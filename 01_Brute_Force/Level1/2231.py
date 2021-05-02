# 분해합
# https://www.acmicpc.net/problem/2231

def decomposition(k):
    ret = k

    while k > 0:
        ret = ret + k % 10
        k = k // 10

    return ret


if __name__ == "__main__":
    N = int(input())
    M = 0

    # 1. 0 부터 N까지 완전 탐색을 통해 작은 수 부터 분해합이 N과 같아지는 최초의 수 찾기
    for i in range(N):
        if N == decomposition(i):
            M = i
            break

    print(M)