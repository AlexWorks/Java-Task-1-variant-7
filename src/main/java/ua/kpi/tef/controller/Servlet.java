package ua.kpi.tef.controller;

import ua.kpi.tef.controller.service.AmmunitionService;
import ua.kpi.tef.controller.service.DBAmmunitionService;
import ua.kpi.tef.model.entities.ammunition.Ammunition;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Servlet extends HttpServlet {
    private String APP = "app.jsp";
    private AmmunitionService service;
    private List<Ammunition> data;

    @Override
    public void init() {
        try {
            this.service = new DBAmmunitionService();
            this.data = service.getAllAmmunition();
            this.data.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
}
