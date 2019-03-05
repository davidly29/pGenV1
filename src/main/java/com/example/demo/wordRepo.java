package com.example.demo;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NoRepositoryBean
public interface wordRepo extends CrudRepository<Scure1, Integer> {
    List<String> saveScure1(String v1);
    
}
