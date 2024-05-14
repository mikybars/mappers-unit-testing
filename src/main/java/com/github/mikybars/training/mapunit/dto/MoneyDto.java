package com.github.mikybars.training.mapunit.dto;

public class MoneyDto {

  private double amount;

  private String currency;

  public double getAmount() {
    return amount;
  }

  public MoneyDto amount(double amount) {
    this.amount = amount;
    return this;
  }

  public String getCurrency() {
    return currency;
  }

  public MoneyDto currency(String currency) {
    this.currency = currency;
    return this;
  }

  @Override
  public String toString() {
    return "MoneyDTO{" +
        "amount=" + amount +
        ", currency='" + currency + '\'' +
        '}';
  }
}
