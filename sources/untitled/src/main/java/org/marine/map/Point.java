package org.marine.map;
import java.util.HashMap;

public class Point extends java.awt.Point {
    private String Name;
    private int ID;
    HashMap<Integer,Road> roads;

    public Point(int Id,String NAME,int x, int y) {
        super(x,y);
        roads = new HashMap<Integer,Road>();
        this.Name = NAME;
        this.ID = Id;
    }

    //getters
    public int getId(){ return ID; }
    public String getName() {return Name;}
    public HashMap<Integer,Road> getRoads() {return roads;}
    public Road getRoad(int id) {return roads.get(id);}


    //setters
    public void setId(int value) { ID = value; }
    public void setName(String value) { Name = value; }
    public void addRoad(int id,Road road) {roads.put(id,road);}
    public void remRoad(int id,Road road) {roads.remove(id);}

}
