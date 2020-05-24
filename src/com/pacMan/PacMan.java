package com.pacMan;

import javax.swing.*;
import java.awt.*;

public class PacMan extends JFrame{
    private JPanel startWindow;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public PacMan(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(startWindow);
        this.pack();

    }

    public static void main(String[] args){
        JFrame frame = new PacMan();
        frame.setVisible(true);
    }
}
