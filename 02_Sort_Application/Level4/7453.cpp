// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 합이 0인 네 정수
// https://www.acmicpc.net/problem/7453
// 힌트
// 1. 4중 for문을 쓰게되면 시간초과
// 2. 2중 for문을 통해 A+B의 덧셈 집합(AB)과 C+D의 덧셈 집합(CD)을 각각 만들어줌
// 3. AB 수열 값 * -1 값이 CD 수열에 있는지 Binary Search
// 4. 이때 AB와 CD값이 유니크하지 않기 때문에 값이 여러개 일 수 있고 이를 찾는데 오래 걸리므로 
//    map을 이용해서 dynamic programming 해줌

#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

typedef long long ll;
vector<ll> ab, cd;
map<ll, ll> m;

ll getSameValue(ll index){
    if(m.find(index)!=m.end()) return m[index];
    ll ret = 0;
    for(int i = index; i < cd.size(); i++){
        if(cd[i]==cd[index]) ret += 1;
        else break;
    }
    for(int i = index-1; i >= 0; i--){
        if(cd[i]==cd[index]) ret += 1;
        else break;
    }
    m[index] = ret;
    return ret;
}

ll binarySearch(ll k){
    int l = 0;
    int r = cd.size();
    int m = 0;
    while(true){
        if(m==(l+r)/2) {
            return 0; 
        }
        m = (l+r)/2;
        if(cd[m] == k) break;
        else if(cd[m] < k){
            l = m + 1;
        }else{
            r = m - 1;
        }
    }
    return getSameValue(m);
}

int main(){
    int n;
    cin >> n;
    vector<ll> a(n), b(n), c(n), d(n);
    for(int i = 0 ; i < n; i++){
        cin >> a[i] >> b[i] >> c[i] >> d[i];
    }
    ab = vector<ll>(n*n);
    cd = vector<ll>(n*n);
    for(int i = 0 ; i < n; i++){
        for(int j=0; j < n; j++){
            ab[i*n+j] = a[i]+b[j];
            cd[i*n+j] = c[i]+d[j];
        }
    }
    sort(ab.begin(), ab.end());
    sort(cd.begin(), cd.end());
    ll answer = 0;
    for(int i = 0 ; i< ab.size(); i++){
        answer += binarySearch(-ab[i]);
    }
    cout << answer << "\n";
    return 0;
}