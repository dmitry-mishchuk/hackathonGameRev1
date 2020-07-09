package game.veiw;

import game.models.Field;

public class Veiw {
    private Field field;

    public Veiw(Field field) {
        this.field = field;
        System.out.println("Hello. This is a new Game!!!");
        System.out.println("----------------------------");
    }

    public void showField(){
        for (int i = 0; i < field.getSIZE_FIELD(); i += 1){
            for (int j = 0; j < field.getSIZE_FIELD(); j += 1) {
                if (j != 0){
                    System.out.print("|");
                }
                System.out.printf(" %s ", field.getCellField(i, j));
            }
            if (i != field.getSIZE_FIELD()-1){
                System.out.println("\n-------------");
            }
        }
        System.out.println();
    }
}
