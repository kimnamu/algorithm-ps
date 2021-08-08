// 보석 도둑
// https://www.acmicpc.net/problem/1202
// 힌트
// 1.가방과 상자 정렬을 무게에 대해서 오름차순으로 정렬하자.
// 2. 허용 무게가 가장 작은 가방부터 가방에서 담을 수 있는 보석의 가치를 모두 담는다.
// 3. 담을 수 있는 가치 중에서 가장 비싼 것을 해당 가방에 넣는다. (이를 위해 우선순위 큐를 이용하면 편리하다.)
// 4. 2~3을 반복하며 가방에서 담을 수 있는 보석에 대한 index를 하나씩 키워가며 추가로 담을 수 있는 보석을 우선순위 큐에 넣어준다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

class Gem implements Comparable<Gem>{
	int weight;
	int price;
	
	public Gem(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}

	@Override
	public int compareTo(Gem o) {
		return this.weight - o.weight;
	}
}


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Gem> mv = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			mv.add(new Gem(M, V));
		}
		
		int[] bag = new int[K];
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		Collections.sort(mv);
		Arrays.sort(bag);
				
		long answer = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int index = 0;
		
		for (int i = 0; i < K; i++) {
			while (index < N && mv.get(index).weight <= bag[i]) {
				q.add(mv.get(index).price);
				index += 1;
			}
			if (q.size() > 0) {
				answer += q.poll();
			}
		}
		
		System.out.println(answer);
	}
}
