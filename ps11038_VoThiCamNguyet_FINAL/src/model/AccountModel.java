/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entities.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author home
 */
public class AccountModel {
     public AccountModel() {
    }
   
    //1. ham checkLogin
    // - input : mot tai khoan Account acc
    // - output :
    // + return -1 : ket noi khong duoc
    // + return 1 : dang nhap thanh cong
    // + reurn 0 : dang nhap that bai
    public int checkLogin(Account acc)
    {
        //1. tao 1 doi tuong ket noi
        Connection con = new MyConnect().getcn();
        if (con == null)
            return -1; // ket noi khong duoc ===> ket thuc ham luon
        
        try {
            String sql = "select * from Account where username =?  and password= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            //2. truyen vao cho hai tham so ...
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            //3. thuc thi
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return 1; // dang nhap thanh cong
            }
            else
            {
                return 0; // dang nhap that bai
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // dang nhap that bai
        }        
        
    }
    
    public ArrayList getList()
    {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn = new MyConnect().getcn();
        if(cn==null)
            return  null;
        try {
            String sql = "select * from account";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Account temp = new Account(rs.getString(1), rs.getString(2));
                list.add(temp);
            }
            ps.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public int insertAccount(Account a)
    {
        int kq=0;
        Connection cn = new MyConnect().getcn();
        if (cn==null) {
            return -1;
        }
        try {
            String sql="insert into account values(?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            kq=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    public int deleteAccount(Account a)
    {
        Connection cn = new MyConnect().getcn();
        if (cn==null) {
            return -1;
        }
        int kq=0;
        try {
            String sql ="delete from account where username=?";
            PreparedStatement ps= cn.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            kq=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
}