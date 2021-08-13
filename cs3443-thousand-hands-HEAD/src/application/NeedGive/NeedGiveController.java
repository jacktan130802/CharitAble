package application.NeedGive;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import handler.InvalidUserException;
import javafx.fxml.Initializable;
import model.*;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

/********************************************************************
 * 			NeedGiveController - Covid-19 Donation app
 ********************************************************************
 *Purpose:
 *		Main Controller for the Thousand-Hands app.
 *		Contains both model and view logic in one class per the Lab 4
 *		submission guidelines. 
 *
 *Notes:
 *		A bit hacky, definitely helps me understand why we would use
 *		a model class as well as using a 1:1 relationship between 
 *		FXML files and java controllers, per Oracle recommendations.
 *		All FXML files were linked to this controller using the 
 *		fx:controller parameter in a named (fx:id) AnchorPane tag.
 *		I separated code by FXML relation, so it can be refactored 
 *		later.  
 *
 *General App Functions:
 *		Simulates a donation system that allows users to donate or 
 *		receive products using their username, product name, and amount
 *		to create an inventory that can be later viewed and searched.
 *
 *
 ********************************************************************
 */

public class NeedGiveController implements Initializable {

	//class attributes. They must be static since calling the scene change
	//methods reinstatiates the class, static variables allows the data to 
	//remain intact


	@FXML
	private AnchorPane needGivePane;

	@FXML
	private Button needHomeBtn;

	@FXML
	private Button needInvBtn;

	@FXML
	private Button userBtn;

	@FXML
	private Button productBtn;

	@FXML
	private Button quantityBtn;

	@FXML
	private Button addSubBtn;

	@FXML
	private TextField userField;

	@FXML
	private ChoiceBox<String> productField;
	@FXML
	private ChoiceBox<String> position;
	@FXML
	private ChoiceBox<String> Income;
	@FXML
	private Label mylabel;
	@FXML
	private Label needLabel;
	public static Label static_needlabel;
	@FXML
	private TextField quantityField;
	@FXML
	private  Label label1;
	public static Label static_label;


	/*****************************************************************
	 * 				needToMain()
	 *****************************************************************
	 *
	 *	Parameters:
	 *		event: ActionEvent - home button pressed
	 *	Return Type:
	 *		none
	 *	Decorator:
	 *		FXML
	 *
	 *	Switches the scene from the NeedGive view to the Main view
	 *	Does so by instantiating a new AnchorPane (the parent element
	 *	of each view hierarchy)
	 *
	 *****************************************************************
	 */
//	User2 model = new User2();
//	Toast toast;

	@FXML
	void needToMain(ActionEvent event) throws IOException {

		AnchorPane pane = FXMLLoader.load(getClass().getResource("../Main/Main.fxml"));
		pane.setStyle("-fx-background-color: rgba(148, 211, 247, 1);");
		needGivePane.getChildren().setAll(pane);
	}


	/*****************************************************************
	 * 				needToInv()
	 *****************************************************************
	 *
	 *	Parameters:
	 *		event: ActionEvent - inventory button pressed
	 *	Return Type:
	 *		none
	 *	Decorator:
	 *		FXML
	 *
	 *	Switches the scene from the NeedGive view to the Inventory view
	 *	Does so by instantiating a new AnchorPane (the parent element
	 *	of each view hierarchy)
	 *
	 *****************************************************************
	 */
	@FXML
	void needToInv(ActionEvent event) throws IOException {

		AnchorPane pane = FXMLLoader.load(getClass().getResource("../Inventory/Inventory.fxml"));
		pane.setStyle("-fx-background-color: rgba(148, 211, 247, 1);");
		needGivePane.getChildren().setAll(pane);

	}


