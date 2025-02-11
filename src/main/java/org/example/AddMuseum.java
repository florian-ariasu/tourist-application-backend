package org.example;

import java.io.PrintWriter;
import java.util.List;

public class AddMuseum extends Command {
  @Override
  public void execute(List<String> tokens, PrintWriter printWriter) {
    long code = Long.parseLong(tokens.get(0));
    String name = tokens.get(1);
    String county = tokens.get(2);
    long supervisorCode = Long.parseLong(tokens.get(13));
    int sirutaCode = Integer.parseInt(tokens.get(15));

    Location location = new Location(county, sirutaCode);
    Museum museum = new Museum(name, code, supervisorCode, location);

    Database database = Database.getInstance();
    database.addMuseum(museum);

    printWriter.println(museum);
  }
}
