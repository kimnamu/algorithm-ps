// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 수들의 합
// https://www.acmicpc.net/problem/2268
// 힌트
// 1. Brute Force의 시간복잡도는 O(N^2 x M)이므로 시간초과를 하게 된다. 세그트리를 이용하면 시간복잡도는 O(logN * M)로 제한 시간안에 풀 수 있다.
// 2. 세그트리는 크게 세부분으로 나누어 구현한다.
// 2.1. init : 세그트리를 초기화 해준다. N의 크기에 맞춰 트리의 높이를 계산해주고, 그 높이에 맞는 tree를 만들어준다.
// 2.2. query : 구간을 던져주면 해당 구간합을 반환 한다.문제에서 sum이라고 하지만 세그트리에서는 구간을 던져주면 그에 대한 구간합을 만들어주기 때문에 query라고 한다.
// 2.3. update : 특정 index의 값이 바뀌면 해당 index를 포함하는 tree node값을 갱신해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
    static long[] arr;
    static long[] tree;

	
	static long init(int node, int start, int end)
	{
	    if (start == end)
	        return tree[node] = arr[start];
	    else
	    {
	        int mid = (start + end) / 2;
	        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
	    }
	}

	static void update(int node, int start, int end, int idx, long diff)
	{
	    if (!(start <= idx && idx <= end))
	        return;

	    tree[node] += diff;

	    if (start != end)
	    {
	        int mid = (start + end) / 2;

	        update(node * 2, start, mid, idx, diff);
	        update(node * 2 + 1, mid + 1, end, idx, diff);
	    }
	}

	static long query(int node, int start, int end, int i, int j)
	{
	    if (i > end || j < start)
	        return 0;

	    if (i <= start && end <= j)
	        return tree[node];

	    int mid = (start + end) / 2;

	    return query(node * 2, start, mid, i, j) + query(node * 2 + 1, mid + 1, end, i, j);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
	    // 2.1. Initialization
	    int height = (int)Math.ceil(Math.log(N) / Math.log(2));
	    int tree_size = 1 << (height + 1);
	    arr = new long[N + 1];
	    tree = new long[tree_size];
	    
	    init(1, 1, N);
	    
	    StringBuilder sb = new StringBuilder();
	    for (int index = 0; index < M; index++)
	    {
	    	st = new StringTokenizer(br.readLine());
	        int mode = Integer.parseInt(st.nextToken());
	        
	        // 2.2. Sum
	        if (mode == 0)
	        {
		        int i = Integer.parseInt(st.nextToken());
		        int j = Integer.parseInt(st.nextToken());

		        if (i > j) {
		        	int tmp = i;
		        	i = j;
		        	j = tmp;
		        }
		        sb.append(query(1, 1, N, i, j) + "\n");
	        }
	        // 2.3. Update
	        else
	        {
		        int idx = Integer.parseInt(st.nextToken());
		        int val = Integer.parseInt(st.nextToken());
		        
	            long diff = val - arr[idx];
	            arr[idx] = val;
	            update(1, 1, N, idx, diff);
	        }
	    }
	    
	    System.out.println(sb.toString());

	}
}
