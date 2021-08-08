// 보물
// https://www.acmicpc.net/problem/11004
// 힌트
// 1. 정렬 후 K-1 인자를 반환해주면 된다.
// * cpp의 경우 cin.tie(NULL); ios_base::sync_with_stdio(false);를 작성해주지 않으면 시간 초과발생
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int N, K;
    cin >> N >> K;
    vector<int> A(N);
    for (int i = 0; i < N; i++)
    {
        cin >> A[i];
    }
    sort(A.begin(), A.end());
    cout << A[K - 1] << "\n";
    return 0;
}
