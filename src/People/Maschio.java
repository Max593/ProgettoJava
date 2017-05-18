package People;

import Exceptions.WrongTypeException;

/**
 * Created by max on 17/05/17.
 */
public class Maschio extends Persona {

    public Maschio(Type t) throws WrongTypeException {
        if(t.equals(Type.P) || t.equals(Type.S)) { throw new WrongTypeException(); }
        setGender(Genders.MALE);
        setType(t);
    }
}
