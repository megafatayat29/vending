package com.mega.Entity;

public class Snack {
  private String name;
  private Integer price;

  public Snack(String name, Integer price) {
    this.name = name;
    this.price = price;
  }

  public Integer getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Snack{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
