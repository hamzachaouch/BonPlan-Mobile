/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

import java.util.Date;




/**
 *
 * @author Seif Bejaoui
 */
public class Ads {
    public int id;
 //public  Date dateBegin;
  // public  Date dateEnd;
        public  String status;

     public  String dateBegin;
     public  String dateEnd;
    public int views;
    public int publicitePayee;
    public String  titre;
    public String imgUrl;
    public String  description;
    public String  ville;
    public int companyId;

    public Ads()
    {
    }
    
    //cons à 3 para titre descp et ville
    
    public Ads(String titre,String description, String ville) {
       
        this.titre = titre;
        this.description = description;
        this.ville = ville;
    }
    
    
    
  /* public Ads(String titre, String ville, String imgUrl, String description, Date dateBegin, Date dateEnd, String status,int companyId){
        this.titre = titre;
        this.ville = ville;
        this.imgUrl = imgUrl;
        this.description = description;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.status = status;
        this.companyId = companyId;
    }

      public Ads(Date dateBegin, Date dateEnd, String titre, String imgUrl, String description, String ville) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.titre = titre;
        this.imgUrl = imgUrl;
        this.description = description;
        this.ville = ville;
    }
*/
    
    
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    
    
    /*  public Ads(int id, Date dateBegin, Date dateEnd, String status, int views, int publicitePayee, String titre, String imgUrl, String description, String ville) {
        this.id = id;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.status = status;
        this.views = views;
        this.publicitePayee = publicitePayee;
        this.titre = titre;
        this.imgUrl = imgUrl;
        this.description = description;
        this.ville = ville;
    }
    
    

    public Ads(Date dateBegin, Date dateEnd, String titre, String description, String ville) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.titre = titre;
        this.description = description;
        this.ville = ville;
    }

    public Ads(Date dateBegin, Date dateEnd, String status, int views, int publicitePayee, String titre, String imgUrl, String description, String ville) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.status = status;
        this.views = views;
        this.publicitePayee = publicitePayee;
        this.titre = titre;
        this.imgUrl = imgUrl;
        this.description = description;
        this.ville = ville;
    }
*/
    //constr sans les dates
    
      public Ads(String status, int views, int publicitePayee, String titre, String imgUrl, String description, String ville) {
        
        this.status = status;
        this.views = views;
        this.publicitePayee = publicitePayee;
        this.titre = titre;
        this.imgUrl = imgUrl;
        this.description = description;
        this.ville = ville;
    }

    public Ads(int id, String titre, String description, String ville) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.ville = ville;
    }

    public Ads(String dateBegin, String dateEnd, String titre, String description, String ville) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.titre = titre;
        this.description = description;
        this.ville = ville;
    }
      
      
      

    //constr pour les 5 dernier sans date

    public Ads(int publicitePayee, String titre, String imgUrl, String description, String ville) {
        this.publicitePayee = publicitePayee;
        this.titre = titre;
        this.imgUrl = imgUrl;
        this.description = description;
        this.ville = ville;
    }
      
      
    public Ads(String titre, String imgUrl, String description, String ville) {
        this.titre = titre;
        this.imgUrl = imgUrl;
        this.description = description;
        this.ville = ville;
    }

    public Ads(String dateBegin, String dateEnd, String titre, String imgUrl, String description, String ville) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.titre = titre;
        this.imgUrl = imgUrl;
        this.description = description;
        this.ville = ville;
    }
    
    

    
    public Ads(String titre){
                this.titre = titre;

        
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 /*  public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getPublicitePayee() {
        return publicitePayee;
    }

    public void setPublicitePayee(int publicitePayee) {
        this.publicitePayee = publicitePayee;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    
    @Override
    public String toString() {
        return "Ads{" + "id=" + id + ", status=" + status + ", views=" + views + ", publicitePayee=" + publicitePayee + ", titre=" + titre + ", imgUrl=" + imgUrl + ", description=" + description + ", ville=" + ville + ", companyId=" + companyId + '}';
    }

    
}