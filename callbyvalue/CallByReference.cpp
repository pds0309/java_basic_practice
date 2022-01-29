#include <iostream>
using namespace std;

void pluss(int &input) { input += 25; };

int main()
{
    int num = 10;
    pluss(num);
    cout << num;
    return 0;
}
