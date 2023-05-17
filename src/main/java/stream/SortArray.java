package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortArray {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        Car ferrari = new Car(1990, "Ferrari 360 Spider", 310);
        Car lambo = new Car(20012, "Lamborghini Gallardo", 290);
        Car bugatti = new Car(2010, "Bugatti Veyron", 350);

        cars.add(ferrari);
        cars.add(bugatti);
        cars.add(lambo);

        sortCar(cars).forEach(System.out::println);


        List<User> users = new ArrayList<>();
        User pavel = new User(1991, "Pavel");
        User anton = new User(2000, "Anton");
        users.add(pavel);
        users.add(anton);
        Collections.sort(users);
    }

    public static List<Car> sortCar(List cars) {
        return cars.stream().sorted(Comparator.comparing(Car::getMaxSpeed).reversed()).toList();
    }

}



class Car {

    private int manufactureYear;
    private String model;
    private int maxSpeed;

    public Car(int manufactureYear, String model, int maxSpeed) {
        this.manufactureYear = manufactureYear;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufactureYear=" + manufactureYear +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

class User implements Comparable<User>{

    private int year;
    private String name;

    public User(int year, String name) {
        this.year = year;
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "year=" + year +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(User user) {
        return this.getYear() - user.getYear();
    }
}

