package Environment;

import People.Femmina;
import People.Maschio;
import People.Persona;


import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class Popolazione {

    private double a;  //Premio generazione figli
    private double b;  //Costo crescere figli
    private double c;  //Costo corteggiamento
    private double stabMM;  //Percentuale di stabilità maschi M
    private double stabFP;  //Percentuale di stabilità femmine P
    private double A11;
    private double A12;
    private double A21;
    private double A22;
    private double B11;
    private double B12;
    private double B21;
    private double B22;

    private Map<Integer, Generazione> popolazione = new HashMap<>();  //Record di ogni generazione passata, numerata con la chiave

    public Popolazione(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        A11 = a - b/2 - c;
        A12 = a - b/2;
        A21 = 0;
        A22 = a;
        B11 = a - b/2 - c;
        B12 = 0;
        B21 = a - b/2;
        B22 = a - b;
        stabFP = (B22 - B12) / (B11 - B21 - B12 + B22);
        stabMM = (A22-A12) / (A11 - A21 - A12 + A22);
        costruisciPopolazione();

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
        while(nGen <= 2000) {  //Numero cicli da diminuire
            Generazione gen = popolazione.get(nGen);
            System.out.println(nGen);
            System.out.println(popolazione.get(nGen));
            List<Femmina> femmine = gen.getListaFemmine();  //Dovrebbe attivarsi il synchronized già da questo accesso

            /*
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
                        //while(partner.isImpegnata()) { partner = randPartnerPicker.apply(femmine); System.out.println("Partner trovato"); }
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
                boolean b = new Random().nextBoolean();
                if(b) {  //Se maschio
                    int totPay = (Mpay.intValue() + Apay.intValue());
                    if(new Random().nextInt(totPay) <= Mpay) { countM += 1; }
                    else { countA += 1; }
                }
                else {  //Se femmina
                    int totPay = (Ppay.intValue() + Spay.intValue());
                    if(totPay < 0) {
                        if(new Random().nextInt(Math.abs(totPay)) >= Ppay) { countP += 1; }
                        else { countS += 1; }
                    }
                    else if(new Random().nextInt(totPay) <= Ppay) { countP += 1; }
                    else { countS += 1; }
                }
            }
*/
            //FORMULE PAYOFF UOMINI
            double PayoffMP = a - (b/2) - c;
            double PayoffMS = a - (b/2);
            double PayoffAP = 0;
            double PayoffAS = a;

            //FORMULE PAYOFF DONNE
            double PayoffPM = a - (b/2) - c;
            double PayoffPA = 0;
            double PayoffSM = a - (b/2);
            double PayoffSA = a-b;



            //PROPORZIONE DEI TIPI RISPETTO AL SESSO
            double PropP = ((double) gen.getNumeroTipoP()) / gen.getNumeroFemmine();  //PROBLEMA: esce 0 invece della divisione corretta
            double PropS = 1 - PropP;
            double PropM = ((double) gen.getNumeroTipoM()) / gen.getNumeroMaschi();
            double PropA = 1 - PropM;

            //PAYOFF MEDI DEI SESSI
            double AvgMalePayoff = (PayoffMP*PropM*PropP) + (PayoffMS*PropM*PropS) + (PayoffAP*PropA*PropP) + (PayoffAS*PropA*PropS);
            double AvgFemalePayoff = (PayoffPM*PropM*PropP) + (PayoffPA*PropP*PropA) + (PayoffSM*PropS*PropM) + (PayoffSA*PropA*PropS);

            //RATEO DI CRESCITA DI UN TIPO
            double RateP = PropP*(((PayoffPM*PropM) + (PayoffPA*PropA)) - AvgFemalePayoff);
            double RateS = PropS*(((PayoffSM*PropM) + (PayoffSA*PropA)) - AvgFemalePayoff);
            double RateM = PropM*(((PayoffMP*PropP) + (PayoffMS*PropS)) - AvgMalePayoff);
            double RateA = PropA*(((PayoffAP*PropP) + (PayoffAS*PropS)) - AvgMalePayoff);

            //NUMERI FINALI

            Double GrowthRateP = gen.getNumeroTipoP() + gen.getNumeroTipoP()*RateP;
            Double GrowthRateS = gen.getNumeroTipoS() + gen.getNumeroTipoS()*RateS;
            Double GrowthRateM = gen.getNumeroTipoM() + gen.getNumeroTipoM()*RateM;
            Double GrowthRateA = gen.getNumeroTipoA() + gen.getNumeroTipoA()*RateA;


            nGen += 1;
            popolazione.put(nGen, new Generazione(GrowthRateP.intValue(), GrowthRateS.intValue(), GrowthRateM.intValue(), GrowthRateA.intValue()));
        }

    }
    public void popGrowth2() {
        int nGen = 1;
        while(nGen < 2000) {
            Generazione gen = popolazione.get(nGen);
            System.out.println(gen);
            double numFemmine = gen.getNumeroFemmine();
            double numMaschi = gen.getNumeroMaschi();
            double numMM = gen.getNumeroTipoM();
            double numMA = gen.getNumeroTipoA();
            double numFP = gen.getNumeroTipoP();
            double numFS = gen.getNumeroTipoS();
            double Wm = a + (numMM/numMaschi)*A11 + (numMA/numMaschi)*A12;
            double Wa = a + (numMM/numMaschi)*A21 + (numMA/numMaschi)*A22;
            double Wp = a + (numFP/numFemmine)*B11 + (numFS/numFemmine)*B12;
            double Ws = a + (numFP/numFemmine)*B21 + (numFS/numFemmine)*B22;
            double Wu = (numMM/numMaschi)*Wm + (numMA/numMaschi)*Wa;
            double Wd = (numFP/numFemmine)*Wp + (numFS/numFemmine)*Ws;
            double incM = (numMM/numMaschi)*((Wm-Wu)/Wu);
            double incA = (numMA/numMaschi)*((Wa-Wu)/Wu);
            double incP = (numFP/numFemmine)*((Wp-Wd)/Wd);
            double incS = (numFS/numFemmine)*((Ws-Wd)/Wd);

            Double newM = numMM + numMM * incM;
            Double newA = numMA + numMA * incA;
            Double newP = numFP + numFP * incP;
            Double newS = numFS + numFS * incS;

            nGen += 1;
            popolazione.put(nGen, new Generazione(newP.intValue(), newS.intValue(), newM.intValue(), newA.intValue()));
        }
    }

}
