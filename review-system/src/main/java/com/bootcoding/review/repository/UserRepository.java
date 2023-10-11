package com.bootcoding.review.repository;

import com.bootcoding.review.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    //construtor injection
    public UserRepository(DataSource dataSource,JdbcTemplate jdbcTemplate){
        this.dataSource=dataSource;
        this.jdbcTemplate=jdbcTemplate;
    }
    public  void save(User user){
        try{
            String query ="INSERT into review_user " +"values('"+user.getUserName()+"',"+
                    "'"+user.getEmailId()+"',"+user.getPhoneNumber()+")";
            jdbcTemplate.update(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public List<User> getAllUser() {
        try{
            String query="Select * from review_user";
            return jdbcTemplate.query(query,(resultSet, rowNum) ->{
                User user =new User();
                user.setUserName(resultSet.getString(1));
                user.setEmailId(resultSet.getString(2));
                user.setPhoneNumber(resultSet.getLong(3));
                return user;
            } );
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



//    public User getById(int id) {
//        try{
//            String query="Select * from review_user where id="+;
//
//        }catch (Exception ex){
//            ex.printStackTrace();
//            return
//        }
    }

