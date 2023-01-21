// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 최솟값과 최댓값
// https://www.acmicpc.net/problem/2357
// 힌트
// 1. 세그트리를 이용하여 각 구간 별 최소 값을 저장하는 트리와, 최대 값을 저장하는 트리를 만든다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static int[] arr;
    static int[] min_tree;
    static int[] max_tree;

	static void init(int node, int start, int end)
	{
	    if (start == end)
	    {
	        min_tree[node] = max_tree[node] = arr[start];
	        return;
	    }
	    init(node * 2, start, (start + end) / 2);
	    init(node * 2 + 1, (start + end) / 2 + 1, end);
	    min_tree[node] = Math.min(min_tree[node * 2], min_tree[node * 2 + 1]);
	    max_tree[node] = Math.max(max_tree[node * 2], max_tree[node * 2 + 1]);
	    return;
	}

	static Pair find(int node, int a, int b, int left, int right)
	{
	    if (left > b || right < a)
	        return new Pair(Integer.MAX_VALUE, 0);
	    if (a <= left && right <= b)
	    {
	        return new Pair(min_tree[node], max_tree[node]);
	    }
	    
	    Pair l, r;
	    l = find(node * 2, a, b, left, (left + right) / 2);
	    r = find(node * 2 + 1, a, b, (left + right) / 2 + 1, right);
	    return new Pair(Math.min(l.first, r.first), Math.max(l.second, r.second));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
	    int ts = 1 << (int)(Math.ceil(Math.log(N)/Math.log(2)) + 1);
	    min_tree = new int[ts];
	    max_tree = new int[ts];

    	arr = new int[N];
    	for(int i = 0 ; i < N ; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	
    	init(1, 0, N-1);
    	
    	for (int i = 0; i < M ; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		Pair answer = find(1, a-1, b-1, 0, N-1);
    		System.out.println(answer.first + " " + answer.second);
    	}
		
	}
}
