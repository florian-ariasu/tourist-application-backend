package org.example;

public class Professor extends Person {
  private String school;
  private int experience;

  public Professor(String surname, String name, String role) {
    super(surname, name, role);
  }

  public String getSchool() {
    return this.school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public int getExperience() {
    return this.experience;
  }

  public void setExperience(int experience) {
    this.experience = experience;
  }

  @Override
  public String toString() {
    return super.toString() + ", school=" + this.getSchool() + ", experience=" + this.getExperience();
  }
}