package game;

import java.util.Random;

public class GameMath {
    public int[] ArrayNumber = new int[16]; //Случайные числа для пятнашек

    //Получить случайную последовательность от 1 до 15 неповторяющихся элементов, путем перестановки
    private void RandomElements() {
        Random random = new Random();

        for (int i = 0; i < 16; i++) {
            ArrayNumber[i] = (i + 1);
        }

        int value;
        int index1;
        int index2;
        for (int i = 0; i < 16; i++) {
            index1 = random.nextInt(15);
            index2 = random.nextInt(15);
            value = ArrayNumber[index1];
            ArrayNumber[index1] = ArrayNumber[index2];
            ArrayNumber[index2] = value;
        }
    }

    /*
    Пусть плитка с числом i расположена до (если считать слева на право и сверзу вниз) k плиток с числами, меньшими i;
    тогда обозначим ni == k. В частности, если после плитки с числом i нет плиток с числами, меньшими i, то ni == 0.
    Также введм l  - номер ряда пустой клетки (считая с 1, у нас похоже всегда 4).
                        N = (Сумма от1-до15) (ni) + l
    Сумма числа пар костяшек, в которых костяшка с большим номером идёт перед костяшкой с меньшим номером,
    и номера ряда с пустой клетки нечётна, то решений головоломки не существует

     */

    //Проверить, есть ли у последовательности решение
    private boolean ThisSolution(int[] array) {
        int n = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = i + 1; j < 16; j++) {
                if (array[i] > array[j]) n++;
            }
        }
        if ((n + 4) % 2 == 0) return true;
        else return false;
    }

    //Получить случайную последовательность от 1 до 15 неповторяющихся элементов, путем перестановки, имеющую решение
    public void GetRandomElements() {
        //получаем последовательность элементов имеющую решение
        boolean stop = true;
        while (stop) {
            RandomElements();
            if (ThisSolution(ArrayNumber)) stop = false;
        }
    }

}
