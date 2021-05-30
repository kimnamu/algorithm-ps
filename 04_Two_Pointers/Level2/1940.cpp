// 주몽
// https://www.acmicpc.net/problem/1940
// 힌트
// 1. 번호들이 고유한 값을 가지므로 M을 만드는 수 중에서 중복되는 수가 없다.
// 2. 투 포인터를 이용해 하나는 갑이 가장 작은값부터 올라가면서, 다른 하나는 값이 가장 큰 값부터 내려가면서 합이 M 이되는 쌍을 찾으면된다.
// 3. 합이 M보다 작다면 작은 값을 하나 더 큰값으로 올려주고, 합이 M보다 작다면 큰값을 하나더 작은 값으로 내려주면 된다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
    int N, M;
    cin >> N >> M;
    vector<int> v(N);
    for (int i = 0; i < N; i++)
    {
        cin >> v[i];
    }
    sort(v.begin(), v.end());
    int index1 = 0, index2 = N - 1;
    int answer = 0;
    while (index1 < index2)
    {
        if (v[index1] + v[index2] == M)
        {
            answer += 1;
            // 이때 index1 += 1 대신 index2 -= 1을 해주어도 된다.
            index1 += 1;
        }
        else if (v[index1] + v[index2] < M)
        {
            index1 += 1;
        }
        else
        {
            index2 -= 1;
        }
    }
    cout << answer << endl;
    return 0;
}