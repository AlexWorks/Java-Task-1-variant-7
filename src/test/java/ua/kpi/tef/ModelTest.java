package ua.kpi.tef;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.kpi.tef.model.Model;
import ua.kpi.tef.model.entities.ammunition.Ammunition;
import ua.kpi.tef.model.entities.ammunition.armor.Boots;
import ua.kpi.tef.model.entities.ammunition.armor.Chestplate;
import ua.kpi.tef.model.entities.ammunition.armor.Helmet;
import ua.kpi.tef.model.entities.ammunition.armor.Leggings;

import java.util.ArrayList;

public class ModelTest {

    private  Model model;
    private  ArrayList<Ammunition> data;

    public ModelTest() {
        try {
            data = new ArrayList<>();
            data.add(new Helmet("Helmet", 10, 0.5));
            data.add(new Chestplate("Chestplate", 20, 1));
            data.add(new Leggings("Leggings", 30, 0.8));
            data.add(new Boots("Boots", 40, 0.6));
            model = new Model(data);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void sample() {
        Assert.assertTrue(true);
    }

    @Test
    public void checkEquipAndPrice() {
        for (Ammunition item : data) {
            model.equipItem(item);
        }
        Assert.assertEquals(100, model.getKnight().getOverallPrice());
    }
}
