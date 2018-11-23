#include <iostream>

using namespace std;

int main()
{
    int firstFibNumber = 1;
    int secondFibNumber = 1;
    int answer = 0;
    int count = 2;
    int index = 0;
    cout << "Enter index of Fibonacci number : ";
    cin >> index;
    
    while (index > count)
    {
        answer = firstFibNumber + secondFibNumber;
        firstFibNumber = secondFibNumber;
        secondFibNumber = answer;
        count ++;
    }
    
    cout << "Fibonacci number : ";
    cout << answer;
    return 0;
}
