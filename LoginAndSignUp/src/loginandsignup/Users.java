package loginandsignup;

 
import java.io.Serializable;

/**
 *
 * @author Sihle Mzamo
 */

    public class Users implements Serializable{

    private final String username;
    private final String password;
    private final String phoneNumber;

    public Users(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getPhoneNumber() { return phoneNumber; }
}
    

