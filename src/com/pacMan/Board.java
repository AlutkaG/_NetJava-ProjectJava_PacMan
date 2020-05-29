package com.pacMan;

import javax.swing.*;
import java.awt.*;
import java.util.logging.ConsoleHandler;

public class Board extends JPanel{

    private int XAXIS_OF_GHOST =166;
    private int YAXIS_OF_GHOST = 217;
    public int widthOfBoard = 370;
    public int heightOfBoard = 450;
    private int BLOCK_SIZE = 50;

    private int tab[][]={
            {0,0,0,0,0,0,0},
            {0,1,0,1,1,1,0},
            {0,1,0,0,0,0,0},
            {0,1,0,1,1,1,0},
            {0,0,0,0,0,0,0},
            {0,1,1,1,0,1,0},
            {0,0,0,0,0,0,0}
    };
    private int Star[] ={
            16, 64, 118, 166, 217, 268, 316

    };

    JFrame window = new JFrame("Pacman");
    Game pac = new Game(16,16,"images//pacman1.png", true);
    KeyEvents keyEvents = new KeyEvents(pac,this);
    Ghost ghost1 = new Ghost(XAXIS_OF_GHOST,YAXIS_OF_GHOST,"images//ghost.png",true, this, pac);

    public Board(){

        window.addKeyListener(keyEvents);
        window.setFocusable(true);
        window.add(this);
        Thread thread1= new Thread(ghost1);
        thread1.start();

        window.setSize(widthOfBoard,heightOfBoard);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }


    public void paint(Graphics g2d){
        ImageIcon imageIcon = new ImageIcon("images//back.png");
        g2d.drawImage(imageIcon.getImage(),0,0,null);
        drawMaze(g2d);
        pac.drawPacman(g2d);
        ghost1.drawPacman(g2d);

    }

    private void drawMaze(Graphics g2d) {

        g2d.setColor(Color.blue);
        // Prostokąt nr 1
        g2d.drawLine(BLOCK_SIZE, BLOCK_SIZE, 2 * BLOCK_SIZE, BLOCK_SIZE);
        g2d.drawLine(BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 4 * BLOCK_SIZE);
        g2d.drawLine(BLOCK_SIZE, 4 * BLOCK_SIZE, 2 * BLOCK_SIZE, 4 * BLOCK_SIZE);
        g2d.drawLine(2 * BLOCK_SIZE, BLOCK_SIZE, 2 * BLOCK_SIZE, 4 * BLOCK_SIZE);
        // Prostokat nr 2
        g2d.drawLine(3 * BLOCK_SIZE, BLOCK_SIZE, 6 * BLOCK_SIZE, BLOCK_SIZE);
        g2d.drawLine(3 * BLOCK_SIZE, BLOCK_SIZE, 3 * BLOCK_SIZE, 2 * BLOCK_SIZE);
        g2d.drawLine(3 * BLOCK_SIZE, 2 * BLOCK_SIZE, 6 * BLOCK_SIZE, 2 * BLOCK_SIZE);
        g2d.drawLine(6 * BLOCK_SIZE, BLOCK_SIZE, 6 * BLOCK_SIZE, 2 * BLOCK_SIZE);
        // Prostokat nr 3
        g2d.drawLine(3 * BLOCK_SIZE, 3 * BLOCK_SIZE, 6 * BLOCK_SIZE, 3 * BLOCK_SIZE);
        g2d.drawLine(3 * BLOCK_SIZE, 3 * BLOCK_SIZE, 3 * BLOCK_SIZE, 4 * BLOCK_SIZE);
        g2d.drawLine(3 * BLOCK_SIZE, 4 * BLOCK_SIZE, 6 * BLOCK_SIZE, 4 * BLOCK_SIZE);
        g2d.drawLine(6 * BLOCK_SIZE, 3 * BLOCK_SIZE, 6 * BLOCK_SIZE, 4 * BLOCK_SIZE);
        //Prostokat nr 4
        g2d.drawLine(BLOCK_SIZE, 5 * BLOCK_SIZE, 4 * BLOCK_SIZE, 5 * BLOCK_SIZE);
        g2d.drawLine(BLOCK_SIZE, 5 * BLOCK_SIZE, BLOCK_SIZE, 6 * BLOCK_SIZE);
        g2d.drawLine(BLOCK_SIZE, 6 * BLOCK_SIZE, 4 * BLOCK_SIZE, 6 * BLOCK_SIZE);
        g2d.drawLine(4 * BLOCK_SIZE, 5 * BLOCK_SIZE, 4 * BLOCK_SIZE, 6 * BLOCK_SIZE);
        // Prostokat nr 5
        g2d.drawLine(5 * BLOCK_SIZE, 5 * BLOCK_SIZE, 6 * BLOCK_SIZE, 5 * BLOCK_SIZE);
        g2d.drawLine(5 * BLOCK_SIZE, 5 * BLOCK_SIZE, 5 * BLOCK_SIZE, 6 * BLOCK_SIZE);
        g2d.drawLine(5 * BLOCK_SIZE, 6 * BLOCK_SIZE, 6 * BLOCK_SIZE, 6 * BLOCK_SIZE);
        g2d.drawLine(6 * BLOCK_SIZE, 5 * BLOCK_SIZE, 6 * BLOCK_SIZE, 6 * BLOCK_SIZE);

        // Kropki
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if(pac.getxAxis()==Star[j] && pac.getyAxis()==Star[i] && tab[i][j]==0){
                    tab[i][j]=1;
                }
                if( tab[i][j]==0) {
                    g2d.setColor(Color.PINK);
                    g2d.fillRect(j * BLOCK_SIZE + BLOCK_SIZE / 2, i * BLOCK_SIZE + BLOCK_SIZE / 2, 8, 8);
                }
            }
        }
    }
}