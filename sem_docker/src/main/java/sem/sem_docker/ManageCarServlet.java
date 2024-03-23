package sem.sem_docker;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sem.dataaccess.DataAccess;
import sem.models.Car;

import java.io.IOException;

@WebServlet(name = "ManageCarServlet", value = "/managecar")
public class ManageCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String make = request.getParameterValues("make")[0];
        String model = request.getParameterValues("model")[0];

        DataAccess da = new DataAccess();

        Car car = new Car(0, make, model);

        da.AddCar(car);

        response.sendRedirect("getcars");
    }
}