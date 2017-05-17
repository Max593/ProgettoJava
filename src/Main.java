import Interfaces.Popolazione;

/**
 * Created by max on 17/05/17.
 */
public class Main {
    public static void main(String[] args) {
        Popolazione pop = new Popolazione();
        pop.addAll2(30,23,12,10);
        System.out.println(pop.getMaschi().size()+" "+pop.getFemmine().size());
        pop.add3(1, pop.getMaschi(), pop.getFemmine());
        System.out.println(pop.getGenerazioni(1).get(0).size());
    }
}
