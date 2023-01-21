// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 귀여운 라이언
// https://www.acmicpc.net/problem/15565
// 힌트
// 1. K개의 1을 포함하는 배열의 길이가 최소가 뙬때를 찾으면 된다.
// 2. 투 포인터를 이용하여 1의 갯수가 K개보다 작으면 오른쪽 포인터를 키워주고,
//    K보다 크면 오니쪽 포인터를 키워 준다.
// 3. 어떤 경우도 K개의 1을 포함하지 못할 경우 -1을 반환한다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
    int N, K;
    cin >> N >> K;
    vector<int> v(N);
    for (int i = 0; i < N; i++)
    {
        cin >> v[i];
    }
    int left = 0;
    int right = 0;
    int cnt = 0;
    // N개 보다 큰 배열의 크기를 가질 수없으므로 anser를 N=1로 초기화해준다.
    int answer = N + 1;

    if (v[0] == 1)
        cnt += 1;

    while (right <= N)
    {
        if (cnt == K)
        {
            answer = min(answer, right - left + 1);
            if (v[left] == 1)
                cnt -= 1;
            left += 1;
        }
        else if (cnt < K)
        {
            right += 1;
            if (v[right] == 1)
                cnt += 1;
        }
        else
        {
            if (v[left] == 1)
                cnt -= 1;
            left += 1;
        }
    }
    if (answer == N + 1)
        cout << -1 << endl;
    else
        cout << answer << endl;
    return 0;
}