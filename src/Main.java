import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Point origin = new Point( 0, 0 );
        Point p1 = new Point( 0, 1 );
        Point p2 = new Point( 1, 1 );
        Point p3 = new Point( 1, 0 );
        Point p4 = new Point( 1, 12 );
        Point p5 = new Point( 1, -10 );
        MapPlanner obj = new MapPlanner(2);

        obj.addStreet("A",p1,p2);
        obj.addStreet("B",p1,p4);
        obj.addStreet("C",p2,p3);

        obj.addStreet("E",p3,p5);
        obj.addStreet("F",p1,p5);
        ArrayList<Street> print=(ArrayList<Street>) obj.streets;

        Street s1 = new Street("A",p1,p2);
        Street s2 = new Street("C",p2,p3);
        Street s3 = new Street("E",p3,p5);
        Leg leg1 = new Leg(TurnDirection.Right,s1);
        Leg leg2 = new Leg(TurnDirection.Straight,s2);
        Leg leg3 = new Leg(TurnDirection.Straight,s3);
        ArrayList<Leg> LEGS  = new ArrayList<>();
        LEGS.add(leg1);
        LEGS.add(leg2);
        LEGS.add(leg3);

        Street s4 = new Street("F",p1,p5);
        Route rou1 = new Route(LEGS);
        Boolean ans  = rou1.appendTurn(TurnDirection.Right,s4);
        System.out.println(ans);
        rou1.streetPassLength(print);
        int totalLegs = Route.legs();
        System.out.println(totalLegs);

        System.out.println(Route.turnOnto(2));
        System.out.println(Route.turnDirection(4));

        double length = rou1.length();
        System.out.println(length);

        Location l1 = new Location("A",StreetSide.Right);
        obj.depotLocation(l1);

        System.out.println("Furthest Street");
        System.out.println(obj.furthestStreet());

    }
}