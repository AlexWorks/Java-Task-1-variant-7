package ua.kpi.tef.controller.command;

import ua.kpi.tef.model.Model;
import ua.kpi.tef.model.entities.ammunition.Shield;
import ua.kpi.tef.model.entities.ammunition.Weapon;
import ua.kpi.tef.model.entities.ammunition.armor.Boots;
import ua.kpi.tef.model.entities.ammunition.armor.Chestplate;
import ua.kpi.tef.model.entities.ammunition.armor.Helmet;
import ua.kpi.tef.model.entities.ammunition.armor.Leggins;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

public class EquipItem implements Command {
    @Override
    public String execute(HttpServletRequest request, Model model) {
        List validTypes = Arrays.asList("Helmet", "Chestplate", "Leggins", "Boots", "Weapon", "Shield");
        //TODO Error handling
        String type = request.getParameter("type");
        if (validTypes.contains(type)) {
            String name = request.getParameter("name");
            int price;
            double weight;
            try {
                price = Integer.parseInt(request.getParameter("price"));
                weight = Double.parseDouble(request.getParameter("weight"));
                switch (type) {
                    case "Helmet":
                        model.equipItem(new Helmet(name, price, weight));
                        break;
                    case "Chestplate":
                        model.equipItem(new Chestplate(name, price, weight));
                        break;
                    case "Leggins":
                        model.equipItem(new Leggins(name, price, weight));
                        break;
                    case "Boots":
                        model.equipItem(new Boots(name, price, weight));
                        break;
                    case "Weapon":
                        model.equipItem(new Weapon(name, price, weight));
                        break;
                    case "Shield":
                        model.equipItem(new Shield(name, price, weight));
                        break;
                    default: break;
                }
            } catch (Exception e) {
                return "app.jsp";
            }
        } else {
            System.out.println("No such type!");
        }
        System.out.println("Equiped");
        return "app.jsp";
    }
}
