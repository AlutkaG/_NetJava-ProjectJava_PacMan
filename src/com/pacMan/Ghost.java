package com.pacMan;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ghost extends  Game implements  Runnable{

    private Board board;
    public int direction_x = 1;
    public int direction_y = 1;
    public int ghost_x = 6;
    public int ghost_y = 6;
    private Game pac;
    private int BLOCK_SIZE = 50;
    private Random random;
    private int pos = 6;

    //           8 - do góry
    // 4 - w lewo           6 - prawo
    //           2 - w dół


    private int Star[] ={
            16, 64, 118, 166, 217, 268, 316
    };

    public Ghost(int xAxis, int yAxis, String imagePath, boolean isAlive, Board board, Game pac){
        super(xAxis,yAxis,imagePath,isAlive, board);
        this.board = board;
        this.pac = pac;
    }

    public void kill(){
        Rectangle pacRect = new Rectangle(pac.getxAxis(), pac.getyAxis(), 50, 50);
        Rectangle ghostRect = new Rectangle(Star[ghost_x], Star[ghost_y], 100, 100);
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

            /*if(ghost_y <6 && ghost_x<6 && ghost_x > 0 && ghost_y > 0) {
                if (board.getTabStartDraw()[ghost_y + 1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y - 1][ghost_x] == 1 &&
                        board.getTabStartDraw()[ghost_y][ghost_x - 1] == 0 && board.getTabStartDraw()[ghost_y][ghost_x + 1] == 0) {
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
                } else if (board.getTabStartDraw()[ghost_y + 1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y - 1][ghost_x] == 0 &&
                        board.getTabStartDraw()[ghost_y][ghost_x - 1] == 0 && board.getTabStartDraw()[ghost_y][ghost_x + 1] == 0) {
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
                } else if (board.getTabStartDraw()[ghost_y - 1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y + 1][ghost_x] == 0 &&
                        board.getTabStartDraw()[ghost_y][ghost_x - 1] == 0 && board.getTabStartDraw()[ghost_y][ghost_x + 1] == 0) {
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
                } else if (board.getTabStartDraw()[ghost_y - 1][ghost_x] == 0 && board.getTabStartDraw()[ghost_y + 1][ghost_x] == 0 &&
                        board.getTabStartDraw()[ghost_y][ghost_x - 1] == 1 && board.getTabStartDraw()[ghost_y][ghost_x + 1] == 1) {
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
                }else if(board.getTabStartDraw()[ghost_y-1][ghost_x] == 0 && board.getTabStartDraw()[ghost_y+1][ghost_x] == 0 &&
                            board.getTabStartDraw()[ghost_y][ghost_x-1] == 1 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 0){
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
                if (board.getTabStartDraw()[ghost_y - 1][ghost_x] == 0 && board.getTabStartDraw()[ghost_y+1][ghost_x] == 0 &&
                        board.getTabStartDraw()[ghost_y][ghost_x - 1] == 0 ) {
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
                else if(board.getTabStartDraw()[ghost_y-1][ghost_x] == 0 && board.getTabStartDraw()[ghost_y+1][ghost_x] == 0 &&
                            board.getTabStartDraw()[ghost_y][ghost_x-1] == 1 ){
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
                if(board.getTabStartDraw()[ghost_y - 1][ghost_x] == 0 && board.getTabStartDraw()[ghost_y][ghost_x - 1] == 0 &&
                        board.getTabStartDraw()[ghost_y][ghost_x + 1] == 0 ) {
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
                else if(board.getTabStartDraw()[ghost_y][ghost_x-1] == 0 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 0 &&
                            board.getTabStartDraw()[ghost_y-1][ghost_x] == 1){
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
            else if(ghost_y == 6 && ghost_x == 6 && board.getTabStartDraw()[ghost_y-1][ghost_x] == 0 &&
                        board.getTabStartDraw()[ghost_y][ghost_x-1] == 0){
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
            else if(ghost_y == 6  && ghost_x == 0 && board.getTabStartDraw()[ghost_y-1][ghost_x] == 0 &&
                    board.getTabStartDraw()[ghost_y][ghost_x+1] == 0){
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
                if(board.getTabStartDraw()[ghost_y-1][ghost_x] == 0 && board.getTabStartDraw()[ghost_y+1][ghost_x] == 0 &&
                        board.getTabStartDraw()[ghost_y][ghost_x+1] == 1){
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
                else if(board.getTabStartDraw()[ghost_y-1][ghost_x] == 0 && board.getTabStartDraw()[ghost_y+1][ghost_x] == 0 &&
                        board.getTabStartDraw()[ghost_y][ghost_x+1] == 0){
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
            else if(ghost_x == 6 && ghost_y == 0 && board.getTabStartDraw()[ghost_y+1][ghost_x] == 0 &&
                        board.getTabStartDraw()[ghost_y][ghost_x-1] == 0){
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
                if(board.getTabStartDraw()[ghost_y+1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 0 &&
                        board.getTabStartDraw()[ghost_y][ghost_x-1] == 0){
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
                else if(board.getTabStartDraw()[ghost_y+1][ghost_x] == 0 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 0 &&
                        board.getTabStartDraw()[ghost_y][ghost_x-1] == 0){
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
            else if(ghost_x == 0 && ghost_y == 0 && board.getTabStartDraw()[ghost_y+1][ghost_x] == 0 &&
                        board.getTabStartDraw()[ghost_y][ghost_x+1] == 0){
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
            }*/

            if(ghost_y <6 && ghost_x<6 && ghost_x > 0 && ghost_y > 0){
                // jezeli po lewej i prawej znajduje sie przeszkoda
                if(board.getTabStartDraw()[ghost_y][ghost_x+1] == 1 && board.getTabStartDraw()[ghost_y][ghost_x-1] == 1){
                    if(pos == 2){
                        ghost_y +=1;
                        setYAxis(Star[ghost_y]);
                        pos = 2;
                    }
                    else if(pos == 8){
                        ghost_y -= 1;
                        setYAxis(Star[ghost_y]);
                        pos = 8;
                    }
                }
                //jezeli na dole i na gorze znajduje sie przeszkoda
                else if(board.getTabStartDraw()[ghost_y-1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y+1][ghost_x-1] == 1){
                    if(pos == 6){
                        ghost_x += 1;
                        setXAxis(Star[ghost_x]);
                        pos = 6;
                    }
                    else if(pos == 4){
                        ghost_x -= 1;
                        setXAxis(Star[ghost_x]);
                        pos = 4;
                    }
                }
                // jezeli po prawej stronie znajduje sie przeszkoda
                 else if(board.getTabStartDraw()[ghost_y][ghost_x+1] == 1) {
                     // jezeli idziemy od lewej strony
                     if (pos == 6) {
                         // jezeli na gorze znajduje sie przeszkoda, ale na dole nie
                         if (board.getTabStartDraw()[ghost_y - 1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y + 1][ghost_x] == 0) {
                             ghost_y += 1;
                             setYAxis(Star[ghost_y]);
                             pos = 2;
                         }
                         // jezeli na dole jest przeszkoda a na gorze nie ma
                         else if (board.getTabStartDraw()[ghost_y - 1][ghost_x] == 0 && board.getTabStartDraw()[ghost_y + 1][ghost_x] == 1) {
                             ghost_y -= 1;
                             setYAxis(Star[ghost_y]);
                             pos = 8;
                         }
                         // jezeli na gorze i na dole znajduje sie przeszkoda
                         else if (board.getTabStartDraw()[ghost_y - 1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y + 1][ghost_x] == 1) {
                             ghost_x -= 1;
                             setXAxis(Star[ghost_x]);
                             pos = 4;
                         }
                         // jezeli nie ma na dole i na gorze przeszkod
                         else if (board.getTabStartDraw()[ghost_y - 1][ghost_x] == 0 && board.getTabStartDraw()[ghost_y + 1][ghost_x] == 0) {
                             random = new Random();
                             if (random.nextInt() % 2 == 0) {
                                 ghost_y += 1;
                                 setYAxis(Star[ghost_y]);
                                 pos = 2;
                             } else {
                                 ghost_y -= 1;
                                 setYAxis(Star[ghost_y]);
                                 pos = 8;
                             }
                         }
                     } else if (pos == 2) {
                         // jezeli na dole nie ma przeszkod
                         if (board.getTabStartDraw()[ghost_y + 1][ghost_x] == 0) {
                             ghost_y += 1;
                             setYAxis(Star[ghost_y]);
                             pos = 2;
                         }
                         // jezeli na dole jest przeszkoda a po lewej nie
                         else if (board.getTabStartDraw()[ghost_y][ghost_x - 1] == 0 && board.getTabStartDraw()[ghost_y + 1][ghost_x] == 1) {
                             ghost_x -= 1;
                             setXAxis(Star[ghost_x]);
                             pos = 4;
                         }
                         // jezeli na dole i po lewej jest przeszkoda
                         else if (board.getTabStartDraw()[ghost_y + 1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y][ghost_x - 1] == 1) {
                             ghost_y -= 1;
                             setYAxis(Star[ghost_y]);
                             pos = 8;
                         }
                     }
                     // jezeli idziemy od dolu
                     else if (pos == 8) {
                         // jezeli na gorze nie ma przeszkod
                         if (board.getTabStartDraw()[ghost_y - 1][ghost_x] == 0) {
                             ghost_y -= 1;
                             setYAxis(Star[ghost_y]);
                             pos = 8;
                         }
                         // jezeli na gorze jest przeszkoda a po lewej nie
                         else if (board.getTabStartDraw()[ghost_y][ghost_x - 1] == 0 && board.getTabStartDraw()[ghost_y - 1][ghost_x] == 1) {
                             ghost_x -= 1;
                             setXAxis(Star[ghost_x]);
                             pos = 4;
                         }
                         // jezeli na gorze i po lewej jest przeszkoda
                         else if (board.getTabStartDraw()[ghost_y - 1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y][ghost_x - 1] == 1) {
                             ghost_y += 1;
                             setYAxis(Star[ghost_y]);
                             pos = 2;
                         }
                     }
                 }
                 // jezeli jest przeszkoda na gorze
                else if(board.getTabStartDraw()[ghost_y-1][ghost_x] == 1){
                     if (pos == 8) {
                         // jezeli po lewej znajduje sie przeszkoda, ale po prawej nie
                         if (board.getTabStartDraw()[ghost_y][ghost_x-1] == 1 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 0) {
                             ghost_x += 1;
                             setXAxis(Star[ghost_x]);
                             pos = 6;
                         }
                         // jezeli po prawej jest przeszkoda a po lewej nie ma
                         else if (board.getTabStartDraw()[ghost_y][ghost_x-1] == 0 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 1) {
                             ghost_x -= 1;
                             setXAxis(Star[ghost_x]);
                             pos = 4;
                         }
                         // jezeli po lewej i prawej znajduje sie przeszkoda
                         else if (board.getTabStartDraw()[ghost_y][ghost_x-1] == 1 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 1) {
                             ghost_y += 1;
                             setYAxis(Star[ghost_y]);
                             pos = 2;
                         }
                         // jezeli nie ma po prawej i lewej przeszkod
                         else if (board.getTabStartDraw()[ghost_y][ghost_x-1] == 0 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 0) {
                             random = new Random();
                             if (random.nextInt() % 2 == 0) {
                                 ghost_x += 1;
                                 setXAxis(Star[ghost_x]);
                                 pos = 6;
                             } else {
                                 ghost_x -= 1;
                                 setXAxis(Star[ghost_x]);
                                 pos = 4;
                             }
                         }
                     }
                     // jeeli idziemy od lewej
                     else if (pos == 6) {
                         // jezeli na po prawej nie ma przeszkod
                         if (board.getTabStartDraw()[ghost_y][ghost_x+1] == 0) {
                             ghost_x += 1;
                             setXAxis(Star[ghost_x]);
                             pos = 6;
                         }
                         // jezeli po prawej jest przeszkoda a na dole nie
                         else if (board.getTabStartDraw()[ghost_y][ghost_x + 1] == 1 && board.getTabStartDraw()[ghost_y + 1][ghost_x] == 0) {
                             ghost_y += 1;
                             setYAxis(Star[ghost_y]);
                             pos = 2;
                         }
                         // jezeli po prawej i na dole jest przeszkoda
                         else if (board.getTabStartDraw()[ghost_y + 1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y][ghost_x + 1] == 1) {
                             ghost_x -= 1;
                             setXAxis(Star[ghost_x]);
                             pos = 4;
                         }
                     }
                     // jezeli idziemy od prawej
                     else if (pos == 4) {
                         // jezeli po lewej nie ma przeszkod
                         if (board.getTabStartDraw()[ghost_y][ghost_x-1] == 0) {
                             ghost_x -= 1;
                             setXAxis(Star[ghost_x]);
                             pos = 4;
                         }
                         // jezeli po lewej jest przeszkoda a na dole nie
                         else if (board.getTabStartDraw()[ghost_y][ghost_x - 1] == 1 && board.getTabStartDraw()[ghost_y + 1][ghost_x] == 0) {
                             ghost_y += 1;
                             setYAxis(Star[ghost_y]);
                             pos = 2;
                         }
                         // jezeli po lewej i na dole jest przeszkoda
                         else if (board.getTabStartDraw()[ghost_y][ghost_x-1] == 1 && board.getTabStartDraw()[ghost_y + 1][ghost_x] == 1) {
                             ghost_x += 1;
                             setXAxis(Star[ghost_x]);
                             pos = 6;
                         }
                     }
                 }
                // jezeli jest przeszkoda na dole
                else if(board.getTabStartDraw()[ghost_y+1][ghost_x] == 1){
                    if (pos == 2) {
                        // jezeli po lewej znajduje sie przeszkoda, ale po prawej nie
                        if (board.getTabStartDraw()[ghost_y][ghost_x-1] == 1 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 0) {
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                        // jezeli po prawej jest przeszkoda a po lewej nie ma
                        else if (board.getTabStartDraw()[ghost_y][ghost_x-1] == 0 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 1) {
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                        }
                        // jezeli po lewej i prawej znajduje sie przeszkoda
                        else if (board.getTabStartDraw()[ghost_y][ghost_x-1] == 1 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 1) {
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                        }
                        // jezeli nie ma po prawej i lewej przeszkod
                        else if (board.getTabStartDraw()[ghost_y][ghost_x-1] == 0 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 0) {
                            random = new Random();
                            if (random.nextInt() % 2 == 0) {
                                ghost_x += 1;
                                setXAxis(Star[ghost_x]);
                                pos = 6;
                            } else {
                                ghost_x -= 1;
                                setXAxis(Star[ghost_x]);
                                pos = 4;
                            }
                        }
                    }
                    // jeeli idziemy od lewej
                    else if (pos == 6) {
                        // jezeli po prawej nie ma przeszkod
                        if (board.getTabStartDraw()[ghost_y][ghost_x+1] == 0) {
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                        // jezeli po prawej jest przeszkoda a na gorze nie
                        else if (board.getTabStartDraw()[ghost_y][ghost_x + 1] == 1 && board.getTabStartDraw()[ghost_y - 1][ghost_x] == 0) {
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                        }
                        // jezeli po prawej i na gorze jest przeszkoda
                        else if (board.getTabStartDraw()[ghost_y - 1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y][ghost_x + 1] == 1) {
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                        }
                    }
                    // jezeli idziemy od prawej
                    else if (pos == 4) {
                        // jezeli po lewej nie ma przeszkod
                        if (board.getTabStartDraw()[ghost_y][ghost_x-1] == 0) {
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                        }
                        // jezeli po lewej jest przeszkoda a na gorze nie
                        else if (board.getTabStartDraw()[ghost_y][ghost_x - 1] == 1 && board.getTabStartDraw()[ghost_y - 1][ghost_x] == 0) {
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                        }
                        // jezeli po lewej i na gorze jest przeszkoda
                        else if (board.getTabStartDraw()[ghost_y][ghost_x-1] == 1 && board.getTabStartDraw()[ghost_y - 1][ghost_x] == 1) {
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                    }
                }
                // jezeli jest przeszkoda po lewej
                else if(board.getTabStartDraw()[ghost_y][ghost_x-1] == 1){
                    // jezeli idziemy od prawej
                    if (pos == 4) {
                        // jezeli na dole znajduje sie przeszkoda, ale na gorze nie
                        if (board.getTabStartDraw()[ghost_y + 1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y - 1][ghost_x] == 0) {
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                        }
                        // jezeli na gorze jest przeszkoda a na dole nie ma
                        else if (board.getTabStartDraw()[ghost_y - 1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y + 1][ghost_x] == 0) {
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                        }
                        // jezeli na gorze i na dole znajduje sie przeszkoda
                        else if (board.getTabStartDraw()[ghost_y-1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y+1][ghost_x] == 1) {
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                        // jezeli nie ma na gorze i na dole przeszkod
                        else if (board.getTabStartDraw()[ghost_y-1][ghost_x] == 0 && board.getTabStartDraw()[ghost_y+1][ghost_x] == 0) {
                            random = new Random();
                            if (random.nextInt() % 2 == 0) {
                                ghost_y += 1;
                                setYAxis(Star[ghost_y]);
                                pos = 2;
                            } else {
                                ghost_y -= 1;
                                setYAxis(Star[ghost_y]);
                                pos = 8;
                            }
                        }
                    }
                    // jeeli idziemy od gory
                    else if (pos == 2) {
                        // jezeli na dole nie ma przeszkod
                        if (board.getTabStartDraw()[ghost_y+1][ghost_x] == 0) {
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                        }
                        // jezeli na dole jest przeszkoda a po prawej nie
                        else if (board.getTabStartDraw()[ghost_y+1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 0) {
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                        // jezeli na dole i po prawej jest przeszkoda
                        else if (board.getTabStartDraw()[ghost_y + 1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y][ghost_x + 1] == 1) {
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                        }
                    }
                    // jezeli idziemy od dolu
                    else if (pos == 8) {
                        // jezeli na gorze nie ma przeszkod
                        if (board.getTabStartDraw()[ghost_y-1][ghost_x] == 0) {
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                        }
                        // jezeli na gorze jest przeszkoda a po prawej nie
                        else if (board.getTabStartDraw()[ghost_y-1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 0) {
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                        // jezeli na gorze i po prawej jest przeszkoda
                        else if (board.getTabStartDraw()[ghost_y-1][ghost_x] == 1 && board.getTabStartDraw()[ghost_y][ghost_x+1] == 1) {
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                        }
                    }
                }
                //jezeli na okolo nie ma przeszkod
                else if(board.getTabStartDraw()[ghost_y][ghost_x+1] == 0 && board.getTabStartDraw()[ghost_y][ghost_x-1] == 0 && board.getTabStartDraw()[ghost_y+1][ghost_x] == 0 && board.getTabStartDraw()[ghost_y-1][ghost_x] == 0){
                    //jezeli idziemy od lewej
                    if(pos == 6){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            Random r = new Random();
                            if(r.nextInt()%2 == 0){
                                ghost_y -= 1;
                                setYAxis(Star[ghost_y]);
                                pos = 8;
                            }
                            else{
                                ghost_y += 1;
                                setYAxis(Star[ghost_y]);
                                pos = 2;
                            }
                        }
                        else{
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                    }
                    //jezeli idziemy od prawej
                    else if(pos == 4){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            Random r = new Random();
                            if(r.nextInt()%2 == 0){
                                ghost_y -= 1;
                                setYAxis(Star[ghost_y]);
                                pos = 8;
                            }
                            else{
                                ghost_y += 1;
                                setYAxis(Star[ghost_y]);
                                pos = 2;
                            }
                        }
                        else{
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                        }
                    }
                    //jezeli idziemy od gory
                    else if(pos == 2){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            Random r = new Random();
                            if(r.nextInt()%2 == 0){
                                ghost_x -= 1;
                                setXAxis(Star[ghost_x]);
                                pos = 4;
                            }
                            else{
                                ghost_x += 1;
                                setXAxis(Star[ghost_x]);
                                pos = 6;
                            }
                        }
                        else{
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                        }
                    }
                    //jezeli idziemy od dolu
                    else if(pos == 8){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            Random r = new Random();
                            if(r.nextInt()%2 == 0){
                                ghost_x -= 1;
                                setXAxis(Star[ghost_x]);
                                pos = 4;
                            }
                            else{
                                ghost_x += 1;
                                setXAxis(Star[ghost_x]);
                                pos = 6;
                            }
                        }
                        else{
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                        }
                    }
                }

            }
            // poruszamy sie po prawej krawedzi planszy
            else if(ghost_x == 6 && ghost_y <6 && ghost_y >0){
                // jezeli mamy po lewej przeszkody
                if(board.getTabStartDraw()[ghost_y][ghost_x-1] == 1){
                    // jezeli idziemy od gory
                    if(pos == 2){
                        ghost_y += 1;
                        setYAxis(Star[ghost_y]);
                        pos = 2;
                    }
                    else if(pos == 8){
                        ghost_y -= 1;
                        setYAxis(Star[ghost_y]);
                        pos = 8;
                    }
                }
                // gdy z lewej nie ma przeszkody
                else if(board.getTabStartDraw()[ghost_y][ghost_x-1] == 0){
                    // jezeli idziemy od gory
                    if(pos == 2){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                        }
                        else{
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                        }
                    }
                    else if(pos == 8){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                        }
                        else{
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                        }
                    }
                    else if(pos == 6){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                           ghost_y -= 1;
                           setYAxis(Star[ghost_y]);
                           pos = 8;
                        }
                        else{
                           ghost_y += 1;
                           setYAxis(Star[ghost_y]);
                           pos = 2;
                        }

                    }
                }
            }
            // poruszamy sie po lewej krawedzi
            else if(ghost_x == 0 && ghost_y > 0 && ghost_y < 6){
                // jezeli mamy po prawej przeszkody
                if(board.getTabStartDraw()[ghost_y][ghost_x+1] == 1){
                    // jezeli idziemy od gory
                    if(pos == 2){
                        ghost_y += 1;
                        setYAxis(Star[ghost_y]);
                        pos = 2;
                    }
                    else if(pos == 8){
                        ghost_y -= 1;
                        setYAxis(Star[ghost_y]);
                        pos = 8;
                    }
                }
                // gdy z prawej nie ma przeszkody
                else{
                    // jezeli idziemy od gory
                    if(pos == 2){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                        else{
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                        }
                    }
                    else if(pos == 8){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                        else{
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                        }
                    }
                    else if(pos == 4){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                        }
                        else{
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                        }
                    }
                }
            }
            // poruszamy sie po gornej krawedzi planszy
            else if(ghost_y == 0 && ghost_x > 0 && ghost_x < 6){
                // jezeli mamy na dole przeszkody
                if(board.getTabStartDraw()[ghost_y+1][ghost_x] == 1){
                    // jezeli idziemy od lewej
                    if(pos == 6){
                        ghost_x += 1;
                        setXAxis(Star[ghost_x]);
                        pos = 6;
                    }
                    else if(pos == 4){
                        ghost_x -= 1;
                        setXAxis(Star[ghost_x]);
                        pos = 4;
                    }
                }
                // gdy od dołu nie ma przeszkody
                else{
                    // jezeli idziemy od lewej
                    if(pos == 6){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                        }
                        else{
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                    }
                    else if(pos == 4){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                        }
                        else{
                            ghost_y += 1;
                            setYAxis(Star[ghost_y]);
                            pos = 2;
                        }
                    }
                    else if(pos == 8){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                        else{
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                        }
                    }
                }
            }
            // poruszamy sie po dolnej krawedzi planszy
            else if(ghost_y == 6 && ghost_x > 0 && ghost_x < 6){
                // jezeli mamy na gorze przeszkody
                if(board.getTabStartDraw()[ghost_y-1][ghost_x] == 1){
                    // jezeli idziemy od lewej
                    if(pos == 6){
                        ghost_x += 1;
                        setXAxis(Star[ghost_x]);
                        pos = 6;
                    }
                    else if(pos == 4){
                        ghost_x -= 1;
                        setXAxis(Star[ghost_x]);
                        pos = 4;
                    }
                }
                // gdy od gory nie ma przeszkody
                else{
                    // jezeli idziemy od lewej
                    if(pos == 6){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                        }
                        else{
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                    }
                    else if(pos == 4){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                        }
                        else{
                            ghost_y -= 1;
                            setYAxis(Star[ghost_y]);
                            pos = 8;
                        }
                    }
                    else if(pos == 2){
                        random = new Random();
                        if(random.nextInt()%2 == 0){
                            ghost_x += 1;
                            setXAxis(Star[ghost_x]);
                            pos = 6;
                        }
                        else{
                            ghost_x -= 1;
                            setXAxis(Star[ghost_x]);
                            pos = 4;
                        }
                    }
                }
            }
            // jezeli stoimy w gornym lewym rogu
            else if(ghost_x == 0 && ghost_y == 0){
               if(pos == 8){
                   ghost_x += 1;
                   setXAxis(Star[ghost_x]);
                   pos = 6;
               }
               else if(pos == 4){
                   ghost_y += 1;
                   setYAxis(Star[ghost_y]);
                   pos = 2;
               }
            }
            // jezeli stoimy w gornym prawym rogu
            else if(ghost_x == 6 && ghost_y == 0){
                if(pos == 8){
                    ghost_x -= 1;
                    setXAxis(Star[ghost_x]);
                    pos = 4;
                }
                else if(pos == 6){
                    ghost_y += 1;
                    setYAxis(Star[ghost_y]);
                    pos = 2;
                }
            }
            // jezeli stoimy w dolnym lewym rogu
            else if(ghost_x == 0 && ghost_y == 6){
                if(pos == 2){
                    ghost_x += 1;
                    setXAxis(Star[ghost_x]);
                    pos = 6;
                }
                else if(pos == 4){
                    ghost_y -= 1;
                    setYAxis(Star[ghost_y]);
                    pos = 8;
                }
            }
            // jezeli stoimy w dolnym prawym rogu
            else if(ghost_x == 6 && ghost_y == 6){
                if(pos == 2){
                    ghost_x -= 1;
                    setXAxis(Star[ghost_x]);
                    pos = 4;
                }
                else if(pos == 6){
                    ghost_y -= 1;
                    setYAxis(Star[ghost_y]);
                    pos = 8;
                }
            }
            kill();
            board.repaint();
        }
    }
}
