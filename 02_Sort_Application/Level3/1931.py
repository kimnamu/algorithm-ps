# 회의실 배정
# https://www.acmicpc.net/problem/1931
# 힌트
# 1. 끝나는 시간 순으로 정렬
# 2. 끝나는 시간이 같으면 시작시간이 빠른 순으로 정렬
# 3. 끝나는 순서가 빠른 순으로 예약하면서 예약 가능한 회의만 카운트 해줌.

if __name__ == "__main__":
    N = int(input())

    clist = []
    for _ in range(N):
        clist.append(list(map(int, input().split())))

    clist.sort(key=lambda x:(x[1],x[0]))

    last = 0
    answer = 0
    for item in clist:
        if last <= item[0]:
            last = item[1]
            answer += 1

    print(answer)