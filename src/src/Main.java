import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean show = true;

    //We need a primitive database to store our students(for now ArrayList of Student Classes)
    public static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner inputMenu = new Scanner(System.in);

        Menu menu  = new Menu();
        do{
            menu.showMenu();
            String userInput = inputMenu.nextLine();
            int code  = menu.checkInput(userInput);

            switch (code){
                case 1:
                    Student student  = new Student();
                    student.createStudent(inputMenu);
                    System.out.println("\n\n");
                    System.out.println(student.getFirstName() + " " + student.getLastName()+ " Welcome");
                    System.out.println("\n\n");
                    students.add(student);
                    break;
                case 2:
                    System.out.println("\n\n");
                    System.out.println("""
                            First Name || Last Name || Email || DOB\
                            
                            ---------------------------------------
                            """);
                    for (Student value : students) {
                        System.out.println(value.getFirstName() + "     " + value.getLastName()
                        + "     " + value.getEmail() + "    " + value.getDateOfBirth());
                    }
                    System.out.println("\n\n");
                    break;
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