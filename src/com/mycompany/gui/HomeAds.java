/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Services.ServiceAds;
import com.mycompany.Entities.Ads;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Toshiba
 */
public class HomeAds {
    
    private Form current;
    private Resources theme;
    
    
   // Form f1;
    Form f;
        Button btndetail;
        SpanLabel lb;

        
        
        
            public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
        lb = new SpanLabel("");
 
        ServiceAds serviceTask=new ServiceAds();
        ArrayList<Ads> lis=serviceTask.getList2();
        lb.setText(lis.toString());
                    
                    
    }
            
            
//             public void start() {
//        if (current != null) {
//            current.show();
//            return;
//        }
//        f1=new Form("Affichage tous les publicités");
//
//                    btndetail = new Button("detail");
//
//                   
//                    
//                    
//                    
//                     btndetail.addActionListener((e) ->{
//                         Ads a=new Ads();
//                  ServiceAds s=  new ServiceAds();
//        s.updateViews(a);
//                
//                });
//                    
//                    
//                           
//f1.add(btndetail);
//f1.show();
//    
//
//        
//        
//}
            //***********************************************************************
            
            
    public void start() 
    {
     
         f = new Form("Liste des publicités", BoxLayout.x());
        
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage ajouterIcon = FontImage.createMaterial(FontImage.MATERIAL_ADD, s);
        FontImage modifierIcon = FontImage.createMaterial(FontImage.MATERIAL_EDIT, s);
        FontImage afficherIcon = FontImage.createMaterial(FontImage.MATERIAL_DASHBOARD, s);
        FontImage exitIcon = FontImage.createMaterial(FontImage.MATERIAL_WARNING, s);
        Command cAjouter = new Command("Ajouter");
        Command cModifier = new Command("Modifier / Supprimer");
        Command cAfficher = new Command("Afficher");
        Command cExit = new Command("Retour vers acceuil");
        f.getToolbar().addCommandToSideMenu(cAjouter);
        f.getToolbar().addCommandToSideMenu(cModifier);
        f.getToolbar().addCommandToSideMenu(cAfficher);
        f.getToolbar().addCommandToSideMenu(cExit);

        f.addCommandListener(e->{
//            if(e.getCommand()==cAjouter){
//                new EventApplication().start(theme);
//           
//            }
//            if(e.getCommand()==cModifier){
//                try {
//                    new editEvents().start();
//                } catch (IOException ex) {
//                }
//            }
            if(e.getCommand()==cAfficher){
              
                    new showAds().start();
                
            }
//            if(e.getCommand()==cExit){
//                
//            HomeAds l = new HomeAds();
//            l.getF1().show();
//            
//        
//            }
        });
      ArrayList<Ads> productsList = getAllm();
        int mm = Display.getInstance().convertToPixels(3);
        final EncodedImage placeholder = EncodedImage.createFromImage(
        FontImage.createMaterial(FontImage.MATERIAL_SYNC, new Style()).
                scaled(300, 300), false);

        String[] listdesproduits = new String[productsList.size()];
        com.codename1.ui.List myList = new com.codename1.ui.List();
        for (int i = 0; i < productsList.size(); i++) {
      //  listdesproduits[i] = productsList.get(i).getImage();
        }
  
       // MyListModelEvent model = new MyListModelEvent(listdesproduits);
        int ii=0;
        
            
            
        Container ctn2 = new Container();
        for (Ads p : productsList) {
             ctn2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            
           // Image im = model.getItemAtt(ii, p.getImage());
           // ImageViewer v = new ImageViewer(im);
         //   ctn2.add(v);
            ctn2.add(new Label(p.getTitre()));
            Button moreInfo = new Button("More");
            ctn2.add(moreInfo);
            f.addComponent(ctn2);
            ii++;
            
//             moreInfo.addActionListener(e -> {
//                 try {
//                     new showEvent(p.getId(),p.getType()).start();
//                 } catch (IOException ex) {
//                 }
//            });
             
             /*ShareButton sb = new ShareButton();
             sb.setTextToShare("lol");
             f.add(BorderLayout.CENTER, sb);*/
        }
        
        
        f.setScrollableX(true);
        
        f.show();
            
        
   
    }
             
public Form getF() {
        return f;
    }

//    public Form getF1() {
//        return f1;
//    }
//
//    public void setF1(Form f1) {
//        this.f1 = f1;
//    }
    public void setF(Form f) {
        this.f = f;
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }

    public void destroy() {
    }
    
    
    
     
     public ArrayList<Ads> getAllm() {
        ArrayList<Ads> am = new ArrayList<>();

        ConnectionRequest con = new ConnectionRequest() {
            @Override
            protected void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");
                    Map<String, Object> data = json.parseJSON(reader);
                    ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) data.get("ad");
                    am.clear();

                    for (Map<String, Object> obj : list) {
                        Ads me = new Ads();
                        
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                    
                       
                        
                      //  me.setId(Integer.parseInt(obj.get("id").toString()));
                          
                        
                        me.setId((int) id);
                       me.setTitre(obj.get("title").toString());
                        me.setDescription(obj.get("description").toString());
                        
                       // me.setIdMember(Integer.parseInt(obj.get("idMembre").toString()));
//                        me.setPrix(Float.parseFloat(obj.get("prix").toString()));
//                        me.setDate(obj.get("dateAdd").toString());
//                        me.setImage(obj.get("imageName").toString());
//                        me.setType(obj.get("type").toString());
                        am.add(me);
                    }

                } catch (IOException err) {
                    Log.e(err);
                }
            }

        };
        con.setUrl("http://localhost/bonplan1/web/app_dev.php/client/listJson");
        con.setPost(false);
        NetworkManager.getInstance().addToQueueAndWait(con);
        if (am == null) {
            return null;
        } else {
            return am;
        }
    }
}

