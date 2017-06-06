import People.Maschio;
import People.Persona;

/**
 * Created by max on 17/05/17.
 */
public class Main {
    public static void main(String[] args) {
        Maschio m = new Maschio(Persona.Types.M);
        m.setAge(12);
        System.out.println(m);
    }
}
