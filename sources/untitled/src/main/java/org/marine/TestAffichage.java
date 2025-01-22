package org.marine;

//import org.marine.graphics.Camera;
import org.marine.map.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class TestAffichage extends JPanel {
    private Map map;
    public TestAffichage() {
        map = new Map();
        org.marine.map.Point A = new org.marine.map.Point(0,"Port",0,0);
        org.marine.map.Point B = new org.marine.map.Point(1,"Port",800,600);
        org.marine.map.Point C = new org.marine.map.Point(2,"Port",800,0);
        org.marine.map.Point D = new org.marine.map.Point(3,"Port",0,600);
        org.marine.map.Point E = new org.marine.map.Point(4,"Port",400,300);
        org.marine.map.Point F = new org.marine.map.Point(5,"Port",100,200);
        org.marine.map.Point G = new org.marine.map.Point(6,"Port",500,100);

        map.addPoint(A);
        map.addPoint(B);
        map.addPoint(C);
        map.addPoint(D);
        map.addPoint(E);
        map.addPoint(F);
        map.addPoint(G);

        A.addRoad(0,new Road(B,1));
        A.addRoad(1,new Road(C,1));
        A.addRoad(2,new Road(D,1));
        A.addRoad(3,new Road(E,1));

        B.addRoad(0,new Road(F,1));
        B.addRoad(1,new Road(G,1));

        C.addRoad(0,new Road(E,1));

        D.addRoad(1,new Road(A,1));
        E.addRoad(2,new Road(D,1));

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Appelle la méthode de la classe parente
        g.setColor(Color.RED);
        System.out.println(map.getPoints());
        for( org.marine.map.Point p : map.getPoints()){
            g.fillOval( (int) p.getX(), (int) p.getY(), 50, 50);

            for(Road r: p.getRoads().values()){
                g.drawLine((int) p.getX()+25,(int) p.getY()+25, r.getPoint().x+25, r.getPoint().y+25);
                System.out.println(""+r.getPoint().x+" "+r.getPoint().y);
                continue;
            }
        }

    }

    public static void main(String[] args) {
        // Créer la fenêtre principale
        JFrame frame = new JFrame("Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Créer un panneau personnalisé et l'ajouter à la fenêtre
        TestAffichage panneau = new TestAffichage();
        frame.add(panneau);

        // Afficher la fenêtre
        frame.setVisible(true);
    }
}