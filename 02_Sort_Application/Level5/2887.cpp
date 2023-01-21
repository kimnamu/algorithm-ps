// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 행성 터널 
// https://www.acmicpc.net/problem/2887
// 힌트
// 1. N이 100,000이기 때문에 모든 행성간의 간선을 구하면 메모리 초과가 된다.
// 2. 각 세 좌표값 차이의 절대값의 최소를 거리로 삼으므로
//    각 좌표값으로 정렬하여 이웃한 간선만을 구하면 3 * (N-1)개의 간선만 구하면 된다.
// 3. 간선의 거리를 오름차순으로 정렬한 뒤 Kruskal 알고리즘으로 최소 스패닝 트리를 구하면 된다.
#include <iostream>
#include <algorithm>
#include <string>
#include <stack>
#include <vector>
#include <queue>
#include <map>

using namespace std;
vector<int> parents;
vector<pair<int, pair<int, int>>> edges;

bool cmp(pair<int, int> a, pair<int, int> b){
    if(a.first==b.first) return a.second < b.second;
    else return a.first < b.first;
}

// 현재 노드 집합에 연결된 최소 idx를 반환
int get_parent(int idx) {
	if (idx != parents[idx]) 
        parents[idx] = get_parent(parents[idx]);
	return parents[idx];
}

// idx1과 idx2를 같은 집합에 속하게 만들어주는 함수
void union_find(int idx1, int idx2) {
	int pdx1 = get_parent(idx1);
	int pdx2 = get_parent(idx2);

	if (pdx1 > pdx2) 
        parents[pdx2] = pdx1;
	else 
        parents[pdx1] = pdx2;
}
int main(){
    int N;
    cin >> N;
    // 사이클을 형성하는 간선을 제외하기 위해 각 노드에 연결된 집합의 최소 index 노드를 가지게 할 parents 생성(기본적으로 다른 노드와 연결되어 있지 않으면 자기 자신의 index를 가짐)
    parents = vector<int> (N);
    vector<pair<int, int>> X(N);
    vector<pair<int, int>> Y(N);
    vector<pair<int, int>> Z(N);
    // 1. 각 행성의 좌표와 index를 저장한다.
	for (int i = 0; i < N; i++) {
		cin >> X[i].first >> Y[i].first >> Z[i].first;
        X[i].second = i;
        Y[i].second = i;
        Z[i].second = i;
		parents[i] = i;
	}

    // 2. x,y,z 각각 좌표별로 정렬한 뒤, 인접한 행성끼리 거리를 구해서 edge에 저장한다.
	sort(X.begin(), X.end(), cmp);
	sort(Y.begin(), Y.end(), cmp);
	sort(Z.begin(), Z.end(), cmp);

	for (int i = 0; i < N - 1; i++) {
		edges.push_back({ abs(X[i + 1].first - X[i].first) , {X[i].second, X[i + 1].second} });
		edges.push_back({ abs(Y[i + 1].first - Y[i].first) , {Y[i].second, Y[i + 1].second} });
		edges.push_back({ abs(Z[i + 1].first - Z[i].first) , {Z[i].second, Z[i + 1].second} });
	}

    // 3. 행성간의 거리를 기준으로 오름차순으로 정렬해준다.
	sort(edges.begin(), edges.end());
	long long answer = 0;
	for (int i = 0; i < edges.size(); i++) {
		int a = edges[i].second.first;
		int b = edges[i].second.second;
		int val = edges[i].first;
        // 5. 두 정점이 같은 집합에 속하는지 판별
		if (get_parent(a) != get_parent(b)) {
            // 두 정점을 같은 집합에 속하게 병합
			union_find(a, b);
			answer += long(val);
		}
	}

	cout << answer;

    return 0;
}