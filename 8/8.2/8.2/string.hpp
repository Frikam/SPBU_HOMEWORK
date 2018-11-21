#pragma once

struct Sign
{
    char sign;
    Sign *next;
};

struct String
{
    Sign *firstSign;
};

String *createString(char word[]);
String *clone(String *string);
int getSize(String *firstWord);
void addSign(String *string, char sign);
bool isEqual(String *firstWord, String *secondWord);
int getSize(String *string);
bool isEmpty(String *string);
char *representation(String *string);
void concatenation(String *firstWord, String *secondWord);
String *substring(String *string, int index);
void deleteString(String *string);

