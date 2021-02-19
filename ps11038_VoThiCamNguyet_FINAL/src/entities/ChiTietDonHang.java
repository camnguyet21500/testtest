/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ahihi
 */
public class ChiTietDonHang {
    //4 thuộc tính 
    private int maDH;
    private int maSP;
    private int donGia;
    private int soLuong;
    public ChiTietDonHang()
    {
        
    }
    public ChiTietDonHang(int maDH, int maSP, int donGia, int soLuong)
    {
        this.maDH = maDH;
        this.maSP = maSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public int getMaDH() {
        return maDH;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
