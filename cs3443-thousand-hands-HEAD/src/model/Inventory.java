package model;

import java.util.ArrayList;

public class Inventory extends DataObject{
    private static ArrayList<String> acc;
    private static ArrayList<String> qty;

    public static ArrayList<String> getAcc() {
        return acc;
    }

    public static void setAcc(ArrayList<String> acc) {
        Inventory.acc = acc;
    }

    public static ArrayList<String> getQty() {
        return qty;
    }

    public static void setQty(ArrayList<String> qty) {
        Inventory.qty = qty;
    }


}
