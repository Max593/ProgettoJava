package People;

public class Maschio extends Persona implements Runnable{
    private Femmina partner;

    //COSTRUTTORI
    public Maschio(Types type ) {
        setType(type);
        setGender(Genders.MALE);
    }

    //CERCA UNA FEMMINA PER ACCOPPIARSI
    public void cercaFemmina(Femmina femmina){
    }
    public void setPartner(Femmina f) { partner = f; }

    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"GENERE = "+getGender()+" , ANNI = "+getAge()+" , TIPOLOGIA = "+getType()+" , OCCUPATO = "+getOccupato()+" ]";
    }

    //Esecuzione del thread
    @Override
    public void run() {

    }
}
