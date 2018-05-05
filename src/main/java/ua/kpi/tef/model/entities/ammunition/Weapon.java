package ua.kpi.tef.model.entities.ammunition;

import ua.kpi.tef.exception.InvalidDataException;
import ua.kpi.tef.model.entities.knight.Knight;

public class Weapon extends  Ammunition {
    public Weapon(String name, int price, double weight) throws InvalidDataException {
        super(name, price, weight);
    }

    @Override
    public void visit(Knight knight) {
        knight.setWeapon(this);
    }
}
