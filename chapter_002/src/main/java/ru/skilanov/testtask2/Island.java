package ru.skilanov.testTask2;

/**
 * This class finds max island size.
 */
public class Island {

    /**
     * This recursive method finds islands.
     *
     * @param c int
     * @param r int
     * @param sz int[][]
     * @return count int
     */
    private int islandSize(int r, int c, int[][] sz) {
        int count = 0;
        if (sz[r - 1][c] == 0 && sz[r + 1][c] == 0 && sz[r][c + 1] == 0 && sz[r][c - 1] == 0) {
            return 0;
        }
        if (sz[r - 1][c] == 1) {
            sz[r - 1][c] = 0;
            count = count + 1 + islandSize(r - 1, c, sz);
        }
        if (sz[r + 1][c] == 1) {
            sz[r + 1][c] = 0;
            count = count + 1 + islandSize(r + 1, c, sz);
        }
        if (sz[r][c + 1] == 1) {
            sz[r][c + 1] = 0;
            count = count + 1 + islandSize(r, c + 1, sz);
        }
        if (sz[r][c - 1] == 1) {
            sz[r][c - 1] = 0;
            count = count + 1 + islandSize(r, c - 1, sz);
        }

        return count;
    }

    /**
     * This method finds max island.
     * @param sea int[][]
     * @return int mazSquare
     */
    public int maxSizeIsland(int[][] sea) {
        int maxSquare = 0;
        int[][] newSea = new int[sea.length + 2][sea[0].length + 2];
        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < sea[0].length; j++) {
                newSea[i + 1][j + 1] = sea[i][j];
            }
        }

        for (int i = 0; i < newSea.length; i++) {
            for (int j = 0; j < newSea[0].length; j++) {
                if (newSea[i][j] == 1) {
                    int islandSquare = islandSize(i, j, newSea);
                    if (islandSquare > maxSquare) {
                        maxSquare = islandSquare;
                    }
                }
            }
        }
        return maxSquare;
    }
}