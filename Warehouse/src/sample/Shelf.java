/**
 * This class is to create an object of Shelf
 */

package sample;

public class Shelf {
    private String shelfNumber;

    LinkedNode<Pallet> palletList = new LinkedNode<>();

    public Shelf(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public String getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    @Override
    public String toString() {
        return "Shelf" +
                "shelfNumber=" + shelfNumber;
    }

    public String printShelfNum() {
        return "Shelf " + shelfNumber;
    }
}

