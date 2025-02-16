package com.pacMan;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class KeyEvents implements KeyListener {

    private Game pac;
    private Board board;
    private int speed = 3;
    private int score =0;
    private int pom_score = score;
    private int x = 16;
    private int y = 16;
    private int i = 0;
    private int j = 0;

    //public int tab[][]= new int[board.getTabStartDraw().length][];

    private int Star[] ={
            16, 64, 118, 166, 217, 268, 316
    };
    

    public KeyEvents(Game pac, Board board){
        this.board = board;
        this.pac = pac;
    }


    @Override
    public void keyTyped(KeyEvent e){

    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
            if(i > 0){
                this.i -= 1;
                if(board.getTabStartDraw()[j][i] == 0){
                    x = Star[this.i];
                    y = Star[this.j];
                }
                else{
                    this.i +=1;
                }
            }
            pac.setXAxis(x);
            pac.setYAxis(y);
            pac.setImagePath("images//pacmanL.png");
            board.repaint();
        }
        else if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
            if(i < 6){
                this.i += 1;
                if(board.getTabStartDraw()[j][i] == 0){
                    x = Star[this.i];
                    y = Star[this.j];
                }
                else{
                    this.i -=1;
                }
            }
            pac.setXAxis(x);
            pac.setYAxis(y);
            pac.setImagePath("images//pacmanR.png");
            board.repaint();
        }
        else if(keyEvent.getKeyCode() == KeyEvent.VK_UP){
            if(j > 0 && j<=6) {
                this.j -= 1;
                if (board.getTabStartDraw()[j][i] == 0) {
                    x = Star[this.i];
                    y = Star[this.j];
                } else {
                    this.j += 1;
                }
            }
            pac.setXAxis(x);
            pac.setYAxis(y);
            pac.setImagePath("images//pacmanU.png");
            board.repaint();
        }
        else if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
            if(j < 6 && j>=0){
                this.j += 1;
                if(board.getTabStartDraw()[j][i] == 0){
                    x = Star[this.i];
                    y = Star[this.j];
                }
                else{
                    this.j -=1;
                }
            }
            pac.setXAxis(x);
            pac.setYAxis(y);
            pac.setImagePath("images//pacmanD.png");
            board.repaint();
        }
        this.score = pac.score(this.score,pac);
        board.setScore(this.score);
        System.out.println(this.score);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        /*if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT
                || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            x = Star[this.i];
            y = Star[this.j];
        }*/
    }
}
