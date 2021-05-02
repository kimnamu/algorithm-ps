# 콘테스트
# https://www.acmicpc.net/problem/5576

if __name__ == "__main__":
    w, k = [], []
    for i in range(10):
        w.append(int(input()))

    for i in range(10):
        k.append(int(input()))

    w.sort(reverse=True)
    k.sort(reverse=True)

    print(sum(w[:3]), sum(k[:3]))