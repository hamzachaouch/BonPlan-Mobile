/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

import java.util.Date;
  
/**
 *
 * @author ThinkPad
 */
public class Event {
    private int id;
    private String title;
    private String description;
    private String type;
   private Date date;
    private String city;
    private int telnumber;
    private double price;
    private String siteUrl;
    private float longitude;
    private float latitude;
    private String nom_image;
   private int id_Company;

    public Event() {
    }

    public Event(int id, String title, String description, String type, Date date, String city, int telnumber, double price, String siteUrl, float longitude, float latitude, String nom_image, int id_Company) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.date = date;
        this.city = city;
        this.telnumber = telnumber;
        this.price = price;
        this.siteUrl = siteUrl;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nom_image = nom_image;
        this.id_Company = id_Company;
    }

    public Event(int id, String title, String description, String type, Date date, String city, int telnumber, double price, String siteUrl, float longitude, float latitude, String nom_image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.date = date;
        this.city = city;
        this.telnumber = telnumber;
        this.price = price;
        this.siteUrl = siteUrl;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nom_image = nom_image;
    }


    public Event(String title, String description, String type, Date date, String city, int telnumber, double price, String siteUrl, float longitude, float latitude, String nom_image) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.date = date;
        this.city = city;
        this.telnumber = telnumber;
        this.price = price;
        this.siteUrl = siteUrl;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nom_image = nom_image;
    }

  




   

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(int telnumber) {
        this.telnumber = telnumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    public int getId_Company() {
        return id_Company;
    }

    public void setId_Company(int id_Company) {
        this.id_Company = id_Company;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", title=" + title + ", description=" + description + ", type=" + type + ", date=" + date + ", city=" + city + ", telnumber=" + telnumber + ", price=" + price + ", siteUrl=" + siteUrl + ", longitude=" + longitude + ", latitude=" + latitude + ", nom_image=" + nom_image + '}';
    }

 

   
 

   
   
    
}