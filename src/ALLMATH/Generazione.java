package ALLMATH;

public class Generazione {

    private int numeroTipoP;
    private int numeroTipoS;
    private int numeroTipoM;
    private int numeroTipoA;
    private int numeroMaschi;
    private int numeroFemmine;
    private int numeroTotale;

    //METODI COSTRUTTORI
    public  Generazione( int numeroTipoP , int numeroTipoS , int numeroTipoM , int numeroTipoA){

        this.numeroTipoP = numeroTipoP;
        this.numeroTipoS = numeroTipoS;
        this.numeroTipoM = numeroTipoM;
        this.numeroTipoA = numeroTipoA;
        this.numeroMaschi = numeroTipoM + numeroTipoA;
        this.numeroFemmine = numeroTipoP + numeroTipoS;
        this.numeroTotale = numeroMaschi + numeroFemmine;
    }


    //METODI GETTER
    public int getNumeroTipoP() {return this.numeroTipoP;}
    public int getNumeroTipoS() {return this.numeroTipoS;}
    public int getNumeroTipoM() {return this.numeroTipoM;}
    public int getNumeroTipoA() {return this.numeroTipoA;}
    public int getNumeroMaschi() {return this.numeroMaschi;}
    public int getNumeroFemmine() {return this.numeroFemmine;}
    public int getNumeroTotale() {return this.numeroTotale;}

    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"NUMERO TIPO P = "+numeroTipoP+" , NUMERO TIPO S = "+numeroTipoS+" , NUMERO TIPO M = "+numeroTipoM+" ,NUMERO TIPO A = "+numeroTipoA+" ]";
    }
}