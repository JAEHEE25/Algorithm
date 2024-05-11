import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < input.length(); i++) {
			String letter = String.valueOf(input.charAt(i));
			map.put(letter, map.getOrDefault(letter, 0) + 1);
		}

		List<String> keyList = new java.util.ArrayList<>(map.keySet());
		Collections.sort(keyList);

		StringBuilder sb = new StringBuilder();
		int oddCnt = 0;
		String mid = "";
		for (String letter : keyList) {
			int cnt = map.get(letter);
			sb.append(letter.repeat(cnt / 2));

			if (cnt % 2 == 1) {
				mid = letter;
				oddCnt++;
			}
		}

		if (oddCnt >= 2)
			System.out.println("I'm Sorry Hansoo");
		else {
			String left = sb.toString();
			String right = sb.reverse().toString();
			System.out.println(left + mid + right);
		}
	}
}
