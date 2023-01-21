// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 리모컨
// https://www.acmicpc.net/problem/1107
// 힌트
// 1. 리모컨으로 숫자를 먼저 고를때 0부터 누르는 경우는 카운팅하지 않도록 하자.
// 2. 반례 (https://www.acmicpc.net/board/view/46120)
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int N, M;
vector<int> broken(10, true);

//해당 채널을 누르는 것이 가능한지 여부
bool valid(int num)
{
    if (num == 0)
        return broken[0];
    while (num)
    {
        if (broken[num % 10] == false)
            return false;
        num /= 10;
    }
    return true;
}

//누른 채널의 길이
int touch(int num)
{
    //0이면 길이 1(중요한 예외처리)
    if (num == 0)
        return 1;
    int result = 0;
    while (num)
    {
        num /= 10;
        result++;
    }
    return result;
}

//100에서 시작이 아닌 채널을 누르고 나서 +/-
int changeEntirely()
{
    int result = 500000;
    //1000000에서 - 버튼으로 찾아가는 경우를 고려하여.
    for (int i = 0; i <= 1000000; i++)
    {
        //해당 채널을 누를 수 있다면
        if (valid(i))
        {
            int click = touch(i) + abs(N - i);
            if (result > click)
            {
                result = click;
            }
        }
    }
    return result;
}

int main(void)
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int button;
        cin >> button;
        broken[button] = false;
    }
    // +/-로 채널 변경했을때
    int answer = abs(N - 100);

    // 수동 채널 변경 후 +/- 채널 변경했을때
    answer = min(answer, changeEntirely());

    // 정답 출력
    cout << answer << endl;
    return 0;
}