/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entities.Company;
import com.mycompany.Services.CompanyService;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author HP
 */
public class SearchPage {

    private Form form,f,f2;
     ImageViewer img;

    private MultiButton mb;
    private SpanLabel info;
    private Button tous, restaurant, salon, cinema, hotels,btn1,btn2;
    
    public SearchPage() {
        try {
            form = new Form("liste des entreprises", BoxLayout.y());
            tous = new Button("tous les entreprises");
            restaurant = new Button("Restaurants");
            salon = new Button("Salon de thé");
            cinema = new Button("Cinema");
            hotels = new Button("Hotels");
            form.add(tous);
            form.add(restaurant);
            form.add(salon);
            form.add(cinema);
            form.add(hotels);
            //bouton tous les restaurant
            EncodedImage enc = EncodedImage.create("/giphy.gif");
            
            tous.addActionListener(e->{
                info = new SpanLabel();
                CompanyService cs = new CompanyService();
                ArrayList<Company> companies = new ArrayList<>();
                companies = cs.getListCompany();
                //  Image image;
                f = new Form("all",BoxLayout.y());
                for (Company company : companies) {
                    Container c1 = new Container(BoxLayout.x());
//                    Image j = (URLImage.createToStorage(enc,company.getImg_url(),
//                            "http://localhost/bpPI/web/images/" +company.getImg_url()+"",URLImage.RESIZE_SCALE));
//                    System.out.println("http://localhost/bpPI/web/images/"+company.getImg_url()+"");
//                    ImageViewer image = new ImageViewer(j.fill(100, 100));
                    Label l = new Label(company.getName());
                    l.addPointerPressedListener(ev->{
                        Form f2 = new Form("Le profile de "+company.getName(),BoxLayout.y());
                        Container c2 = new Container();
                        Container c3 = new Container();
                        Container c4 = new Container();
                        Container c5 = new Container();
                        Container c6 = new Container();
                        
                        Label l2 = new Label(company.getAddress());
                        Label l3 = new Label(company.getDescription());
                        Label l4 = new Label(company.getEmail());
                        Label l5 = new Label (company.getVille());
//                        c2.add(image);
                        c3.add(l2);
                        c4.add(l3);
                        c5.add(l4);
                        c6.add(l5);
                        f2.add(c2);
                        f2.add(c3);
                        f2.add(c4);
                        f2.add(c5);
                        f2.add(c6);
                        btn1 = new Button("ajouter un avis");
                        
                        btn1.addActionListener((ec) -> {
                            AjoutAvisForm sup = new AjoutAvisForm();
                            sup.getF().show();
                        });
                        btn2 = new Button ("désactiver mon compte");
                        btn2.addActionListener((ec) -> {
                            CompanyService sup = new CompanyService();
                            sup.deleteCompany(company.getId());
                        });
                        f2.add(btn2);
                        
                        f2.add(btn1);
                        
                        f2.getToolbar().addCommandToRightBar("back",null,(eq->{
                            
                            f.show();
                            
                        }));
                        f2.show();
                    });
                    c1.add(l);
                    
                    
                    f.add(c1);
                    
                    f.getToolbar().addCommandToRightBar("back",null,(ev->{
                        
                        form.show();
                        
                    }));
                    f.show();
                    // form.show();
                }});
            
            
            salon.addActionListener(ec->{
                info = new SpanLabel();
                CompanyService m = new CompanyService();
                ArrayList<Company> salon = new ArrayList<>();
                salon = m.SelectSalon();
                f = new Form("tous les salon de the",BoxLayout.y());
                
                for (Company company : salon) {
                    Container c1 = new Container(BoxLayout.x());
                    Label l = new Label(company.getName());
                    l.addPointerPressedListener(ea->{
                        Form f2 = new Form("Le profile de "+company.getName(),BoxLayout.y());
                        Container c3 = new Container();
                        Container c4 = new Container();
                        Container c5 = new Container();
                        Container c6 = new Container();
                        
                        Label l2 = new Label(company.getAddress());
                        Label l3 = new Label(company.getDescription());
                        Label l4 = new Label(company.getEmail());
                        Label l5 = new Label (company.getVille());
                        btn1 = new Button("ajouter un avis");
                        
                        c3.add(l2);
                        c4.add(l3);
                        c5.add(l4);
                        c6.add(l5);
                        
                        f2.add(c3);
                        f2.add(c4);
                        f2.add(c5);
                        f2.add(c6);
                        
                        btn1 = new Button("ajouter un avis");
                        
                        btn1.addActionListener((em) -> {
                            AjoutAvisForm sup = new AjoutAvisForm();
                            sup.getF().show();
                        });
                        btn2 = new Button ("désactiver mon compte");
                        btn2.addActionListener((en) -> {
                            CompanyService sup = new CompanyService();
                            sup.deleteCompany(company.getId());
                        });
                        f2.add(btn2);
                        
                        f2.add(btn1);
                        f2.getToolbar().addCommandToRightBar("back",null,(eq->{
                            
                            f.show();
                            
                        }));
                        f2.show();
                    });
                    c1.add(l);
                    // c1.add(mb);
                    
                    f.add(c1);
                    f.getToolbar().addCommandToRightBar("back",null,(ev->{
                        
                        form.show();
                        
                    }));
                    
                    f.show();
                }});
            
            restaurant.addActionListener(ex->{
                CompanyService w = new CompanyService();
                ArrayList<Company> res = new ArrayList<>();
                res = w.SelectRestaurant();
                f = new Form("tous les restaurants",BoxLayout.y());
                
                for (Company company : res) {
                    Container c1 = new Container(BoxLayout.x());
                    Label l = new Label(company.getName());
                    l.addPointerPressedListener(ed->{
                        Form f2 = new Form("Le profile de "+company.getName(),BoxLayout.y());
                        Container c3 = new Container();
                        Container c4 = new Container();
                        Container c5 = new Container();
                        Container c6 = new Container();
                        
                        Label l2 = new Label(company.getAddress());
                        Label l3 = new Label(company.getDescription());
                        Label l4 = new Label(company.getEmail());
                        Label l5 = new Label (company.getVille());
                        btn1 = new Button("ajouter un avis");
                        
                        c3.add(l2);
                        c4.add(l3);
                        c5.add(l4);
                        c6.add(l5);
                        
                        f2.add(c3);
                        f2.add(c4);
                        f2.add(c5);
                        f2.add(c6);
                        btn1 = new Button("ajouter un avis");
                        
                        btn1.addActionListener((ec) -> {
                            AjoutAvisForm sup = new AjoutAvisForm();
                            sup.getF().show();
                        });
                        btn2 = new Button ("désactiver mon compte");
                        btn2.addActionListener((ec) -> {
                            CompanyService sup = new CompanyService();
                            sup.deleteCompany(company.getId());
                        });
                        f2.add(btn2);
                        
                        f2.add(btn1);
                        f2.getToolbar().addCommandToRightBar("back",null,(eq->{
                            
                            f.show();
                            
                        }));
                        f2.show();
                    });
                    c1.add(l);
                    
                    f.add(c1);
                    f.getToolbar().addCommandToRightBar("back",null,(ev->{
                        
                        form.show();
                        
                    }));
                    
                    f.show();
                }});
            cinema.addActionListener(el->{
                info = new SpanLabel();
                CompanyService cin = new CompanyService();
                ArrayList<Company> cinema = new ArrayList<>();
                cinema = cin.SelectCinema();
                f = new Form("tous les Cinemas",BoxLayout.y());
                
                for (Company company : cinema) {
                    Container c1 = new Container(BoxLayout.x());
                    Label l = new Label(company.getName());
                    l.addPointerPressedListener(ek->{
                        Form f2 = new Form("Le profile de "+company.getName(),BoxLayout.y());
                        Container c3 = new Container();
                        Container c4 = new Container();
                        Container c5 = new Container();
                        Container c6 = new Container();
                        
                        Label l2 = new Label(company.getAddress());
                        Label l3 = new Label(company.getDescription());
                        Label l4 = new Label(company.getEmail());
                        Label l5 = new Label (company.getVille());
                        btn1 = new Button("ajouter un avis");
                        
                        c3.add(l2);
                        c4.add(l3);
                        c5.add(l4);
                        c6.add(l5);
                        
                        f2.add(c3);
                        f2.add(c4);
                        f2.add(c5);
                        f2.add(c6);
                        btn1 = new Button("ajouter un avis");
                        
                        btn1.addActionListener((ec) -> {
                            AjoutAvisForm sup = new AjoutAvisForm();
                            sup.getF().show();
                        });
                        btn2 = new Button ("désactiver mon compte");
                        btn2.addActionListener((ec) -> {
                            CompanyService sup = new CompanyService();
                            sup.deleteCompany(company.getId());
                        });
                        f2.add(btn2);
                        
                        f2.add(btn1);
                        f2.getToolbar().addCommandToRightBar("back",null,(eq->{
                            
                            f.show();
                            
                        }));
                        f2.show();
                    });
                    c1.add(l);
                    
                    
                    f.add(c1);
                    f.getToolbar().addCommandToRightBar("back",null,(ev->{
                        
                        form.show();
                        
                    }));
                    
                    f.show();
                }});
            hotels.addActionListener(ev->{
                
                CompanyService hot = new CompanyService();
                ArrayList<Company> hotels = new ArrayList<>();
                hotels = hot.SelectHotels();
                f = new Form("tous les Hotels",BoxLayout.y());
                
                for (Company company : hotels) {
                    Container c1 = new Container(BoxLayout.x());
                    Label l = new Label(company.getName());
                    l.addPointerPressedListener(ej->{
                        Form f2 = new Form("Le profile de "+company.getName(),BoxLayout.y());
                        Container c3 = new Container();
                        Container c4 = new Container();
                        Container c5 = new Container();
                        Container c6 = new Container();
                        
                        Label l2 = new Label(company.getAddress());
                        Label l3 = new Label(company.getDescription());
                        Label l4 = new Label(company.getEmail());
                        Label l5 = new Label (company.getVille());
                        btn1 = new Button("ajouter un avis");
                        
                        c3.add(l2);
                        c4.add(l3);
                        c5.add(l4);
                        c6.add(l5);
                        
                        f2.add(c3);
                        f2.add(c4);
                        f2.add(c5);
                        f2.add(c6);
                        btn1 = new Button("ajouter un avis");
                        
                        btn1.addActionListener((ec) -> {
                            AjoutAvisForm sup = new AjoutAvisForm();
                            sup.getF().show();
                        });
                        btn2 = new Button ("désactiver mon compte");
                        btn2.addActionListener((ec) -> {
                            CompanyService sup = new CompanyService();
                            sup.deleteCompany(company.getId());
                        });
                        f2.add(btn2);
                        
                        f2.add(btn1);
                        f2.getToolbar().addCommandToRightBar("back",null,(eq->{
                            
                            f.show();
                            
                        }));
                        f2.show();
                    });
                    c1.add(l);
                    
                    f.add(c1);
                    f.getToolbar().addCommandToRightBar("back",null,(ef->{
                        
                        form.show();
                        
                    }));
                    
                    f.show();
                }});
            form.show();
            
            form.getToolbar().addCommandToRightBar("Back", null, (ev) -> {
                AccueilPage h = new AccueilPage();
                h.getF().show();
            });
        } catch (IOException ex) {
        }
  
    
            }
           
    
        

    public Form getF() {
        return form;
    }

    public void setF(Form f) {
        this.form = form;
    }
}
