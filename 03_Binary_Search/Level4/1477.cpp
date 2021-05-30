// 휴게소 세우기
// https://www.acmicpc.net/problem/1477
// 힌트
// 1. 휴게소와 휴게소 사이에 새로운 휴게소를 설치할때, 새로운 휴게소 기준으로 왼쪽 휴게소로 부터 "얼마 만큼 떨어진 휴게소"를 지을지 거리를 정하고,
//    그 거리로 설치하게 되면 "총 몇 개의 휴게소룰 새로설치"하게 되는지 계산을해서, 새로 설치하는 휴게소가 제한된 개수보다 적거나 같으면 더 작은 간격으로 설치가 가능하다.
//    반대로 새로 설치하는 휴게소 개수가 제한된 개수보다 많으면 더 멀리 떨어지게 휴게소를 만들 수 있다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int n, m;
int length, temp;

vector<int> v;

bool solve(int distance)
{
    int cnt = 0;
    for (int i = 0; i < v.size() - 1; i++)
    {
        int d = v[i + 1] - v[i];
        int temp;
        if (d / distance > 0)
        {
            // 휴게소간의 거리가 새로 설치한 distance로 나누었을때 딱 나눠떨어지면,
            // 나눈값에 -1개 한 수만큼 설치가 가능하다.
            if (d % distance == 0)
                temp = (d / distance) - 1;
            else
                temp = (d / distance);
            cnt += temp;
        }
    }
    if (cnt <= m)
        return true;
    return false;
}

int bs()
{
    int l = 0;
    int r = length;
    int mid;
    while (l <= r)
    {
        mid = (r + l) / 2;
        if (solve(mid))
        {
            r = mid - 1;
        }
        else
            l = mid + 1;
    }
    return r + 1;
}

int main()
{
    cin >> n >> m >> length;
    v.push_back(0);
    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        v.push_back(temp);
    }
    v.push_back(length);
    sort(v.begin(), v.end());

    int answer = bs();

    cout << answer;
    return 0;
}