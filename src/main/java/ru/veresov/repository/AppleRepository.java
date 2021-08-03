package ru.veresov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.veresov.models.Apple;
@Repository
public interface AppleRepository extends CrudRepository<Apple, Integer> {
    Long countById(Integer id);
}
