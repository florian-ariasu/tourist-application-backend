package org.example;

import java.io.PrintWriter;

public interface Subject {
  void addObserver(Observer observer);
  void removeObserver(Observer observer);
  void notifyObservers(String message, PrintWriter printWriter);
}
