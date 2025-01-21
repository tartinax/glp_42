package org.marine.faction;
import org.marine.entity.Boat;
import org.marine.entity.Harbor;

import java.util.HashMap;

public class Faction {
    private int ID;
    private String NAME;
    private String Color;
    private String Type;
    private HashMap<String, Harbor> EMPIRE;
    private HashMap<Integer, Boat> ARMADA;

    public Faction(int id) {this.ID = id;}

    //getters
    public int getID() {return ID;}
    public String getNAME() {return NAME;}
    public String getColor() {return Color;}
    public String getType() {return Type;}
    public HashMap<String, Harbor> getEMPIRE() {return EMPIRE;}
    public HashMap<Integer, Boat> getARMADA() {return ARMADA;}
    public Harbor getEMPIRE(String elem) {return EMPIRE.get(elem);}
    public Boat getARMADA(int elem) {return ARMADA.get(elem);}

    //setters
    public void setID(int ID) {this.ID = ID;}
    public void setNAME(String NAME) {this.NAME = NAME;}
    public void setColor(String Color) {this.Color = Color;}
    public void setType(String Type) {this.Type = Type;}


    //Hashmap commands
    public void putEMPIRE(Harbor harbor) {EMPIRE.put(harbor.getNAME(), harbor);}
    public void putARMADA(Boat boat) {ARMADA.put(boat.getID(), boat); }
    public void remEMPIRE(Harbor harbor) {EMPIRE.put(harbor.getNAME(), harbor);}
    public void remARMADA(Boat boat) {ARMADA.put(boat.getID(), boat); }


}
