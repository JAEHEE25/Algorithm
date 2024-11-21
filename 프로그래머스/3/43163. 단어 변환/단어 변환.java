import java.util.*;

class Solution {
    static Map<String, ArrayList<String>> close;
    static Map<String, Boolean> visit;
    
    public int solution(String begin, String target, String[] words) {
        //단어 리스트
        String[] wordList = new String[words.length + 1];
        wordList[0] = begin;
        for (int i = 1; i < wordList.length; i++) {
            wordList[i] = words[i-1];
        }
        
        //인접 맵
        close = new HashMap<>();
        for (int i = 0; i < wordList.length; i++) {
            for (int j = 0; j < wordList.length; j++) {
                if (!close.keySet().contains(wordList[i])) {
                    close.put(wordList[i], new ArrayList<>());
                }                
                if (i != j && changedAlphaCnt(wordList[i], wordList[j]) == 1) { //한 글자만 다르면 인접          
                    close.get(wordList[i]).add(wordList[j]);
                }
            }
        }
        
        //방문 맵
        visit = new HashMap<>();
        for (int i = 0; i < wordList.length; i++) {
            visit.put(wordList[i], false);
        }
        
        return BFS(begin, target);
    }
    
    int BFS(String begin, String target) {
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));
        
        while (!queue.isEmpty()) {
            Word poll = queue.poll();
            if (poll.word.equals(target)) {
                return poll.cnt;
            }
            
            for (String closeWord : close.get(poll.word)) {
                if (visit.get(closeWord)) continue; //이미 방문
                visit.put(closeWord, true);
                queue.add(new Word(closeWord, poll.cnt + 1));
            }
        }
        return 0;
    }
    
    
    int changedAlphaCnt(String word, String nextWord) {
        int cnt = 0;
        int idx = 0;
        while (idx < word.length()) {
            if (word.charAt(idx) != nextWord.charAt(idx)) cnt++;
            idx++;
        }
        return cnt;
    }
}

class Word {
    String word;
    int cnt;
    
    Word(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }
}