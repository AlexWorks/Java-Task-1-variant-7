package ua.kpi.tef.model.entities.ammunition;

import ua.kpi.tef.exception.InvalidDataException;

public class Shield extends Ammunition {
    public Shield(String name, int price, double weight) throws InvalidDataException {
        super(name, price, weight);
    }
}
