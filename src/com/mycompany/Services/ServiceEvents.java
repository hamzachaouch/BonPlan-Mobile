/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entities.Deals;
import com.mycompany.Entities.Event;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ThinkPad
 */
public class ServiceEvents {
     public void ajoutEvent(Event e1) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/bpPIDEV/web/app_dev.php/client/ajoutAPI?"
                + "title="+ e1.getTitle()
                + "&description=" + e1.getDescription()
                + "&type="+ e1.getType()
                + "&ville=" + e1.getCity()
                + "&tel=" + e1.getTelnumber()
                + "&price=" + e1.getPrice()
                + "&site=" + e1.getSiteUrl()
                + "&dateDebut=" +e1.getDate()
           
                + "&l1=" + e1.getLongitude()
                + "&la1=" + e1.getLatitude()
                + "&nom_image=" + e1.getNom_image();
         
        
        con.setUrl(Url);
        System.out.println("Connexion");
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
    }
    

   public ArrayList<Event> getListEvents() {
        ArrayList<Event> listEvents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bpPIDEV/web/app_dev.php/client/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // listDeals = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(events);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Event e = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                        String im = obj.get("nomImage").toString();
                        System.out.println(im);
                       e.setNom_image(im);
                       
                        e.setId((int) id);
                        
                        e.setDescription(obj.get("description").toString());
                        e.setTitle(obj.get("title").toString());
                       // e.setNom_image(obj.get("nomImage").toString());
               
                        listEvents.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
   
    public ArrayList<Event> getListSoire() {
        ArrayList<Event> listEvents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bpPI/web/app_dev.php/event/soireM");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // listDeals = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(events);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Event e = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                         float lan = Float.parseFloat(obj.get("latitude").toString());
                          float loge = Float.parseFloat(obj.get("longitude").toString());
                           float Price = Float.parseFloat(obj.get("price").toString());
                           float tel = Float.parseFloat(obj.get("telnumber").toString());
                           System.out.println(tel);
                              String im = obj.get("nomImage").toString();
                        System.out.println(im);
                       e.setNom_image(im);
                           e.setPrice(Price);
                        e.setTelnumber((int)tel);
                   
                        e.setId((int) id);
                        e.setLatitude(lan);
                        e.setLongitude(loge);
                       
                        e.setDescription(obj.get("description").toString());
                        e.setTitle(obj.get("title").toString());
                        e.setSiteUrl(obj.get("siteUrl").toString());
                        listEvents.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
    
    
    
     public ArrayList<Event> getListVoyage(){
        ArrayList<Event> listEvents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bpPI/web/app_dev.php/event/voyageM");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // listDeals = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(events);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Event e = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                         float lan = Float.parseFloat(obj.get("latitude").toString());
                          float loge = Float.parseFloat(obj.get("longitude").toString());
                           float Price = Float.parseFloat(obj.get("price").toString());
                           float tel = Float.parseFloat(obj.get("telnumber").toString());
                           System.out.println(tel);
                              String im = obj.get("nomImage").toString();
                        System.out.println(im);
                       e.setNom_image(im);
                           e.setPrice(Price);
                        e.setTelnumber((int)tel);
                   
                        e.setId((int) id);
                        e.setLatitude(lan);
                        e.setLongitude(loge);
                       
                        e.setDescription(obj.get("description").toString());
                        e.setTitle(obj.get("title").toString());
                        e.setSiteUrl(obj.get("siteUrl").toString());
                        listEvents.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
     
     
      public ArrayList<Event> getListRandonee() {
        ArrayList<Event> listEvents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bpPI/web/app_dev.php/event/randoneM");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // listDeals = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(events);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Event e = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                         float lan = Float.parseFloat(obj.get("latitude").toString());
                          float loge = Float.parseFloat(obj.get("longitude").toString());
                           float Price = Float.parseFloat(obj.get("price").toString());
                           float tel = Float.parseFloat(obj.get("telnumber").toString());
                           System.out.println(tel);
                              String im = obj.get("nomImage").toString();
                        System.out.println(im);
                       e.setNom_image(im);
                           e.setPrice(Price);
                        e.setTelnumber((int)tel);
                   
                        e.setId((int) id);
                        e.setLatitude(lan);
                        e.setLongitude(loge);
                       
                        e.setDescription(obj.get("description").toString());
                        e.setTitle(obj.get("title").toString());
                        e.setSiteUrl(obj.get("siteUrl").toString());
                        listEvents.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
      
      
       public ArrayList<Event> getListThratre() {
        ArrayList<Event> listEvents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bpPI/web/app_dev.php/event/theatreM");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // listDeals = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(events);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Event e = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                         float lan = Float.parseFloat(obj.get("latitude").toString());
                          float loge = Float.parseFloat(obj.get("longitude").toString());
                           float Price = Float.parseFloat(obj.get("price").toString());
                           float tel = Float.parseFloat(obj.get("telnumber").toString());
                           System.out.println(tel);
                              String im = obj.get("nomImage").toString();
                        System.out.println(im);
                       e.setNom_image(im);
                           e.setPrice(Price);
                        e.setTelnumber((int)tel);
                   
                        e.setId((int) id);
                        e.setLatitude(lan);
                        e.setLongitude(loge);
                       
                        e.setDescription(obj.get("description").toString());
                        e.setTitle(obj.get("title").toString());
                        e.setSiteUrl(obj.get("siteUrl").toString());
                        listEvents.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
       
       
        public ArrayList<Event> getListFoire() {
        ArrayList<Event> listEvents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bpPI/web/app_dev.php/event/foireM");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // listDeals = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(events);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Event e = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                         float lan = Float.parseFloat(obj.get("latitude").toString());
                          float loge = Float.parseFloat(obj.get("longitude").toString());
                           float Price = Float.parseFloat(obj.get("price").toString());
                           float tel = Float.parseFloat(obj.get("telnumber").toString());
                           System.out.println(tel);
                              String im = obj.get("nomImage").toString();
                        System.out.println(im);
                       e.setNom_image(im);
                           e.setPrice(Price);
                        e.setTelnumber((int)tel);
                   
                        e.setId((int) id);
                        e.setLatitude(lan);
                        e.setLongitude(loge);
                       
                        e.setDescription(obj.get("description").toString());
                        e.setTitle(obj.get("title").toString());
                        e.setSiteUrl(obj.get("siteUrl").toString());
                        listEvents.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
    /*
 public ArrayList<Event> getListVoyage() {
        ArrayList<Event> listEvents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bpPIDEV/web/app_dev.php/client/voyageM");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // listDeals = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(events);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Event e = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                                float lan = Float.parseFloat(obj.get("latitude").toString());
                          float loge = Float.parseFloat(obj.get("longitude").toString());
                        System.out.println(lan+"jjjjjjjjjj");
                        System.out.println(loge+"oooooooooo");
                        e.setId((int) id);
                        e.setLatitude(lan);
                        e.setLongitude(loge);
                        
                        e.setId((int) id);
                        e.setDescription(obj.get("description").toString());
                        e.setTitle(obj.get("title").toString());
                        listEvents.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
  public ArrayList<Event> getListRandonee() {
        ArrayList<Event> listEvents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bpPIDEV/web/app_dev.php/client/randoneM");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // listDeals = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(events);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Event e = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                                float lan = Float.parseFloat(obj.get("latitude").toString());
                          float loge = Float.parseFloat(obj.get("longitude").toString());
                        System.out.println(lan+"jjjjjjjjjj");
                        System.out.println(loge+"oooooooooo");
                        e.setId((int) id);
                        e.setLatitude(lan);
                        e.setLongitude(loge);
                        e.setId((int) id);
                        e.setDescription(obj.get("description").toString());
                        e.setTitle(obj.get("title").toString());
                        listEvents.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
     public ArrayList<Event> getListThratre() {
        ArrayList<Event> listEvents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bpPIDEV/web/app_dev.php/client/theatreM");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // listDeals = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(events);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Event e = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                                float lan = Float.parseFloat(obj.get("latitude").toString());
                          float loge = Float.parseFloat(obj.get("longitude").toString());
                        System.out.println(lan+"jjjjjjjjjj");
                        System.out.println(loge+"oooooooooo");
                        e.setId((int) id);
                        e.setLatitude(lan);
                        e.setLongitude(loge);
                        e.setId((int) id);
                        e.setDescription(obj.get("description").toString());
                        e.setTitle(obj.get("title").toString());
                        listEvents.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
      public ArrayList<Event> getListFoire() {
        ArrayList<Event> listEvents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bpPIDEV/web/app_dev.php/client/foireM");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // listDeals = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(events);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Event e = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                                float lan = Float.parseFloat(obj.get("latitude").toString());
                          float loge = Float.parseFloat(obj.get("longitude").toString());
                        System.out.println(lan+"jjjjjjjjjj");
                        System.out.println(loge+"oooooooooo");
                        e.setId((int) id);
                        e.setLatitude(lan);
                        e.setLongitude(loge);
                        e.setId((int) id);
                        e.setDescription(obj.get("description").toString());
                        e.setTitle(obj.get("title").toString());
                        listEvents.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
*/
}
