package ua.kpi.tef.model.entities;

import ua.kpi.tef.model.entities.ammunition.Ammunition;
import ua.kpi.tef.model.entities.ammunition.Shield;
import ua.kpi.tef.model.entities.ammunition.Weapon;
import ua.kpi.tef.model.entities.ammunition.armor.Boots;
import ua.kpi.tef.model.entities.ammunition.armor.Chestplate;
import ua.kpi.tef.model.entities.ammunition.armor.Helmet;
import ua.kpi.tef.model.entities.ammunition.armor.Leggins;

public class Knight {
    private Helmet helmet = null;
    private Chestplate chestplate = null;
    private Leggins leggins = null;
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

    public Leggins getLeggins() {
        return leggins;
    }

    public void setLeggins(Leggins leggins) {
        this.leggins = leggins;
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

    public void equipAmmunition(Ammunition item) {
        if (item instanceof Helmet) {
            helmet = (Helmet) item;
        } else if (item instanceof Chestplate) {
            chestplate = (Chestplate) item;
        } else if (item instanceof Leggins) {
            leggins = (Leggins) item;
        } else if (item instanceof Boots) {
            boots = (Boots) item;
        } else if (item instanceof Weapon) {
            weapon = (Weapon) item;
        } else if (item instanceof Shield) {
            shield = (Shield) item;
        }
    }

    public int getOverallPrice() {
        int sum = 0;
        sum += helmet != null ? helmet.getPrice() : 0;
        sum += chestplate != null ? chestplate.getPrice() : 0;
        sum += leggins != null ? leggins.getPrice() : 0;
        sum += boots != null ? boots.getPrice() : 0;
        sum += weapon != null ? weapon.getPrice() : 0;
        sum += shield != null ? shield.getPrice() : 0;
        return sum;
    }
}
