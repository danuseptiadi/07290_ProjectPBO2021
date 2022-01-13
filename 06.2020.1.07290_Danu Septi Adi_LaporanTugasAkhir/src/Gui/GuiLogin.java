package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import AllObject.*;
public class GuiLogin extends Komponen {
    JButton btnloginadmin = new JButton();
    String pathicon;
    public GuiLogin(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Login");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,350);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(145, 134, 144));
        setLayout(null);
        setVisible(true);
        labelAdmin.setText("LOGIN");
        labelAdmin.setBounds(140,20,70,150);
        add(labelAdmin);
        labelNama.setBounds(35, 150, 80, 25);
        add(labelNama);
        txtNama.setBounds(130, 150, 130, 25);
        add(txtNama);
        
        labelPassword.setBounds(35, 210, 80, 25);
        add(labelPassword);
        txtPassword.setBounds(130, 210, 130, 25);
        add(txtPassword);
        
        btnLogin.setBounds(130, 260, 100, 25);
        btnLogin.setBackground(Color.black);
        btnLogin.setForeground(Color.white);
        btnLogin.setBorder(null);
        add(btnLogin);
        btnLogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setForeground(Color.black);
                btnLogin.setBackground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setForeground(Color.white);
                btnLogin.setBackground(Color.black);
            }
        });
        
        btnLogin.addActionListener(new ActionListener(){
            @Override
           public void actionPerformed(ActionEvent e){
                String nama = txtNama.getText();
                String password = txtPassword.getText();
                try{
                int cek = AllObjectController.adminController.checkAdmin(nama, password);
                if(cek > 0){
                    dispose();
                new GuiMenu().setVisible(true);
                
                } else {
                    try{
                    cek = AllObjectController.customerController.checkCustomer(nama, password);
                    if(cek > 0){
                    dispose();
                    GuiTransaksi guitransaksi = new GuiTransaksi(cek);
                    guitransaksi.setVisible(true);
                    }  else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    }
                  }
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Cancelled");
                    }
                    
                }
              }
                
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                
                }
            }
        });
    }
}
