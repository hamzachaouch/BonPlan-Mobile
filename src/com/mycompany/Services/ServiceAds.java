/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Services;

import com.codename1.io.CharArrayReader;
import com.mycompany.Entities.Ads;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Toshiba
 */
    
    
    
    
    
    

public class ServiceAds {

    private Form current;
    private Resources theme;
    
    ///
                Form f;
                Button rmB;
               Container ctn1;
                   private int Id;

   
                   
                   


    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }
    
    public void start() {
       
            

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
    
     public void deleteProduct(int id){
                ConnectionRequest req = new ConnectionRequest();
                
                req.setUrl("http://localhost/MobileJson/Ads/delete.php?id="+id);
                
                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });

                NetworkManager.getInstance().addToQueue(req);
            }
     
     //modifier ads
     public void editProduct(Ads p){
                ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://localhost/MobileJson/Ads/edit.php?titre=" + p.getTitre() + "&description=" + p.getDescription() + "&vile=" + p.getVille()+"&id="+p.getId());
                
                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });

                NetworkManager.getInstance().addToQueue(req);
            }
   
    public ArrayList<Ads> getList2() {
        ArrayList<Ads> listAds = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bpPI/web/app_dev.php/client/listJson");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                //l'url est type byte il faut le parser par JSONParser
                JSONParser jsonp = new JSONParser();
                
                try {
                    //on a utilisé map récupérant de json car c'est la seul qui accepte clé value
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("ad");
                    for (Map<String, Object> obj : list) {
                        Ads task = new Ads();
                        // l'id  il faut parser float net3adew b string 
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        task.setId((int) id);
                        task.setTitre(obj.get("title").toString());
                        task.setDescription(obj.get("description").toString());
                       //task.setDateBegin(obj.get("name"));
                        // task.setDateEnd(obj.get("name").toString());
                      // task.setImgUrl(obj.get("name").toString());



                        
                        listAds.add(task);
                        

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAds;
    }
    
//    
//    //get with selectAll php
//    public ArrayList<Ads> getListAll() {
//        ArrayList<Ads> listAds = new ArrayList<>();
//        ConnectionRequest con = new ConnectionRequest();
//        con.setUrl("http://localhost/MobileJson/Ads/selectAll.php");
//        con.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                //listTasks = getListTask(new String(con.getResponseData()));
//                //l'url est type byte il faut le parser par JSONParser
//                JSONParser jsonp = new JSONParser();
//                
//                try {
//                    //on a utilisé map récupérant de json car c'est la seul qui accepte clé value
//                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
//                    System.out.println(tasks);
//                    //System.out.println(tasks);
//                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("ad");
//                    for (Map<String, Object> obj : list) {
//                        Ads task = new Ads();
//                        // l'id  il faut parser float net3adew b string 
//                        float id = Float.parseFloat(obj.get("id").toString());
//                        
//                        task.setId((int) id);
//                        task.setTitre(obj.get("title").toString());
//                        task.setDescription(obj.get("description").toString());
//                       //task.setDateBegin(obj.get("name"));
//                        // task.setDateEnd(obj.get("name").toString());
//                      // task.setImgUrl(obj.get("name").toString());
//
//
//
//                        
//                        listAds.add(task);
//
//                    }
//                } catch (IOException ex) {
//                }
//
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(con);
//        return listAds;
//    }
        
//update view
    
    /*public void calculviesws(int v){
             int   res=a.getViews()+1;

    }*/
    
    public void updateViews(Ads a){
       

         ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://localhost/MobileJson/Ads/UpdateView.php?views=" +a.getViews()+"&id=" + 119);

                
                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });

                NetworkManager.getInstance().addToQueue(req);
            }
    
    
     public Ads getAds(int id ) {
        Ads am = new Ads();

        ConnectionRequest con = new ConnectionRequest() {
            protected void readResponse(InputStream in) throws IOException {
                
                 JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");
                    Map<String, Object> data = json.parseJSON(reader);
                    Map<String, Object> obj = (Map<String, Object>) data.get("ads");
 
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        am.setId((int) id);
                        am.setTitre(obj.get("titre").toString());
                        am.setDescription(obj.get("description").toString());
                       am.setVille(obj.get("ville").toString());

//                        am.setIdMember(Integer.parseInt(obj.get("idMembre").toString()));
//                        am.setPrix(Float.parseFloat(obj.get("prix").toString()));
//                        am.setDate(obj.get("dateAdd").toString());
//                        am.setImage(obj.get("imageName").toString());
//                        am.setType(obj.get("type").toString());
                    
                } catch (IOException err) {
                    Log.e(err);
                }
            }
        };
        con.setUrl("http://localhost/MobileJson/Ads/getAdsById.php?id="+id);
        con.setPost(false);
        NetworkManager.getInstance().addToQueueAndWait(con);
        return am;
    }
   }



    

