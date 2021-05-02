// ATM
// https://www.acmicpc.net/problem/11399
// 힌트
// 1. 대기시간이 짧은 사람이 먼저 ATM기를 이용할 수록 뒷사람들의 누적 대기시간이 짧아진다.
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int N;
    cin >> N;
    vector<int> P(N);
    for (int i = 0; i < N; i++)
    {
        cin >> P[i];
    }
    sort(P.begin(), P.end());
    int answer = P[0];
    for (int i = 1; i < N; i++)
    {
        // 1. 누적 대기시간
        P[i] = P[i - 1] + P[i];
        // 2. 누적 대기시간의 합
        answer += P[i];
    }
    cout << answer << endl;
    return 0;
}