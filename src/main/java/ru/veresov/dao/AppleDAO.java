package ru.veresov.dao;

import ru.veresov.models.Apple;


public interface AppleDAO {
    Apple appleInfo(int id);
    void addApple(Apple apple);
    void updateApple(int id, Apple apple);
    void deleteApple(int id);
}
