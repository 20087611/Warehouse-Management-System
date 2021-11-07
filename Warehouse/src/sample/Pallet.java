/**
 * This class is to create an object of Pallet
 */

package sample;

public class Pallet {
    private String palletID;
    private String productDescription;
    private int productQuantity;
    private double minimumStoreTemperature;
    private double maximumStoreTemperature;
    private int palletPositionWidth;
    private int palletPositionDepth;

    public String getPalletID() {
        return palletID;
    }

    public void setPalletID(String palletID) {
        this.palletID = palletID;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getMinimumStoreTemperature() {
        return minimumStoreTemperature;
    }

    public void setMinimumStoreTemperature(double minimumStoreTemperature) {
        this.minimumStoreTemperature = minimumStoreTemperature;
    }

    public double getMaximumStoreTemperature() {
        return maximumStoreTemperature;
    }

    public void setMaximumStoreTemperature(double maximumStoreTemperature) {
        this.maximumStoreTemperature = maximumStoreTemperature;
    }

    public int getPalletPositionWidth() {
        return palletPositionWidth;
    }

    public void setPalletPositionWidth(int palletPositionWidth) {
        this.palletPositionWidth = palletPositionWidth;
    }

    public int getPalletPositionDepth() {
        return palletPositionDepth;
    }

    public void setPalletPositionDepth(int palletPositionDepth) {
        this.palletPositionDepth = palletPositionDepth;
    }

    public Pallet(String palletID, String productDescription, int productQuantity, double minimumStoreTemperature, double maximumStoreTemperature, int palletPositionWidth, int palletPositionDepth) {
        this.palletID = palletID;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.minimumStoreTemperature = minimumStoreTemperature;
        this.maximumStoreTemperature = maximumStoreTemperature;
        this.palletPositionWidth = palletPositionWidth;
        this.palletPositionDepth = palletPositionDepth;
    }

    @Override
    public String toString() {
        return  "Pallet ID: " + palletID +
                ",\n Product Description: " + productDescription +
                ",\n Product Quantity: " + productQuantity +
                ",\n Minimum Storage Temperature: " + minimumStoreTemperature +
                ",\n Maximum Storage Temperature: " + maximumStoreTemperature +
                ",\n Pallet Position Width: " + palletPositionWidth +
                ",\n Pallet Position Depth: " + palletPositionDepth +"\n";

    }
}


