package com.zebsoft.anime;

public class AddCommand extends AbstractCommand {

  @Override
  public String execute(String... args) {
    return "added task";
  }
}
