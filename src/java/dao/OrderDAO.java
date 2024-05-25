/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import dto.Order;
import dto.OrderDetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class OrderDAO {
//    ham nay de lay order va orderdetail
//    theo status
    public ArrayList<Order> getAllOrder(int status){
        ArrayList<Order> list = new ArrayList<>();
//        B1: tao connection
        Connection conn = null;
        try {
            conn = DBUtils.makeConnection();
//            B2: viet query
            String sql = "select [OrderID],[OrderDate],[Status],[Total],[AccID] \n" +
                            "  from [dbo].[Orders]\n" +
                            "  where [Status]=?\n" +
                            "  Order by [OrderDate] desc";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, status);
            ResultSet rs = pst.executeQuery();
//            B3: doc data trong rs
            if(rs!=null){
                while(rs.next()){
                    Order ord = new Order();
                    int orderid = rs.getInt("OrderID");
                    Date date = rs.getDate("OrderDate");
                    double total = rs.getDouble("Total");
                    int accid = rs.getInt("AccID");
//                    gan gia tri
                    ord.setId(orderid);
                    ord.setOrderDate(date);
                    ord.setStatus(status);
                    ord.setAccid(accid);
                    ord.setTotal(total);
//                    lay orderDetail
                    String sql2 = "select [DetailID],[ItemID],[OrderID],[Quantity]\n" +
                                    "  from [dbo].[OrderDetails]\n" +
                                    "  where [OrderID]=?";
                    PreparedStatement pst2 = conn.prepareStatement(sql2);
                    pst2.setInt(1, orderid);
                    ResultSet rs2 = pst2.executeQuery();
                    if(rs2 != null){
                        while(rs2.next()){
                            int detailid = rs2.getInt("DetailID");
                            int itemid = rs2.getInt("ItemID");
                            int quantity = rs2.getInt("Quantity");
                            OrderDetail detail = new OrderDetail(detailid, orderid, itemid, quantity);
                            ord.addOrderDetail(detail);
                        }
                    }
                    list.add(ord);
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
}
