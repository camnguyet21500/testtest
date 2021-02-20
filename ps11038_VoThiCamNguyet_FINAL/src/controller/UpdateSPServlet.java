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
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,  // 10 KB
        maxFileSize = 11024 * 1024 * 10,       // 300 KB
        maxRequestSize = 1024 * 1024 * 100    // 1 MB 
)
public class UpdateSPServlet extends HttpServlet {

   
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
    	
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
        	
        	String tensp = request.getParameter("txttensp");
            int masp = Integer.parseInt(request.getParameter("txtmasp"));          
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
                //ngÆ°á»�i dÃ¹ng chá»�n hÃ¬nh má»›i
                // upload hinh má»›i lÃªn server
                String uploadRootPath = request.getServletContext().getRealPath("/images");
                boolean kqupload = new UploadModel().uploadFile(tenhinh, filehinh, uploadRootPath);

                if (kqupload == false) {
                    message = "upload tháº¥t báº¡i. ";
                    page = "Error.jsp";
                    request.setAttribute("thongbao", message);
                    request.getRequestDispatcher(page).forward(request, response);
                    return; // káº¿t thÃºc.
                }
            }

            SanPham sp = new SanPham(masp, tensp, donggia, soluong, tenhinh, maDM);

            int kq = new SanPhamModel().updateSanPham(sp);
            if (kq == 1) {
                page = "showSanPham.jsp";
            } else if (kq == 0) {
                message = "Update tháº¥t báº¡i.";
                page = "Error.jsp";
            } else if (kq == -1) {
                message = "Káº¿t ná»‘i database tháº¥t báº¡i.";
                page = "Error.jsp";
            }

            request.setAttribute("thongbao", message);
            request.getRequestDispatcher(page).forward(request, response);

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
