import java.util.ArrayList;
import java.util.List;

public class Femmina extends Persona{
    private List<Maschio> oldPartner = new ArrayList<>();  //Partner (A) passati per evitare che si incontrino nuovamente
    private boolean impegnata = false;

    //COSTRUTTORI
    public Femmina(Types type) {
        setType(type);
        setGender(Genders.FEMALE);
    }
    // METODI GETTER
    public List<Maschio> getOldPartner() { return oldPartner; }
    public synchronized boolean isImpegnata() { return impegnata; }

    // AGGIUNGI FIGLIO IN LISTA FIGLI
    public void addPartner(Maschio m) { oldPartner.add(m); }
    public synchronized void setImpegnata(boolean b) { impegnata = b; }

    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"GENERE = "+getGender()+" , ANNI = "+getAge()+" , TIPOLOGIA = "+getType()+" , OCCUPATO = "+getOccupato()+" ]";
    }
}