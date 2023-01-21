// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 보물
// https://www.acmicpc.net/problem/1026
// 힌트
// 1. B의 순서가 바뀌지 않는다는 조건이 있지만 B에 맞춰 A를 출력하거나 하는 것이 아니기때문에 A, B 값들의 순서는 신경써줄 필요가 없다.
// 2. B의 가장 작은 수부터 A의 가장 큰 수가 곱해지도록 하면 전체 합이 가장 작아진다.
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int N; 
    cin >> N;
    vector<int> A(N),B(N);
    for(int i = 0 ; i< N; i++){
        cin >> A[i];
    }
    for(int i = 0 ; i< N; i++){
        cin >> B[i];
    }
    sort(A.begin(), A.end());
    sort(B.begin(), B.end(), greater<int>());
    int S = 0;
    for(int i = 0 ; i< N; i++){
        S += A[i] * B[i];
    }
    cout << S << endl;
    return 0;
}
