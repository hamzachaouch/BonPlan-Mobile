/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.OnOffSwitch;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.util.StringUtil;
import com.mycompany.Entities.Company;
import com.mycompany.Services.CompanyService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.stage.FileChooser;
import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author HP
 */
public class AjouterCompany {

    private Form current, f, resultat;
    private Resources theme;
    private TextField txtnom, txtmail, txtlogin, txtaddress, txtville, password, img_url, txtdescription;
    private final Button btnajout;
    private ComboBox<String> type;
    private final Label l1, l2, l3, l4, l5, l6, l7, l8;
    //private final String  path = "http://localhost/imgs/";
    private final Button b = new Button("Browse");
    private Company company = new Company();
    private String sh = "",imgPath,fileNameInServer;
    List<String> k;
    private String textAttachmentUri;

    public AjouterCompany() {
        f = new Form("Inscription", BoxLayout.y());
        l1 = new Label("nom de l'entreprise");
        txtnom = new TextField("", "le nom de l'entreprise", 20, TextField.ANY);
        l2 = new Label("catégorie");
        type = new ComboBox("Restaurant", "Salon de the", "Hotels", "Cinema");
        l3 = new Label("E-mail");
        txtmail = new TextField("", "votre mail");
        l4 = new Label("Login");
        txtlogin = new TextField("", "votre login", 20, TextField.ANY);
        l5 = new Label("Password");
        password = new TextField("", "votre mot de passe", 20, TextField.PASSWORD);
        l6 = new Label("Adresse");
        txtaddress = new TextField("", "votre adresse exacte", 50, TextField.ANY);
        l7 = new Label("Ville");
        txtville = new TextField("", "votre ville", 20, TextField.ANY);
        l8 = new Label("Description");
        txtdescription = new TextField("", "Description", 20, TextField.ANY);

        btnajout = new Button("Ajouter");
        
                Validator val =new Validator();
val.addConstraint(txtnom, new LengthConstraint(2));
val.addConstraint(txtdescription, new LengthConstraint(4));
val.addConstraint(txtlogin, new LengthConstraint(2));
val.addConstraint(txtmail, new LengthConstraint(8));
val.addConstraint(txtville, new LengthConstraint(1));

        f.add(l1);
        f.add(txtnom);
        f.add(l2);
        f.add(type);
        f.add(l3);
        f.add(txtmail);
        f.add(l4);
        f.add(txtlogin);
        f.add(l5);
        f.add(password);
        f.add(l6);
        f.add(txtaddress);
        f.add(l7);
        f.add(txtville);
        f.add(l8);
        f.add(txtdescription);
        f.add(b);

        f.add(btnajout);
        
            

            f.getToolbar().addCommandToRightBar("back", null, (ev)->{
             pageCompany h=new pageCompany();
               h.start(theme);
          });
        
        
        
        
        
        
        
        
//        b.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                if (FileChooser.isAvailable()) {
//                    FileChooser.showOpenDialog(".png", e2 -> {
//                        String file = (String) e2.getSource();
//                        if (file == null) {
//                            f.add("No file was selected");
//                            f.revalidate();
//                        } else {
//                            String extension = null;
//                            if (file.lastIndexOf(".") > 0) {
//                                extension = file.substring(file.lastIndexOf(".") + 1);
//                            }
//                            if ("txt".equals(extension)) {
//                                FileSystemStorage fs = FileSystemStorage.getInstance();
//                                try {
//                                    InputStream fis = fs.openInputStream(file);
//                                    f.addComponent(new SpanLabel(Util.readToString(fis)));
//                                } catch (Exception ex) {
//                                    Log.e(ex);
//                                }
//                            } else {
//                                k = StringUtil.tokenize(file, '/');
//                                System.out.println(file);
//                                sh = file;
//                                Dialog.show("Info", file, "ok", "cancel");
//                                System.out.println(k.get(k.size() - 1));
//                            }
//                        }
//                        f.revalidate();
//                    });
//                }
//            }
//        });
        btnajout.addActionListener((e) -> {
            //     resultat = new Form("Resultat", BoxLayout.y());
//
            CompanyService ser = new CompanyService();

            company.setLogin(txtlogin.getText());
            company.setPassword(password.getText());
            company.setName(txtnom.getText());
            company.setType(type.getSelectedItem());
            company.setEmail(txtmail.getText());
            company.setAddress(txtaddress.getText());
             company.setImg_url(fileNameInServer);
            company.setDescription(txtdescription.getText());
            company.setVille(txtville.getText());
            company.setImg_url(sh);
        Message m = new Message("bienvenue chez nous "
                + "\n"+"votre entreprise est "+ company.getName());
        m.getAttachments().put(textAttachmentUri, "text/plain");
        Display.getInstance().sendMessage(new String[] {company.getEmail()},"sucéss", m);
            ser.ajoutCompany(company);

//
//            ser.ajoutCompany(c);
//            f.show();
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
