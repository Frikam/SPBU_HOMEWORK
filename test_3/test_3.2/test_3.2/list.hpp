#pragma once

struct ArrayElement
{
    int i;
    int j;
    ArrayElement *next;
};

struct Array
{
    ArrayElement **element;
};

Array *createArray();
void add(Array *array, int index, int i, int j);

