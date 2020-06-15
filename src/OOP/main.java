package OOP;

import java.util.Scanner;

/***
 * this is the main class which has the main menu screen for admin , play ground owner and player
 * @author Ibrahem hany
 */
public class main {
    /***
     * THIS IS THE MAIN MENU TO CHOOSE FROM IT WHICE ROLE YOU ARE
     * @param s this is an object from the whole system of the GoFo application
     * @param p this is an object from a play ground owner which has his specifics and information about his playgrounds
     * @param player this is an object from a player which has his specifics and information about his team
     * @param admin this is an object from admin which has his specifics which are user name and password
     */
    public static void mainMenu(system s, PlaygroundOwner p, Player player, Administrator admin) {
        Scanner in = new Scanner(System.in);
        System.out.println("Which user are u? \n" +
                "1) Admin \n" +
                "2) Player \n" +
                "3) Playground Owner");
        String choice = in.next();
        while (!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2") && !choice.equalsIgnoreCase("3")) {
            System.out.println("invalid option!");
            choice = in.nextLine();
        }
        if (choice.equalsIgnoreCase("1")) {
            adminMainMenu(s, p, player, admin);
        } else if (choice.equalsIgnoreCase("2")) {
            System.out.println("1) Register\n" +
                    "2)Login");
            String choice3 = in.next();
            while (!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2")) {
                System.out.println("invalid option!");
                choice3 = in.nextLine();
            }
            if(choice3.equalsIgnoreCase("1"))
                player.register(s);
            else
                player.login(s);
            mainMenu(s,p,player,admin);
        }
        else
            PGmainMenu(s, p, player, admin);
    }

    /***
     * THIS IS THE MAIN MENU FOR THE PLAY GROUND OWNER
     * @param s  this is an object from the whole system of the GoFo application
     * @param p this is an object from a play ground owner which has his specifics and information about his playgrounds
     * @param player this is an object from a player which has his specifics and information about his team
     * @param admin this is an object from admin which has his specifics which are user name and password
     */
    public static void PGmainMenu(system s, PlaygroundOwner p, Player player, Administrator admin){
        Scanner in = new Scanner(System.in);
        System.out.println("1) Register\n" +
                "2)Login");
        String choice = in.nextLine();
        while (!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2")) {
            System.out.println("invalid option!");
            choice = in.nextLine();
        }
        if(choice.equalsIgnoreCase("1"))
            p.register(s);
        else
            p.login(s);

        mainMenu(s,p,player,admin);

    }

    /***
     * THIS IS THE MAIN MENU AND THE HOME SCREEN FOR THE ADMINISTRATOR
     * @param s  this is an object from the whole system of the GoFo application
     * @param p this is an object from a play ground owner which has his specifics and information about his playgrounds
     * @param player this is an object from a player which has his specifics and information about his team
     * @param admin this is an object from admin which has his specifics which are user name and password
     */
    public static  void adminMainMenu(system s, PlaygroundOwner p, Player player, Administrator admin) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your username:  (user is : admin)");
        String username = in.nextLine();
        System.out.println("Enter your password: (pass is : admin)");
        String pw = in.nextLine();
        while (!username.equalsIgnoreCase("admin") || !pw.equalsIgnoreCase("admin")) {
            System.out.println("Invalid Username or password");
            System.out.println("Enter your username: ");
            username = in.nextLine();
            System.out.println("Enter your password: ");
            pw = in.nextLine();
        }
        System.out.println("1) approve playgrounds");
        System.out.println("Enter your choice: ");
        String choice2 = in.nextLine();
        admin.ApprovePlayground(s);
        mainMenu(s, p, player, admin);
    }

    /***
     *
     * @param args for main Funcrion of the Program
     */
    public static void main(String[] args) {
        system s = new system();
        PlaygroundOwner p = new PlaygroundOwner();
        Player player = new Player();
        Administrator admin = new Administrator();

        mainMenu(s,p,player,admin);

    }

    }
