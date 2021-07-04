// 트리의 높이와 너비
// https://www.acmicpc.net/problem/2250
// 힌트
// 1. inorder traverse 이용해 각 노드의 열번호를 발견한다.
// 2. traverse를 진행하면서 각 원소의 level을 찾아주고 각 level의 MAX와 MIN을 열번호를 통해 최신화 해줍니다.
// 3. par 값은 저장해서 root 노드를 찾는 용도로 사용합니다.
// 4. inorder traverse를 이용해서 차례대로 pos를 찾아주고 시켜주고, level의 MIN과 MAX를 통해 너비가 가장 넓은 위치를 찾아줍니다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair{
	int first;
	int second;
	
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class Main {
	static int[] nodes = new int[10001];
	static int[] MIN = new int[10001];
	static int[] MAX = new int[10001];
	static ArrayList<Pair> v;
	static int root = 1;
	static int max_lvl = 0;
	static int pos = 1;
	
	static void inorder(int root, int level)
	{
	    int left = v.get(root).first;
	    int right = v.get(root).second;
	    if (level > max_lvl)
	        max_lvl = level;
	    if (left != -1)
	        inorder(left, level + 1);
	    if (MIN[level] > pos)
	        MIN[level] = pos;
	    if (MAX[level] < pos)
	        MAX[level] = pos;
	    pos += 1;
	    if (right != -1)
	        inorder(right, level + 1);
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		v = new ArrayList<>();
		for (int i = 0 ;i < N + 1; i++) {
			v.add(new Pair(0, 0));
		}
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			v.set(p, new Pair(l, r));
			if (l >= 0 ) {
				nodes[l] = p;
			}
			
			if (r >= 0) {
				nodes[r] = p;				
			}
		}
		
	    while (nodes[root] != 0)
	        root = nodes[root];
	    
	    for (int i = 1; i <= 10000; i++) {
	        MIN[i] = 100000;
	    	MAX[i] = 1;	    	
	    }
	    
	    inorder(root, 1);
	    
	    int ans = 1;
	    for (int i = 1; i <= max_lvl; i++)
	    {
	        if (MAX[i] - MIN[i] > MAX[ans] - MIN[ans])
	            ans = i;
	    }
	    System.out.println(ans + " " + (MAX[ans] - MIN[ans] + 1));
	}
}
