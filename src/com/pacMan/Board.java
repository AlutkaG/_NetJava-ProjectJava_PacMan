package com.pacMan;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.ConsoleHandler;

public class Board extends JPanel{

    private int XAXIS_OF_GHOST =316;
    private int YAXIS_OF_GHOST = 316;
    public int widthOfBoard = 370;
    public int heightOfBoard = 450;
    private int BLOCK_SIZE = 50;
    private int score =0;
    public int winScore = 0;
    KeyEvents key;

    private int tabStartDraw[][] = new int[7][7];

    private int tab[][]= new int[tabStartDraw.length][];

    public int[][] getTabStartDraw(){
     return tabStartDraw;
    }

    private int Star[] ={
            16, 64, 118, 166, 217, 268, 316

    };


    JFrame window = new JFrame("Pacman");
    static JLabel l;
    Game pac = new Game(16,16,"images//pacmanR.png", true, this);
    KeyEvents keyEvents = new KeyEvents(pac,this);
    Ghost ghost1 = new Ghost(XAXIS_OF_GHOST,YAXIS_OF_GHOST,"images//ghost.png",true, this, pac);

    public Board(){
        // losowanie planszy
        for(int i = 1; i<6; i++){
            for(int j = 1; j<6; j++){
                Random r = new Random();
                this.tabStartDraw[i][j] = r.nextInt(2);
            }
        }
        // kopiowanie planszy, aby na niej usuwac kropki itd.
        for(int i = 1; i<6; i++){
            for(int j = 1; j<6; j++){
                if(this.tabStartDraw[i][j] == 1 && (this.tabStartDraw[i-1][j+1] == 1 || this.tabStartDraw[i+1][j+1] == 1 ||
                        this.tabStartDraw[i+1][j-1] == 1 || this.tabStartDraw[i-1][j-1] == 1)){
                    this.tabStartDraw[i][j] = 0;
                }
            }
        }
        // zliczanie "0" (do zliczania punktow)
        for(int i = 0; i<7; i++){
            for(int j = 0; j<7; j++){
                if(this.tabStartDraw[i][j] == 0){
                    this.winScore++;
                }
            }
        }


        for (int i = 0; i < tabStartDraw.length; i++) {
            tab[i] = Arrays.copyOf(tabStartDraw[i], tabStartDraw[i].length);
        }

        window.addKeyListener(keyEvents);
        window.setFocusable(true);
        window.add(this);
        Thread thread1= new Thread(ghost1);
        thread1.start();

        window.setSize(widthOfBoard,heightOfBoard);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void setScore(int sc){
        this.score = sc;

    }
    public void paint(Graphics g2d){

        ImageIcon imageIcon = new ImageIcon("images//back.png");
        g2d.drawImage(imageIcon.getImage(),0,0,null);
        drawMaze(g2d);
        pac.drawPacman(g2d);
        ghost1.drawPacman(g2d);
        g2d.setColor(Color.GREEN);
        g2d.setFont(new Font("monospaced", Font.PLAIN, 30));
        g2d.drawString("Score: "+score, 110, 380);
    }

    private void drawMaze(Graphics g2d) {

        g2d.setColor(Color.blue);
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                // jezeli "jedynki" znajduja sie w srodku planszy a nie na brzegach
                if(i>0 && j>0 && i<6 && j<6){
                    if(tabStartDraw[i][j] == 1){
                        // SYTUACJA:
                        // 1 0
                        if(tabStartDraw[i][j+1] == 0){
                            g2d.drawLine(BLOCK_SIZE*(j+1),BLOCK_SIZE*i,BLOCK_SIZE*(j+1),BLOCK_SIZE*i+BLOCK_SIZE);
                        }
                        // SYTUACJA:
                        // 0 1
                        if(tabStartDraw[i][j-1] == 0){
                            g2d.drawLine(BLOCK_SIZE*j, BLOCK_SIZE*i, BLOCK_SIZE*j,BLOCK_SIZE*i+BLOCK_SIZE);
                        }
                        // SYTUACJA:
                        // 0
                        // 1
                        if(tabStartDraw[i-1][j] == 0){
                            g2d.drawLine(BLOCK_SIZE*j, BLOCK_SIZE*i, BLOCK_SIZE*j+BLOCK_SIZE, BLOCK_SIZE*i);
                        }
                        // SYTUACJA:
                        // 1
                        // 0
                        if(tabStartDraw[i+1][j] == 0){
                            g2d.drawLine(BLOCK_SIZE*j, BLOCK_SIZE*(i+1), BLOCK_SIZE*j+BLOCK_SIZE,BLOCK_SIZE*(i+1));
                        }
                    }

                }

            }
        }



        // Prostokąt nr 1
        /*g2d.drawLine(BLOCK_SIZE, BLOCK_SIZE, 2 * BLOCK_SIZE, BLOCK_SIZE);
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
        */
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