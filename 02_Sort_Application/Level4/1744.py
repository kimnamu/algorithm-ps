# 수 묶기
# https://www.acmicpc.net/problem/1744
# 힌트
# 1. 1보다 큰 경우, 1인 경우, 0보다 작거나 같은 경우 세가지로 분류한다.
# 2. 1보다 큰 경우는 큰 순서로 정렬하여 두개의 수를 곱해주면 된다.
# 3. 1인 경우는 해당 수를 더해 주면 된다.
# 4. 0보다 작은 경우는 절대값이 큰 순서대로 정렬하여 두개의 수를 곱해주면 된다.

import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline())

    answer = 0
    pos_series = []
    neg_series = []

    for _ in range(N):
        current_val = int(sys.stdin.readline())
        # 1보다 크면 pos_series에 입력
        if current_val > 1:
            pos_series.append(current_val)
        # 1인 경우면 answer에 더해줌
        elif current_val == 1:
            answer += current_val
        # 0보다 같거나 작은 경우는 neg_series에 입력
        else:
            neg_series.append(current_val)

    # pos_series는 내림차순으로 정렬
    pos_series.sort(reverse=True)
    # neg_series는 오름차순으로 정렬
    neg_series.sort()

    if len(pos_series) > 1:
        for i in range(0, len(pos_series) - 1, 2):
            answer += pos_series[i] * pos_series[i+1]
    # 개수가 홀수개이면 1개가 남으므로 더해준다.
    if len(pos_series) % 2 == 1:
        answer += pos_series[-1]

    if len(neg_series) > 1:
        for i in range(0, len(neg_series) - 1, 2):
            answer += neg_series[i] * neg_series[i+1]
    # 개수가 홀수개이면 1개가 남으므로 더해준다.
    if len(neg_series) % 2 == 1:
        answer += neg_series[-1]

    print(answer)