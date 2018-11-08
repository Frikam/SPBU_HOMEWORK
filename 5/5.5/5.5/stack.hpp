#pragma once

struct ListElement {
    int number;
    char sign;
    ListElement *next;
};

struct List {
    ListElement *top;
};

List *createList();
void stackPushSign(List *list, char sign);
void saveStack(List *list, char *postfixForm, int *index);
void stackPop(List *list);
void deleteList(List *list);
int size(List *list);
char getFirstSign(List *list);
void clearList(List *list);
void stackPushNumber(List *list, int c);
void print(List *list);
int getFirstNumber(List *list);
int getSecondNumber(List *list);
