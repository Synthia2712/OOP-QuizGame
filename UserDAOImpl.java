package dao;

import model.Player;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private Connection conn;

    public UserDAOImpl() {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public void addUser(String name) {
        String sql = "INSERT INTO users(name) VALUES (?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    @Override
    public Player getUser(String name) {
        String sql = "SELECT id, name FROM users WHERE name = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Player(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
             System.out.println("Error retrieving user: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Player getUserById(int id) {
        String sql = "SELECT id, name FROM users WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Player(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
             System.out.println("Error retrieving user by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void updateUser(int id, String newName) {
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("User with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("User with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }

    @Override
    public List<Player> getAllUsers() {
        List<Player> list = new ArrayList<>();
        String sql = "SELECT id, name FROM users";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Player(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving users: " + e.getMessage());
        }
        return list;
    }
}
