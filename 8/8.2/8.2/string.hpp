#pragma once

struct String
{
    int length;
    char *word;
};

String *createString(char word[]);
String *clone(String *string);
void addSign(String *string, char sign);
bool areEqual(String *firstWord, String *secondWord);
int getSize(String *string);
bool areEmpty(String *string);
char *representation(String *string);
void concatenate(String *firstWord, String *secondWord);
String *substring(String *string, int index);
void deleteString(String *string);

