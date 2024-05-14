package com.github.mikybars.training.mapunit.dto;

public class UserDto {

  private String firstName;

  private String genre;

  private MoneyDto balance;

  public String getFirstName() {
    return firstName;
  }

  public UserDto firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getGenre() {
    return genre;
  }

  public UserDto genre(String genre) {
    this.genre = genre;
    return this;
  }

  public MoneyDto getBalance() {
    return balance;
  }

  public UserDto balance(MoneyDto balance) {
    this.balance = balance;
    return this;
  }

  @Override
  public String toString() {
    return "UserDTO{" +
        "firstName='" + firstName + '\'' +
        ", genre='" + genre + '\'' +
        ", balance=" + balance +
        '}';
  }
}
