package Environment;

import Exceptions.WrongTypeException;
import People.Femmina;
import People.Maschio;
import People.Persona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by max on 17/05/17.
 */
public class Popolazione {
    private List<Maschio> maschi = new ArrayList<>();
    private List<Femmina> femmine = new ArrayList<>();
    private Map<Integer, List<List<Persona>>> generazioni = new HashMap<>();  //List<List<Persona> [0]maschi [1]femmine

    public void addAmount(int m, int a, int p, int s) {  //Per iniziare una popolazione in base a parametri numerici
        try{
            for(int i = 0; i<m; i++) { maschi.add(new Maschio(Persona.Type.M)); }
            for(int i = 0; i<a; i++) { maschi.add(new Maschio(Persona.Type.A)); }
            for(int i = 0; i<p; i++) { femmine.add(new Femmina(Persona.Type.P)); }
            for(int i = 0; i<s; i++) { femmine.add(new Femmina(Persona.Type.S)); }
        } catch (WrongTypeException ignore) {}
    }

    public void addToGen(int g, List<Maschio> m, List<Femmina> f) {  //Incompleto
        if(!generazioni.containsKey(g) ) {
            generazioni.put(g, new ArrayList<>());
            generazioni.get(g).add(new ArrayList<>(m));
            generazioni.get(g).add(new ArrayList<>(f));
        }
    }

    public List<Maschio> getMaschi() { return maschi; }
    public List<Femmina> getFemmine() { return femmine; }
    public List<List<Persona>> getGenerazioni(int i) { return generazioni.get(i); }

}
