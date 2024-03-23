package sem.sem_docker;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sem.dataaccess.DataAccess;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetCarsServlet", value = "/getcars")
public class GetCarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        DataAccess da = new DataAccess();

        writer.println("<h1>List of cars</h1>");
        var cars = da.GetCars();

        writer.println("<ul>");
        for(var car : cars){
            writer.println(String.format("<li>%d, %s, %s</li>", car.getId(), car.getMake(), car.getModel()));
        }
        writer.println("</ul>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}