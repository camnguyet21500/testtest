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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.SanPhamModel;
import model.UploadModel;

/**
 *
 * @author home
 */
@WebServlet(name = "UpdateSPServlet", urlPatterns = {"/UpdateSPServlet"})
public class UpdateSPServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int masp = Integer.parseInt(request.getParameter("txtmasp"));
            String tensp = request.getParameter("txttensp");
            int donggia = Integer.parseInt(request.getParameter("txtdongia"));
            int soluong = Integer.parseInt(request.getParameter("txtsoluong"));

            Part filehinh = request.getPart("txthinh");
            String tenhinh = new UploadModel().getTenFile(filehinh);
            int maDM = Integer.parseInt(request.getParameter("ddlDanhMuc"));

            String yeucau = request.getParameter("yeucau");

            String page = "";
            String message = "";
            HttpSession session = request.getSession();

            if (tenhinh.equals("")) {
                tenhinh = request.getParameter("txthinh_old");
                out.println(tenhinh);

            } else {
                //người dùng chọn hình mới
                // upload hinh mới lên server
                String uploadRootPath = request.getServletContext().getRealPath("/images");
                boolean kqupload = new UploadModel().uploadFile(tenhinh, filehinh, uploadRootPath);

                if (kqupload == false) {
                    message = "upload thất bại. ";
                    page = "Error.jsp";
                    request.setAttribute("thongbao", message);
                    request.getRequestDispatcher(page).forward(request, response);
                    return; // kết thúc.
                }
            }

            SanPham sp = new SanPham(masp, tensp, donggia, soluong, tenhinh, maDM);

            int kq = new SanPhamModel().updateSanPham(sp);
            if (kq == 1) {
                page = "showSanPham.jsp";
            } else if (kq == 0) {
                message = "Update thất bại.";
                page = "Error.jsp";
            } else if (kq == -1) {
                message = "Kết nối database thất bại.";
                page = "Error.jsp";
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
