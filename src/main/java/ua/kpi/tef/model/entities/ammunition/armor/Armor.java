package ua.kpi.tef.model.entities.ammunition.armor;

import ua.kpi.tef.model.entities.ammunition.Ammunition;

public abstract class Armor extends Ammunition {
    public Armor(int price, double weight) {
        super(price, weight);
    }
}
