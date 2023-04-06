package com.example.repository;

import com.example.entity.CourseEntity;
import com.example.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import javax.naming.InitialContext;
import java.util.List;

public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {

    /*
  6. Get method by each field. (getByName, getByPrice,getByDuration)
  7. Get Course list between given 2 prices.
  8. Get Course list between 2 createdDates
     */

    List<CourseEntity> getByName(String name);
    List<CourseEntity> getByPrice(Integer price);
    List<CourseEntity> getByDuration(Integer duration);

}
