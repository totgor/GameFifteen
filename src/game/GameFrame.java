package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

////Окно для игры
public class GameFrame extends JFrame implements ActionListener {

    Element[] ArrayElements = new Element[16]; //элементы
    GameMath gameMath = new GameMath(); //математика игры, для получения последовательности элементов имеющее решение


    //Конструктор класса
    GameFrame() {
        this.setTitle("Пятнашки"); //имя заголовка
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Операция закрытия окна при нажатии крестика
        this.setLayout(null); //установить макет на нет (что это значит?)
        this.setSize(616, 639); //размер окна
        this.setVisible(true); //досутпность окна
        this.setLocationRelativeTo(null); //по центру экрна

        //Получить случайную последовательность от 1 до 15 неповторяющихся элементов, путем перестановки, имеющую решение
        gameMath.GetRandomElements();

        //проходим по всем позициям и рассталвяем их номера
        int i = 0;
        for (Element.Position position : Element.Position.values()) {
            ArrayElements[i] = new Element(position);
            ArrayElements[i].SetNumber(gameMath.ArrayNumber[i]);
            //Добавляем и прослушиваем
            this.add(ArrayElements[i]); //добавление элемента в окно
            ArrayElements[i].addActionListener(this); //прослушиватель действий на каждый элемент(кнопку)
            if (ArrayElements[i].GetNumber() == 16) ArrayElements[i].setVisible(false); //скрываем 16ый элемент
            i++;
        }

    }


