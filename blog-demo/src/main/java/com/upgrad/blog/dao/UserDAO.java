package com.upgrad.blog.dao;

import com.upgrad.blog.db.DatabaseConnection;
import com.upgrad.blog.dto.UserDTO;
import com.upgrad.blog.interfaces.UserCRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TODO: 6.5. Implement the UserCRUD interface.
 * TODO: 6.6. findByEmail() method should take email id as an input parameter and
 * return the user details corresponding to the email id from the USERS table defined
 * in the database.
 * TODO: 6.7. create() method should take user details as input and insert these details
 * into the USERS table. Return the same UserDAO object which was passed as an input argument.
 */
public class UserDAO implements UserCRUD {
    @Override
    public UserDTO findByEmail(String emailId) throws SQLException {
        String p = "SELECT * FROM USERS WHERE email_id=?";
        ResultSet result = null;
        UserDTO userDTO = null;
        try {
            PreparedStatement ps = DatabaseConnection.getInstance().prepareStatement(p);
            ps.setString(1, emailId);
            result = ps.executeQuery();
            userDTO =new UserDTO();
            while (result.next()) {
                int id = result.getInt(1);
                String email = result.getString(2);
                String password = result.getString(3);
                userDTO.setUserId(id);
                userDTO.setEmailId(email);
                userDTO.setPassword(password);

            }


        } catch (Exception e) {
            System.out.println("Query not executed");
            e.printStackTrace();
        }
        return userDTO;
    }

    @Override
    public UserDTO create(UserDTO userDTO) throws SQLException {
        String insert = "INSERT INTO USERS (email_id, password) values (?, ?)";
        String email = userDTO.getEmailId();
        ResultSet result = null;
        try {
            PreparedStatement ps = DatabaseConnection.getInstance().prepareStatement(insert);
            ps.setString(1, email);
            ps.setString(2, userDTO.getPassword());
            result = ps.executeQuery();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return userDTO;
    }


    public static void main(String[] args) {
        try {
            UserDAO userDAO = new UserDAO();
            UserDTO temp = new UserDTO();
            temp.setUserId(1);
            temp.setEmailId("temp@temp.temp");
            temp.setPassword("temp");
            userDAO.create(temp);
            System.out.println(userDAO.findByEmail("temp@temp.temp"));
        } catch (Exception e) {
            System.out.println("FAILED");
        }

        /**
         * Following should be the desired output of the main method.
         * UserDTO{userId=11, emailId='temp@temp.temp', password='temp'}
         */
    }
}
