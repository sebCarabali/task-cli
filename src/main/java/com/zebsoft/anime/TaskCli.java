package com.zebsoft.anime;

import com.zebsoft.anime.command.AddCommand;
import com.zebsoft.anime.command.Command;
import com.zebsoft.anime.command.CommandArgsPair;
import com.zebsoft.anime.command.DeleteCommand;
import com.zebsoft.anime.command.ListCommand;
import com.zebsoft.anime.command.NotSupportedCommand;
import com.zebsoft.anime.parser.ArgParser;

import java.util.Map;

/**
 * Entry point for task-cli
 */
public class TaskCli {

  private static final Map<String, Command> commands;

  static {
    commands = Map.of("add", new AddCommand(), "delete", new DeleteCommand(), "list", new ListCommand());
  }

  public static void main(String[] args) {
    CommandArgsPair pair = ArgParser.parse(args);
    Command command = commands.getOrDefault(pair.command(), new NotSupportedCommand());
    System.out.println(command.execute(pair.args()));
  }
}
