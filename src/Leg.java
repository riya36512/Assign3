public class Leg {

    private TurnDirection turn;
    private static String street;


    public Leg(TurnDirection turn, String street) {
        this.turn = turn;
        this.street = street;

    }

    public TurnDirection getTurnDirection() {
        return turn;
    }

    public static String getStreet() {
        return street;
    }

}