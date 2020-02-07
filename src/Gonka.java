import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

class Gonka {

    public static void main(String[] args) throws IOException {
        int count = 0;
        List<String[]> content = getStrings();

        List<Car> cars = new ArrayList<>(); // declaring new cars list
        for (int i = 1; i < content.size(); i++) {
            String[] a = content.get(i);
            Car car = aaa(a); // receiving each line as an object
            cars.add(car); // adding objects to the cars list
        }

        Road simpleRoad = new Road(100, "gago"); // Road object sarqi 100 ktoranoc
        List<Ktor> listKtorner = simpleRoad.getKtorner(); //road object as a list

        // HashMap with car as its KEY and time as its VALUE
        HashMap<String, Double> myMap = new HashMap<>();
        for (int i = 0; i < cars.size(); i++) {
            double newTime = getTime(cars.get(i), listKtorner);
            newTime = newTime * 60; // to get in minutes
            myMap.put(cars.get(i).getMaker()+ " " + cars.get(i).getModel(), round(newTime));
        }

        Map<String, Double> newMap = sortByValue(myMap);

        // print the sorted hashmap
        for (Map.Entry<String, Double> sorted : newMap.entrySet()) {
            System.out.println(sorted.getKey() +
                    ", Time = " + sorted.getValue() + " minutes");
        }

    }

    public static List<String[]> getStrings() throws IOException {
        String file = "C:\\Users\\aniam\\Desktop\\CarData.txt";
        List<String[]> content = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] l = line.split(";");
            content.add(l); //storing each line into content list as an array
        }
        return content;
    }

    // sorting the values in HashMap
    public static HashMap<String, Double> sortByValue(HashMap<String, Double> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Double> > list = new LinkedList<Map.Entry<String, Double> >(hm.entrySet());

        // Sort the list
        list.sort(new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> new1 : list) {
            temp.put(new1.getKey(), new1.getValue());
        }
        return temp;
    }

    // method for getting the completion time for each car
    public static double getTime(Car car, List<Ktor> listKtorner) {
        double dandax;
        double time = 0;
        Car carType = new Car(car.getType());

        for (int i = 0; i < listKtorner.size(); i++) {
            if (listKtorner.get(i).getVorak().equals(AsphaltQuality.normal)){
                dandax = carType.getMijinChanaparhiDandaxecum();
            } else if (listKtorner.get(i).getVorak().equals(AsphaltQuality.vat)) {
                dandax = carType.getVatChanaparhiDandaxecum();
            } else {
                dandax = 1;
            }
            time = time + (1 / (car.getSpeed() / dandax));
        }
        return time;
    }

    // arrays into car objects
    public static Car aaa(String[] arr) {
        return new Car(arr[0], arr[1], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), CarTypeEnum.valueOf(arr[2]));
    }

    public static AsphaltQuality randomQuality() {
        return AsphaltQuality.values()[new Random().nextInt(AsphaltQuality.values().length)];
    }

    // method for rounding up the double
    private static double round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}