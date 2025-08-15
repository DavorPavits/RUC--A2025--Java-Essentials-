import static java.lang.Integer.parseInt;

/*
* Class Definition
* ----------------
* In Java, a "class" is a blueprint for creating objects.
* A class can contain:
*   -Fields (data/attributes the object stores)
*   -Methods (actions/behaviours the object can perform)
*
* The menu class in this program is responsible for:
*   1.Displaying the menu options to the user.
*   2.Validating and interpreting the user's input
*
* This helps us separate the concerns:
*   - The Menu class focuses only on menu-related logic
*   - The main program handles the overall flow of the application.
* */
public class Menu {

    /*
    Method: ShoeMenu()
    ------------------
    A "method" in Java is like a function inside a class.
    It defines a specific behaviour or action the object can perform.

    Purpose:
        -Display the list of available actions in the Student Management System
        -Provide instructions for how to select an option.

    Implement details:
        -We use System.out.println() to display each menu option on its own line.
        -The final line uses System.out.print() so the user's input appears on the
        same line as the prompt - this makes the interface cleaner.
    * */
    public void showMenu(){
        System.out.println("Welcome to Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. To exit type Exit");
        System.out.print("Choose an option by typing the indication number:");
    }

    /*
     * Method: checkInput(String choice)
     * ---------------------------------
     * Purpose:
     *   - Validate the user's input and convert it into a code
     *     that the main program can use to decide what action to take.
     *
     * Parameters:
     *   - choice: The raw string the user typed (can be a number, text, or "exit").
     *
     * Return values (special codes):
     *   - 1, 2, 3 → Valid menu selections.
     *   - -1      → Input was a number, but outside the valid menu range.
     *   - 0       → User typed "exit" (case-insensitive), meaning they want to quit.
     *   - 99      → Input was invalid (not a number, not "exit").
     *
     * How it works:
     *   1. The method tries to convert the string into an integer using Integer.parseInt().
     *      - If successful, it checks whether the number is in the valid range (1–3).
     *   2. If parsing fails (NumberFormatException is thrown):
     *      - The method checks if the input is "exit".
     *      - If yes, returns 0 to signal the program to stop.
     *      - If not, returns 99 to indicate invalid text.
     */
    public int checkInput (String choice){
        try{
            //try to interpret the input as an integer
            int num  = Integer.parseInt(choice);
            //Check if number is within valid menu range
            if (num >= 1 && num < 4){
                return num;//valid menu option
            }
            //it's a number, but not in the valid range
            return -1; //invalid number range
        }catch (NumberFormatException e){
            //Input wasn't a number - check for the special "exit" command
            if(choice.equalsIgnoreCase("exit")){//It is not case sensitive
                return 0; // exit code
            }
            return 99; // Invalid non-number input
        }
    }
}
