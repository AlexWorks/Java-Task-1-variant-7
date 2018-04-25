package ua.kpi.tef.model.entities.ammunition.armor;

import ua.kpi.tef.exception.InvalidDataException;
import ua.kpi.tef.model.entities.ammunition.Ammunition;

public abstract class Armor extends Ammunition {
    public Armor(String name, int price, double weight) throws InvalidDataException {
        super(name, price, weight);
    }
}
