/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountModel;

/**
 *
 * @author home
 */
@WebServlet(name = "AccountServlet2", urlPatterns = {"/AccountServlet2"})
public class AccountServlet2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("txtname");
        String password = request.getParameter("txtpass");
        String yeucau = request.getParameter("yeucau");
        
        String page="";
        String message="";
        HttpSession session = request.getSession();
        
        Account a = new Account(username, password);
        
        AccountModel acc_model = new AccountModel();
        
        if(yeucau.equals("insert"))
        {
            int kq = acc_model.insertAccount(a);
            
            if (kq!=-1) {
                if (kq!=0) {
                    session.setAttribute("accountList", new AccountModel().getList());
                    page="view.jsp";
                } else {
                    message="Insert that bai";
                    page="error.jsp";
                }
            }
            else{
                message="Ket noi database that bai";
                page="error.jsp";
            }
            request.setAttribute("thongbao", message);
            request.getRequestDispatcher(page).forward(request, response);
        }
        if (yeucau.equals("delete")) {
            int kq=acc_model.deleteAccount(a);
            if (kq!=-1) {
                if (kq!=0) {
                    session.setAttribute("accountList", new AccountModel().getList());
                    page="view.jsp";
                }
                else
                {
                    message="Delete that bai";
                    page="error.jsp";
                }
            }
            else
            {
                message="Ket noi database that bai";
                page="error.jsp";
            }
            request.setAttribute("thongbao", message);
            request.getRequestDispatcher(page).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
