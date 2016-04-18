/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import model.Aplikasi;
import model.Petugas;
import view.mnLogin1;

/**
 *
 * @author fuad,hani,lenni
 */
 

public class ControllerB implements ActionListener{
   //private Aplikasi app;
    private Petugas p = new Petugas("a","a","a","a","admin","admin");
    private Aplikasi model = new Aplikasi();
    private mnLogin1 login;
    private Object view;
    public ControllerB(){
    login=new mnLogin1();
    login.addListener(this);
    login.setVisible(true);
    view = login;
    }
    
    public boolean login() throws IOException {
        return model.login(login.getUsername(), login.getPassword());
    }

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(view instanceof mnLogin1){
            if(source.equals(login.getBtnLogin())){
                
                if((p.getIdPetugas().equals(login.getUsername()))&&(p.getPassword().equals(login.getPassword()))){
                    
                 new ControllerA(model);
                 login.dispose();
                 
                }
                else{
                   login.loginerror();
                }
            }
            login.dispose();
        }
       
    }
}
