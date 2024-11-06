import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    private Map<String, String> contacts;

    // Конструктор
    public PhoneDirectory() {
        contacts = new HashMap<>();
    }

    // Добавление новой пары "телефон - имя"
    public String addContact(String contact) {
        String[] parts = contact.split(" - ");
        if (parts.length != 2) {
            System.out.println("Ошибка: Ввод должен быть в формате 'телефон - имя'.");
            return null;
        }

        String phone = parts[0].trim();
        String name = parts[1].trim();

        // Проверка на корректность телефона
        if (!phone.matches("\\d{10,15}")) { // Пример: телефон должен содержать от 10 до 15 цифр
            System.out.println("Ошибка: Телефон должен содержать только цифры и быть длиной от 10 до 15 символов.");
            return null;
        }

        return contacts.put(name, phone); // Возвращает старый телефон, если имя уже существует
    }

    // Удаление контакта по имени
    public String removeContact(String name) {
        return contacts.remove(name); // Удаляет пару и возвращает телефон
    }

    // Получение телефона по имени
    public String getPhoneByName(String name) {
        return contacts.get(name); // Возвращает телефон, если имя существует
    }

    // Приведение к строке (полный перечень всех пар)
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            result.append(entry.getValue()).append(" - ").append(entry.getKey()).append("\n");
        }
        return result.toString();
    }

    // Проверка наличия телефона
    public boolean hasPhone(String phone) {
        return contacts.containsValue(phone);
    }

    // Проверка наличия имени
    public boolean hasName(String name) {
        return contacts.containsKey(name);
    }

    // Получение текущего количества контактов
    public int getContactCount() {
        return contacts.size();
    }

    // Получение всех пар
    public String[] getAllPairs() {
        List<String> pairs = new ArrayList<>();
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            pairs.add(entry.getValue() + " - " + entry.getKey());
        }
        return pairs.toArray(new String[0]);
    }

    // Получение всех телефонов
    public String[] getAllPhones() {
        return contacts.values().toArray(new String[0]);
    }

    // Получение всех имен
    public String[] getAllNames() {
        return contacts.keySet().toArray(new String[0]);
    }

    // Получение массива имен, начинающихся с указанной части
    public String[] getNamesStartingWith(String prefix) {
        List<String> matchingNames = new ArrayList<>();
        for (String name : contacts.keySet()) {
            if (name.startsWith(prefix)) {
                matchingNames.add(name);
            }
        }
        return matchingNames.toArray(new String[0]);
    }
}
