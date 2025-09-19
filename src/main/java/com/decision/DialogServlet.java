package com.decision;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Game")
public class DialogServlet extends HttpServlet {
    private Map<String, Dialog> dialogs;

    @Override
    public void init() {
        dialogs = new HashMap<>();

        Dialog d1 = new Dialog();
        d1.setId("inicio");
        d1.setText("Te encuentras con un extraño. ¿Qué haces?");
        d1.setOptions(Map.of(
                "Saludar", "saludo",
                "Ignorar", "ignorar"
        ));

        Dialog d2 = new Dialog();
        d2.setId("saludo");
        d2.setText("El extraño sonríe y te ofrece ayuda.");
        d2.setOptions(Map.of(
                "Aceptar ayuda", "ayuda",
                "Rechazar", "ignorar"
        ));

        Dialog d3 = new Dialog();
        d3.setId("ignorar");
        d3.setTexto("El extraño se aleja en silencio.");
        d3.setOptions(Map.of(
                "Fin", "Final"));

        Dialog d4 = new Dialog();
        d4.setId("ayuda");
        d4.setTexto("Te pide que plantes unos frijoles.");
        d4.setOptions(Map.of(
                "A comer", "comer"
                ,"A plantar","plantar"));

        Dialog d5 = new Dialog();
        d5.setId("comer");
        d5.setTexto("Comes hasta estar lleno y augusto.");
        d5.setOptions(Map.of(
                "Fin", "Final"));


        Dialog d6 = new Dialog();
        d6.setId("plantar");
        d6.setTexto("crece una gran planta.");
        d6.setOptions(Map.of(
                "Talar", "cortar"
                ,"Escalar","escalar"));

        Dialog d7 = new Dialog();
        d7.setId("escalar");
        d7.setTexto("Te caes, ahora tienes dolor de espalda.");
        d7.setOptions(Map.of(
                "Fin", "Final"));

        Dialog d8 = new Dialog();
        d8.setId("cortar");
        d8.setTexto("Cae en una casa... ¡Corres!.");
        d8.setOptions(Map.of(
                "Fin", "Final"));

        dialogs.put(d1.getId(), d1);
        dialogs.put(d2.getId(), d2);
        dialogs.put(d3.getId(), d3);
        dialogs.put(d4.getId(), d4);
        dialogs.put(d5.getId(), d5);
        dialogs.put(d6.getId(), d6);
        dialogs.put(d7.getId(), d7);
        dialogs.put(d8.getId(), d8);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null){
            id = "inicio";
            HttpSession session = req.getSession();
            Integer attempts = (Integer) session.getAttribute("attempts");
            session.setAttribute("attempts", attempts+1);
        }
        if (id.equals("Final")){
            req.getRequestDispatcher("/input.jsp").forward(req, resp);
        }

        Dialog d = dialogs.get(id);
        req.setAttribute("dialog", d);
        req.getRequestDispatcher("/game.jsp").forward(req, resp);
    }
}