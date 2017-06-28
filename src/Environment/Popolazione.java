package Environment;

import java.util.*;

public class Popolazione {

    private double a;  //Premio generazione figli
    private double b;  //Costo crescere figli
    private double c;  //Costo corteggiamento
    private double stabMM;  //Percentuale di stabilit� maschi M
    private double stabFP;  //Percentuale di stabilit� femmine P
    private double A11;
    private double A12;
    private double A21;
    private double A22;
    private double B11;
    private double B12;
    private double B21;
    private double B22;
    private String strategia_M_A = "";
    private String strategia_P_S = "";
    

    private Map<Integer, Generazione> popolazione = new HashMap<>();  //Record di ogni generazione passata, numerata con la chiave

    public Popolazione(int a, int b, int c, int M, int A, int P, int S) throws ArithmeticException {
        System.out.println("INSERIRE VALORI A , B , C");
        this.a = ((double)a);
        this.b = ((double)b);
        this.c = ((double)c);
        this.A11 = a - b/2 - c;
        this.A12 = a - b/2;
        this.A21 = 0;
        this.A22 = a;
        this.B11 = a - b/2 - c;
        this.B12 = 0;
        this.B21 = a - b/2;
        this.B22 = a - b;
        if(((A22 - A12) / (A11 - A21 - A12 + A22)<=0 )  || ((A22 - A12) / (A11 - A21 - A12 + A22)>=1 )
                ||((B22 - B12) / (B11 - B21 - B12 + B22)<=0 )  || ((B22 - B12) / (B11 - B21 - B12 + B22)>=1 )) { throw new IllegalArgumentException(); }
        /*
        try{
        	if(((A22 - A12) / (A11 - A21 - A12 + A22)<=0 )  || ((A22 - A12) / (A11 - A21 - A12 + A22)>=1 )
                    ||((B22 - B12) / (B11 - B21 - B12 + B22)<=0 )  || ((B22 - B12) / (B11 - B21 - B12 + B22)>=1 )   ) throw new ArithmeticException();
        }catch (ArithmeticException e) {
					while(((A22 - A12) / (A11 - A21 - A12 + A22)<=0 )  || ((A22 - A12) / (A11 - A21 - A12 + A22)>=1 )
                            ||((B22 - B12) / (B11 - B21 - B12 + B22)<=0 )  || ((B22 - B12) / (B11 - B21 - B12 + B22)>=1 ) ){
						System.out.println("VALORI NON AMMESSI........");
						Scanner scan2  = new Scanner(System.in);
					    System.out.println("INSERIRE VALORI A , B , C");
					    this.a = scan2.nextInt();
					    this.b = scan2.nextInt();
					    this.c = scan2.nextInt();
					    this.A11 = a - b/2 - c;
					    this.A12 = a - b/2;
					    this.A21 = 0;
					    this.A22 = a;
					    this.B11 = a - b/2 - c;
					    this.B12 = 0;
					    this.B21 = a - b/2;
					    this.B22 = a - b;
					}

		}*/
        stabFP = (A22 - A12) / (A11 - A21 - A12 + A22);
        stabMM = (B22 - B12) / (B11 - B21 - B12 + B22);
        System.out.println("PERCENTUALE DI STABILITA P = "+stabFP);
        System.out.println("PERCENTUALE DI STABILITA M = "+stabMM);
        Generazione gen = new Generazione(M, A, P, S);
        testStrategia(gen);
        popolazione.put(1, gen);  //1 dato che è sicuramente la prima
        popGrowth();

    }

