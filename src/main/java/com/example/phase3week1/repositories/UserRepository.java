package com.example.phase3week1.repositories;

import com.example.phase3week1.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
