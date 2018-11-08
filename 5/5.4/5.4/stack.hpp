#pragma once

struct ListElement {
    int number;
    ListElement *next;
};

struct List {
    ListElement *top;
};

List *createList();
void stackPush(List *list, int c);
void print(List *list);
void stackPop(List *list);
void deleteList(List *list);
int getFirstNumber(List *list);
int getSecondNumber(List *list);
