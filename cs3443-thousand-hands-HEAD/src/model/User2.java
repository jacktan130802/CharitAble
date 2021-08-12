package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import application.NeedGive.NeedGiveController;
import handler.InvalidUserException;

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

public class User2 {//for methods of altering the inventory.

	//Instantiations of all classes used in data structure for the app
	public static boolean need = true; //need page
	public static HashMap<String, String> users = new HashMap<String, String>();
	public static Properties userProp = new Properties();
	public static File userFile = new File("users.properties");
	String user;
	String position;

//	public static boolean isNeed() {
//		return need;
//	}




	public static boolean addUserName(String user,String position,Donor donor) throws IOException, InvalidUserException {

		if (!VerifyUser.verifyUser(user)) {
			throw new InvalidUserException("Invalid username. Not in form abc123");
		}

		if (!users.containsKey(user)) {
		//Add user
		FileOutputStream writer = new FileOutputStream(userFile, true);
			//users.put(user, "user");
		if (donor.isAnonymous() == true) {
			users.put("XXX", position);
		} else
			users.put(user, position);
		User2.userProp.putAll(User2.users);
		User2.userProp.store(writer, user);
		writer.close();
		return false;
		}
//		else
//			User2.userProp.get(user);
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

	public static void loadUser() throws IOException {

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