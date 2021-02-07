package lesson03.HomeWork;

public class MainClass {
    public static void main(String[] args) {

            System.out.println("Создаем справочник");
            Phonebook phonebook = new Phonebook();

            System.out.println("Наполняем справочник");
            phonebook.add("Иванов", "223234234344");
            phonebook.add("Иванов", "22323423434411");
            phonebook.add("Петров", "22334234234499");
            phonebook.add("Сидоров", "2233234234488");
            phonebook.add("Иванов", "2233423422");


            System.out.println("Получаем номера");
            System.out.println("Иванов");
            System.out.println(phonebook.get("Иванов"));
            System.out.println("Петров");
            System.out.println(phonebook.get("Петров"));
            System.out.println("Сидоров");
            System.out.println(phonebook.get("Сидоров"));


            System.out.println("Случай отсутствия записи");
            System.out.println("Кузнецов");
            System.out.println(phonebook.get("Кузнецов"));


            System.out.println("Пробуем записать существующий номер");
            phonebook.add("Иванов", "223344");
            System.out.println("Иванов");
            System.out.println(phonebook.get("Иванов"));


    }
}
