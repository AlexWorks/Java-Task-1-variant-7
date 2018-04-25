package ua.kpi.tef.controller.command;
import ua.kpi.tef.model.Model;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request, Model model);
}
