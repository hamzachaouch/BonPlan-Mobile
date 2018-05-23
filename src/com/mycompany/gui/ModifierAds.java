/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Services.ServiceAds;
import com.mycompany.Entities.Ads;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Toshiba
 */
public class ModifierAds  {
    public int AdsId;
     Form f;
    Button  btnvalider;

    public ModifierAds(int id) {
        this.AdsId = id;
    }
    
    public ModifierAds()  {
        f = new Form("Modifier publicité", BoxLayout.y());
                btnvalider=new Button("valider");
                  TextArea ttitre=new TextArea();
                     TextArea tdesc=new TextArea();
                     TextArea tville=new TextArea();

        f.add(btnvalider);
        
        ServiceAds s=new ServiceAds();
        
               Ads p = s.getAds(AdsId);

                  p.setTitre(ttitre.getText());
                p.setDescription(tdesc.getText());
               p.setVille(tville.getText());
               
               
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{
             DetailAds h=new DetailAds();
               h.getF1().show();
          });
          
          
          
               btnvalider.addActionListener(ez->{
              
                 ServiceAds sa=  new ServiceAds();
                 sa.editProduct(p); 
           });

        /*  ArrayList<Ads> ListAds = null;
        System.err.println(ListAds);
            for (Ads p : ListAds) {
            Container ctn2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            ctn2.setScrollableX(true);
            Container ctn1 = new Container( BoxLayout.x());
            ctn1.setScrollableX(true);
            Label l = new Label(p.getTitre());
           // Button rmB = new Button(fm);
           // rmB.setUIID("rmB");
        btnvalider=new Button("valider");
            btnvalider.setUIID("edB");
            ctn1.add(btnvalider);
           // ctn1.add(rmB);
            ctn1.getAllStyles().setMarginLeft(260);
            ctn2.add(l);
            ctn2.add(ctn1);
          */
          
            //Listen to edit action
//          btnvalider.addActionListener((e) ->{
//                Ads p=new Ads();
//                  ServiceAds s=  new ServiceAds();
//        s.editProduct(p);
//                
//                });
          
              
                 // f.setScrollableY(true);


    
    
    f.add(ttitre);
        f.add(tdesc);
            f.add(tville);


    f.show();
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}

    

    

