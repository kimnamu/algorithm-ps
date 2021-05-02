// 체스판 다시 칠하기
// https://www.acmicpc.net/problem/1018
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
    int N, M;
    string s;
    cin >> N >> M;
    //1. 입력받기, W는 0, B는 1로 저장
    vector<vector<int> > table(N, vector<int>(M, 0));
    for (int i = 0; i < N; i++)
    {
        cin >> s;
        for (int j = 0; j < M; j++)
        {
            if (s[j] == 'W')
                table[i][j] = 0;
            else
                table[i][j] = 1;
        }
    }
    int answer = 8 * 8;
    for (int i = 0; i + 7 < N; i++)
    {
        for (int j = 0; j + 7 < M; j++)
        {
            int BW = 0;
            int WB = 0;
            for (int ki = 0; ki < 8; ki++)
            {
                for (int kj = 0; kj < 8; kj++)
                {
                    // BW로 시작하는 체스판과의 차이 계산
                    if ((ki + kj) % 2 == 0 && table[i + ki][j + kj] != 1)
                    {
                        BW += 1;
                    }
                    else if ((ki + kj) % 2 == 1 && table[i + ki][j + kj] != 0)
                    {
                        BW += 1;
                    }
                    // // WB로 시작하는 체스판과의 차이 계산 (BW의 반대값으로 계산)
                    WB = 64 - BW;
                }
            }
            answer = min(answer, BW);
            answer = min(answer, WB);
        }
    }
    cout << answer << endl;
    return 0;
}