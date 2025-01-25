package marine.faction;
import marine.entity.Boat;
import marine.entity.Port;

import java.util.HashMap;

public class Faction {
    private int ID;
    private String NAME;
    private String Color;
    private String Type;
    private HashMap<String, Port> EMPIRE;
    private HashMap<Integer, Boat> ARMADA;

    public Faction(int id) {this.ID = id;}

    //getters
    public int getID() {return ID;}
    public String getNAME() {return NAME;}
    public String getColor() {return Color;}
    public String getType() {return Type;}
    public HashMap<String, Port> getEMPIRE() {return EMPIRE;}
    public HashMap<Integer, Boat> getARMADA() {return ARMADA;}
    public Port getEMPIRE(String elem) {return EMPIRE.get(elem);}
    public Boat getARMADA(int elem) {return ARMADA.get(elem);}

    //setters
    public void setID(int ID) {this.ID = ID;}
    public void setNAME(String NAME) {this.NAME = NAME;}
    public void setColor(String Color) {this.Color = Color;}
    public void setType(String Type) {this.Type = Type;}


    //Hashmap commands
    public void putEMPIRE(Port harbor) {EMPIRE.put(harbor.getNAME(), harbor);}
    public void putARMADA(Boat boat) {ARMADA.put(boat.getID(), boat); }
    public void remEMPIRE(Port harbor) {EMPIRE.put(harbor.getNAME(), harbor);}
    public void remARMADA(Boat boat) {ARMADA.put(boat.getID(), boat); }


}
