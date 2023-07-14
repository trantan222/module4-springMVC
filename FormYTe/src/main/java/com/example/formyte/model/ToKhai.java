package com.example.formyte.model;

import java.util.Date;

public class ToKhai {
    private String name;
    private int yearDate;
    private int gender;
    private String country;
    private int Id_card;
    private String vehicle;
    private String num_vehicle;
    private String num_seat;
    private Date start_day;
    private Date end_day;
    private String bonus_context;
    private String province;
    private String district;
    private String wards;
    private String address;
    private String phone;
    private String email;
    private String symptom;
    private String lich_su_phoi_nhiem;

    public ToKhai(String name, int yearDate, int gender, String country, int id_card, String vehicle, String num_vehicle, String num_seat, Date start_day, Date end_day, String bonus_context, String province, String district, String wards, String address, String phone, String email, String symptom, String lich_su_phoi_nhiem) {
        this.name = name;
        this.yearDate = yearDate;
        this.gender = gender;
        this.country = country;
        Id_card = id_card;
        this.vehicle = vehicle;
        this.num_vehicle = num_vehicle;
        this.num_seat = num_seat;
        this.start_day = start_day;
        this.end_day = end_day;
        this.bonus_context = bonus_context;
        this.province = province;
        this.district = district;
        this.wards = wards;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptom = symptom;
        this.lich_su_phoi_nhiem = lich_su_phoi_nhiem;
    }

    public ToKhai() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearDate() {
        return yearDate;
    }

    public void setYearDate(int yearDate) {
        this.yearDate = yearDate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId_card() {
        return Id_card;
    }

    public void setId_card(int id_card) {
        Id_card = id_card;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNum_vehicle() {
        return num_vehicle;
    }

    public void setNum_vehicle(String num_vehicle) {
        this.num_vehicle = num_vehicle;
    }

    public String getNum_seat() {
        return num_seat;
    }

    public void setNum_seat(String num_seat) {
        this.num_seat = num_seat;
    }

    public Date getStart_day() {
        return start_day;
    }

    public void setStart_day(Date start_day) {
        this.start_day = start_day;
    }

    public Date getEnd_day() {
        return end_day;
    }

    public void setEnd_day(Date end_day) {
        this.end_day = end_day;
    }

    public String getBonus_context() {
        return bonus_context;
    }

    public void setBonus_context(String bonus_context) {
        this.bonus_context = bonus_context;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWards() {
        return wards;
    }

    public void setWards(String wards) {
        this.wards = wards;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getLich_su_phoi_nhiem() {
        return lich_su_phoi_nhiem;
    }

    public void setLich_su_phoi_nhiem(String lich_su_phoi_nhiem) {
        this.lich_su_phoi_nhiem = lich_su_phoi_nhiem;
    }
}
