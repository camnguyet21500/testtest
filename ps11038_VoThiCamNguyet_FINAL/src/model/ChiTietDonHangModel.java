/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.ChiTietDonHang;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Ahihi
 */
public class ChiTietDonHangModel {
    public ChiTietDonHangModel()
    {
        
    }
    //1 hàm lưu xuống bảng chi tiết đơn hàng
    //input: đối tượng ChiTietDonHang ctdh (bao gồm 4 thuộc tính: maDH, maSP, donGia, soLuong) 
    //thêm xuống bảng CTDH
    public int insertChiTietDonHang(ChiTietDonHang ctdh)
    {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null)
            return -1; // ko ket noi duoc.
        try {
            String sql = "insert into ChiTietDonHang values(?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, ctdh.getMaDH());
            ps.setInt(2, ctdh.getMaSP());
            ps.setInt(3, ctdh.getDonGia());
            ps.setInt(4, ctdh.getSoLuong());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;        
    }
}
