/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
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
public class showByAdsByCompany {
        private int CompanyCourant=4;

    public void start() throws IOException {
        Form f = new Form("Modifier les produits", BoxLayout.y());
        
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage ajouterIcon = FontImage.createMaterial(FontImage.MATERIAL_ADD, s);
        FontImage modifierIcon = FontImage.createMaterial(FontImage.MATERIAL_EDIT, s);
        FontImage afficherIcon = FontImage.createMaterial(FontImage.MATERIAL_DASHBOARD, s);
        FontImage exitIcon = FontImage.createMaterial(FontImage.MATERIAL_WARNING, s);
        Command cAjouter = new Command("Ajouter");
        Command cModifier = new Command("Modifier / Supprimer");
        Command cAfficher = new Command("Afficher");
        Command cExit = new Command("Exit");
        f.getToolbar().addCommandToSideMenu(cAjouter);
        f.getToolbar().addCommandToSideMenu(cModifier);
        f.getToolbar().addCommandToSideMenu(cAfficher);
        f.getToolbar().addCommandToSideMenu(cExit);
      //  ArrayList<Ads> AdsList = getOwnAdsByCompany(CompanyCourant);
       // System.err.println("yesssssssss"+AdsList);
        
               ArrayList<Ads> AdsList = getOwnAdsByCompany(CompanyCourant);
         int mm = Display.getInstance().convertToPixels(3);
        final EncodedImage placeholder = EncodedImage.createFromImage(
        FontImage.createMaterial(FontImage.MATERIAL_SYNC, new Style()).
                scaled(300, 300), false);

        String[] tabAds = new String[AdsList.size()];
        com.codename1.ui.List myList = new com.codename1.ui.List();
        for (int i = 0; i < AdsList.size(); i++) {
      tabAds[i] = AdsList.get(i).getImgUrl();
        }
  
        MyListModelAds model = new MyListModelAds(tabAds);
        int ii=0;
        
            
            
        Container ctn2 = new Container();
        for (Ads p : AdsList) {
             ctn2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            
            Image im = model.getItemAtt(ii, p.getImgUrl());
           ImageViewer v = new ImageViewer(im);
          ctn2.add(v);
            ctn2.add(new Label(p.getTitre()));
            Button moreInfo = new Button("More");
            ctn2.add(moreInfo);
            f.addComponent(ctn2);
            ii++;
            
            

             moreInfo.addActionListener(e -> {
                 Button supp =new Button("Supprimer");
                 Button mod =new Button("modifier");
                 Form Fmore=new Form("Details", BoxLayout.y());
                 Container co= new Container(new BoxLayout(BoxLayout.Y_AXIS));
                     co.add(new Label("Titre :"+p.getTitre()));
          co.add(new Label("Description :" + p.getDescription()));
         co.add(new Label("date début  :" +p.getDateBegin()));
          co.add(new Label("date fin :" +p.getDateEnd()));
          
       
          Fmore.add(co); 
          Fmore.add(supp);
          Fmore.add(mod);
                     supp.addActionListener((x) ->{
                  ServiceAds sa=  new ServiceAds();
                  sa.deleteProduct(p.getId());
                  showAds sh=new showAds();
                  sh.start();
                
                });
                     
                   
                     
//                       mod.addActionListener(ez->{
//                p.setTitre(ttitre.getText());
//                p.setDescription(tdesc.getText());
//                p.setDescription(tville.getText());
//                 ServiceAds sa=  new ServiceAds();
//                  sa.editProduct(p); 
//                });
                     
                     
                          mod.addActionListener((y) -> {
//                 ServiceAds sa=  new ServiceAds();
//                  sa.editProduct(p);       
                 ModifierAds h=new ModifierAds();
                      h.getF().show();


   });
                    
          
          
            Fmore.getToolbar().addCommandToRightBar("back", null, (ev)->{
                showAds h=new showAds();
                h.start();
           });
              
                Fmore.show(); 
          });
         

        }
       
       
       
        f.setScrollableY(true);
         f.show();
        }
    
       public ArrayList<Ads> getOwnAdsByCompany(int id) {
        ArrayList<Ads> am = new ArrayList<>();

        ConnectionRequest con = new ConnectionRequest() {
            @Override
            protected void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");
                    Map<String, Object> data = json.parseJSON(reader);
                    ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) data.get("ads");
       
                    am.clear();

                    for (Map<String, Object> obj : list) {
                        Ads me = new Ads();
                        me.setId(Integer.parseInt(obj.get("id").toString()));
                        me.setTitre(obj.get("titre").toString());
                        me.setDescription(obj.get("description").toString());
                     //   me.setIdMember(Integer.parseInt(obj.get("idMembre").toString()));
                      //  me.setPrix(Float.parseFloat(obj.get("prix").toString()));
                       // me.setDate(obj.get("dateAdd").toString());
                        me.setImgUrl(obj.get("img_url").toString());
                       // me.setType(obj.get("type").toString());
                        am.add(me);
                    }

                } catch (IOException err) {
                    Log.e(err);
                }
            }

        };
         
        con.setUrl("http://localhost/MobileJson/Ads/getOwnAdsByCompany.php?id="+id);
        con.setPost(false);
        NetworkManager.getInstance().addToQueueAndWait(con);
        if (am == null) {
            return null;
        } else {
            return am;
            
        }
    }

    
    
    
    
    
    
    
    
                
    
//       public ArrayList<Ads> getOwnAdsByCompany(int id) {
//        ArrayList<Ads> am = new ArrayList<>();
//
//        ConnectionRequest con = new ConnectionRequest();
//            
//                    con.setUrl("http://localhost/MobileJson/Ads/getOwnAdsByCompanyId.php?id="+id);
//
//            
//                    con.addResponseListener(new ActionListener<NetworkEvent>() {
//
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//
//                JSONParser json = new JSONParser();
//                
//                    //Reader reader = new InputStreamReader(in, "UTF-8");
//                    try{
//           Map<String, Object> data = json.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
//
//                    //Map<String, Object> data = json.parseJSON(reader);
//                    ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) data.get("ads");
//       
//                    //am.clear();
//
//                    for (Map<String, Object> obj : list) {
//                        Ads me = new Ads();
//                        me.setId(Integer.parseInt(obj.get("id").toString()));
//                        me.setTitre(obj.get("titre").toString());
//                        me.setDescription(obj.get("description").toString());
//                        me.setVille(obj.get("ville").toString());
//                    //    me.set(Integer.parseInt(obj.get("companyId").toString()));
//                        /*me.setPrix(Float.parseFloat(obj.get("prix").toString()));
//                        me.setDate(obj.get("dateAdd").toString());
//                        me.setImage(obj.get("imageName").toString());
//                        me.setType(obj.get("type").toString());*/
//                        am.add(me);
//                  }
//                    }catch (IOException ex) {
//                }
//            }
//            
//
//            });
//         
//      // con.setPost(false);
//      NetworkManager.getInstance().addToQueueAndWait(con);
//        return am ;
//    }

    
    
}