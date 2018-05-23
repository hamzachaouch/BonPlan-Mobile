/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.capture.Capture;
import com.codename1.io.Log;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.Services.ServiceDeals;
import com.mycompany.Entities.Deals;
import java.io.IOException;
import java.util.Date;
import rest.file.uploader.tn.FileUploader;



/**
 *
 * @author sana
 */
public class  AjoutDealForm {
        private Resources theme;

    Form f;
      String d2,d1,imgPath,fileNameInServer;
    TextField tname,tdescription,taddress,tcategorie,timgUrl,tprogramme,ttel,thorraire,tnbrclients,tnote,tidcompany,tprice;
    Picker cdeb,cfin;
    Button btnUp,btnajout,btnaff;

    public AjoutDealForm() {
        f = new Form("Ajouter un Deal");
        tname = new TextField("", "name");
        taddress = new TextField("", "address");
        tcategorie = new TextField("", "catégorie");
        thorraire = new TextField("", "horraire");
        //timgUrl = new TextField("", "image");
        tnote = new TextField("", "note");
        tdescription = new TextField("", "description");
        tprice = new TextField("", "prix");
        tprogramme = new TextField("", "programme");
        ttel = new TextField("", "+21600000000");
        tnbrclients = new TextField("", "nbr clients");
        tidcompany = new TextField("", "id company");
        cdeb= new Picker();
        cfin= new Picker();
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        btnUp=new Button("Upload");
        
        Validator val =new Validator();
val.addConstraint(tname, new LengthConstraint(2));
val.addConstraint(tdescription, new LengthConstraint(4));
val.addConstraint(taddress, new LengthConstraint(2));
val.addConstraint(ttel, new LengthConstraint(8));
val.addConstraint(tprice, new LengthConstraint(1));
val.addConstraint(thorraire, new LengthConstraint(1));
val.addConstraint(tprogramme, new LengthConstraint(1));

        f.add(tname);
        f.add(taddress);
        f.add(tcategorie);
        f.add(thorraire);
        f.add(btnUp);
       // f.add(timgUrl);
        f.add(tnote);
        f.add(tdescription);
        f.add(tprice);
        f.add(tprogramme);
        f.add(tidcompany);
        f.add(ttel);
        f.add(cdeb);
        f.add(cfin);
        f.add(tnbrclients);
        f.add(btnajout);
        f.add(btnaff);
       // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        btnUp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        System.out.println("hamzma");
                        imgPath = Capture.capturePhoto();
                        System.out.println(imgPath);
                        String link = imgPath.toString();
                        int pod= link.indexOf("/", 2);
                        String news = link.substring(pod+2, link.length());
                        System.out.println(""+news);
      FileUploader fu = new FileUploader("http://localhost/bpPI/web/");
        //Upload
        fileNameInServer = fu.upload(news);
                        System.out.println("-----------"+fileNameInServer+"---------------");
         } catch (IOException ex) {
                          ex.printStackTrace();
                    } catch (Exception ex) {
                    }
                }
            });

            f.getToolbar().addCommandToRightBar("back", null, (ev)->{
             pageCompany h=new pageCompany();
               h.start(theme);
          });
       
        btnajout.addActionListener((e) -> {
            ServiceDeals ser = new ServiceDeals();
            Deals d;
          
            
            SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                  String datedebu = formater.format(cdeb.getDate());
                  String datefin = formater.format(cfin.getDate());
            
            
            
            
            
            
            
            
            
            d = new Deals(Integer.parseInt(tprice.getText()), 0, tname.getText(),tdescription.getText() ,  taddress.getText(),tcategorie.getText(), fileNameInServer , tprogramme.getText(), ttel.getText(),thorraire.getText(), datedebu ,datefin);
            System.out.println(d);
              ser.ajoutDeal(d);
        });
       
        
        btnaff.addActionListener((e)->{
              Affichage a;
              a = new Affichage();
              a.Affichage();
              
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

   
 

}
