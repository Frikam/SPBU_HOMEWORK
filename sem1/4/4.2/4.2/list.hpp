#pragma once

const int maxLength = 1000;

struct ListElement {
    long long number;
    char name[maxLength] {};
    ListElement *next;
};

struct List {
    ListElement *first;
};

List *createList();
void deleteList(List *list);
void add(List *list, long long value, char y[]);
void print(List *list);

