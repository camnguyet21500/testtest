/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountModel;
import model.MyConnect;

/**
 *
 * @author home
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("txtUserName");
        String password = request.getParameter("txtPassword");

        String page = "";
        String message = "";
        //Tạo kết nối với database
        Connection cn = new MyConnect().getcn();

        //Kiểm tra kết nối thành công or thất bại
        if (cn == null) {
            message = "Ket noi that bai";
            request.setAttribute("thongbao", message);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            return;
        }

        //Select dữ liệu từ database – theo username mà client vừa login.     
        try {
            String sql = "select * from account where username like ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getString(2).equals(password)) {
                    message = "Login thanh cong";
                    page = "View.jsp";
                } else {
                    message = "Login that bai";
                    page = "Error.jsp";
                }
            } else {
                message = "Username ko ton tai";
                page = "Error.jsp";
            }
            request.setAttribute("thongbao", message);
            request.getRequestDispatcher(page).forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }}

//        HttpSession session = request.getSession();
//
//        Account acc = new Account(username, password);
//        AccountModel acc_model = new AccountModel();
//
//        int loginkq = acc_model.loginAccount(acc);
//
//        if (loginkq != -1) {
//            if (loginkq == 1) {
//                message = "Login thanh cong";
//                page = "View.jsp";
//                AccountModel model = new AccountModel();
//                session.setAttribute("accountList", model.getList());
//            } else if (loginkq == 2) {
//                message = "Login sai mat khau.";
//                page = "Error.jsp";
//            } else if (loginkq == 3) {
//                message = "Username ko ton tai";
//                page = "Error.jsp";
//            }
//        }
//        request.setAttribute("thongbao", message);
//        request.getRequestDispatcher(page).forward(request, response);
//    if(username.equals("a")&&password.equals("a"))
//    {
//        page="View.jsp";
//    }
//    else
//    {
//        page="Error.jsp";
//    }
//    request.getRequestDispatcher(page).forward(request, response);
//    }
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
