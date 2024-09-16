package com.zebsoft.anime;

import java.util.Map;

/**
 * Entry point for task-cli
 */
public class TaskCli {

  private static final Map<String, Command> commands;

  static {
    commands = Map.of("add", new AddCommand());
  }

  public static void main(String[] args) {
    CommandArgsPair pair = ArgParser.parse(args);
    Command command = commands.getOrDefault(pair.command(), new NotSupportedCommand());
    System.out.println(command.execute(pair.args()));
  }
}
