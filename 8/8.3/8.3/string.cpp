#include <iostream>

#include <string.h>

#include "string.hpp"

using namespace std;

String *createString(char *word)
{
    String *newString = new String;
    newString->length = strlen(word);
    newString->word = new char [newString->length];
    
    for (int i = 0; i < newString->length; i++)
    {
        newString->word[i] = word[i];
    }
    
    return newString;
}

String *clone(String *string)
{
    String *clonedWord = createString(string->word);
    return clonedWord;
}

bool areEqual(String *firstWord, String *secondWord)
{
    if (firstWord->length == secondWord->length)
    {
        for (int i = 0; i < firstWord->length; i++)
        {
            if (firstWord->word[i] != secondWord->word[i])
            {
                return false;
            }
        }
    }
    
    else
    {
        return false;
    }
    
    return true;
}

long long getSize(String *string)
{
    return string->length;
}

bool isEmpty(String *string)
{
    if (string->length == 0)
    {
        return true;
    }
    
    return false;
}

char *representation(String *string)
{
    char *line = new char [string->length];
    
    for (int i = 0; i < string->length; i++)
    {
        line[i] = string->word[i];
    }
    
    return line;
}

void concatenation(String *firstWord, String *secondWord)
{
    firstWord->length = firstWord->length + secondWord->length;
    char *newWord = new char [firstWord->length];
    
    for (int i = 0; i < firstWord->length - secondWord->length; i++)
    {
        newWord[i] = firstWord->word[i];
    }
    
    for (int i = 0; i < secondWord->length; i++)
    {
        newWord[i + firstWord->length - secondWord->length] = secondWord->word[i];
    }
    
    firstWord->word = newWord;
}

String *substring(String *baseString, int lastPosition)
{
    int j = 0;
    char *charSubstring = new char[lastPosition];
    for (int i  = 0; i < lastPosition; i++)
    {
        charSubstring[j] = baseString->word[i];
        j++;
    }
    String* substring = new String {lastPosition, charSubstring};
    return substring;
}

void deleteString(String *string)
{
    delete[] string->word;
    delete string;
}

void printElement(String *string)
{
    for (int i = 0; i < string->length; i++)
    {
        cout << string->word[i];
    }
}
