#include <iostream>

using namespace std;

class AA {
    public:
    string name;
    AA(string name) {
        this->name = name;
    }
};

void run(AA *inputAA){
    AA myAA = AA("최번개");
    *inputAA = myAA;
}

int main()
{
    AA aa = AA("김갑환");
    run(&aa);
    cout << aa.name;
    return 0;
}