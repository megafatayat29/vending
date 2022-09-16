package com.mega.Entity;

import java.util.*;

public class Machine {
  private String name;
  private Integer maxStock;
  private Integer stockAvailable;
  private Integer totalMoney;
  private Map<Snack, Integer> snackIntegerMap = new HashMap<>();
  private Set<Map.Entry<Snack, Integer> > set = snackIntegerMap.entrySet();
  private List<Map.Entry<Snack, Integer> > list = new ArrayList<>();
  private Integer moneyEntered;
  private Integer price;

  public Machine(String name, Integer maxStock, Integer totalMoney) {
    this.name = name;
    this.maxStock = maxStock;
    this.stockAvailable = this.maxStock;
    this.totalMoney = totalMoney;
  }

  public void addSnack(Snack snack, Integer howMany) {
    if (this.stockAvailable >= howMany) {
      snackIntegerMap.put(snack, howMany);
      this.stockAvailable -= howMany;
    } else {
      System.out.println("Maaf maksimal stok snack yang bisa ditampung vending machine ini adalah " + this.maxStock);
    }
  }

  public void someoneBuySnack(Snack snack, Integer howMany) {
    list.addAll(set);
    this.price = 0;
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getKey() == snack) {
        if (list.get(i).getValue() >= howMany) {
          this.price += list.get(i).getKey().getPrice() * howMany;
          System.out.println("Total harga snack " + list.get(i).getKey().getName() + " sebanyak " + howMany +" = " + this.price);
          System.out.println("Silakan masukkan uang anda! ");
          entryMoney(list.get(i).getKey().getName(), howMany, snack, list.get(i).getValue());
        } else {
          System.out.println("Maaf, " + snack + " yang tersedia di vending machine kami hanya " + list.get(i).getValue());
        }
      }
    }
  }

  private void entryMoney(String pesanan, Integer howMany, Snack snack, Integer stockExt) {
    Scanner scan = new Scanner(System.in);
    this.moneyEntered = scan.nextInt();
    if (this.moneyEntered != 2000 && this.moneyEntered != 5000 && this.moneyEntered != 10000 && this.moneyEntered != 20000 && this.moneyEntered != 50000) {
      System.out.println("Maaf, anda hanya dapat memasukkan uang 2000, 5000, 10000, 20000 atau 50000 saja!");
      System.out.println("Silakan masukkan uang lagi..");
      entryMoney(pesanan, howMany, snack, stockExt);
    } else {
      if (this.moneyEntered >= this.price) {
        Integer sisa = this.moneyEntered - price;
        snackIntegerMap.replace(snack, stockExt-howMany);
        this.totalMoney += this.price;
        if (sisa > 0) {
          System.out.println("Silakan ambil " + pesanan + " anda, sebanyak " + howMany + ". Dan uang kembalian anda sebanyak " + sisa);
        } else {
          System.out.println("Silakan ambil " + pesanan + " anda, sebanyak " + howMany);
        }
      } else {
        System.out.println("Uang yang anda masukkan kurang! Silakan masukkan uang lagi. ^_^");
        entryMoney(pesanan, howMany, snack, stockExt);
      }
    }
  }

  @Override
  public String toString() {
    return "Machine{" +
        "name='" + name + '\'' +
        ", maxStock=" + maxStock +
        ", stockAvailable=" + stockAvailable +
        ", totalMoney=" + totalMoney +
        ", snackIntegerMap=" + snackIntegerMap +
        '}';
  }
}

