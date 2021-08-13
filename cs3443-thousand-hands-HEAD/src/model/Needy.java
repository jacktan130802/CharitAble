package model;

import java.io.FileOutputStream;
import java.io.IOException;

public class Needy extends User {
    private String position;

    private String incomeStatus; //must be private. Method can but user attr. must be private
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Needy(String name, String position, String donated, String qty, String incomeStatus) {
        super(name, donated,qty);
        this.position = position;
        this.incomeStatus= incomeStatus;
    }
    String name = super.name;
    String item = super.ItemsDonated;
    String amount = super.Qty;

    public int recieve() throws IOException {
        int quantity;
        quantity = Integer.parseInt(amount);
        FileOutputStream writer = new FileOutputStream(Inventory.file, true);
        if (Inventory.itemsQty.containsKey(item)) {
            if ((int) Integer.parseInt(Inventory.itemsQty.get(item)) >= quantity) { //change amount to string.
                int difference = (int) Integer.parseInt(Inventory.itemsQty.get(item)) - quantity;  //deduction from inventory

                //replaces the amount of the item with the difference after user received a donation
                Inventory.itemsQty.replace(item, "" + difference);
                Inventory.prop.putAll(Inventory.itemsQty);
                Inventory.prop.store(writer, null);  //writes to file
                writer.close();
                return difference;
            } else {
                writer.close();
                return 0;
            }
        } else {
            writer.close();
            return -1;
        }
    }



}
