package com.upgrad.blog.dao;

/**
 * TODO: 6.12. Implement the PostsCRUD interface.
 * TODO: 6.13. Define the following methods and return null for each of them. You will provide
 * a proper implementation for each of these methods, later in this project.
 * a. findByEmail
 * b. findByTag
 * c. findAllTags
 * d. deleteById
 * TODO: 6.14. create() method should take post details as input and insert these details
 * into the POSTS table. Return the same PostDTO object which was passed as an input argument.
 */

/**
 * TODO: 7.1. Implement findByEmail() method which takes email id as an input
 * parameter and returns all the posts corresponding to the email id from the POSTS
 * table defined in the database.
*/

/**
 * TODO: 7.6. Implement deleteById() method which takes post id and email id
 * as an input parameters and delete the corresponding post from the database. If
 * the post was deleted successfully, then return true, otherwise return false.
 */

import com.upgrad.blog.db.DatabaseConnection;
import com.upgrad.blog.dto.PostDTO;
import com.upgrad.blog.dto.UserDTO;
import com.upgrad.blog.interfaces.PostsCRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * TODO: 7.10. Implement findAllTags() method which returns a set of all unique tags
 * in the POSTS table.
 * TODO: 7.11. Implement findByTag() method which takes "tag" as an input parameter and
 * returns all the posts corresponding to the input "tag" from the POSTS table defined
 * in the database.
 */
public class PostDAO implements PostsCRUD {

    @Override
    public List<PostDTO> findByEmail(String emailId) throws SQLException {
        String p = "SELECT * FROM POSTS WHERE email_id=?";
        ResultSet result = null;
        List<PostDTO> postDTOList = null;
        try {
            PreparedStatement ps = DatabaseConnection.getInstance().prepareStatement(p);
            ps.setString(1, emailId);
            result = ps.executeQuery();
            postDTOList =new ArrayList<>();
            while (result.next()) {
                PostDTO dtoObj = (PostDTO) DAOFactory.postsCRUD();
                int id = result.getInt(1);
                String email = result.getString(2);
                String title = result.getString(3);
                String tag = result.getString(4);
                String desc = result.getString(5);
                String time = result.getString(6);
                dtoObj.setEmailId(email);
                dtoObj.setTitle(title);
                dtoObj.setDescription(desc);
                dtoObj.setTag(tag);
                dtoObj.setTimestamp(LocalDateTime.parse(time));
                postDTOList.add(dtoObj);



            }


        } catch (Exception e) {
            System.out.println("Query not executed");
            e.printStackTrace();
        }
        return postDTOList;
    }
    @Override
    public boolean deleteById(int id, String emailId) throws SQLException {
        return false;
    }

    @Override
    public List<PostDTO> findByTag(String tag) throws SQLException {
        String p = "SELECT * FROM POSTS WHERE tag=?";
        ResultSet result = null;
        List<PostDTO> postDTOList = null;
        try {
            PreparedStatement ps = DatabaseConnection.getInstance().prepareStatement(p);
            ps.setString(1, tag);
            result = ps.executeQuery();
            postDTOList =new ArrayList<>();
            while (result.next()) {
                PostDTO dtoObj = new PostDTO();
                int id = result.getInt(1);
                String email = result.getString(2);
                String title = result.getString(3);
                String tagFromDB = result.getString(4);
                String desc = result.getString(5);
                String time = result.getString(6);
                dtoObj.setEmailId(email);
                dtoObj.setTitle(title);
                dtoObj.setDescription(desc);
                dtoObj.setTag(tagFromDB);
                dtoObj.setTimestamp(LocalDateTime.parse(time));
                postDTOList.add(dtoObj);

            }


        } catch (Exception e) {
            System.out.println("Query not executed");
            e.printStackTrace();
        }
        return postDTOList;
    }

    @Override
    public HashSet<String> findAllTags() throws SQLException {
        String p = "SELECT TAG FROM POSTS";
        ResultSet result = null;
        HashSet<String> allUniqueTags = null;
        try {
            PreparedStatement ps = DatabaseConnection.getInstance().prepareStatement(p);
            result = ps.executeQuery();
            allUniqueTags =new HashSet<>();
            while (result.next()) {
                String tag = result.getString(1);
                allUniqueTags.add(tag);
            }


        } catch (Exception e) {
            System.out.println("Query not executed");
            e.printStackTrace();
        }
        return allUniqueTags;
    }

    public PostDTO create(PostDTO postDTO) throws SQLException {
    String insert = "INSERT INTO POSTS (email_id, title,description, tag, timestamp) values (?, ?, ?, ?, ?)";

        String email = postDTO.getEmailId();
        String title = postDTO.getTitle();
        String description = postDTO.getDescription();
        String tag = postDTO.getTag();
        LocalDateTime timeStamp = postDTO.getTimestamp();

    ResultSet result = null;
        try {
        PreparedStatement ps = DatabaseConnection.getInstance().prepareStatement(insert);
        ps.setString(1, email);
        ps.setString(2, title);
            ps.setString(3, description);
            ps.setString(4, tag);
            ps.setString(5, timeStamp.toString());
        result = ps.executeQuery();

    } catch (SQLException e) {
        e.printStackTrace();
    }
        return postDTO;
}
}
