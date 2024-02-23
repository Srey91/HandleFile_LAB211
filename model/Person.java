/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84898
 */
public class Person {
    private String name;
    private String address;
    private double money;

    public Person() {
    }

    public Person(String name, String address, double money) {
        this.name = name;
        this.address = address;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
    public String fileFormat()
    {
        return name + ";" + address + ";" + money;
    }
    
    public void printDisplayFormat()
    {
        System.out.printf("%-15s%-20s%-15s", "|" + name, "|" + address, "|" + money);
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", address=" + address + ", money=" + money + '}';
    }
}
