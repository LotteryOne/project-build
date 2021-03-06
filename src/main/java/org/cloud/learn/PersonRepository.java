package org.cloud.learn;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by tappe on 6/18/2017.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name=:name and p.address=:addresss")
     Person queryBySqlQuery(@Param("name") String name, @Param("address") String address);
    Person queryByCondition(String name, String address);





}
