package com.zebsoft.anime.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Task {

  private int id;
  private String description;
  private Status status;
  private Date createdAt;
  private Date updatedAt;

  private Task() {
  }

  private Task(Builder builder) {
    createdAt = builder.createdAt;
    id = builder.id;
    description = builder.description;
    status = builder.status;
    updatedAt = builder.updatedAt;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public static final class Builder {

    private Date createdAt;
    private int id;
    private String description;
    private Status status;
    private Date updatedAt;

    public Builder() {
    }

    public Builder createdAt(Date val) {
      createdAt = val;
      return this;
    }

    public Builder id(int val) {
      id = val;
      return this;
    }

    public Builder description(String val) {
      description = val;
      return this;
    }

    public Builder status(Status val) {
      status = val;
      return this;
    }

    public Builder updatedAt(Date val) {
      updatedAt = val;
      return this;
    }

    public Task build() {
      return new Task(this);
    }
  }
}
