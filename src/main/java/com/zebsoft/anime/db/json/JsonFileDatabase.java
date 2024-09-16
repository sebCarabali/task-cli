package com.zebsoft.anime.db.json;

import com.zebsoft.anime.model.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zebsoft.anime.db.TaskFileDatabase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class JsonFileDatabase implements TaskFileDatabase {

  private static final Path FILE_PATH = Paths.get("task-db.json");
  private ObjectMapper objectMapper = new ObjectMapper();

  private void createFileIfNotExists() throws IOException {
    if (Files.notExists(FILE_PATH)) {
        Files.createFile(FILE_PATH);
        Files.writeString(FILE_PATH, "[]"); // Initialize file with an empty array if it’s new
        System.out.println("Created new tasks.json file.");
    }
}

  @Override
  public void add(Task task) throws IOException {
    createFileIfNotExists();
    var tasks = findAll();
    task.setId(tasks.size() + 1);
    tasks.add(task);
    String jsonString = objectMapper.writeValueAsString(tasks);
        Files.writeString(FILE_PATH, jsonString);
  }

  @Override
  public void update(Long id, Task updatedTask) {

  }

  @Override
  public Optional<Task> find(Long id) {
    return Optional.empty();
  }

  @Override
  public List<Task> findAll() throws IOException {
    String jsonContent = Files.readString(FILE_PATH);
    return objectMapper.readValue(jsonContent, new TypeReference<List<Task>>() {});
  }

  @Override
  public void delete(Long id) {

  }
}
