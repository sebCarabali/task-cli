package com.zebsoft.anime.db;

import com.zebsoft.anime.model.Task;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface TaskFileDatabase {
  void add (Task task) throws IOException;
  void update(Long id, Task updatedTask);
  Optional<Task> find(Long id);
  List<Task> findAll() throws IOException;
  void delete(Long id) throws IOException;
}