	/*****************************************************************
	 * 				checkUser()
	 *****************************************************************
	 *
	 *	Parameters:
	 *		event: ActionEvent - user button pressed
	 *	Return Type:
	 *		none
	 *	Decorator:
	 *		FXML
	 *	Helpers:
	 *		verifyText()
	 *
	 *	Gets user info and determines its validity
	 *
	 *****************************************************************
	 */
	@FXML
	void checkUser(ActionEvent event) {

		String text = userField.getText();  //gets field info
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setHeaderText("User ID");

		//valid username
		if (VerifyUser.verifyUser(text)) {
			a.setContentText("User ID is valid!");

			//invalid
		} else {
			a.setAlertType(AlertType.ERROR);
			a.setContentText("User ID is invalid, please enter username in the format:\n\nabc123");
		}
		a.show();    //displays alert after condition
	}

	@FXML
	void checkPosition(ActionEvent event) throws IOException, InvalidUserException {
		String text = productField.getValue();


	}

	/*****************************************************************
	 * 				checkProduct()
	 *****************************************************************
	 *
	 *	Parameters:
	 *		event: ActionEvent - item button pressed
	 *	Return Type:
	 *		none
	 *	Decorator:
	 *		FXML
	 *	Helpers:
	 *		verifyText()
	 *
	 *	Gets product info and determines its validity
	 *
	 *****************************************************************
	 */
	@FXML
	void checkProduct(ActionEvent event) {

		String text = productField.getValue();    //gets field info
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setHeaderText("Product");

		//valid item
		if (VerifyUser.verifyProduct(text)) {
			a.setContentText("Product Name is valid!");

			//invalid
		} else {
			a.setAlertType(AlertType.ERROR);
			a.setContentText("Product Name is invalid, please use only alphabetical and numerical characters");
		}
		a.show();  //displays alert
	}

	/*****************************************************************
	 * 				checkQuantity()
	 *****************************************************************
	 *
	 *	Parameters:
	 *		event: ActionEvent - amount button pressed
	 *	Return Type:
	 *		none
	 *	Decorator:
	 *		FXML
	 *	Helpers:
	 *		verifyInt()
	 *f
	 *	Gets amount info and determines its validity
	 *
	 *****************************************************************
	 */
	@FXML
	void checkQuantity(ActionEvent event) {

		String text = quantityField.getText();
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setHeaderText("Item Quantity");

		//valid
		if (VerifyUser.verifyInt(text)) {
			a.setContentText("Item Quantity is valid!");

			//invalid
		} else {
			a.setAlertType(AlertType.ERROR);
			a.setContentText("Item Quantity is invalid, please input an integer");
		}
		a.show();

	}

