public class Leg {

    private TurnDirection turn;
    private String street;
    static Point startLeg;
    static Point endLeg;

    public Leg(TurnDirection turn, String street, Point startLeg, Point endLeg) {
        this.turn = turn;
        this.street = street;
        this.startLeg= startLeg;
        this.endLeg = endLeg;
    }

    public TurnDirection getTurnDirection() {
        return turn;
    }

    public String getStreet() {
        return street;
    }
    public static Point getStartLeg(){
        return startLeg;
    }
    public static Point getEndLeg(){
        return endLeg;
    }
}