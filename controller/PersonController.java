/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import menu.Menu;
import view.PersonView;

/**
 *
 * @author 84898
 */

public class PersonController {
    public void menu(PersonView pv)
    {
        String[] content = {"Find person info", "Copy Text to new file", "Exit"};
        Menu m = new Menu("========== File Processing =========", content) {
            @Override
            public void execute(int ch) {
                switch (ch)
                {
                    case 1: pv.find(); break;
                    case 2: {
                        try {
                            pv.copyToFile();
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
break;

                }
            }
        };
        m.run();
    }
}
