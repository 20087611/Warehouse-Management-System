/**
 * This class is to create an object of floor
 */
package sample;

public class Floor {
    private int floorNum;
    private  String securityLevel;
    private  Double temperature;

    LinkedNode<Aisle> aisleList = new LinkedNode<>();

    public Floor(int floorNum, String securityLevel, Double temperature) {
        this.floorNum = floorNum;
        this.securityLevel = securityLevel;
        this.temperature = temperature;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return  "Floor " + floorNum + ": " +
                "\n Security Level: " + securityLevel + ", Floor Temperature: " + temperature + "°C"+"\n";
    }

    public String printFloorNum() {
        return "Floor " + floorNum;
    }
}
