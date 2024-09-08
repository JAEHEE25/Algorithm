import java.io.*;
import java.util.*;

public class Main {
	static char[] result;
	static int L;
	static int C;
	static char[] letters;
	static boolean[] visit;
	static List<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		letters = new char[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			letters[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(letters);
		result = new char[L];
		visit = new boolean[26];
        list = new ArrayList<>();
        backtracking(0, 0);

		StringBuilder sb = new StringBuilder();
        list.stream().filter(Main::validate).forEach(l -> sb.append(l).append("\n"));
		System.out.println(sb);

	}//main

    public static boolean validate(String str) {
        char[] arr = str.toCharArray();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int vowel = 0;

		for (char c : arr) {
			for (char v : vowels) {
				if (c == v) vowel++;
			}
		}
		return vowel >= 1 && (str.length() - vowel) >= 2;
    }

	public static void backtracking(int depth, int start) {
		if (depth == L) {
			list.add(String.valueOf(result));
			return;
		}

		for (int i = start; i < C; i++) {
			char letter = letters[i];
			int alphaIdx = letter - 97;
			if (!visit[alphaIdx]) {
				visit[alphaIdx] = true;
				result[depth] = letter;
                backtracking(depth + 1, i);
                visit[alphaIdx] = false;
			}
		}
	}
}//class