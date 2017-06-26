package Incontri;

import java.util.ArrayList;
import java.util.List;

public class Femmina extends Persona{
    private List<Maschio> oldPartner = new ArrayList<>();  //Partner (A) passati per evitare che si incontrino nuovamente

    //COSTRUTTORI
    public Femmina(Types type) {
        setType(type);
        setGender(Genders.FEMALE);
    }
    // METODI GETTER
    public List<Maschio> getOldPartner() { return oldPartner; }

    public void addPartner(Maschio m) { oldPartner.add(m); }

    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"GENERE = "+getGender()+" , ANNI = "+getAge()+" , TIPOLOGIA = "+getType()+" , OCCUPATO = "+getOccupato()+" ]";
    }
}