package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

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

public class User {//for methods of altering the inventory.
		public String name;
		String Qty;
		String ItemsDonated;
		public User(String name, String donated, String qty) {
			this.name = name;
			Qty = qty;
			ItemsDonated = donated;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		public String getqty() {
			return Qty;
		}

		public void setqty(String qty) {
			this.Qty = Qty;
		}

		public String getDonated() {
			return ItemsDonated;
		}

		public void setDonated(String donated){
			this.ItemsDonated = ItemsDonated;
		}

	//Instantiations of all classes used in data structure for the app
	public static boolean need = true; //need page
	public static HashMap<String, String> users = new HashMap<String, String>(); // to store the username and the position
	public static Properties userProp = new Properties();
	public static File userFile = new File("users.properties");

	public static boolean addUserName(String user,String position,Donor donor) throws IOException, InvalidUserException {

		if (!VerifyUser.verifyUser(user)) {
			throw new InvalidUserException("Invalid username. Not in form abc123");
		}
		if (donor.isAnonymous() == true) {
			user= "XXX" + " - " +  donor.genRandomID();
		}


		if (!users.containsKey(user)) {
		//Add user
		FileOutputStream writer = new FileOutputStream(userFile, true);
			users.put(user, position);
		User.userProp.putAll(User.users);
		User.userProp.store(writer, user);
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