package ru.veresov;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import ru.veresov.models.Apple;
import ru.veresov.repository.AppleRepository;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AppleRepositoryTest {

    @Autowired private AppleRepository appleRepository;

    @Test
    public void testAddApple(){
        Apple apple = new Apple();
        apple.setGrade("grade1");
        apple.setColor("red");
        apple.setWeight(0.32);
        apple.setSour(false);

        Apple newApple = appleRepository.save(apple);
        Assertions.assertThat(newApple).isNotNull();
        Assertions.assertThat(newApple.getId()).isGreaterThan(0);
    }

    @Test
    public void testGetApplesList(){
        Iterable<Apple> apples = appleRepository.findAll();

        Assertions.assertThat(apples).hasSizeGreaterThan(0);
        for (Apple apple : apples){
            System.out.println(apple);
        }
    }

    @Test
    public void testUpdateApple(){
        Integer userID = 1;
        Optional<Apple> optional = appleRepository.findById(userID);
        Apple apple = optional.get();
        apple.setGrade("updateGrade");
        apple.setColor("yellow");
        apple.setWeight(1);
        apple.setSour(true);

        appleRepository.save(apple);

        Apple updateApple = appleRepository.findById(userID).get();
        Assertions.assertThat(updateApple.getGrade()).isEqualTo("updateGrade");
        Assertions.assertThat(updateApple.getColor()).isEqualTo("yellow");
        Assertions.assertThat(updateApple.getWeight()).isGreaterThan(0);
        Assertions.assertThat(updateApple.isSour()).isTrue();
    }

    @Test
    public void testGetApple(){
        Integer userID = 1;
        Optional<Apple> optional = appleRepository.findById(userID);
        Assertions.assertThat(optional).isPresent();
        System.out.println(optional.get());
    }

    @Test
    public void testDeleteApple(){
        Integer userID = 1;
        appleRepository.deleteById(userID);

        Optional<Apple> optional = appleRepository.findById(userID);
        Assertions.assertThat(optional).isNotPresent();
    }
}