	/*****************************************************************
	 * 				process()
	 *****************************************************************
	 *
	 *	Parameters:
	 *		event: ActionEvent - add/sub button pressed
	 *	Return Type:
	 *		none
	 *	Decorator:
	 *		FXML
	 *	Helpers:
	 *		verifyText()
	 *		verifyInt()
	 *
	 *	Core Donation Algorithm
	 *	Handles input errors and out of stock problems
	 *	Determines if the user selected need or give on the main view
	 *	using need flag, then makes a donation or receives a product
	 *	if the item is available. The result to the user will be some
	 *	alerts describing the donation, but the back end will still
	 *	process the inventory accordingly
	 * @throws IOException
	 * @throws InvalidUserException
	 *
	 *****************************************************************
	 * @return
	 */
	@FXML
	void process(ActionEvent event) throws IOException, InvalidUserException {

		//System.out.println(Models.hash);
		//makes alert object
		Alert a = new Alert(AlertType.CONFIRMATION);
		FileOutputStream writer = new FileOutputStream(Inventory.file, true);
		a.setHeaderText("Donation Complete!");


		//checks for valid input in all fields
		if (VerifyUser.verifyUser(userField.getText()) &&
				VerifyUser.verifyProduct(productField.getValue()) &&
				VerifyUser.verifyInt(quantityField.getText())) {

			//assigns variables to fields if they are valid
			String user = userField.getText();
			String item = productField.getValue();
			String amount = quantityField.getText();
			Donor donor = null;
			boolean choice = false;
			Needy needy = null;
			if(User.need == false) {
				if(Income.getValue()=="Yes") choice=true;
				else choice=false; //wheter to remain anonymous;
					donor = new Donor(user, item, amount,choice); //creating the donor
				User.addUserName(user, "(donor)" + " GAVE " + amount + " " +  item,donor);

			}
//			else {
////				needLabel.setText("Thank you for donating! ");
////				label1.setText("Show name? ");
//				needy = new Needy(user, position.getValue(), item, amount,);
//				//adds user's name to map of existing users
//				User2.addUserName(user, "(" +needy.getPosition() + " ) RECIEVED " + amount+ " " +  item);//for altering the data.properties.
//			}
			//on Need View
			if (User.need == true) {
				String incomeStatus;
				if(Income.getValue() == "<$2000")incomeStatus= "low";
				else incomeStatus="Ok";
				//subtractItem() will return -1 if item is not found, 0 if item is found but user has requested too much
				//Otherwise, it returns the difference after making the withdrawal
				needy = new Needy(user, position.getValue(), item, amount,incomeStatus);

				//Not OOpish
				int difference = needy.recieve();
				if (difference > 0) {
					//clears input fields
					userField.clear();
//					productField.clear();
					quantityField.clear();

					//alert message for donation
					a.setContentText("You have received " + item + " (x" + amount + ")\nThere are " + difference + " " + item + " remaining.\nBe well, " + user + "!");


					//item is found but user has requested too much
				} else if (difference == 0) {
					a.setAlertType(AlertType.ERROR);
					a.setHeaderText("Not enough inventory");
					a.setContentText("We found the item " + item + ", but we do not have " + amount + " in stock.");

					//item not found
				} else {
					a.setAlertType(AlertType.ERROR);
					a.setHeaderText("Item not found");
					a.setContentText("Sorry, we could not find " + item + " in our inventory");
				}

				//On Give View
			} else {

				//Model.additem() returns true if the item is found in inventory in order to change alerts
				if (donor.donate()) {
					a.setContentText("You have added " + item + " (x" + amount + ") to existing inventory.\nThank you " + user + "!");
				} else {
					a.setContentText("You have donated " + item + " (x" + amount + ")\nThank you " + user + "!");
				}


				//clear input fields
				userField.clear();
//				productField.clear();
				quantityField.clear();

			}

			//One or more input fields is invalid
		} else {
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid Donation");
			a.setContentText("One of your input fields is invalid. Use the buttons next to the input fields to determine validity.");


//			toast.makeText((Stage)needGivePane.getScene().getWindow(), "Please input your fields!", 500, 100, 100);

		}

		//show alert after all conditions
		a.show();
		writer.close();

	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		static_label = label1;
		static_needlabel = needLabel;
		ArrayList<String> datas = new ArrayList<String>();
		ArrayList<String> positionfields = new ArrayList<String>();
		ArrayList<String> income = new ArrayList<String>();
		income.add("<$2000");
		income.add(">$2000");
		positionfields.add("Hawker");
		positionfields.add("Needy");
		positionfields.add("Regular User");
		boolean isHawker = false;
		try {
			Inventory.loadInventory();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String data = "";
		for (Map.Entry<String, String> entry : Inventory.itemsQty.entrySet()) {
			data = entry.getKey();
			System.out.println(data);
			datas.add(data);
		}
//		productField.getItems().addAll(datas);

		if (User.need == true) {
			Income.getItems().addAll(income);
			position.getItems().addAll(positionfields);
//			income. //add income.
			Income.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
				if(newValue=="<$2000"){
					productField.getItems().clear();
					datas.add("Free Tickets");
				}else {
					productField.getItems().clear();//initialising
					productField.getItems().addAll(datas);
				}

			});
			position.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
				if (newValue == "Hawker") {
					productField.getItems().clear(); //initialising
					productField.getItems().add("Thermometer");
				} else {
					productField.getItems().clear();//initialising
					productField.getItems().addAll(datas);
				}



			}); //lambda function

		} else {
			position.getItems().addAll("Donor"); //donor tab
			ArrayList<String> yesno = new ArrayList<String>();
			yesno.add("Yes");
			yesno.add("No");
			Income.getItems().addAll(yesno);
			productField.getItems().clear();
			productField.getItems().addAll(datas);
		}

	}
}
