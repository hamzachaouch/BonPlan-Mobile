/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

import java.util.Date;





/**
 *
 * @author Hamza
 */
public class Deals {
    private int id,price,nbrClients,note,idCompany;
    private String name,description,address,categorie,imgUrl,programme,telephone,horraire;
    private Date dateDebut,dateFin;
    private String datedebu,datefin;

    public Deals(int price,int note, String name,
            String description, String address, String categorie,String imgUrl,
            String programme, String telephone, String horraire, String datedebu, String datefin) {
        this.price = price;
        this.note = note;
        this.idCompany = idCompany;
        this.imgUrl = imgUrl;
  
        this.name = name;
        this.description = description;
        this.address = address;
        this.categorie = categorie;
        this.programme = programme;
        this.telephone = telephone;
        this.horraire = horraire;
        this.datedebu = datedebu;
        this.datefin = datefin;
    }
    public Deals(int id, int price, int nbrClients, int note, int idCompany, String name, String description, String address, String categorie, String imgUrl, String programme, String telephone, String horraire, String datedeb, String datefin) {
        this.id = id;
        this.price = price;
        this.nbrClients = nbrClients;
        this.note = note;
        this.idCompany = idCompany;
        this.name = name;
        this.description = description;
        this.address = address;
        this.categorie = categorie;
        this.imgUrl = imgUrl;
        this.programme = programme;
        this.telephone = telephone;
        this.horraire = horraire;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
     public Deals( int price, String name, String description, String address, String imgUrl, String programme, String telephone, String horraire, Date dateDebut, Date dateFin) {
        
        this.price = price;
        this.name = name;
        this.description = description;
        this.address = address;
        this.imgUrl = imgUrl;
        this.programme = programme;
        this.telephone = telephone;
        this.horraire = horraire;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
       public Deals( int price, String name, String description, String address,String cat, String imgUrl, String programme, String telephone, String horraire, Date dateDebut, Date dateFin) {
        
        this.price = price;
        this.name = name;
        this.description = description;
        this.address = address;
        this.categorie = categorie;
        
        this.imgUrl = imgUrl;
        this.programme = programme;
        this.telephone = telephone;
        this.horraire = horraire;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    public Deals() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNbrClients() {
        return nbrClients;
    }

    public void setNbrClients(int nbrClients) {
        this.nbrClients = nbrClients;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHorraire() {
        return horraire;
    }

    public void setHorraire(String horraire) {
        this.horraire = horraire;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDatedebu() {
        return datedebu;
    }

    public void setDatedebu(String datedebu) {
        this.datedebu = datedebu;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }
    
    
    
    @Override
    public String toString() {
        return "Deals{" + "id=" + id + ", price=" + price + ", nbrClients=" + nbrClients + ", note=" + note + ", idCompany=" + idCompany + ", name=" + name + ", description=" + description + ", address=" + address + ", categorie=" + categorie + ", imgUrl=" + imgUrl + ", programme=" + programme + ", telephone=" + telephone + ", horraire=" + horraire + ", dateDebut=" + datedebu + ", dateFin=" +
                datefin + '}'+'\n';
    }

    
    
}
