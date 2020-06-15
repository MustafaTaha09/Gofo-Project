package OOP;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/***
 * this is the playground class which has the registered specifics playground which has been registered by the play ground owner
 * @author Ibrahim hany
 */
public class Playground {

    /***
     * Playground's name
     */
    private String name;
    /***
     * its location
     */
    private String location;
    /***
     * its description
     */
    private String description;
    /***
     * its number of available hours to be reserved which will be 12 hours
     */
    private int available_hours;
    /***
     * its booking number which will be used for player to choose which playground to book
     */
    private String booking_number;
    /***
     * its price per hour
     */
    private double price;
    /***
     * its website
     */
    private String website;
    /***
     * its cancellation period
     */
    private String cancelationPeriod;
    /***
     * an array to save in it the reserved time slots
     */
    private int[] available_time = new int[12];
    /***
     * a boolean which declares whether this playground approved by the admin or not
     */
    private boolean activasion;

    /***
     * getter for name
     * @return PG name
     */
    public String getName() {
        return name;
    }

    /***
     * setter for PG name
     * @param name PG name
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * getter for PG location
     * @return PG location
     */
    public String getLocation() {
        return location;
    }

    /***
     * setter for PG location
     * @param location PG location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /***
     * getter for PG description
     * @return PG description
     */
    public String getDescription() {
        return description;
    }

    /***
     * setter for PG description
     * @param description PG description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /***
     * getter for PG available hours
     * @return PG available hours
     */
    public int getAvailable_hours() {
        return available_hours;
    }

    /***
     * setter for PG available hours
     * @param available_hours PG available hours
     */
    public void setAvailable_hours(int available_hours) {
        this.available_hours = available_hours;
    }

    /***
     * getter for PG booking number
     * @return PG booking number
     */
    public String getBooking_number() {
        return booking_number;
    }

    /***
     * setter for PG booking number
     * @param booking_number PG booking number
     */
    public void setBooking_number(String booking_number) {
        this.booking_number = booking_number;
    }

    /***
     * getter for PG price per hour
     * @return PG price per hour
     */
    public double getPrice() {
        return price;
    }

    /***
     * setter for PG price per hour
     * @param price PG price per hour
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /***
     * getter for PG website
     * @return PG website
     */
    public String getWebsite() {
        return website;
    }

    /***
     * setter for PG website
     * @param website PG website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /***
     * getter for PG cancellation period
     * @return PG cancellation period
     */
    public String getCancelationPeriod() {
        return cancelationPeriod;
    }

    /***
     * setter for PG cancellation period
     * @param cancelationPeriod PG cancellation period
     */
    public void setCancelationPeriod(String cancelationPeriod) {
        this.cancelationPeriod = cancelationPeriod;
    }

    /***
     * getter for PG reserved time slots
     * @return PG reserved time slots
     */
    public int[] getAvailable_time() {
        return available_time;
    }

    /***
     * setter for PG reserved time slots
     * @param available_time PG reserved time slots
     */
    public void setAvailable_time(int[] available_time) {
        this.available_time = available_time;
    }

    /***
     *
     * @return printing to user every playground with its specifications
     */
    @Override
    public String toString() {
        return "Playground{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", available_hours='" + available_hours + '\'' +
                ", booking_number='" + booking_number + '\'' +
                ", price=" + price +
                ", website='" + website + '\'' +
                ", cancelationPeriod='" + cancelationPeriod + '\'' +
                '}';
    }

    /***
     * getter for PG activation
     * @return PG activation condition
     */
    public boolean isActivasion() {
        return activasion;
    }

    /***
     * setter for PG activation
     * @param activasion PG activation boolean
     */
    public void setActivasion(boolean activasion) {
        this.activasion = activasion;
    }

    /***
     * the play ground parametered Constructor
     * @param name
     * @param location
     * @param description
     * @param available_hours
     * @param booking_number
     * @param price
     * @param website
     * @param cancelationPeriod
     * @param s
     */
    public Playground(String name, String location, String description, int available_hours, String booking_number, double price, String website, String cancelationPeriod, int[] s) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.available_hours = available_hours;
        this.booking_number = booking_number;
        this.price = price;
        this.website = website;
        this.cancelationPeriod = cancelationPeriod;
        this.activasion = false;
        this.available_time = s;

    }


}
