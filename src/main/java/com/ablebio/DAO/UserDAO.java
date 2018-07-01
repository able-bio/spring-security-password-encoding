package com.ablebio.DAO;

import com.ablebio.Model.Authorities;
import com.ablebio.Model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAO {

    @Autowired
    SessionFactory sessionFactory;


    public Users getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Users where username = ?");
        query.setString(0, username);

        return (Users) query.uniqueResult();
    }

    public List<Users> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Users");
        List<Users> usersList = query.list();

        return usersList;
    }



}
