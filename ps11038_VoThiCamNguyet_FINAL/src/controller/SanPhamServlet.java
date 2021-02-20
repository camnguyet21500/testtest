
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

@WebServlet(name = "SanPhamServlet", urlPatterns = {"/SanPhamServlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,  // 10 KB
        maxFileSize = 11024 * 1024 * 10,       // 300 KB
        maxRequestSize = 1024 * 1024 * 100    // 1 MB 
)
public class SanPhamServlet extends HttpServlet {

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
    	
        //processRequest(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
        	String yeucau = request.getParameter("yeucau");
            String tensp = request.getParameter("txttensp");
            int donggia = Integer.parseInt(request.getParameter("txtdongia"));
            int soluong = Integer.parseInt(request.getParameter("txtsoluong"));
            
            Part filehinh = request.getPart("txthinh");
            String tenhinh = new UploadModel().getTenFile(filehinh);
            int maDM = Integer.parseInt(request.getParameter("ddlDanhMuc"));

            

            String page = "";
            String message = "";
            HttpSession session = request.getSession();

            SanPham sp = new SanPham(1, tensp, donggia, soluong, tenhinh, maDM);
            SanPhamModel sp_model = new SanPhamModel();

            if (yeucau.equals("Insert")) {
                String uploadRootPath = request.getServletContext().getRealPath("/images");
                boolean kqupload= new UploadModel().uploadFile(tenhinh, filehinh, uploadRootPath);
                
                if (kqupload == false)
                {
                    message = "upload thất bại. ";
                    page = "Error.jsp";
                    return; // kết thúc.
                }
                
                int kq = sp_model.insertSanPham(sp);
                if (kq == 1) {
                    page = "showSanPham.jsp";
                } else if (kq == 0) {
                    message = "Insert thất bại.";
                    page = "Error.jsp";
                } else if (kq == -1) {
                    message = "Kết nối database thất bại.";
                    page = "Error.jsp";
                }
            }
            if (yeucau.equals("laythongtin"))
            {
                int masp = Integer.parseInt(request.getParameter("txtmasp"));
                
                SanPham sanpham = new SanPhamModel().getSanPhamByMaSP(masp);
                session.setAttribute("sanpham", sanpham);
                page = "updateSP.jsp";
            }
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
