package lesson7;

import kotlin.NotImplementedError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class JavaDynamicTasks {
    /**
     * Наибольшая общая подпоследовательность.
     * Средняя
     *
     * Дано две строки, например "nematode knowledge" и "empty bottle".
     * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
     * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
     * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
     * Если общей подпоследовательности нет, вернуть пустую строку.
     * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
     * При сравнении подстрок, регистр символов *имеет* значение.
     */

    //Трудоемкость(T): О(n * m)
    //Ресурсоемкость(R): О(n * m)
    public static String longestCommonSubSequence(String first, String second) {

        int firstLen = first.length();
        int secondLen = second.length();
        int[][] lensList = new int[firstLen + 1][secondLen + 1];

        for(int i = 1; i < firstLen + 1; i++) {
            for (int j = 1; j < secondLen + 1; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)){
                    lensList[i][j] = lensList[i - 1][j - 1] + 1;

                } else lensList[i][j] = Math.max(lensList[i - 1][j], lensList[i][j - 1]);
            }
        }
        StringBuilder string = new StringBuilder();
        while (firstLen > 0 && secondLen > 0) {

            if (first.charAt(firstLen - 1) == second.charAt(secondLen - 1)){
                string.append(first.charAt(firstLen - 1));
                firstLen--;
                secondLen--;

            } else if (lensList[firstLen - 1][secondLen] > lensList[firstLen][secondLen - 1]) {
                firstLen--;

            } else secondLen--;
        }
        return string.reverse().toString();
    }

    /**
     * Наибольшая возрастающая подпоследовательность
     * Сложная
     *
     * Дан список целых чисел, например, [2 8 5 9 12 6].
     * Найти в нём самую длинную возрастающую подпоследовательность.
     * Элементы подпоследовательности не обязаны идти подряд,
     * но должны быть расположены в исходном списке в том же порядке.
     * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
     * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
     * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
     */

    //Трудоемкость = O(N^2)
    //Ресурсоемкость = O(N)

    public static List<Integer> longestIncreasingSubSequence(List<Integer> list) {
        if (list.size() <= 1) return list;

        ArrayList<Integer> res =  new ArrayList<>();
        int size = list.size();
        int[] pred = new int[size];
        int[] len = new int[size];
        int lastElementIndex = 0;
        int length = len[0];

        for (int i = 0; i < size; i++){
            len[i] = 1;
            pred[i] = -1;

            for (int j = 0; j < size; j++){
                if (list.get(j) < list.get(i) && len[j] + 1 > len[i]){
                    len[i] = len[j] + 1;
                    pred[i] = j;
                }
            }
        }

        for (int i = 0; i < size; i++){
            if (len[i] > length) {
                lastElementIndex = i;
                length = len[i];
            }
        }

        while (lastElementIndex != -1) {
            res.add(0, list.get(lastElementIndex));
            lastElementIndex = pred[lastElementIndex];
        }

        return res;
    }

    /**
     * Самый короткий маршрут на прямоугольном поле.
     * Средняя
     *
     * В файле с именем inputName задано прямоугольное поле:
     *
     * 0 2 3 2 4 1
     * 1 5 3 4 6 2
     * 2 6 2 5 1 3
     * 1 4 3 2 6 2
     * 4 2 3 1 5 0
     *
     * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
     * В каждой клетке записано некоторое натуральное число или нуль.
     * Необходимо попасть из верхней левой клетки в правую нижнюю.
     * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
     * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
     *
     * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
     */
    public static int shortestPathOnField(String inputName) {
        throw new NotImplementedError();
    }

    // Задачу "Максимальное независимое множество вершин в графе без циклов"
    // смотрите в уроке 5
}
