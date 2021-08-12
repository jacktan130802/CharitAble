package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Inventory {

    public static HashMap<String, String> hash = new HashMap<String, String>(); //this is my 2 data for OOP
    public static Properties prop = new Properties();
    public static ObservableList<String> obsInventory = FXCollections.observableArrayList();
    public static File file = new File("data.properties");

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


    }
}
