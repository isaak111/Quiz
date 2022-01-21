package se.superdevs;

import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){

        stringReturnString upperCase = new stringReturnString() {
            @Override
            public String check(String string) {
                return string.toUpperCase(Locale.ROOT);
            }
        };

        System.out.println(upperCase.check("jonas"));


        Predicate<Integer> greaterThanTen = x -> x > 100;
        MyFuncIgen <Integer, Integer> dubbleras = x -> x * 2;
      Function<Double,Double> sqrtAsMr = x -> Math.sqrt(x + 10);

        List<Integer> lista = List.of(1,2,3,4,5);

        System.out.println(
                lista
                        .stream()
                        .reduce(0, (sum,el) -> sum +el)
        );

        class Employee {
            String name;
            int age;
            double salary;

            public Employee(String name, int age, double salary) {
                this.name = name;
                this.age = age;
                this.salary = salary;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }

            public double getSalary() {
                return salary;
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        ", salary=" + salary +
                        '}';

            }
        }
        List<Employee> employees = List.of(
                new Employee("Jonas",62,37000),
                new Employee("Hanna",26,31000),
                new Employee("Sara",55,34000),
                new Employee("Kristian",12,39000),
                new Employee("Calle",11,44000));

        System.out.println(
                employees
                        .stream()
                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .limit(3)
                        .sorted(Comparator.comparing(Employee::getAge))
                        .skip(1)
                        .limit(1)
                        .toList()
        );

        List<String> ord = List.of("Bil", "Banan", "Burk", "Kräfta", "Penna");

        System.out.println(
                ord
                        .stream()
                        .mapToDouble(String::length).average().getAsDouble()
        );

        List<Integer> points = List.of(7,4,9,4,2,7,10);

        Function<List<Integer>, Double> averageScore = list -> list
                .stream()
                .sorted(Comparator.naturalOrder())
                .skip(2)
                .limit(3)
                .mapToDouble(x -> x)
                .summaryStatistics()
                .getAverage();

        System.out.println(averageScore.apply(points));

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .forEach(x -> {
                    if(x % 2 == 0){
                        System.out.println(x + " - Jämt");
                    } else {
                        System.out.println(x + " - Ojämt");
                    }
                });

        // Skapa en klass Month, som innehåller dels ett fält för månadens namn,
        // dels en List<Double> på ett antal uppmätta temperaturer under den månaden.
        // I din main-klass, skapa i sin tur en lista med årets tolv sådana månader.
        // Från den listan, skapa en ström som returnerar en Map
        // med månadsnamnet som key och snitt temperaturer som value

        List<Month> aYear = List.of(
                new Month("Januari", List.of(2.3, 8.2, 3.6)),
                new Month("Februari", List.of(4.3, 7.2, 5.6)),
                new Month("Mars", List.of(8.3, 13.2, 7.5)),
                new Month("April", List.of(14.3, 16.2, 11.4)),
                new Month("Maj", List.of(19.3, 18.2, 19.6)),
                new Month("Juni", List.of(23.0, 26.2, 23.6)),
                new Month("Juli", List.of(22.3, 28.2, 30.6)),
                new Month("Augusti", List.of(27.3, 28.2, 23.6)),
                new Month("September", List.of(15.3, 18.2, 13.6)),
                new Month("Oktober", List.of(12.3, 8.7, 11.3)),
                new Month("November", List.of(5.2, 8.2, 4.6)),
                new Month("December", List.of(0.1, 1.5, 0.6))
        );








    }

}
