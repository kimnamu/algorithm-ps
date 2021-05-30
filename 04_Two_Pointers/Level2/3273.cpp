// 두 수의 합
// https://www.acmicpc.net/problem/3273
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    int n, x;
    cin >> n;
    vector<int> v(n);
    for(int i = 0 ; i< n; i++){
        cin >> v[i];
    }
    cin >> x;
    sort(v.begin(), v.end());
    int left = 0;
    int right = n-1;
    int answer = 0;
    while(left < right){
        if(v[left]+v[right]==x){
            answer += 1;
            left += 1;
        }else if(v[left]+v[right]>x){
            right -= 1;
        }else{
            left += 1;
        }
    }
    cout << answer << endl;
    return 0;
}