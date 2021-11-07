/**
 * This class is to create an object of Pallet
 */

package sample;

public class Aisle {
    private String id;
    private int width, depth;

    LinkedNode<Shelf> shelfList = new LinkedNode<>();

    public Aisle(String id, int width, int depth) {
        this.id = id;
        this.width = width;
        this.depth = depth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        depth = depth;
    }

    @Override
    public String toString() {
        return "Aisle:" +
                "id='" + id + '\'' +
                ", width=" + width +
                ", Depth=" + depth;
    }

    public String printAisleID() {
        return "Aisle " + id;
    }
}
