package OOP;
import java.util.ArrayList;
import java.util.Scanner;

/***
 * this is the team class in this application
 * @author mustafa taha
 */
public class Team {
    /***
     * array list for team's players
     */
    private ArrayList<Player> Players;

    /***
     * team's constructor
     */
    public Team() {
        Players = new ArrayList<Player>();
    }

    /***
     * getter for team
     * @return
     */
    public ArrayList<Player> getPlayers() {
        return Players;
    }

    /***
     * setter for team
     * @param players
     */
    public void setPlayers(ArrayList<Player> players) {
        Players = players;
    }
}
