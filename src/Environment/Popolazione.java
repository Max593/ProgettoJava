package Environment;

import People.Femmina;
import People.Maschio;

import java.util.*;

public class Popolazione {

    private int a;  //Premio generazione figli
    private int b;  //Costo crescere figli
    private int c;  //Costo corteggiamento
    private double Ppay;
    private double Spay;
    private double Mpay;
    private double Apay;
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
            Generazione gen = popolazione.get(nGen);
            List<Maschio> maschi = gen.getListaMaschi();
            List<Femmina> femmine = gen.getListaFemmine();
            for(Maschio m : maschi) {  //Si assegna la generazione e li si lascia correre.

            }
        }

    }

}
