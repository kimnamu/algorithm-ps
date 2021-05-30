# 회문
# https://www.acmicpc.net/problem/17609
# 힌트
# 1. 문자열의 왼쪽끝과 오른쪽 끝에서부터 하나씩 비교하면서 회문인지 확인한다.
# 2. 유사회문이 될 수 있으므로 서로 다른 문자를 비교하게 되면 왼쪽 포인터를 오른쪽으로 한칸 옮기고 마저 비교하거나,
#    오른쪽 포인터를 하나 건너띄고 비교하면 된다.
# 3. 왼쪽에서 건너띌지 오른쪽에서 건너뛸지 알수 없기 때문에 각각 수행해준다.
import sys


if __name__ == "__main__":
    T = int(sys.stdin.readline())

    for _ in range(T):
        str = sys.stdin.readline().strip()
        N = len(str)

        left, right = 0, N-1
        cnt = 0

        while left < right:
            if str[left] == str[right]:
                left += 1
                right -= 1
            else:
                if cnt == 1:
                    cnt = 2
                    break
                else:
                    left += 1
                    cnt += 1

        if cnt == 0 or cnt == 1:
            print(cnt)
            continue

        left, right = 0, N-1
        cnt = 0
        while left < right:
            if str[left] == str[right]:
                left += 1
                right -= 1
            else:
                if cnt == 1:
                    cnt = 2
                    break
                else:
                    right -= 1
                    cnt += 1

        if cnt == 1:
            print(1)
        else:
            print(2)
