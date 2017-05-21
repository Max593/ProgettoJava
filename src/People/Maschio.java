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
        if ((femmina.getType() == Types.P) && (type == Types.M)){
            System.out.println(" FEMMINA TIPO = P , MASCHIO TIPO M");
        } else if((femmina.getType() == Types.P) && (type == Types.A)) {
            System.out.println(" FEMMINA TIPO = P , MASCHIO TIPO A");
        } else if((femmina.getType() == Types.S) && (type == Types.M)) {
            System.out.println(" FEMMINA TIPO = S , MASCHIO TIPO M");
        }else if((femmina.getType() == Types.S) && (type == Types.A)) {
            System.out.println(" FEMMINA TIPO = S , MASCHIO TIPO A");
        }
    }
    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"GENERE = "+gender+" , ANNI = "+age+" , TIPOLOGIA = "+type+" , OCCUPATO = "+occupato+" ]";
    }
}
