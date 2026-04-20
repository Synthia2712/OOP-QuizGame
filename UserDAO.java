package dao;

import model.Player;
import java.util.List;

/**
 * Interface defining User Data Access Operations.
 * Highlights: Abstraction/Interface usage
 */
public interface UserDAO {
    void addUser(String name);
    Player getUser(String name);
    Player getUserById(int id);
    void updateUser(int id, String newName);
    void deleteUser(int id);
    List<Player> getAllUsers();
}
