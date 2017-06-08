package Environment;

import People.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Generazione {

    private int numeroTipoP;
    private int numeroTipoS;
    private int numeroTipoM;
    private int numeroTipoA;
    private int numeroMaschi;
    private int numeroFemmine;
    private int numeroTotale;
    private int numeroFigli = 0;

    private List<Maschio> listaMaschi = new ArrayList<>();
    private List<Femmina> listaFemmine = new ArrayList<>();

    //METODI COSTRUTTORI
    public  Generazione( int numeroTipoP , int numeroTipoS , int numeroTipoM , int numeroTipoA){

        this.numeroTipoP = numeroTipoP;
        this.numeroTipoS = numeroTipoS;
        this.numeroTipoM = numeroTipoM;
        this.numeroTipoA = numeroTipoA;
        this.numeroMaschi = numeroTipoM + numeroTipoA;
        this.numeroFemmine = numeroTipoP + numeroTipoS;
        this.numeroTotale = numeroTipoP + numeroTipoS + numeroTipoM + numeroTipoA;

        for(int i = 0; i<numeroTipoP; i++) { listaFemmine.add(new Femmina(Persona.Types.P)); }
        for(int i = 0; i<numeroTipoS; i++) { listaFemmine.add(new Femmina(Persona.Types.S)); }
        for(int i = 0; i<numeroTipoM; i++) { listaMaschi.add(new Maschio(Persona.Types.M)); }
        for(int i = 0; i<numeroTipoA; i++) { listaMaschi.add(new Maschio(Persona.Types.A)); }

        long rand = System.nanoTime()+1;  //Vengono mischiati per semplificare la randomicità di selezione
        Collections.shuffle(listaMaschi, new Random(rand));
        rand = System.nanoTime()-1;
        Collections.shuffle(listaFemmine, new Random(rand));
    }


    //METODI GETTER
    public List<Maschio> getListaMaschi() { return this.listaMaschi; }
    public synchronized List<Femmina> getListaFemmine() { return this.listaFemmine; }
    public int getNumeroTipoP() {return this.numeroTipoP;}
    public int getNumeroTipoS() {return this.numeroTipoS;}
    public int getNumeroTipoM() {return this.numeroTipoM;}
    public int getNumeroTipoA() {return this.numeroTipoA;}
    public int getNumeroMaschi() {return this.numeroMaschi;}
    public int getNumeroFemmine() {return this.numeroFemmine;}
    public int getNumeroTotale() {return this.numeroTotale;}
    public synchronized int getNumeroFigli() {return this.numeroFigli;}

    //METODI SETTER

    public synchronized void setNumeroFigli(int n) { numeroFigli += n; }

    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"NUMERO TIPO P = "+numeroTipoP+" , NUMERO TIPO S = "+numeroTipoS+" , NUMERO TIPO M = "+numeroTipoM+" ,NUMERO TIPO A = "+numeroTipoA+" ]";
    }
}
