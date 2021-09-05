# 가장 긴 증가하는 부분 수열
# https://www.acmicpc.net/problem/11053
# 힌트
# 1. Bottom up으로 왼쪽에서 오른쪽까지 번호 하나씩 순회하며 해당 번호까지 가장 긴 증가하는 부분 수열 개수를 입력해준다.
# 2. 다음 위치에서 해당 위치까지의 가장 긴 부분수열을 구하기 위해 이전 값을 모두 순회하며 해당 값보다 작을 경우,
#    최소 그 위치의 가장 긴 부분 수열 개수 + 1이 되도록 해준다.
import sys


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    seq = list(map(int, sys.stdin.readline().split()))
    cnts = [0] * N
    answer = 0

    for i in range(N):
        cnt = 1
        for j in range(i):
            if seq[j] < seq[i]:
                cnt = max(cnt, cnts[j] + 1)

        cnts[i] = cnt
        answer = max(answer, cnt)

    print(answer)
