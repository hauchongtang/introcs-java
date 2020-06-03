public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        int[][] minearray;
        minearray = new int[m][n];
        int x;
        int y;
        boolean isMinepresent;
        for (int i = 0; i < k; i++) {
            isMinepresent = false;
            while (!isMinepresent) {
                x = (int) Math.round((Math.random() * (m - 1)));
                y = (int) Math.round(Math.random() * (n - 1));
                if (minearray[x][y] != 9) {
                    minearray[x][y] = 9;
                    isMinepresent = true;
                }
            }


        }
        for (int j = 0; j < m; j++) {
            for (int l = 0; l < n; l++) {
                if (minearray[j][l] != 9) {
                    int newX;
                    int newY;
                    //CHECK NORTH
                    newX = j;
                    newY = l - 1;
                    if (newY >= 0) {
                        if (minearray[newX][newY] == 9) {
                            minearray[j][l] = minearray[j][l] + 1;
                        }

                    }
                    //CHECK SOUTH
                    newX = j;
                    newY = l + 1;
                    if (newY < n) {
                        if (minearray[newX][newY] == 9) {
                            minearray[j][l] = minearray[j][l] + 1;
                        }
                    }
                    //CHECK EAST
                    newX = j + 1;
                    newY = l;
                    if (newX < m) {
                        if (minearray[newX][newY] == 9) {
                            minearray[j][l] = minearray[j][l] + 1;
                        }
                    }
                    //CHECK WEST
                    newX = j - 1;
                    newY = l;
                    if (newX >= 0) {
                        if (minearray[newX][newY] == 9) {
                            minearray[j][l] = minearray[j][l] + 1;
                        }
                    }
                    //CHECK NORTH-EAST
                    newX = j + 1;
                    newY = l - 1;
                    if (newX < m && newY >= 0) {
                        if (minearray[newX][newY] == 9) {
                            minearray[j][l] = minearray[j][l] + 1;
                        }
                    }
                    //CHECK NORTH WEST
                    newX = j - 1;
                    newY = l - 1;
                    if (newY >= 0 && newX >= 0) {
                        if (minearray[newX][newY] == 9) {
                            minearray[j][l] = minearray[j][l] + 1;
                        }
                    }
                    //CHECK SOUTH EAST
                    newX = j + 1;
                    newY = l + 1;
                    if (newX < m && newY < n) {
                        if (minearray[newX][newY] == 9) {
                            minearray[j][l] = minearray[j][l] + 1;
                        }
                    }
                    //CHECK SOUTH WEST
                    newX = j - 1;
                    newY = l + 1;
                    if (newX >= 0 && newY < n) {
                        if (minearray[newX][newY] == 9) {
                            minearray[j][l] = minearray[j][l] + 1;
                        }
                    }
                }
            }
        }
        for (int j = 0; j < m; j++)
        {
            for (int l = 0; l < n; l++)
            {
                if(minearray[j][l] == 9)
                {
                    System.out.print("*  ");
                }
                else
                    System.out.print(minearray[j][l] + "  ") ;
            }
            System.out.print(" \n");
        }
    }
}