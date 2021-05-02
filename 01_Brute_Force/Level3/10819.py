# 차이를 최대로
# https://www.acmicpc.net/problem/10819
from itertools import permutations

if __name__ == "__main__":
    N = int(input())

    A = list(map(int, input().split()))

    answer = 0

    # A의 순열을 바꿔가면서 그때의 이웃한 값들의 차이의 합이 가장 커지는 temp값을 answer에 갱신
    for pl in permutations(A, N):
        temp = 0
        for i in range(1, N):
            temp += abs(pl[i] - pl[i-1])
        answer = max(temp, answer)

    print(answer)

