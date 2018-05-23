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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sana
 */
public class ServiceDeals {

    public void ajoutDeal(Deals d) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/bpPI/web/app_dev.php/deals/create?"
                + "name="+ d.getName() 
                + "&description=" + d.getDescription()
                + "&datedeb="+ d.getDatedebu()
                + "&datefin=" +d.getDatefin()
                + "&address=" + d.getAddress()
                + "&categorie=" + d.getCategorie()
                + "&imgUrl=" + d.getImgUrl()
                + "&programme=" + d.getProgramme()
                + "&tel=" + d.getTelephone()
                + "&horraire=" + d.getHorraire()
                + "&nbrclients=" + d.getNbrClients()
                + "&note=" + d.getNote()
                + "&idcompany=" + d.getIdCompany()
                +"&price=" + d.getPrice();
        
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
    

   public ArrayList<Deals> getListDeals() {
        ArrayList<Deals> listDeals = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bpPI/web/app_dev.php/deals/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // listDeals = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> deals = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(deals);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) deals.get("root");
                    for (Map<String, Object> obj : list) {
                        Deals d = new Deals();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        d.setId((int) id);
                        d.setProgramme(obj.get("programme").toString());
                        d.setName(obj.get("name").toString());
                        d.setDescription(obj.get("description").toString());
                        d.setHorraire(obj.get("horraire").toString());
                        d.setTelephone(obj.get("telephone").toString());
                    
                        Map<String, Object> datef  = (Map<String, Object>) obj.get("datefin");
                        float da2 = Float.parseFloat(datef.get("timestamp").toString());
                        Date d2 = new Date((long)(da2-3600)*1000);
                        d.setDateFin(d2);
                        Map<String, Object> dateb  = (Map<String, Object>) obj.get("datedebut");
                        float da1 = Float.parseFloat(datef.get("timestamp").toString());
                        Date d1 = new Date((long)(da2-3600)*1000);
                        d.setDateDebut(d1);

                        d.setImgUrl(obj.get("imgUrl").toString());
                        float prix = Float.parseFloat(obj.get("price").toString());
                         d.setPrice((int) prix);

                       
                        listDeals.add(d);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listDeals;
    }






}
