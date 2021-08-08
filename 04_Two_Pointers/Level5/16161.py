import sys

if __name__ == "__main__":
    N = int(input())
    s_list = list(map(int, sys.stdin.readline().split()))

    answer = 1

    left, right = 0, 0

    while right < len(s_list) - 1:
        cnt, l, r = 0, 0, 0

        if s_list[right] < s_list[right + 1]:
            right += 1
        else:
            if s_list[right] > s_list[right + 1]:
                cnt = 1
                l = right - 1
                r = right + 1
            else:
                cnt = 0
                l = right

            r = right + 1

            while l >= left and r < len(s_list):
                if s_list[l] == s_list[r]:
                    cnt += 2
                    l -= 1
                    r += 1
                else:
                    break
            answer = max(answer, cnt)

            right += 1
            left = right
            right = right

    print(answer)
