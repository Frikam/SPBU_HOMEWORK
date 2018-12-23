#include <iostream>

#include "hash.hpp"

using namespace std;

HashTable* createHashTable()
{
    HashTable *hashTable = new HashTable;
    hashTable->table = new HashElement *[hashTable->maxLength];
    
    for (int i = 0; i < hashTable->maxLength; i++)
    {
        hashTable->table[i] = nullptr;
    }
    
    return hashTable;
}

int getHash(String *string, int mod)
{
    int index = 0;
    int const primeNumber = 17;
    long long length = getSize(string);
    
    for (int i = 0; i < length; i++)
    {
        index = (index + (string->word[i] * primeNumber) % mod) % mod;
    }
    
    return index;
}

void addString(HashTable *hashTable, String *word)
{
    int step = 0;
    int hashNumber = getHash(word, hashTable->maxLength);
    int index = hashNumber;

    while (hashTable->table[index])
    {
        if (areEqual(hashTable->table[index]->string, word))
        {
            hashTable->table[index]->size++;
            hashTable->size++;
            deleteString(word);
            return;
        }
        index = (hashNumber + step * step) % hashTable->maxLength;
        step++;
    }
    
    HashElement *newElement = new HashElement {1, 1, word};
    hashTable->table[index] = newElement;
    hashTable->size++;
}

int numbOfElements(HashTable *hashTable)
{
    return hashTable->size;
}

double getLoadFactor(HashTable *hashTable)
{
    return double (numbOfElements(hashTable)) / double(hashTable->maxLength);
}

int emptyElements(HashTable *hashTable)
{
    return hashTable->maxLength - hashTable->size;
}

double getAverageNumberOfSample(HashTable *hashTable)
{
    int answer = 0;
    
    for (int i = 0; i < hashTable->maxLength; i++)
    {
        if (hashTable->table[i])
        {
            answer += hashTable->table[i]->size;
        }
    }
    
    return double (answer) / double (hashTable->size);
}

int getMaxNumberOfSamples(HashTable *hashTable)
{
    int answer = 0;
    
    for (int i = 0; i < hashTable->maxLength; i++)
    {
        if (hashTable->table[i] && hashTable->table[i]->countOfTest > answer)
        {
            answer = hashTable->table[i]->countOfTest;
        }
    }
    
    return answer;
}

void print(HashTable *hashTable)
{
    for (int i = 0; i < hashTable->maxLength; i++)
    {
        if (hashTable->table[i])
        {
            printElement(hashTable->table[i]->string);
            cout << ' ' << i << endl;
        }
    }
}

void printElementsWithMaxTest(HashTable *hashTable, int answer)
{
    for (int i = 0; i < hashTable->maxLength; i++)
    {
        if (hashTable->table[i] && hashTable->table[i]->countOfTest == answer)
        {
            printElement(hashTable->table[i]->string);
            cout << ' ';
        }
    }
    cout << endl;
}

void deleteHashTable(HashTable *hashTable)
{
    for (int i = 0; i < hashTable->maxLength; i++)
    {
        if (hashTable->table[i] && hashTable->table[i]->string)
        {
            deleteString(hashTable->table[i]->string);
        }
        delete hashTable->table[i];
    }
    delete[] hashTable->table;
    delete hashTable;
}

bool wordInHashTable(HashTable *hashTable, String *word)
{
    int hash = getHash(word, hashTable->maxLength);
    int step = 0;
    int index = hash;
    int count = 0;
    
    while (hashTable->table[index] && count != hashTable->maxLength)
    {
        if (areEqual(hashTable->table[index]->string, word))
        {
            return true;
        }
        index = (hash + step * step) % hashTable->maxLength;
        step++;
        count++;
    }
    return false;
}
