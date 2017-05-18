package People;

/**
 * Created by max on 17/05/17.
 */
public class Persona {
    public enum Genders {MALE, FEMALE}
    public enum Type {M, A, P, S}

    private Genders gender;
    private Type type;
    private int age = 0;
    private boolean occupato = false;

    public Genders getGender() { return gender; }
    public Type getType() { return type; }
    public int getAge() { return age; }
    public boolean getOccupato() { return occupato; }

    public void setGender(Genders g) { gender = g; }
    public void setType(Type t) { type = t; }
    public void setOccupato(boolean b) { occupato = b; }

    public String toString() {  //Per identificazione semplificata
        return gender+" "+age+" "+type+" "+occupato;
    }
}
