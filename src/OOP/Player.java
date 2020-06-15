package OOP;
import java.util.Scanner;

/***
 * the player class which has his specifications and his team if he want to add team
 * @author kamel mohamed
 */
public class Player implements IGofo {
    /***
     * player's name
     */
    private String name;
    /***
     * player's ID
     */
    private String ID;
    /***
     * player's Email
     */
    private String email;
    /***
     * player's password
     */
    private String password;
    /***
     * player's team
     */
    private Team team;
    Scanner in = new Scanner(System.in);

    /***
     * player's constructor
     */
    public Player(){
        this.password = null;
        this.ID = null;
        this.team = new Team();
        this.name = null;
        this.email = null;
    }

    /***
     * player's parametered constructor
     * @param name his name
     * @param email his email
     */
    public Player(String name, String email){
        this.name = name;
        this.email = email;
        this.password = null;
        this.ID = null;
        this.team = new Team();
    }

    /***
     * another player's parametered constructor
     * @param name
     * @param ID
     * @param email
     * @param password
     */
    public Player(String name, String ID, String email, String password){
        this.name = name;
        this.email = email;
        this.ID = ID;
        this.password = password;
        this.team = new Team();
    }

    /***
     * getter for player name
     * @return
     */
    public String getName() {
        return name;
    }

    /***
     * setter for player name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * getter for player ID
     * @return
     */
    public String getID() {
        return ID;
    }

    /***
     * setter for Player ID
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /***
     * getter for player email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /***
     * setter for player email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /***
     * getter for player password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /***
     * setter for player password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /***
     * getter for player's team if he want
     * @return
     */
    public Team getTeam() {
        return team;
    }

    /***
     * setter for player's team if he want
     * @param team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /***
     * this is the player's registeration function like creating his own account for GOFO system
     * @param s object from the whole system
     */
    public void register(system s){
        String name, ID, email, password, code;
        boolean flag =true;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = in.nextLine();
        System.out.println("Enter your ID:");
        ID = in.nextLine();
        System.out.println("Enter your email: ");
        email = in.nextLine();
        if(checkEmail(email))
            flag =false;
        while(flag){
            System.out.println("email should have a (@) and (.com))");
            System.out.println("Enter your email again: ");
            email = in.nextLine();
            if(checkEmail(email))
                flag =false;
        }
        System.out.println("Enter your password: ");
        password = in.nextLine();


        s.getPlayers().add(new Player(name, ID, email, password));

        while(true) {
            System.out.println("Please enter the verification code sent to ur email: (ur verification code is ur ID)");
            code = in.nextLine();
            if (code.equalsIgnoreCase(ID)) {
                System.out.println("Verification code is correct!");
//              mainMenu();
                break;
            } else {
                System.out.println("Code is incorrect!");
            }
        }
    }

