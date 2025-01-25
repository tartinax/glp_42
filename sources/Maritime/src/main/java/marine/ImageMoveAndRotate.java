package marine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageMoveAndRotate extends JPanel {
    private BufferedImage image;
    private final List<Boat> boats;  // Liste de bateaux
    private float t = 0;

    // Classe représentant un bateau
    private class Boat {
        double x, y; // Position du bateau
        double angle = 0; // Angle de rotation
        double speed = 2; // Vitesse du bateau
        double deltaX = 1, deltaY = 0; // Direction de déplacement

        // Constructeur du bateau
        public Boat(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Méthode pour mettre à jour la position et l'angle du bateau
        public void updatePosition() {
            t += 0.01;
            deltaY = Math.sin(t);
            deltaX = Math.cos(t);

            // Mettre à jour la position du bateau
            x += deltaX * speed;
            y += deltaY * speed;

            // Calculer l'angle de rotation en fonction de la direction
            angle = Math.atan2(deltaY, deltaX);
        }
    }

    public ImageMoveAndRotate() {
        try {
            // Charger l'image (ici on utilise une image exemple, mettez votre propre chemin)
            image = javax.imageio.ImageIO.read(new File("C:\\Users\\defra\\Downloads\\boat.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialiser la liste des bateaux
        boats = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            // Placer les bateaux à des positions différentes
            boats.add(new Boat(100 + i * 50, 100 + i * 30));
        }

        // Timer pour le mouvement et la rotation des bateaux
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mettre à jour la position et l'angle de chaque bateau
                for (Boat boat : boats) {
                    boat.updatePosition();
                }

                // Redessiner les bateaux
                repaint();
            }
        });
        timer.start();

        // Ajouter un MouseListener pour détecter les clics
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Vérifier si le clic est dans un des bateaux
                for (Boat boat : boats) {
                    if (isBoatClicked(e.getX(), e.getY(), boat)) {
                        // Afficher la pop-up si un bateau est cliqué
                        JOptionPane.showMessageDialog(null, "Tu as cliqué sur le bateau !");
                    }
                }
            }
        });
    }

    // Vérifier si le clic est dans les limites d'un bateau
    private boolean isBoatClicked(int mouseX, int mouseY, Boat boat) {
        // Calculer les coordonnées du coin supérieur gauche du bateau après translation
        int imgLeft = (int)(boat.x - image.getWidth() / 2);
        int imgTop = (int)(boat.y - image.getHeight() / 2);

        // Vérifier si le clic est dans la zone du bateau
        return (mouseX >= imgLeft && mouseX <= imgLeft + image.getWidth() &&
                mouseY >= imgTop && mouseY <= imgTop + image.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Vérifier si l'image a bien été chargée
        if (image == null) {
            System.out.println("L'image n'a pas été chargée correctement.");
            return; // Ne pas continuer si l'image est nulle
        }

        // Dessiner chaque bateau
        for (Boat boat : boats) {
            // Sauvegarder l'état des transformations actuelles
            AffineTransform originalTransform = g2d.getTransform();

            // Appliquer la rotation et la translation pour chaque bateau
            g2d.translate(boat.x, boat.y);  // Déplacer le bateau à la position (x, y)
            g2d.rotate(boat.angle);          // Appliquer la rotation (en radians)

            // Dessiner l'image du bateau
            g2d.drawImage(image, -image.getWidth() / 2, -image.getHeight() / 2, this);

            // Restauration des transformations
            g2d.setTransform(originalTransform);

            // Dessiner la hitbox (rectangle autour du bateau)
            drawHitbox(g2d, boat);
        }
    }

    // Dessiner la hitbox de chaque bateau
    private void drawHitbox(Graphics2D g2d, Boat boat) {
        // Calculer les coordonnées du coin supérieur gauche de la hitbox
        int imgLeft = (int)(boat.x - image.getWidth() / 2);
        int imgTop = (int)(boat.y - image.getHeight() / 2);

        // Dessiner un rectangle autour du bateau qui représente la hitbox
        g2d.setColor(Color.RED); // Couleur de la hitbox
        g2d.setStroke(new BasicStroke(2)); // Epaisseur du contour du rectangle
        g2d.drawRect(imgLeft, imgTop, image.getWidth(), image.getHeight());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Move and Rotate");
        ImageMoveAndRotate panel = new ImageMoveAndRotate();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}