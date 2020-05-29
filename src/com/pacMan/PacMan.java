package com.pacMan;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class PacMan extends JFrame{
    private JPanel startWindow;
    private JButton start;
    private JButton options;
    private JButton exit;

    public PacMan(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(startWindow);
        this.pack();

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Options opt = new Options();
                opt.Opt();

            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board b=new Board();
                //run.main();

            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new PacMan();
        frame.setVisible(true);
    }

}
