/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.Entities;

/**
 *
 * @author HP
 */
public class Company {
    private int id;
    private String login;
    private String password;  
    private String name ;
    private String description;  
    private String address;
    private String type;
    private String img_url;
    private String email;
    private int budget;
    private String ville;
    private Boolean prenium;
    private int etat;

    public Company(int id, String login, String password, String name, String description, String address, String type, String img_url, String email, int budget, String ville, Boolean prenium, int etat) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.description = description;
        this.address = address;
        this.type = type;
        this.img_url = img_url;
        this.email = email;
        this.budget = budget;
        this.ville = ville;
        this.prenium = prenium;
        this.etat = etat;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Boolean getPrenium() {
        return prenium;
    }

    public void setPrenium(Boolean prenium) {
        this.prenium = prenium;
    }

    public Company(int id, String login, String password, String name, String description, String address, String type, String img_url, String email, int budget, String ville, Boolean prenium) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.description = description;
        this.address = address;
        this.type = type;
        this.img_url = img_url;
        this.email = email;
        this.budget = budget;
        this.ville = ville;
        this.prenium = prenium;
    }

    public Company(String login, String password, String name, String description, String address, String type, String img_url, String email, int budget, String ville, Boolean prenium) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.description = description;
        this.address = address;
        this.type = type;
        this.img_url = img_url;
        this.email = email;
        this.budget = budget;
        this.ville = ville;
        this.prenium = prenium;
    }

    public Company(int id, String login, String password, String name, String description, String address, String type, String email, String ville) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.description = description;
        this.address = address;
        this.type = type;
        this.email = email;
        this.ville = ville;
    }
    

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", login=" + login + ", password=" + password + ", name=" + name + ", description=" + description + ", address=" + address + ", type=" + type + ", img_url=" + img_url + ", email=" + email + ", budget=" + budget + ", ville=" + ville + ", prenium=" + prenium + '}';
    }

 



   

  

    
   

 
    
}
