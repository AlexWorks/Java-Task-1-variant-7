package ua.kpi.tef.controller;

import ua.kpi.tef.controller.command.Command;
import ua.kpi.tef.controller.command.EquipItem;
import ua.kpi.tef.controller.command.FilterItems;
import ua.kpi.tef.controller.service.AmmunitionService;
import ua.kpi.tef.controller.service.DBAmmunitionService;
import ua.kpi.tef.model.Model;
import ua.kpi.tef.model.entities.ammunition.Ammunition;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Model model;
    private String APP = "app.jsp";
    private AmmunitionService service;
    private ArrayList<Ammunition> data;
    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() {
        try {
            this.service = new DBAmmunitionService();
            this.data = service.getAllAmmunition();
            this.data.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model = new Model(this.data);
        commands.put("filter", new FilterItems());
        commands.put("equip", new EquipItem());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(APP).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println(path);
        path = path.replaceAll(".*/app/" , "");
        System.out.println(path);
        Command command = commands.getOrDefault(path ,
                (r, model)->"/index.jsp)");
        String page = command.execute(request, model);
        if (page.contains("redirect")){
            response.sendRedirect(page.replace("redirect:", "/api"));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
