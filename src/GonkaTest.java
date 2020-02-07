import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GonkaTest {

    // @Test
    public void testData() throws IOException { assertEquals(11, Gonka.getStrings().size()); }

    @Test
    public void testCar() {
        // nor meqena
        Car newCar = new Car("blah", "blah",200,1280, CarTypeEnum.common);
        // nor ktor
        Ktor ktor1 = new Ktor(AsphaltQuality.lav);
        Ktor ktor2 = new Ktor(AsphaltQuality.vat);
        List<Ktor> newRoad = new ArrayList<>();
        newRoad.add(ktor1);
        newRoad.add(ktor2);
        assertEquals(Gonka.getTime(newCar, newRoad), 0.01345);
    }
}