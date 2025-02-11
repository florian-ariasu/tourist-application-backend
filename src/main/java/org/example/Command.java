package org.example;

import java.io.PrintWriter;
import java.util.List;

public abstract class Command {
  public abstract void execute(List<String> tokens, PrintWriter printWriter);
}
