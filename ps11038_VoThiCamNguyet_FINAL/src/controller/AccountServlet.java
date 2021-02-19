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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountModel;

/**
 *
 * @author Ahihi
 */
public class AccountServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            //1. lấy giá trị user và pass từ form
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String page = ""; // biến trang cần chuyển đến
            String thongbao = ""; // bien thongbao
            HttpSession session = request.getSession();
            
            //2. tao 1 doi tuong Account
            Account acc = new Account(username, password);
            //3. tao 1 doi tuong cua lop AccountModel
            AccountModel acc_model = new AccountModel();
            //4. goi ham checkLogin
            int kq = acc_model.checkLogin(acc);
            
            
            if (kq == -1)
            {
                page = "error.jsp";
                thongbao = "khong ket noi duoc voi csdl";
            }
            else if (kq == 1){
                //2. chuyển đến trang view.jsp
                page = "showSanPhamTheoHang.jsp";
                thongbao = "dang nhap thanh cong.";
                session.setAttribute("accountList", new AccountModel().getList());
            }
            else{
                //2. chuyển đến trang error.jsp
                page = "error.jsp";
                thongbao= "dang nhap that bai.";
            }
            // gan gia tri cho attribute thongbao
            request.setAttribute("thongbao", thongbao);
            //3. chuyển đến trang page
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
