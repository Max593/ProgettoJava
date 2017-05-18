/*
Pacchetto di test in caso di dubbi
 */

package TEST;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 18/05/17.
 */
public class Test {
    public static void main(String[] args) {
        List<List<Father>> test = new ArrayList<>();
        List<Son1> t1 = new ArrayList<>();
        t1.add(new Son1());
        test.add(new ArrayList<>(t1));
        test.add(new ArrayList<>());
    }
}
