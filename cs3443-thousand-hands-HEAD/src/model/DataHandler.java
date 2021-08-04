package model;

import java.io.*;

public class DataHandler implements FileInterface {


    public String readFile(String file) {
        String currentLine = ""; //Init value
        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            currentLine = reader.readLine();    //Obtain value from
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentLine;
    }

    @Override
    public FileOutputStream writeFile(String file, boolean append) throws FileNotFoundException {

        FileOutputStream outputStream = new FileOutputStream(file, append);
        // OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");


        return outputStream;

    }
}
