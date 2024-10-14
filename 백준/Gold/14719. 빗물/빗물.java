import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int water = getWater(W, height);
        System.out.println(water);
    }//main

    private static int getWater(int W, int[] height) {
        int left = 0;
        int right = W - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        while (left < right) {
            if (leftMax <= rightMax) {
                left++;
                leftMax = Math.max(height[left], leftMax);
                water += (leftMax - height[left]);
            } else {
                right--;
                rightMax = Math.max(height[right], rightMax);
                water += (rightMax - height[right]);
            }
        }
        return water;
    }

}//class