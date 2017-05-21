package Environment;

import java.util.HashMap;
import java.util.Map;

public class Popolazione {

    private Map<Integer,Generazione> popolazione = new HashMap<>();

    public void addToGen(int g , Generazione generazione) {  //Incompleto
        if(!popolazione.containsKey(g) ) {
            popolazione.put(g , generazione);
        }
    }

    public Map<Integer,Generazione> getPopolazione () { return popolazione; }

}
