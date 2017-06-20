public class Maschio extends Persona {

    //COSTRUTTORI
    public Maschio(Persona.Types type) {
        setType(type);
        setGender(Persona.Genders.MALE);
    }

    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"GENERE = "+getGender()+" , ANNI = "+getAge()+" , TIPOLOGIA = "+getType()+" , OCCUPATO = "+getOccupato()+" ]";
    }
}