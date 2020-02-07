
public class Car {
    private String maker, model;
    private int speed, weight;
    private CarTypeEnum type;
    private CarTypeEnum ct;
    private double mijinChanaparhiDandaxecum;
    private double vatChanaparhiDandaxecum;

    public Car() {
    }

    public Car(String maker, String model, int speed, int weight, CarTypeEnum type) {
        this.maker = maker;
        this.model = model;
        this.speed = speed;
        this.weight = weight;
        this.type = type;
    }

    public Car(CarTypeEnum type) {
        if (type == CarTypeEnum.suv) {
            mijinChanaparhiDandaxecum = 1.1;
            vatChanaparhiDandaxecum = Math.pow(1.1, 2);
        } else if (type == CarTypeEnum.common) {
            mijinChanaparhiDandaxecum = 1.3;
            vatChanaparhiDandaxecum = Math.pow(1.3, 2);
        } else if (type == CarTypeEnum.sport) {
            mijinChanaparhiDandaxecum = 1.5;
            vatChanaparhiDandaxecum = Math.pow(1.5, 2);
        }
    }

    public double getMijinChanaparhiDandaxecum() {
            return mijinChanaparhiDandaxecum;
        }
        
    public double getVatChanaparhiDandaxecum() {
        return vatChanaparhiDandaxecum;
    }    

    public CarTypeEnum getType() { return type; }

    public int getSpeed() {
        return speed;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", speed=" + speed +
                ", weight=" + weight +
                ", type=" + type +
                '}';
    }
}
