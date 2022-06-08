public class 力扣206周赛第一题 {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int counts = 0;
        int flag = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    for (int k = 0; k < m; k++) {
                        if (k == j) {
                            continue;
                        }
                        if (mat[i][k] != 0) {
                            flag = 1;
                            break;
                        }
                        if (flag == 1) {
                            break;
                        }
                    }
                    for (int l = 0; l < n; l++) {
                        if (l == i) {
                            continue;
                        }
                        if (mat[l][j] != 0) {
                            flag = 1;
                            break;
                        }
                        if (flag == 1) {
                            break;
                        }
                    }
                    if (flag == 0) {
                        counts++;
                    }
                    flag = 0;
                }
            }
        }
        return counts;
    }
}
