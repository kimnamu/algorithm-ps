// 사냥꾼
// https://www.acmicpc.net/problem/8983
// 힌트
// 1. 동물을 기준으로 사냥 가능한 범위에 사로가 있는지 이분 탐색으로 구하면 된다.
// 2. 사냥 가능한 범위는 L값을 기준으로 동물의 위치로 부터 가장 멀리 떨어 질 수 있는 lower와 upper를 구한다.
// 3. 각각의 동물에 대해 lower와 upper를 지정 후, 가능한 사로가 있는지 이분 탐색 한다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
    int M, N, L, x, y, answer = 0;
    cin >> M >> N >> L;
    vector<int> v(M);
    for (int i = 0; i < M; i++)
    {
        cin >> v[i];
    }
    sort(v.begin(), v.end());
    for (int i = 0; i < N; i++)
    {
        cin >> x >> y;
        if (y > L)
            continue;
        int upper = x + (L - y), lower = x - (L - y);
        int left = 0, right = v.size() - 1;
        while (left <= right)
        {
            int mid = (left + right) / 2;
            if (lower <= v[mid] && v[mid] <= upper)
            {
                answer++;
                break;
            }
            else if (v[mid] < lower)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
    }
    cout << answer << endl;
}
