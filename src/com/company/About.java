package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    About(){
        setBounds(600,200,700,600);
        setLayout(null);

        JLabel l2 = new JLabel("<html>Notepad version 1 <br>This NotePad is developed by Vishal Verma <br>It is Free and open source <br> Feel free to donate </html>");
        l2.setBounds(50,30,500,300);
        l2.setFont(new Font("SAN SERIF",Font.PLAIN,18));
        add(l2);
        JButton b1;
        b1 = new JButton("OK");
        b1.setBounds(500,300,60,30);
        b1.addActionListener(this);
        add(b1);



        }
        public static void main(String[] args){
        new About().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
