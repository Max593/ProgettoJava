package Incontri;

public class Persona {

    public enum Types {M,A,P,S}
    public enum Genders {FEMALE,MALE}

    private Types type;
    private Genders gender;
    private int age = 0;  //Age e Occupato sono preimpostati, alla nascita hanno 0 anni e non sono occupati
    private boolean occupato = false;
    private double payoff;

    // METODI GETTER
    public Types getType() { return type; }
    public Genders getGender() { return gender; }
    public int getAge() { return age; }
    public boolean getOccupato() { return occupato; }
    public double getPayoff() { return payoff; }

    // METODI SETTER
    public void setType(Types type) { this.type = type; }
    public void setGender(Genders g) { this.gender = g; }
    public void setAge(int a) { this.age = a; }
    public void setOccupato(boolean b) { this.occupato = b; }
    public synchronized void setPayoff(double d) { payoff += d; }


}