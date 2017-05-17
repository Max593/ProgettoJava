package Interfaces;

import People.Femmina;
import People.Maschio;

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
    private Map<Integer, List<List>> generazioni = new HashMap<>();  //List<List> [0]maschi [1]femmine
/*
    public void addMale(Maschio m) { maschi.add(m); }
    public void addFemale(Femmina f) { femmine.add(f); }
    public void addAllMale(List<Maschio> lm) { maschi = lm; }
    public void addAllFemale(List<Femmina> lf) { femmine = lf; }
    public void addPopulation(List<Persona> lp) {
        for(Persona p : lp) {
            if(p.getGender() == Persona.Genders.MALE) { maschi.add((Maschio) p); }
            else { femmine.add((Femmina) p); }
        }
    }
*/
    public void addAll2(int m, int a, int p, int s) {
        for(int i = 0; i<m; i++) { maschi.add(new Maschio(Persona.Type.M)); }
        for(int i = 0; i<a; i++) { maschi.add(new Maschio(Persona.Type.A)); }
        for(int i = 0; i<p; i++) { femmine.add(new Femmina(Persona.Type.P)); }
        for(int i = 0; i<s; i++) { femmine.add(new Femmina(Persona.Type.S)); }
    }

    public void add3(int g, List<Maschio> m, List<Femmina> f) {
        if(!generazioni.containsKey(g) ) { generazioni.put(1, new ArrayList<>()); }
        generazioni.get(g).add(m);
        generazioni.get(g).add(f);
    }

    public List<Maschio> getMaschi() { return maschi; }
    public List<Femmina> getFemmine() { return femmine; }
    public List<List> getGenerazioni(int i) { return generazioni.get(i); }

    public Popolazione() {}


}
