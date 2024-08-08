class Solution {

    static int total;
    static int rMax, cMax;
    static int x, y;
    static int cnt;
    static int[][] history;

    static boolean isValid() {
        return x >= 0 && y >= 0 && x < rMax && y < cMax;
    }

    static boolean record() {
        history[cnt] = new int[] { x, y };
        cnt++;
        return cnt == total;
    }

    static boolean autoRecord() {
        if (isValid()) {
            return record();
        }
        return false;
    }

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        cnt = 0;
        total = rows * cols;
        rMax = rows;
        cMax = cols;
        history = new int[total][];
        x = rStart;
        y = cStart;
        autoRecord();

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // Right, Down, Left, Up
        int dirIndex = 0;
        int steps = 1;

        while (cnt < total) {
            for (int i = 0; i < 2; i++) { // There are two sides of each length to cover
                for (int j = 0; j < steps; j++) {
                    x += directions[dirIndex][0];
                    y += directions[dirIndex][1];
                    if (autoRecord()) {
                        return history;
                    }
                }
                dirIndex = (dirIndex + 1) % 4; // Change direction
            }
            steps++; // Increase step size after completing a full turn (two sides)
        }

        return history;
    }
}
