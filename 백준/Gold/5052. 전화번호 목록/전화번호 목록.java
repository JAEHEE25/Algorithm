import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] numbers = new String[N];
			for (int i = 0; i < N; i++) {
				numbers[i] = br.readLine();
			}

			Arrays.sort(numbers);
			Trie trie = new Trie();
			for (String number : numbers) {
				trie.insert(number);
			}
            boolean isYes = true;
            for (String number : numbers) {
                isYes = trie.search(number);
				if (!isYes) break;
			}

            if (isYes) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
		}
        System.out.println(sb);
	}//main
}//class

class Node {
	Node[] children = new Node[10];
	boolean isEnd;
}

class Trie {
	Node root;

	Trie() {
		root = new Node();
	}

	void insert(String number) {
		Node node = root;

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			int idx = c - '0';
			if (node.children[idx] == null) {
				node.children[idx] = new Node();
			}
			node = node.children[idx];
		}
        node.isEnd = true;
	}

	boolean search(String number) {
		Node node = root;

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			int idx = c - '0';
			if (node.isEnd && node.children[idx] != null) { //접두어 존재
				return false;
			}
			node = node.children[idx];
		}
        return true;
	}
}