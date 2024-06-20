package me.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.project.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
