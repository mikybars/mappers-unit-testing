package com.github.mikybars.training.mapunit.domain;

public class User {

  private String name;

  private Genre genre;

  private Money balance;

  public String getName() {
    return name;
  }

  public User name(String name) {
    this.name = name;
    return this;
  }

  public Genre getGenre() {
    return genre;
  }

  public User genre(Genre genre) {
    this.genre = genre;
    return this;
  }

  public Money getBalance() {
    return balance;
  }

  public User balance(Money balance) {
    this.balance = balance;
    return this;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", genre=" + genre +
        ", balance=" + balance +
        '}';
  }
}
