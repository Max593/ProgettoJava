package People;

public class Maschio implements Persona {

    private Types type;
    private Genders gender;
    private int age;
    private boolean occupato;

    //COSTRUTTORI
    public Maschio( Types type ) {
        this.type = type;
        this.gender = Genders.MALE;
        this.age = 0;
        this.occupato = false;
    }
    // METODI GETTER
    public  Types getType( ){ return type ;}
    public  Genders getGender(){ return gender ;}
    public  int getAge(){return age;};
    public  boolean getOccupato( ){ return occupato;}

    // METODI SETTER
    public  void setType( Types type ){ this.type = type;}
    public  void setAge(int age ){ this.age = age;}
    public  void setOccupato(boolean occupato) {this.occupato = occupato;}

    // CERCA UNA FEMMINA PER ACCOPPIARSI
    public void cercaFemmina(Femmina femmina){

        if (femmina.getType() == Types.P) {
            System.out.println(" FEMMINA TIPO = P");
        } else if( femmina.getType() == Types.S) {
            System.out.println(" FEMMINA TIPO = S");
        }
    }
    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"GENERE = "+gender+" , ANNI = "+age+" , TIPOLOGIA = "+type+" , OCCUPATO = "+occupato+" ]";
    }
}
