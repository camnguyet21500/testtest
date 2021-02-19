/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ahihi
 */
public class KhachHangModel {

//    public void insertKhachHang(KhachHang model) {
//        String sqlInsert = "insert into KhachHang values(?,?,?)";
//        Connection cn = new MyConnect().getcn();
//        try {
//            PreparedStatement ps = cn.prepareStatement(sqlInsert);
//            ps.setString(1, model.getTenKH());
//            ps.setString(2, model.getDiaChi());
//            ps.setString(3, model.getSdt());
//            ps.executeUpdate();
//            ps.close();
//            cn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        KhachHangModel kh = new KhachHangModel();
//        KhachHang k = new KhachHang(0, "Test", "Test", "00");
//        kh.insertKhachHang(k);
//        System.out.println("Insert thanh cong");
//    }
    public KhachHangModel()
    {
        
    }
    public int insertKhachHang(KhachHang model) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;
        }

        try {
            String sql = "insert into KhachHang(TenKH, DiaChi, DienThoai) values(?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, model.getTenKH());
            ps.setString(2, model.getDiaChi());
            ps.setString(3, model.getSdt());

            kq = ps.executeUpdate(); // insert thành công trả về  1
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public int getMaKH_MoiNhat() {
        int maxMaKH = 0;
        Connection cn = new MyConnect().getcn();
        if (cn == null) {
            return -1;
        }
        try {
            String sql = "select max(maKH) from KhachHang";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maxMaKH = rs.getInt(1);
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxMaKH;
    }
}
