/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entities.Company;
import com.mycompany.Services.CompanyService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class AllRestaurants {

    private Form form;
    private SpanLabel info;
    private MultiButton mb;
    private  Label nom,description,adresse,ville,type,email;
    private Container t,x ,c;

    Style s = UIManager.getInstance().getComponentStyle("Button");
    Style style = UIManager.getInstance().getComponentStyle("Label");
//    FontImage p = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, s);
//    EncodedImage placeholder = EncodedImage.createFromImage(p.scaled(p.getWidth() * 4, p.getHeight() * 5), false);

    public AllRestaurants()   {
        form = new Form("liste des entreprises", BoxLayout.y());
       
        info = new SpanLabel();
        CompanyService cs = new CompanyService();
        ArrayList<Company> companies = new ArrayList<>();
        companies = cs.getListCompany();
        Image image;

        for (Company company : companies) {
             t = new Container(new BoxLayout(BoxLayout.X_AXIS));
                     x = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                     c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                     nom = new Label();
                     type=new Label();
                     nom.setText(company.getName());
                     type.setText(company.getType());
                     c.add(nom);
                     c.add(type);
//            InputStream stream = FileSystemStorage.getInstance().openInputStream(company.getImg_url());
//            System.out.println(stream);
//           
        

          /*  URLImage i = URLImage.createToStorage(placeholder,"404.png",
                   company.getImg_url());
            System.out.println(company.getImg_url());
           image = (Image) i;*/
          //  image = Image.createImage(FileSystemStorage.getInstance().openInputStream(company.getImg_url()));

           // InputStream is =  Storage.getInstance().createInputStream("C:\\Users\\HP\\AppData\\Local\\Temp\\temp437841702671400042..png");

            // EncodedImage a = EncodedImage.create(is, is.available());
//            image.scaledWidth(Display.getInstance().getDisplayWidth()/10);
//                        image.scaledHeight(Display.getInstance().getDisplayHeight()/10);
//
//            
//            mb.setIcon(image);
//            form.add(mb);
                     
        }
        t.add(c);
        form.add(t);
        form.show();

        form.getToolbar().addCommandToRightBar("Back", null, (ev) -> {
            AccueilPage h = new AccueilPage();
            h.getF().show();
        });

    }

    public Form getF() {
        return form;
    }

    public void setF(Form f) {
        this.form = form;
    }
}
