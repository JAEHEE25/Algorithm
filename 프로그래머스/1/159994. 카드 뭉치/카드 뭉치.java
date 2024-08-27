class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int idx1 = 0;
        int idx2 = 0;

        for (String word : goal) {
            if (cards1.length > idx1) {
                if (word.equals(cards1[idx1])) { //같은 단어
                    idx1++;
                    continue;
                }
            }
            
            if (cards2.length > idx2) {
                if (word.equals(cards2[idx2])) { //같은 단어
                    idx2++;
                    continue;
                }
            }
            answer = "No";
            break;
        }
        return answer;
    }
}