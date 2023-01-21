// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// BABBA
// https://www.acmicpc.net/problem/9625
// 힌트
// 1. Bottom-Up 방식의 다이나믹 프로그래밍을 이용하여 이전 상태에서 다음 상태를 갱신하여 O(N)안에 풀 수 있다.
#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int K;
    cin >> K;
    int A = 1, B =0 ;
    while(K--){
        int A_new = B;
        int B_new = A + B;
        A = A_new;
        B = B_new;
    }
    cout << A << " " << B <<endl;
    return 0;
}