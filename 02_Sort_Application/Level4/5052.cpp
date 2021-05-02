// 전화번호 목록
// https://www.acmicpc.net/problem/5052
// 힌트
// 1. 전화번호 목록을 문자열 형식으로 받아서 문자열 순서대로 정렬
// 2. 문자열 순서대로 정렬되어 있으므로 현재 번호와 다음 번호만 비교하면 가능
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main(){
    int t, n;
    cin >> t;
    while(t--){
        bool answer = true;
        cin >> n;
        vector<string> v(n);
        for(int i = 0 ; i < n; i++){
            cin >> v[i];
        }
        sort(v.begin(), v.end());
        for(int i = 0; i < n-1; i++){
            int size = min(v[i].size(), v[i+1].size());
            if(v[i].substr(0, size)==v[i+1].substr(0, size)){
                answer = false;
                break;
            }
        }
        if(answer)
            cout << "YES\n";
        else
            cout << "NO\n";
    }
    return 0;
}