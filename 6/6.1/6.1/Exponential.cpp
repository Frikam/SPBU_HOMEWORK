#include <iostream>

#include <iomanip>

#include "Exponential.hpp"

using namespace std;

void printSign(double number)
{
    long long firstNumber = 0b10000000;
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
    long long firstNumber = 0b00111111;
    long long secondNumber = 0b11110000;

    ((char*)&number)[7] = firstNumber;
    ((char*)&number)[6] = ((char*)&number)[6] | secondNumber;
    
    cout << setprecision(15) << number;
}

void printExponential(double number)
{
    long long firstNumber = 0b01111111;
    long long secondNumber = 0b11110000;
    long long thirdNumber = 0b1111111111;
    
    char *binForm = (char*)&number;
    
    cout << " * 2^(" << (((binForm[7] & firstNumber) << 4) | ((binForm[6] & secondNumber) >> 4)) - thirdNumber << ')';
}
