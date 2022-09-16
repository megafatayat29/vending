package com.mega;

import com.mega.Entity.Machine;
import com.mega.Entity.Snack;

public class Main {
  public static void main(String[] args) {
    Machine vendingMachine1 = new Machine("Punya Mega", 10, 0);
    Snack biskuit = new Snack("Biskuit", 6000);
    Snack chips = new Snack("Chips", 8000);
    Snack oreo = new Snack("Oreo", 10000);
    Snack tango = new Snack("Tango", 12000);
    Snack cokelat = new Snack("Cokelat", 15000);

    System.out.println("Kondisi awal Vending Machine: ");
    System.out.println(vendingMachine1);
    System.out.println();

    vendingMachine1.addSnack(biskuit, 2);
    vendingMachine1.addSnack(chips, 2);
    vendingMachine1.addSnack(oreo, 2);
    vendingMachine1.addSnack(tango, 2);
    vendingMachine1.addSnack(cokelat, 2);

    System.out.println("Kondisi Vending Machine setelah diisi penuh snack: ");
    System.out.println(vendingMachine1);
    System.out.println();

    System.out.println("Kondisi Vending Machine saat diisi snack lagi padahal sudah memenuhi maksimal stock: ");
    vendingMachine1.addSnack(cokelat, 8);
    System.out.println();

    vendingMachine1.someoneBuySnack(biskuit, 1);
    System.out.println("Kondisi setelah terjadi pembelian 1 biskuit: ");
    System.out.println(vendingMachine1);
    System.out.println();

    System.out.println("Kondisi jika terjadi pembelian snack yg kurang dari stock yg tersedia: ");
    vendingMachine1.someoneBuySnack(biskuit, 2);
  }
}
