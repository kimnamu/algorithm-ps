// 이진 검색 트리
// https://www.acmicpc.net/problem/5639
// 힌트
// 1. pre[start]보다 작은 노드들의 구간 중 끝 지점을 찾아 해당 위치를 기준으로
//    (l, r - 1), (r, end) 구간에서 postOrder 함수를 재귀호출한다.
// 2. pre[start]보다 작은 노드가 없다면 (l, end)에 대해 postOrder함수를 재귀 호출 한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] pre = new int[100000];
	
	static void postOrder(int start, int end)
	{
	    int root = pre[start];
	    int l = start + 1;
	    int r = -1;
	    for (int i = start; i <= end; i++)
	    {
	        if (root < pre[i])
	        {
	            r = i;
	            break;
	        }
	    }
	    if (start != end)
	    {
	        if (r != l)
	        {
	            if (r != -1)
	                postOrder(l, r - 1);
	            else
	                postOrder(l, end);
	        }
	        if (r != -1)
	            postOrder(r, end);
	    }
	    System.out.println(root);
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int index = 0;
		int num = 0;
		String input;
		while (true) {
			input = br.readLine();
			if (input == null || input.equals(""))
				break;
			num = Integer.parseInt(input);
			pre[index++] = num;
		}
		
		postOrder(0, index - 1);
	}
}

