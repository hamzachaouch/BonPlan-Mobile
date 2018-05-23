/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.googlemaps.MapContainer;
import com.codename1.io.FileSystemStorage;
import com.codename1.maps.Coord;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entities.Deals;
import com.mycompany.Entities.Event;
import com.mycompany.Services.ServiceDeals;
import com.mycompany.Services.ServiceEvents;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;






/**
 *
 * @author hessine
 */
class ListEvent {
    static Form h,F2;
    Form fs,fr,ff,ft,fv,hs,f;
    SpanLabel lb;
    Button btnMap,btnSoire,btnVoyage,btnFoire,btnTheatre,btnRandonne,btnenregistre,btnfavoris,btnall;
    MultiButton mb,mb1;
   
    static Database db ;
    boolean created =false;
      private static final String MAPS_KEY = "AIzaSyAcF6rl0tnRZB26Y2BKuBJF_1d7qDeGvoY"; 
          ImageViewer img;
   
    Label lbTitle,price,lbPrix,description,horraire,tel,site;
    EncodedImage enc;
    Container t,x ,c;


    public ListEvent() {

        btnFoire=new Button("Foire");
        btnVoyage= new Button("Voyage");
        btnSoire=new Button ("Soire");
        btnTheatre =new Button("Theatre");
        btnRandonne=new Button ("Randonne");
        btnMap= new  Button("Maps");
        btnenregistre=new Button("Enregistrer");
        btnfavoris = new Button("Favoris");
       // btnall= new Button("all");
        
        
        created = Database.exists("3a13");
            
        try {
            db = Database.openOrCreate("3a13");
            
             if(created == false)
                db.execute("create table evenement "
                 + "(id INTEGER, title TEXT, city TEXT );");
        
        } catch (IOException ex) {
            
        }
           

    
    
    h = new Form("Liste Evenements",BoxLayout.y());
    
        h.add(btnSoire);
        h.add(btnVoyage);
        h.add(btnRandonne);
        h.add(btnTheatre);
        h.add(btnFoire);
     //  h.add(btnall);
        
         h.getToolbar().addCommandToRightBar("favoris", null, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        Form F2 = new Form("List",BoxLayout.y());
                        Cursor c1 =
                         db.executeQuery("select * from evenement");
                        while (c1.next()) {
                            Row r = c1.getRow();
                            String title = r.getString(1);
                           
                            
                            Label l = new Label(title + " : ");
                            F2.add(l);
                             }
                        
                        F2.show();
                    

                          
                      
                    } catch (IOException ex) {
                    }
                    
               
                
                }
          
        });
         
           f.getToolbar().addCommandToRightBar("back", null, (evkk)->{
             AjoutEventForm h=new AjoutEventForm();
               h.getF().show();
          });
                           
          btnSoire.addActionListener((e6)->{
            f = new Form("Liste Evenements",BoxLayout.y());
        ServiceEvents s = new ServiceEvents();
        ArrayList<Event> list = s.getListSoire();
         
        for (Event e : list){
        t = new Container(new BoxLayout(BoxLayout.X_AXIS));
        x = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         lbTitle = new Label();
          lbPrix = new Label();
           lbPrix.getAllStyles().setFgColor(0xff0000);
             lbPrix.setText(e.getPrice()+" Dt");
            c.add(lbPrix);
        lbTitle.setText(e.getTitle());
        c.add(lbTitle);
      
        
          try {
              enc = EncodedImage.create("/giphy.gif");
          } catch (IOException ex) {
          }
        //System.out.println(d.getImgUrl()); 
        Image i = (URLImage.createToStorage(enc,e.getNom_image(),
              "http://localhost/bpPI/web/images/" +e.getNom_image()+"",URLImage.RESIZE_SCALE));
            System.out.println("http://localhost/bpPI/web/images/" +e.getNom_image()+"");
        ImageViewer img = new ImageViewer(i.fill(100, 100));
         x.add(img);    
        t.add(x);
        t.add(c);
        f.add(t);
       description = new Label();
       tel = new Label();
       price = new Label();
       site = new Label();
        lbTitle.addPointerPressedListener(ev->{
              Form detail = new Form(e.getTitle(),BoxLayout.y());
                
                description.setText(e.getDescription());
                price.setText(e.getPrice()+" Dt");
                tel.setText(e.getTelnumber()+"");
                site.setText(e.getSiteUrl());
                detail.add(btnenregistre);
               
                      
          
//              img.setHeight(200);
//              img.setWidth(200);
              Image j = (URLImage.createToStorage(enc,e.getNom_image(),
              "http://localhost/bpPI/web/images/" +e.getNom_image()+"",URLImage.RESIZE_SCALE));
            System.out.println("http://localhost/bpPI/web/images/" +e.getNom_image()+"");
              ImageViewer image = new ImageViewer(i.fill(500, 300));
              detail.add(image);
              Container c = new Container(BoxLayout.x());
              c.add(new Label("prix")).add(price);
                 
              detail.add(c);
              
              detail.add(new Label("description :")).add(description);
                            Container c2 = new Container(BoxLayout.x());
              c2.add(new Label("Site")).add(site);
                 
              detail.add(c2);
             //detail.add(site);
                            Container c3 = new Container(BoxLayout.x());
              c3.add(new Label("Tel:")).add(tel);
                 
              detail.add(c3);
              
               /*
                         Style s8 = new Style();
                 s8.setFgColor(0xFF7F50);
                 s8.setBgTransparency(0);
                            // System.out.println(e.getLatitude()+"      "+e.getLongitude());
                 FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s8, Display.getInstance().convertToPixels(1));
               MapContainer cn = new MapContainer();
               Coord c1= new Coord(e.getLatitude(), e.getLongitude());
               cn.zoom(c1, 15);
            
                cn.setCameraPosition(c1); // since the image is iin the jar this is unlikely
                cn.addMarker(EncodedImage.createFromImage(markerImg, false), c1, "Hi marker", "Optional long description", new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Dialog.show("Marker Clicked!", "You clicked the marker", "OK", null);
                    }
                });
                           
                               
        
                                   
                    
       ;
       detail.add(cn);
                 */
              
                         try {
                        db.execute("insert into evenement (title,city )"
                                + " values ('"+e.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                  btnenregistre.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+e.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                }
                                
         
  
         ;
                
          });
                               detail.getToolbar().addCommandToLeftBar("Back",null,evv->{f.show();});

  detail.show();
             
             
              //detail.add(tel);
              detail.show(); 
           //  detail.getToolbar().addCommandToRightBar("back",null,(e9)->{f.
                  /******
            
                   ********/
              });

      
       
       
                
       

         
      
           
        }
         f.getToolbar().addCommandToLeftBar("Back",null,ev->{h.show();});
            
        
        f.show();
    
  });
        
         btnRandonne.addActionListener((e6)->{
            f = new Form("Liste Evenements",BoxLayout.y());
        ServiceEvents s = new ServiceEvents();
        ArrayList<Event> list = s.getListRandonee();
         
        for (Event e : list){
        t = new Container(new BoxLayout(BoxLayout.X_AXIS));
        x = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         lbTitle = new Label();
          lbPrix = new Label();
           lbPrix.getAllStyles().setFgColor(0xff0000);
             lbPrix.setText(e.getPrice()+" Dt");
            c.add(lbPrix);
        lbTitle.setText(e.getTitle());
        c.add(lbTitle);
      
        
          try {
              enc = EncodedImage.create("/giphy.gif");
          } catch (IOException ex) {
          }
        //System.out.println(d.getImgUrl()); 
        Image i = (URLImage.createToStorage(enc,e.getNom_image(),
              "http://localhost/bpPI/web/images/" +e.getNom_image()+"",URLImage.RESIZE_SCALE));
            System.out.println("http://localhost/bpPI/web/images/" +e.getNom_image()+"");
        ImageViewer img = new ImageViewer(i.fill(100, 100));
         x.add(img);    
        t.add(x);
        t.add(c);
        f.add(t);
       description = new Label();
       tel = new Label();
       price = new Label();
       site = new Label();
        lbTitle.addPointerPressedListener(ev->{
              Form detail = new Form(e.getTitle(),BoxLayout.y());
                
                description.setText(e.getDescription());
                price.setText(e.getPrice()+" Dt");
                tel.setText(e.getTelnumber()+"");
                site.setText(e.getSiteUrl());
                detail.add(btnenregistre);
               
                      
          
//              img.setHeight(200);
//              img.setWidth(200);
              Image j = (URLImage.createToStorage(enc,e.getNom_image(),
              "http://localhost/bpPI/web/images/" +e.getNom_image()+"",URLImage.RESIZE_SCALE));
            System.out.println("http://localhost/bpPI/web/images/" +e.getNom_image()+"");
              ImageViewer image = new ImageViewer(i.fill(500, 300));
              detail.add(image);
              Container c = new Container(BoxLayout.x());
              c.add(new Label("prix")).add(price);
                 
              detail.add(c);
              
              detail.add(new Label("description :")).add(description);
                            Container c2 = new Container(BoxLayout.x());
              c2.add(new Label("Site")).add(site);
                 
              detail.add(c2);
             //detail.add(site);
                            Container c3 = new Container(BoxLayout.x());
              c3.add(new Label("Tel:")).add(tel);
                 
              detail.add(c3);
              
               
                         Style s8 = new Style();
                 s8.setFgColor(0xFF7F50);
                 s8.setBgTransparency(0);
                            // System.out.println(e.getLatitude()+"      "+e.getLongitude());
                 FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s8, Display.getInstance().convertToPixels(1));
               MapContainer cn = new MapContainer();
               Coord c1= new Coord(e.getLatitude(), e.getLongitude());
               cn.zoom(c1, 15);
            
                cn.setCameraPosition(c1); // since the image is iin the jar this is unlikely
                cn.addMarker(EncodedImage.createFromImage(markerImg, false), c1, "Hi marker", "Optional long description", new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Dialog.show("Marker Clicked!", "You clicked the marker", "OK", null);
                    }
                });
                           
                               
        
                                   
                    
       ;
       detail.add(cn);
                 
              
                         try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+e.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                  btnenregistre.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+e.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                }
                                
         
  
         ;
                
          });
                               detail.getToolbar().addCommandToLeftBar("Back",null,evv->{f.show();});

  detail.show();
             
             
              //detail.add(tel);
              detail.show(); 
           //  detail.getToolbar().addCommandToRightBar("back",null,(e9)->{f.
                  /******
            
                   ********/
              });

      
       
       
                
       

         
      
           
        }
         f.getToolbar().addCommandToLeftBar("Back",null,ev->{h.show();});
            
        
        f.show();
    
  });
         
         
           btnVoyage.addActionListener((e6)->{
            f = new Form("Liste Evenements",BoxLayout.y());
        ServiceEvents s = new ServiceEvents();
        ArrayList<Event> list = s.getListVoyage();
         
        for (Event e : list){
        t = new Container(new BoxLayout(BoxLayout.X_AXIS));
        x = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         lbTitle = new Label();
          lbPrix = new Label();
           lbPrix.getAllStyles().setFgColor(0xff0000);
             lbPrix.setText(e.getPrice()+" Dt");
            c.add(lbPrix);
        lbTitle.setText(e.getTitle());
        c.add(lbTitle);
      
        
          try {
              enc = EncodedImage.create("/giphy.gif");
          } catch (IOException ex) {
          }
        //System.out.println(d.getImgUrl()); 
        Image i = (URLImage.createToStorage(enc,e.getNom_image(),
              "http://localhost/bpPI/web/images/" +e.getNom_image()+"",URLImage.RESIZE_SCALE));
            System.out.println("http://localhost/bpPI/web/images/" +e.getNom_image()+"");
        ImageViewer img = new ImageViewer(i.fill(100, 100));
         x.add(img);    
        t.add(x);
        t.add(c);
        f.add(t);
       description = new Label();
       tel = new Label();
       price = new Label();
       site = new Label();
        lbTitle.addPointerPressedListener(ev->{
              Form detail = new Form(e.getTitle(),BoxLayout.y());
                
                description.setText(e.getDescription());
                price.setText(e.getPrice()+" Dt");
                tel.setText(e.getTelnumber()+"");
                site.setText(e.getSiteUrl());
                detail.add(btnenregistre);
               
                      
          
//              img.setHeight(200);
//              img.setWidth(200);
              Image j = (URLImage.createToStorage(enc,e.getNom_image(),
              "http://localhost/bpPI/web/images/" +e.getNom_image()+"",URLImage.RESIZE_SCALE));
            System.out.println("http://localhost/bpPI/web/images/" +e.getNom_image()+"");
              ImageViewer image = new ImageViewer(i.fill(500, 300));
              detail.add(image);
              Container c = new Container(BoxLayout.x());
              c.add(new Label("prix")).add(price);
                 
              detail.add(c);
              
              detail.add(new Label("description :")).add(description);
                            Container c2 = new Container(BoxLayout.x());
              c2.add(new Label("Site")).add(site);
                 
              detail.add(c2);
             //detail.add(site);
                            Container c3 = new Container(BoxLayout.x());
              c3.add(new Label("Tel:")).add(tel);
                 
              detail.add(c3);
              
              /*
                         Style s8 = new Style();
                 s8.setFgColor(0xFF7F50);
                 s8.setBgTransparency(0);
                            // System.out.println(e.getLatitude()+"      "+e.getLongitude());
                 FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s8, Display.getInstance().convertToPixels(1));
               MapContainer cn = new MapContainer();
               Coord c1= new Coord(e.getLatitude(), e.getLongitude());
               cn.zoom(c1, 15);
            
                cn.setCameraPosition(c1); // since the image is iin the jar this is unlikely
                cn.addMarker(EncodedImage.createFromImage(markerImg, false), c1, "Hi marker", "Optional long description", new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Dialog.show("Marker Clicked!", "You clicked the marker", "OK", null);
                    }
                });
                           
                               
        
                                   
                    
       ;
       detail.add(cn);
                 
              */
                         try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+e.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                  btnenregistre.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+e.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                }
                                
         
  
         ;
                
          });
                               detail.getToolbar().addCommandToLeftBar("Back",null,evv->{f.show();});

  detail.show();
             
             
              //detail.add(tel);
              detail.show(); 
           //  detail.getToolbar().addCommandToRightBar("back",null,(e9)->{f.
                  /******
            
                   ********/
              });     
        }
         f.getToolbar().addCommandToLeftBar("Back",null,ev->{h.show();});
            
        
        f.show();
    
  });
           
                      btnTheatre.addActionListener((e6)->{
            f = new Form("Liste Evenements",BoxLayout.y());
        ServiceEvents s = new ServiceEvents();
        ArrayList<Event> list = s.getListThratre();
         
        for (Event e : list){
        t = new Container(new BoxLayout(BoxLayout.X_AXIS));
        x = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         lbTitle = new Label();
          lbPrix = new Label();
           lbPrix.getAllStyles().setFgColor(0xff0000);
             lbPrix.setText(e.getPrice()+" Dt");
            c.add(lbPrix);
        lbTitle.setText(e.getTitle());
        c.add(lbTitle);
      
        
          try {
              enc = EncodedImage.create("/giphy.gif");
          } catch (IOException ex) {
          }
        //System.out.println(d.getImgUrl()); 
        Image i = (URLImage.createToStorage(enc,e.getNom_image(),
              "http://localhost/bpPI/web/images/" +e.getNom_image()+"",URLImage.RESIZE_SCALE));
            System.out.println("http://localhost/bpPI/web/images/" +e.getNom_image()+"");
        ImageViewer img = new ImageViewer(i.fill(100, 100));
         x.add(img);    
        t.add(x);
        t.add(c);
        f.add(t);
       description = new Label();
       tel = new Label();
       price = new Label();
       site = new Label();
        lbTitle.addPointerPressedListener(ev->{
              Form detail = new Form(e.getTitle(),BoxLayout.y());
                
                description.setText(e.getDescription());
                price.setText(e.getPrice()+" Dt");
                tel.setText(e.getTelnumber()+"");
                site.setText(e.getSiteUrl());
                detail.add(btnenregistre);
               
                      
          
//              img.setHeight(200);
//              img.setWidth(200);
              Image j = (URLImage.createToStorage(enc,e.getNom_image(),
              "http://localhost/bpPI/web/images/" +e.getNom_image()+"",URLImage.RESIZE_SCALE));
            System.out.println("http://localhost/bpPI/web/images/" +e.getNom_image()+"");
              ImageViewer image = new ImageViewer(i.fill(500, 300));
              detail.add(image);
              Container c = new Container(BoxLayout.x());
              c.add(new Label("prix")).add(price);
                 
              detail.add(c);
              
              detail.add(new Label("description :")).add(description);
                            Container c2 = new Container(BoxLayout.x());
              c2.add(new Label("Site")).add(site);
                 
              detail.add(c2);
             //detail.add(site);
                            Container c3 = new Container(BoxLayout.x());
              c3.add(new Label("Tel:")).add(tel);
                 
              detail.add(c3);
              
               /*
                         Style s8 = new Style();
                 s8.setFgColor(0xFF7F50);
                 s8.setBgTransparency(0);
                            // System.out.println(e.getLatitude()+"      "+e.getLongitude());
                 FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s8, Display.getInstance().convertToPixels(1));
               MapContainer cn = new MapContainer();
               Coord c1= new Coord(e.getLatitude(), e.getLongitude());
               cn.zoom(c1, 15);
            
                cn.setCameraPosition(c1); // since the image is iin the jar this is unlikely
                cn.addMarker(EncodedImage.createFromImage(markerImg, false), c1, "Hi marker", "Optional long description", new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Dialog.show("Marker Clicked!", "You clicked the marker", "OK", null);
                    }
                });
                           
                               
        
                                   
                    
       ;
       detail.add(cn);
                 */
              
                         try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+e.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                  btnenregistre.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+e.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                }
                                
         
  
         ;
                
          });
                               detail.getToolbar().addCommandToLeftBar("Back",null,evv->{f.show();});

  detail.show();
             
             
              //detail.add(tel);
              detail.show(); 
           //  detail.getToolbar().addCommandToRightBar("back",null,(e9)->{f.
                  /******
            
                   ********/
              });     
        }
         f.getToolbar().addCommandToLeftBar("Back",null,ev->{h.show();});
            
        
        f.show();
    
  });
                      
                      
 btnFoire.addActionListener((e6)->{
            f = new Form("Liste Evenements",BoxLayout.y());
        ServiceEvents s = new ServiceEvents();
        ArrayList<Event> list = s.getListFoire();
         
        for (Event e : list){
        t = new Container(new BoxLayout(BoxLayout.X_AXIS));
        x = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         lbTitle = new Label();
          lbPrix = new Label();
           lbPrix.getAllStyles().setFgColor(0xff0000);
             lbPrix.setText(e.getPrice()+" Dt");
            c.add(lbPrix);
        lbTitle.setText(e.getTitle());
        c.add(lbTitle);
      
        
          try {
              enc = EncodedImage.create("/giphy.gif");
          } catch (IOException ex) {
          }
        //System.out.println(d.getImgUrl()); 
        Image i = (URLImage.createToStorage(enc,e.getNom_image(),
              "http://localhost/bpPI/web/images/" +e.getNom_image()+"",URLImage.RESIZE_SCALE));
            System.out.println("http://localhost/bpPI/web/images/" +e.getNom_image()+"");
        ImageViewer img = new ImageViewer(i.fill(100, 100));
         x.add(img);    
        t.add(x);
        t.add(c);
        f.add(t);
       description = new Label();
       tel = new Label();
       price = new Label();
       site = new Label();
        lbTitle.addPointerPressedListener(ev->{
              Form detail = new Form(e.getTitle(),BoxLayout.y());
                
                description.setText(e.getDescription());
                price.setText(e.getPrice()+" Dt");
                tel.setText(e.getTelnumber()+"");
                site.setText(e.getSiteUrl());
                detail.add(btnenregistre);
               
                      
          
//              img.setHeight(200);
//              img.setWidth(200);
              Image j = (URLImage.createToStorage(enc,e.getNom_image(),
              "http://localhost/bpPI/web/images/" +e.getNom_image()+"",URLImage.RESIZE_SCALE));
            System.out.println("http://localhost/bpPI/web/images/" +e.getNom_image()+"");
              ImageViewer image = new ImageViewer(i.fill(500, 300));
              detail.add(image);
              Container c = new Container(BoxLayout.x());
              c.add(new Label("prix")).add(price);
                 
              detail.add(c);
              
              detail.add(new Label("description :")).add(description);
                            Container c2 = new Container(BoxLayout.x());
              c2.add(new Label("Site")).add(site);
                 
              detail.add(c2);
             //detail.add(site);
                            Container c3 = new Container(BoxLayout.x());
              c3.add(new Label("Tel:")).add(tel);
                 
              detail.add(c3);
              
               /*
                         Style s8 = new Style();
                 s8.setFgColor(0xFF7F50);
                 s8.setBgTransparency(0);
                            // System.out.println(e.getLatitude()+"      "+e.getLongitude());
                 FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s8, Display.getInstance().convertToPixels(1));
               MapContainer cn = new MapContainer();
               Coord c1= new Coord(e.getLatitude(), e.getLongitude());
               cn.zoom(c1, 15);
            
                cn.setCameraPosition(c1); // since the image is iin the jar this is unlikely
                cn.addMarker(EncodedImage.createFromImage(markerImg, false), c1, "Hi marker", "Optional long description", new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Dialog.show("Marker Clicked!", "You clicked the marker", "OK", null);
                    }
                });
                           
                               
        
                                   
                    
       ;
       detail.add(cn);
                 
              */
                         try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+e.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                  btnenregistre.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+e.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                }
                                
         
  
         ;
                
          });
                               detail.getToolbar().addCommandToLeftBar("Back",null,evv->{f.show();});

  detail.show();
             
             
              //detail.add(tel);
              detail.show(); 
           //  detail.getToolbar().addCommandToRightBar("back",null,(e9)->{f.
                  /******
            
                   ********/
              });     
        }
         f.getToolbar().addCommandToLeftBar("Back",null,ev->{h.show();});
            
        
        f.show();
    
  });
       /* 
        btnSoire.addActionListener((e1)->{
            
        
             //  ServiceEvents ss =  new ServiceEvents();
      //         ArrayList<Event> listsoire = ss.getListSoire();
        //       fs = new Form("Soirée",BoxLayout.y());
           //    for (Event t : listsoire){
         //      Container c1 = new Container(BoxLayout.y());
       //   mb = new MultiButton(t.getDescription());
     //  Container c2 = new Container(BoxLayout.x());
       //        Label l = new Label(t.getNom_image());
   //           mb = new MultiButton(t.getNom_image());
         
                  
 // mb.setTextLine1(t.getTitle());
       //   mb.setTextLine2(t.getNom_image());
       //   mb.setTextLine3(t.getCity());
    
         
         // Label l = new Label(t.getTitle());
        

       //       c1.add(l);
     //         c1.add(mb);
   // fs.add(c1);
                        // l.addPointerPressedListener(d1-> {
        // mb.addPointerPressedListener(f-> {
                        // Form f2 =new Form("Details",BoxLayout.y());
                         // mb1 = new MultiButton();
                      
          //  mb1.setTextLine2(t.getTitle());
           // mb1.setTextLine3(t.getDescription());
          //  mb1.setTextLine4(t.getCity());
          //  mb1.setTextLine1(t.getType());
                        
                       Label l2 = new Label(t.getDescription()) ;
                         Label l3 = new Label (t.getCity());
                         Label l4 = new Label(t.getCity());
                      
                         
                         f2.add(l3);
                         f2.add(l2);
                         f2.add(l4);
                         
                    
                         Style s = new Style();
                 s.setFgColor(0xFF7F50);
                 s.setBgTransparency(0);
                             System.out.println(t.getLatitude()+"      "+t.getLongitude());
                 FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, Display.getInstance().convertToPixels(1));
               MapContainer cn = new MapContainer();
               Coord c= new Coord(t.getLatitude(), t.getLongitude());
               cn.zoom(c, 15);
            
                cn.setCameraPosition(c); // since the image is iin the jar this is unlikely
                cn.addMarker(EncodedImage.createFromImage(markerImg, false), c, "Hi marker", "Optional long description", new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Dialog.show("Marker Clicked!", "You clicked the marker", "OK", null);
                    }
                });
                           
                               
        
                                   
                    
       ;
                          btnenregistre=new Button("Enregistrer");
                         f2.add(btnMap);
                         
                         
                         f2.add(btnenregistre);
                         f2.add(cn);
                        // f2.add(btnfavoris);
                         
            
               
                         try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+t.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                  btnenregistre.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+t.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                }
            });
           
              
                f2.getToolbar().addCommandToLeftBar("Back",null,ev->{fs.show();});

  f2.show();
          });
                        c1.setLeadComponent(l);
      // c1.setLeadComponent(mb);
                        fs.getToolbar().addCommandToLeftBar("Back",null,ev->{h.show();});
            }
         
  fs.show();
        });
       
       
        btnRandonne.addActionListener((e2)->{
                ServiceEvents sr =  new ServiceEvents();
                ArrayList<Event> listrandone = sr.getListRandonee();
                fr = new Form("Randoné",BoxLayout.y());
                for (Event t : listrandone){
                Container c1 = new Container(BoxLayout.x());
                Label l = new Label(t.getTitle());
                 mb = new MultiButton(t.getDescription());
                 c1.add(mb);
                c1.add(l);
                fr.add(c1);
                l.addPointerPressedListener(d2-> {
                Form f2 =new Form("Details",BoxLayout.y());
                Label l2 = new Label(t.getDescription()) ;
                Label l3 = new Label (t.getCity());
               
                      
                btnenregistre=new Button("Enregistrer");
                         btnenregistre.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+t.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                }
            });
                
                f2.add(l2);
                f2.add(l3);
                f2.add(btnMap);
                
                         Style s = new Style();
                 s.setFgColor(0xFF7F50);
                 s.setBgTransparency(0);
                             System.out.println(t.getLatitude()+"      "+t.getLongitude());
                 FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, Display.getInstance().convertToPixels(1));
               MapContainer cn = new MapContainer();
               Coord c= new Coord(t.getLatitude(), t.getLongitude());
               cn.zoom(c, 15);
            
                cn.setCameraPosition(c); // since the image is iin the jar this is unlikely
                cn.addMarker(EncodedImage.createFromImage(markerImg, false), c, "Hi marker", "Optional long description", new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Dialog.show("Marker Clicked!", "You clicked the marker", "OK", null);
                    }
                });
                f2.add(cn);
               f2.add(btnenregistre);
               f2.getToolbar().addCommandToLeftBar("Back",null,ev->{fr.show();});
f2.show();
               });
              c1.setLeadComponent(l);
               fr.getToolbar().addCommandToLeftBar("Back",null,ev->{h.show();});
            }
             
fr.show();
        });
        
        
        
        
        
       
         btnVoyage.addActionListener((e3)->{
               ServiceEvents sv =  new ServiceEvents();
        ArrayList<Event> listvoyage = sv.getListVoyage();
    
      fv = new Form("Voyage",BoxLayout.y());
 
          for (Event t : listvoyage){
          Container c1 = new Container(BoxLayout.x());
       //  ImageViewer img = new ImageViewer((t.getNom_image()));
        
    
          Label l = new Label(t.getTitle());
           mb = new MultiButton(t.getDescription());
        

        c1.add(l);
        c1.add(mb);
           fv.add(c1);
           l.addPointerPressedListener(d3-> {
           Form f2 =new Form("Details",BoxLayout.y());
          
           Label l2 = new Label(t.getDescription()) ;
           Label l3 = new Label (t.getCity());
           btnMap= new  Button("Maps");
           btnenregistre=new Button("Enregistrer");
         btnenregistre.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+t.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                }
            });
   
      
     
                
                f2.add(l2);
               f2.add(l3);
               f2.add(btnMap);
               
                         Style s = new Style();
                 s.setFgColor(0xFF7F50);
                 s.setBgTransparency(0);
                             System.out.println(t.getLatitude()+"      "+t.getLongitude());
                 FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, Display.getInstance().convertToPixels(1));
               MapContainer cn = new MapContainer();
               Coord c= new Coord(t.getLatitude(), t.getLongitude());
               cn.zoom(c, 15);
            
                cn.setCameraPosition(c); // since the image is iin the jar this is unlikely
                cn.addMarker(EncodedImage.createFromImage(markerImg, false), c, "Hi marker", "Optional long description", new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Dialog.show("Marker Clicked!", "You clicked the marker", "OK", null);
                    }
                });
                f2.add(cn);
            
               f2.add(btnenregistre);
                f2.getToolbar().addCommandToLeftBar("Back",null,ev->{fv.show();});

          f2.show();
          });
        c1.setLeadComponent(l);
               fv.getToolbar().addCommandToLeftBar("Back",null,ev->{h.show();});

         
 
            }
             
          fv.show();
        });
       
          btnTheatre.addActionListener((e4)->{
              ServiceEvents st =  new ServiceEvents();
        ArrayList<Event> listheatre = st.getListThratre();
    
      ft = new Form("Théatre",BoxLayout.y());
 
          for (Event t : listheatre){
          Container c1 = new Container(BoxLayout.x());
       //  ImageViewer img = new ImageViewer((t.getNom_image()));
        
         
          Label l = new Label(t.getTitle());
         mb = new MultiButton(t.getDescription());

        c1.add(l);
        c1.add(mb);
           ft.add(c1);
           l.addPointerPressedListener(d4-> {
           Form f2 =new Form("Details",BoxLayout.y());
          
   Label l2 = new Label(t.getDescription()) ;
   Label l3 = new Label (t.getCity());
    btnMap= new  Button("Maps");
    btnenregistre=new Button("Enregistrer");

            btnenregistre.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+t.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                }
            });
      
     
                
                f2.add(l2);
               f2.add(l3);
               f2.add(btnMap);
               
                         Style s = new Style();
                 s.setFgColor(0xFF7F50);
                 s.setBgTransparency(0);
                             System.out.println(t.getLatitude()+"      "+t.getLongitude());
                 FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, Display.getInstance().convertToPixels(1));
               MapContainer cn = new MapContainer();
               Coord c= new Coord(t.getLatitude(), t.getLongitude());
               cn.zoom(c, 15);
            
                cn.setCameraPosition(c); // since the image is iin the jar this is unlikely
                cn.addMarker(EncodedImage.createFromImage(markerImg, false), c, "Hi marker", "Optional long description", new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Dialog.show("Marker Clicked!", "You clicked the marker", "OK", null);
                    }
                });
                f2.add(cn);
             
               f2.add(btnenregistre);
                        btnenregistre.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+t.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                }
            });
                f2.getToolbar().addCommandToLeftBar("Back",null,ev->{ft.show();});

          f2.show();
          });
        c1.setLeadComponent(l);
               ft.getToolbar().addCommandToLeftBar("Back",null,ev->{h.show();});

         
 
            }
             
          ft.show();
        });
          
           btnFoire.addActionListener((e5)->{
               ServiceEvents sf =  new ServiceEvents();
        ArrayList<Event> listfoire = sf.getListFoire();
    
      ff = new Form("Foire",BoxLayout.y());
 
          for (Event t : listfoire){
          Container c1 = new Container(BoxLayout.x());
       //  ImageViewer img = new ImageViewer((t.getNom_image()));
        
         
          Label l = new Label(t.getTitle());
         mb = new MultiButton(t.getDescription());

        c1.add(l);
        c1.add(mb);
           ff.add(c1);
           l.addPointerPressedListener(d5-> {
           Form f2 =new Form("Details",BoxLayout.y());
          
   Label l2 = new Label(t.getDescription()) ;
   Label l3 = new Label (t.getCity());
 btnMap= new  Button("Maps");
 btnenregistre=new Button("Enregistrer");
   
               btnenregistre.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        db.execute("insert into evenement (title )"
                                + " values ('"+t.getTitle()+"')");
                        System.out.println("Ajout OK");
                        
                    } catch (IOException ex) {
                     }
                }
            });
     
                
                f2.add(l2);
               f2.add(l3);
               f2.add(btnMap);
          
                         Style s = new Style();
                 s.setFgColor(0xFF7F50);
                 s.setBgTransparency(0);
                             System.out.println(t.getLatitude()+"      "+t.getLongitude());
                 FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, Display.getInstance().convertToPixels(1));
               MapContainer cn = new MapContainer();
               Coord c= new Coord(t.getLatitude(), t.getLongitude());
               cn.zoom(c, 15);
            
                cn.setCameraPosition(c); // since the image is iin the jar this is unlikely
                cn.addMarker(EncodedImage.createFromImage(markerImg, false), c, "Hi marker", "Optional long description", new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Dialog.show("Marker Clicked!", "You clicked the marker", "OK", null);
                    }
                });
                f2.add(cn);
               f2.add(btnenregistre);
                f2.getToolbar().addCommandToLeftBar("Back",null,ev->{ff.show();});

          f2.show();
          });
        c1.setLeadComponent(l);
               ff.getToolbar().addCommandToLeftBar("Back",null,ev->{h.show();});

         
 
            }
             
          ff.show();
        });

         /* for (Event t : list){
          Container c1 = new Container(BoxLayout.x());
       //  ImageViewer img = new ImageViewer((t.getNom_image()));
        
         
          Label l = new Label(t.getTitle());
        

        c1.add(l);
           h.add(c1);
           l.addPointerPressedListener(f-> {
           Form f2 =new Form("Details",BoxLayout.y());
          
   Label l2 = new Label(t.getDescription()) ;
   Label l3 = new Label (t.getCity());

   
      
     
                
                f2.add(l2);
               f2.add(l3);
                f2.getToolbar().addCommandToLeftBar("Back",null,ev->{h.show();});

          f2.show();
          });
        c1.setLeadComponent(l);
     // h.getToolbar().addCommandToRightBar("back",null,(ev)->{AjoutEventForm a = new AjoutEventForm();
         
          }      
*/    
         
    }

    public static Form getF2() {
        return F2;
    }

    public static void setF2(Form F2) {
        ListEvent.F2 = F2;
    }

    public static Form getH() {
        return h;
    }

    public static void setH(Form h) {
        ListEvent.h = h;
    }
    
}
    
        
 
         
                 
    
  
        
                 