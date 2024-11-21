import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Book[] books = new Book[book_time.length];
        for (int i = 0; i < book_time.length; i++) {
            int startTime = convertToTime(book_time[i][0]);
            int endTime = convertToTime(book_time[i][1]) + 10;
            books[i] = new Book(startTime, endTime);
        }

        Arrays.sort(books, (o1, o2) -> o1.startTime - o2.startTime);
        Queue<Book> pq = new PriorityQueue<>();
        pq.add(books[0]);
        int answer = 1;

        for (int i = 1; i < books.length; i++) {
            int startTime = books[i].startTime;
            int nextEndTime = pq.peek().endTime;
            if (nextEndTime > startTime) {
                answer++;
            } else {
                pq.poll();
            }
            pq.add(books[i]);
        }
        return answer;
    }
    
    int convertToTime(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]) * 60;
        int min = Integer.parseInt(t[1]);
        return hour + min;
    }
}

class Book implements Comparable<Book> {
    int startTime;
    int endTime;
    
    Book(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    @Override
    public int compareTo(Book book) {
        return this.endTime - book.endTime;
    }
}