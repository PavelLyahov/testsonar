package jae;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Посчитать общее население планет, где диаметр меньше 10000
 */
public class PlanetPopulation {
    public static void main(String[] args) {
        List<Planet> planets = Arrays.asList(
                new Planet("Yavin IV", 10200, 1000),
                new Planet("Hoth", 7200, 10000),
                new Planet("Dagobah", 8900, 0),
                new Planet("Endor", 4900, 30000000),
                new Planet("Kamino", 19720, 1000000000));

        System.out.println(getPopulation(planets, 10000));

    }

    static int getPopulation(List<Planet> planets, int maxDiameter) {
        return planets.stream()
                .filter(Objects::nonNull)
                .mapToInt(Planet::getDiameter)
                .filter(diameter -> diameter < maxDiameter)
                .sum();
    }

}

class Planet {
    private String name;
    private int diameter;
    private int population;

    public Planet(String name, int diameter, int population) {
        this.name = name;
        this.diameter = diameter;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getPopulation() {
        return population;
    }
}
