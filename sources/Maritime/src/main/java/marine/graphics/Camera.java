package marine.graphics;

public class Camera {
    private int WIDTH, HEIGHT;
    private double ZOOM;
    private int x,y;

    public Camera(int width, int height, double zoom, int x, int y) {
        WIDTH = width; HEIGHT = height;
        ZOOM = zoom;
        this.x = x; this.y = y;}

    //getters
    public int getWidth() { return WIDTH; }
    public int getHeight() { return HEIGHT; }
    public double getZoom() { return ZOOM; }
    public int getX() { return x; }
    public int getY() { return y; }

    //setters
    public void setWidth(int width) { WIDTH = width; }
    public void setHeight(int height) { HEIGHT = height; }
    public void setZoom(double zoom) { ZOOM = zoom; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public void addX(int x) { this.x += x; }
    public void addY(int y) { this.y += y; }

}
