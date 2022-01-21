package se.superdevs;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        stringReturnString upperCase = new stringReturnString() {
            @Override
        public String check(String string) {
        return string.toUpperCase();
    }
    };
        System.out.println(
                upperCase.check("Jonas")
        );

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
        Function<List<Integer>,Double> point = points
                .stream()
                .sorted(Comparator.naturalOrder())
                .skip(2)
                .limit(3)
                .mapToDouble()
    }

}
