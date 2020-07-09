package game.controlers;

import game.models.Field;
import game.models.Player;
import java.util.Scanner;

public class ControllerGame {
    Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Field field;

    public ControllerGame(Field field, Player player1, Player player2) {
        this.field = field;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int inputCoordinat(String coordinat){
        System.out.printf("Введите координату %s: ", coordinat);
        return scanner.nextInt();
    }

    //установка фигурки игрока на поле, если не удалось, то !!!!!!
    public void movePlayer(int x, int y, Player player){
        field.setCellField(x, y, player.getFIGURE());
    }

    public String curentMove(){
        String[][] temp = field.getStateField();
        int lenTemp = temp.length;
        int count = 0;
        for (int i = 0; i < lenTemp; i += 1) {
            for (int j = 0; j < lenTemp; j += 1) {
                if (temp[i][j] != " "){
                    count++;
                }
            }
        }
        if (count == field.getSIZE_FIELD()*field.getSIZE_FIELD()){
            return null;
        }
        if (count % 2 == 0) {
            return player1.getFIGURE();
        }
        return player2.getFIGURE();
    }
    public boolean endGame(){
        if (curentMove() != null){
            return false;
        }
        return true;
    }

    private boolean getWinnerPlayer(Player player){
        int count;
        //проверка по горизонтали
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            count = 0;
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                if (field.getCellField(i, j) == player.getFIGURE()){
                    count++;
                }
                if (count == field.getSIZE_FIELD()){
                    return true;
                }
            }
        }
        //проверка по вертикали
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            count = 0;
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                if (field.getCellField(j, i) == player.getFIGURE()){
                    count++;
                }
                if (count == field.getSIZE_FIELD()){
                    return true;
                }
            }
        }
        //проверка по диагонали 1
        count = 0;
        for (int i = 0; i < field.getSIZE_FIELD(); i++) {
            for (int j = 0; j < field.getSIZE_FIELD(); j++) {
                if (field.getCellField(i, j) == player.getFIGURE()){
                    count++;
                    break;
                }
            }
        }
        if (count == field.getSIZE_FIELD()){
            return true;
        }
        //проверка по диагонали 2
        count = 0;
        for (int i = field.getSIZE_FIELD(); i >= 0; i--) {
            for (int j = field.getSIZE_FIELD(); j >= 0; j--) {
                if (field.getCellField(i, j) == player.getFIGURE()){
                    count++;
                    break;
                }
            }
        }
        if (count == field.getSIZE_FIELD()){
            return true;
        }
        return false;
    }

    public String getWinnerPlayer(){
        if (getWinnerPlayer(player1)){
            return player1.getNAME();
        }
        else if (getWinnerPlayer(player2)){
            return player2.getNAME();
        }
        return "NON Winner";
    }
}
