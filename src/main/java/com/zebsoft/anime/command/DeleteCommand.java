package com.zebsoft.anime.command;

import com.zebsoft.anime.util.DbUtil;

public class DeleteCommand extends AbstractCommand {

    @Override
    public String execute(String... args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("usage: task-cli delete <task-id>");
        }
        DbUtil.delete(Long.valueOf(args[0]));
        return String.format("Task with id '%s' deleted", args[0]);
    }
}
