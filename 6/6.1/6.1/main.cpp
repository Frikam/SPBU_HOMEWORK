#include <iostream>

#include "Exponential.hpp"

using namespace std;

int main()
{
    cout << "Enter number: ";
    double number = 0;
    cin >> number;
    
    cout << "Answer : ";
    
    if (number == 0)
    {
        cout << 0;
    }
    else
    {
        printSign(number);
        printMantissa(number);
        printExponential(number);
    }
    return 0;
}
