/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Services.ServiceAds;
import com.mycompany.Entities.Ads;

/**
 *
 * @author Toshiba
 */
public class DetailAds {
     Button modifier;
    Button supprimer;
    Form f1;
    
  
    public DetailAds(){
        
                 f1 =new Form("tous les publicités",new BoxLayout(BoxLayout.Y_AXIS));
                modifier=new Button("modifier publicité");
                supprimer=new Button("supprimer publicité");
              
                /*   lb = new SpanLabel("");
        f.add(lb);
        ServiceAds serviceTask=new ServiceAds();
        ArrayList<Ads> lis=serviceTask.getList2();
        lb.setText(lis.toString());*/
                
                 f1.getToolbar().addCommandToRightBar("back", null, (ev)->{
             allAdsCompany h=new allAdsCompany();
               h.getF1().show();
          });
                 modifier.addActionListener((e) -> {
                     
                 ModifierAds h=new ModifierAds();
                      h.getF().show();


    });
                  supprimer.addActionListener((e) -> {
                          
                          
                             Ads p=new Ads();
                     
                 ServiceAds h=new ServiceAds();
                      h.deleteProduct(p.getId());
                 DetailAds D=new DetailAds();
                      D.getF1().show();


    });
                  
                  /* partager.addActionListener((e) -> {
                 AjouterAds h=new AjouterAds();
                      h.getF().show();
                  });*/


    
                 
         f1.add(modifier);
         f1.add(supprimer);
         f1.show();
    }

    public Form getF1() {
        return f1;
    }

    public void setF1(Form f1) {
        this.f1 = f1;
    }
                 
    
    
}
