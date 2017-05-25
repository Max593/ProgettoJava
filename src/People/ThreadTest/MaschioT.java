package People.ThreadTest;

public class MaschioT extends PersonaT implements Runnable{

    //COSTRUTTORI
    public MaschioT(Types type ) {
        setType(type);
        setGender(Genders.MALE);
    }

    //CERCA UNA FEMMINA PER ACCOPPIARSI
    public void cercaFemmina(FemminaT femmina){
        if ((femmina.getType() == Types.P) && (getType() == Types.M)){
            System.out.println(" FEMMINA TIPO = P , MASCHIO TIPO M");
        } else if((femmina.getType() == Types.P) && (getType() == Types.A)) {
            System.out.println(" FEMMINA TIPO = P , MASCHIO TIPO A");
        } else if((femmina.getType() == Types.S) && (getType() == Types.M)) {
            System.out.println(" FEMMINA TIPO = S , MASCHIO TIPO M");
        }else if((femmina.getType() == Types.S) && (getType() == Types.A)) {
            System.out.println(" FEMMINA TIPO = S , MASCHIO TIPO A");
        }
    }

    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"GENERE = "+getGender()+" , ANNI = "+getAge()+" , TIPOLOGIA = "+getType()+" , OCCUPATO = "+getOccupato()+" ]";
    }

    //Esecuzione del thread
    @Override
    public void run() {

    }
}
