package People.ThreadTest;


public class PersonaT {

    enum Types {P,S,M,A}
    enum Genders {FEMALE,MALE}

    private Types type;
    private Genders gender;
    private int age = 0;  //Age e Occupato sono preimpostati, alla nascita hanno 0 anni e non sono occupati
    private boolean occupato = false;

    // METODI GETTER
    public Types getType() { return type; }
    public Genders getGender() { return gender; }
    public int getAge() { return age; }
    public boolean getOccupato() { return occupato; }

    // METODI SETTER
    public void setType(Types type) { this.type = type; }
    public void setGender(Genders g) { this.gender = g; }
    public void setAge(int a) { this.age = a; }
    public void setOccupato(boolean b) { this.occupato = b; }

}

