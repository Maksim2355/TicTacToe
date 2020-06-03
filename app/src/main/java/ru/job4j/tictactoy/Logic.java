package ru.job4j.tictactoy;

public class Logic {
    private int turn = 0;
    private String value;
    public final static String X = "X";
    public final static String O = "O";
    private final int SIZE = 3;
    private static Logic logic = new Logic();


    private String[][] matrix = new String[SIZE][SIZE];

    public boolean isFilled (){
        for(int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++) {
                if (matrix[i][j] == null) return false;
            }
        }
        return true;
    }

    public boolean isWin(String XorO) {
        String expect = null;
        for (int index = 0; index < SIZE; index++) {expect += XorO;}
        String result = null;

        for(int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++) {
                if (matrix[i][j] != null) {result += matrix[i][j];}
            }
            if (expect.equals(result)) {
                return true;
            } else result = null;
        }

        for(int j = 0; j < SIZE; j++){
            for (int i = 0; i < SIZE; i++) {
                if (matrix[i][j] != null) {result += matrix[i][j];}
            }
            if (expect.equals(result)) {
                return true;
            } else result = null;
        }

        for(int j = 0, i = 0; j < SIZE; j++, i++) {
            if (matrix[i][j] != null) {result += matrix[i][j];}
        }
        if (expect.equals(result)) {
            return true;
        } else result = null;

        for(int i = SIZE - 1, j = 0; j < SIZE; j++ , i--) {
            if (matrix[i][j] != null) {result += matrix[i][j]; }
        }
        return expect.equals(result);
    }

    public String[][] getMatrix() {

        return matrix;
    }

    public void clearMatrix() {
        matrix = new String[SIZE][SIZE];
        logic.setTurn(0);
    }

    public static Logic getLogic() {
        return logic;
    }

    public String getValue() {
        return value = turn % 2 == 0 ? X : O;
    }

    public int getTurn() {
        return this.turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
