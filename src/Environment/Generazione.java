package Environment;

public class Generazione {

    private double numeroTipoP;
    private double numeroTipoS;
    private double numeroTipoM;
    private double numeroTipoA;
    private double numeroMaschi;
    private double numeroFemmine;
    private double numeroTotale;

    //METODI COSTRUTTORI
    public  Generazione( double numeroTipoM , double numeroTipoA , double numeroTipoP , double numeroTipoS){

        this.numeroTipoP = numeroTipoP;
        this.numeroTipoS = numeroTipoS;
        this.numeroTipoM = numeroTipoM;
        this.numeroTipoA = numeroTipoA;
        this.numeroMaschi = numeroTipoM + numeroTipoA;
        this.numeroFemmine = numeroTipoP + numeroTipoS;
        this.numeroTotale = numeroMaschi + numeroFemmine;
    }


    //METODI GETTER
    public double getNumeroTipoP() {return this.numeroTipoP;}
    public double getNumeroTipoS() {return this.numeroTipoS;}
    public double getNumeroTipoM() {return this.numeroTipoM;}
    public double getNumeroTipoA() {return this.numeroTipoA;}
    public double getNumeroMaschi() {return this.numeroMaschi;}
    public double getNumeroFemmine() {return this.numeroFemmine;}
    public double getNumeroTotale() {return this.numeroTotale;}

    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"NUMERO TIPO M = "+numeroTipoM+" ," +
                " NUMERO TIPO A = "+numeroTipoA+" , NUMERO TIPO P = "+numeroTipoP+" ,NUMERO TIPO S = "+numeroTipoS+" ]";
    }
}