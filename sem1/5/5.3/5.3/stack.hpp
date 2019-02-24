#pragma once

struct ListElement {
    char sign;
    ListElement *next;
};

struct List {
    ListElement *top;
};

List *createList();
void stackPush(List *list, char sign);
void print(List *list, char *postfixForm, int *index);
void stackPop(List *list);
void deleteList(List *list);
int size(List *list);
char getTop(List *list);
void clearList(List *list);

