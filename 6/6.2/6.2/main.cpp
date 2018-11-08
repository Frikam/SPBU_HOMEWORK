#include <iostream>

using namespace std;

int isNegative(int *number)
{
    if ((*number) > 0){
        return 0;
    }
    else{
        (*number) = (*number) * -1;
        return 1;
    }
}

void binPresentation(int *binNumber, int number, int maxLength)
{
    int count = 0;
    int maxNumber = 128;
    
    for (int i = 1; i < maxNumber; i = i * 2)
    {
        if (number & i){
            binNumber[maxLength - 1 - count] = 1;
        }
        else{
            binNumber[maxLength - 1 - count] = 0;
        }
        count++;
    }
}

void printBinNumber(int binNumber[], int maxLength)
{
    for (int i = 0; i < maxLength; i++)
    {
        cout << binNumber[i];
    }
}

void sum(int *firstNumb, int *secondNumb, int *answer, int maxLength)
{
    int memory = 0;
    for (int i = maxLength - 1; i >= 0; i--)
    {
        if (memory == 0)
        {
            if (firstNumb[i] + secondNumb[i] == 2)
            {
                memory = 1;
                answer[i] = 0;
            }
            else{
                answer[i] = firstNumb[i] + secondNumb[i];
            }
        }
        else{
            if (firstNumb[i] + secondNumb[i] == 2)
            {
                memory = 1;
                answer[i] = 1;
            }
            else{
                if (firstNumb[i] + secondNumb[i] == 1){
                    answer[i] = 0;
                    memory = 1;
                }
                else{
                    answer[i] = 1;
                    memory = 0;
                }
            }
        }
    }
}

void makeAdditionalCode(int *binNumber, int *binPresentationOfOne, int maxLength)
{
    for (int i = 1; i < maxLength; i++)
    {
        if (binNumber[i] == 1){
            binNumber[i] = 0;
        }
        else{
            binNumber[i] = 1;
        }
    }
    sum(binNumber, binPresentationOfOne, binNumber, maxLength);
}

void fromBinToDecimal(int binNumber[], int maxLength)
{
    int answer = 0;
    int powerOfTwo = 1;
    
    for (int i = maxLength - 1; i >= 1; i--)
    {
        answer = powerOfTwo * binNumber[i] + answer;
        powerOfTwo = powerOfTwo * 2;
    }

    cout << answer;
}

int main()
{
    bool IsThereNegativeNumber = false;
    const int maxLength = 8;
    int binPresentationOfOne[maxLength];
    binPresentation(binPresentationOfOne, 1, maxLength);
    int answer[maxLength];
    cout << "The program sums two numbers and outputs them in binary form" << endl;
    cout << "Enter first number : ";
    int firstNumber = 0;
    cin >> firstNumber;
    int binPresentationOfFirstNumber[maxLength];
    binPresentationOfFirstNumber[0] = isNegative(&firstNumber);
    binPresentation(binPresentationOfFirstNumber, firstNumber, maxLength);
    
    cout << "Enter second number : ";
    int secondNumber = 0;
    cin >> secondNumber;
    int binPresentationOfSecondNumber[maxLength];
    binPresentationOfSecondNumber[0] = isNegative(&secondNumber);
    binPresentation(binPresentationOfSecondNumber, secondNumber, maxLength);

    cout << "Binary representation of first number : ";
    printBinNumber(binPresentationOfFirstNumber, maxLength);
    
    cout << endl << "Binary representation of second number : ";
    printBinNumber(binPresentationOfSecondNumber, maxLength);

    if (binPresentationOfFirstNumber[0] == 1){
        IsThereNegativeNumber = true;
        makeAdditionalCode(binPresentationOfFirstNumber, binPresentationOfOne, maxLength);
    }
    if (binPresentationOfSecondNumber[0] == 1){
        IsThereNegativeNumber = true;
        makeAdditionalCode(binPresentationOfSecondNumber, binPresentationOfOne, maxLength);
    }
    
    sum(binPresentationOfFirstNumber, binPresentationOfSecondNumber, answer, maxLength);

    if ((binPresentationOfFirstNumber[0] == 1 && binPresentationOfSecondNumber[0] == 0 && firstNumber < secondNumber)||(binPresentationOfFirstNumber[0] == 0 && binPresentationOfSecondNumber[0] == 1 && firstNumber > secondNumber)){
        cout << endl << "Binary representation answer : ";
        printBinNumber(answer, maxLength);
        cout << endl << "Sum : ";
        fromBinToDecimal(answer, maxLength);
    }
    else if (binPresentationOfSecondNumber[0] == 1 || binPresentationOfFirstNumber[0] == 1 ){
        makeAdditionalCode(answer, binPresentationOfOne, maxLength);
        cout << endl << "Binary representation answer : ";
        printBinNumber(answer, maxLength);
        cout << endl << "Sum : ";
        cout << '-';
        fromBinToDecimal(answer, maxLength);
    }
    else{
        cout << endl << "Binary representation answer : ";
        printBinNumber(answer, maxLength);
        cout << endl << "Sum : ";
        fromBinToDecimal(answer, maxLength);
    }
    return 0;
}
