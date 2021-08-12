package model;

public class VerifyUser {
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
}
