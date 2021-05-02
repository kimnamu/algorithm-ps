# 체스판 다시 칠하기
# https://www.acmicpc.net/problem/1018

if __name__ == "__main__":
    N, M = map(int, input().split())

    table = []
    for _ in range(N):
        table.append(input())

    answer = 8 * 8

    for i in range(N - 7):
        for j in range(M - 7):
            BW, WB = 0, 0
            for ki in range(8):
                for kj in range(8):
                    if (ki + kj) % 2 == 0 and table[i+ki][j+kj] != 'B':
                        BW += 1
                    elif (ki + kj) % 2 == 1 and table[i+ki][j+kj] != 'W':
                        BW += 1
                    # WB로 시작하는 체스판과의 차이 계산 (BW의 반대값으로 계산)
                    WB = 64 - BW
            answer = min(answer, BW, WB)

    print(answer)
