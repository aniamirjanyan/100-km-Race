public class Ktor {

    private AsphaltQuality vorak;

    public Ktor(AsphaltQuality vorak) {
        this.vorak = vorak;
    }

    public AsphaltQuality getVorak() {
        return vorak;
    }
    public AsphaltQuality setVorak() {return vorak; }

    @Override
    public String toString() {
        return "Ktor{" +
                "vorak=" + vorak +
                '}';
    }
}