    public void popGrowth() {
        int nGen = 1;
        int counter = 0;
        while(counter <= 50) {
            Generazione gen = popolazione.get(nGen);
            System.out.println(gen);
            System.out.println("PERCENTUALE DI STABILITA P = "+stabFP);
            System.out.println("PERCENTUALE DI STABILITA M = "+stabMM);
            double numFemmine = gen.getNumeroFemmine();
            double numMaschi = gen.getNumeroMaschi();
            double numMM = gen.getNumeroTipoM();
            double numMA = gen.getNumeroTipoA();
            double numFP = gen.getNumeroTipoP();
            double numFS = gen.getNumeroTipoS();
            
            double Wm = a + (numMM/numMaschi)*B11 + (numMA/numMaschi)*B12;
            double Wa = a + (numMM/numMaschi)*B21 + (numMA/numMaschi)*B22;
            double Wp = a + (numFP/numFemmine)*A11 + (numFS/numFemmine)*A12;
            double Ws = a + (numFP/numFemmine)*A21 + (numFS/numFemmine)*A22;
            double Wu = (numMM/numMaschi)*Wm + (numMA/numMaschi)*Wa;
            double Wd = (numFP/numFemmine)*Wp + (numFS/numFemmine)*Ws;

            double incM = 0.0;
            double incA = 0.0;
            double incP = 0.0;
            double incS = 0.0;
            
            if(strategia_M_A.equals("uno")){
                incM = (numMM/numMaschi)*((Wm-Wu)/Wu);
                incA = (numMA/numMaschi)*((Wa-Wu)/Wu);
            }else{
                incM = -1*((numMM/numMaschi)*((Wm-Wu)/Wu));
                incA = -1*((numMA/numMaschi)*((Wa-Wu)/Wu));
            }
            
            if(strategia_P_S.equals("uno")){
                incP = (numFP/numFemmine)*((Wp-Wd)/Wd);
                incS = (numFS/numFemmine)*((Ws-Wd)/Wd);
            }else{
                incP = -1*((numFP/numFemmine)*((Wp-Wd)/Wd));
                incS = -1*((numFS/numFemmine)*((Ws-Wd)/Wd));
            }

            Double newM = numMM + numMM * incM;
            Double newA = numMA + numMA * incA;
            Double newP = numFP + numFP * incP;
            Double newS = numFS + numFS * incS;

            nGen += 1;
            popolazione.put(nGen, new Generazione(newM, newA, newP, newS));

            if(stabMM-0.01<numMM/numMaschi || numMM/numMaschi<stabMM+0.01 &&
                    stabFP-0.01<numFP/numFemmine || numFP<stabFP+0.01) { counter += 1; }
        }
    }

    public void popGrowthIncontri() {  //Nel caso introduciamo gli incontri

    }
    
    public void testStrategia(Generazione gen) {

            double numFemmine = gen.getNumeroFemmine();
            double numMaschi = gen.getNumeroMaschi();
            double numMM = gen.getNumeroTipoM();
            double numMA = gen.getNumeroTipoA();
            double numFP = gen.getNumeroTipoP();
            double numFS = gen.getNumeroTipoS();
               
            double Wm = a + (numMM/numMaschi)*B11 + (numMA/numMaschi)*B12;
            double Wa = a + (numMM/numMaschi)*B21 + (numMA/numMaschi)*B22;
            double Wp = a + (numFP/numFemmine)*A11 + (numFS/numFemmine)*A12;
            double Ws = a + (numFP/numFemmine)*A21 + (numFS/numFemmine)*A22;
            
            double Wu = (numMM/numMaschi)*Wm + (numMA/numMaschi)*Wa;
            double Wd = (numFP/numFemmine)*Wp + (numFS/numFemmine)*Ws;
            
            double passato_M_A = Math.abs(Wm-Wu)+Math.abs(Wa-Wu);
            double passato_P_S = Math.abs(Wp-Wd)+Math.abs(Ws-Wd);
           
            double incM = (numMM/numMaschi)*((Wm-Wu)/Wu);
            double incA = (numMA/numMaschi)*((Wa-Wu)/Wu);
            double incP = (numFP/numFemmine)*((Wp-Wd)/Wd);
            double incS = (numFS/numFemmine)*((Ws-Wd)/Wd);

            double numMM2 = numMM + numMM * incM;
            double numMA2 = numMA + numMA * incA;
            double numFP2 = numFP + numFP * incP;
            double numFS2 = numFS + numFS * incS;
            double numFemmine2 =  numFP2 + numFS2;
            double numMaschi2 = numMM2 + numMA2 ;
            
            double Wm2 = a + (numMM2/numMaschi2)*B11 + (numMA2/numMaschi2)*B12;
            double Wa2 = a + (numMM2/numMaschi2)*B21 + (numMA2/numMaschi2)*B22;
            double Wp2 = a + (numFP2/numFemmine2)*A11 + (numFS2/numFemmine2)*A12;
            double Ws2 = a + (numFP2/numFemmine2)*A21 + (numFS2/numFemmine2)*A22;
            
            double Wu2 = (numMM2/numMaschi2)*Wm2 + (numMA2/numMaschi2)*Wa2;
            double Wd2 = (numFP2/numFemmine2)*Wp2 + (numFS2/numFemmine2)*Ws2;
            
            double attuale_M_A = Math.abs(Wm2-Wu2)+Math.abs(Wa2-Wu2);
            double attuale_P_S = Math.abs(Wp2-Wd2)+Math.abs(Ws2-Wd2);
            
            if(attuale_M_A < passato_M_A){
            	this.strategia_M_A = "uno";
            	
            }else{
            	this.strategia_M_A = "due";
            }
           
            if(attuale_P_S < passato_P_S){
            	this.strategia_P_S = "uno";
            	
            }else{
            	this.strategia_P_S = "due";
            }

    }

    public Map<Integer, Generazione> getMap() { return popolazione; }

}