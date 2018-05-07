package ua.kpi.tef.controller.command;

import ua.kpi.tef.TextConstants;
import ua.kpi.tef.exception.InvalidDiapasonException;
import ua.kpi.tef.model.Model;

import javax.servlet.http.HttpServletRequest;

public class FilterItems implements Command {
    @Override
    public String execute(HttpServletRequest request, Model model) {
        try {
            int lower = Integer.parseInt(request.getParameter(TextConstants.PRICE_FILTER_LOWER_BOUND));
            int upper = Integer.parseInt(request.getParameter(TextConstants.PRICE_FILTER_UPPER_BOUND));
            model.filterItemsInDiapason(lower, upper);
        } catch (InvalidDiapasonException | NumberFormatException e) {
            request.setAttribute(TextConstants.FILTER_ERROR, e.getMessage());
        }
        return TextConstants.DEFAULT_PAGE;
    }
}
