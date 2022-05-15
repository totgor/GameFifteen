package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

////Окно для игры
public class GameFrame extends JFrame implements ActionListener {

    Element[] ArrayElements = new Element[16]; //
    int[] ArrayNumber = new int[16]; //Случайные числа для пятнашек

    //Получить случайную последовательность от 1 до 15 неповторяющихся элементов, путем перестановки
    void RandomElements() {
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
    boolean ThisSolution(int[] array) {
        int n = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = i + 1; j < 16; j++) {
                if (array[i] > array[j]) n++;
            }
        }
        if ((n + 4) % 2 == 0) return true;
        else return false;
    }


    //Конструктор класса
    GameFrame() {
        this.setTitle("Пятнашки"); //имя заголовка
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Операция закрытия окна при нажатии крестика
        this.setLayout(null); //установить макет на нет (что это значит?)
        this.setSize(615, 638); //размер окна
        this.setVisible(true); //досутпность окна
        this.setLocationRelativeTo(null); //по центру экрна

        //получаем последовательность элементов имеющую решение
        boolean stop = true;
        while (stop) {
            RandomElements();
            if (ThisSolution(ArrayNumber)) stop = false;
        }

        int i = 0;
        for (Element.Position position : Element.Position.values()) {
            ArrayElements[i] = new Element(position);
            ArrayElements[i].number = ArrayNumber[i];
            ArrayElements[i].setText(String.valueOf(ArrayNumber[i]));
            this.add(ArrayElements[i]);
            ArrayElements[i].addActionListener(this); //прослушиватель действий на каждый элемент(кнопку)
            if(ArrayElements[i].number == 16) ArrayElements[i].setVisible(false);
            i++;
        }

    }


    //Отслеживание события
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ArrayElements[0]) {
            System.out.println("Boo!");
        }
    }
}
