package com.github.sharifulin.main;

import com.github.sharifulin.entity.Person;
import com.github.sharifulin.utils.PersonFileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        List<MenuItem> menuItems = new ArrayList<>();
        Exec readFromFile = data -> {
            System.out.println("Insert path to the file");
            PersonFileReader pfr = new PersonFileReader(scanner.nextLine());
            data.addAll(pfr.readFile());
            pfr.close();
        };
        menuItems.addAll(Arrays.asList(new MenuItem("Read from file",readFromFile)
                , new MenuItem("Clear data in memory", data->data.clear())
                ,new MenuItem("Exit", data->System.exit(0))));
        menu.setItems(menuItems);
        int number = 0;
        while(number != 3) {
            menu.showMenu();
            number = Integer.parseInt(scanner.nextLine());
            menu.execMenuItem(number, personList);
            System.out.println(personList);
        }
        scanner.close();
    }
    private interface Exec {
        void exec(List<Person> data) throws Exception;
    }

    private static class MenuItem {
        private String name;
        private Exec exec;
        private MenuItem(String name, Exec exec) {
            this.name = name;
            this.exec = exec;
        }

        public String toString(){
            return name;
        }
    }

    private static class Menu {
        private Scanner scanner;
        private List<MenuItem> items;
        private void setItems(List<MenuItem> items) {
            this.items = items;
        }
        private Menu(Scanner scanner) {
            this.scanner = scanner;
        }
        private void showMenu() {
            int count = 1;
            for(MenuItem menuItem: items) {
                System.out.println("" + count++ +". " + menuItem);
            }
        }
        private void execMenuItem(int number, List<Person> list) {
            try {
                items.get(number-1).exec.exec(list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
