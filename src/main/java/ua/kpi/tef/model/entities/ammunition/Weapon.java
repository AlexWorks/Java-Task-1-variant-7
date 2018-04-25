package ua.kpi.tef.model.entities.ammunition;

import ua.kpi.tef.exception.InvalidDataException;

public class Weapon extends  Ammunition {
    public Weapon(String name, int price, double weight) throws InvalidDataException {
        super(name, price, weight);
    }
}
