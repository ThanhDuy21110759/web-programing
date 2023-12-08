package ecommerce.controller;

import ecommerce.business.CustomerEntity;
import ecommerce.data.CustomerDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SignUpServlet")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/home.jsp";

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String customername = request.getParameter("customername");
        String customerphonenumber = request.getParameter("customerphonenumber");
        String customeraddress = request.getParameter("customeraddress");


        CustomerEntity newCus = new CustomerEntity();
        newCus.setUsername(username);
        newCus.setPassword(password);
        newCus.setCustomername(customername);
        newCus.setCustomerphonenumber(customerphonenumber);
        newCus.setCustomeraddress(customeraddress);

        CustomerDB.insert(newCus);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
