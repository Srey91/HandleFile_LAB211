/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.Person;
import model.PersonMangement;
import validation.Validation;

/**
 *
 * @author 84898
 */
public class PersonView {
    PersonMangement pm = new PersonMangement();
    Validation v = new Validation();
    
    public void loadFile(String path, PersonMangement mangement)
    {
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader;
        
        if (file.exists() && file.isFile())
        {
            try
            {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                
                String line = bufferedReader.readLine();
                
                while (line != null)
                {
                    String[] data = line.split(";");
                    
                    String name = data[0];
                    String address = data[1];
                    double money = Double.parseDouble(data[2]);
                    
                    Person p = new Person(name, address, money);
                    mangement.add(p);
                    
                    line = bufferedReader.readLine();
                }
                System.out.println("Load file success!!!");
                    
            }catch (FileNotFoundException e)
            {
                System.out.println("File not found!!!");
            }catch (IOException e)
            {
                System.err.println("File close error!!!");
            }finally
            {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    System.out.println("File close error!!!");
                }
            }
        }
    }
    
    public void copyToFile() throws IOException
    {
        System.out.println("------------- Copy text --------------");
        String oldFilename = v.getString("Source");
        String filename = v.getString("new file name");
        PersonMangement data = new PersonMangement();
        
        File file = new File(filename);
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        
        loadFile(oldFilename, data);
        
        for (int i = 0; i < data.getPersonList().size(); i++)
        {
            String person = data.getPersonList().get(i).fileFormat() + "\n";
            printWriter.append(person);
        }
        System.out.println("Copy done...");
        
        printWriter.close();
    }
    
    public void display(PersonMangement personMangement)
    {
        System.out.println("------------- Result ----------");
        rowBorder(15); rowBorder(20); rowBorder(15); System.out.println("|");
        
        System.out.printf("%-15s%-20s%-15s", "|Name", "|Address", "|Money");
        System.out.println("|");
        rowBorder(15); rowBorder(20); rowBorder(15); System.out.println("|");
        for (Person p : personMangement.getPersonList())
        {
            p.printDisplayFormat(); System.out.println("|");
        }
        
        rowBorder(15); rowBorder(20); rowBorder(15); System.out.println("|");
    }
    
    public void find()
    {
        System.out.println("--------- Person info ---------");
        PersonMangement find = new PersonMangement();
        String path = v.getString("Path");
        loadFile(path, pm);
        double min, max = 0;
        int indexMin = 0, indexMax = 0;
        
        double salary = v.getDouble("Money");
        for (Person p : pm.getPersonList())
        {
            if (p.getMoney() >= salary)
            {
                find.add(p);
            }
        }
        
        display(find);
        
        for (Person p : find.getPersonList())
        {
            if (p.getMoney() > max)
            {
                max = p.getMoney();
                indexMax = find.getPersonList().indexOf(p);
            }
        }
        
        min = max;
        for (Person p : find.getPersonList())
        {
            if (p.getMoney() < min)
            {
                indexMin = find.getPersonList().indexOf(p);
            }
        }
        
        System.out.println("Max: " + find.getPersonList().get(indexMax).getName());
        System.out.println("Min: " + find.getPersonList().get(indexMin).getName());
    } 
    
    public void rowBorder(int number)
    {   
        System.out.print("|");
        for (int i = 0; i < number - 1; i++)
        {
            System.out.print("-");
        }
    }
}
