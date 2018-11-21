#include <iostream>

#include <string.h>

#include "string.hpp"

using namespace std;

void addSign(String *string, char sign)
{
    Sign *current = string->firstSign;
    
    if (!current)
    {
        string->firstSign = new Sign {sign, nullptr};
    }
    else
    {
        while (current->next)
        {
            current = current->next;
        }
        current->next = new Sign {sign, nullptr};
    }

}

String *createString(char word[])
{
    String *string = new String {nullptr};
    for (int i = 0; i < strlen(word); i++)
    {
        addSign(string, word[i]);
    }
    
    return string;
}

String *clone(String *string)
{
    String *clonedWord = new String {nullptr};
    Sign *current = string->firstSign;
    cout << "Cloned word : ";
    
    while (current)
    {
        cout << current->sign;
        addSign(clonedWord, current->sign);
        current = current->next;
    }
    
    cout << endl;
    return clonedWord;
}

bool isEqual(String *firstWord, String *secondWord)
{
    Sign *firstPointer = firstWord->firstSign;
    Sign *secondPointer = secondWord->firstSign;
    
    while(firstPointer)
    {
        if (secondPointer->sign != firstPointer->sign)
        {
            cout << "String isn't equal" << endl;
            return false;
        }
        
        secondPointer = secondPointer->next;
        firstPointer = firstPointer->next;
    }
    
    if (secondPointer)
    {
        cout << "String isn't equal" << endl;
        return false;
    }
    
    cout << "String is equal" << endl;
    return true;
}

int getSize(String *string)
{
    int size = 0;
    Sign *current = string->firstSign;

    while (current)
    {
        size++;
        current = current->next;
    }
    
    cout << "Size of string : " << size << endl;
    return size;
}

bool isEmpty(String *string)
{
    if (string->firstSign)
    {
        cout << "String isn't empty" << endl;
        return false;
    }
    
    cout << "String is empty" << endl;
    return true;
}

char *representation(String *string)
{
    const int maxLength = 10000;
    int index = 0;
    char *line = new char [maxLength];
    Sign *current = string->firstSign;

    while (current)
    {
        line[index] = current->sign;
        current = current->next;
        index++;
    }
    
    return line;
}

void concatenation(String *firstWord, String *secondWord)
{
    Sign *firstPointer = firstWord->firstSign;
    Sign *secondPointer = secondWord->firstSign;
    cout << "New string : ";
    
    while (firstPointer->next)
    {
        cout << firstPointer->sign;
        firstPointer = firstPointer->next;
    }
    
    cout << firstPointer->sign;
    
    while (secondPointer)
    {
        cout << secondPointer->sign;
        firstPointer->next = new Sign {secondPointer->sign, nullptr};
        firstPointer = firstPointer->next;
        secondPointer = secondPointer->next;
    }
    
    cout << endl;
}

String *substring(String *string, int index)
{
    String *word = new String {nullptr};
    Sign *current = string->firstSign;
    int count = 0;
    cout << "Substring : ";

    while (count != index)
    {
        cout << current->sign;
        addSign(word, current->sign);
        current = current->next;
        count++;
    }
    
    cout << endl;
    return word;
}

void deleteString(String *string)
{
    Sign *current = string->firstSign;
    
    while (current)
    {
        Sign *nextElement = current->next;
        delete current;
        current = nextElement;
    }
}
