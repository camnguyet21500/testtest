/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author home
 */
public class SanPham {
    private int maSP;
    private String tenSP;
    private int donGia;
    private int soLuong;
    private String hinh;
    private int maDM;
    public SanPham()
    {
        
    }
    public SanPham(int maSP, String tenSP, int donGia, int soLuong, String hinh, int maDM)
    {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.hinh = hinh;
        this.maDM = maDM;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        if(donGia > 0) {
        	this.donGia = donGia;
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        if(soLuong > 0) {
        	this.soLuong = soLuong;
        }
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public int getMaDM() {
        return maDM;
    }

    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }

  
}
