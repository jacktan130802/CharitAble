package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class InventoryHandler implements ConvertToHash {
    private static int quantity;
    private static String invitem;
    public static HashMap<String, String> hash = new HashMap<String, String>(); //this is my 2 data for OOP
    public static Properties prop = new Properties();
    public static ObservableList<String> obsInventory = FXCollections.observableArrayList();
    public static File file = new File("data.properties");

   static DataHandler dataHandler = new DataHandler();





    /*************************************************************************************
     * 				getNumberOfItemsInInventory()
     *************************************************************************************
     *
     *	Parameters:
     *		data: String
     *
     *	Return Type:
     *		int
     *
     *	Determines number of items in inventory, will handle normal queries, not found errors
     *
     *
     *************************************************************************************
     */

    public static int getNumberOfItemsInInventory(String data) { //string because from user input
        if (hash.size() > 0) {
            for (Map.Entry<String, String> entry : hash.entrySet()) {

                if (entry.getKey().equals(data)) {
                    return Integer.parseInt(entry.getValue());

                }
            }
        }


        return 0;
    }

    /*************************************************************************************
     * 				subtractItem()
     *************************************************************************************
     *
     *	Parameters:
     *		item: String
     *		amount: String
     *	Return Type:
     *		int
     *
     *	Removes the selected item to inventory if the item exists, handles item not found
     *  and not enough inventory issues. Returns the int value of the difference if a
     *  proper subtraction was made.
     *
     *************************************************************************************
     */

//    public static int subtractItem(String item, String amount) throws IOException {
//        quantity = Integer.parseInt(amount);
//        invitem = item;
//
//        FileOutputStream writer = new FileOutputStream(file, true);
//        if (hash.containsKey(item)) {
//            if ((int) Integer.parseInt(hash.get(item)) >= quantity) { //change amount to string.
//                int difference = (int) Integer.parseInt(hash.get(item)) - quantity;  //deduction from inventory
//
//                //replaces the amount of the item with the difference after user received a donation
//                InventoryHandler.hash.replace(item, "" + difference);
//                InventoryHandler.prop.putAll(InventoryHandler.hash);
//                InventoryHandler.prop.store(writer, null);  //writes to file
//                writer.close();
//                return difference;
//            } else {
//                writer.close();
//                return 0;
//            }
//        } else {
//            writer.close();
//            return -1;
//        }
//    }


    public static void loadFiles() throws IOException {

        //loads the file from application directory
        FileInputStream reader = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(reader);

        reader.close();

        ArrayList<String> tmpkey = new ArrayList<String>();
        ArrayList<String> tmpprop = new ArrayList<String>();
        //iterates through the file and adds values to HashMap  -- Throw into hashmap!
        for (Object key : prop.stringPropertyNames()) {
            hash.put(key.toString(), prop.get(key).toString());//converting evrything to string.
            tmpkey.add(key.toString());
            tmpprop.add(prop.get(key).toString());
        }
        Inventory.setAcc(tmpkey);
        Inventory.setQty(tmpprop);

    }

    public static void initInventory() throws IOException {
        HashMap<String, String> hash;
        File file;
        Properties prop;
        InventoryHandler.hash.put("Toilet Paper", "10");
        InventoryHandler.hash.put("Hand Sanitizer", "12");
        InventoryHandler.hash.put("Shampoo", "10");
        InventoryHandler.prop.putAll(InventoryHandler.hash);
        FileOutputStream writer = new FileOutputStream(InventoryHandler.file, true);
        InventoryHandler.prop.store(writer, null);

    }
      @Override
        public void ArrayToHash(ArrayList<String> tmpKey,ArrayList<String> tmpProp) {
            for (String x :tmpKey) {
                for(String y : tmpProp)
                hash.put(x, y);//converting evrything to string.
            }

    }
}
