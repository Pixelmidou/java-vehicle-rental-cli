package Java_Uni.tp3.act;

import java.util.HashMap;
import java.util.Random;

public class Roue {
    private static final String[] symboles = {"banane", "abricot", "étoile", "cerise"};
    private int index;

    public void lance() {
        Random random = new Random();
        index = random.nextInt(symboles.length);
    }

    public HashMap<Integer, String> get() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(index+1,symboles[index]);
        return map;
    }

}
