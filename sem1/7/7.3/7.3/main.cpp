#include <iostream>

#include <string.h>

#include <fstream>

#include "ArithmeticTree.hpp"

using namespace std;

void inputFile(char *line, ifstream &input)
{
    int count = 0;
    char sign = 'a';
    
    while(!input.eof())
    {
        input.get(sign);
        if (sign != '\n')
        {
            line[count] = sign;
            count++;
        }
    }
}

void printLine(char line[])
{
    for (int i = 0; i < strlen(line); i++)
    {
        cout << line[i];
    }
    cout << endl;
}

int power (int degree)
{
    int number = 1;
    
    for (int i = 1; i < degree; i++)
    {
        number = number * 10;
    }
    
    return number;
}

int whatNumber (char *number, int length)
{
    int answer = 0;
    int tenInPower = power(length);
    
    for (int i = 1; i <= length; i++)
    {
        answer = answer + (number[i] - '0') * tenInPower;
        tenInPower = tenInPower / 10;
    }
    
    return answer;
}

int TypeOfSign (char sign)
{
    switch (sign)
    {
        case '(':
        case ')':
        case ' ':
            return 1;
        case '*':
        case '/':
        case '+':
        case '-':
            return 2;
    }
    
    return 0;
}

int main()
{
    int number = 0;
    int answer = 0;
    int index = 0;
    int count = 0;
    char sign = 'a';
    const int maxLength = 10000;
    char *line = new char[maxLength];
    char *digits = new char[maxLength];
    ifstream input("input.txt");
    ArithmeticTree *tree = createTree();

    inputFile(line, input);
    int length = strlen(line);
    
    while (index != length)
    {
        sign = line[index];
        if (TypeOfSign(sign) == 2)
        {
            addSign(tree, sign);
        }
        
        else if (TypeOfSign(sign) != 1)
        {
            while (TypeOfSign(sign) != 1)
            {
                index++;
                count++;
                digits[count] = sign;
                sign = line[index];
            }
            number = whatNumber(digits, count);
            addNumber(tree, number);
            count = 0;
        }
        
        index++;
    }
    
    answer = calculate(tree);
    cout << "Expression : ";
    printLine(line);
    cout << "Aswer : " << answer;
    delete[] digits;
    delete[] line;
    deleteTree(tree);
    input.close();
    return 0;
}
