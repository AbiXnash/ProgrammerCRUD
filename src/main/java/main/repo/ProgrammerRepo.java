package main.repo;

import main.Programmer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProgrammerRepo extends CrudRepository<Programmer, Integer> {
    List<Programmer> findByName(String name);
}
