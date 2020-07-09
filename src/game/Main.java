package game;

import game.controlers.ControllerGame;
import game.models.Field;
import game.models.Player;
import game.veiw.Veiw;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(3);
        Player player1 = new Player("Max", "0");
        Player player2 = new Player("Lev", "1");
        ControllerGame controllerGame = new ControllerGame(field, player1, player2);
        Veiw veiw = new Veiw(field);
        veiw.showField();
        int x, y;
        while (!controllerGame.endGame()){
            x = controllerGame.inputCoordinat("x");
            y = controllerGame.inputCoordinat("y");
            controllerGame.movePlayer(x, y, player1);
            veiw.showField();
            if (controllerGame.getWinnerPlayer(player1) || controllerGame.endGame()){
                break;
            }
            x = controllerGame.inputCoordinat("x");
            y = controllerGame.inputCoordinat("y");
            controllerGame.movePlayer(x, y, player2);
            veiw.showField();
            if (controllerGame.getWinnerPlayer(player2) || controllerGame.endGame()){
                break;
            }

        }
        System.out.printf("Winner the %s: \n", controllerGame.getNameWinnerPlayer());

    }
}
