package ru.veresov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.veresov.AppleNotFoundException;
import ru.veresov.models.Apple;
import ru.veresov.repository.AppleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppleService {
    AppleRepository appleRepository;

    @Autowired
    public AppleService(AppleRepository appleRepository) {
        this.appleRepository = appleRepository;
    }

    public List<Apple> getAppleList() {
        return (List<Apple>) appleRepository.findAll();
    }

    public void addApple(Apple apple) {
        appleRepository.save(apple);
    }

    public Apple getApple(Integer id) throws AppleNotFoundException {
        Optional<Apple> optional = appleRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else throw new AppleNotFoundException(String.format("Apple with id %d is not found!", id));
    }

    public void deleteApple(Integer id) throws AppleNotFoundException {
        Long count = appleRepository.countById(id);
        if (count == null || count == 0){
            throw new AppleNotFoundException(String.format("Apple with id %d is not found!", id));
        }
        appleRepository.deleteById(id);
    }
}
