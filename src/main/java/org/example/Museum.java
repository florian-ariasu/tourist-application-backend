package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Museum implements Subject {
  private final String name;
  private final long code;
  private final long supervisorCode;
  private final Location location;
  private final List<Observer> observers = new ArrayList<>();

  public Museum(String name, long code, long supervisorCode, Location location) {
    this.name = name;
    this.code = code;
    this.supervisorCode = supervisorCode;
    this.location = location;
  }

  public String getName() {
    return this.name;
  }

  public long getCode() {
    return this.code;
  }

  public long getSupervisorCode() {
    return this.supervisorCode;
  }

  public Location getLocation() {
    return this.location;
  }

  @Override
  public String toString() {
    return this.code + ": " + this.name;
  }

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers(String message, PrintWriter printWriter) {
    for (Observer observer : observers)
      observer.update(message, printWriter);
  }
}
