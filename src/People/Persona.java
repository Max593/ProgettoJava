package People;


public interface Persona{

    enum Types {P,S,M,A}
    enum Genders {FEMALE,MALE}

    // METODI GETTER
    Types getType();
    Genders getGender();
    int getAge();
    boolean getOccupato( );

    // METODI SETTER
    void setType( Types type);
    void setAge(int a);
    void setOccupato(boolean b) ;

}

