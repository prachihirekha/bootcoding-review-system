package com.bootcoding.review.repository;

import com.bootcoding.review.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository

public class ReviewRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    //constuctor
    public ReviewRepository(DataSource dataSource, JdbcTemplate jdbcTemplate){
        this.dataSource=dataSource;
        this.jdbcTemplate=jdbcTemplate;
    }
    public void save(Review review){
        try {
            String query = "INSERT INTO review VALUES ('" +review.getUserId() + "','" + review.getTotalCount() + "', '" + review.getOneStar() + "', '" +
                    review.getTwoStar() + "', '" + review.getThreeStar() + "', '" +
                    review.getFourStar() + "', '" + review.getFiveStar() + "')";
            jdbcTemplate.update(query);

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public List<Review> getAllReview() {
        try {
            String query = "select * from review";
            return jdbcTemplate.query(query, (rs, rowNum) -> {
                Review review = new Review();
                review.setUserId(rs.getInt(1));
                review.setTotalCount(rs.getInt(2));
                review.setOneStar(rs.getInt(3));
                review.setTwoStar(rs.getInt(4));
                review.setThreeStar(rs.getInt(5));
                review.setFourStar(rs.getInt(6));
                review.setFiveStar(rs.getInt(7));
                return review;
            });

          }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
