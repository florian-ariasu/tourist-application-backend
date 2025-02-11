package org.example;

import java.util.LinkedHashSet;
import java.util.Set;

public class Database {
  public static Database instance = null;
  private final Set<Museum> museums = new LinkedHashSet<>();
  private final Set<Group> groups = new LinkedHashSet<>();

  private Database() {
  }

  public static Database getInstance() {
    if (instance == null)
      instance = new Database();
    return instance;
  }

  public Set<Museum> getMuseums() {
    return museums;
  }

  public Set<Group> getGroups() {
    return groups;
  }

  public void addMuseum(Museum museum) {
    museums.add(museum);
  }

  public void addGroup(Group group) {
    groups.add(group);
  }

  public void addMuseums(Set<Museum> museums) {
    this.museums.addAll(museums);
  }

  public void addGroups(Set<Group> groups) {
    this.groups.addAll(groups);
  }

  public Person createNewPerson(String surname, String name, String role, String type) {
    if (type.equals("student"))
      return new Student(surname, name, role);
    else if (type.equals("profesor"))
      return new Professor(surname, name, role);
    return null;
  }

  public Group findGroup(long museumCode, String timetable) {
    for (Group group : groups)
      if (group.getMuseumCode() == museumCode && group.getTimetable().equals(timetable))
        return group;
    return null;
  }

  public Museum findMuseum(long code) {
    for (Museum museum : museums)
      if (museum.getCode() == code)
        return museum;
    return null;
  }
}
