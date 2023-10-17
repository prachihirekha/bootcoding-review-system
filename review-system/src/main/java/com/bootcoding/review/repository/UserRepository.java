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
    public UserRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        try {
            String query = "INSERT INTO public.review_user(user_name, gmail_id, phone_number)VALUES('"+user.getUserName()+"','"+user.getEmailId()+"',"+user.getPhoneNumber()+")";
            jdbcTemplate.update(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<User> getAllUser() {
        try {
            String query = "Select * from review_user";
            return jdbcTemplate.query(query, (resultSet, rowNum) -> {
                User user = new User();
                user.setUserName(resultSet.getString("user_name"));
                user.setEmailId(resultSet.getString("gmail_id"));
                user.setPhoneNumber(resultSet.getLong("phone_number"));
                return user;
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

        public User getById ( int id){
            try {
                String query = "SELECT * FROM review_user WHERE ID= ?";
                return jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNum) -> {
                    User user = new User();
                    user.setUserName(rs.getString("user_name"));
                    user.setEmailId(rs.getString("gmail_id"));
                    user.setPhoneNumber(rs.getLong("phone_number"));
                    return user;
                });
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        public String deleteById(int id){
        try{
            String sql ="DELETE FROM review_user WHERE ID =?";
           jdbcTemplate.update(sql,id);
        }catch (Exception e){
            e.printStackTrace();

        }
        return "delete message";
        }
    public User updateById(int id,User user) {
        try {
            String sql = "update review_user set user_name=?,gmail_id=?,phone_number=? where id=?";
            jdbcTemplate.update(sql,  user.getUserName(), user.getEmailId(), user.getPhoneNumber(),id);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<User> insertMultipleUser(List<User> userslist){
        for(User user:userslist){
            try {
                String q ="INSERT INTO public.review_user(user_name, gmail_id, phone_number)VALUES('"+user.getUserName()+"','"+user.getEmailId()+"',"+user.getPhoneNumber()+")";
                jdbcTemplate.update(q);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return userslist;
    }
}



