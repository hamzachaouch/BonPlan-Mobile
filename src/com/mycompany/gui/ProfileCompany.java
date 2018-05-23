/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.FontImage;
import com.codename1.ui.Toolbar;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;

/**
 *
 * @author HP
 */
public class ProfileCompany {

    private Form form, home, about;
    private Form current;
    private Resources theme;
    private Button modif;
    private ImageViewer img;
    private Label nom, type, adresse, description;

    public ProfileCompany() {
        form = new Form("ProfileCompany", BoxLayout.y());

        form.getToolbar().addCommandToSideMenu("ajouter offre",null, e->{
            this.getF().show();
        });
        form.getToolbar().addCommandToSideMenu("ajouter publicités",null, e->{
            this.getF().show();
        });
        form.getToolbar().addCommandToSideMenu("ajouter avis",null, e->{
            this.getF().show();
        });
        form.show();
        
        form.getToolbar().addCommandToRightBar("Accueil", null, (ev) -> {
            AccueilPage h = new AccueilPage();
            h.getF().show();
        });
        modif = new Button("modifier");
        
        form.add(modif);
        modif.addActionListener((e) -> {
            ModifierCompany p = new ModifierCompany();
            p.getF().show();

        });
    }

    public Form getF() {
        return form;
    }

    public void setF(Form f) {
        this.form = form;
    }
}
