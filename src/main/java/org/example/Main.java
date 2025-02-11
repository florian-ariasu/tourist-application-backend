package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    if (args.length != 2 && args.length != 4) {
      System.out.println("Invalid number of arguments.");
      return;
    }

    Database database = Database.getInstance();
    database.getMuseums().clear();
    database.getGroups().clear();

    PathTypes pathType = PathTypes.valueOf(args[0].toUpperCase());

    switch (pathType) {
      case MUSEUMS:
        processMuseumsFile(args[1]);
        break;
      case GROUPS:
        processGroupsFile(args[1]);
        break;
      case LISTENER:
        processMuseumsFile(args[1]);
        processGroupsFile(args[2]);
        processEventsFile(args[3]);
        break;
      default:
        System.out.println("Invalid path type.");
    }
  }

  private static void processMuseumsFile(String file) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file + ".in")); PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file + ".out", true)))) {
      String line;

      while ((line = bufferedReader.readLine()) != null) {
        try {
          String[] split = line.split("\\|");
          List<String> tokens = List.of(split).subList(1, split.length);

          if ("ADD MUSEUM".equals(split[0]))
            new AddMuseum().execute(tokens, printWriter);
        } catch (Exception exception) {
          printWriter.println("Exception: Data is broken. ## (" + line + ")");
          System.out.println(exception.getMessage());
        }
      }
    } catch (IOException exception) {
      System.out.println(exception.getMessage());
    }
  }

  private static void processGroupsFile(String file) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file + ".in")); PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file + ".out", true)))) {
      String line;

      while ((line = bufferedReader.readLine()) != null) {
        try {
          String[] split = line.split("\\|");
          List<String> tokens = List.of(split).subList(1, split.length);

          if ("ADD GUIDE".equals(split[0]))
            new AddGuide().execute(tokens, printWriter);
          else if ("REMOVE GUIDE".equals(split[0]))
            new RemoveGuide().execute(tokens, printWriter);
          else if ("ADD MEMBER".equals(split[0]))
            new AddMember().execute(tokens, printWriter);
          else if ("REMOVE MEMBER".equals(split[0]))
            new RemoveMember().execute(tokens, printWriter);
          else if ("FIND GUIDE".equals(split[0]))
            new FindGuide().execute(tokens, printWriter);
          else if ("FIND MEMBER".equals(split[0]))
            new FindMember().execute(tokens, printWriter);
        } catch (Exception exception) {
          printWriter.println(exception.getMessage());
        }
      }
    } catch (IOException exception) {
      System.out.println(exception.getMessage());
    }
  }

  private static void processEventsFile(String file) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file + ".in")); PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file + ".out", true)))) {
      String line;

      while ((line = bufferedReader.readLine()) != null) {
        try {
          String[] split = line.split("\\|");
          List<String> tokens = List.of(split).subList(1, split.length);

          if ("ADD EVENT".equals(split[0]))
            new AddEvent().execute(tokens, printWriter);
        } catch (Exception exception) {
          printWriter.println(exception.getMessage());
        }
      }
    } catch (IOException exception) {
      System.out.println(exception.getMessage());
    }
  }
}
