package gb;

import gb.animals.*;
import gb.options.AnimalBirthdayComparator;
import gb.options.Counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
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

    public static void main(String[] args) throws Exception {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); Counter counter = new Counter()) {

            boolean forward = true;
            int num = -1;
            while (forward) {
                System.out.println(menu);
                try {
                    num = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка при выборе действия");
                    continue;
                }
                switch (num) {
                    case 1:
                        printAnimals();
                        break;
                    case 2:
                        boolean result = createAnimal(reader);
                        if (result) counter.add();
                        System.out.println(result ? "О, у нас появилась новая зверушка!" : "О таком звере ничего не знаем (");
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
                        System.out.println("Количество животных по счетчику внутри класса Animals: " + Animals.getCount());
                        System.out.println("Количество животных по счетчику внутри класса Counter: " + counter.getCount());
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
    }

    static void inputData(BufferedReader reader) throws IOException {
        System.out.print("Введите имя: ");
        name = reader.readLine();
        System.out.print("Введите дату рождения в формате yyyy-MM-dd : ");
        String[] arr = reader.readLine().strip().split("-");
        try {
            birthDay = LocalDate.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | DateTimeException e) {
            birthDay = null;
            System.out.println("Дата не указана или введена не корректно");//e.printStackTrace();
        }
    }

    static boolean createAnimal(BufferedReader reader) throws IOException {
        System.out.println(menuAnimal);
        int num = inputValue(reader);
        if (num < 1) return false;
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
            default:
                System.out.println("Ошибка при вводе значения");
                return false;
        }
        animals.sort(new AnimalBirthdayComparator());
        return true;
    }

    static void printAnimals() {
        int cnt = 0;
        for (Animals animal: animals) {
            System.out.printf("%d. %s", ++cnt, animal);
            System.out.println();
        }
    }

    static void outputCommands(BufferedReader reader) throws IOException {
        System.out.println("Выберите животное:");
        printAnimals();
        int num = -1;
        try {
            num = Integer.parseInt(reader.readLine());
            animals.get(num - 1).getCommands().forEach(System.out::println);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Ошибка при выборе животного");
        }
    }

    static boolean addNewCommand(BufferedReader reader) throws IOException {
        System.out.println("Выберите животное:");
        printAnimals();
        int num = inputValue(reader);
        try {
            Animals animal = animals.get(num - 1);
            List<String> possibleCommands = animal.getPossibleCommands();
            System.out.println("Возможные команды для данного животного: " + String.join(", ", possibleCommands));
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
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка при выборе животного");
            return false;
        }
    }

    static void changeAnimal(BufferedReader reader) throws IOException {
        System.out.println("Выберите животное:");
        printAnimals();
        int num = inputValue(reader);
        try {
            Animals animal = animals.get(num - 1);
            inputData(reader);
            if (!name.isEmpty()) animal.setName(name);
            if (birthDay != null) {
                animal.setBirthDay(birthDay);
                animals.sort(new AnimalBirthdayComparator());
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка при выборе животного");
        }


    }

    static boolean deleteAnimal(BufferedReader reader) throws IOException {
        System.out.println("Выберите животное:");
        printAnimals();
        int num = inputValue(reader);
        try {
            Animals animal = animals.get(num - 1);
            return animals.remove(animal);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка при выборе животного");
            return false;
        }
    }

    static int inputValue(BufferedReader reader) throws IOException {
        int num = -1;
        try {
            num = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка при вводе значения");
            return num;
        }
        return num;
    }
}
