package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Controller {

    @FXML
    TextArea textDisplayArea;

    @FXML
    TextField textSecLvl, textFTemp, textGetFloor,
            textAisleW, textAisleD, textGetAisle,
            textGetShelf,
            textProductDescription, textProQuantity, textMinStoreTemp, textMaxStoreTemp,
            textPalPosW, textPalPosD, textPalletID, textPalletSearch;


    /**  Create a number for the floor to be added..*/
    public int creatFloorNumber() {
        if (Main.floorList.head != null) {
            return Main.floorList.length() + 1;
        } else {
            return 1;
        }
    }

    /**  Create a ID for the Aisle to be added..*/
    public String creatAisleID() {
        Floor floorSelected = getFloor();

        WNode<Aisle> temp = floorSelected.aisleList.head;

        int stringIndex;
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int integerPart = floorSelected.getFloorNum();

        if (temp != null) {
            stringIndex = floorSelected.aisleList.length();
        } else {
            stringIndex = 0;
        }
        char charPart = alpha.charAt(stringIndex);
        return integerPart+String.valueOf(charPart);
    }

    /**  Create a ID for the Shelf to be added..*/
    public String creatShelfID() {
        Aisle aisleSelected = getAisle();
        WNode<Shelf> temp = aisleSelected.shelfList.head;

        String integerPart = aisleSelected.getId();
        int stringIndex;
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if (temp != null) {
            stringIndex = aisleSelected.shelfList.length();
        } else {
            stringIndex = 0;
        }
        char charPart = alpha.charAt(stringIndex);
        return integerPart + charPart;
    }

    /**  Create a ID for the Pallet to be added..*/
    public String creatPalletID() {
        Shelf shelfSelected = getShelf();

        WNode<Pallet> temp = shelfSelected.palletList.head;
        String firstPart = shelfSelected.getShelfNumber();
        int stringIndex;

        if (temp != null) {
            stringIndex = shelfSelected.palletList.length() + 1;
        } else {
            stringIndex = 1;
        }
        return firstPart + stringIndex;
    }

    /**
     * Add Floor to floorList in Main
     */
    public void addFloor() {
        String secLevel = textSecLvl.getText();
        Double fTemp = Double.parseDouble(textFTemp.getText());

        if (secLevel.equalsIgnoreCase("high") || secLevel.equalsIgnoreCase("medium") || secLevel.equalsIgnoreCase("low")) {
            Main.floorList.addElement(new Floor(creatFloorNumber(), secLevel, fTemp));
            textDisplayArea.appendText("Floor Add");
            textDisplayArea.setText(Main.floorList.printList());
        } else {
            textDisplayArea.appendText("Invalid Input");
        }
    }

    /**
     * Gets floor node to add aisles.
     */
    public Floor getFloor() {
        try {
            int floorNumber = Integer.parseInt(textGetFloor.getText());

            WNode<Floor> tempFloor = Main.floorList.head;

            while (tempFloor != null) {
                if (tempFloor.getContents().getFloorNum() == floorNumber) {
                    textDisplayArea.setText("Floor " + floorNumber + " successfully selected." + "\n");
                    return tempFloor.getContents();
                }
                tempFloor = tempFloor.next;
            }
            textDisplayArea.setText("Floor not found " + "\n" + Main.floorList.printList());
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Add aisle to aisleList in selected Floor.
     */
    public void addAisle() {
        int aWidth = Integer.parseInt(textAisleW.getText());
        int aDepth = Integer.parseInt(textAisleD.getText());

        Floor floorSelected = getFloor();

        if (floorSelected != null) {
            if (floorSelected.aisleList.length() < 20) {
                if (aWidth < 10 && aWidth > 0) {
                    if (aDepth < 10 && aDepth > 0) {
                        floorSelected.aisleList.addElement(new Aisle(creatAisleID(), aWidth, aDepth));
                        textDisplayArea.setText("Aisles in Floor " + floorSelected.getFloorNum() + ": " + "\n" + "\n" + floorSelected.aisleList.printList() + "\n");
                    }
                } else {
                    textDisplayArea.appendText("Invalid Input." + "\n");
                }
            } else {
                textDisplayArea.appendText("Floor is full." + "\n");
            }
        }
    }


        /**
         * Gets aisle node to add shelves to.
         */

        public Aisle getAisle() {
            try {
                String aID = textGetAisle.getText().toUpperCase();

                Floor tempFloor = getFloor();

                WNode<Aisle> tempAisle = getFloor().aisleList.head;

                while (tempAisle != null) {
                    if (tempAisle.getContents().getId().equals(aID)) {
                        textDisplayArea.setText("Aisle " + aID.toUpperCase() + " successfully selected." + "\n");
                        return tempAisle.getContents();
                    }
                    tempAisle = tempAisle.next;
                }
                textDisplayArea.appendText("Aisle not found! Please try again :)" + "\n");
                if(tempFloor.aisleList.head!=null) {
                    textDisplayArea.setText("Aisle not found! Please choose the following aisle" + "\n" + "Aisles in Floor " + tempFloor.getFloorNum() + ": "  + "\n" + tempFloor.aisleList.printList()+"\n");
                }
                return null;
            }
            catch(Exception e) {
                return null;
            }
        }



        /**
         * Add Shelf to Linked list in selected Aisle.
         */
        public void addShelf() {
            Aisle aisleSelected = getAisle();

            if (aisleSelected != null) {
                if (aisleSelected.shelfList.length() < 5) {
                    aisleSelected.shelfList.addElement(new Shelf(creatShelfID()));
                    textDisplayArea.setText(getAisle().shelfList.printList());
                } else {
                    textDisplayArea.setText(getAisle().shelfList.printList()+"Maximum number of shelves reached!" + "\n");
                }
            } else {
                textDisplayArea.setText("Please choose a valid aisle to add to!" + "\n");
            }
        }

        /**
         * Gets shelf node to add pallets to.
         */
        public Shelf getShelf() {
            try {
                String sNum = textGetShelf.getText().toUpperCase();

                WNode<Shelf> shelfTemp = getAisle().shelfList.head;

                while (shelfTemp != null) {
                    if (shelfTemp.getContents().getShelfNumber().equals(sNum)) {
                        textDisplayArea.setText("Shelf " + sNum.toUpperCase() + " successfully selected." + "\n");
                        return shelfTemp.getContents();
                    }
                    shelfTemp = shelfTemp.next;
                }
                textDisplayArea.appendText("Shelf not found!)" + "\n");
                return null;
            }
            catch (Exception e){
                return null;
            }
        }

        /**
         * Add pallet to palletList in selected Shelf.
         */
        public void addPallet () {
            String proDesc = textProductDescription.getText();
            int proQuantity = Integer.parseInt(textProQuantity.getText());
            double minStoreTemp = Double.parseDouble(textMinStoreTemp.getText());
            double maxStoreTemp = Double.parseDouble(textMaxStoreTemp.getText());
            int palPosW = Integer.parseInt(textPalPosW.getText());
            int palPosD = Integer.parseInt(textPalPosD.getText());

            Aisle aisleSelected = getAisle();
            Shelf shelfSelected = getShelf();

            if (shelfSelected.palletList.length() < aisleSelected.getWidth() * aisleSelected.getDepth()) {
                if (palPosD > 0 && palPosW > 0) {
                    if (shelfSelected != null) {
                            shelfSelected.palletList.addElement(new Pallet(creatPalletID(), proDesc, proQuantity, minStoreTemp, maxStoreTemp, palPosW, palPosD));
                            textDisplayArea.setText(shelfSelected.palletList.printList());
                            textProQuantity.clear();
                            textMinStoreTemp.clear();
                            textMaxStoreTemp.clear();
                            textPalPosW.clear();
                            textPalPosD.clear();
                    }
                    else {
                        textDisplayArea.appendText("Shelf not found. Pallet not added." + "\n");
                    }
                }
            }
            else {
                textDisplayArea.appendText("The shelves are full, please choose another shelf" + "\n");
            }
        }


        /**
         * Deletes pallet from selected shelf by pallet ID.
         */
        public void deletePallet () {
            try {
                String palletID = textPalletID.getText();
                LinkedNode<Pallet> palList = getShelf().palletList;

                for (int i = 0; i < palList.length(); i++) {
                    if (palList.accessNode(i).getContents().getPalletID().equals(palletID)) {
                        palList.removeNode(i);
                        textDisplayArea.setText("Pallet Deleted" + "\n");
                    }
                }
            } catch (Exception e) {
                textDisplayArea.setText("Try Again!" + "\n");
            }
        }


    public void searchForPallet() {
        String searchFor = textPalletSearch.getText();

        for (Floor tempFloor : Main.floorList) {
            for (Aisle tempAisle : tempFloor.aisleList) {
                for (Shelf tempShelf : tempAisle.shelfList) {
                    for (Pallet tempPallet : tempShelf.palletList) {

                        if (tempPallet.getProductDescription().equalsIgnoreCase(searchFor)) {
                            textDisplayArea.setText("Pallet Found in " + tempFloor.toString() + ", "+tempAisle.toString() + ", " + tempShelf.toString() + "\n" + "\n" + tempPallet.toString() + "\n" );
                            textPalletSearch.clear();
                            return;
                        }
                    }
                }
            }
        }
    }


    public void viewAll() {
        textDisplayArea.clear();
        for(Floor floor: Main.floorList) {
            textDisplayArea.appendText("\n" + floor.toString()  + "------------------------------------------------");
            for (Aisle aisle : floor.aisleList) {
                textDisplayArea.appendText( "\n" + "----------"+ aisle.printAisleID() + "-----------" + "\n");
                for (Shelf shelf: aisle.shelfList) {
                    textDisplayArea.appendText("\n" + shelf.printShelfNum());
                    for (Pallet pallet: shelf.palletList) {
                        textDisplayArea.appendText( "\n" + pallet.toString());
                    }
                }
            }
        }
    }

        /**
         * Saves Load Reset and Qiut method
         */
        public void save () throws Exception {
            XStream xstream = new XStream(new DomDriver());
            ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("WarehouseApp.xml"));
            out.writeObject(Main.floorList);
            out.close();
            textDisplayArea.appendText("File has been saved." + "\n");
        }

        public void load () throws Exception {
            XStream xstream = new XStream(new DomDriver());
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("WarehouseApp.xml"));
            Main.floorList = (LinkedNode<Floor>) is.readObject();
            is.close();
            textDisplayArea.setText("File loaded" );
        }

        public void reset(){
            Main.floorList.emptyList();
            textDisplayArea.setText("System has been reset." + "\n");
        }

        public void quit(){
            System.exit(0);
        }
}
