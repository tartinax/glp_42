package marine.map;

public class Road {
    private final Point connected;
    private final int length;
    private Boolean Pirate;

    public Road(final Point connected, int length) {
        this.connected = connected;
        this.length = length;
    }

    public Point getPoint() {return connected;}
    public boolean hasPirate() {return Pirate;}
    public int getLength() {return length;}

    public void setPirate(final boolean pirate) {Pirate = pirate;}


}
