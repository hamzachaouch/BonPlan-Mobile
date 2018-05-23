/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entities.Company;
import com.mycompany.Services.CompanyService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class AccueilPage {

    Form form,f;
    private Container c1;
    private Label l1;
    private Button recherche;

    public AccueilPage() {
        form = new Form("home", BoxLayout.y());
        l1 = new Label("nom de l'entreprise");
        form.add(l1);
        recherche = new Button("Rechercher endroit");
        form.add(recherche);

        recherche.addActionListener((e) -> {
              SearchPage p = new SearchPage();
            p.getF().show(); 
                    });
        
        form.getToolbar().addCommandToRightBar("S'inscrire", null, (ev) -> {
            AjouterCompany h = new AjouterCompany();
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
