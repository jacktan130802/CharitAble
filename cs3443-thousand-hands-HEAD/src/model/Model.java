package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import handler.InvalidUserException;

import java.util.Map.Entry;

import javafx.collections.ObservableList;

/********************************************************************
 * 			Model - Covid-19 Donation app
 ********************************************************************
 *Purpose:
 *		Model class for the app. Contains most backend logic and handling
 *		of files.
 *
 *
 ********************************************************************
 */

public class Model {//for methods of altering the inventory.

	//Instantiations of all classes used in data structure for the app
	public static boolean need = true;
	public static HashMap<String, String> users = new HashMap<String, String>();
	public static Properties userProp = new Properties();
	public static File userFile = new File("users.properties");

	public static boolean isNeed() {
		return need;
	}

	public static boolean addUserName(String user) throws IOException, InvalidUserException {

		if (!verifyUser(user)) {
			throw new InvalidUserException("Invalid username. Not in form abc123");
		}

		if (!users.containsKey(user)) {
			FileOutputStream writer = new FileOutputStream(userFile, true);
			users.put(user, "user");
			Model.userProp.putAll(Model.users);
			Model.userProp.store(writer, user);
			writer.close();
			return false;
		}

		return true;
	}

	/*********************************************
	 * 				verifyUser()
	 *********************************************
	 *
	 *	Parameters:
	 *		text: String
	 *	Return Type:
	 *		boolean
	 *
	 *	Tests if text is a valid String for use
	 *  as a username. Checks if
	 *  the string is in the form abc123
	 *********************************************
	 */

	public static boolean verifyUser(String text) {

		boolean valid = true;
		//empty field or too long
		if (text.length() == 0 || text.length() > 10)
			valid = false;


		return valid;   //no alphabetical char found
	}

	/*********************************************
	 * 				verifyInt()
	 *********************************************
	 *
	 *	Parameters:
	 *		text: String
	 *	Return Type:
	 *		boolean
	 *
	 *	Checks if the text string is valid for use
	 *	in the item quantity field. Invalid if the
	 *	string cannot be parsed to an int
	 *********************************************
	 */

	public static boolean verifyInt(String text) {

		//empty
		if (text.length() == 0)
			return false;

		//compares unicode values in string
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c < '0' || c > '9')
				return false;    //non-int char found
		}
		return true;
	}

	/*********************************************
	 * 				verifyProduct()
	 *********************************************
	 *
	 *	Parameters:
	 *		text: String
	 *	Return Type:
	 *		boolean
	 *
	 *	Checks if the text string is valid for use
	 *	in the item quantity field. Invalid if the
	 *	string cannot be parsed to an int
	 *********************************************
	 */

	public static boolean verifyProduct(String text) {
		//empty
		if (text.length() == 0)
			return false;
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (!(c == ' ' || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')))
				return false;
		}
		return true;
	}


	/*********************************************
	 * 				loadFile()
	 *********************************************
	 *
	 *	Parameters:
	 *		none
	 *	Return Type:
	 *		none
	 *
	 *	used to load the data.properties file at app
	 *  launch (called in main)
	 *********************************************
	 */

	public static void loadFiles() throws IOException {

		//loads the file from application directory
		FileInputStream userReader = new FileInputStream(userFile);
		userProp.load(userReader);
		userReader.close();

		//iterates through the file and adds values to HashMap
		for (Object key : userProp.stringPropertyNames()) {
			users.put(key.toString(), userProp.get(key).toString());
		}
	}

}