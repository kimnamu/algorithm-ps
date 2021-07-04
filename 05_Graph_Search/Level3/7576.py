# 토마토
# https://www.acmicpc.net/problem/7576
# 힌트
# 1. 처음에 익은 토마토를 queue에 넣어주어 상하좌우 방향으로 안익은 토마토를 익힌 토마토로 바꾸어 나가면 된다.
#  queue에 들어오는 값들이 처음 input 위치와 얼마만큼 떨어졌는지를 계산해 내야한다.
# Python Tip. 타임아웃 난다면  collections의 dequeue를 사용
#  list를 queue로 사용가능하지만, pop시 O(n)의 시간복잡도를 가짐. dequeue는 O(1)
import sys
from collections import deque

dxy = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def solve():
    ans = 0

    q = deque()
    for i in range(N):
        for j in range(M):
            if board[i][j] == 1:
                q.append((i, j))
                check[i][j] = True

    while len(q) != 0:
        q_size = len(q)
        for i in range(q_size):
            current = q.popleft()

            for tp in dxy:
                np = (current[0] + tp[0], current[1] + tp[1])
                if inside_board(np) and board[np[0]][np[1]] == 0 and check[np[0]][np[1]] == 0:
                    q.append(np)
                    check[np[0]][np[1]] = True
                    board[np[0]][np[1]] = 1

        ans += 1

    if is_all_ripen():
        return ans - 1
    else:
        return -1


def is_all_ripen():
    for i in range(N):
        for j in range(M):
            if board[i][j] == 0:
                return False
    return True


def inside_board(p):
    return 0 <= p[0] < N and 0 <= p[1] < M


if __name__ == "__main__":
    M, N = map(int, sys.stdin.readline().split())

    board = [[0] * M for _ in range(N)]
    check = [[False] * M for _ in range(N)]

    for i in range(N):
        board[i] = list(map(int, sys.stdin.readline().split()))

    answer = solve()
    print(answer)

