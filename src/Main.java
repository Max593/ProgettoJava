import Environment.Generatore;

/**
 * Created by max on 17/05/17.
 */
public class Main {
    public static void main(String[] args) {

        Generatore gen = new Generatore(19,50,90,20);
        gen.stampaListaGenerazione();
        System.out.printf(gen.toString());

    }
}
