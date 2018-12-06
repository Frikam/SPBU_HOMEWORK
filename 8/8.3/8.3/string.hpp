#pragma once

struct String
{
    long long length;
    char *word;
};

String *createString(char *word);
String *clone(String *string);
void addSign(String *string, char sign);
bool areEqual(String *firstWord, String *secondWord);
long long getSize(String *string);
bool isEmpty(String *string);
char *representation(String *string);
void concatenation(String *firstWord, String *secondWord);
String *substring(String *string, int index);
void deleteString(String *string);
void printElement(String *string);

