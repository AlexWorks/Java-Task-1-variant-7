package ua.kpi.tef.model.entities.ammunition.armor;

import ua.kpi.tef.exception.InvalidDataException;
import ua.kpi.tef.model.entities.knight.Knight;

public class Leggings extends  Armor {
    public Leggings(String name, int price, double weight) throws InvalidDataException {
        super(name, price, weight);
    }

    @Override
    public void visit(Knight knight) {
        knight.setLeggings(this);
    }
}
