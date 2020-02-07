import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Road {
    private int len;
    private List<Ktor> ktorner;
    private String name;

    public Road(int len, String name) {
        this.len = len;
        this.name = name;
        List<Ktor> norKtorner = new ArrayList<>(); // new list
        for (int i = 0; i < len; i++) {
            lcnelMiKtor(norKtorner); //adds ktorner to the list with random qualities
        }
        this.ktorner = norKtorner;
    }

    public Road () {

    }

    public String getName() { return name; }

    public List<Ktor> getKtorner() {
        return ktorner;
    }

    private void lcnelMiKtor(List<Ktor> norKtorner) {
        Ktor ktor = new Ktor(Gonka.randomQuality()); //randomly picks quality for ktor
        norKtorner.add(ktor);
    }

    @Override
    public String toString() {
        return "Road{" +
                "len=" + len +
                ", ktorner=" + ktorner +
                '}';
    }
}