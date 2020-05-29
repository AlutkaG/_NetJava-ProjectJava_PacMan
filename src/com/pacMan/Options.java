package com.pacMan;

import javax.swing.*;

public class Options extends JFrame{

    private JPanel settings;

    public Options(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(settings);
        this.pack();
    }

    public static void Opt(){
        JFrame frame = new Options();
        frame.setVisible(true);
    }
}
