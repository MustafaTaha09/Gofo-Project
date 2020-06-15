package OOP;

import java.util.ArrayList;
import java.util.Scanner;

/***
 * This is the whole system of the GoFo application which has all information about PG , PG ONWER , PLAYER , ADMIN and TEAMS
 * @author yousef sayed
 */
public class system {
    /***
     * array list for PG owners
     */
    private ArrayList<PlaygroundOwner> PlaygroundOwners;
    /***
     * array list for Players
     */
    private ArrayList<Player> players;
    /***
     * the only admin for the GOFO program
     */
    private Administrator admin;
    /***
     * array list for PG
     */
    private ArrayList<Playground> playgrounds;
    /***
     * array list for TEAMS
     */
    private ArrayList<Team> teams;

    /***
     *
     * @return print out information about PG , PG OWNERS , PLAYERS , TEAM , ADMIN
     */
    @Override
    public String toString() {
        return "system{" +
                "PlaygroundOwners=" + PlaygroundOwners +
                ", players=" + players +
                ", admin=" + admin +
                ", playgrounds=" + playgrounds +
                ", teams=" + teams +
                '}';
    }


    /***
     * getter for array list of PG OWNERS
     * @return
     */
    public ArrayList<PlaygroundOwner> getPlaygroundOwners() {
        return PlaygroundOwners;
    }

    /***
     * setter for  array list PG owners
     * @param playgroundOwners
     */
    public void setPlaygroundOwners(ArrayList<PlaygroundOwner> playgroundOwners) {
        PlaygroundOwners = playgroundOwners;
    }

    /***
     * getter for players
     * @return
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /***
     * setter for players
     * @param players
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /***
     * getter for admin
     * @return
     */
    public Administrator getAdmin() {
        return admin;
    }

    /***
     * setter for admin
     * @param admin
     */
    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    /***
     * getter for PGs
     * @return
     */
    public ArrayList<Playground> getPlaygrounds() {
        return playgrounds;
    }

    /***
     * setter for PGs
     * @param playgrounds
     */
    public void setPlaygrounds(ArrayList<Playground> playgrounds) {
        this.playgrounds = playgrounds;
    }

    /***
     * getter for Teams
     * @return
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /***
     * setter for Teams
     * @param teams
     */
    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    /***
     * system's constructor
     */
    public system(){
        playgrounds = new ArrayList<Playground>();
        players = new ArrayList<Player>();
        teams = new ArrayList<Team>();
        PlaygroundOwners = new ArrayList<PlaygroundOwner>();
    }
}
