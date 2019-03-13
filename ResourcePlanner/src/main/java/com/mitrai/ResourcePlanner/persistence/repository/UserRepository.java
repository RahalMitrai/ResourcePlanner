package com.mitrai.ResourcePlanner.persistence.repository;


import com.mitrai.ResourcePlanner.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
}
