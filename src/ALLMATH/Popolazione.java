package ALLMATH;

import java.util.*;

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
        stabMM = (A22 - A12) / (A11 - A21 - A12 + A22);
        Scanner scan  = new Scanner(System.in);
        int P = scan.nextInt();
        int S = scan.nextInt();
        int M = scan.nextInt();
        int A = scan.nextInt();
        Generazione gen = new Generazione(P, S, M, A);
        popolazione.put(1, gen);  //1 dato che è sicuramente la prima

    }
    public Popolazione() {  //Valori standard di Dawkins
        this(15, 20, 3);
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
