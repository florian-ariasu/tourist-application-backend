package org.example;

public class Student extends Person {
  private String school;
  private int studyYear;

  public Student(String surname, String name, String role) {
    super(surname, name, role);
  }

  public String getSchool() {
    return this.school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public int getStudyYear() {
    return this.studyYear;
  }

  public void setStudyYear(int studyYear) {
    this.studyYear = studyYear;
  }

  @Override
  public String toString() {
    return super.toString() + ", school=" + this.getSchool() + ", studyYear=" + this.getStudyYear();
  }
}