    /***
     * this is the LOGIN function for player  and his home screen
     * @param s object from the whole system
     */
    public void login(system s) {
        Scanner in = new Scanner(System.in);
        String id, pass;

        int index=0;
        while(true){

            System.out.println("Enter your ID: ");
            id = in.nextLine();
            System.out.println("Enter your password: ");
            pass = in.nextLine();
            boolean flag=false;
            for (int i = 0; i < s.getPlayers().size(); i++) {
                if (id.equalsIgnoreCase(s.getPlayers().get(i).getID())) {
                    if (pass.equalsIgnoreCase(s.getPlayers().get(i).getPassword())) {
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
            System.out.println("Either ID or password is incorrect!");

        }

        System.out.println("1) Create a team");
        System.out.println("2) Book a playground");
        String choice;
        choice = in.nextLine();
        while(!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2")){
            System.out.println("invalid Choice!");
            choice = in.nextLine();
        }
        if(choice.equalsIgnoreCase("1"))
            createTeam(s, index);
        else if(choice.equalsIgnoreCase("2"))
            bookPlayground(s);
    }

    /***
     * this is the function for the player to create his team
     * @param s object of the whole system
     * @param ind index for him for easy accessing in the system
     */
    public void createTeam(system s, int ind){
        System.out.println("Enter the number of players: ");
        int num;
        num = in.nextInt();
        in.nextLine();
        for(int i =1; i<=num; i++) {
            String name, email = "";
            boolean flag = true;
            System.out.println("Enter player number " + i + " name: ");
            name = in.nextLine();
            while (flag) {
                System.out.println("Enter player number " + i + " email (should consist of (@) and (.com): ");
                email = in.nextLine();
                if (checkEmail(email))
                    flag = false;
            }
            System.out.println("A verification code has been sent to Player" + i + "'s email");

            s.getPlayers().get(ind).getTeam().getPlayers().add(new Player(name, email));
            s.getTeams().add(s.getPlayers().get(ind).getTeam());
        }
            System.out.println("Team has been created successfully!");





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

    /***
     * function for player to view all registered available PGs in the Application
     * @param s object for the whole system
     * @return boolean to know if there is any playgrounds available to show or not
     */
    public int viewPlaygrounds(system s){
        int checker=0;
        if(s.getPlaygrounds().size()>0){
            for(int i=0; i<s.getPlaygrounds().size(); i++){
                if(s.getPlaygrounds().get(i).isActivasion()){
                    ++checker;
                    System.out.println("Playground number " + ++i + ": ");
                    --i;
                    System.out.println(s.getPlaygrounds().get(i).toString());
                }
            }
        }
        else
            System.out.println("There are no playgrounds yet!");
        return checker;
    }

    /***
     * filter function to show specific PGs for the player
     * @param s object from the whole system
     */
    public void filter(system s){
        String location;
        double price;
        System.out.println("Enter the location: ");
        location = in.nextLine();
        System.out.println("Enter your maximum price: ");
        price = in.nextDouble();
        in.nextLine();

        for(int i =0; i<s.getPlaygrounds().size(); i++){
            if(s.getPlaygrounds().get(i).getPrice() <= price && s.getPlaygrounds().get(i).getLocation().equalsIgnoreCase(location) && s.getPlaygrounds().get(i).isActivasion()){
                System.out.println("Playground number " + ++i + ": ");
                --i;
                System.out.println(s.getPlaygrounds().get(i).toString());

            }
        }

    }

    /***
     * this is the function which make the player able to book any available PG he want
     * @param s object from the whole system
     */
    void bookPlayground(system s){
        if(s.getPlaygrounds().size() > 0){
            int checker=0;
            checker = viewPlaygrounds(s);
            if(checker != 0) {
                System.out.println("Do u want to filter playgrounds? (y/n)");
                String choice = in.nextLine();
                while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
                    System.out.println("Invalid choice!");
                    choice = in.nextLine();
                }
                if (choice.equalsIgnoreCase("y"))
                    filter(s);

                int idx = 0;
                while (true) {
                    boolean flag = false;
                    System.out.println("Enter the booking number of the playground u want to book");
                    String num = in.nextLine();

                    for (int i = 0; i < s.getPlaygrounds().size(); i++) {
                        if (num.equalsIgnoreCase(s.getPlaygrounds().get(i).getBooking_number())) {
                            idx = i;
                            flag = true;
                            break;
                        } else if (i == s.getPlaygrounds().size() - 1)
                            System.out.println("There is no such playground");

                    }
                    if (flag == true)
                        break;

                }

                if(s.getPlaygrounds().get(idx).getAvailable_hours() <= 0){
                    System.out.println("there is no available reservation");
                    return;
                }

//                System.out.println("Enter the time slot u want to book (ex. time: 12:00  hours: 1 ");
//                //>>>>>>>>>
//                System.out.println("Enter time :");
//                String timeString = in.nextLine();
//                System.out.println("Enter hours :");
                int hours = 0;
//                in.nextLine();
                boolean condition = true;
                //>>>>>>>>>>>>>>>>>>>>>>
                while(condition ) {
                    System.out.println("Enter the time slot u want to book (ex. time: 14:00  hours: 1) ");
                    //>>>>>>>>>
                    System.out.println("Enter time :");
                    String timeString = in.nextLine();
                    System.out.println("Enter hours :");
                     hours = in.nextInt();
                    in.nextLine();

                    timeString = timeString.substring(0, 2);
                    int timeInt = Integer.parseInt(timeString);
                    while (timeInt < 12 || timeInt + hours > 24 || hours < 1){
                        System.out.println("time should be from 12:00 ~ 24:00 (24 hours format) and hours shouldn't exceed midnight");
                        System.out.println("Enter time :");
                         timeString = in.nextLine();
                        System.out.println("Enter hours :");
                        hours = in.nextInt();
                        in.nextLine();

                        timeString = timeString.substring(0, 2);
                        timeInt = Integer.parseInt(timeString);
                    }

                    for (int i = timeInt - 12; i < timeInt - 12 + hours; i++) {
                        if (s.getPlaygrounds().get(idx).getAvailable_time()[i] == -1) {
                            System.out.println("This time isn't available");

                            break;
                        } else if (i == (timeInt - 12 + hours) - 1) {

                            s.getPlaygrounds().get(idx).setAvailable_hours(s.getPlaygrounds().get(idx).getAvailable_hours() - hours);
                            for (int j = timeInt - 12; j < timeInt - 12 + hours; j++) {
                                s.getPlaygrounds().get(idx).getAvailable_time()[j] = -1;

                                condition = false;
                            }

                        }
                    }
                }


//                while (!s.getPlaygrounds().get(idx).getAvailable_time().contains(time)) {
//                    System.out.println("Time slot doesnt exist!");
//                    time = in.nextLine();
//                }
//                if (s.getPlaygrounds().get(idx).getAvailable_time().contains(time)) {
//                    s.getPlaygrounds().get(idx).getAvailable_time().remove(time);
//                    s.getPlaygrounds().get(idx).setAvailable_hours(s.getPlaygrounds().get(idx).getAvailable_hours() - 2);
//                }

                //>>>>>>>>>>>>>>>>>>>>>>>>

                System.out.println("Price required is " + s.getPlaygrounds().get(idx).getPrice() * hours);
                System.out.println("Booking Completed!");
            }else System.out.println("There is no Available playGrounds to book!!");
        }
        else
            System.out.println("There is no playgrounds to book!");
    }
}
