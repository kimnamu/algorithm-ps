# 타일 장식물
# https://www.acmicpc.net/problem/13301
# 힌트
# 1. 타일의 크기는 피보나치수열을 이루고 있다.
# 2. "타일의 둘레 = 이전 타일의 둘레 + 새로 만들어진 타일의 크기 * 2" 의 점화식을
#     이용하여 bottom-up의 다이나믹 프로그래밍을 이용한다.
import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline())

    a_list = [1, 1]

    for _ in range(N - 1):
        a_list.append(sum(a_list[-2:]))

    answer = a_list[-1] * 2 + a_list[-2] * 2
    print(answer)