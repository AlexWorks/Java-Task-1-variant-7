package ua.kpi.tef.model.entities.knight;

import ua.kpi.tef.model.entities.ammunition.Shield;
import ua.kpi.tef.model.entities.ammunition.AmmunitionVisitor;
import ua.kpi.tef.model.entities.ammunition.Weapon;
import ua.kpi.tef.model.entities.ammunition.armor.Boots;
import ua.kpi.tef.model.entities.ammunition.armor.Chestplate;
import ua.kpi.tef.model.entities.ammunition.armor.Helmet;
import ua.kpi.tef.model.entities.ammunition.armor.Leggings;

public class Knight implements KnightElement {
    private Helmet helmet = null;
    private Chestplate chestplate = null;
    private Leggings leggings = null;
    private Boots boots = null;
    private Weapon weapon = null;
    private Shield shield = null;

    public Helmet getHelmet() {
        return helmet;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public Chestplate getChestplate() {
        return chestplate;
    }

    public void setChestplate(Chestplate chestplate) {
        this.chestplate = chestplate;
    }

    public Leggings getLeggings() {
        return leggings;
    }

    public void setLeggings(Leggings leggings) {
        this.leggings = leggings;
    }

    public Boots getBoots() {
        return boots;
    }

    public void setBoots(Boots boots) {
        this.boots = boots;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public void equip(AmmunitionVisitor item) {
        item.visit(this);
    }

    public int getOverallPrice() {
        int sum = 0;
        sum += helmet != null ? helmet.getPrice() : 0;
        sum += chestplate != null ? chestplate.getPrice() : 0;
        sum += leggings != null ? leggings.getPrice() : 0;
        sum += boots != null ? boots.getPrice() : 0;
        sum += weapon != null ? weapon.getPrice() : 0;
        sum += shield != null ? shield.getPrice() : 0;
        return sum;
    }
}
