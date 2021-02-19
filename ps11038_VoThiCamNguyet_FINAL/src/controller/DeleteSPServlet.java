/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SanPhamModel;

/**
 *
 * @author home
 */
@WebServlet(name = "DeleteSPServlet", urlPatterns = {"/DeleteSPServlet"})
public class DeleteSPServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            String yeucau = request.getParameter("yeucau");
            String message = "";
            String page = "";
            
            
            if (yeucau.equals("delete")) {
                int masp = Integer.parseInt(request.getParameter("txtmasp"));

                SanPham p = new SanPham();
                p.setMaSP(masp);

                int kq = new SanPhamModel().delete(p);
                if (kq == 1) {
                    page = "showSanPham.jsp";
                } else if (kq == -1) {
                    message = "Không kết nối được.";
                    page = "Error.jsp";
                }
            }
            else if (yeucau.equals("xoanhieu"))
            {
                // lấy các trị của checkbox được checked bỏ vào mảng listsanpham
                String[] listsanpham = request.getParameterValues("chon");
                if (listsanpham == null)
                {
                    request.setAttribute("thongbao", "chưa chọn dữ liệu cần xóa.");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                    return;
                }
                // duyệt và xóa hết
                int kq = 1;
                for(String masp : listsanpham)
                {
                    SanPham p = new SanPham();
                    p.setMaSP(Integer.parseInt(masp));
                    kq = new SanPhamModel().delete(p);
                }
                // show sp
                page = "showSanPham.jsp";
            }
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
