package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Console;
import java.util.Random;

public class Animation extends JFrame implements Runnable{

    int deltaX;
    int deltaY;

    int deltaX2;
    int deltaY2;

    //balle1
    int balleX;
    int balleY;
    int balleTailleWidth;
    int balleTailleHeigth;

    //balle2
    int balleX2;
    int balleY2;
    int balleTailleWidth2;
    int balleTailleHeigth2;

    //Ecran
    int ecranX;
    int ecranY;
    int ecranTailleWidth;
    int ecranTailleHeigth;

    //obstacle
    int obstacleX;
    int obstacleY;
    int obstacleTailleWidth;
    int obstacleTailleHeigth;


    public Animation(){

        deltaX = 10;
        deltaY = 10;

        deltaX2 = 10;
        deltaY2 = 10;

        //obstacle
        obstacleX = 200;
        obstacleY = 200;
        obstacleTailleWidth = 100;
        obstacleTailleHeigth = 100;

        //ecran
        ecranX = 50;
        ecranY = 50;
        ecranTailleWidth = 400;
        ecranTailleHeigth = 400;

        //balle1
        balleX = 100;
        balleY = 126;
        balleTailleWidth = 25;
        balleTailleHeigth = 25;

        //balle2
        balleX2 = 150;
        balleY2 = 226;
        balleTailleWidth2 = 25;
        balleTailleHeigth2 = 25;


        int LargeurFenetre = 500;
        int LongeurFenetre = 500;
        setVisible(true);
        //setResizable(false);
        setSize(LongeurFenetre, LargeurFenetre);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp = new JPanel() {
            public void paint(Graphics g) {
                super.paint(g);

                //ecran
                g.setColor(Color.BLUE);
                g.drawRect(ecranX, ecranY, ecranTailleWidth, ecranTailleWidth);
                g.fillOval(balleX, balleY, balleTailleWidth, balleTailleHeigth);

                //balle1
                g.setColor(Color.red);
                g.drawOval(obstacleX, obstacleY, obstacleTailleWidth, obstacleTailleHeigth);

                //balle2
                g.setColor(Color.green);
                g.fillOval(balleX2, balleY2, balleTailleWidth2, balleTailleHeigth2);


            }

        };
        this.add(jp);
    }



    @Override
    public void run() {
        //ajouter une variable bool
        int n =  0 ;

        while(n++ <  900) {
            try {

                //balle 1
                balleX = balleX + deltaX;
                balleY = balleY + deltaY;
                System.out.println(obstacleX+obstacleTailleWidth);
                if(balleX >= (ecranTailleWidth + balleTailleWidth))
                {
                    deltaX = -20;
                }

                if(balleX <= (ecranX))
                {
                    deltaX = 10;
                }

                if(balleY >= (ecranTailleHeigth))
                {
                    deltaY = -10;
                }

                if(balleY <= (ecranY))
                {
                    deltaY = 10;
                }

                //Obstacle
                if (balleY <= (obstacleY))
                {
                    deltaY = +10;

                }
                if (balleY >= (obstacleY ))
                {
                    deltaY = -10;
                }
                if (balleX <= (obstacleX))
                {
                    deltaX = +10;

                }
                if (balleX >= (obstacleX))
                {
                    deltaX = -10;

                }


                //balle 2
                balleX2 = balleX2 + deltaX2;
                balleY2 = balleY2 + deltaY2;

                if(balleX2 > (ecranTailleWidth + balleTailleWidth))
                {
                    deltaX2 = -10;
                }

                if(balleX2 < (ecranX))
                {
                    deltaX2 = 10;
                }

                if(balleY2 > (ecranTailleHeigth + 25))
                {
                    deltaY2 = -10;
                }

                if(balleY2 < (ecranY))
                {
                    deltaY2 = 10;
                }

                //collision balles
                /*
                if (balleX == balleX2 && balleY == balleY2)
                {
                    deltaX = -deltaX;
                    deltaX2 = +deltaX2;
                    System.out.println("collsion!");
                }
                 */




                repaint();
                Thread.sleep(60) ;

            }  catch (InterruptedException e) {

                // gestion de l'erreur
            }
        }


    }
}
