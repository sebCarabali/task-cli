package com.zebsoft.anime.command;

import com.zebsoft.anime.model.Status;
import com.zebsoft.anime.util.DbUtil;

public class MarkDoneCommand implements Command{

    @Override
    public String execute(String... args) {
        if(args.length < 1) {
            throw new IllegalArgumentException("usage: task-cli mark-in-progress <task-id>");
        }
        var task = DbUtil.find(Long.valueOf(args[0])).orElseThrow(() -> new IllegalArgumentException("task with given id not found"));
        task.setStatus(Status.DONE);
        DbUtil.update(Long.valueOf(args[0]), task);
        return String.format("Task with id '%s' is done", args[0]);
    }

}
