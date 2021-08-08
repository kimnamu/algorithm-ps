# 다이어트
# https://www.acmicpc.net/problem/1484
# 힌트
# 1. 기존 몸무게를 1부터, 현재 몸무게를 1부터 시작하는 투포인터를 이용하여 G 값과 비교 한다.
# 2. 두 몸무게의 제곱 차가 G보다 작으면 현 몸무게를 1씩 키우고, 크면 기존 몸무게를 1씩 키운다.
# 3. 두 몸무게의 차이가 1인데 제곱의 차가 G보다 크면 더이상 찾지 않아도 된다.

def find_limit(k):
    ret = 2

    while True:
        if k < (ret + ret - 1):
            break
        ret += 1

    return ret


if __name__ == "__main__":
    G = int(input())

    limit = find_limit(G)

    left, right = 1, 1
    exist_no = True

    while right <= limit:
        if (right + left) * (right - left) == G:
            print(right)
            left += 1
            exist_no = False
        elif (right + left) * (right - left) < G:
            right += 1
        else:
            left += 1

    if exist_no:
        print(-1)
