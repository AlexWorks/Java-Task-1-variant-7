package ua.kpi.tef.model.entities.ammunition;

import ua.kpi.tef.exception.InvalidDataException;

public abstract class Ammunition {
    private String name;
    private int price;
    private double weight;
    private static String NEGATIVE_PRICE = "Price cannot be negative";
    private static String NON_POSITIVE_WEIGHT = "Weight must be greater than zero";

    public Ammunition(String name, int price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws InvalidDataException {
        if (price < 0) {
            throw new InvalidDataException(NEGATIVE_PRICE);
        }
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws InvalidDataException {
        if (price <= 0) {
            throw new InvalidDataException(NON_POSITIVE_WEIGHT);
        }
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Ammunition{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
