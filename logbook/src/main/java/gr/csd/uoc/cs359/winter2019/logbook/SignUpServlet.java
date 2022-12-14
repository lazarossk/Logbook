/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs359.winter2019.logbook;

import gr.csd.uoc.cs359.winter2019.logbook.db.UserDB;
import gr.csd.uoc.cs359.winter2019.logbook.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author user
 */
public class SignUpServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String firstname=request.getParameter("firstname");
        String password=request.getParameter("password");
        String lastname=request.getParameter("lastname");
        String birthdate=request.getParameter("birthdate");
        String gender=request.getParameter("gender");
        String country=request.getParameter("country");
        String city=request.getParameter("city");
        String address=request.getParameter("address");
        String prof=request.getParameter("prof");
        String interests=request.getParameter("interests");
        String info=request.getParameter("info");
        
        
        User user = new User();
        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setBirthDate(birthdate);
        user.setCountry(country);
        user.setTown(city);
        user.setAddress(address);
        user.setOccupation(prof);
        user.setGender(gender);
        user.setInterests(interests);
        user.setInfo(info);
        
        if (UserDB.checkValidUserName(username) && UserDB.checkValidEmail(email))
        {
            UserDB.addUser(user);
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                response.setContentType("text/html;charset=UTF-8");
                out.println("<br><h3>Created Account with following field values.</h2>");
                out.println("<p>Username:<br>"+username+"</p>");
                out.println("<p>Email:<br>"+email+"</p>");
                out.println("<p>Password:<br>"+password+"</p>");
                out.println("<p>Firstname:<br>"+firstname+"</p>");
                out.println("<p>Lastname:<br>"+lastname+"</p>");
                out.println("<p>Birhtdate:<br>"+birthdate+"</p>");
                out.println("<p>Gender:<br>"+gender+"</p>");
                out.println("<p>Country:<br>"+country+"</p>");
                out.println("<p>City:<br>"+city+"</p>");
                out.println("<p>Address:<br>"+address+"</p>");
                out.println("<p>Profession:<br>"+prof+"</p>");
                out.println("<p>Interests:<br>"+interests+"</p>");
                out.println("<p>Info:<br>"+info+"</p>");
                response.setStatus(200);
            }
        }
        else{
            try (PrintWriter out = response.getWriter()) {
                out.println("User Exists");
                response.setStatus(400);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
