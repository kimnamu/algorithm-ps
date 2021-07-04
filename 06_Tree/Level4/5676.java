// 음주 코딩
// https://www.acmicpc.net/problem/5676
// 힌트
// 1. 구간연산을 위해 Segment Tree를 활용한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static long[] tree, v;
	
	static long sum(int i)
	{
	    long ret = 0;
	    while (i > 0)
	    {
	        ret += tree[i];
	        i -= (i & -i);
	    }
	    return ret;
	}

	static void update(int i, long val)
	{
	    while (i <= N)
	    {
	        tree[i] += val;
	        i += (i & -i);
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ( (str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			tree = new long[500000];
			v = new long[500000];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				v[i] = Long.parseLong(st.nextToken());
				if (v[i] == 0) {
					update(i, (long)1e6);
				} else if (v[i] > 0) {
					update(i, 0);
				} else if (v[i] < 0){
					update(i, 1);
				}
			}
			
	        for (int i = 1; i <= K; i++)
	        {
				st = new StringTokenizer(br.readLine());

	            char c;
	            int x, y;
	            c = st.nextToken().charAt(0);
	            x = Integer.parseInt(st.nextToken());
	            y = Integer.parseInt(st.nextToken());
	            
	            if (c == 'P')
	            {
	                long ans = sum(y) - sum(x - 1);
	                if (ans >= 1000000)
	                    System.out.print('0');
	                else if ((ans & 1) > 0)
	                    System.out.print('-');
	                else
	                    System.out.print('+');
	            }
	            else if (c == 'C')
	            {
	                long diff = (long) ((y > 0 ? 0 : y < 0 ? 1: 1e6) -
	                          (v[x] > 0 ? 0 : v[x] < 0 ? 1: 1e6));
	                v[x] = y;
	                update(x, diff);
	            }
	        }
	        System.out.println();
		}
	}
}
