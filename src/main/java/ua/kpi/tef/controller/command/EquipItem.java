package ua.kpi.tef.controller.command;

import ua.kpi.tef.controller.AmmunitionFactory;
import ua.kpi.tef.controller.enums.AmmunitionType;
import ua.kpi.tef.model.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

public class EquipItem implements Command {
    @Override
    public String execute(HttpServletRequest request, Model model) {
        List validTypes = Arrays.asList("Helmet", "Chestplate", "Leggins", "Boots", "Weapon", "Shield");
        //TODO Error handling
        try {
            String type = request.getParameter("type");
            AmmunitionType ammunitionType = AmmunitionType.getType(type);
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            double weight = Double.parseDouble(request.getParameter("weight"));
            AmmunitionFactory factory = new AmmunitionFactory();
            model.equipItem(factory.createAmmunition(ammunitionType, name, price, weight));

        } catch (Exception e) {
            return "app.jsp";
        }

        System.out.println("Equiped");
        return "app.jsp";
    }
}
