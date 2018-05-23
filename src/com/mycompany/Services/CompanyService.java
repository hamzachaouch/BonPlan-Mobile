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
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entities.Company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class CompanyService {

    public void ajoutCompany(Company c) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/WebService/AddCompany.php?login=" + c.getLogin()
                + "&password=" + c.getPassword()
                + "&name=" + c.getName()
                + "&description=" + c.getDescription()
                + "&address=" + c.getAddress()
                + "&type=" + c.getType()
                + "&img_url=" + c.getImg_url()
                + "&email=" + c.getEmail()
                + "&ville=" + c.getVille();
              
        con.setUrl(Url);

        System.out.println("succés");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public ArrayList<Company> getListCompany() {
        ArrayList<Company> companies = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WebService/SelectAllCompany.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> Listcompany = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(Listcompany);

                    List<Map<String, Object>> list = (List<Map<String, Object>>) Listcompany.get("root");
                    for (Map<String, Object> obj : list) {
                        Company c = new Company();
                        float id = Float.parseFloat(obj.get("id").toString());

                        c.setId((int) id);
                        c.setLogin(obj.get("login").toString());
                        c.setPassword(obj.get("password").toString());
                        c.setName(obj.get("name").toString());
                        c.setDescription(obj.get("description").toString());
                        c.setAddress(obj.get("address").toString());
                        c.setType(obj.get("type").toString());
                        c.setImg_url(obj.get("img_url").toString());
                        c.setEmail(obj.get("email").toString());
                        c.setVille(obj.get("ville").toString());

                        companies.add(c);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return companies;
    }


   public ArrayList<Company> SelectRestaurant(){
       ArrayList<Company> companies = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WebService/SelectRestaurants.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> Listcompany = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(Listcompany);

                    List<Map<String, Object>> list = (List<Map<String, Object>>) Listcompany.get("root");
                    for (Map<String, Object> obj : list) {
                        Company c = new Company();
                        float id = Float.parseFloat(obj.get("id").toString());

                        c.setId((int) id);
                        c.setLogin(obj.get("login").toString());
                        c.setPassword(obj.get("password").toString());
                        c.setName(obj.get("name").toString());
                        c.setDescription(obj.get("description").toString());
                        c.setAddress(obj.get("address").toString());
                        c.setType(obj.get("type").toString());
                        c.setImg_url(obj.get("img_url").toString());
                        c.setEmail(obj.get("email").toString());
                        c.setVille(obj.get("ville").toString());

                        companies.add(c);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return companies;
    }

   
   public ArrayList<Company> SelectSalon(){
       ArrayList<Company> companies = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WebService/SelectSalon.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> Listcompany = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(Listcompany);

                    List<Map<String, Object>> list = (List<Map<String, Object>>) Listcompany.get("root");
                    for (Map<String, Object> obj : list) {
                        Company c = new Company();
                        float id = Float.parseFloat(obj.get("id").toString());

                        c.setId((int) id);
                        c.setLogin(obj.get("login").toString());
                        c.setPassword(obj.get("password").toString());
                        c.setName(obj.get("name").toString());
                        c.setDescription(obj.get("description").toString());
                        c.setAddress(obj.get("address").toString());
                        c.setType(obj.get("type").toString());
                        c.setImg_url(obj.get("img_url").toString());
                        c.setEmail(obj.get("email").toString());
                        c.setVille(obj.get("ville").toString());

                        companies.add(c);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return companies;
    

   }
   public ArrayList<Company> SelectCinema(){
   ArrayList<Company> companies = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WebService/SelectCinema.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> Listcompany = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(Listcompany);

                    List<Map<String, Object>> list = (List<Map<String, Object>>) Listcompany.get("root");
                    for (Map<String, Object> obj : list) {
                        Company c = new Company();
                        float id = Float.parseFloat(obj.get("id").toString());

                        c.setId((int) id);
                        c.setLogin(obj.get("login").toString());
                        c.setPassword(obj.get("password").toString());
                        c.setName(obj.get("name").toString());
                        c.setDescription(obj.get("description").toString());
                        c.setAddress(obj.get("address").toString());
                        c.setType(obj.get("type").toString());
                        c.setImg_url(obj.get("img_url").toString());
                        c.setEmail(obj.get("email").toString());
                        c.setVille(obj.get("ville").toString());

                        companies.add(c);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return companies;
    }
    
   
   public ArrayList<Company> SelectHotels(){
   ArrayList<Company> companies = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WebService/SelectHotels.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> Listcompany = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(Listcompany);

                    List<Map<String, Object>> list = (List<Map<String, Object>>) Listcompany.get("root");
                    for (Map<String, Object> obj : list) {
                        Company c = new Company();
                        float id = Float.parseFloat(obj.get("id").toString());

                        c.setId((int) id);
                        c.setLogin(obj.get("login").toString());
                        c.setPassword(obj.get("password").toString());
                        c.setName(obj.get("name").toString());
                        c.setDescription(obj.get("description").toString());
                        c.setAddress(obj.get("address").toString());
                        c.setType(obj.get("type").toString());
                        c.setImg_url(obj.get("img_url").toString());
                        c.setEmail(obj.get("email").toString());
                        c.setVille(obj.get("ville").toString());

                        companies.add(c);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return companies;
    }
    public void UpdateCompany(Company c) {

               ConnectionRequest con = new ConnectionRequest();
        String Url="http://localhost/WebService/Updateompany?login=" + c.getLogin()
                + "&password=" + c.getPassword()
                + "&name=" + c.getName()
                + "&description=" + c.getDescription()
                + "&address=" + c.getAddress()
                + "&type=" + c.getType()
                + "&img_url=" + c.getImg_url()
                + "&email=" + c.getEmail()
                + "&ville=" + c.getVille();
                
              
                
        con.setUrl(Url);

        System.out.println("succés");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
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

                NetworkManager.getInstance().addToQueue(con);
            }        
     public void deleteCompany(int id){
                ConnectionRequest req = new ConnectionRequest();
                
                req.setUrl("http://localhost/WebService/DeleteCompany.php?id="+id);
                
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

}
    
   

