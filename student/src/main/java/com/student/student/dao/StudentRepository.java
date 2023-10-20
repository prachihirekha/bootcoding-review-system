package com.student.student.dao;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.student.student.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StudentRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    //construtor injection
    public StudentRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertStudent(Student student) {
        try {
            String query = "INSERT INTO public.student_details(user_name, gmail_id, phone_number, address)VALUES('" + student.getStudentName() + "','" + student.getGmailId() + "'," + student.getPhoneNumber() + ",'" + student.getAddress() + "')";
            jdbcTemplate.update(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudent() {
        try {
            String sql = "SELECT * FROM public.student_details";
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                Student student = new Student();
                student.setStudentName(rs.getString("user_name"));
                student.setGmailId(rs.getString("gmail_id"));
                student.setPhoneNumber(rs.getLong("phone_number"));
                student.setAddress(rs.getString("address"));
                return student;
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Student getStudentById(int id) {
        try{
            String sql="SELECT * FROM student_details WHERE ID=?";
            return jdbcTemplate.queryForObject(sql,new Object[]{id},(rs, rowNum) ->{
                Student student=new Student();
                student.setStudentName(rs.getString("user_name"));
                student.setGmailId(rs.getString("gmail_id"));
                student.setPhoneNumber(rs.getLong("phone_number"));
                student.setAddress((rs.getString("address")));
                return student;
            } );
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

    public String deleteById(int id) {
        try {
            String query="DELETE FROM student_details WHERE ID=?";
            jdbcTemplate.update(query,id);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return "delete successfully";
    }

    public Student updateById(int id, Student student) {
        try{
            String sql="update student_details set user_name=?,gmail_id=?,phone_number=?,address=? where id=?";
            jdbcTemplate.update(sql,student.getStudentName(),student.getGmailId(),student.getPhoneNumber(),student.getAddress(),id);
            return student;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
