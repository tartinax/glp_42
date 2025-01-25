package marine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class Main extends JPanel {

    private Image backgroundImage;  // Image de fond (ex. terrain)
    private final int cercleX = 100;
    private final int cercleY = 100;  // Position du cercle
    private final int CERCLE_DIAMETER = 50;  // Diamètre du cercle
    private int cameraX = 0, cameraY = 0;  // Position de la caméra

    // Constructeur pour charger l'image de fond
    public Main() {
        try {
            // Charger l'image de fond (peut être une image large)
            backgroundImage = ImageIO.read(new File("C:\\Users\\defra\\Downloads\\carte.jpg"));  // Remplacer par le chemin de votre image
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Permet de déplacer la caméra avec les touches fléchées
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Déplacer la caméra en fonction des touches fléchées
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        cameraX -= 10;  // Déplacer la caméra vers la gauche
                        break;
                    case KeyEvent.VK_RIGHT:
                        cameraX += 10;  // Déplacer la caméra vers la droite
                        break;
                    case KeyEvent.VK_UP:
                        cameraY -= 10;  // Déplacer la caméra vers le haut
                        break;
                    case KeyEvent.VK_DOWN:
                        cameraY += 10;  // Déplacer la caméra vers le bas
                        break;
                }
                repaint();  // Redessiner après le déplacement de la caméra
            }
        });
        setFocusable(true);  // Permet de capter les événements clavier
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Appelle la méthode de la classe parente

        // Dessiner l'image de fond (en fonction de la position de la caméra)
        if (backgroundImage != null) {
            // Décaler l'image en fonction de la position de la caméra
            g.drawImage(backgroundImage, -cameraX, -cameraY, this);
        }

        // Dessiner le cercle par-dessus l'image de fond, en tenant compte du décalage de la caméra
        g.setColor(Color.RED);
        g.fillOval(cercleX - cameraX, cercleY - cameraY, CERCLE_DIAMETER, CERCLE_DIAMETER);  // Décalage en fonction de la caméra
    }

    public static void main(String[] args) {
        // Créer la fenêtre principale
        JFrame frame = new JFrame("Caméra mobile avec un cercle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Créer un panneau personnalisé et l'ajouter à la fenêtre
        Main panneau = new Main();
        frame.add(panneau);

        // Afficher la fenêtre
        frame.setVisible(true);
    }
}