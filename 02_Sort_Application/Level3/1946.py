# 신입 사원
# https://www.acmicpc.net/problem/1946
import sys

if __name__ == "__main__":
    T = int(input())

    for _ in range(T):
        N = int(input())

        scores = []
        for i in range(N):
            scores.append(list(map(int, sys.stdin.readline().split())))

        scores = sorted(scores)

        # 1. 서류면접 순위가 가장 높은 사람을 먼저 뽑고,
        answer = 1
        index = scores[0][1]
        for i in range(1, N):
            # 2. 이후 면접 순위가 앞의 통과자들의 면접 순위보다 높은 사람을 뽑으면서, 최소 면접 순위를 갱신함
            if scores[i][1] < index:
                answer += 1
                index = scores[i][1]

        print(answer)
