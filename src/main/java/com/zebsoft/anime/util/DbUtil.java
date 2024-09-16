package com.zebsoft.anime.util;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.zebsoft.anime.db.TaskFileDatabase;
import com.zebsoft.anime.db.json.JsonFileDatabase;
import com.zebsoft.anime.model.Task;

public class DbUtil {

    private static final TaskFileDatabase fileDb = new JsonFileDatabase();

    public static List<Task> findAll()  {
        try {
            return fileDb.findAll();
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    public static void save(Task task) {
        try {
            fileDb.add(task);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
