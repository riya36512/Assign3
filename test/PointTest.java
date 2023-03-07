import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void turnType() {
        Point origin = new Point( 0, 0 );
        Point p1 = new Point( 0, 1 );
        Point p2 = new Point( 1, 1 );
        Point p3 = new Point( 1, 0 );
        Point p4 = new Point( 1, 10 );
        Point p5 = new Point( 1, -10 );

//        MapPlanner obj = new MapPlanner(20);
//        Boolean ans = obj.addStreet("ABC123",p1,p2);
//        Boolean ans1 = obj.addStreet("DEF143",p1,p4);
//        Boolean ans2 = obj.addStreet("EFG163",p5,p4);
//        Boolean ans3 = obj.addStreet("HIJ423",p1,p4);
//        System.out.println(ans);
//        System.out.println(ans1);
//        System.out.println(ans2);
//        System.out.println(ans3);
//        Location l1 = new Location("DEF143",StreetSide.Right);
//        Boolean loc = obj.depotLocation(l1);
//        System.out.println(loc);


        assertEquals( TurnDirection.Right, origin.turnType( p1, p4, 1 ) );
        assertEquals( TurnDirection.Straight, origin.turnType( p1, p4, 20 ) );
        assertEquals( TurnDirection.Right, origin.turnType( p1, p5, 1 ) );
        assertEquals( TurnDirection.UTurn, origin.turnType( p1, p5, 20 ) );
        assertEquals( TurnDirection.Left, p3.turnType( p2, p1, 1 ) );
    }
}