package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Задание
//        Реализуйте структуру телефонной книги с помощью HashMap.
//        Программа также должна учитывать, что во входной структуре
//        будут повторяющиеся имена с разными телефонами, их необходимо считать,
//        как одного человека с разными телефонами. Вывод должен быть отсортирован
//        по убыванию числа телефонов.
        HashMap<String, ArrayList<Integer>>  phonebook = new HashMap<>();
        boolean work = true;
        Scanner in = new Scanner(System.in);
        String name = "";
        String choice = "";
        while(work) {
            ArrayList<Integer> numbers = new ArrayList<>();
            name = "";
            System.out.println("Введите ФИО контакта: ");
            name = in.nextLine();
            System.out.println("Введите номер телефона контакта: ");
            if (phonebook.containsKey(name)) numbers = (ArrayList<Integer>) phonebook.get(name).clone();
            numbers.add(Integer.valueOf(in.nextLine()));
            phonebook.put(name, numbers);
            System.out.println("Желаете продолжить вводить контакты? (Да/Нет):");
            choice = in.nextLine().toLowerCase();
            if (!choice.equals("да")) {
                work = false;
                in.close();
            }
        }
        System.out.println(phonebook);
        LinkedHashMap<String, ArrayList<Integer>>  sortedPhonebook = new LinkedHashMap<>();
        phonebook.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue().size()))
                .forEach(n -> sortedPhonebook.put(n.getKey(),n.getValue()));
        System.out.println(sortedPhonebook);
    }

}