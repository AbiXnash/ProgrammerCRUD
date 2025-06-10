package main.repo;

import main.Programmer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammerRepo extends JpaRepository<Programmer, Integer> {
    List<Programmer> findByName(String name);
}
