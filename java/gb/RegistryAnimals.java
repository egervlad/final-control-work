package gb;

import gb.animals.*;
import gb.options.AnimalBirthdayComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistryAnimals {

    static String menu = "Меню:" +
            "\n 1 - Список всех животных" +
            "\n 2 - Добавить новое животное" +
            "\n 3 - Список команд" +
            "\n 4 - Научить новой команде" +
            "\n 5 - Изменить данные о животном" +
            "\n 6 - Удалить запись о животном" +
            "\n 7 - Вывести общее количество всех добавленных животных" +
            "\n 0 - Выход";

    static String menuAnimal = "Выберите вид животного:" +
            "\n 1 - Котик" +
            "\n 2 - Собака" +
            "\n 3 - Хомяк" +
            "\n 4 - Лошадь" +
            "\n 5 - Верблюд" +
            "\n 6 - Осёл";

    static List<Animals> animals = new ArrayList<>();
    static String name;
    static LocalDate birthDay;

    public static void main(String[] args) throws IOException {

        animals.sort(new AnimalBirthdayComparator());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean forward = true;
        while (forward) {
            System.out.println(menu);
            int num = Integer.parseInt(reader.readLine());
            switch (num) {
                case 1:
                    outputAnimals();
                    break;
                case 2:
                    System.out.println(createAnimal(reader) ? "О, у нас появилась новая зверушка!" : "О таком звере ничего не знаем (");
                    break;
                case 3:
                    outputCommands(reader);
                    break;
                case 4:
                    System.out.println(addNewCommand(reader) ? "Очень способная зверушка, понимает все с полуслова!" : "Эту команду животное не может выполнить в принципе (");
                    break;
                case 5:
                    changeAnimal(reader);
                    break;
                case 6:
                    System.out.println(deleteAnimal(reader) ? "Запись удалена." : "Запись не удалена.");
                    break;
                case 7:
                    System.out.println(Animals.getCount());
                    break;
                case 0:
                    forward = false;
                    System.out.println("Good bay!");
                    break;
                default:
                    System.out.println("Допустимо вводить только номера пунктов меню!");
            }
            System.out.println();
        }
    }

    static void inputData(BufferedReader reader) throws IOException {
        System.out.print("Введите имя: ");
        name = reader.readLine();
        System.out.print("Введите дату рождения в формате dd.MM.yyyy : ");
        String[] arr = reader.readLine().strip().split("\\.");
        try {
            birthDay = LocalDate.of(Integer.parseInt(arr[2]), Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));
        } catch (Exception e) {
            birthDay = null;
            e.printStackTrace();
        }
    }

    static int selectKindAnimal(BufferedReader reader) throws IOException {
        System.out.println(menuAnimal);
        return Integer.parseInt(reader.readLine());
    }

    static boolean createAnimal(BufferedReader reader) throws IOException {
        int num = selectKindAnimal(reader);
        if (num < 1 || num > 6) return false;
        inputData(reader);
        if (name.isEmpty() || birthDay == null) return false;
        switch (num) {
            case 1:
                animals.add(new Cat(name, birthDay));
                break;
            case 2:
                animals.add(new Dog(name, birthDay));
                break;
            case 3:
                animals.add(new Hamster(name, birthDay));
                break;
            case 4:
                animals.add(new Horse(name, birthDay));
                break;
            case 5:
                animals.add(new Camel(name, birthDay));
                break;
            case 6:
                animals.add(new Donkey(name, birthDay));
                break;
        }
        animals.sort(new AnimalBirthdayComparator());
        return true;
    }

    static void outputAnimals() {
        int cnt = 0;
        for (Animals animal: animals) {
            System.out.printf("%d. %s", ++cnt, animal);
            System.out.println();
        }
    }

    static void outputCommands(BufferedReader reader) throws IOException {
        System.out.println("Выберите животное:");
        outputAnimals();
        int num = Integer.parseInt(reader.readLine());
        animals.get(num - 1).getCommands().forEach(System.out::println);
    }

    static boolean addNewCommand(BufferedReader reader) throws IOException {
        System.out.println("Выберите животное:");
        outputAnimals();
        int num = Integer.parseInt(reader.readLine());
        Animals animal = animals.get(num - 1);
        List<String> commands = animal.getCommands();
        System.out.print("Введите команду: ");
        String command = reader.readLine();
        if (animal.getPossibleCommands().contains(command)) {
            commands.add(command);
            animal.setCommands(commands);
            return true;
        } else {
            return false;
        }
    }

    static void changeAnimal(BufferedReader reader) throws IOException {
        System.out.println("Выберите животное:");
        outputAnimals();
        int num = Integer.parseInt(reader.readLine());
        Animals animal = animals.get(num - 1);
        inputData(reader);
        if (!name.isEmpty()) animal.setName(name);
        if (birthDay != null) {
            animal.setBirthDay(birthDay);
            animals.sort(new AnimalBirthdayComparator());
        }

    }

    static boolean deleteAnimal(BufferedReader reader) throws IOException {
        System.out.println("Выберите животное:");
        outputAnimals();
        int num = Integer.parseInt(reader.readLine());
        Animals animal = animals.get(num - 1);
        return animals.remove(animal);
    }
}
