package com.zebsoft.anime.command;

import java.util.List;
import java.util.Set;

import com.zebsoft.anime.model.Task;
import com.zebsoft.anime.util.DbUtil;

public class ListCommand implements Command {

    private static final Set<String> validStatus = Set.of("todo", "done", "in-progress");

    @Override
    public String execute(String... args) {
        var tasks = DbUtil.findAll();
        return buildResponse(tasks);
    }

    private String buildResponse(List<Task> tasks) {
        StringBuilder sb = new StringBuilder("Task").append("\n----------------------------------\n");
        for(var t: tasks) {
            sb.append(t.getDescription()).append("\n");
        }
        return sb.toString();
    }

}
