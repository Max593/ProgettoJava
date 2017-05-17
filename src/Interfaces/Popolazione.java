package Interfaces;

import People.Femmina;
import People.Maschio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 17/05/17.
 */
public class Popolazione {
    private List<Maschio> maschi = new ArrayList<>();
    private List<Femmina> femmine = new ArrayList<>();

    public void addMale(Maschio m) { maschi.add(m); }
    public void addFemale(Femmina f) { femmine.add(f); }


}
