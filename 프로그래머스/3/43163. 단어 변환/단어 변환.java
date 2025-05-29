import java.util.*;

class Solution {
	// 단어 + 변환 횟수 클래스 정의
    class Word {
        String word;
        int count;
        
        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    // 두 단어 사이의 글자 차이 수 세기
    int getDiffCount(String word1, String word2) {
        int count = 0;
        
        for (int i = 0; i < word1.length(); i++){
            if (word1.charAt(i) != (word2.charAt(i))) count++;
        }
        return count;
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(new Word(begin, 0)); // 시작 단어로 시작
        visited.add(begin);
            
        while(!queue.isEmpty()){
            Word cur = queue.poll();
            
            // 방문한 단어가 목표 단어면 끝 return count
            if (cur.word.equals(target)) return cur.count;
           
            for (String next : words) {
		            // cur.word와 next가 한 글자 차이면
                if (getDiffCount(cur.word, next) == 1){ 
                    if (!visited.contains(next)){
                        queue.offer(new Word(next, cur.count+1));
                        visited.add(next);
                    }
                }
            }    
        }
        return 0;
    }
}