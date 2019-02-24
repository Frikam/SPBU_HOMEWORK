#include <iostream>

#include "printPolynomial.hpp"

using namespace std;

int main()
{
    cout << "The program outputs a polynomial with given coefficients" << endl;
    cout << "Enter number of coefficients : ";
    int length = 0;
    cin >> length;
    int power = length - 1;
    bool thisIsFirstPrint = true;
    int *coefficients = new int[length];
    int *lengthOfNumbers = new int[length];
    cin >> coefficients[0];
    lengthOfNumbers[0] = countLengthOfNumber(coefficients[0]);
    
    printFirstPower(lengthOfNumbers, coefficients, &power, &thisIsFirstPrint);
    
    printPower(lengthOfNumbers, coefficients, &power, length, &thisIsFirstPrint);

    thisIsFirstPrint = true;
    
    printFirstCofficient(lengthOfNumbers, coefficients, &thisIsFirstPrint, length);
    
    printCoefficients(lengthOfNumbers, coefficients, length, &thisIsFirstPrint);

    delete[] coefficients;
    delete[] lengthOfNumbers;
    return 0;
}
