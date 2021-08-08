// 좌표 압축
// https://www.acmicpc.net/problem/18870
// 힌트
// 1.X원 소 중 중복을 제외하고 오름차순으로 정렬된 새로운 vector를 구한다.
// 2. 이 vector값의 작은 수부터 0부터 시작하는 좌표 값을 mapping 해준다.
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

int main()
{
    int N;
    cin >> N;

    vector<int> X(N);
    for (int i = 0; i < N; i++)
    {
        cin >> X[i];
    }
    vector<int> X2 = X;

    sort(X2.begin(), X2.end());
    X2.erase(unique(X2.begin(), X2.end()), X2.end());
    map<int, int> m;

    for (int i = 0; i < X2.size(); i++)
    {
        m[X2[i]] = i;
    }
    for (int i = 0; i < N; i++)
    {
        cout << m[X[i]] << " ";
    }
    return 0;
}
