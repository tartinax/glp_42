package marine;

//import org.marine.graphics.Camera;
import marine.map.Map;
import marine.map.Point;
import marine.map.Road;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TestAffichageMap extends JPanel {

    private final Map map;

    public TestAffichageMap() {

        map = new Map();

        Point A = new Point(0,"Port",0,0);
        Point B = new Point(1,"Port",800,600);
        Point C = new Point(2,"Port",800,0);
        Point D = new Point(3,"Port",0,600);
        Point E = new Point(4,"Port",600,300);
        Point F = new Point(5,"Port",100,200);
        Point G = new Point(6,"Port",500,100);

        map.addPoint(A);
        map.addPoint(B);
        map.addPoint(C);
        map.addPoint(D);
        map.addPoint(E);
        map.addPoint(F);
        map.addPoint(G);

        A.addRoad(0,new Road(B,1));

        B.addRoad(0,new Road(C,1));



        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Appelle la méthode de la classe parente
        for( marine.map.Point p : map.getPoints()){
            g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
            g.fillOval( (int) p.getX(), (int) p.getY(), 50, 50);
            for(Road r: p.getRoads().values()){
                g.drawLine((int) p.getX()+25,(int) p.getY()+25, r.getPoint().x+25, r.getPoint().y+25);
            }
        }

    }

    public static void main(String[] args) {
        // Créer la fenêtre principale
        JFrame frame = new JFrame("Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);

        // Créer un panneau personnalisé et l'ajouter à la fenêtre
        TestAffichageMap panneau = new TestAffichageMap();
        frame.add(panneau);

        // Afficher la fenêtre
        frame.setVisible(true);
    }
}