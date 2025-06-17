package loginandsignup;


import java.util.HashMap;
import java.io.*;

/**
 *
 * @author Sihle Mzamo
 */
public class ManageUsers {
    

private static final String FILE_NAME = "users.ser";
    private static HashMap<String, Users> users = loadUsers();

    public static HashMap<String, Users> getUsers() {
        return users;
    }

    public static boolean isUsernameTaken(String username) {
        return users.containsKey(username);
    }

    public static boolean isPhoneUsed(String phone) {
        return users.values().stream().anyMatch(user -> user.getPhoneNumber().equals(phone));
    }

    public static void addUser(Users user) {
        users.put(user.getUsername(), user);
        saveUsers();
    }

    public static Users get(String username) {
        return users.get(username);
    }
    
    public static boolean containsKey(String username) {
        return users.containsKey(username);
    }
    public static void saveUsers() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, Users> loadUsers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (HashMap<String, Users>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }


}
