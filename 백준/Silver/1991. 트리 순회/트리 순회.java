import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		Map<String, Node> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			String alpha = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			Node node = map.getOrDefault(alpha, new Node(alpha.charAt(0)));
			map.put(alpha, node);

			if (!left.equals(".")) {
				Node leftNode = map.getOrDefault(left, new Node(left.charAt(0)));
				node.setLeftNode(leftNode);
				map.put(left, leftNode);
			}

			if (!right.equals(".")) {
				Node rightNode = map.getOrDefault(right, new Node(right.charAt(0)));
				node.setRightNode(rightNode);
				map.put(right, rightNode);
			}
		}

		visit = new boolean[26];
		PLR(map.get("A"));
		sb.append("\n");

		visit = new boolean[26];
		LPR(map.get("A"));
		sb.append("\n");

		visit = new boolean[26];
		LRP(map.get("A"));
		System.out.println(sb);
	}//main

	static void PLR(Node node) {
		if (visit[node.idx]) {
			return;
		}
		visit[node.idx] = true;
		sb.append(node.alpha);

		for (int i = 0; i < 2; i++) {
			if (node.close[i] != null) {
				PLR(node.close[i]);
			}
		}
	}

	static void LPR(Node node) {
		if (visit[node.idx])
			return;

		if (node.close[0] != null) {
			LPR(node.close[0]);
		}

		visit[node.idx] = true;
		sb.append(node.alpha);

		if (node.close[1] != null) {
			LPR(node.close[1]);
		}
	}

	static void LRP(Node node) {
		if (visit[node.idx])
			return;

		for (int i = 0; i < 2; i++) {
			if (node.close[i] != null) {
				LRP(node.close[i]);
			}
		}

		visit[node.idx] = true;
		sb.append(node.alpha);
	}

}//class

class Node {
	char alpha;
	int idx;
	Node[] close;

	Node(char alpha) {
		this.alpha = alpha;
		this.idx = alpha - 'A';
		this.close = new Node[2];
	}

	void setLeftNode(Node left) {
		close[0] = left;
	}

	void setRightNode(Node right) {
		close[1] = right;
	}
}
