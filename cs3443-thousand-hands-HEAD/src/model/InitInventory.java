package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class InitInventory  {

 //used to initialise the items inside.
    public static void initInventory() throws IOException {
        HashMap<String, String> hash;
        File file;
        Properties prop;
        hash = Inventory.itemsQty;
        prop = Inventory.prop;
        file = Inventory.file;
        hash.put("Toilet Paper", "10");
        hash.put("Hand Sanitizer", "12");
        hash.put("Shampoo", "10");
        prop.putAll(hash);
        FileOutputStream writer = new FileOutputStream(file, true);
        prop.store(writer, null);

    }
}
