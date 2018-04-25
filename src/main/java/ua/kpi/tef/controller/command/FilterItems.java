package ua.kpi.tef.controller.command;

import ua.kpi.tef.model.Model;

import javax.servlet.http.HttpServletRequest;

public class FilterItems implements Command {
    @Override
    public String execute(HttpServletRequest request, Model model) {
        return "/app";
    }
}
