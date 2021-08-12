package model;

import java.io.FileOutputStream;
import java.io.IOException;

public class Donor extends User {

//    public Donor(String Name, String Donated, String qty) {
//
//
////        name = Name;
////        ItemsDonated = Donated;
////        Qty = qty;
////
//    }


    public Donor(String name, String donated, String qty) {
        super(name, donated, qty);
    }
    String name = super.name;
    String donated = super.ItemsDonated;
    String qty = super.Qty;

    /*************************************************************************************
     * 				addItem()
     *************************************************************************************
     *
     *	Parameters:
     *		item: String
     *		amount: String
     *	Return Type:
     *		boolean
     *
     *	Adds the selected item to inventory, handles new and existing items
     *
     *************************************************************************************
     */

    public boolean addItem() throws IOException {
        int quantity;
         String invitem;
        quantity= Integer.parseInt(qty) ;
        invitem= donated;
        FileOutputStream writer = new FileOutputStream(Inventory.file, true);
        //checks if item is already in inventory, then adds user's amount to current value
        if (Inventory.hash.containsKey(invitem)) {
//            int add =quantity;
            Inventory.hash.replace(donated, "" + (quantity + Integer.parseInt(Inventory.hash.get(invitem))));
            Inventory.prop.putAll(Inventory.hash);
            Inventory.prop.store(writer, null);
            return true;


            //otherwise creates a new entry
        } else {
            Inventory.hash.put(invitem, String.format(invitem));
            Inventory.prop.putAll(Inventory.hash);
            Inventory.prop.store(writer, null);
            return false;

        }

    }




}
