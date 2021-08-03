package model;

import java.io.File;

public class Inventory {
    public static File file = new File("data.properties");
    int quantity;
    String item;




    public int getQuantity() {
        return quantity;
    }

    public String getItem() {
        return item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
