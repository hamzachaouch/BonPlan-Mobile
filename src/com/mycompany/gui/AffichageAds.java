    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.mycompany.Entities.Ads;
import com.mycompany.Services.ServiceAds;
import java.util.ArrayList;

/**
 *
 * @author sana
 */
public class AffichageAds {

    Form f;
    SpanLabel lb;
  
    public AffichageAds() {
        
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServiceAds serviceTask=new ServiceAds();
        ArrayList<Ads> lis=serviceTask.getList2();
        lb.setText(lis.toString());
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{
             AjouterAds h=new AjouterAds();
               h.start();
          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
