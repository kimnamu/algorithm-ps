// 나이트의 이동
// https://www.acmicpc.net/problem/7562
// 힌트
// 1. BFS 알고리즘을 활용하여 시작점을 중심으로 몇 번째 만에 목적지에 다다를 수 있는지 구해보자.
// 2. 시작 위치를 중심으로 총 8가지의 이동을 할 수 있고, 
//    이전에 방문한 적이 없다면 queue에 넣어주어 다음 스텝에서 꺼내서 방문하자.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point add(Point p) {
		return new Point(this.x + p.x, this.y + p.y);
	}
	
	public boolean isEqual(Point p) {
		return (this.x == p.x && this.y == p.y);
	}
}

public class Main {
	static boolean check[][];
	static int N;
	static Point[] dxy = {new Point(-2, -1), new Point(-1, -2), new Point(1, -2), new Point(2, -1),
			new Point(2, 1), new Point(1, 2), new Point(-1, 2), new Point(-2, 1)};
		
	static int solve(Point s, Point e) {
		int answer = 0;
		
		Queue<Point> q = new LinkedList<>();
		q.add(s);
		check[s.x][s.y] = true;

		while(!q.isEmpty()) {
			int q_size = q.size();
			for (int i = 0; i < q_size; i++) {
				Point current = q.poll();
				
				if (current.isEqual(e)) {
					return answer;
				}
				for (Point tp : dxy) {
					Point np = current.add(tp);
					if (insideBoard(np) && !check[np.x][np.y]) {
						q.add(np);
						check[np.x][np.y]= true; 
					}
				}				
			}
			answer += 1;
		}
		
		return answer;
	}
	
	static boolean insideBoard(Point p) {
		return (p.x >= 0 && p.x < N && p.y >=0 && p.y < N);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			check = new boolean[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine());
			Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			int answer = solve(start, end);
			
			System.out.println(answer);
		}
	}
}
