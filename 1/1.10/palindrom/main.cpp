#include <iostream>

using namespace std;

int main()
{
    cout << "Программа проверяет, является ваша строка палиндромом или нет" << endl;
    const int maxLength = 1000000;
    char word[maxLength];
    cin >> word;
    long long lenght = strlen(word);
    long long halfLenght = strlen(word) / 2;
    char firstHalf[halfLenght];
    char secondHalf[halfLenght];
    
    for (int index = 0; index < halfLenght; index++)
    {
        firstHalf[index] = word[index];

    }
    
    bool isDifferent  = false;
    
    for (int index = 0; index < halfLenght; index++)
    {
        secondHalf[index] = word[lenght - 1 - index];
        
        if (secondHalf[index] != firstHalf[index])
        {
            isDifferent = true;
        }

    }

    if (isDifferent)
    {
        cout << "Строка не является палиндромом" << endl;
    }
    else
    {
        cout << "Строка является палиндромом" << endl;

    }
    return 0;
}
