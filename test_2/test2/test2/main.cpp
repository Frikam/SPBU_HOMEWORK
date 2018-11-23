#include <iostream>

#include <string.h>

#include <fstream>

using namespace std;

const int maxLength = 10;

int howManyDayInMonth(int month)
{
    int day = 0;
    switch (month)
    {
        case 1:
            day = 31;
            break;
        case 2:
            day = 28;
            break;
        case 3:
            day = 31;
            break;
        case 4:
            day = 30;
            break;
        case 5:
            day = 31;
            break;
        case 6:
            day = 30;
            break;
        case 7:
            day = 31;
            break;
        case 8:
            day = 31;
            break;
        case 9:
            day = 30;
            break;
        case 10:
            day = 31;
            break;
        case 11:
            day = 30;
            break;
        case 12:
            day = 31;
            break;
    }
    
    return day;
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

int whatNumber (char *number, int length, int firstPointer, int secondPointer)
{
    int answer = 0;
    int tenInPower = power(length);

    for (int i = secondPointer; i <= firstPointer; i++)
    {
        answer = answer + (number[i] - '0') * tenInPower;
        tenInPower = tenInPower / 10;
    }
    
    return answer;
}

bool isDate(char *date)
{
    if (strlen(date) != 10)
    {
        return false;
    }
    
    for (int i = 0; i < maxLength; i++)
    {
        if (i == 2 || i == 5)
        {
            if (date[i] != '.')
            {
                return false;
            }
        }
        else
        {
            if (date[i] - '0' < 0 || date[i] > '9')
            {
                return false;
            }
        }
    }
    
    return true;
}

int main()
{
    char *answer = new char [maxLength] {'0','0','0','0','0','0','0','0','0','0'};
    int minDate = 0;
    ifstream input("input.txt");
    char *date = new char [maxLength];
    int day = 0;
    int month = 0;
    int year = 0;
    int dayInMonth = 0;
    
    while(!input.eof())
    {
        input >> date;
        
        if (isDate(date))
        {
            day = whatNumber(date, 2, 1, 0);
            month = whatNumber(date, 2, 4, 3);
            year = whatNumber(date, 4, 9, 6);
            dayInMonth = howManyDayInMonth(month);
            
            if (day > 0 && dayInMonth >= day && minDate < (year * 365 + month * dayInMonth + day))
            {
                minDate = year * 365 + month * dayInMonth + day;
                
                for (int i = 0; i < maxLength; i++)
                {
                    answer[i] = date[i];
                }
            }
        }
    }

    cout << "The smallest date : ";
    for (int i = 0; i < maxLength; i++)
    {
        cout << answer[i];
    }

    input.close();
    delete[] answer;
    delete[] date;
    return 0;
}
