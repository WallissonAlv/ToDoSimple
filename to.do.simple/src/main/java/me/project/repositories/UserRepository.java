package me.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.project.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
