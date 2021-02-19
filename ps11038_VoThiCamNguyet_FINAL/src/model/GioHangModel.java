/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import entities.Item;
import entities.SanPham;
import java.util.*;
/**
 *
 * @author home
 */
public class GioHangModel {
    //1. khai báo dữ liệu
    HashMap<Integer, Item> cart; // chứa masp và món hàng mua <masp,Item>
    
    //2. constructor

    public GioHangModel() {
        cart = new HashMap<>();
    }
    //3. hàm thêm vào giỏ hàng
    public void addSanPham(int masp){
        
        //4. nếu mã sản phẩm có trong giỏ hàng thì chỉ tăng so lượng lên
        if(cart.containsKey(masp)){
            //4.1 lay Item dựa vao masp
            Item item = cart.get(masp);
            //4.2 lay so luong ra
            int count = item.getSoluong();
            //4.3 tang so luong len 1
            count = count + 1;
            //4.4 gán lại cho so luong của item
            item.setSoluong(count);
        }
        else{
            //5. bỏ vào giỏ hàng
            //6. lấy ra sản phẩm dựa vào masp
            SanPham sp = new SanPhamModel().getSanPhamByMaSP(masp);
            //7. tạo 1 doi tuong Item (SanPham, soluong=1)
            Item item = new Item(sp, 1);
            //8. thêm vào giỏ hàng <masp, Item>
            cart.put(masp, item);
        }
        
    }
    //2. hàm lay ra cac Items có trong giỏ hàng
    public ArrayList<Item> getListItems(){
        // khai bao danh sach item
        ArrayList<Item> list = new ArrayList<>();
        // duyet qua gio hang va them vao danh list
        for(Item i : cart.values()){
            // them vao danh sach
            list.add(i);
        }
        return list; // tra ve danh sach cac item co trong gio hàng
    }
    //3.bỏ 1 sản phẩm trong giỏ hàng
    public void removeSanPham(int masp)
    {
        //3.1 xóa món hàng trong giỏ hàng   
        cart.remove(masp);
    }
    //4. xóa hết giỏ hàng
    public void removeAllSanPham()
    {
        cart.clear();
    }
    public int getTongTien()
    {
        int tien=0;
        for(Item item : cart.values())
        {
            tien += (item.getSanpham().getDonGia() * item.getSoluong());
        }
        return tien;
    }
    public void tang(int masp)
    {
        int sl=cart.get(masp).getSoluong();
        sl+=1;
        cart.get(masp).setSoluong(sl);
        
    }
    public void giam(int masp)
    {
        int sl=cart.get(masp).getSoluong();
        sl=sl-1;
        
        cart.get(masp).setSoluong(sl);
        if(sl==0)
        {
            cart.remove(masp);
        }
    }
}
