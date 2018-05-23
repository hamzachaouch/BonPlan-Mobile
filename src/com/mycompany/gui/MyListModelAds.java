/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.events.SelectionListener;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.EventDispatcher;

/**
 *
 * @author Toshiba
 */
public class MyListModelAds implements ListModel<Image> {
    private int selection;
    private String[] imageURLs = {
       
    };
     public MyListModelAds(String[] imageNames){
        imageURLs=imageNames;
        
    }
    private Image[] images;
    private EventDispatcher listeners = new EventDispatcher();
    final EncodedImage placeholder = EncodedImage.createFromImage(
        FontImage.createMaterial(FontImage.MATERIAL_SYNC, new Style()).
                scaled(300, 300), false);

    public MyListModelAds() {
        this.images = new EncodedImage[imageURLs.length];
    }

    public Image getItemAtt(final int index,String imageName) {
        System.err.println("image name :"+imageName);
        Image image = URLImage.createToStorage(placeholder, "i"+index,"http://localhost/MobileJson/Ads/"+imageName);
        return image;
    }
    public Image getItemAt(final int index) {
        //disabled because it does not give us what we want , sadly...
        //do not touch @!
         Image image = URLImage.createToStorage(placeholder, "image"+index,"http://localhost/MobileJson/");
         return image;
    }


    public int getSize() {
        return imageURLs.length;
    }

    public int getSelectedIndex() {
        return selection;
    }

    public void setSelectedIndex(int index) {
        selection = index;
    }

    public void addDataChangedListener(DataChangedListener l) {
        listeners.addListener(l);
    }

    public void removeDataChangedListener(DataChangedListener l) {
        listeners.removeListener(l);
    }

    public void addSelectionListener(SelectionListener l) {
    }

    public void removeSelectionListener(SelectionListener l) {
    }

    public void addItem(Image item) {
    }

    public void removeItem(int index) {
    }
}
