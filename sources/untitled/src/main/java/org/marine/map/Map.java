package org.marine.map;
import java.util.ArrayList;

public class Map {
    private ArrayList<Point> points;
    public Map() {
        points = new ArrayList<Point>();
    }

    //getters
    public void addPoint(int ID, String NAME, int x, int y){points.add(new Point(ID,NAME,x,y));}
    public void addPoint(Point p){points.add(p);}

    public Point getPoint(int ID){return points.get(ID);}
    public ArrayList<Point> getPoints(){return points;}

    //setters
    public void remPoint(int ID){points.remove(ID);}
    public void setPoints(ArrayList<Point> points){this.points = points;}


}
