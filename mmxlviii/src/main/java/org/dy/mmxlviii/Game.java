package org.dy.mmxlviii;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private int[][] table;
    private int moveNr = 0, points = 0;
    private final int SIZE;
    private Random rand = new Random();
    private ArrayList<Move> moves;

    public class Move {
        int[][] table;
        int pointsWon;
        int direction;
        int newRow;
        int newCol;
        int newVal;
    }

    public Game(Integer size) {
        SIZE = size;
        table = new int[size][size];
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                table[i][j] = 0;
            }
        }
        moves = new ArrayList<Move>();
        addRandomNumber();
        addRandomNumber();
    }

    public Game() {
        this(4);
    }

    public int[][] getTable() {
        return table;
    }

    private Boolean isFinished() {
        for(int r = 0; r <  SIZE; r++) {
            for(int c = 0; c < SIZE; c++) {
                if(table[r][c] == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

    private Move addRandomNumber() {
        Integer num, val24;
        Integer x, y;
        num = rand.nextInt(100);
        if(isFinished()) {
            return null;
        }

        if(num < 75) {
            val24 = 2;
        } else {
            val24 = 4;
        }
        System.out.println("Num: " + num);
        do {    
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
            System.out.println("Val: " + val24 + ", x: " + x + ", y:" + y);
        } while(table[x][y] != 0);
    
        table[x][y] = val24;

        Move m = new Move();
        m.newCol = x;
        m.newRow = y;
        m.newVal = val24;
        m.table = CopyTable(table);
        moves.add(m);
        return m;
    }

    public static int[][] CopyTable(int[][] table) {
        if (table == null)
            return null;
        int[][] result = new int[table.length][];
        for (int r = 0; r < table.length; r++) {
            result[r] = table[r].clone();
        }
        return result;
    }

    public Boolean moveLeft() {
        Boolean moved = false;
        for(int r = 0; r < SIZE; r++) {
            Boolean merged = false;
            for(int c = 0; c < SIZE; c++) {
                int cb;
                if(table[r][c] == 0) {
                    continue;
                }
                for(cb = c; cb > 0; cb--) {
                    if(table[r][cb-1] > 0) {
                        break;
                    }
                    table[r][cb-1] = table[r][cb];
                    table[r][cb] = 0;
                    moved = true;
                }
                if(!merged) {
                    if(cb > 0 && table[r][cb-1] > 0 && table[r][cb] == table[r][cb-1]) {
                        table[r][cb-1] *= 2;
                        table[r][cb] = 0;
                        points += table[r][cb-1];
                        merged = true;
                        moved = true;
                    }
                } else {
                    merged = false;
                }
            }
        }
        if(moved) {
            Move m = addRandomNumber();
            m.direction = 1;
            m.table = CopyTable(table);
            moveNr++;
        }
        return moved;
    }
    
    public Boolean moveRight() {
        Boolean moved = false;
        for(int r = 0; r < SIZE; r++) {
            Boolean merged = false;
            for(int c = SIZE - 1; c > -1; c--) {
                int cb;
                if(table[r][c] == 0) {
                    continue;
                }
                for(cb = c; cb < SIZE-1; cb++) {
                    if(table[r][cb+1] > 0) {
                        break;
                    }
                    table[r][cb+1] = table[r][cb];
                    table[r][cb] = 0;
                    moved = true;
                }
                if(!merged) {
                    if(cb < SIZE-1 && table[r][cb+1] > 0 && table[r][cb] == table[r][cb+1]) {
                        table[r][cb+1] *= 2;
                        table[r][cb] = 0;
                        points += table[r][cb+1];
                        merged = true;
                        moved = true;
                    }
                } else {
                    merged = false;
                }
            }
        }
        if(moved) {
            Move m = addRandomNumber();
            m.direction = 2;
            m.table = CopyTable(table);
            moveNr++;
        }
        return moved;
    }
    public Boolean moveUp() {
        Boolean moved = false;
        for(int c = 0; c < SIZE; c++) {
            Boolean merged = false;
            for(int r = 0; r < SIZE; r++) {
                int rb;
                if(table[r][c] == 0) {
                    continue;
                }
                for(rb = r; rb > 0; rb--) {
                    if(table[rb-1][c] > 0) {
                        break;
                    }
                    table[rb-1][c] = table[rb][c];
                    table[rb][c] = 0;
                    moved = true;
                }
                if(!merged) {
                    if(rb > 0 && table[rb-1][c] > 0 && table[rb][c] == table[rb-1][c]) {
                        table[rb-1][c] *= 2;
                        table[rb][c] = 0;
                        points += table[rb-1][c];
                        merged = true;
                        moved = true;
                    }                    
                } else {
                    merged = false;
                }
            }
        }
        if(moved) {
            Move m = addRandomNumber();
            m.direction = 3;
            m.table = CopyTable(table);
            moveNr++;
        }
        return moved;
    }

    public Boolean moveDown() {
        Boolean moved = false;
        for(int c = 0; c < SIZE; c++) {
            Boolean merged = false;
            for(int r = SIZE - 1; r > -1; r--) {
                int rb;
                if(table[r][c] == 0) {
                    continue;
                }
                for(rb = r; rb < SIZE - 1; rb++) {
                    if(table[rb+1][c] > 0) {
                        break;
                    }
                    table[rb+1][c] = table[rb][c];
                    table[rb][c] = 0;
                    moved = true;
                }
                if(!merged) {
                    if(rb < SIZE-1 && table[rb+1][c] > 0 && table[rb][c] == table[rb+1][c]) {
                        table[rb+1][c] *= 2;
                        table[rb][c] = 0;
                        points += table[rb+1][c];
                        merged = true;
                        moved = true;
                    }                    
                } else {
                    merged = false;
                }
            }
        }
        if(moved) {
            Move m = addRandomNumber();
            m.direction = 4;
            m.table = CopyTable(table);

            moveNr++;
        }
        return moved;
    }
    
}
