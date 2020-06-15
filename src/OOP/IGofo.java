package OOP;

/***
 * an interface for some functions which will be used different time but in different implementation according to the user role
 * @author yousef sayed
 */
interface IGofo {
    /***
     * registration function
     * @param s object from the whole system
     */
    void  register(system s);

    /***
     * login function
     * @param s object from the whole system
     */
    void login(system s);
}
