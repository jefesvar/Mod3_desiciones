package com.decision;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/input")
public class InputServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/input.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String valor = req.getParameter("name");
        if (valor != null && !valor.isEmpty()) {
            HttpSession session = req.getSession();
            session.setAttribute("name", valor);
            session.setAttribute("attempts", 0);
        }
        resp.sendRedirect("input");
    }
}



