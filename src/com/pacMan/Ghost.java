package com.pacMan;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ghost extends  Game implements  Runnable{

    private Board board;
    public int direction_x = 1;
    public int direction_y = 1;
    public int ghost_x = 3;
    public int ghost_y = 4;
    private Game pac;
    private int BLOCK_SIZE = 50;
    private Random random;
    private int pos = 6;

    //           8 - do góry
    // 4 - w lewo           6 - prawo
    //           2 - w dół
    private int tabOfGhostPos[][]={
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

    public Ghost(int xAxis, int yAxis, String imagePath, boolean isAlive, Board board, Game pac){
        super(xAxis,yAxis,imagePath,isAlive);
        this.board = board;
        this.pac = pac;
    }

    public void kill(){
        Rectangle pacRect = new Rectangle(pac.getxAxis(), pac.getyAxis(), 100, 100);
        Rectangle ghostRect = new Rectangle(Star[ghost_x], Star[ghost_y], 150, 150);
        if(ghostRect.contains(pacRect)){
            JOptionPane.showMessageDialog(null,"You died!");
            System.exit(0);
        }
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Thread interrupted");
                System.exit(1);
            }

            if(ghost_y <6 && ghost_x<6 && ghost_x > 0 && ghost_y > 0) {
                if (tabOfGhostPos[ghost_y + 1][ghost_x] == 1 && tabOfGhostPos[ghost_y - 1][ghost_x] == 1 &&
                        tabOfGhostPos[ghost_y][ghost_x - 1] == 0 && tabOfGhostPos[ghost_y][ghost_x + 1] == 0) {
                    if (pos == 6) {
                        ghost_x += 1;
                        setXAxis(Star[ghost_x]);
                        pos = 6;
                        kill();
                    } else if (pos == 4) {
                        ghost_x -= 1;
                        setXAxis(Star[ghost_x]);
                        pos = 4;
                        kill();
                    }
                    kill();
                } else if (tabOfGhostPos[ghost_y + 1][ghost_x] == 1 && tabOfGhostPos[ghost_y - 1][ghost_x] == 0 &&
                        tabOfGhostPos[ghost_y][ghost_x - 1] == 0 && tabOfGhostPos[ghost_y][ghost_x + 1] == 0) {
                    if (pos == 4) {
                        random = new Random();
                        if (random.nextInt() % 2 == 0) {
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                            kill();
                        } else {
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                            kill();
                        }
                    }
                    else if(pos == 6){
                        random = new Random();
                        if (random.nextInt() % 2 == 0) {
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                            kill();
                        } else {
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                            kill();
                        }
                    }
                    else if(pos == 2){
                        random = new Random();
                        if (random.nextInt() % 2 == 0) {
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                            kill();
                        } else {
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                            kill();
                        }
                    }
                    kill();
                } else if (tabOfGhostPos[ghost_y - 1][ghost_x] == 1 && tabOfGhostPos[ghost_y + 1][ghost_x] == 0 &&
                        tabOfGhostPos[ghost_y][ghost_x - 1] == 0 && tabOfGhostPos[ghost_y][ghost_x + 1] == 0) {
                    if (pos == 6) {
                        random = new Random();
                        if (random.nextInt() % 2 == 0) {
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                            kill();
                        } else {
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                            kill();
                        }
                    }
                    else if(pos == 8){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                            kill();
                        }
                        else{
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                            kill();
                        }
                    }
                    else if(pos == 4){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                            kill();
                        }
                        else{
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                            kill();
                        }
                    }
                    kill();
                } else if (tabOfGhostPos[ghost_y - 1][ghost_x] == 0 && tabOfGhostPos[ghost_y + 1][ghost_x] == 0 &&
                        tabOfGhostPos[ghost_y][ghost_x - 1] == 1 && tabOfGhostPos[ghost_y][ghost_x + 1] == 1) {
                    if (pos == 2) {
                        ghost_y += 1;
                        setYAxis(Star[ghost_y]);
                        pos = 2;
                        kill();
                    } else {
                        ghost_y -= 1;
                        setYAxis(Star[ghost_y]);
                        pos = 8;
                        kill();
                    }
                    kill();
                }else if(tabOfGhostPos[ghost_y-1][ghost_x] == 0 && tabOfGhostPos[ghost_y+1][ghost_x] == 0 &&
                            tabOfGhostPos[ghost_y][ghost_x-1] == 1 && tabOfGhostPos[ghost_y][ghost_x+1] == 0){
                    if(pos == 8){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                            kill();
                        }
                        else{
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                            kill();
                        }
                    }
                    else if(pos == 2){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                            kill();
                        }
                        else{
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                            kill();
                        }
                    }
                    else if(pos == 4){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                            kill();
                        }
                        else{
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                            kill();
                        }
                    }
                    kill();
                }
                kill();
            }else if (ghost_y<6 && ghost_x == 6 && ghost_y > 0){
                if (tabOfGhostPos[ghost_y - 1][ghost_x] == 0 && tabOfGhostPos[ghost_y+1][ghost_x] == 0 &&
                        tabOfGhostPos[ghost_y][ghost_x - 1] == 0 ) {
                    System.out.println("x=6");
                    if(pos == 6){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                            kill();
                        }
                        else{
                            ghost_y +=1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                            kill();
                        }
                    }
                    else if(pos == 8){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                            kill();
                        }
                        else{
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                            kill();
                        }
                    }
                    else if(pos == 2){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                            kill();
                        }
                        else{
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                            kill();
                        }
                    }
                    kill();
                }
                else if(tabOfGhostPos[ghost_y-1][ghost_x] == 0 && tabOfGhostPos[ghost_y+1][ghost_x] == 0 &&
                            tabOfGhostPos[ghost_y][ghost_x-1] == 1 ){
                    if(pos == 8){
                        ghost_y -= 1;
                        setYAxis(Star[ghost_y]);
                        pos = 8;
                        kill();
                    }
                    else if(pos == 2){
                        ghost_y += 1;
                        setYAxis(Star[ghost_y]);
                        pos = 2;
                        kill();
                    }
                }
                kill();
            }
            else if (ghost_x <6 && ghost_y == 6 && ghost_x>0){
                if(tabOfGhostPos[ghost_y - 1][ghost_x] == 0 && tabOfGhostPos[ghost_y][ghost_x - 1] == 0 &&
                        tabOfGhostPos[ghost_y][ghost_x + 1] == 0 ) {
                    if (pos == 2) {
                        random = new Random();
                        if (random.nextInt() % 2 == 0) {
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                            kill();
                        } else {
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                            kill();
                        }
                        kill();
                    } else if (pos == 4) {
                        random = new Random();
                        if (random.nextInt() % 2 == 0) {
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                            kill();
                        } else {
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                            kill();
                        }
                        kill();
                    } else if (pos == 6) {
                        random = new Random();
                        if (random.nextInt() % 2 == 0) {
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                            kill();
                        } else {
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                            kill();
                        }
                        kill();
                    }
                    kill();
                }
                else if(tabOfGhostPos[ghost_y][ghost_x-1] == 0 && tabOfGhostPos[ghost_y][ghost_x+1] == 0 &&
                            tabOfGhostPos[ghost_y-1][ghost_x] == 1){
                    if(pos == 4){
                        ghost_x -= 1;
                        setXAxis(Star[ghost_x]);
                        pos = 4;
                        kill();
                    }
                    else{
                        ghost_x += 1;
                        setXAxis(Star[ghost_x]);
                        pos = 6;
                        kill();
                    }
                    kill();
                }
                kill();
            }
            else if(ghost_y == 6 && ghost_x == 6 && tabOfGhostPos[ghost_y-1][ghost_x] == 0 &&
                        tabOfGhostPos[ghost_y][ghost_x-1] == 0){
                if(pos == 2){
                    ghost_x -= 1;
                    setXAxis(Star[ghost_x]);
                    pos = 4;
                    kill();
                }
                else{
                    ghost_y -= 1;
                    setYAxis(Star[ghost_y]);
                    pos = 8;
                    kill();
                }
                kill();
            }
            else if(ghost_y == 6  && ghost_x == 0 && tabOfGhostPos[ghost_y-1][ghost_x] == 0 &&
                    tabOfGhostPos[ghost_y][ghost_x+1] == 0){
                if(pos == 4){
                    ghost_y -= 1;
                    setYAxis(Star[ghost_y]);
                    pos = 8;
                    kill();
                }
                else{
                    ghost_x += 1;
                    setXAxis(Star[ghost_x]);
                    pos = 6;
                    kill();
                }
                kill();
            }
            else if(ghost_x==0 && ghost_y > 0){
                if(tabOfGhostPos[ghost_y-1][ghost_x] == 0 && tabOfGhostPos[ghost_y+1][ghost_x] == 0 &&
                        tabOfGhostPos[ghost_y][ghost_x+1] == 1){
                    if(pos == 8){
                        ghost_y -= 1;
                        setYAxis(Star[ghost_y]);
                        pos = 8;
                        kill();
                    }
                    else{
                        ghost_y += 1;
                        setYAxis(Star[ghost_y]);
                        pos = 2;
                        kill();
                    }
                    kill();
                }
                else if(tabOfGhostPos[ghost_y-1][ghost_x] == 0 && tabOfGhostPos[ghost_y+1][ghost_x] == 0 &&
                        tabOfGhostPos[ghost_y][ghost_x+1] == 0){
                    if(pos == 8){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                            kill();
                        }
                        else{
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                            kill();
                        }
                        kill();
                    }
                    else if(pos == 2){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                            kill();
                        }
                        else{
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                            kill();
                        }
                        kill();
                    }
                    else if(pos == 4){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                            kill();
                        }
                        else{
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                            kill();
                        }
                        kill();
                    }
                }
                kill();
            }
            else if(ghost_x == 6 && ghost_y == 0 && tabOfGhostPos[ghost_y+1][ghost_x] == 0 &&
                        tabOfGhostPos[ghost_y][ghost_x-1] == 0){
                if(pos == 8){
                    ghost_x -= 1;
                    setXAxis(Star[ghost_x]);
                    pos = 4;
                    kill();
                }
                else if(pos == 6){
                    ghost_y += 1;
                    setYAxis(Star[ghost_y]);
                    pos = 2;
                    kill();
                }
                kill();
            }
            else if(ghost_y == 0 && ghost_x > 0){
                if(tabOfGhostPos[ghost_y+1][ghost_x] == 1 && tabOfGhostPos[ghost_y][ghost_x+1] == 0 &&
                        tabOfGhostPos[ghost_y][ghost_x-1] == 0){
                    if(pos == 4){
                        ghost_x -= 1;
                        setXAxis(Star[ghost_x]);
                        pos = 4;
                        kill();
                    }
                    else if(pos == 6){
                        ghost_x += 1;
                        setXAxis(Star[ghost_x]);
                        pos = 6;
                        kill();
                    }
                    kill();
                }
                else if(tabOfGhostPos[ghost_y+1][ghost_x] == 0 && tabOfGhostPos[ghost_y][ghost_x+1] == 0 &&
                        tabOfGhostPos[ghost_y][ghost_x-1] == 0){
                    if(pos == 4){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                            kill();
                        }
                        else{
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                            kill();
                        }
                        kill();
                    }
                    else if(pos == 8){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                            kill();
                        }
                        else{
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                            kill();
                        }
                        kill();
                    }
                    else if(pos == 6){
                        random = new Random();
                        if(random.nextInt() % 2 == 0){
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                            kill();
                        }
                        else{
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                            kill();
                        }
                        kill();
                    }
                }
                kill();
            }
            else if(ghost_x == 0 && ghost_y == 0 && tabOfGhostPos[ghost_y+1][ghost_x] == 0 &&
                        tabOfGhostPos[ghost_y][ghost_x+1] == 0){
                if(pos == 4){
                    ghost_y += 1;
                    setYAxis(Star[ghost_y]);
                    pos = 2;
                    kill();
                }
                else if(pos == 8){
                    ghost_x += 1;
                    setXAxis(Star[ghost_x]);
                    pos = 6;
                    kill();
                }
                kill();
            }
            kill();
            board.repaint();
        }
    }
}
