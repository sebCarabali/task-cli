package com.zebsoft.anime.command;

public class NotSupportedCommand implements Command {

  @Override
  public String execute(String... args) {
    return "usage: error";
  }
}
