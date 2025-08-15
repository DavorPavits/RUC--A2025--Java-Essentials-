import java.util.Scanner;

public class Main {
    static boolean show = true;


    public static void main(String[] args) {
        Scanner inputMenu = new Scanner(System.in);

        Menu menu  = new Menu();
        menu.showMenu();
        do{
            String userInput = inputMenu.nextLine();
            int code  = menu.checkInput(userInput);

            switch (code){
                case 1:
                case 2:
                case 3:
                    System.out.println("Correct Choice");
                    break;
                case -1:
                    System.out.println("Wrong Choice");
                    break;
                case 0:
                    System.out.println("Bye");
                    show = false;
                    break;
                case 99:
                    System.out.println("Incorrect typing");
                    break;

                default:
                    System.out.println("Invalid Input");

            }
        }while(show);
    }
}