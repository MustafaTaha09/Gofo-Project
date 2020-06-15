package OOP;

import java.util.Scanner;

/***
 * This is the admin class for this application
 * @author mustafa taha
 */
public class Administrator {
    /***
     * admin's username
     */
    private String email;
    /***
     * admin's password
     */
    private String password;

    Scanner in = new Scanner(System.in);

    /***
     * this the admin's only function which make him able to available all playground's which its price per hour doesn't exceed 500 pounds
     * @param s object from the whole system
     */
    public void ApprovePlayground(system s) {
        if(s.getPlaygrounds().size()>0){
            for (int i = 0; i < s.getPlaygrounds().size(); i++) {
                if (s.getPlaygrounds().get(i).getPrice() < 500)
                    s.getPlaygrounds().get(i).setActivasion(true);
                else
                    s.getPlaygrounds().get(i).setActivasion(false);

            }
            System.out.println("Playgrounds Approved Successfully! ");
        }
        else
            System.out.println("There are no playgrounds to approve!");
    }
}
