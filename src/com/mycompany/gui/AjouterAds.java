/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.social.FacebookConnect;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.codename1.util.Base64;
import com.mycompany.Services.ServiceAds;
import com.codename1.io.FileSystemStorage;

import com.mycompany.Entities.Ads;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author sana
 */
public class AjouterAds {

    private Form current;
    private Resources theme;

    Form f;
    ////////////////////////////////
    private String fileName;///
    private String filePath;//
/////////////////////////////

    TextField ville;
    TextField titre;
    TextArea desc;
    TextField img;
    private Picker dateB;
    private Picker dateE;
    Container ctntitre;
    Container ctnville;
    Container ctnDesc;

    Container ctn1;
    Container ctn2;

    Label l1;
    Label l2;
    Label l3;
    Label l4;

    Button btnajout, btnaff;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }

    public void start() {
        if (current != null) {
            current.show();
            return;
        }

        f = new Form("ajout publicité", BoxLayout.y());

        dateB = new Picker();
        dateE = new Picker();
        ctn1 = new Container(BoxLayout.x());
        ctn2 = new Container(BoxLayout.x());
        ctntitre = new Container(BoxLayout.x());
        ctnville = new Container(BoxLayout.x());
        ctnDesc = new Container(BoxLayout.x());
        ville = new TextField("", "ville...", 20, TextField.ANY);

        titre = new TextField("", "titre...", 20, TextField.ANY);
        desc = new TextField("", "desc", 20, TextArea.URL);
        img = new TextField("", "img...", 20, TextField.ANY);
        Button upload = new Button("Upload");
        CheckBox shareFb = new CheckBox("Partager sur facebook");

        l1 = new Label("Ville");
        l2 = new Label("titre");
        l3 = new Label("descrption");
        l4 = new Label("image");

        btnajout = new Button("ajouter");
        btnaff = new Button("Affichage");

        //ctntitre.add(l2);
        ctntitre.add(titre);
        f.add(ctntitre);

        ctnville.add(ville);
        ctnville.add(l1);
        f.add(ctnville);

        ctnDesc.add(desc);
        ctnDesc.add(l3);
        f.add(ctnDesc);

        // f.add(img);
        //f.add(l1);
        f.add(l4);

        ctn1.add(dateB);
        ctn1.add(dateE);
        f.add(ctn1);
        f.add(shareFb);

        f.add(upload);

        ctn2.add(btnajout);
        ctn2.add(btnaff);
        f.add(ctn2);
        
//                 f.getToolbar().addCommandToLeftBar("back", theme.getImage("back-command.png"), et->{
//                      allAdsCompany h = new allAdsCompany();
//            h.getF1().show();
//                 });

        
        f.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            allAdsCompany h = new allAdsCompany();
            h.getF1().show();
        });

        btnajout.addActionListener(new ActionListener() {
            
            
              @Override
            public void actionPerformed(ActionEvent evt) {
            Ads A = new Ads(dateB.getText(), dateE.getText(), titre.getText(), fileName, desc.getText(), ville.getText());
           

 if(titre.getText().equals("")||desc.getText().equals("")||ville.getText().equals("")){
         Dialog.show("Erreur", "Veuiller remplir tous les champs", "Ok", null);}
 
 
 
 
        
     
            // Event p = new Event(tfTitre.getText(), tfDescription.getText(), 0,Float.parseFloat(tfPrix.getText()),""+tfType.getModel().getItemAt(i),tfDate,fileName);
            ConnectionRequest req = new ConnectionRequest();
            req.addArgument("image", fileName);

            //  req.addArgument("image", fileName);
            //     req.setUrl("http://localhost/MobileJson/Ads/insert.php?datepub1=" + A.getDateBegin()+ "&datepub2="+ A.getDateEnd() + "&titre="+ A.getTitre()+"$img_url="+A.getImgUrl() + "&descritpion=" + A.getDescription() + "&ville=" + A.getVille() );
            //req.setUrl("http://localhost/MobileJson/Ads/insert.php?datepub1=" + A.getDateBegin()+ "&datepub2="+ A.getDateEnd() + "$status="+A.getStatus()+"&titre="+ A.getTitre()+"$img_url="+A.getImgUrl() +"&descritpion=" + A.getDescription() + "&ville=" + A.getVille() );
            req.setUrl("http://localhost/MobileJson/Ads/insert.php?datepub1=" + A.getDateBegin() + "&datepub2=" + A.getDateEnd() + "$status=" + A.getStatus() + "&titre=" + A.getTitre() + "&description=" + A.getDescription()+ "&ville=" + A.getVille()+"&companyId="+4);

            System.out.println("http://localhost/MobileJson/Ads/insert.php?titre=" + A.getTitre() + "&description=" + A.getDescription() + "&ville=" + A.getVille());

            
            ///////////////////////////////////////////////
//             req.addResponseListener(new ActionListener<NetworkEvent>() {
//
//                    @Override
//                    public void actionPerformed(NetworkEvent evt) {
//                        
//                        byte[] data = (byte[]) evt.getMetaData();
//                        String s = new String(data);
//                        System.out.println(s);
//                        if (s.equals("success")) {
//                            Dialog.show("Confirmation", "success", "Ok", null);
//                        } else {
//                            Dialog.show("Erreur", "erreur", "Ok", null);
//                        }
//                    }
//                });
            ////////////////////////////////////////////////////////
            
          NetworkManager.getInstance().addToQueue(req);
                if(shareFb.isSelected()){
                    try {                 
                        
                        shareImageOnFacebook(filePath,A.getTitre(),A.getDescription());
                    } catch (IOException ex) {
                    }
                   
                }
            
            Form resultat = new Form("affichage", BoxLayout.y());

            Label ltitre = new Label("titre : " + titre.getText());
            Label ldesc = new Label("description : " + desc.getText());
            Label lville = new Label("ville : " + ville.getText());
          //  Label limage = new Label("image : " + );

            Label ldateD = new Label("Date begin  : " + dateB.getText());
            Label ldateF = new Label("Date End  : " + dateE.getText());

            resultat.add(ltitre).add(ldesc).add(lville).add(ldateD).add(ldateF);
            resultat.show();
            resultat.getToolbar().addCommandToRightBar("back", null, (ev) -> {
                f.show();
            });
            
                 }
        });
