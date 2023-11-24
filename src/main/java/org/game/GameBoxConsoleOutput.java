package org.game;

@SuppressWarnings("java:S106")

public class GameBoxConsoleOutput {
    private static final String BOX_ROW_FORMAT = " %s | %s | %s ";
    private static final String DELIMITER = "\n-----------";
    public void printInitialBox() {
        System.out.printf("\n\n" + BOX_ROW_FORMAT, '1', '2', '3');
        System.out.println(DELIMITER);
        System.out.printf(BOX_ROW_FORMAT, '4', '5', '6');
        System.out.println(DELIMITER);
        System.out.printf(BOX_ROW_FORMAT + "\n", '7', '8', '9');
    }

    public void printBox(char[] box) {
        System.out.printf("\n\n" + BOX_ROW_FORMAT, box[0], box[1], box[2]);
        System.out.println(DELIMITER);
        System.out.printf(BOX_ROW_FORMAT, box[3], box[4], box[5]);
        System.out.println(DELIMITER);
        System.out.printf(BOX_ROW_FORMAT + "\n", box[6], box[7], box[8]);
    }
}
