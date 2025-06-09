package main.repo;

import main.Programmer;

import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepo extends CrudRepository<Programmer, Integer> {}
