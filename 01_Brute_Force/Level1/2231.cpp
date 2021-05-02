// 분해합
// https://www.acmicpc.net/problem/2231
#include <iostream>
using namespace std;

// 2. 분해합 계산
int decomposition(int k)
{
    int ret = k;
    while (k)
    {
        ret = ret + k % 10;
        k = k / 10;
    }
    return ret;
}

int main()
{
    int N, M = 0;
    cin >> N;
    // 1. 0 부터 N까지 완전 탐색을 통해 작은 수 부터 분해합이 N과 같아지는 최초의 수 찾기
    for (int i = 0; i < N; i++)
    {
        if (N == decomposition(i))
        {
            M = i;
            break;
        }
    }
    cout << M << endl;
    return 0;
}