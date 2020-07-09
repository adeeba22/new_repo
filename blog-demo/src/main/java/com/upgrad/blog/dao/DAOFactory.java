package com.upgrad.blog.dao;

import com.upgrad.blog.interfaces.PostsCRUD;
import com.upgrad.blog.interfaces.UserCRUD;

/**
 * TODO: 6.8. Provide a factory method which returns PostDAO object. (Hint: Return type
 * of this method should be PostsCRUD)
 * TODO: 6.9. Provide a factory method which returns UserDAO object. (Hint: Return type
 * of this method should be UserCRUD)
 */
public class DAOFactory {
    public static PostsCRUD postsCRUD() {
        return new PostDAO();
    }

    public static UserCRUD userCRUD() {
        return new UserDAO();
    }
}
