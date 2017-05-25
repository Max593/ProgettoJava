package People.ThreadTest;

import java.util.ArrayList;
import java.util.List;

public class FemminaT extends PersonaT implements Runnable{
    private List<PersonaT> listaFigli = new ArrayList<>();

    //COSTRUTTORI
    public FemminaT(Types type) {
        setType(type);
        setGender(Genders.FEMALE);
    }
    // METODI GETTER
    public List<PersonaT> getListaFigli() { return listaFigli; }

    // AGGIUNGI FIGLIO IN LISTA FIGLI
    public void nasceFiglio(PersonaT figlio){
        listaFigli.add(figlio);
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