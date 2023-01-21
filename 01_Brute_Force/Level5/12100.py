# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
#2048(Easy)
#https://www.acmicpc.net/problem/12100
import copy

# 블록을 시계방향으로 회전시켜주는 함수
def turnRight(brd):
    ret = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            ret[j][N-1-i] = brd[i][j]

    return ret


# 4가지 방향으로의 움직임에 대해 dfs를 활용하여 완전탐색을 해준다.
def dfs(brd, cnt):
    if cnt == 0:
        return

    brd_temp = copy.deepcopy(brd)

    for i in range(4):
        dfs(move(i, brd), cnt - 1)

        brd = copy.deepcopy(brd_temp)


def move(k, brd):
    global answer
    # 4방향에 대해 각각 코드를 짜주는것이 아닌,
    # 전체 block을 미리 회전 시켜 각 방향으로 합쳐주는 효과를 준다.
    for i in range(k):
        brd = turnRight(brd)
    # top block과 새로 push되는 block이 같으면 합쳐준다.
    for i in range(N):
        block = []
        for j in range(N-1, -1, -1):
            if brd[i][j] != 0:
                if len(block) == 0:
                    block.append(brd[i][j])
                elif block[-1] == brd[i][j]:
                    block.pop()
                    # 한번 합쳐준 block은 다시 합쳐지면 안되므로 +1을 해주어 다시 합쳐지지 않도록 함.
                    # block 특성상 모두 짝수이기 때문에 가능한 방법이다.
                    block.append(brd[i][j] * 2 + 1)
                else:
                    block.append(brd[i][j])
            brd[i][j] = 0

        while len(block) > 0:
            b = block[-1]

            # 합쳐져서 홀수로 입력된 block을 다시 원래값인 짝수로 변환해준다.
            if b % 2 == 1:
                b -= 1
            answer = max(answer, b)
            brd[i][N - len(block)] = b
            block.pop()

    # 다시 원래 board 방향으로 돌려놓는다.
    if k != 0:
        for i in range(4 - k):
            brd = turnRight(brd)
    return brd


if __name__ == "__main__":
    N = int(input())
    board = []

    for _ in range(N):
        board.append(list(map(int, input().split())))

    answer = 0

    dfs(board, 5)

    print(answer)