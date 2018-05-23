/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.io.IOException;

/**
 *
 * @author Toshiba
 */
public class pageCompany {
    
    
    
    
        public void start(Resources theme) {

     Form f = new Form("Entreprise", BoxLayout.y());
       
        Command Gdeals = new Command("Gestion Deals");
        Command GEvent = new Command("Gestion Evenement");
        Command GPub = new Command("Gestion Publicité");
        Command cExit = new Command("Retour vers acceuil");
        
        f.getToolbar().addCommandToSideMenu(Gdeals);
        f.getToolbar().addCommandToSideMenu(GEvent);
        f.getToolbar().addCommandToSideMenu(GPub);
        f.getToolbar().addCommandToSideMenu(cExit);
        f.addCommandListener(e->{
           
           
            
             
            if(e.getCommand()==Gdeals){
AjoutDealForm D=new AjoutDealForm();
D.getF().show();
            }
            if(e.getCommand()==GEvent){
      AjoutEventForm E=new AjoutEventForm();
      E.getF().show();
            }
            
            if(e.getCommand()==GPub){
                
allAdsCompany all=new allAdsCompany();
all.getF1().show();
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