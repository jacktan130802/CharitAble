package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Inventory {
    private static int quantity;
    private static String invitem;

    public static HashMap<String, String> hash = new HashMap<String, String>(); //this is my 2 data for OOP

    //    public static HashMap<String, String> users = new HashMap<String, String>();
    public static Properties prop = new Properties();

    //    public static Properties userProp = new Properties();

    public static File file = new File("data.properties");

    //    public static File userFile = new File("users.properties");


    //    public static File file = new File("data.properties");


    public static ObservableList<String> obsInventory = FXCollections.observableArrayList();


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
    public static boolean addItem(String item, String amount) throws IOException {
        quantity= Integer.parseInt(amount) ;
        invitem= item;
        FileOutputStream writer = new FileOutputStream(file, true);

        //checks if item is already in inventory, then adds user's amount to current value
        if (hash.containsKey(invitem)) {
//            int add =quantity;
            hash.replace(item, "" + (quantity + Integer.parseInt(hash.get(invitem))));
            prop.putAll(Inventory.hash);
            prop.store(writer, null);
            return true;


            //otherwise creates a new entry
        } else {
            hash.put(invitem, String.format(invitem));
            prop.putAll(Inventory.hash);
            prop.store(writer, null);
            return false;

        }

    }

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

    public static int subtractItem(String item, String amount) throws IOException {
        quantity = Integer.parseInt(amount);
        invitem = item;

        FileOutputStream writer = new FileOutputStream(file, true);
        if (hash.containsKey(item)) {
            if ((int) Integer.parseInt(hash.get(item)) >= quantity) { //change amount to string.
                int difference = (int) Integer.parseInt(hash.get(item)) - quantity;  //deduction from inventory

                //replaces the amount of the item with the difference after user received a donation
                Inventory.hash.replace(item, "" + difference);
                Inventory.prop.putAll(Inventory.hash);
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


    public static void loadFiles() throws IOException {

        //loads the file from application directory
        FileInputStream reader = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(reader);

        reader.close();


        //iterates through the file and adds values to HashMap  -- Throw into hashmap!
        for (Object key : prop.stringPropertyNames()) {
            hash.put(key.toString(), prop.get(key).toString());//converting evrything to string.
        }


        //iterates through the file and adds values to HashMap
//        for(Object key: userProp.stringPropertyNames()){
//            users.put(key.toString(), userProp.get(key).toString());
//        }

    }

    public static void initInventory() throws IOException {
        HashMap<String, String> hash;
        File file;
        Properties prop;
        Inventory.hash.put("Toilet Paper", "10");
        Inventory.hash.put("Hand Sanitizer", "12");
        Inventory.hash.put("Shampoo", "10");
        Inventory.prop.putAll(Inventory.hash);
        FileOutputStream writer = new FileOutputStream(Inventory.file, true);
        Inventory.prop.store(writer, null);

    }
}
