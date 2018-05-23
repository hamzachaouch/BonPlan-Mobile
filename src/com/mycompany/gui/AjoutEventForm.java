/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.gui;

import com.codename1.db.Cursor;
import com.codename1.db.Row;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.spinner.Picker;
import com.mycompany.Entities.Event;
import com.codename1.l10n.ParseException;
import com.codename1.io.Log;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form; 
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.codename1.util.Base64;
import com.mycompany.Services.ServiceDeals;
import com.mycompany.Entities.Deals;
import java.util.Date;
import com.mycompany.gui.ListEvent;
import com.mycompany.Services.ServiceEvents;
import static com.mycompany.gui.ListEvent.db;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author ThinkPad
 */

public class AjoutEventForm {
    
    Form f,F2;
    Resources theme;

    TextField ttitle,tdescription,ttype,tcity,ttel,tsite,tprice,timage,tlongitude,tlatitude;
    Picker date;
    Button btnajout,btnaff,btnfavoris,upload;
    
       String fileName ;
                            Image imgg;
  

    public AjoutEventForm() {
        f = new Form("Ajouter un Evenements");
        ttitle = new TextField("", "title");
        tdescription = new TextField("", "description");

   
      ComboBox<String>ttype=new ComboBox<>();
                 ttype.addItem("Soire");
                 ttype.addItem("Voyage");
                 ttype.addItem("Randonne");   
                 ttype.addItem("Theatre");
                 ttype.addItem("Foire");  

        tcity = new TextField("", "city");
        ttel= new TextField("", "telnumber");
        tprice = new TextField("", "price");
        tsite = new TextField("", "siteUrl");
        tlongitude = new TextField("", "logitude");
        tlatitude = new TextField("", "latitude");
        timage = new TextField("", "image");
        date= new Picker();
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        btnfavoris= new Button("Favoris");
           Button upload = new Button("Upload");
        f.add(ttitle);
        f.add(tdescription);
        f.add(ttype);
        f.add(date);
        f.add(tcity);
        f.add(ttel);
        f.add(tprice);
        f.add(tsite);
        f.add(tlongitude);
        f.add(tlatitude);
        f.add(timage);
        f.add(btnajout);
        f.add(btnaff);
        f.add(btnfavoris);
        f.add(upload);
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
upload.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().openGallery(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ev) {
                        if (ev != null && ev.getSource() != null) {
                            String filePath = (String) ev.getSource();

                            int fileNameIndex = filePath.lastIndexOf("/") + 1;
                            String fileName = filePath.substring(fileNameIndex);
                            Image imgg;
                            try {
                                imgg = Image.createImage(filePath);
                                if (imgg != null) {
                                    ImageIO imgIO = ImageIO.getImageIO();
                                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                                    imgIO.save(imgg, out, ImageIO.FORMAT_JPEG, 1);
                                    byte[] ba = out.toByteArray();
                                    fileName = Base64.encode(ba);
                                    System.err.println(fileName);
                                }
                            } catch (IOException ex) {
                            }
                        }
                    }
                }, Display.GALLERY_IMAGE);

            }
        });
        btnajout.addActionListener((e) -> {
            ServiceEvents serEvents = new ServiceEvents();
            Event ev;
            ev = new Event(
                                     ttitle.getText(),
                                     tdescription.getText() ,
                                     ttype.getSelectedItem() ,
                                     date.getDate(),
                                     tcity.getText(),
                                     ( Integer.valueOf(ttel.getText())),
                                     (Float.valueOf(tprice.getText())),
                                      tsite.getText(),
                                      (Float.valueOf(tlongitude.getText())),
                                      (Float.valueOf(tlatitude.getText())),
                                     
timage.getText());

 
                                      serEvents.ajoutEvent(ev);
               
           
            

        });
        
        
         f.getToolbar().addCommandToRightBar("back", null, (ev)->{
             pageCompany h=new pageCompany();
               h.start(theme);
          });
         
        btnaff.addActionListener((e1)->{
              ListEvent a=new ListEvent();
              a.h.show();
        });
        
      
                           
 
    
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    
    
}
