# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# LCA
# https://www.acmicpc.net/problem/11438
# 힌트
# 1. 각 노드 별로 깊이를 저장하고 같은 깊이가 될때까지 더 깊은 노드의 parent를 찾는다.
# 2. 같은 깊이 일때 서로 다른 노드 값을 갖는다면 같은 parent를 갖을때까지 계속해서 parent를 찾는다.
# * python의 경우 pypy3로 컴파일해야 시간초과 안남.
import sys
from collections import deque

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    m = {}
    # 1. map을 활용해 input데이터 저장하기
    for _ in range(N - 1):
        num1, num2 = map(int, sys.stdin.readline().split())
        if num1 in m:
            m[num1].append(num2)
        else:
            m[num1] = [num2]
        if num2 in m:
            m[num2].append(num1)
        else:
            m[num2] = [num1]

    # 2. 질문들 저장
    M = int(sys.stdin.readline())
    question = []
    for _ in range(M):
        a, b = map(int, sys.stdin.readline().split())
        question.append((a, b))
    # 3. 트리 배열과 깊이 배열 만들기
    # tree 배열은 조상 노드를 저장
    # depth 배열은 해당 노드의 깊이 저장
    tree = [0] * (N + 1)
    depth = [0] * (N + 1)
    q = deque()

    tree[1] = 1
    depth[1] = 0
    q.append(1)

    d = 1
    while len(q) > 0:
        parent = [0] * len(q)
        for i in range(len(q)):
            parent[i] = q.popleft()

        for i in range(len(parent)):
            child = m[parent[i]]
            for j in range(len(child)):
                if tree[child[j]] == 0:
                    tree[child[j]] = parent[i]
                    depth[child[j]] = d
                    q.append(child[j])
        d += 1

    # 4. 가까운 공통조상 찾기
    for i in range(len(question)):
        num1 = question[i][0]
        num2 = question[i][1]

        while True:
            # 공통 조상을 찾으면 출력
            if num1 == num2:
                print(num1)
                break

            # depth가 같으면 두 노드 모두 조상 노드로 치환
            if depth[num1] == depth[num2]:
                num1 = tree[num1]
                num2 = tree[num2]
                # num1의 depth가 더 깊으면 num1만 조상 노드로 치환
            elif depth[num1] > depth[num2]:
                num1 = tree[num1]
                # num2의 depth가 더 깊으면 num2만 조상 노드로 치환
            else:
                num2 = tree[num2]