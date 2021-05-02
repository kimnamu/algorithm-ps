//콘테스트
//https://www.acmicpc.net/problem/5576
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		
		for(int i = 0; i < 10; i++) {
			arr1[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 10; i++) {
			arr2[i] = sc.nextInt();
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int answer1 = arr1[7] + arr1[8] + arr1[9];
		int answer2 = arr2[7] + arr2[8] + arr2[9];
		
		System.out.println(answer1 + " " + answer2);
	}
}
