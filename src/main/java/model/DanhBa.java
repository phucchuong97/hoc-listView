package model;

import java.io.Serializable;

public class DanhBa implements Serializable{
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public DanhBa(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
    }

    public DanhBa() {
    }

    private String ten;
    private String sdt;

}
