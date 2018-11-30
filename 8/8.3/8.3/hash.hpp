#pragma once

#include "string.hpp"


struct HashElement
{
    int countOfTest;
    int size;
    String *string;    
};

struct HashTable
{
    const int maxLength = 1023;
    int size = 0;
    HashElement **table;
};

HashTable *createHashTable();
int getHash(String *string, int mod);
void addString(HashTable *hashTable, String *word);
int numbOfElements(HashTable *hashTable);
double getLoadFactor(HashTable *hashTable);
int emptyElements(HashTable *hashTable);
int getMaxNumberOfSamples(HashTable *hashTable);
double getAverageNumberOfSample(HashTable *hashTable);
void print(HashTable *hashTable);
void printElementsWithMaxTest(HashTable *hashTable, int numeber);
