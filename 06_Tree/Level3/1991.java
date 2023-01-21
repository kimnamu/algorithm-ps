// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 트리 순회
// https://www.acmicpc.net/problem/1991
// 힌트
// 1. left와 right 값을 갖는 node로 이루어진 배열을 만들어 tree구조로 사용한다.
// 2. PreOrder는 root -> left -> right 순으로 출력한다.
// 3. InOrder는 left -> root -> right 순으로 출력한다.
// 4. PostOrder는 left -> right -> root 순으로 출력한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
	char left;
	char right;
	
	public Node(char left, char right) {
		this.left = left;
		this.right = right;
	}
}

public class Main {
	static int N;
	static ArrayList<Node> tree;
	
	static void PreOrder(char root)
	{
	    if (root == '.')
	        return;
	    System.out.print(root);
	    PreOrder(tree.get(charToNodeNum(root)).left);
	    PreOrder(tree.get(charToNodeNum(root)).right);
	}

	static void InOrder(char root)
	{
	    if (root == '.')
	        return;
	    InOrder(tree.get(charToNodeNum(root)).left);
	    System.out.print(root);
	    InOrder(tree.get(charToNodeNum(root)).right);
	}

	static void PostOrder(char root)
	{
	    if (root == '.')
	        return;
	    PostOrder(tree.get(charToNodeNum(root)).left);
	    PostOrder(tree.get(charToNodeNum(root)).right);
	    System.out.print(root);
    }
	
	static int charToNodeNum(char ch) {
		return ch - 'A';
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList<>();
		for (int i = 0; i < 27; i++) {
			tree.add(new Node('.', '.'));
		}
		
		for (int i = 1; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node = st.nextToken().charAt(0) - 'A';
			
			tree.get(node).left =st.nextToken().charAt(0);
			tree.get(node).right =st.nextToken().charAt(0);
		}
		
		PreOrder('A');
		System.out.println();
		
		InOrder('A');
		System.out.println();
		
		PostOrder('A');
		System.out.println();
		
	}
}

