package org.example;

import java.io.PrintWriter;

public interface Observer {
  void update(String message, PrintWriter printWriter);
}
