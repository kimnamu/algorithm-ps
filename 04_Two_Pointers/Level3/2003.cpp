// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 수들의 합 2
// https://www.acmicpc.net/problem/2003
// 힌트
// 1. 투 포인터를 이용하여 부분합의 왼쪽 위치와 오른쪽 위치를 조정해가면서 부분합을 계산한다.
// 1.1 부분합이 M보다 작으면 왼쪽 포인터 위치의 배열 값을 빼주고 오른쪽으로 한칸 옮겨준다.
// 1.2 부분합이 M보다 크면 오른쪽 포인터를 한칸 오른쪽으로 옮겨준 후 해당 값을 더해준다.
// 1.3 부분합이 M이면 count를 하나 늘려주고, 왼쪽 포인터 위치의 배열 값을 빼주고 오른쪽으로 한칸 옮겨준다.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef long long ll;

int main(){
    int N;
    ll M;
    cin >> N >> M;
    vector<ll> v(N);
    for(int i = 0 ; i < N; i++){
        cin >> v[i];
    }
    int left = 0;
    int right = 0;
    int sum = v[0];
    int answer = 0;
    while(right < N){
        if(sum==M){
            answer += 1;
            right += 1;
            sum += v[right];
        }
        else if(sum < M){
            right += 1;
            sum += v[right];
        }else{
            sum -= v[left];
            left += 1;
        }
    }
    cout << answer << endl;
    return 0;
}