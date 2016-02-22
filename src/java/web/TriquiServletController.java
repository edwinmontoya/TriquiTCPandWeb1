package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import triqui.TriquiGame;

@WebServlet(name = "TriquiServletController", urlPatterns = {"/TriquiServletController"})
public class TriquiServletController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    TriquiGame tg = new TriquiGame();

    public TriquiServletController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pos = -1;
        String action = request.getParameter("action");
        if (action.equals("play")) {
            pos = Integer.parseInt(request.getParameter("pos"));
            tg.setStatus(Boolean.toString(tg.Play(pos - 1)));
        } else {
            tg.Start();
        }
        request.setAttribute("triqui", tg);
        getServletContext().getRequestDispatcher("/TriquiApp.jsp").forward(request, response);
    }

}
