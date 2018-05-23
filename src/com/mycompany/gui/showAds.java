/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

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
import com.codename1.components.ImageViewer;
import com.codename1.ui.Image;


/**
 *
 * @author Toshiba
 */
public class showAds {
    
    private Form current;
    private Resources theme;
    private String fileName;
    private String filePath;
    
    
    Form f;
    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        
        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
        
    }
    
    public void start () 
    {
     
         f = new Form("Liste des publicités", BoxLayout.x());
        
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage ajouterIcon = FontImage.createMaterial(FontImage.MATERIAL_ADD, s);
        FontImage modifierIcon = FontImage.createMaterial(FontImage.MATERIAL_EDIT, s);
        FontImage afficherIcon = FontImage.createMaterial(FontImage.MATERIAL_DASHBOARD, s);
        FontImage exitIcon = FontImage.createMaterial(FontImage.MATERIAL_WARNING, s);
        Command cAjouter = new Command("Ajouter");
        Command cAfficher = new Command("Afficher");
        Command cExit = new Command("Retour vers acceuil");
        f.getToolbar().addCommandToSideMenu(cAjouter);
        f.getToolbar().addCommandToSideMenu(cAfficher);
        f.getToolbar().addCommandToSideMenu(cExit);
        
               f.getToolbar().addCommandToRightBar("back", null, et -> {
            allAdsCompany h = new allAdsCompany();
            h.getF1().show();
        });
               
               
//         f.getToolbar().addCommandToLeftBar("back", theme.getImage("back-command.png"), e->{
//              allAdsCompany h = new allAdsCompany();
//             h.getF1().show();             
//         });



        f.addCommandListener(e->{
            if(e.getCommand()==cAjouter){
               AjouterAds a=new AjouterAds();
               a.start();
           
            }
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
      ArrayList<Ads> AdsList = getAllm();
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
             
             
             
             
             
             
             /*ShareButton sb = new ShareButton();
             sb.setTextToShare("lol");
             f.add(BorderLayout.CENTER, sb);*/
        
        
        
        f.setScrollableX(true);
        
        f.show();
            
        
   
    }
    public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
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
                        me.setDateBegin(obj.get("dateBegin").toString());
                        me.setDateEnd(obj.get("dateEnd").toString());
                        me.setImgUrl(obj.get("img_url").toString());

//                        me.setType(obj.get("type").toString());
                        am.add(me);
                    }

                } catch (IOException err) {
                    Log.e(err);
                }
            }

        };
        con.setUrl("http://localhost/bpPI/web/app_dev.php/client/listJson");
        con.setPost(false);
        NetworkManager.getInstance().addToQueueAndWait(con);
        if (am == null) {
            return null;
        } else {
            return am;
        }
     }
    
    
    
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
   
}

    

