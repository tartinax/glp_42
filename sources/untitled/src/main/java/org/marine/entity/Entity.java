package org.marine.entity;
import org.marine.inventory.Inventory;

import java.awt.*;

public class Entity {
    private int ID;
    private String NAME;
    private String TYPE;
    private String MODEL;
    private Inventory INVENTORY;

    private Point MAP_P;
    private double MAP_ANGLE;

    private int VISION_RANGE;
    private static int MAX_HEALTH_POINT;
    private  int HEALTH_POINT;

    private String FACTION;

    public Entity(int id) {this.ID=id;}


    //Getters
    public int getID() {return ID;}
    public String getNAME() {return NAME;}
    public String getTYPE() {return TYPE;}
    public String getMODEL() {return MODEL;}
    public Inventory getINVENTORY() {return INVENTORY;}
    public int getVISION_RANGE() {return VISION_RANGE;}
    public int getHEALTH_POINT() {return HEALTH_POINT;}
    public double getMAP_X() {return MAP_P.getX();}
    public double getMAP_Y() {return MAP_P.getY();}
    public double getMAP_ANGLE() {return MAP_ANGLE;}
    public String getFACTION() {return FACTION;}


    //Setters
    public void setID(int id) {this.ID = id;}
    public void setNAME(String name) {this.NAME = name;}
    public void setTYPE(String type) {this.TYPE = type;}
    public void setINVENTORY(Inventory inventory) {this.INVENTORY = inventory;}
    public void setVISION_RANGE(int range) {VISION_RANGE = range;}
    public void setMODEL(String model) {this.MODEL = model;}
    public void setHEALTH_POINT(int point) {HEALTH_POINT = point;}
    public void setMAP_LOCATION(int x, int y) {MAP_P.setLocation(x,y);}
    public void setMAP_ANGLE(int angle) {MAP_ANGLE = angle;}
    public void setFACTION(String name) {FACTION=name;}



    public void addInventory(String Elem, int Quantity){}
    public void remInventory(String Elem, int Quantity){}



}
