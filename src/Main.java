import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Point origin = new Point( 0, 0 );
        Point p1 = new Point( 0, 1 );
        Point p2 = new Point( 1, 1 );
        Point p3 = new Point( 1, 0 );
        Point p4 = new Point( 1, 10 );
        Point p5 = new Point( 1, -10 );
        MapPlanner obj = new MapPlanner(2);

        obj.addStreet("A",p1,p2);
        obj.addStreet("B",p1,p4);
        obj.addStreet("C",p5,p4);
        obj.addStreet("D",p1,p4);
        obj.addStreet("E",p1,p3);
        obj.addStreet("F",p1,p5);
        Location l1 = new Location("D",StreetSide.Right);
        Boolean loc = obj.depotLocation(l1);
        System.out.println(loc);

        Leg leg1 = new Leg(TurnDirection.Right,"A" );
        Leg leg2 = new Leg(TurnDirection.Right,"B" );
        Leg leg3 = new Leg(TurnDirection.Straight,"B" );
        Leg leg4 = new Leg(TurnDirection.Right,"D" );
        Leg leg5 = new Leg(TurnDirection.UTurn,"E" );

        ArrayList<Leg> LEGS  = new ArrayList<>();
        LEGS.add(leg1);
        LEGS.add(leg2);
        LEGS.add(leg3);
        LEGS.add(leg4);
        LEGS.add(leg5);
        Route r1 = new Route(LEGS);

        String strID = r1.turnOnto(3);
        System.out.println(strID);

        TurnDirection turn = r1.turnDirection(3);
        System.out.println(turn);
    }
}