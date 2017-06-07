package People;

import Environment.Generazione;

import java.util.List;
import java.util.Random;

import java.util.function.Function;

public class Maschio extends Persona implements Runnable{
    private Generazione gen;  //Generazione a cui sta facendo riferimento per accesso al gruppo femminile

    //COSTRUTTORI
    public Maschio(Types type) {
        setType(type);
        setGender(Genders.MALE);
    }

    public void setGen(Generazione gen) { this.gen = gen; }

    //METODO INFORMAZIONI OGGETTO
    public String toString() {
        return getClass().getName()+" [ "+"GENERE = "+getGender()+" , ANNI = "+getAge()+" , TIPOLOGIA = "+getType()+" , OCCUPATO = "+getOccupato()+" ]";
    }

    //Esecuzione del thread
    @Override
    public void run() {
        List<Femmina> femmine = gen.getListaFemmine();  //Dovrebbe attivarsi il synchronized già da questo accesso

        Function<List<Femmina>, Femmina> randPartnerPicker = l -> {  //Cerca la prima femmina non occupata che può trovare
            int index = new Random().nextInt(femmine.size());  //Valore random
            Femmina female = femmine.get(index);  //Recupera una femmina random
            while(female.isImpegnata()) {
                index = new Random().nextInt(femmine.size());  //Nuovo valore random
                female = femmine.get(index);  //Recupera una nuova femmina random
            }
            female.setImpegnata(true);
            return female;
        };

        Femmina partner = randPartnerPicker.apply(femmine);

        if(getType() == Types.M) {  //Se si tratta di maschi M
            if(partner.getType() == Types.P) {  //Se si tratta di femmine P

            }
            else {  //Se si tratta di femmine S

            }
        }
        else {  //Se si tratta di maschi A

        }

    }
}
