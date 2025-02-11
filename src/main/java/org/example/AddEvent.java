package org.example;

import java.io.PrintWriter;
import java.util.List;

public class AddEvent extends Command {
  @Override
  public void execute(List<String> tokens, PrintWriter printWriter) {
    int museumCode = Integer.parseInt(tokens.get(0));
    String msg = tokens.get(1);

    Database database = Database.getInstance();
    Museum museum = database.findMuseum(museumCode);

    if (museum == null)
      return;

    String message = "To: %s ## Message: " + museum.getName() + " (" + museumCode + ") " + msg;
    museum.notifyObservers(message, printWriter);
  }
}
