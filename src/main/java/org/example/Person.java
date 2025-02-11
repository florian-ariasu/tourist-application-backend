package org.example;

public abstract class Person {
  private final String surname;
  private final String name;
  private final String role;
  private int age;
  private String email;

  public Person(String surname, String name, String role) {
    this.surname = surname;
    this.name = name;
    this.role = role;
  }

  public String getSurname() {
    return this.surname;
  }

  public String getName() {
    return this.name;
  }

  public String getRole() {
    return this.role;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    String email = this.email.isEmpty() ? "null" : this.email;
    return "surname=" + this.surname + ", name=" + this.name + ", role=" + this.role + ", age=" + this.age + ", email" + "=" + email;
  }
}
