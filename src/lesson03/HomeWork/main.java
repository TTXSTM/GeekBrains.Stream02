package lesson03.HomeWork;

import java.util.*;

public class main {


    public static void main(String[] args) {
        String[] words = {"Mercedes", "BMW", "Audi", "Toyota", "Vokswagen",
                "Opel", "Subaru", "Range Rover", "Toyota", "Vokswagen",
                "BMW", "Audi", "Toyota", "Subaru", "Subaru",
                "Audi", "Toyota", "Subaru", "Subaru", "Toyota"};

        List<String> listString = Arrays.asList(words);

        Set<String> unique = new HashSet<String>(Arrays.asList(words));

        System.out.println("Первоначальный массив");
        System.out.println(listString.toString());
        System.out.println("Уникальные слова");
        System.out.println(unique.toString());
        System.out.println("Частота встречаемости слов");

        for(String key : unique){
            System.out.println(key + ": " + Collections.frequency(Arrays.asList(words), key));
        }




    }




}
