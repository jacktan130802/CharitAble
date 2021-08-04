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
        FileOutputStream writer = new FileOutputStream(InventoryHandler.file, true);
        //checks if item is already in inventory, then adds user's amount to current value
        if (InventoryHandler.hash.containsKey(invitem)) {
//            int add =quantity;
            InventoryHandler.hash.replace(donated, "" + (quantity + Integer.parseInt(InventoryHandler.hash.get(invitem))));
            InventoryHandler.prop.putAll(InventoryHandler.hash);
            InventoryHandler.prop.store(writer, null);
            return true;


            //otherwise creates a new entry
        } else {
            InventoryHandler.hash.put(invitem, String.format(invitem));
            InventoryHandler.prop.putAll(InventoryHandler.hash);
            InventoryHandler.prop.store(writer, null);
            return false;

        }

    }




}
