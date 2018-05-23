/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;


/**
 *
 * @author sana
 */
public class allAdsCompany {
    
    private Resources theme;

    Button ajout;
    Button aff;
    Form f1;
    
    
  
    public allAdsCompany() {
        
                f1 =new Form("tous les publicités",new BoxLayout(BoxLayout.Y_AXIS));
                ajout=new Button("ajouter publicité");
                aff=new Button("afficher");
                
       

                
                /*   lb = new SpanLabel("");
        f.add(lb);
        ServiceAds serviceTask=new ServiceAds();
        ArrayList<Ads> lis=serviceTask.getList2();
        lb.setText(lis.toString());*/
                 ajout.addActionListener((e) -> {
                 AjouterAds h=new AjouterAds();
                      h.start();


    });
                 
 
                  aff.addActionListener((e) -> {
                 showAds s =new showAds();
                 s.start();
 });
/////////////////////////////
//                  showByAdsByCompany C=new showByAdsByCompany();
//                      try {
//                          C.start();
//                      } catch (IOException iOException) {
//                      }
//    });
  f1.getToolbar().addCommandToRightBar("back", null, (ev)->{
             pageCompany h=new pageCompany();
               h.start(theme);
          });
                 
                  
         f1.add(ajout);
         f1.add(aff);
         f1.show();
    }
                 

    public Form getF1() {
        return f1;
    }

    public void setF1(Form f) {
        this.f1 = f;
    }

}
