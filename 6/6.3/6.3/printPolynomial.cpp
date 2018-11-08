#include <iostream>

#include "printPolynomial.hpp"

using namespace std;

int countLengthOfNumber(int number)
{
    int length = 0;
    while (number != 0)
    {
        number = number / 10;
        length++;
    }
    return length;
}

void printFirstPower(int *lengthOfNumbers, int coefficients[], int *power, bool *thisIsFirstPrint)
{
    if (coefficients[0] > 0)
    {
        (*thisIsFirstPrint) = false;
        if (coefficients[0] == 1){
            cout << ' ';
        }
        else{
            for (int j = 0; j < (lengthOfNumbers[0] + 1); j++){
                cout << ' ';
            }
        }
        cout << *power;
    }
    else if (coefficients[0] < 0)
    {
        (*thisIsFirstPrint) = false;
        if (coefficients[0] == -1){
            cout << "  ";
        }
        else{
            for (int j = 0; j < (lengthOfNumbers[0] + 2); j++){
                cout << ' ';
            }
        }
        cout << *power;
    }
    
    (*power)--;
}

void printPower(int *lengthOfNumbers, int *coefficients, int *power, int length, bool *thisIsFirstPrint)
{
    for (int i = 1; i < length - 1; i++)
    {
        cin >> coefficients[i];
        lengthOfNumbers[i] = countLengthOfNumber(coefficients[i]);
        
        if (coefficients[i] != 0 && power != 0){
            if (coefficients[i] != 1 && coefficients[i] != -1)
            {
                if (*thisIsFirstPrint)
                {
                    (*thisIsFirstPrint) = false;
                    
                    if (coefficients[i] > 0){
                        for (int j = 0; j < (lengthOfNumbers[i]+1); j++){
                            cout << ' ';
                        }
                    }
                    else{
                        for (int j = 0; j < (lengthOfNumbers[i]+2); j++){
                            cout << ' ';
                        }
                    }
                    cout << *power;
                    
                }
                else
                {
                    for (int j = 0; j < (lengthOfNumbers[i]+3); j++){
                        cout << ' ';
                    }
                    cout << *power;
                    
                }
                
            }
            else{
                cout << "   ";
                cout << *power;
                
            }
        }
        
        (*power)--;
    }
    
    cin >> coefficients[length - 1];
    lengthOfNumbers[length - 1] = countLengthOfNumber(coefficients[length - 1]);
    cout << endl;
}

void printFirstCofficient(int *lengthOfNumbers, int *coefficients, bool *itFirstPrinted, int length)
{
    int lengthOfPower = countLengthOfNumber(length - 1);
    
    if (coefficients[0] < 0){
        *itFirstPrinted = false;
        if (coefficients[0] == -1){
            cout << "-x";
        }
        else{
            cout << '-' << coefficients[0] * (-1) << 'x';
        }
    }
    else if (coefficients[0] > 0){
        *itFirstPrinted = false;
        if (coefficients[0] == 1){
            cout << 'x';
        }
        else{
            cout << coefficients[0] << 'x';
        }
    }
    
    for (int i = 0; i < lengthOfPower; i++)
    {
        cout << ' ';
    }
}

void printCoefficients(int *lengthOfNumbers, int *coefficients, int length, bool *thisIsFirstPrint)
{
    int power = length - 1;
    int lengthOfPower = 0;
    for (int i = 1; i < length - 1; i++)
    {
        if (coefficients[i] > 0){
            lengthOfPower = countLengthOfNumber(power - 1);
            if (*thisIsFirstPrint){
                if (coefficients[i] == 1){
                    cout << 'x';
                }
                else{
                    *thisIsFirstPrint = false;
                    cout << coefficients[i] << 'x';
                }
            }
            else{
                if (coefficients[i] == 1){
                    cout << "+ x";
                }
                else{
                    cout<< "+ " << coefficients[i] << 'x';
                }
            }
        }
        else if (coefficients[i] < 0){
            lengthOfPower = countLengthOfNumber(power - 1);
            if (*thisIsFirstPrint){
                *thisIsFirstPrint = false;
                if (coefficients[i] == -1){
                    cout << "-x";
                }
                else{
                    *thisIsFirstPrint = false;
                    cout << '-' << coefficients[i] * (-1) << 'x';
                }
            }
            else{
                if (coefficients[i] == -1){
                    cout << "- x";
                }
                else{
                    cout << "- " << coefficients[i] * (-1) << 'x';
                    
                }
            }
        }
        if (coefficients[i] != 0){
            for (int j = 0; j < lengthOfPower ; j++){
                cout << ' ';
            }
        }
        
        power--;
    }
    
    if (coefficients[length - 1] > 0){
        cout << "+ " << coefficients[length - 1];
    }
    else if (coefficients[length - 1] < 0){
        cout << "- " << coefficients[length - 1] * (-1);
    }
}
