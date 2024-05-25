/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Order {
    private int id,status,accid;
    private Date orderDate;
    private double total;
    private ArrayList<OrderDetail> listOrder;

    public Order() {
        orderDate = new Date(System.currentTimeMillis());
        listOrder = new ArrayList<>();
    }

    public Order(int id, int status, int accid, Date orderDate, double total, ArrayList<OrderDetail> listOrder) {
        this.id = id;
        this.status = status;
        this.accid = accid;
        this.orderDate = orderDate;
        this.total = total;
        this.listOrder = listOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<OrderDetail> getListOrder() {
        return listOrder;
    }

    public void setListOrder(ArrayList<OrderDetail> listOrder) {
        this.listOrder = listOrder;
    }
    

    public boolean addOrderDetail(OrderDetail detail) {
        return listOrder.add(detail);
    }
    
}
