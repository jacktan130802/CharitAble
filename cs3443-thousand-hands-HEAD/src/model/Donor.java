package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Donor extends User {
private boolean anonymous;
private int id ;



    public int genID(){

       id =(int) (Math.random()*((1000-100)+1))+100;
       return id;
    }

    public boolean isAnonymous() {
        return anonymous;
    }
////        name = Name;
////        ItemsDonated = Donated;
////        Qty = qty;
////
//    }


    public Donor(String name, String donated, String qty,boolean anonymous) {
        super(name, donated, qty);
        this.anonymous = anonymous;
     ;
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

    public boolean donate() throws IOException {
        int quantity;
         String invitem;
        quantity= Integer.parseInt(qty) ;
        invitem= donated;
        FileOutputStream writer = new FileOutputStream(Inventory.file, true);
        //checks if item is already in inventory, then adds user's amount to current value
        if (Inventory.itemsQty.containsKey(invitem)) {
//            int add =quantity;
            Inventory.itemsQty.replace(donated, "" + (quantity + Integer.parseInt(Inventory.itemsQty.get(invitem))));
            Inventory.prop.putAll(Inventory.itemsQty);
            Inventory.prop.store(writer, null);
            return true;


            //otherwise creates a new entry
        } else {
            Inventory.itemsQty.put(invitem, String.format(invitem));
            Inventory.prop.putAll(Inventory.itemsQty);
            Inventory.prop.store(writer, null);
            return false;

        }

    }





}
