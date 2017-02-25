package code.Arrays;

public class MatrixSpiralPrinter {
    private int[][] matrix;
    private boolean[][] printed;
    private boolean terminate = false;
    private StringBuilder result = new StringBuilder();

    public MatrixSpiralPrinter(int[][] matrix) {
        this.matrix = matrix;
        this.printed = new boolean[matrix.length][matrix[0].length];
    }

    public String print() {
        int orientation = 0;
        int row = 0;
        int col = 0;

        while (!this.terminate) {
            Coordinate newCoord;
            switch (orientation) {
                case 0:
                    // Right
                    newCoord = this.printRight(row, col);
                    orientation++;
                    break;
                case 1:
                    // Down
                    newCoord = this.printDown(row, col);
                    orientation++;
                    break;
                case 2:
                    // Left
                    newCoord = this.printleft(row, col);
                    orientation++;
                    break;
                case 3:
                    // Up
                    newCoord = this.printUp(row, col);
                    orientation = 0;
                    break;
                default:
                    return "";
            }

            row = newCoord.row;
            col = newCoord.col;
        }

        return result.toString();
    }

    private Coordinate printRight(int row, int col) {
        int c;
        for (c = col; c < this.matrix[row].length; c++) {
            if (!this.printed[row][c]) {
                this.result.append(this.matrix[row][c]);
                this.printed[row][c] = true;
            } else {
                break;
            }
        }

        if (this.printed[row + 1][c - 1]) {this.terminate = true;}
        return new Coordinate(row + 1, c - 1);
    }

    private Coordinate printleft(int row, int col) {
        int c;
        for (c = col; c >= 0; c--) {
            if (!this.printed[row][c]) {
                this.result.append(this.matrix[row][c]);
                this.printed[row][c] = true;
            } else {
                break;
            }
        }

        if (this.printed[row - 1][c + 1]) {this.terminate = true;}
        return new Coordinate(row - 1, c + 1);
    }

    private Coordinate printDown(int row, int col) {
        int r;
        for (r = row; r < this.matrix.length; r++) {
            if (!this.printed[r][col]) {
                this.result.append(this.matrix[r][col]);
                this.printed[r][col] = true;
            } else {
                break;
            }
        }

        if (this.printed[r - 1][col - 1]) {this.terminate = true;}
        return new Coordinate(r - 1, col - 1);
    }

    private Coordinate printUp(int row, int col) {
        int r;
        for (r = row; r >= 0; r--) {
            if (!this.printed[r][col]) {
                this.result.append(this.matrix[r][col]);
                this.printed[r][col] = true;
            } else {
                break;
            }
        }

        if (this.printed[r + 1][col + 1]) {this.terminate = true;}
        return new Coordinate(r + 1, col + 1);
    }

    private class Coordinate {
        public int row;
        public int col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
