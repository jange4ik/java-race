import java.util.*;

class Car implements Comparable<Car> {
    private int maxSpeed;
    private float acceleration;
    private String carName;
    private float nowSpeed;
    private float carLocation;
    private float carTime;

    Car(int maxSpeed, float acceleration, String carName) {
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.carName = carName;
        this.nowSpeed = 0;
        this.carLocation = 0;
        this.carTime = 0;
    }

    public void moveCar() {
        if (this.nowSpeed < this.maxSpeed) {
            this.nowSpeed += this.acceleration;
        }
        this.carLocation += this.nowSpeed;
    }

    public float getSpeed() {
        return this.nowSpeed;
    }

    public float getLocation() {
        return this.carLocation;
    }

    public String getName() {
        return this.carName;
    }

    public void setTime(float carTime) {
        this.carTime = carTime;
    }

    public float getTime() {
        return this.carTime;
    }

    public String toString() {
        return "{carName: " + this.carName + ", " +
                "acceleration: " + this.acceleration + ", " +
                "maxSpeed:" + this.maxSpeed + "}";
    }

    public int compareTo(Car otherCar) {
        return Float.compare(this.carTime, otherCar.carTime);
    }
}

public class Race {

    public static void main(String[] args) {
        final int track = 1500; // track length in m
        boolean raceNow = true;
        float timer = 0;
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(20, 1.5f, "Blue Car")); // here are the car specs
        cars.add(new Car(50, 0.7f, "Red Car")); // speed & acceleration in m/s

        System.err.println("The race has started!");

        for (Car car : cars) {
            raceNow = true;
            while (raceNow) {
                car.moveCar();
                timer += 0.1;
                if (car.getLocation() >= track) {
                    raceNow = false;
                    car.setTime(timer);
                    System.out.println(
                            car.getName() + " finished in " + timer + "s at a speed " + car.getSpeed() + "m/s");
                    timer = 0;
                }
            }
            ;
        }
        Collections.sort(cars);
        System.out.println(cars.get(0).getName() + " is winning!");
    }
}
