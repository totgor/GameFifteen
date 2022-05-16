package game;

import javax.swing.*;
import java.awt.*;

public class Element extends JButton {
    enum Position {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN};

    private int number; //номер элемента
    private int positionX; //ряд
    private int positionY; //столбец

    Element(Position position) {
        CalcPosition(position);
        //Рисуем элемент
        this.setBounds(positionX, positionY, 150, 150);
        this.setFont(new Font("Comic Sans", Font.BOLD, 35)); //шрифт, жирный, размер
        this.setBackground(Color.lightGray); //цвет элемента
        this.setBorder(BorderFactory.createEtchedBorder()); //вид границ
    }

    public int GetNumber () {
        return number;
    }

    public void SetNumber (int number) {
        this.number = number;
        this.setText(String.valueOf(number)); //написать число на элементе
    }


    void CalcPosition(Position position) {
        switch (position) {
            case ONE:
                positionX = 0;
                positionY = 0;
                break;
            case TWO:
                positionX = 150;
                positionY = 0;
                break;
            case THREE:
                positionX = 300;
                positionY = 0;
                break;
            case FOUR:
                positionX = 450;
                positionY = 0;
                break;
            case FIVE:
                positionX = 0;
                positionY = 150;
                break;
            case SIX:
                positionX = 150;
                positionY = 150;
                break;
            case SEVEN:
                positionX = 300;
                positionY = 150;
                break;
            case EIGHT:
                positionX = 450;
                positionY = 150;
                break;
            case NINE:
                positionX = 0;
                positionY = 300;
                break;
            case TEN:
                positionX = 150;
                positionY = 300;
                break;
            case ELEVEN:
                positionX = 300;
                positionY = 300;
                break;
            case TWELVE:
                positionX = 450;
                positionY = 300;
                break;
            case THIRTEEN:
                positionX = 0;
                positionY = 450;
                break;
            case FOURTEEN:
                positionX = 150;
                positionY = 450;
                break;
            case FIFTEEN:
                positionX = 300;
                positionY = 450;
                break;
            case SIXTEEN:
                positionX = 450;
                positionY = 450;
                break;
        }
    }


}
