package io.yalkaev.rahat_lokum.dto;

import java.util.Date;

public class OrderDTO {

    private String id;
    private String name;
    private String phone;
    private String type;
    private String amount;
    private Date orderdDate;


    public OrderDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getOrderdDate() {
        return orderdDate;
    }

    public void setOrderdDate(Date orderdDate) {
        this.orderdDate = orderdDate;
    }

    public OrderDTO(String title) {
        this.name = title;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }


}
