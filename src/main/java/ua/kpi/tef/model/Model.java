package ua.kpi.tef.model;

import ua.kpi.tef.model.entities.Knight;
import ua.kpi.tef.model.entities.ammunition.Ammunition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Model {
    private Knight knight;
    private ArrayList<Ammunition> allAmmunition;
    private ArrayList<Ammunition> currentAmmuniton;
    private int lowerPriceBound  = 0;
    private int upperPriceBound = 0;

    public Model(ArrayList<Ammunition> ammunition) {
        this.knight = new Knight();
        this.allAmmunition = ammunition;
        this.currentAmmuniton = new ArrayList<>(this.allAmmunition);
        this.sortItems();
    }

    public void filterItemsInDiapason(int lower, int upper) {
        if (lower > upper) return;
        if (lower == 0 && upper == 0) return;
        lowerPriceBound = lower;
        upperPriceBound = upper;
        currentAmmuniton = allAmmunition.stream()
                .filter((item) -> item.getPrice() >= lower && item.getPrice() <= upper)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void sortItems() {
        Collections.sort(currentAmmuniton);
    }

    public void equipItem(Ammunition item) {
        knight.equipAmmunition(item);
    }

    public ArrayList<Ammunition> getAllAmmunition() {
        return currentAmmuniton;
    }

    public int getLowerPrice() {
        return lowerPriceBound;
    }

    public int getUpperPrice() {
        return upperPriceBound;
    }

    public Knight getKnight() {
        return knight;
    }

}
