package com.github.mikybars.training.mapunit.domain;

public class Money {

  private double amount;

  public double getAmount() {
    return amount;
  }

  public Money amount(double amount) {
    this.amount = amount;
    return this;
  }

  @Override
  public String toString() {
    return "Money{" +
        "amount=" + amount +
        '}';
  }
}
