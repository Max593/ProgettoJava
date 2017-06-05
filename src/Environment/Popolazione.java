package Environment;

import People.Femmina;
import People.Maschio;

import java.util.*;

public class Popolazione {

    private int a;  //Premio generazione figli
    private int b;  //Costo crescere figli
    private int c;  //Costo corteggiamento
    private Generazione gen;
    private Map<Integer, Generazione> popolazione = new HashMap<>();

    public Popolazione(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        costruisciPopolazione();
    }
    public Popolazione() {  //Valori standard di Dawkins
        this(15, 20, 3);
    }

    public void costruisciPopolazione() {
        Scanner scan  = new Scanner(System.in);
        int P = scan.nextInt();
        int S = scan.nextInt();
        int M = scan.nextInt();
        int A = scan.nextInt();
        gen = new Generazione(P, S, M, A);
    }
}
