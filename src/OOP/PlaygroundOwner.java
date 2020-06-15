package OOP;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

/***
 * this is the PG owner class which has his specifications and playgrounds which he registered in the system
 * @author kamel mohamed
 */

public class PlaygroundOwner implements IGofo {
    /***
     * PG OWNER NAME
     */
    private String name;
    /***
     * PG OWNER ID
     */
    private String ID;
    /***
     * PG OWNER EMAIL
     */
    private String email;
    /***
     * PG OWNER PASSWORD
     */
    private String password;
    /***
     * ARRAYLIST FOR PG WHICH HE REGISTERED
     */
    private ArrayList<Playground> playground;
    /***
     * HIS  ADDRESS
     */
    private String address;
    /***
     * HIS PHONE NUMBER
     */
    private String phone;
    Scanner in = new Scanner(System.in);

    /***
     * PG OWNER CONSTRUCTOR
     */
    public PlaygroundOwner() {
        this.name = null;
        this.ID = null;
        this.email = null;
        this.password = null;
        this.address = null;
        this.phone = null;
        playground = new ArrayList<Playground>();

    }

    /***
     * PG OWNER PARAMETERED CONSTRUCTOR
     * @param name
     * @param ID
     * @param email
     * @param password
     */
    public PlaygroundOwner(String name, String ID, String email, String password) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.ID = ID;
        this.playground = new ArrayList<Playground>();
    }

    /***
     * getter for PG owner name
     * @return
     */
    public String getName() {
        return name;
    }

    /***
     * setter for his name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * getter for his ID
     * @return
     */
    public String getID() {
        return ID;
    }

    /***
     * setter for PG owner ID
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /***
     * getter for his email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /***
     * setter for his email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /***
     * getter for his password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /***
     * setter for his password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /***
     * getter for array list of PGs which he registered
     * @return
     */
    public ArrayList<Playground> getPlayground() {
        return playground;
    }

    /***
     * setter for array list of PGs which he registered
     * @param playground
     */
    public void setPlayground(ArrayList<Playground> playground) {
        this.playground = playground;
    }

    /***
     * getter for his address
     * @return
     */
    public String getAddress() {
        return address;
    }

    /***
     * setter for his address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /***
     * getter for his phone number
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /***
     * setter for his phone number
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /***
     * this is the PG owner registration function like creating his account in the system
     * @param s object from the whole system
     */
    public void register(system s) {
        boolean flag = true;
        String name, ID, email, password, code;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = in.nextLine();
        System.out.println("Enter your ID:");
        ID = in.next();
        System.out.println("Enter your email: ");
        email = in.next();
        if(checkEmail(email))
            flag =false;
        while(flag){
            System.out.println("email should have a (@) and (.com))");
            System.out.println("Enter your email again: ");
            email = in.next();
            if(checkEmail(email))
                flag =false;

        }
        System.out.println("Enter your password: ");
        password = in.next();

        s.getPlaygroundOwners().add(new PlaygroundOwner(name, ID, email, password));

        while (true) {
            System.out.println("Please enter the verification code sent to ur email (the code is ur ID): ");
            code = in.next();
            if (code.equalsIgnoreCase(ID)) {
                System.out.println("Verification code is correct!");
                break;
            } else {
                System.out.println("Code is incorrect!");
            }
        }

    }

    /***
     * this is the PG owner login function and his home screen
     * @param s object from the whole system
     */

    public void login(system s) {
        Scanner in = new Scanner(System.in);
        String id, pass;

        int index=0;
        while(true){

            System.out.println("Enter your ID: ");
            id = in.next();
            System.out.println("Enter your password: ");
            pass = in.next();
            boolean flag=false;
            for (int i = 0; i < s.getPlaygroundOwners().size(); i++) {
                if (id.equalsIgnoreCase(s.getPlaygroundOwners().get(i).getID())) {
                    if (pass.equalsIgnoreCase(s.getPlaygroundOwners().get(i).getPassword())) {
                        System.out.println("Logged in successfully!");
                        index = i;
                        flag = true;
                        break;
                    }

                }

            }
            if(flag){
                break;
            }
            System.out.println("Either email or password is incorrect!");

        }

        System.out.println("Do u want to add a playground? (y/n)");
        String choice;
        choice = in.next();
        while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
            System.out.println("invalid Choice!");
            System.out.println("Do u want to add a playground? (y/n)");
            choice = in.next();
        }
        if(choice.equalsIgnoreCase("y"))
            createProfile(s, index);


    }

    /***
     * this is a function for adding more information in his profile like address, phone and his playground which he want to register
     * @param s object from the whole GOFO system
     * @param i index for him for easy accessing in the system
     */
    public void createProfile(system s, int i){
        String address, phone;
        System.out.println("Enter your address: ");
        address = in.nextLine();

        System.out.println("please enter your phone: ");
        phone = in.nextLine();

        s.getPlaygroundOwners().get(i).setPhone(phone);
        s.getPlaygroundOwners().get(i).setAddress(address);

        String pgname, location, description, booking_number,cancelationPeriod, website;
        boolean activasion;
        int available_hours;
        double price;
        System.out.println("Please note that available play hours will be 12 hours only from 12:00 ~ 00:00  ");
        available_hours = 12;

        System.out.println("Enter your playground's name: ");
        pgname = in.nextLine();
        System.out.println("Enter your playground's location: ");
        location = in.nextLine();




        System.out.println("Enter your playground's description: ");
        description = in.nextLine();
        System.out.println("Enter your playground's booking number: ");
        booking_number = in.nextLine();
        System.out.println("Enter your playground's price per hour:  ");
        price = in.nextDouble();
        in.nextLine();
        System.out.println("Enter your playground's cancelation period: ");
        cancelationPeriod = in.nextLine();
        System.out.println("Enter your playground's website");
        website = in.nextLine();

        int[] time = new int[12];


        s.getPlaygrounds().add(new Playground(pgname, location, description, available_hours, booking_number, price, website, cancelationPeriod, time));
        s.getPlaygroundOwners().get(i).getPlayground().add(new Playground(pgname, location, description, available_hours, booking_number, price, website, cancelationPeriod, time));


    }

    /***
     * this is a function for making sure that the email following the specific format (@) and (.com)
     * @param email
     * @return
     */
    public boolean checkEmail(String email){
        if(email.contains("@") && email.contains(".com"))
            return true;
        else
            return false;

    }

}
