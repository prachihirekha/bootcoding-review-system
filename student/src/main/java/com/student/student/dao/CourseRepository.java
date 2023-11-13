package com.student.student.dao;

import com.student.student.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CourseRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public CourseRepository(DataSource dataSource,JdbcTemplate jdbcTemplate){
        this.dataSource=dataSource;
        this.jdbcTemplate=jdbcTemplate;
    }
    public void insertCourse(Course course) {
        try{
            String query ="INSERT INTO public.course(name)VALUES('"+course.getName()+"')";
           jdbcTemplate.update(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

//    public List<Course> getAllCourse() {
//        try{
//            String sql="SELECT * FROM public.course";
//            return jdbcTemplate.query(sql,(rs, rowNum) -> {
//                Course course = new Course();
//                course.setName(rs.getString("name"));
//                return  course;
//            });
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public Course getById(int id) {
//        try{
//            String sql ="SELECT * FROM course WHERE ID="+id;
//            return jdbcTemplate.queryForObject(sql,(rs, rowNum) -> {
//                Course course = new Course();
//                course.setName(rs.getString("name"));
//                return course;
//            });
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public String deleteById(int id) {
//        try {
//            String sql="DELETE FROM course WHERE ID=?";
//            jdbcTemplate.update(sql,id);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return "delete successfully";
//    }
//
//    public Course updateById(int id, Course course) {
//        try{
//            String sql="UPDATE course SET name=? WHERE ID=?";
//            jdbcTemplate.update(sql, course.getName(),id);
//            return course;
//        }catch (Exception exception){
//            exception.printStackTrace();
//            return null;
//        }
//    }
}
