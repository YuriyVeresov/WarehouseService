package ru.veresov.dao;


import org.springframework.stereotype.Component;
import ru.veresov.models.Apple;
import ru.veresov.models.Colors;

import java.util.ArrayList;
import java.util.List;


@Component
public class AppleDAOImpl implements AppleDAO {

    private static int ID;
    private List<Apple> appleList;

    {
        appleList = new ArrayList<>();

        appleList.add(new Apple(++ID, 0.32, Colors.GREEN, "grade1",true));
        appleList.add(new Apple(++ID, 0.2, Colors.RED, "grade2",false));
        appleList.add(new Apple(++ID, 0.223, Colors.YELLOW, "grade3",true));
    }

    public List<Apple> start() {
        return appleList;
    }


    @Override
    public Apple appleInfo(int id) {
        return appleList.stream().filter(apple -> apple.getId() == id).findAny().orElse(null);
    }

    @Override
    public void addApple(Apple apple) {
        apple.setId(++ID);
        appleList.add(apple);
    }

    @Override
    public void updateApple(int id, Apple apple) {
        Apple appleToUpdated = appleInfo(id);

        appleToUpdated.setWeight(apple.getWeight());
        appleToUpdated.setColor(apple.getColor());
        appleToUpdated.setGrade(apple.getGrade());
        appleToUpdated.setSour(apple.isSour());
    }

    @Override
    public void deleteApple(int id) {
        appleList.removeIf(apple -> apple.getId() == id);
    }
}