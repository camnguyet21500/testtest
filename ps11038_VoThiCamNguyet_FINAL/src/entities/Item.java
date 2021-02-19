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
public class Item {
    //1. khai báo du liệu (Item : món hàng bạn chọn mua)
    SanPham sanpham;
    int soluong;
    //constructor

    public Item() {
    }

    public Item(SanPham sanpham, int soluong) {
        this.sanpham = sanpham;
        this.soluong = soluong;
    }
    
    //getter - setter

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
}
