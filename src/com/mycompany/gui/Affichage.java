/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entities.Deals;
import com.mycompany.Services.ServiceDeals;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.io.IOException;

import java.util.ArrayList;


import javafx.scene.image.ImageView;

/**
 *
 * @author Hamza
 */
public class Affichage {
     ImageViewer img;
    Form f;
    Label lbTitle,price,lbPrix,description,horraire,tel;
    EncodedImage enc;
    Container t,x ,c;
    Button btnFB;
    public Affichage() {
    }
   
    public void Affichage()  {
      f = new Form("Liste deals",BoxLayout.y());
        ServiceDeals s = new ServiceDeals();
        ArrayList<Deals> list = s.getListDeals();
         
        for (Deals d : list){
        t = new Container(new BoxLayout(BoxLayout.X_AXIS));
        x = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         lbTitle = new Label();
         lbPrix = new Label();
      
        lbTitle.setText(d.getName());
        lbPrix.setText(d.getPrice()+" Dt");
            c.add(lbTitle);
            lbPrix.getAllStyles().setFgColor(0xff0000);
            c.add(lbPrix);
        
          try {
              enc = EncodedImage.create("/giphy.gif");
          } catch (IOException ex) {
          }
        //System.out.println(d.getImgUrl()); 
        Image i = (URLImage.createToStorage(enc,d.getImgUrl(),
              "http://localhost/bpPI/web/images/" +d.getImgUrl()+"",URLImage.RESIZE_SCALE));
            System.out.println("http://localhost/bpPI/web/images/" +d.getImgUrl()+"");
        ImageViewer img = new ImageViewer(i.fill(100, 100));
        x.add(img);    
        t.add(x);
        t.add(c);
        f.add(t);
        description = new Label();
        horraire = new Label();
        tel = new Label();  
        price = new Label();
        lbTitle.addPointerPressedListener(ev->{
              Form detail = new Form(d.getName(),BoxLayout.y());
                description.setText(d.getDescription());
                horraire.setText(d.getHorraire());
                tel.setText(d.getTelephone());
                price.setText(d.getPrice()+" Dt");
//              img.setHeight(200);
//              img.setWidth(200);
              Image j = (URLImage.createToStorage(enc,d.getImgUrl(),
              "http://localhost/bpPI/web/images/" +d.getImgUrl()+"",URLImage.RESIZE_SCALE));
            System.out.println("http://localhost/bpPI/web/images/" +d.getImgUrl()+"");
              ImageViewer image = new ImageViewer(i.fill(100, 100));
              detail.add(image);
              Container c = new Container(BoxLayout.x());
              c.add(new Label("prix")).add(price);
              btnFB = new Button ("Partage FB");
              detail.add(c);
              detail.add(description);
              detail.add(horraire);
              detail.add(tel);
              detail.add(btnFB);
              detail.show(); 
              
              
              
              
              
              
              btnFB.setUIID("LoginButton");
                     btnFB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                String accessToken = "EAACEdEose0cBANbZC6FTtqj0C8OZAuaPkEjGm6AebStFfViqr1FDoiexsZA5SE0MeCaPPtqp5nzSF0hZABvliMpzvxZCe4ZB0ZCrzZA1ZBBTWWGWfuZAu68H2XIZA7uaQwPqvIyJVUeuyIWcXH9KhD03cm4xDSn7HzioTfTz9aKmYhG2iVaULZAsT5D7oCZC1DgXPwr7hPj7mfwcyfAZDZD";
                FacebookClient fbClient = new DefaultFacebookClient(accessToken);
               
                   FacebookType response = fbClient.publish("me/feed", FacebookType.class,
                Parameter.with("message","Deal publié pour une date debut   "
                +d.getDateDebut().toString()+" A "+d.getDateFin().toString()+" avec un prix de   "+d.getPrice()+" TND/personne. Voici d'autre details: "
                      +"description" +  d.getDescription()));
             
                System.out.println("fb.com/"+response.getId());
                Dialog.show("Succes", "Votre Deal a été partagé sur facebook", "Fermer", null);
                
            }
        });
              
              
              
              
              
              
              
              
              
              
              
              
              
              detail.getToolbar().addCommandToRightBar("back",null,(e)->{
                  f.show();
              });

        });
           
        }
        
        f.show();
        f.getToolbar().addCommandToRightBar("back",null,(ev)->{AjoutDealForm a = new AjoutDealForm();
        a.getF().show();
        
    });
        }
}
