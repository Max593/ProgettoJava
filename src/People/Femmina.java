package People;

import java.util.ArrayList;
import java.util.List;

public class Femmina implements Persona {

    private Types type;
    private Genders gender;
    private int age;
    private boolean occupato;

    private List<Persona> listaFigli = new ArrayList<>();

    //COSTRUTTORI
    public Femmina( Types type) {
        this.type = type;
        this.gender = Genders.FEMALE;
        this.age = 0;
        this.occupato = false;
    }
    // METODI GETTER
    public  Types getType( ){ return type ;}
    public  Genders getGender(){ return gender ;}
    public  int getAge(){return age;};
    public  boolean getOccupato( ){ return occupato;}
    public List<Persona> getListaFigli(){return listaFigli;}

    // METODI SETTER
    public  void setType( Types type ){ this.type = type;}
    public  void setAge(int age ){ this.age = age;}
    public  void setOccupato(boolean occupato) {this.occupato = occupato;}

    // AGGIUNGI FIGLIO IN LISTA FIGLI
    public void nasceFiglio(Persona figlio){
        listaFigli.add(figlio);
    }

    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"GENERE = "+gender+" , ANNI = "+age+" , TIPOLOGIA = "+type+" , OCCUPATO = "+occupato+" ]";
    }
}