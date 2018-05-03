package ua.kpi.tef.controller;

import ua.kpi.tef.controller.enums.AmmunitionType;
import ua.kpi.tef.model.entities.ammunition.Ammunition;
import ua.kpi.tef.model.entities.ammunition.Shield;
import ua.kpi.tef.model.entities.ammunition.Weapon;
import ua.kpi.tef.model.entities.ammunition.armor.Boots;
import ua.kpi.tef.model.entities.ammunition.armor.Chestplate;
import ua.kpi.tef.model.entities.ammunition.armor.Helmet;
import ua.kpi.tef.model.entities.ammunition.armor.Leggins;

public class AmmunitionFactory {
    public Ammunition createAmmunition(AmmunitionType type, String name, int price, double weight) throws Exception {
        switch (type) {
            case HELMET: return new Helmet(name, price, weight);
            case CHESTPLATE: return new Chestplate(name, price, weight);
            case LEGGINS: return new Leggins(name, price, weight);
            case BOOTS: return new Boots(name, price, weight);
            case WEAPON: return new Weapon(name, price, weight);
            case SHIELD: return new Shield(name, price, weight);
            default: throw new Exception("Invalid type");
        }
    }
}
