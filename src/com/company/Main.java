package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main extends JFrame implements ActionListener {

    JTextArea area;
    JScrollPane pane;
    String text;
    Main(){
setBounds(0,0,1950,1000);

JMenuBar menuBar = new JMenuBar();
JMenu file =new JMenu("File");

JMenuItem newdoc = new JMenuItem("new");


newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
newdoc.addActionListener(this);

        JMenuItem open = new JMenuItem("open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        open.addActionListener(this);

        JMenuItem save = new JMenuItem("save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        save.addActionListener(this);


        JMenuItem print = new JMenuItem("print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        print.addActionListener(this);

        JMenuItem exit = new JMenuItem("exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
        exit.addActionListener(this);

  file.add(newdoc);

        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);


        JMenu edit =new JMenu("Edit");


        JMenuItem cut = new JMenuItem("cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        cut.addActionListener(this);

        JMenuItem copy = new JMenuItem("copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copy.addActionListener(this);


        JMenuItem paste = new JMenuItem("paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        paste.addActionListener(this);

        JMenuItem selectall = new JMenuItem("Select all");
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        selectall.addActionListener(this);

        edit.add(cut);
        edit.add(copy);
        edit.add(selectall);
        edit.add(paste);



        JMenu help =new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        about.addActionListener(this);

        help.add(about);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
        setJMenuBar(menuBar);

area = new JTextArea();
area.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
area.setLineWrap(true);
area.setWrapStyleWord(true);
pane =  new JScrollPane(area);
pane.setBorder(BorderFactory.createEmptyBorder());
add(pane, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
	// write your code here
        new Main().setVisible(true);
        System.out.println("Hello Java");
        System.out.println("Hello bc");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("new")){
                area.setText("");
        }else if(e.getActionCommand().equals("open")) {
            JFileChooser chooser = new JFileChooser("D:");
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt", "txt");
            chooser.addChoosableFileFilter(restrict);
            int action = chooser.showOpenDialog(this);
            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File file = chooser.getSelectedFile();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                area.read(reader,null);

            }catch (Exception e1){

            }


        }else if (e.getActionCommand().equals("save")){
            JFileChooser saveas = new JFileChooser();
            saveas.setApproveButtonText("Save");
            int action = saveas.showOpenDialog(this);
            if(action!=JFileChooser.APPROVE_OPTION){
                return;
            }
            File filename = new File(saveas.getSelectedFile()+".txt");

            BufferedWriter outFile = null;

            try
            {
                outFile= new BufferedWriter(new FileWriter(filename));
                area.write(outFile);

            }
            catch (Exception el){

            }


        }else if (e.getActionCommand().equals("print")){
            try {
                area.print();
            } catch (PrinterException printerException) {
                printerException.printStackTrace();
            }
        }else if (e.getActionCommand().equals("exit")){
            System.exit(0);
        }else if(e.getActionCommand().equals("copy")) text = area.getSelectedText();
        else if(e.getActionCommand().equals("paste")) area.insert(text, area.getCaretPosition());
        else if (e.getActionCommand().equals("cut")){
            text = area.getSelectedText();
            area.replaceRange("",area.getSelectionStart(),area.getSelectionEnd());

        }else if (e.getActionCommand().equals("Select all")){
 area.selectAll();
        }
        else if (e.getActionCommand().equals("About")){
            new About().setVisible(true);
        }


    }
}
