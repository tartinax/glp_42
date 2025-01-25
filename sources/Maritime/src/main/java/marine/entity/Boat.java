package marine.entity;

public class Boat extends Entity {

    private int SPEED;
    private int DAMAGE;

    public Boat(int id) {
        super(id);
    }

    //getters
    public int getSPEED() {return SPEED;}
    public int getDAMAGE() {return DAMAGE;}

    //setters
    public void setSPEED(int speed) {SPEED = speed;}
    public void setDAMAGE(int damage) {DAMAGE = damage;}

}
