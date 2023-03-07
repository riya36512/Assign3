public class Street {
    private final String id;
    private final Point start;
    private final Point end;

    public Street(String id, Point start, Point end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public  Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
}
