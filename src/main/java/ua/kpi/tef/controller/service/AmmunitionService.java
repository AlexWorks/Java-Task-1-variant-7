package ua.kpi.tef.controller.service;

import ua.kpi.tef.model.entities.ammunition.Ammunition;

import java.util.ArrayList;

public interface AmmunitionService {
    ArrayList<Ammunition> getAllAmmunition() throws Exception;
}
