# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
import sys


def solve(pos, state):
    if state == (1 << N) - 1:
        if table[pos][0] == 0:
            return sys.maxsize
        else:
            return table[pos][0]

    if cost[pos][state] != -1:
        return cost[pos][state]
    cost[pos][state] = sys.maxsize

    for i in range(N):
        if table[pos][i] == 0:
            continue
        if (state & (1 << i)) == (1 << i):
            continue

        cost[pos][state] = min(cost[pos][state], \
                               table[pos][i] + solve(i, state | 1 << i))

    return cost[pos][state]


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    table = []

    for _ in range(N):
        table.append(list(map(int, sys.stdin.readline().split())))

    cost = [[-1] * (2 ** N) for _ in range(N)]
    answer = solve(0, 1)

    print(answer)