    //Отслеживание события (нажатие на кнопку-элемент)
    @Override
    public void actionPerformed(ActionEvent e) {
        //ONE
        if (e.getSource() == ArrayElements[0]) {
            //right
            if (ArrayElements[1].GetNumber() == 16) {
                ArrayElements[1].SetNumber(ArrayElements[0].GetNumber());
                ArrayElements[0].SetNumber(16);
                ArrayElements[0].setVisible(false);
                ArrayElements[1].setVisible(true);
            }
            //down
            if (ArrayElements[4].GetNumber() == 16) {
                ArrayElements[4].SetNumber(ArrayElements[0].GetNumber());
                ArrayElements[0].SetNumber(16);
                ArrayElements[0].setVisible(false);
                ArrayElements[4].setVisible(true);
            }
        }
        //TWO
        if (e.getSource() == ArrayElements[1]) {
            //left
            if (ArrayElements[0].GetNumber() == 16) {
                ArrayElements[0].SetNumber(ArrayElements[1].GetNumber());
                ArrayElements[1].SetNumber(16);
                ArrayElements[1].setVisible(false);
                ArrayElements[0].setVisible(true);
            }
            //down
            if (ArrayElements[5].GetNumber() == 16) {
                ArrayElements[5].SetNumber(ArrayElements[1].GetNumber());
                ArrayElements[1].SetNumber(16);
                ArrayElements[1].setVisible(false);
                ArrayElements[5].setVisible(true);
            }
            //right
            if (ArrayElements[2].GetNumber() == 16) {
                ArrayElements[2].SetNumber(ArrayElements[1].GetNumber());
                ArrayElements[1].SetNumber(16);
                ArrayElements[1].setVisible(false);
                ArrayElements[2].setVisible(true);
            }
        }
        //THREE
        if (e.getSource() == ArrayElements[2]) {
            //left
            if (ArrayElements[1].GetNumber() == 16) {
                ArrayElements[1].SetNumber(ArrayElements[2].GetNumber());
                ArrayElements[2].SetNumber(16);
                ArrayElements[2].setVisible(false);
                ArrayElements[1].setVisible(true);
            }
            //down
            if (ArrayElements[6].GetNumber() == 16) {
                ArrayElements[6].SetNumber(ArrayElements[2].GetNumber());
                ArrayElements[2].SetNumber(16);
                ArrayElements[2].setVisible(false);
                ArrayElements[6].setVisible(true);
            }
            //right
            if (ArrayElements[3].GetNumber() == 16) {
                ArrayElements[3].SetNumber(ArrayElements[2].GetNumber());
                ArrayElements[2].SetNumber(16);
                ArrayElements[2].setVisible(false);
                ArrayElements[3].setVisible(true);
            }
        }
        //FOUR
        if (e.getSource() == ArrayElements[3]) {
            //left
            if (ArrayElements[2].GetNumber() == 16) {
                ArrayElements[2].SetNumber(ArrayElements[3].GetNumber());
                ArrayElements[3].SetNumber(16);
                ArrayElements[3].setVisible(false);
                ArrayElements[2].setVisible(true);
            }
            //down
            if (ArrayElements[7].GetNumber() == 16) {
                ArrayElements[7].SetNumber(ArrayElements[3].GetNumber());
                ArrayElements[3].SetNumber(16);
                ArrayElements[3].setVisible(false);
                ArrayElements[7].setVisible(true);
            }
        }
        //FIVE
        if (e.getSource() == ArrayElements[4]) {
            //up
            if (ArrayElements[0].GetNumber() == 16) {
                ArrayElements[0].SetNumber(ArrayElements[4].GetNumber());
                ArrayElements[4].SetNumber(16);
                ArrayElements[4].setVisible(false);
                ArrayElements[0].setVisible(true);
            }
            //right
            if (ArrayElements[5].GetNumber() == 16) {
                ArrayElements[5].SetNumber(ArrayElements[4].GetNumber());
                ArrayElements[4].SetNumber(16);
                ArrayElements[4].setVisible(false);
                ArrayElements[5].setVisible(true);
            }
            //down
            if (ArrayElements[8].GetNumber() == 16) {
                ArrayElements[8].SetNumber(ArrayElements[4].GetNumber());
                ArrayElements[4].SetNumber(16);
                ArrayElements[4].setVisible(false);
                ArrayElements[8].setVisible(true);
            }
        }
        //SIX
        if (e.getSource() == ArrayElements[5]) {
            //up
            if (ArrayElements[1].GetNumber() == 16) {
                ArrayElements[1].SetNumber(ArrayElements[5].GetNumber());
                ArrayElements[5].SetNumber(16);
                ArrayElements[5].setVisible(false);
                ArrayElements[1].setVisible(true);
            }
            //right
            if (ArrayElements[6].GetNumber() == 16) {
                ArrayElements[6].SetNumber(ArrayElements[5].GetNumber());
                ArrayElements[5].SetNumber(16);
                ArrayElements[5].setVisible(false);
                ArrayElements[6].setVisible(true);
            }
            //down
            if (ArrayElements[9].GetNumber() == 16) {
                ArrayElements[9].SetNumber(ArrayElements[5].GetNumber());
                ArrayElements[5].SetNumber(16);
                ArrayElements[5].setVisible(false);
                ArrayElements[9].setVisible(true);
            }
            //left
            if (ArrayElements[4].GetNumber() == 16) {
                ArrayElements[4].SetNumber(ArrayElements[5].GetNumber());
                ArrayElements[5].SetNumber(16);
                ArrayElements[5].setVisible(false);
                ArrayElements[4].setVisible(true);
            }
        }
        //SEVEN
        if (e.getSource() == ArrayElements[6]) {
            //up
            if (ArrayElements[2].GetNumber() == 16) {
                ArrayElements[2].SetNumber(ArrayElements[6].GetNumber());
                ArrayElements[6].SetNumber(16);
                ArrayElements[6].setVisible(false);
                ArrayElements[2].setVisible(true);
            }
            //right
            if (ArrayElements[7].GetNumber() == 16) {
                ArrayElements[7].SetNumber(ArrayElements[6].GetNumber());
                ArrayElements[6].SetNumber(16);
                ArrayElements[6].setVisible(false);
                ArrayElements[7].setVisible(true);
            }
            //down
            if (ArrayElements[10].GetNumber() == 16) {
                ArrayElements[10].SetNumber(ArrayElements[6].GetNumber());
                ArrayElements[6].SetNumber(16);
                ArrayElements[6].setVisible(false);
                ArrayElements[10].setVisible(true);
            }
            //left
            if (ArrayElements[5].GetNumber() == 16) {
                ArrayElements[5].SetNumber(ArrayElements[6].GetNumber());
                ArrayElements[6].SetNumber(16);
                ArrayElements[6].setVisible(false);
                ArrayElements[5].setVisible(true);
            }
        }
        //EIGHT
        if (e.getSource() == ArrayElements[7]) {
            //up
            if (ArrayElements[3].GetNumber() == 16) {
                ArrayElements[3].SetNumber(ArrayElements[7].GetNumber());
                ArrayElements[7].SetNumber(16);
                ArrayElements[7].setVisible(false);
                ArrayElements[3].setVisible(true);
            }
            //down
            if (ArrayElements[11].GetNumber() == 16) {
                ArrayElements[11].SetNumber(ArrayElements[7].GetNumber());
                ArrayElements[7].SetNumber(16);
                ArrayElements[7].setVisible(false);
                ArrayElements[11].setVisible(true);
            }
            //left
            if (ArrayElements[6].GetNumber() == 16) {
                ArrayElements[6].SetNumber(ArrayElements[7].GetNumber());
                ArrayElements[7].SetNumber(16);
                ArrayElements[7].setVisible(false);
                ArrayElements[6].setVisible(true);
            }
        }
        //NINE
        if (e.getSource() == ArrayElements[8]) {
            //up
            if (ArrayElements[4].GetNumber() == 16) {
                ArrayElements[4].SetNumber(ArrayElements[8].GetNumber());
                ArrayElements[8].SetNumber(16);
                ArrayElements[8].setVisible(false);
                ArrayElements[4].setVisible(true);
            }
            //right
            if (ArrayElements[9].GetNumber() == 16) {
                ArrayElements[9].SetNumber(ArrayElements[8].GetNumber());
                ArrayElements[8].SetNumber(16);
                ArrayElements[8].setVisible(false);
                ArrayElements[9].setVisible(true);
            }
            //down
            if (ArrayElements[12].GetNumber() == 16) {
                ArrayElements[12].SetNumber(ArrayElements[8].GetNumber());
                ArrayElements[8].SetNumber(16);
                ArrayElements[8].setVisible(false);
                ArrayElements[12].setVisible(true);
            }
        }
        //TEN
        if (e.getSource() == ArrayElements[9]) {
            //up
            if (ArrayElements[5].GetNumber() == 16) {
                ArrayElements[5].SetNumber(ArrayElements[9].GetNumber());
                ArrayElements[9].SetNumber(16);
                ArrayElements[9].setVisible(false);
                ArrayElements[5].setVisible(true);
            }
            //right
            if (ArrayElements[10].GetNumber() == 16) {
                ArrayElements[10].SetNumber(ArrayElements[9].GetNumber());
                ArrayElements[9].SetNumber(16);
                ArrayElements[9].setVisible(false);
                ArrayElements[10].setVisible(true);
            }
            //down
            if (ArrayElements[13].GetNumber() == 16) {
                ArrayElements[13].SetNumber(ArrayElements[9].GetNumber());
                ArrayElements[9].SetNumber(16);
                ArrayElements[9].setVisible(false);
                ArrayElements[13].setVisible(true);
            }
            //left
            if (ArrayElements[8].GetNumber() == 16) {
                ArrayElements[8].SetNumber(ArrayElements[9].GetNumber());
                ArrayElements[9].SetNumber(16);
                ArrayElements[9].setVisible(false);
                ArrayElements[8].setVisible(true);
            }
        }
        //ELEVEN
        if (e.getSource() == ArrayElements[10]) {
            //up
            if (ArrayElements[6].GetNumber() == 16) {
                ArrayElements[6].SetNumber(ArrayElements[10].GetNumber());
                ArrayElements[10].SetNumber(16);
                ArrayElements[10].setVisible(false);
                ArrayElements[6].setVisible(true);
            }
            //right
            if (ArrayElements[11].GetNumber() == 16) {
                ArrayElements[11].SetNumber(ArrayElements[10].GetNumber());
                ArrayElements[10].SetNumber(16);
                ArrayElements[10].setVisible(false);
                ArrayElements[11].setVisible(true);
            }
            //down
            if (ArrayElements[14].GetNumber() == 16) {
                ArrayElements[14].SetNumber(ArrayElements[10].GetNumber());
                ArrayElements[10].SetNumber(16);
                ArrayElements[10].setVisible(false);
                ArrayElements[14].setVisible(true);
            }
            //left
            if (ArrayElements[9].GetNumber() == 16) {
                ArrayElements[9].SetNumber(ArrayElements[10].GetNumber());
                ArrayElements[10].SetNumber(16);
                ArrayElements[10].setVisible(false);
                ArrayElements[9].setVisible(true);
            }
        }
        //TWELVE
        if (e.getSource() == ArrayElements[11]) {
            //up
            if (ArrayElements[7].GetNumber() == 16) {
                ArrayElements[7].SetNumber(ArrayElements[11].GetNumber());
                ArrayElements[11].SetNumber(16);
                ArrayElements[11].setVisible(false);
                ArrayElements[7].setVisible(true);
            }
            //down
            if (ArrayElements[15].GetNumber() == 16) {
                ArrayElements[15].SetNumber(ArrayElements[11].GetNumber());
                ArrayElements[11].SetNumber(16);
                ArrayElements[11].setVisible(false);
                ArrayElements[15].setVisible(true);
            }
            //left
            if (ArrayElements[10].GetNumber() == 16) {
                ArrayElements[10].SetNumber(ArrayElements[11].GetNumber());
                ArrayElements[11].SetNumber(16);
                ArrayElements[11].setVisible(false);
                ArrayElements[10].setVisible(true);
            }
        }
        //THIRTEEN
        if (e.getSource() == ArrayElements[12]) {
            //up
            if (ArrayElements[8].GetNumber() == 16) {
                ArrayElements[8].SetNumber(ArrayElements[12].GetNumber());
                ArrayElements[12].SetNumber(16);
                ArrayElements[12].setVisible(false);
                ArrayElements[8].setVisible(true);
            }
            //right
            if (ArrayElements[13].GetNumber() == 16) {
                ArrayElements[13].SetNumber(ArrayElements[12].GetNumber());
                ArrayElements[12].SetNumber(16);
                ArrayElements[12].setVisible(false);
                ArrayElements[13].setVisible(true);
            }
        }
        //FOURTEEN
        if (e.getSource() == ArrayElements[13]) {
            //left
            if (ArrayElements[12].GetNumber() == 16) {
                ArrayElements[12].SetNumber(ArrayElements[13].GetNumber());
                ArrayElements[13].SetNumber(16);
                ArrayElements[13].setVisible(false);
                ArrayElements[12].setVisible(true);
            }
            //up
            if (ArrayElements[9].GetNumber() == 16) {
                ArrayElements[9].SetNumber(ArrayElements[13].GetNumber());
                ArrayElements[13].SetNumber(16);
                ArrayElements[13].setVisible(false);
                ArrayElements[9].setVisible(true);
            }
            //right
            if (ArrayElements[14].GetNumber() == 16) {
                ArrayElements[14].SetNumber(ArrayElements[13].GetNumber());
                ArrayElements[13].SetNumber(16);
                ArrayElements[13].setVisible(false);
                ArrayElements[14].setVisible(true);
            }
        }
        //FIVTEEN
        if (e.getSource() == ArrayElements[14]) {
            //left
            if (ArrayElements[13].GetNumber() == 16) {
                ArrayElements[13].SetNumber(ArrayElements[14].GetNumber());
                ArrayElements[14].SetNumber(16);
                ArrayElements[14].setVisible(false);
                ArrayElements[13].setVisible(true);
            }
            //up
            if (ArrayElements[10].GetNumber() == 16) {
                ArrayElements[10].SetNumber(ArrayElements[14].GetNumber());
                ArrayElements[14].SetNumber(16);
                ArrayElements[14].setVisible(false);
                ArrayElements[10].setVisible(true);
            }
            //right
            if (ArrayElements[15].GetNumber() == 16) {
                ArrayElements[15].SetNumber(ArrayElements[14].GetNumber());
                ArrayElements[14].SetNumber(16);
                ArrayElements[14].setVisible(false);
                ArrayElements[15].setVisible(true);
            }
        }
        //SIXTEEN
        if (e.getSource() == ArrayElements[15]) {
            //left
            if (ArrayElements[14].GetNumber() == 16) {
                ArrayElements[14].SetNumber(ArrayElements[15].GetNumber());
                ArrayElements[15].SetNumber(16);
                ArrayElements[15].setVisible(false);
                ArrayElements[14].setVisible(true);
            }
            //right
            if (ArrayElements[11].GetNumber() == 16) {
                ArrayElements[11].SetNumber(ArrayElements[15].GetNumber());
                ArrayElements[15].SetNumber(16);
                ArrayElements[15].setVisible(false);
                ArrayElements[11].setVisible(true);
            }
        }
    }
}
