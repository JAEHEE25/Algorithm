class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] result = {6, 6, 5, 4, 3, 2, 1};
        int zeroCnt = 0;
        int winCnt = 0;
        for (int l : lottos) {
            if (l == 0) zeroCnt++;
            for (int w : win_nums) {
                if (l == w) winCnt++;
            }
        }
        return new int[] {result[zeroCnt + winCnt], result[winCnt]};
    }
}