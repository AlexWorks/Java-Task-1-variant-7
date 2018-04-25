package ua.kpi.tef.model;

import ua.kpi.tef.model.entities.Knight;
import ua.kpi.tef.model.entities.ammunition.Ammunition;

import java.util.ArrayList;
import java.util.Collections;

public class Model {
    private Knight knight;
    private ArrayList<Ammunition> ammunition;

    public Model(ArrayList<Ammunition> ammunition) {
        this.knight = new Knight();
        this.ammunition = ammunition;
        this.sortItems();
    }

    private void sortItems() {
        Collections.sort(ammunition);
    }
}
