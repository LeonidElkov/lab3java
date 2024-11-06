import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Выберите действие от 0 до 4: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Ошибка! Введите целое число: ");
                scanner.next();
            }
            int d = scanner.nextInt();
            if (d < 0 || d > 4) {
                System.out.println("Введено неверное значение!");
                continue;
            }
            switch (d) {
                case 0:
                    System.out.println("Программа завершена.");
                    return;
                case 1:
                    Scanner scanner1 = new Scanner(System.in);

                    System.out.print("Введите количество студентов: ");
                    int numberOfStudents = Integer.parseInt(scanner1.nextLine());

                    Student[] students = new Student[numberOfStudents];

                    for (int i = 0; i < numberOfStudents; i++) {
                        System.out.print("Введите имя студента: ");
                        String name = scanner1.nextLine();

                        System.out.print("Введите оценки (через пробел): ");
                        String[] gradesInput = scanner1.nextLine().split(" ");
                        int[] grades = new int[gradesInput.length];

                        // Проверка на корректность ввода оценок
                        boolean validGrades = true;
                        for (int j = 0; j < gradesInput.length; j++) {
                            try {
                                grades[j] = Integer.parseInt(gradesInput[j]);
                                if (grades[j] < 2 || grades[j] > 5) {
                                    System.out.println("Ошибка: Оценка должна быть в диапазоне от 2 до 5.");
                                    validGrades = false;
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: Введите корректное число для оценки.");
                                validGrades = false;
                                break;
                            }
                        }

                        if (validGrades) {
                            students[i] = new Student(name, grades);
                        } else {
                            System.out.println("Студент не был добавлен из-за некорректных оценок.");
                            i--; // Уменьшаем счетчик, чтобы повторить ввод для этого студента
                        }
                    }

                    // Вывод информации о студентах
                    System.out.println("\nИнформация о студентах:");
                    for (Student student : students) {
                        if (student != null) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 3:
                    Scanner scanner2 = new Scanner(System.in);

                    // Ввод для первой точки
                    System.out.print("Введите координаты первой точки (x y z): ");
                    double x1 = scanner2.nextDouble();
                    double y1 = scanner2.nextDouble();
                    double z1 = scanner2.nextDouble();
                    Pointxyz point1 = new Pointxyz(x1, y1, z1);

                    // Ввод для второй точки
                    System.out.print("Введите координаты второй точки (x y z): ");
                    double x2 = scanner2.nextDouble();
                    double y2 = scanner2.nextDouble();
                    double z2 = scanner2.nextDouble();
                    Pointxyz point2 = new Pointxyz(x2, y2, z2);

                    // Ввод для третьей точки
                    System.out.print("Введите координаты третьей точки (x y z): ");
                    double x3 = scanner2.nextDouble();
                    double y3 = scanner2.nextDouble();
                    double z3 = scanner2.nextDouble();
                    Pointxyz point3 = new Pointxyz(x3, y3, z3);

                    // Вывод точек
                    System.out.println("Точки:");
                    System.out.println(point1);
                    System.out.println(point2);
                    System.out.println(point3);
                    break;

                case 2:
                    Scanner scanner3 = new Scanner(System.in);
                    PhoneDirectory directory = new PhoneDirectory();

                    while (true) {
                        System.out.println("Выберите действие:");
                        System.out.println("1. Добавить контакт");
                        System.out.println("2. Удалить контакт");
                        System.out.println("3. Получить телефон по имени");
                        System.out.println("4. Вывести все контакты");
                        System.out.println("5. Проверить наличие телефона");
                        System.out.println("6. Проверить наличие имени");
                        System.out.println("7. Получить количество контактов");
                        System.out.println("8. Получить все пары");
                        System.out.println("9. Получить все телефоны");
                        System.out.println("10. Получить все имена");
                        System.out.println("11. Получить имена, начинающиеся с");
                        System.out.println("0. Выход");

                        int choice = Integer.parseInt(scanner3.nextLine());

                        switch (choice) {
                            case 1: // Добавить контакт
                                System.out.print("Введите контакт в формате 'телефон - имя': ");
                                String contact = scanner3.nextLine();
                                String oldPhone = directory.addContact(contact);
                                if (oldPhone != null) {
                                    if (oldPhone != null) {
                                        System.out.println("Существующий телефон " + oldPhone + " заменен на новый.");
                                    } else {
                                        System.out.println("Контакт добавлен.");
                                    }
                                }
                                break;
                            case 2: // Удалить контакт
                                System.out.print("Введите имя для удаления: ");
                                String nameToRemove = scanner3.nextLine();
                                String removedPhone = directory.removeContact(nameToRemove);
                                if (removedPhone != null) {
                                    System.out.println("Контакт " + nameToRemove + " с телефоном " + removedPhone + " удален.");
                                } else {
                                    System.out.println("Контакт не найден.");
                                }
                                break;
                            case 3: // Получить телефон по имени
                                System.out.print("Введите имя для поиска: ");
                                String nameToSearch = scanner3.nextLine();
                                String foundPhone = directory.getPhoneByName(nameToSearch);
                                if (foundPhone != null) {
                                    System.out.println("Телефон для " + nameToSearch + ": " + foundPhone);
                                } else {
                                    System.out.println("Контакт не найден.");
                                }
                                break;
                            case 4: // Вывести все контакты
                                System.out.println("Все контакты:");
                                System.out.println(directory);
                                break;
                            case 5: // Проверить наличие телефона
                                System.out.print("Введите телефон для проверки: ");
                                String phoneToCheck = scanner3.nextLine();
                                System.out.println("Телефон " + (directory.hasPhone(phoneToCheck) ? "найден." : "не найден."));
                                break;
                            case 6: // Проверить наличие имени
                                System.out.print("Введите имя для проверки: ");
                                String nameToCheck = scanner3.nextLine();
                                System.out.println("Имя " + (directory.hasName(nameToCheck) ? "найдено." : "не найдено."));
                                break;
                            case 7: // Получить количество контактов
                                System.out.println("Количество контактов: " + directory.getContactCount());
                                break;
                            case 8: // Получить все пары
                                System.out.println("Все пары:");
                                for (String pair : directory.getAllPairs()) {
                                    System.out.println(pair);
                                }
                                break;
                            case 9: // Получить все телефоны
                                System.out.println("Все телефоны:");
                                for (String phoneNumber : directory.getAllPhones()) {
                                    System.out.println(phoneNumber);
                                }
                                break;
                            case 10: // Получить все имена
                                System.out.println("Все имена:");
                                for (String contactName : directory.getAllNames()) {
                                    System.out.println(contactName);
                                }
                                break;
                            case 11: // Получить имена, начинающиеся с
                                System.out.print("Введите префикс: ");
                                String prefix = scanner3.nextLine();
                                System.out.println("Имена, начинающиеся с '" + prefix + "':");
                                for (String matchedName : directory.getNamesStartingWith(prefix)) {
                                    System.out.println(matchedName);
                                }
                                break;
                            case 0: // Выход
                                System.out.println("Выход из программы.");
                                return;
                            default:
                                System.out.println("Неверный выбор. Попробуйте снова.");
                                break;
                        }
                    }
                case 4:
                    Scanner scanner4 = new Scanner(System.in);

                    // Ввод для первой точки
                    System.out.print("Введите координаты первой точки (x y): ");
                    double x4 = scanner4.nextDouble();
                    double y4 = scanner4.nextDouble();
                    Point point4 = new Point(x4, y4);

                    // Ввод для второй точки
                    System.out.print("Введите координаты второй точки (x y): ");
                    double x5 = scanner4.nextDouble();
                    double y5 = scanner4.nextDouble();
                    Point point5 = new Point(x5, y5);

                    System.out.print("Введите координаты второй точки (x y): ");
                    double x6 = scanner4.nextDouble();
                    double y6 = scanner4.nextDouble();
                    Point point6 = new Point(x6, y6);


            }
        }
            }
        }
