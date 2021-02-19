/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.ChiTietDonHang;
import entities.Item;
import entities.KhachHang;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ChiTietDonHangModel;
import model.DonHangModel;
import model.GioHangModel;
import model.KhachHangModel;

/**
 *
 * @author home
 */
@WebServlet(name = "GioHangServlet", urlPatterns = {"/GioHangServlet"})
public class GioHangServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // tao 1 doi tuong
    GioHangModel model = new GioHangModel();
    KhachHangModel khachhang_model=new KhachHangModel();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            // khai bao
            String page = "";
            String message = "";
            int masp = 0;
            if (request.getParameter("txtmasp") != null) {
                masp = Integer.parseInt(request.getParameter("txtmasp"));
            }
            String yeucau = request.getParameter("yeucau");

            if (yeucau.equals("muasp")) {
                // them vao gio hang
                model.addSanPham(masp);
                // lay cac Items co trong gio hang ra
                // de qua trang giohang.jsp chung ta hien thị ra
                request.setAttribute("giohang", model.getListItems());
            }
            if (yeucau.equals("bosp")) {
                //gọi hàm xóa món hàng
                model.removeSanPham(masp);
                //hiển thị các món hàng còn lại trong giỏ hàng
                request.setAttribute("giohang", model.getListItems());
            }
            if (yeucau.equals("xoatatca")) {
                //gọi hàm xóa hết giỏ hàng
                model.removeAllSanPham();
//                //hiển thị  giỏ hàng
//                request.setAttribute("giohang", model.getListItems());
            }
            if (yeucau.equals("tang")) {
                model.tang(masp);
                request.setAttribute("giohang", model.getListItems());
            }
            if (yeucau.equals("giam")) {
                model.giam(masp);
                request.setAttribute("giohang", model.getListItems());
            }
            if (yeucau.equals("thanhtoan")) {
                //1. thêm insert into khách hàng
                //2. lấy getMax_MaKH vừa thêm
                //3. các câu lệnh phía dưới hôm trước đã làm
                String TenKH=request.getParameter("form-control");
                String DiaChi=request.getParameter("ct-address");
                String DienThoai=request.getParameter("ct-phone-num");
                KhachHang khachhang=new KhachHang(0, TenKH, DiaChi, DienThoai);
                khachhang_model.insertKhachHang(khachhang);
                System.out.println("khach hang sg");
                int Max_MaKH=khachhang_model.getMaKH_MoiNhat();
                
                //lấy ngày hiện tại (ngày hệ thống)
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Calendar cal = Calendar.getInstance();
                String ngayDH = dateFormat.format(cal.getTime());
                //1. insert don hang moi
                DonHangModel donhang_model = new DonHangModel();
                //lưu xuống đơn hàng ngayDH và ở đây tại maKH = 1
                donhang_model.insertDonHang(ngayDH, Max_MaKH); // khach hang có mã là 1
                //2. lấy maDH vừa insert trong DonHang(tức là maDH lớn nhất)
                int maDH_MoiNhat = donhang_model.getMaDH_MoiNhat();
                //3. insert chi tiết giỏ hàng vào bảng chi tiet don hàng
                //dùng vòng lặp duyệt qua giỏ hàng và thêm vào bảng CTDH
                ChiTietDonHangModel ctdh_model = new ChiTietDonHangModel();
                ArrayList<Item> giohang = model.getListItems();// lấy từng item trong giỏ hàng ra
                int kq = 0;
                for (Item i : giohang) {
                    ChiTietDonHang ctdh = new ChiTietDonHang(maDH_MoiNhat, i.getSanpham().getMaSP(), i.getSanpham().getDonGia(), i.getSoluong());
                    kq = ctdh_model.insertChiTietDonHang(ctdh);
                }
                //4. xóa giỏ hàng
                model.removeAllSanPham();//sau khi thêm xuống database thì ta xóa giỏ hàng
                page = "thongbao.jsp";// chuyển qua trang thongbao.jsp xuất ra maDH vừa thêm
                message = "Mã đơn hàng quý khách đặt có mã " + maDH_MoiNhat + " đã đặt thành công. ";
                request.setAttribute("thongbao", message);
                request.getRequestDispatcher(page).forward(request, response);
                return;
            }
            // chuyển trang
            page = "giohang.jsp";
            // 2. Lấy giỏ hàng để trang giohang.jsp xuất ra các item đã mua
            request.setAttribute("giohang", model.getListItems());
            request.setAttribute("tongtien", model.getTongTien());
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
