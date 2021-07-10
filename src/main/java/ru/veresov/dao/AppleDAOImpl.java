package ru.veresov.dao;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.veresov.models.Apple;

import java.util.List;

@Component
public class AppleDAOImpl implements AppleDAO {

    private final JdbcTemplate jdbcTemplate;

    public AppleDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Apple> start() {
        return jdbcTemplate.query("SELECT * FROM apple", new BeanPropertyRowMapper<>(Apple.class));
    }

    @Override
    public Apple appleInfo(int id) {
        return jdbcTemplate.query("SELECT * FROM apple WHERE id=?",
                new BeanPropertyRowMapper<>(Apple.class), id)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void addApple(Apple apple) {
        jdbcTemplate.update("INSERT INTO apple(weight, color, grade, sour) VALUES (?,?,?,?)",
                apple.getWeight(),
                apple.getColor(),
                apple.getGrade(),
                apple.isSour());
    }

    @Override
    public void updateApple(int id, Apple apple) {
        jdbcTemplate.update("UPDATE apple SET weight=?, color=?, grade=?, sour=? WHERE id=?",
                apple.getWeight(),
                apple.getColor(),
                apple.getGrade(),
                apple.isSour(), id);
    }

    @Override
    public void deleteApple(int id) {
        jdbcTemplate.update("DELETE FROM apple WHERE id=?", id);
    }
}