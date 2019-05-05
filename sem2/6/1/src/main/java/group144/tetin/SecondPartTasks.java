package group144.tetin;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Random;

public final class SecondPartTasks {

    private SecondPartTasks() {}

    // Найти строки из переданных файлов, в которых встречается указанная подстрока.
    public static List<String> findQuotes(List<String> paths, CharSequence sequence) {
        return paths.stream()
                .filter(x -> x.contains(sequence))
                .collect(Collectors.toList());
    }

    // В квадрат с длиной стороны 1 вписана мишень.
    // Стрелок атакует мишень и каждый раз попадает в произвольную точку квадрата.
    // Надо промоделировать этот процесс с помощью класса java.util.Random и посчитать, какова вероятность попасть в мишень.
    public static double piDividedBy4() {
        Random random = new Random();
        final int NUMBER_OF_SHOOTING = 10000;
        final Double RADIUS = 0.5;
        final Double CENTER_X = 0.5;
        final Double CENTER_Y = 0.5;
        class Point {
            double x = random.nextDouble() - CENTER_X;
            double y = random.nextDouble() - CENTER_Y;
        }

        return (double) (Stream.generate(() -> new Point()).limit(NUMBER_OF_SHOOTING)
                .filter(point -> (point.x * point.x) + (point.y * point.y) <= (RADIUS * RADIUS))
                .count()) / NUMBER_OF_SHOOTING;
    }

    // Дано отображение из имени автора в список с содержанием его произведений.RADIUS
    // Надо вычислить, чья общая длина произведений наибольшая.
    public static String findPrinter(Map<String, List<String>> compositions) {
        return compositions.entrySet().stream().max(
                Comparator.comparing(
                        value -> value.getValue().stream().mapToInt(String::length).sum()))
                .get().getKey();
    }

    // Вы крупный поставщик продуктов. Каждая торговая сеть делает вам заказ в виде Map<Товар, Количество>.
    // Необходимо вычислить, какой товар и в каком количестве надо поставить.
    public static Map<String, Integer> calculateGlobalOrder(List<Map<String, Integer>> orders) {
        return orders.stream()
                .flatMap(x -> x.entrySet().stream())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, Integer::sum)
                );
    }
}