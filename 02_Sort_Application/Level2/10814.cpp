// 나이순 정렬
// https://www.acmicpc.net/problem/10814
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

typedef tuple<int, int, string> tiis;

bool cmp(tiis a, tiis b)
{
    // 1. 나이가 다르다면 나이순으로 정렬
    if (get<1>(a) != get<1>(b))
    {
        return get<1>(a) < get<1>(b);
    }
    // 2. 나이가 같다면 등록순으로 정렬
    return get<0>(a) < get<0>(b);
}

int main()
{
    int n;
    cin >> n;
    vector<tiis> v(n);
    // 3가지 정보 (등록순, 나이, 이름)이 입력된 배열을 이용해서 순서 정렬
    for (int i = 0; i < n; i++)
    {
        get<0>(v[i]) = i;
        cin >> get<1>(v[i]) >> get<2>(v[i]);
    }
    sort(v.begin(), v.end(), cmp);
    for (int i = 0; i < v.size(); i++)
    {
        cout << get<1>(v[i]) << " " << get<2>(v[i]) << "\n";
    }
    return 0;
}