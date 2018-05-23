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
public class Review {
    private int id,idCompany,idClient,qualitePrix,service,satisfaction,globalMark;
    private String content,title,imgUrl;
    private Date dateOfVisit;

    public Review() {
    }

    public Review(int id, int idCompany, int idClient, int qualitePrix, int service, int satisfaction, int globalMark, String content, String title, String imgUrl, Date dateOfVisit) {
        this.id = id;
        this.idCompany = idCompany;
        this.idClient = idClient;
        this.qualitePrix = qualitePrix;
        this.service = service;
        this.satisfaction = satisfaction;
        this.globalMark = globalMark;
        this.content = content;
        this.title = title;
        this.imgUrl = imgUrl;
        this.dateOfVisit = dateOfVisit;
    }
  public Review( int idCompany, int idClient, int qualitePrix, int service, int satisfaction, int globalMark, String content, String title, String imgUrl, Date dateOfVisit) {
        this.idCompany = idCompany;
        this.idClient = idClient;
        this.qualitePrix = qualitePrix;
        this.service = service;
        this.satisfaction = satisfaction;
        this.globalMark = globalMark;
        this.content = content;
        this.title = title;
        this.imgUrl = imgUrl;
        this.dateOfVisit = dateOfVisit;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getQualitePrix() {
        return qualitePrix;
    }

    public void setQualitePrix(int qualitePrix) {
        this.qualitePrix = qualitePrix;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public int getGlobalMark() {
        return globalMark;
    }

    public void setGlobalMark(int globalMark) {
        this.globalMark = globalMark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(Date dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + id + ", idCompany=" + idCompany + ", idClient=" + idClient + ", qualitePrix=" + qualitePrix + ", service=" + service + ", satisfaction=" + satisfaction + ", globalMark=" + globalMark + ", content=" + content + ", title=" + title + ", imgUrl=" + imgUrl + ", dateOfVisit=" + dateOfVisit + '}'+'\n';
    }
    
    
    
    
}
