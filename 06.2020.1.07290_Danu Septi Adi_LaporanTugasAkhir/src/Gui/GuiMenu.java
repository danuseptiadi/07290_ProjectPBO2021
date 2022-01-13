package Gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenu extends Komponen {

    public GuiMenu() {
        initComponent();
    }

    public void initComponent(){
        setSize(350 , 350);
        
        getContentPane().setBackground(new Color(145, 134, 144));
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnCustomer.setBounds(100, 40 , 150 , 50);
        btnCustomer.setFont(new Font("Arial" , Font.BOLD,17));
        add(btnCustomer);

        btnBarang.setBounds(100, 110 , 150 , 50);
        btnBarang.setFont(new Font("Arial" , Font.BOLD,17));
        add(btnBarang);

        
        btnKeluar.setBounds(100 , 180 , 150 , 50);
        btnBarang.setFont(new Font("Arial" , Font.BOLD,17));
        add(btnKeluar);
        
        btnCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiCustomer().setVisible(true);
            }
        });

        btnBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiBarang().setVisible(true);
            }
        });
        
        
        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiLogin().setVisible(true);
            }
        });
        
        
    }
}
