package com.zebsoft.anime.parser;

import com.zebsoft.anime.command.CommandArgsPair;
import java.util.Arrays;

public final class ArgParser {

  private ArgParser() {
  }

  public static CommandArgsPair parse(String ... programInput) {
    String command = programInput[0];
    String[] args = Arrays.copyOfRange(programInput, 1, programInput.length);
    return new CommandArgsPair(args, command);
  }
}
