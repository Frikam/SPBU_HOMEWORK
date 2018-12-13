#include <iostream>

#include "Exponential.hpp"

using namespace std;

void printSign(double number)
{
    int firstNumber = 0b10000000;
    char *binForm = (char*)&number;
    
    if (binForm[7] & firstNumber)
    {
        cout <<  '-';
        return;
    }
    
    cout << '+';
}

void printMantissa(double number)
{
    int firstNumber = 0b00111111;
    int secondNumber = 0b11110000;

    ((char*)&number)[7] = firstNumber;
    ((char*)&number)[6] = ((char*)&number)[6] | secondNumber;
    
    cout << number;
}

void printExponential(double number)
{
    int firstNumber = 0b01111111;
    int secondNumber = 0b11110000;
    int thirdNumber = 0b1111111111;
    
    char *binForm = (char*)&number;
    
    cout << " * 2^(" << (((binForm[7] & firstNumber) << 4) | ((binForm[6] & secondNumber) >> 4)) - thirdNumber << ')';
}
