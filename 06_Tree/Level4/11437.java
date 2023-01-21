// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// LCA
// https://www.acmicpc.net/problem/11437
// 힌트
// 1. 각 노드 별로 깊이를 저장하고 같은 깊이가 될때까지 더 깊은 노드의 parent를 찾는다.
// 2. 같은 깊이 일때 서로 다른 노드 값을 갖는다면 같은 parent를 갖을때까지 계속해서 parent를 찾는다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Question{
	int first;
	int second;
	public Question(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    // 1. map을 활용해 input데이터 저장하기
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
		
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			if (m.get(num1) == null) {
				m.put(num1, new ArrayList<Integer>() {{add(num2);}});
			} else {
				m.get(num1).add(num2);
			}
			if (m.get(num2) == null) {
				m.put(num2, new ArrayList<Integer>() {{add(num1);}});
			} else {
				m.get(num2).add(num1);
			}
		}

	    // 2. 질문들 저장
		int M = Integer.parseInt(br.readLine());
	    ArrayList<Question> question = new ArrayList<>();
	    
	    for (int i = 0; i < M; i++)
	    {
	    	st = new StringTokenizer(br.readLine());
	    	int first = Integer.parseInt(st.nextToken());
	    	int second = Integer.parseInt(st.nextToken());

	    	question.add(new Question(first, second));
	    }

	    // 3. 트리 배열과 깊이 배열 만들기
	    // tree 배열은 조상 노드를 저장
	    // depth 배열은 해당 노드의 깊이 저장
	    int[] tree = new int[N + 1];
		int[] depth = new int[N + 1];
		
		Queue<Integer> q = new LinkedList<>();

	    tree[1] = 1;
	    depth[1] = 0;
	    q.add(1);
	    int d = 0;
	    while (q.size() > 0 && ++d > 0)
	    {
	        int[] parent = new int[q.size()];
	        for (int i = 0; i < q.size(); i++)
	        {
	            parent[i] = q.poll();
	        }
	        
	        for (int i = 0; i < parent.length; i++)
	        {
	            ArrayList<Integer> child = m.get(parent[i]);
	            if (child == null)
	            	continue;
	            
	            for (int j = 0; j < child.size(); j++)
	            {
	                if (tree[child.get(j)] == 0)
	                {
	                	tree[child.get(j)] = parent[i];
	                    depth[child.get(j)] = d;
	                    q.add(child.get(j));
	                }
	            }
	        }
	    }

	    // 4. 가까운 공통조상 찾기
	    for (int i = 0; i < question.size(); i++)
	    {
	        int num1 = question.get(i).first;
	        int num2 = question.get(i).second;
	        while (true)
	        {
	            // 공통 조상을 찾으면 출력
	            if (num1 == num2)
	            {
	                System.out.println(num1);
	                break;
	            }
	            // depth가 같으면 두 노드 모두 조상 노드로 치환
	            if (depth[num1] == depth[num2])
	            {
	                num1 = tree[num1];
	                num2 = tree[num2];
	                // num1의 depth가 더 깊으면 num1만 조상 노드로 치환
	            }
	            else if (depth[num1] > depth[num2])
	            {
	                num1 = tree[num1];
	                // num2의 depth가 더 깊으면 num2만 조상 노드로 치환
	            }
	            else
	            {
	                num2 = tree[num2];
	            }
	        }
	    }
		
	}
}
