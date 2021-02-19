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
public class KhachHang {
    private int maKH;
    private String tenKH;
    private String DiaChi;
    private String Sdt;

    public KhachHang() {
    }

    public KhachHang(int maKH, String tenKH, String diaChi, String sdt) {

        this.maKH = maKH;
        this.tenKH = tenKH;
        this.DiaChi = diaChi;
        this.Sdt = sdt;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        this.DiaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        this.Sdt = sdt;
    }
}
