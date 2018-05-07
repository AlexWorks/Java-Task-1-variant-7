package ua.kpi.tef.controller.command;

import ua.kpi.tef.TextConstants;
import ua.kpi.tef.controller.AmmunitionFactory;
import ua.kpi.tef.controller.enums.AmmunitionType;
import ua.kpi.tef.model.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

public class EquipItem implements Command {
    @Override
    public String execute(HttpServletRequest request, Model model) {
        //TODO Error handling
        try {
            String type = request.getParameter(TextConstants.AMMUNITION_TYPE);
            AmmunitionType ammunitionType = AmmunitionType.getType(type);
            String name = request.getParameter(TextConstants.AMMUNITION_NAME);
            int price = Integer.parseInt(request.getParameter(TextConstants.AMMUNITION_PRICE));
            double weight = Double.parseDouble(request.getParameter(TextConstants.AMMUNITION_WEIGHT));
            AmmunitionFactory factory = new AmmunitionFactory();
            model.equipItem(factory.createAmmunition(ammunitionType, name, price, weight));
        } catch (Exception e) {
            request.setAttribute(TextConstants.EQUIP_ERROR, "Ammunition equip failed for some reason. Please try again.");
            return TextConstants.DEFAULT_PAGE;
        }
        return TextConstants.DEFAULT_PAGE;
    }
}
