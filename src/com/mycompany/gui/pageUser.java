/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Hamza
 */
public class pageUser {
            public void start(Resources theme) {

     Form f = new Form("User", BoxLayout.y());
       
        Command Gdeals = new Command("Afficher  Deals");
        Command GEvent = new Command("Afficher Evenement");
        Command GPub = new Command(" Afficher  publicité");
        Command cExit = new Command("Retour vers acceuil");
        
        f.getToolbar().addCommandToSideMenu(Gdeals);
        f.getToolbar().addCommandToSideMenu(GEvent);
        f.getToolbar().addCommandToSideMenu(GPub);
        f.getToolbar().addCommandToSideMenu(cExit);
        f.addCommandListener(e->{
           
           
            
             
            if(e.getCommand()==Gdeals){
Affichage d=new Affichage();
        d.Affichage();
            }
            if(e.getCommand()==GEvent){
//      ListEvent E=new ListEvent();
//      E.getH().show();
            }
            
            if(e.getCommand()==GPub){
                
showallAdsbyUser all=new showallAdsbyUser();
all.start();
        }
            
            if(e.getCommand()==cExit){
                
            }
        });
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{
             pageCompany h=new pageCompany();
               h.start(theme);
          });
            
     f.setScrollableY(true);
            f.show();
}}

