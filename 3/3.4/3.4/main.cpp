#include <iostream>

using namespace std;

int bullsAndCows(int number[], int randomNumber[], int numbOfDigits)
{
    int bulls = 0;
    int cows = 0;
    
    for (int i = 0; i < numbOfDigits; i++)
    {
        for (int j = 0; j < numbOfDigits; j++)
        {
            if (number[i] == randomNumber[j])
            {
                if (i == j){
                    bulls++;
                }
                else{
                    cows++;
                }
            }
        }
    }
    
    if (bulls == 4){
        cout << "Congratulations you guessed the number!!!!!!";
    }
    else{
        cout << "Quantity Of Cows :" << cows << endl << "Quantity Of bulls :" << bulls << endl;
    }
    
    return bulls;
    
}

int powerOfNumb(int number, int power)
{
    int counter = 1;
    
    for (int i = 0; i < power; i++)
    {
        counter = counter * 10;
    }
    
    return counter;
}

void enterNumb(int *number, int numbOfDigits)
{
    int digits = 0;
    cin >> digits;
    int replace = 0;
    
    for (int i = 0; i < numbOfDigits; i++)
    {
        replace = (powerOfNumb(10, (numbOfDigits - i - 1)));
        number[i] = digits / replace;
        digits = digits % replace;
    }
}

bool isDifferent(int *randomNumber, int numbOfDigits, int number)
{
    int count = 0;
    for (int i = 0; i < numbOfDigits; i++)
    {
        if (number == randomNumber[i]){
            count++;
        }
    }
    return (count == 1);
}

void makeRandomNumber(int *randomNumber, int numbOfDigits)
{
    int count = 0;
    while (count != numbOfDigits)
    {
        count = 0;
        for (int i = 0; i < numbOfDigits; i++)
        {
            randomNumber[i] = (rand() % 10);
        }
        
        for (int i = 0; i < numbOfDigits; i++)
        {
            if (isDifferent(randomNumber, numbOfDigits, randomNumber[i])){
                count++;
            }
        }
    }
}

int main()
{
    srand(time(0));
    cout << "Computer made a number, try to guess it" << endl;
    const int numbOfDigits = 4;
    int randomNumber[numbOfDigits];
    makeRandomNumber(randomNumber, numbOfDigits);
    cout << randomNumber[0] << randomNumber[1] << randomNumber[2] << randomNumber[3] << endl;
    int number[numbOfDigits];
    int bulls = 0;
    
    while (bulls != 4)
    {
        cout << "Enter your number : ";
        enterNumb(number, numbOfDigits);
        bulls = bullsAndCows(number, randomNumber, numbOfDigits);
    }
    return 0;
}
