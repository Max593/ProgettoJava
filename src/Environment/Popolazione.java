package Environment;

import People.Femmina;
import People.Maschio;
import People.Persona;


import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class Popolazione {

    private int a;  //Premio generazione figli
    private int b;  //Costo crescere figli
    private int c;  //Costo corteggiamento
    private Random rand;

    private Map<Integer, Generazione> popolazione = new HashMap<>();  //Record di ogni generazione passata, numerata con la chiave

    public Popolazione(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Popolazione() {  //Valori standard di Dawkins
        this(15, 20, 3);
    }

    public void costruisciPopolazione() {  //Costruttore iniziale
        Scanner scan  = new Scanner(System.in);
        int P = scan.nextInt();
        int S = scan.nextInt();
        int M = scan.nextInt();
        int A = scan.nextInt();
        Generazione gen = new Generazione(P, S, M, A);
        popolazione.put(1, gen);  //1 dato che è sicuramente la prima
    }

    public void popGrowth() {
        int nGen = 1;  //Primissima generazione sicuramente la 1
        while(nGen <= 2000) {
            System.out.println(nGen);
            Generazione gen = popolazione.get(nGen);
            System.out.println(popolazione.get(nGen));
            List<Femmina> femmine = gen.getListaFemmine();  //Dovrebbe attivarsi il synchronized già da questo accesso
            Function<List<Femmina>, Femmina> randPartnerPicker = l -> {  //Cerca la prima femmina non occupata che può trovare
                int index = new Random().nextInt(femmine.size());  //Valore random
                Femmina female = femmine.get(index);  //Recupera una femmina random
                while(female.isImpegnata()) {
                    index = new Random().nextInt(femmine.size());  //Nuovo valore random
                    female = femmine.get(index);  //Recupera una nuova femmina random
                }
                female.setImpegnata(true);
                return female;
            };

            ExecutorService service = Executors.newCachedThreadPool();
            for(Maschio m : gen.getListaMaschi()) {
                Thread t = new Thread() {
                    private Femmina partner;
                    public void run() {
                        partner = randPartnerPicker.apply(femmine);
                        while(partner.isImpegnata()) { partner = randPartnerPicker.apply(femmine); }
                        if(m.getType() == Persona.Types.M) {
                            if(partner.getType() == Persona.Types.S) {  //M incontra S
                                m.setPayoff(a - (b/2));
                                partner.setPayoff(a - (b/2));
                                gen.setNumeroFigli(1);
                            }
                            else {
                                m.setPayoff(a - (b/2) - c);
                                partner.setPayoff(a - (b/2) - c);
                                gen.setNumeroFigli(1);
                            }
                        }
                        else {
                            for(int i = 0; i < 20; i++ ) {
                                if(partner.getType() == Persona.Types.P) {
                                    m.setPayoff(0);
                                    partner.setPayoff(0);
                                    partner.setImpegnata(false);
                                }

                                else {
                                    m.setPayoff(a);
                                    partner.setPayoff(a-b);
                                    gen.setNumeroFigli(1);
                                    partner.setImpegnata(false);
                                }
                            }
                        }

                    }
                };
                service.execute(t);
            }
            service.shutdown();
            while(!service.isTerminated()) {}  //Fa schifo

            int countP = 0;
            int countS = 0;
            int countM = 0;
            int countA = 0;

            Double Mpay = 0.0;
            Double Apay = 0.0;
            for(Maschio m : gen.getListaMaschi()) {
                if(m.getType() == Persona.Types.M) { Mpay += m.getPayoff(); }
                else { Apay += m.getPayoff(); }
            }

            Double Ppay = 0.0;
            Double Spay = 0.0;
            for(Femmina f : gen.getListaFemmine()) {
                if(f.getType() == Persona.Types.P) { Ppay += f.getPayoff(); }
                else { Spay += f.getPayoff(); }
            }

            for(int i = 0; i < gen.getNumeroFigli(); i++) {
                boolean b = rand.nextBoolean();
                if(b) {  //Se maschio
                    int totPay = (Mpay.intValue() + Apay.intValue());
                    if(rand.nextInt(totPay) <= Mpay) { countM += 1; }
                    else { countA += 1; }
                }
                else {  //Se femmina
                    int totPay = (Ppay.intValue() + Spay.intValue());
                    if(rand.nextInt(totPay) <= Ppay) { countP += 1; }
                    else { countS += 1; }
                }
            }

            nGen += 1;
            popolazione.put(nGen, new Generazione(countP, countS, countM, countA));
        }

    }

}
