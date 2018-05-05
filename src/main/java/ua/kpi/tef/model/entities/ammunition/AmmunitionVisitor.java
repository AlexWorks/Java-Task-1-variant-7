package ua.kpi.tef.model.entities.ammunition;

import ua.kpi.tef.model.entities.knight.Knight;

public interface AmmunitionVisitor {
    void visit(Knight knight);
}
