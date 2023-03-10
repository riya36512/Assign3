import java.util.List;
import java.util.ArrayList;
/**
 * Define a route to travel in the map.  It's a sequence of turns and streets in the city map.
 *
 * The first leg of a route is leg 1.
 */

// Class to represent a leg of the route, including the start and end intersections and the turn direction


public class Route {

    private static List<Leg> legs;

    // Constructor to create an empty route
    public Route() {
        this.legs = new ArrayList<>();
    }

    // Constructor to create a route with a given list of legs
    public Route(List<Leg> legs) {
        this.legs = legs;
    }
    /**
     * Grow a Route by adding one step (called a "leg") of the route at a time.  This method adds one more
     * leg to an existing route
     * @param turn -- from the current route, what kind of turn do you make onto the next leg
     * @param streetTurnedOnto -- the street id onto which the next leg of the route turns
     * @return -- true if the leg was added to the route.
     */
    public Boolean appendTurn(TurnDirection turn, Street streetTurnedOnto) {
        if (turn == null || streetTurnedOnto == null) {
            return false;
        }
        Leg newLeg = new Leg(turn, streetTurnedOnto);
        legs.add(newLeg);
        Point start = null;
        Point end = null;
        for (Street st: tempStreets){
            if(st.getId() == streetTurnedOnto.getId())
            {
                start = st.getStart();
                end = st.getEnd();
            }
        }
        Street newst = new Street(streetTurnedOnto.getId(),start,end);
        tempStreets.add(newst);
        return true;
    }

    /**
     * Given a route, report whether the street of the given leg number of the route.
     *
     * Leg numbers begin with 1.
     * @param legNumber -- the leg number for which we want the next street.
     * @return -- the street id of the next leg, or null if there is an error.
     */
    public static String turnOnto(int legNumber) {
        // check if the leg number is valid

        if (legNumber < 1 || legNumber > legs.size()) {
            return null;
        }

        // get the leg corresponding to the given leg number
        Leg leg = legs.get(legNumber - 1);

        // look up the street ID of the end intersection of the leg
//        int endIntersection = leg.getEndIntersection();
        String streetId = leg.getStreet().getId();

        return streetId;
    }

    /**
     * Given a route, report whether the type of turn that initiates the given leg number of the route.
     *
     * Leg numbers begin with 1.
     * @param legNumber -- the leg number for which we want the next turn.
     * @return -- the turn direction for the leg, or null if there is an error.
     */
    public static TurnDirection turnDirection(int legNumber) {
        // check if the leg number is valid
        if (legNumber < 1 || legNumber > legs.size()) {
            return null;
        }

        // get the leg corresponding to the given leg number
        Leg leg = legs.get(legNumber - 1);

        // return the turn direction of the leg
        return leg.getTurnDirection();
    }

    /**
     * Report how many legs exist in the current route
     * @return -- the number of legs in this route.
     */
    public static int legs() {
        return legs.size();
    }
    List<Street> tempStreets =new ArrayList<>();
    public void streetPassLength(ArrayList<Street> tempS){
        tempStreets=tempS;
    }

    /**
     * Report the length of the current route.  Length is computed in metres by Euclidean distance.
     *
     * By assumption, the route always starts and ends at the middle of a road, so only half of the length
     * of the first and last leg roads contributes to the length of the route
     * @return -- the length of the current route.
     */
    public Double length() {
        double length = 0.0;

        for(Leg leg: legs){
            if(leg.getStreet().getId() == legs.get(0).getStreet().getId() || leg.getStreet().getId() == legs.get(legs.size()-1).getStreet().getId()){
                //System.out.println(leg.getStreet() + " " + leg.getStreet().getEnd().getX() + " " +  leg.getStreet().getStart().getX() + " " +leg.getStreet().getEnd().getY() + " " + leg.getStreet().getStart().getY());
                length += (Math.sqrt(Math.pow(leg.getStreet().getEnd().getX() - leg.getStreet().getStart().getX(),2) +Math.pow(leg.getStreet().getEnd().getY() - leg.getStreet().getStart().getY(),2)))/2;
            }
            else{
                //System.out.println(leg.getStreet() + " " + leg.getStreet().getEnd().getX() + " " +  leg.getStreet().getStart().getX() + " " +leg.getStreet().getEnd().getY() + " " + leg.getStreet().getStart().getY());
                length += (Math.sqrt(Math.pow(leg.getStreet().getEnd().getX() - leg.getStreet().getStart().getX(),2) +Math.pow(leg.getStreet().getEnd().getY() - leg.getStreet().getStart().getY(),2)));
            }
        }
        return length;
    }


    /**
     * Given a route, return all loops in the route.
     *
     * A loop in a route is a sequence of streets where we start and end at the same intersection.  A typical
     * example of a loop would be driving around the block in a city.  A loop does not need you to start and end
     * the loop going in the same direction.  It's just a point of driving through the same intersection again.
     *
     * A route may contain more than one loop.  Return the loops in order that they start along the route.
     *
     * If one loop is nested inside a larger loop then only report the larger loop.
     * @return -- a list of subroutes (starting and ending legs) of each loop.  The starting leg and the ending leg
     * share a common interesection.
     */
    public List<SubRoute> loops() {
        List<SubRoute> loops = new ArrayList<>();

        return loops;
    }

    /**
     * Given a route, produce a new route with simplified instructions.  The simplification reports a route
     * that reports the turns in the route but does not report the points where you should keep going straight
     * along your current path.
     * @return -- the simplified route.
     */
    public static Route simplify() {
        List<Leg> simplifiedLegs = new ArrayList<>();
        for (Leg leg : legs) {
            if (leg.getTurnDirection() != TurnDirection.Straight) {
                simplifiedLegs.add(leg);
            }
        }
        return new Route(simplifiedLegs);
    }
}

