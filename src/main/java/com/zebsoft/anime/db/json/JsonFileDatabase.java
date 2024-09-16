package com.zebsoft.anime.db.json;

import com.zebsoft.anime.model.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
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

  private void saveAll(List<Task> tasks) throws IOException {
    String jsonString = objectMapper.writeValueAsString(tasks);
    Files.writeString(FILE_PATH, jsonString);
  }

  @Override
  public void add(Task task) throws IOException {
    var tasks = findAll();
    task.setId(tasks.stream().map(Task::getId).max(Integer::compare).get() + 1);
    tasks.add(task);
    saveAll(tasks);
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
    createFileIfNotExists();
    String jsonContent = Files.readString(FILE_PATH);
    return objectMapper.readValue(jsonContent, new TypeReference<List<Task>>() {
    });
  }

  @Override
  public void delete(Long id) throws IOException {
    var tasks = findAll();
    boolean removed = tasks.removeIf(task -> task.getId() == id);
    if (!removed) {
      throw new IllegalArgumentException("task with given id not found");
    }
    saveAll(tasks);
  }
}
