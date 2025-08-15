import java.util.Scanner;

/*
Since we are creating a student management system the primary object is the student.
A student for now has name, surname, email & dod
* */
public class Student {
    /*As discussed the fields of a class should be modified only by the class. That is why we are setting the scope
    * to private. Meaning their lifetime is bind to the class*/
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;

    /* We will create a constructor but for the first usage of the class we will not use it.
    * We will create methods that allow the user to create a student object.*/
    public Student(String firstName, String lastName, String email, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Student() {}

    /*
    * When creating the student object we have to ensure that the data follow the structure
    * we have set for the system.
    * 1.First Name & Last Nam should start with Capital letter
    * 2. The email should follow a standard format(contain @ and .com for now)
    * 3. Date of birth should be a valid date
    * */
    public void createStudent(Scanner input) {
        //Instead of checking for Capital letter and returning wrong messages we will do that.
        while (true){
            System.out.print("First Name: ");
            String firstName = input.nextLine();
            if(!firstName.isEmpty()){
                setFirstName(firstName.toUpperCase());
                break;
            }
            System.out.print("Please enter a valid first name!");
        }

        while(true){
            System.out.print("Last Name: ");
            String lastName = input.nextLine();
            if(!lastName.isEmpty()){
                setLastName(lastName.toUpperCase());
                break;
            }
            System.out.print("Please enter a valid last name!");
        }

        while(true){
            System.out.print("Email: ");
            String email = input.nextLine();
            if(isEmail(email) && !email.isEmpty()){
                setEmail(email);
                break;
            }else {
                System.out.print("Please enter a valid email!");
            }
        }

        while(true){
            System.out.print("Date of Birth: ");
            String dateOfBirth = input.nextLine();
            if(isDateOfBirthValid(dateOfBirth) && !dateOfBirth.isEmpty()){
                setDateOfBirth(dateOfBirth);
                break;
            }else {
              System.out.print("Please enter a valid date of birth!");
            }
        }
    }

    public boolean isDateOfBirthValid(String dateOfBirth){
        if(dateOfBirth == null){
            return false;
        }

        String[] split = dateOfBirth.split("-");
        if(split.length != 3){ return false;}

        try{
            int day = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int year = Integer.parseInt(split[2]);

            if(day >= 1 && day <= 31){
                if(month >= 1 && month <= 12){
                    return year >= 1950 && year <= 2020;
                }
            }
            return  false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean isEmail(String email){
        /*This is an alternative form of using conditional statements with if
        * The statement is checked and then the outcome is returned
        * */
        return email.contains("@") && email.indexOf(".") > email.indexOf("@");
    }

    /*Getters and setter
    * ------------------
    * Through these the program modifies the class fields
    * */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
