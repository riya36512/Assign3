public class Leg {

    private TurnDirection turn;
    private static Street street;


    public Leg(TurnDirection turn, Street street) {
        this.turn = turn;
        this.street = street;

    }

    public TurnDirection getTurnDirection() {
        return turn;
    }

    public static Street getStreet() {
        return street;
    }

}