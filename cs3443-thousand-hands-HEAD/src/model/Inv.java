package model;

import java.util.ArrayList;

public class Inv {
    private static ArrayList<String> acc;
    private static ArrayList<String> qty;

    public static ArrayList<String> getAcc() {
        return acc;
    }

    public static void setAcc(ArrayList<String> acc) {
        Inv.acc = acc;
    }

    public static ArrayList<String> getQty() {
        return qty;
    }

    public static void setQty(ArrayList<String> qty) {
        Inv.qty = qty;
    }


}
