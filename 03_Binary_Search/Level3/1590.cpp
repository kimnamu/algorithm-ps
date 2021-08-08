// 캠프가는 영식
// https://www.acmicpc.net/problem/1590
// 힌트
// 1. 버스의 모든 시간을 입력하여 정렬한다.
// 2. 정렬된 버스를 기준으로 영식이의 도착시간이 가장 빠른 시간보다 빠르거나 가장 늦은 시간보다 늦으면 brute force로 구하고,
//    중간에 있을 경우 binary search로 도착시간과 같거나, 늦은 시간중 가장 이른 시간을 구해서 도착시간에서 빼준다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int N, T;
typedef long long ll;
vector<ll> times;

ll bs(){
    if(times[times.size()-1]<T) return -1;
    if(times[0]>=T) return times[0] - T;

    ll l = 0;
    ll r = times.size()-1;
    ll m = (l+r)/2;
    while(l<r){
        m = (l+r)/2;
        if(times[m] == T){
            return 0;
        }else if(times[m] > T){
            r = m;
        }else{
            l = m + 1;
        }
    }
    return times[r] - T;
}

int main()
{
    cin >> N >> T;
    for (int i = 0; i < N; i++)
    {
        ll start, gap, num;
        cin >> start >> gap >> num;
        for (int j = 0; j < num; j++)
        {
            times.push_back(gap * j + start);
        }
    }
    sort(times.begin(), times.end());
    ll answer = bs();
    cout << answer << endl;
    return 0;
}