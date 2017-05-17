package People;

import Interfaces.Persona;

/**
 * Created by max on 17/05/17.
 */
public class Maschio extends Persona {
    //private int cort;  //Tempo dedicato al corteggiamento
    public Maschio(Type t) {
        setGender(Genders.MALE);
        setType(t);
    }
}
