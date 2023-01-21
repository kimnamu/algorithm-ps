// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 최소 스패닝 트리
// https://www.acmicpc.net/problem/1197
// 힌트
// 1. 크루스칼 알고리즘을 이용하여 가중치가 낮은 node부터 순차적으로 연결해준다.
// 2. 이미 연결되어 있는 node는 스킵한다. 이미 연결되어 있는지의 체크는 union-find 방식을 이용한다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef pair<int,int> pii;
vector<pair<int, pii> > edges;
vector<int> parent;
int V, E;

int find_parent(int k){
    if(parent[k]==-1){
        parent[k] = k;
        return k;
    }
    if(parent[k]==k) return k;
    return find_parent(parent[k]);
}

void union_edge(int e1, int e2){
    if(parent[e1]==-1 && parent[e2]==-1){
        parent[e1] = e1;
        parent[e2] = e1;
    }else if(parent[e1]==-1){
        parent[e1] = parent[e2];
    }else if(parent[e2]==-1){
        parent[e2] = parent[e1];
    }else{
        int p1 = find_parent(e1);
        parent[p1] = find_parent(e2);
    }

}


bool cmp(pair<int, pii> a, pair<int, pii> b){
    if(a.first==b.first){
        if(a.second.first==b.second.first){
            return a.second.second < b.second.second;
        }else{
            return a.second.first < b.second.first;
        }
    }else{
        return a.first < b.first;
    }
}

int main()
{
    cin >> V >> E;
    parent = vector<int>(V+1, -1);
    for (int i = 0; i < E; i++)
    {
        pii temp;
        int w;
        cin >> temp.first >> temp.second >> w;
        edges.push_back({w, temp});
    }
    sort(edges.begin(), edges.end());

    int answer = 0;
    for(int i = 0; i < E; i++){
        int edge1 = edges[i].second.first;
        int edge2 = edges[i].second.second;
        if(find_parent(edge1)!=find_parent(edge2)|| parent[edge1]==-1 || parent[edge2]==-1){
            union_edge(edge1, edge2);
            answer += edges[i].first;
        }
    }
    cout << answer << endl;
    return 0;
}