package People;

import Exceptions.WrongTypeException;

/**
 * Created by max on 17/05/17.
 */
public class Femmina extends Persona {

    public Femmina(Type t) throws WrongTypeException {
        if(t.equals(Type.M) || t.equals(Type.A)) { throw new WrongTypeException(); }
        setGender(Genders.FEMALE);
        setType(t);
    }
}
