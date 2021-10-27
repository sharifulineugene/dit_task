package com.github.sharifulin.main;

import com.github.sharifulin.entity.Person;
import com.github.sharifulin.utils.PersonFileReader;
import com.github.sharifulin.utils.PersonFileWriter;
import com.github.sharifulin.utils.PersonScanner;

import java.util.*;
import java.util.function.Predicate;

public class Main7 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        PersonScanner personScanner = new PersonScanner(scanner);

        Menu menu = new Menu(scanner);
        List<MenuItem> menuItems = new ArrayList<>();
        Comparator<Person> comparator = (Person first, Person second) -> !first.getLastName().equals(second.getLastName())
                ? first.getLastName().compareTo(second.getLastName())
                : first.getFirstName().compareTo(second.getFirstName());

        Exec readFromFile = data -> {
            System.out.println("Insert path to the file");
            PersonFileReader pfr = new PersonFileReader(scanner.nextLine());
            data.addAll(pfr.readFile());
            pfr.close();
        };
        Exec writeToFile = data -> {
            System.out.println("Specify the full path to the file to write.\n!!!Warning!!! The file will be overwritten!");
            String path = scanner.nextLine();
            try(PersonFileWriter pfw = new PersonFileWriter(path)) {
                data.stream().forEach(pfw::write);
            }
        };
        Exec uniqueSort = data -> {
            HashSet<String> set = new HashSet<>();
            data.stream().sorted(comparator).filter(p->
                    {
                        if(!set.contains(p.getLastName())) {
                            set.add(p.getLastName());
                            return true;
                        } else
                            return false;
                    }
            ).forEach(System.out::println);
        };

        menuItems.addAll(Arrays.asList(
                  new MenuItem("Add Person", data->data.add(personScanner.getPerson()))
                , new MenuItem("Show", data -> data.stream().forEach(System.out::println))
                , new MenuItem("Show sorted unique", uniqueSort)
                , new MenuItem("Save to file", writeToFile)
                , new MenuItem("Read from file", readFromFile)
                , new MenuItem("Clear data in memory", data->data.clear())

        ));
        menu.setItems(menuItems);
        menu.showMenu(personList);
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
        private void showMenu(List<Person> personList) {
            items.add(new MenuItem("Exit", data->System.exit(0)));
            int number = 0;
            MenuItem current = items.get(number);
            while(!current.name.equals("Exit")) {
                int count = 1;
                for(MenuItem menuItem: items) {
                    System.out.println("" + count++ +". " + menuItem);
                }
                number = Integer.parseInt(scanner.nextLine())-1;
                current = items.get(number);
                execMenuItem(number, personList);
            }

        }
        private void execMenuItem(int number, List<Person> list) {
            try {
                items.get(number).exec.exec(list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
