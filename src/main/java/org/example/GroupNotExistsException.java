package org.example;

public class GroupNotExistsException extends RuntimeException {
  public GroupNotExistsException(String message) {
    super(message);
  }
}
