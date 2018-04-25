package ua.kpi.tef.model.entities.ammunition.armor;

import ua.kpi.tef.exception.InvalidDataException;

public class Helmet extends Armor {
    public Helmet(String name, int price, double weight) throws InvalidDataException {
        super(name, price, weight);
    }
}
