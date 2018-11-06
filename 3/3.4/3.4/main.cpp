#include <iostream>

using namespace std;

int bullsAndCows(int number[], int randnumb[], int numbOfDigits)
{
    int bulls = 0;
    int cows = 0;
    
    for (int i = 0; i < numbOfDigits; i++)
    {
        for (int j = 0; j < numbOfDigits; j++)
        {
            if (number[i] == randnumb[j])
            {
                if (i == j)
                {
                    bulls++;
                }
                else
                {
                    cows++;
                }
            }
        }
    }
    
    if (bulls == 4)
    {
        cout << "Congratulations you guessed the number!!!!!!";
    }
    else
    {
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
        replace = (powerOfNumb(10,(numbOfDigits - i - 1)));
        number[i] = digits / replace;
        digits = digits % replace;
    }
}

bool isDifferent(int *randnumber, int numbOfDigits, int number)
{
    int count = 0;
    for (int i = 0; i < numbOfDigits; i++)
    {
        if (number == randnumber[i]){
            count++;
        }
    }
    return (count == 1);
}

void randomNumber(int *randnumber, int numbOfDigits)
{
    int count = 0;
    while (count != numbOfDigits)
    {
        count = 0;
        for (int i = 0; i < numbOfDigits; i++)
        {
            randnumber[i] = (rand() % 10);
        }
        
        for (int i = 0; i < numbOfDigits; i++)
        {
            if (isDifferent(randnumber, numbOfDigits, randnumber[i])){
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

    int randnumber[numbOfDigits];
    randomNumber(randnumber, numbOfDigits);
    cout << randnumber[0] << randnumber[1] << randnumber[2] << randnumber[3] << endl;
    int number[numbOfDigits];
    int bulls = 0;
    
    while(bulls != 4)
    {
        cout << "Enter your number : ";
        enterNumb(number, numbOfDigits);
        bulls = bullsAndCows(number, randnumber, numbOfDigits);
    }
    return 0;
}
