package People;

import java.util.ArrayList;
import java.util.List;

public class Femmina extends Persona implements Runnable{
    private List<Persona> listaFigli = new ArrayList<>();
    private List<Maschio> oldPartner = new ArrayList<>();  //Partner (A) passati per evitare che si incontrino nuovamente

    //COSTRUTTORI
    public Femmina(Types type) {
        setType(type);
        setGender(Genders.FEMALE);
    }
    // METODI GETTER
    public List<Persona> getListaFigli() { return listaFigli; }
    public List<Maschio> getOldPartner() { return oldPartner; }

    // AGGIUNGI FIGLIO IN LISTA FIGLI
    public void nasceFiglio(Persona figlio){
        listaFigli.add(figlio);
    }
    public void addPartner(Maschio m) { oldPartner.add(m); }

    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"GENERE = "+getGender()+" , ANNI = "+getAge()+" , TIPOLOGIA = "+getType()+" , OCCUPATO = "+getOccupato()+" ]";
    }

    //Esecuzione del thread
    @Override
    public void run() {

    }
}