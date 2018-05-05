package ua.kpi.tef.model.entities.knight;

import ua.kpi.tef.model.entities.ammunition.AmmunitionVisitor;

public interface KnightElement {
    void equip(AmmunitionVisitor ammunition);
}
