import java.util.Arrays;

public class Student {
    private String name;
    private int[] grades;

    // Конструктор
    public Student(String name, int... grades) {
        this.name = name;
        setGrades(grades);
    }

    // Метод для установки оценок с проверкой на диапазон
    private void setGrades(int... grades) {
        for (int grade : grades) {
            if (grade < 2 || grade > 5) {
                System.out.println("Ошибка: Оценка должна быть в диапазоне от 2 до 5.");
                this.grades = null; // Устанавливаем grades в null, чтобы избежать использования некорректных данных
                return; // Завершаем выполнение метода, если оценка некорректна
            }
        }
        this.grades = Arrays.copyOf(grades, grades.length);
    }

    // Метод toString
    @Override
    public String toString() {
        if (grades == null) {
            return name + ": нет оценок"; // Сообщение о том, что оценок нет
        }
        return name + ": " + Arrays.toString(grades);
    }
}
