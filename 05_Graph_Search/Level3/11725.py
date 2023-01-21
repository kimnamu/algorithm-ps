# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 트리의 부모 찾기
# https://www.acmicpc.net/problem/11725
# 힌트
# 1. 연결된 노드가 "부모-자식" 인지 "자식-부모"인지 명확하지 않기 때문에, 우선은 모두 연결 해준다.
# 2. 노드1을 루트로 하여 BFS를 통해 모든 노드를 순회한다.
#  이 때, 이전에 방문하지 않았던 새로운 노드를 방문하게 된다면, 새로운 노드의 부모 노드는 input으로 주어진 노드의 번호 된다.
# 3. N이 너무 크기 때문에 N^2의 이차 배열을 만들게 되면 메모리 초과 발생
import sys
from collections import deque


def bfs():
    q = deque()
    q.append(1)

    while len(q) != 0:
        parent = q.popleft()
        for j in table[parent]:
            if answer[j] == 0:
                answer[j] = parent
                q.append(j)


if __name__ == "__main__":
    N = int(sys.stdin.readline())

    table = [[] for _ in range(N+1)]

    for i in range(N-1):
        x, y = map(int, sys.stdin.readline().split())
        table[x].append(y)
        table[y].append(x)

    answer = [0] * (N + 1)
    bfs()

    for i in range(2, N + 1):
        print(answer[i])