package com.zebsoft.anime.command;

import java.util.Date;

import com.zebsoft.anime.model.Status;
import com.zebsoft.anime.model.Task;
import com.zebsoft.anime.util.DbUtil;

public class AddCommand extends AbstractCommand {

  @Override
  public String execute(String... args) {
    if (args.length < 1) {
      throw new IllegalArgumentException("usage: task-cli add \"<task description>\"");
    }
    var description = args[0];
    var task = new Task.Builder()
      .description(description)
      .createdAt(new Date())
      .updatedAt(new Date())
      .status(Status.TODO)
    .build();
    DbUtil.save(task);
    return String.format("Task '%s' added.", description);
  }
}
