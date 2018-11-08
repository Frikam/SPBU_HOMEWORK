#pragma once

struct ListElement {
    int number;
    ListElement *next;
};

struct List {
    ListElement *top;
};

List *createList();
void stackPushNumber(List *list, int c);
void print(List *list);
void stackPop(List *list);
void deleteList(List *list);
void calculator(List *list, int firstNumber, int secondNumber, char sign);
int isNumber(char sign);
