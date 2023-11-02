package com.example.apiexample.model;

import java.io.Serializable;

public class User implements Serializable {

    // The "easy" fields.  These are all just text
    private String gender;
    private String email;
    private String phone;
    private String cell;
    private String nat;



    private Picture picture;
    private Name name;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName().getTitle());
        sb.append(" ");
        sb.append(getName().getFirst());
        sb.append(" ");
        sb.append(getName().getLast());
        return sb.toString();
    }

    public Name getName() {
        return name;
    }

    private void setName(Name name){
        this.name = name;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

}