package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Group implements Observer {
  private final List<Person> members = new ArrayList<>();
  private final Integer museumCode;
  private final String timetable;
  private Professor guide = null;

  private Group(Integer museumCode, String timetable) {
    this.museumCode = museumCode;
    this.timetable = timetable;
  }

  public List<Person> getMembers() {
    return this.members;
  }

  public void addMember(Person person) {
    this.members.add(person);
  }

  public void removeMember(Person person) {
    this.members.remove(person);
  }

  public Professor getGuide() {
    return this.guide;
  }

  public void addGuide(Professor guide) {
    this.guide = guide;
  }

  public void resetGuide() {
    this.guide = null;
  }

  public Integer getMuseumCode() {
    return this.museumCode;
  }

  public String getTimetable() {
    return this.timetable;
  }

  public Person findMember(Person person) {
    for (Person member : this.members)
      if (member.getSurname().equals(person.getSurname()))
        if (member.getName().equals(person.getName()))
          return member;
    return null;
  }

  @Override
  public void update(String message, PrintWriter printWriter) {
    printWriter.println(String.format(message, this.getGuide().getEmail()));
  }

  public static class Builder {
    private final List<Person> members = new ArrayList<>();
    private Integer museumCode;
    private String timetable;
    private Professor guide;

    public Builder museumCode(Integer museumCode) {
      this.museumCode = museumCode;
      return this;
    }

    public Builder timetable(String timetable) {
      this.timetable = timetable;
      return this;
    }

    public Builder guide(Professor guide) {
      this.guide = guide;
      return this;
    }

    public Group build() {
      Group group = new Group(this.museumCode, this.timetable);
      group.addGuide(this.guide);
      return group;
    }
  }
}
