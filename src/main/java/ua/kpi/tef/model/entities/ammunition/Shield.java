package ua.kpi.tef.model.entities.ammunition;

import ua.kpi.tef.exception.InvalidDataException;
import ua.kpi.tef.model.entities.knight.Knight;

public class Shield extends Ammunition {
    public Shield(String name, int price, double weight) throws InvalidDataException {
        super(name, price, weight);
    }

    @Override
    public void visit(Knight knight) {
        knight.setShield(this);
    }
}
