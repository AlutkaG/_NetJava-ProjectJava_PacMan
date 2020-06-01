package com.pacMan;

import javax.swing.*;
import java.awt.*;

public class Game{
    private int xAxis =0;
    private int yAxis =0;
    private String imagePath;
    private boolean isAlive;
    private int BLOCK_SIZE=50;
    private int score=0;
    private int win=0;
    Board board;

    private int Star[] ={
            16, 64, 118, 166, 217, 268, 316

    };

    private int tabScore[][]={
        {1,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0}
    };

    private int tab[][]={
            {0,0,0,0,0,0,0},
            {0,1,0,1,1,1,0},
            {0,1,0,0,0,0,0},
            {0,1,0,1,1,1,0},
            {0,0,0,0,0,0,0},
            {0,1,1,1,0,1,0},
            {0,0,0,0,0,0,0}
    };

    public Game(int xAxis, int yAxis, String imagePath, boolean isAlive){
        setXAxis(xAxis);
        setYAxis(yAxis);
        setImagePath(imagePath);
        setIsAlive(isAlive);
    }


    public void setXAxis(int xAxis){
        if(isAlive){
            if(this.xAxis >= 317){
                this.xAxis = 317;
            }else if(this.xAxis <=15){
                this.xAxis = 15;
            }else{
                this.xAxis = xAxis;
            }
        }else{
            this.xAxis = xAxis;
        }
    }

    public void setYAxis(int yAxis){
        if(isAlive){
            if(this.yAxis >= 317){
                this.yAxis = 317;
            }else if(this.yAxis <=15){
                this.yAxis = 15;
            }else{
                this.yAxis = yAxis;
            }
        }else{
            this.yAxis = yAxis;
        }
    }

    public void setImagePath(String imagePath){
        if(imagePath == null){
            JOptionPane.showMessageDialog(null,"Image is null");
            System.exit(1);
        }
        else {
            this.imagePath = imagePath;
        }
    }

    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public int getxAxis(){
        return xAxis;
    }

    public int getyAxis(){
        return yAxis;
    }

    public String getImagePath(){
        return imagePath;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public void drawPacman(Graphics graphics){
        ImageIcon img = new ImageIcon(imagePath);
        graphics.drawImage(img.getImage(),xAxis,yAxis,null);
    }

    public int score(int score,Game pac){
        for(int i=0; i<7; i++){
                for(int j=0; j<7; j++){
                    if(pac.getxAxis()==Star[j] && pac.getyAxis()==Star[i] && tabScore[i][j]==0){
                        score++;
                        tabScore[i][j]=1;
                        win++;

                        if(win == 35){
                            JOptionPane.showMessageDialog(null,"You win!");
                            System.exit(0);
                        }
                    }
                }
        }
        return score;
    }

    /*public void win(){
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){

            }
        }
        JOptionPane.showMessageDialog(null,"You died!");
        System.exit(0);
    }*/
}