//           Button rmB = new Button("supprimer");
//            Container co = new Container();
//            co.add(rmB);
//            rmB.addActionListener(ev -> {
//                ServiceAds Del = new ServiceAds();
//                Del.deleteProduct(A.getId());
//            });
//            resultat.add(co);
            /*Button modif=new Button("modifier");
                        modif.addActionListener(ev->{
                            Ads p=new Ads();
                 new DeleteAds(p.getId()).start();

                });
                        f.add(modif);*/

      
          
            // Ads t = new Ads( titre.getText(), desc.getText(),ville.getText());

            // Ads t = new Ads(0, titre.getText(), desc.getText(),ville.getText());
            //*************pour redirection******
            //AffichageAds h=new AffichageAds();
            //h.getF().show();
       
        btnaff.addActionListener((e) -> {
//            AffichageAds a = new AffichageAds();
//            a.getF().show();

showAds s =new showAds();
s.start();

        });

        upload.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().openGallery(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ev) {
                        if (ev != null && ev.getSource() != null) {
                            filePath = (String) ev.getSource();

                            int fileNameIndex = filePath.lastIndexOf("/") + 1;
                            fileName = filePath.substring(fileNameIndex);
                            Image imgg;
                            try {
                                imgg = Image.createImage(filePath);
                                if (imgg != null) {
                                    ImageIO imgIO = ImageIO.getImageIO();
                                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                                    imgIO.save(imgg, out, ImageIO.FORMAT_JPEG, 1);
                                    byte[] ba = out.toByteArray();
                                    fileName = Base64.encode(ba);
                                    System.err.println(fileName);
                                }
                            } catch (IOException ex) {
                            }
                        }
                    }
                }, Display.GALLERY_IMAGE);

            }
        });

        f.show();
    }

 
    public void stop() {
        current = Display.getInstance().getCurrent();
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }

    public void destroy() {
    }

    
    
    
    
    
       //function using Multipart request to share product
public void shareImageOnFacebook(String filename,String titre,String Description) throws IOException{
                            MultipartRequest req = new MultipartRequest();
                            String endpoint;
                            if(FacebookConnect.getInstance().isFacebookSDKSupported()) {
                                endpoint = "EAACEdEose0cBAFpujquQabQiha75BPdqMFdrkimM9gaAUMZCZBjMJNZAhZAmZCXZA6M8xQMnMmi6aIhEfaT1S88mZBVwNg0D7RAdZB0JhqqQk1wQYhkNEZAVGxi89PibYaVv79jE8PmjLDaEX0uNMsumCvZBZBWI8W6mx91vkXLpe6gmylxniTH21ZBT23vKJyvbMZA0Nqy6Wcso0zAZDZD";
                            } else {
                                endpoint = "https://graph.facebook.com/me/photos?access_token=EAACEdEose0cBAFpujquQabQiha75BPdqMFdrkimM9gaAUMZCZBjMJNZAhZAmZCXZA6M8xQMnMmi6aIhEfaT1S88mZBVwNg0D7RAdZB0JhqqQk1wQYhkNEZAVGxi89PibYaVv79jE8PmjLDaEX0uNMsumCvZBZBWI8W6mx91vkXLpe6gmylxniTH21ZBT23vKJyvbMZA0Nqy6Wcso0zAZDZD";
                            }
                            req.setUrl(endpoint);
                            req.addArgument("message","Titre:"+titre+"Description:"+Description);
                            InputStream is = null;
                            is = FileSystemStorage.getInstance().openInputStream(filename);
                            req.addData("source", is, FileSystemStorage.getInstance().getLength(filename), "image/jpeg");
                            NetworkManager.getInstance().addToQueue(req);
                            System.err.println("shared on facebook...");
        }
    
    
    
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
