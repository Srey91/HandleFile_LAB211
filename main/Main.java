/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.PersonController;
import view.PersonView;

/**
 *
 * @author 84898
 */
public class Main {
    public static void main(String[] args) {
        PersonView pv = new PersonView();
        PersonController pc = new PersonController();
        pc.menu(pv);
    }
}
