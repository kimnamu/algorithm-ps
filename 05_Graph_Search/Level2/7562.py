# 나이트의 이동
# https://www.acmicpc.net/problem/7562
# 힌트
# 1. BFS 알고리즘을 활용하여 시작점을 중심으로 몇 번째 만에 목적지에 다다를 수 있는지 구해보자.
# 2. 시작 위치를 중심으로 총 8가지의 이동을 할 수 있고,
#    이전에 방문한 적이 없다면 queue에 넣어주어 다음 스텝에서 꺼내서 방문하자.
import sys

dxy = [(-2, -1), (-1, -2), (1, -2), (2, -1),
       (2, 1), (1, 2), (-1, 2), (-2, 1)]


def solve(s, e):
    ans = 0

    q = [s]
    check[s[0]][s[1]] = True

    while len(q) != 0:
        q_size = len(q)
        for i in range(q_size):
            current = q.pop(0)
            if current[0] == e[0] and current[1] == e[1]:
                return ans

            for tp in dxy:
                np = (current[0] + tp[0], current[1] + tp[1])
                if inside_board(np) and check[np[0]][np[1]] == 0:
                    q.append(np)
                    check[np[0]][np[1]] = 1

        ans += 1


def inside_board(p):
    return 0 <= p[0] < N and 0 <= p[1] < N


if __name__ == "__main__":
    T = int(sys.stdin.readline())
    while T > 0:
        N = int(sys.stdin.readline())

        check = [[0] * N for _ in range(N)]

        a, b = map(int, sys.stdin.readline().split())
        start = (a, b)

        a, b = map(int, sys.stdin.readline().split())
        end = (a, b)

        answer = solve(start, end)
        print(answer)

        T -= 1
