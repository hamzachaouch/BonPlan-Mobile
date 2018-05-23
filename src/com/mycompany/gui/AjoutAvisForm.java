/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.Entities.Deals;
import com.mycompany.Entities.Review;
import com.mycompany.Services.ServiceDeals;
import com.mycompany.Services.ServiceReview;
import com.mycompany.gui.StarRating;
import java.io.IOException;


/**
 *
 * @author Hamza
 */
public class AjoutAvisForm {
    
    Form f;
    TextField ttitle,tcontent,timg,tidcompany,tidclient;
    StarRating qp,satisfaction,service,globale;
    Picker date;
    Button btnajout,btnaff;
    Label sqp , 
            ssatisfaction
        ,sservice
        ,sglobale;
    Slider sliderQP,sliderGlob,sliderSatisf,sliderServ;    
    public AjoutAvisForm() {
        f = new Form("Ajouter un Avis");
        ttitle = new TextField("", "title");
        tcontent = new TextField("", "content");
        timg = new TextField("", "imgUrl");
        qp =new StarRating();
        satisfaction=new StarRating();
        service=new StarRating();
        globale=new StarRating();
        tidcompany = new TextField("", "id company");
        tidclient = new TextField("", "id client");
     
        date= new Picker();
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        
        
                Validator val =new Validator();
                val.addConstraint(ttitle, new LengthConstraint(2));
                val.addConstraint(tcontent, new LengthConstraint(2));


        f.add(ttitle);
        f.add(tcontent);
        f.add(timg);
     
        sliderGlob=globale.showStarPickingForm();
        f.add(new Label("Note Globale"));
        f.add(sliderGlob);
        sglobale = new Label();
        sliderGlob.addActionListener(ev ->{
            sglobale.setText(sliderGlob.getProgress()+"");
         });
        f.add(sglobale);
        /******/
        ssatisfaction = new Label();
        sliderSatisf=satisfaction.showStarPickingForm();
        f.add(new Label("Note Satisfaction"));
        
        f.add(sliderSatisf);
        
        sliderSatisf.addActionListener(ev ->{
            ssatisfaction.setText(sliderSatisf.getProgress()+"");
         });
        f.add(ssatisfaction);
 /******/
        sservice = new Label();
        sliderServ=service.showStarPickingForm();
        f.add(new Label("Note Service"));
        
        f.add(sliderServ);
        sservice = new Label();
        sliderServ.addActionListener(ev ->{
            sservice.setText(sliderServ.getProgress()+"");
         });
        f.add(sservice);
 /******/
        sqp = new Label();
        sliderQP=qp.showStarPickingForm();
        f.add(new Label("Note Qualité/Prix"));
        
        f.add(sliderQP);
        sqp = new Label();
        sliderQP.addActionListener(ev ->{
            sqp.setText(sliderQP.getProgress()+"");
         });
        f.add(sqp);
 
        
      
        f.add(date);
        f.add(tidclient);
        f.add(tidcompany);
        f.add(btnajout);
        f.add(btnaff);
        
// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       

        btnajout.addActionListener((ActionEvent e) -> {
            ServiceReview ser = new ServiceReview();
            Review d;
           
            d= new Review(Integer.parseInt(tidcompany.getText()),
                          Integer.parseInt(tidclient.getText()),
                          Integer.parseInt(sqp.getText()),
                          Integer.parseInt( sservice.getText()),
                          Integer.parseInt( ssatisfaction.getText()),
                          Integer.parseInt( sglobale.getText()) ,
                          tcontent.getText(),ttitle.getText(),timg.getText(),date.getDate());
            
               ser.ajoutReview(d);
               
           
            

        });
        btnaff.addActionListener((e)->{
              Affichage a;
              a = new Affichage();
              a.f.show();
              
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

   
 
}
