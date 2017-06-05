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
    //private Generazione gen;
    private Map<Integer, Generazione> popolazione = new HashMap<>();

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
        popolazione.put(gen.getNumeroGenerazione(), gen);
    }

    /*
    public void nextGeneration() {
        int key = 1;

        Generazione gen = popolazione.get(key);
        List<Maschio> maschi = gen.getListaMaschi();
        List<Femmina> femmine = gen.getListaFemmine();
    }
*/

}
