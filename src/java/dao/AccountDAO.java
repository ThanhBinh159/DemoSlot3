/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class AccountDAO {
//lay data trong bang Account
//    tra ve ArrayList<Account>
    public ArrayList<Account> getAccounts(){
        ArrayList<Account> list = new ArrayList<>();
//        B1: tao connection
        Connection conn = null;
        try {
            conn = DBUtils.makeConnection();
//            B2: viet query
            String sql = "SELECT AccId,Email,FullName,Password FROM dbo.Accounts";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
//            B3: doc data trong rs
            if(rs!=null){
                while(rs.next()){
                    int id = rs.getInt("AccId");
                    String email = rs.getString("Email");
                    String fullname = rs.getString("FullName");
                    String password = rs.getString("Password");
                    Account acc = new Account(id, email, fullname, password);
                    list.add(acc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn!= null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
//    public static void main(String[] args) {
//        AccountDAO vd = new AccountDAO();
//        ArrayList<Account> kq = vd.getAccounts();
//        for(Account a : kq){
//            System.out.println(a.toString());
//        }
//    }
}
