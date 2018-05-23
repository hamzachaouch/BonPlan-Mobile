/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entities.Company;
import com.mycompany.Services.CompanyService;

/**
 *
 * @author HP
 */
public class ModifierCompany {

    private Form current, f, resultat;
    private Resources theme;
    private TextField nom, mail, login, address, ville, password, description, img_url;
    private Button modifier;
    private ComboBox<String> type;

    public ModifierCompany() {

        f = new Form("Modifier votre profile", BoxLayout.y());
        nom = new TextField("", "le nom de votre entreprise", 20, TextField.ANY);
        type = new ComboBox("Restaurant", "Salon de thé", "Hotels", "Cinéma");

        mail = new TextField("", "l'email de votre entreprise", 20, TextField.ANY);
        login = new TextField("", "votre login", 20, TextField.ANY);
        password = new TextField("", "votre mot de passe", 20, TextField.PASSWORD);
        address = new TextField("", "votre adresse exacte", 50, TextField.ANY);
        ville = new TextField("", "votre ville", 20, TextField.ANY);
        description = new TextField("", "votre description", 500, TextField.ANY);

        modifier = new Button("Modifier");

        f.add(nom);
        f.add(type);
        f.add(mail);
        f.add(login);
        f.add(password);
        f.add(address);
        f.add(ville);
        f.add(description);

        f.add(modifier);
        modifier.addActionListener((e) -> {
//             resultat=new Form("Resultat", BoxLayout.y());
//
//              
//            CompanyService ser = new CompanyService();
//            Company c = new Company(0, nom.getText(),type.getSelectedItem(),mail.getText(),login.getText()
//            ,password.getText(),address.getText(),ville.getText(),description.getText());
//                   
//             ser.ajoutCompany(c);
//             f.show();
            ProfileCompany p = new ProfileCompany();
            p.getF().show();

        });
        f.getToolbar().addCommandToRightBar("Accueil", null, (ev) -> {
            AccueilPage h = new AccueilPage();
            h.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
