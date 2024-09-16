package com.zebsoft.anime.command;

import com.zebsoft.anime.util.DbUtil;

public class UpdateCommand implements Command{

    @Override
    public String execute(String... args) {
        if(args.length < 2) {
            throw new IllegalArgumentException("usage: task-cli update <task-id> \"<task-description>\"");
        }
        var task = DbUtil.find(Long.valueOf(args[0])).orElseThrow(() -> new IllegalArgumentException("task with given id not found"));
        task.setDescription(args[1]);
        DbUtil.update(Long.valueOf(args[0]), task);
        return String.format("Task with id '%s' updated to '%s'", args[0], args[1]);
    }

}
