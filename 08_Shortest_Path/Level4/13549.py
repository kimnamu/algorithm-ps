# 숨바꼭질 3
# https://www.acmicpc.net/problem/13549
# 1. BFS를 이용하여 최단거리로 도달할 수 있는 방법을 찾는다.
# 2. 이때, 우선순위 Queue를 이용하여 2배 위치로 점프할 경우 가중치가 유지되어 먼저 search하도록 해준다.
import sys
from collections import deque

MAXNUM = 100000

if __name__ =="__main__":
    N, K = map(int, sys.stdin.readline().split())

    visit = [False] * (MAXNUM + 1)

    dq = deque()
    dq.appendleft((N, 0))
    visit[N] = True

    while dq:
        pos, answer = dq.popleft()

        visit[pos] = True

        if pos == K:
            print(answer)
            break

        left = pos - 1
        right = pos + 1
        jump = pos * 2

        if jump <= MAXNUM and not visit[jump]:
            dq.appendleft((jump, answer))

        if left >= 0 and not visit[left]:
            dq.append((left, answer + 1))

        if right <= MAXNUM and not visit[right]:
            dq.append((right, answer + 1))


