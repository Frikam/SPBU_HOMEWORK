#include <iostream>

using namespace std;

void fillingArray(int *array, char *word)
{
    for (int i = 0; i < strlen(word); i++)
    {
        array[int(word[i])]++;
    }
}

void fillingArrayWithZeros(int *array, int maxLength)
{
    for (int i = 0; i < maxLength; i++)
    {
        array[i] = 0;
    }
}

bool equal(int *array1, int *array2, int len) {
    bool isEqual = true;
    for (int i = 0; i < len; ++i)
        if (array1[i] != array2[i])
        {
            isEqual = false;
        }
    return isEqual;
}

int main()
{
    cout << "The program checks if the word is an annagram";
    int maxLength = 200;
    cout << "Enter word";
    char firstWord[maxLength];
    cin >> firstWord;
    cout << "Enter word";
    char secondWord[maxLength];
    cin >> secondWord;
    
    int charactersOfFirstWord[maxLength];
    fillingArrayWithZeros(charactersOfFirstWord, maxLength);
    fillingArray(charactersOfFirstWord, firstWord);
    
    int charactersOfSecondWord[maxLength];
    fillingArrayWithZeros (charactersOfSecondWord, maxLength);
    fillingArray(charactersOfSecondWord, secondWord);
    
    if (equal(charactersOfFirstWord, charactersOfSecondWord, maxLength))
    {
        cout << "YES";
    }
    else
    {
        cout << "NO";
    }
    return 0;
}
