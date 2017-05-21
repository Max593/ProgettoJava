package Environment;

import People.Femmina;
import People.Maschio;
import People.Persona;
import java.util.ArrayList;
import java.util.List;

public class Generazione {

    private int numeroTipoP;
    private int numeroTipoS;
    private int numeroTipoM;
    private int numeroTipoA;
    private int numeroMaschi = numeroTipoP + numeroTipoS;
    private int numeroFemmine = numeroTipoM + numeroTipoA;
    private int numeroTotale = numeroTipoP + numeroTipoS + numeroTipoM + numeroTipoA;

    private List<Persona> listaGenerazione = new ArrayList<>();

    //METODI COSTRUTTORI
    public  Generazione( int numeroTipoP , int numeroTipoS , int numeroTipoM , int numeroTipoA){

        this.numeroTipoP = numeroTipoP;
        this.numeroTipoS = numeroTipoS;
        this.numeroTipoM = numeroTipoM;
        this.numeroTipoA = numeroTipoA;

        for(int i = 0; i<numeroTipoP; i++) {  listaGenerazione.add(new Maschio(Persona.Types.P)); }
        for(int i = 0; i<numeroTipoS; i++) {  listaGenerazione.add(new Maschio(Persona.Types.S)); }
        for(int i = 0; i<numeroTipoM; i++) {  listaGenerazione.add(new Femmina(Persona.Types.M)); }
        for(int i = 0; i<numeroTipoA; i++) {  listaGenerazione.add(new Femmina(Persona.Types.A)); }
    }

    //METODI GETTER
    public List<Persona> getlistaGenerazione() { return this.listaGenerazione; }
    public int getNumeroTipoP(){return this.numeroTipoP;}
    public int getNumeroTipoS(){return this.numeroTipoS;}
    public int getNumeroTipoM(){return this.numeroTipoM;}
    public int getNumeroTipoA(){return this.numeroTipoA;}
    public int getNumeroMaschi(){return this.numeroMaschi;}
    public int getNumeroFemmine(){return this.numeroFemmine;}
    public int getNumeroTotale(){return this.numeroTotale;}

    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"NUMERO TIPO P = "+numeroTipoP+" , NUMERO TIPO S = "+numeroTipoS+" , NUMERO TIPO M = "+numeroTipoM+" ,NUMERO TIPO A = "+numeroTipoA+" ]";
    }

    public void stampaListaGenerazione () {
        for (Persona p : listaGenerazione) {System.out.println(p.toString());
        }
    }
}