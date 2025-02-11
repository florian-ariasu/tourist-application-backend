package org.example;

import java.io.PrintWriter;
import java.util.List;

public class RemoveGuide extends Command {
  @Override
  public void execute(List<String> tokens, PrintWriter printWriter) {
    String surname = tokens.get(0);
    String name = tokens.get(1);
    String type = tokens.get(2);
    int age = Integer.parseInt(tokens.get(3));
    String email = tokens.get(4);
    String school = tokens.get(5);
    int years = Integer.parseInt(tokens.get(6));
    String role = tokens.get(7);
    long museumCode = Integer.parseInt(tokens.get(8));
    String timetable = tokens.get(9);

    Database database = Database.getInstance();
    Group group = database.findGroup(museumCode, timetable);
    Person person = database.createNewPerson(surname, name, role, type);
    person.setAge(age);
    person.setEmail(email);

    if (type.equals("student")) {
      ((Student) person).setSchool(school);
      ((Student) person).setStudyYear(years);
    } else if (type.equals("profesor")) {
      ((Professor) person).setSchool(school);
      ((Professor) person).setExperience(years);
    }

    if (group == null) {
      group = new Group.Builder().museumCode((int) museumCode)
        .timetable(timetable)
        .guide(null)
        .build();

      String message = group.getMuseumCode() + " ## " + group.getTimetable() +
        " ## GroupNotExistsException: Group does not exist. ## (removed member: " + person + ")";
      throw new GroupNotExistsException(message);
    }

    group.resetGuide();

    String message = group.getMuseumCode() + " ## " + group.getTimetable() + " ## " + "removed guide: " + person;
    printWriter.println(message);
  }
}