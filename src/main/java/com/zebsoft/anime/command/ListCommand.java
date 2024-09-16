package com.zebsoft.anime.command;

import java.util.List;
import java.util.Set;

import com.zebsoft.anime.model.Status;
import com.zebsoft.anime.model.Task;
import com.zebsoft.anime.util.DbUtil;

public class ListCommand implements Command {

    private static final Set<String> VALID_STATUS = Set.of("todo", "done", "in-progress");

    @Override
    public String execute(String... args) {
        var tasks = DbUtil.findAll();
        if (args.length == 0) {
            return buildResponse(tasks);
        }
        String status = args[0];
        if (!VALID_STATUS.contains(status)) {
            throw new IllegalArgumentException("The given status is not valid.");
        }
        switch (status) {
            case "done":
                return buildResponse(tasks.stream().filter(t -> t.getStatus().equals(Status.DONE)).toList());
            case "todo":
                return buildResponse(tasks.stream().filter(t -> t.getStatus().equals(Status.TODO)).toList());
            case "in-progress":
                return buildResponse(tasks.stream().filter(t -> t.getStatus().equals(Status.IN_PROGRESS)).toList());
            default:
                return "No tasks found";
        }
    }

    private String buildResponse(List<Task> tasks) {
        StringBuilder sb = new StringBuilder("Task").append("\n----------------------------------\n");
        for (var t : tasks) {
            sb.append(t.getDescription()).append("\n");
        }
        return sb.toString();
    }

}
