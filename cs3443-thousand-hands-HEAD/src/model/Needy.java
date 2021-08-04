package model;

import java.io.FileOutputStream;
import java.io.IOException;

public class Needy extends User {
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Needy(String name, String position, String donated, String qty) {
        super(name, donated,qty);
        this.position = position;
    }
    String name = super.name;
    String item = super.ItemsDonated;
    String amount = super.Qty;
    public int subtractItem() throws IOException {
        int quantity;
        String invitem;
        quantity = Integer.parseInt(amount);
        invitem = item;

        FileOutputStream writer = new FileOutputStream(InventoryHandler.file, true);
        if (InventoryHandler.hash.containsKey(item)) {
            if ((int) Integer.parseInt(InventoryHandler.hash.get(item)) >= quantity) { //change amount to string.
                int difference = (int) Integer.parseInt(InventoryHandler.hash.get(item)) - quantity;  //deduction from inventory

                //replaces the amount of the item with the difference after user received a donation
                InventoryHandler.hash.replace(item, "" + difference);
                InventoryHandler.prop.putAll(InventoryHandler.hash);
                InventoryHandler.prop.store(writer, null);  //writes to file
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
