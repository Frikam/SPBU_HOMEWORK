#include <iostream>

#include <fstream>

#include "string.hpp"

#include "hash.hpp"

using namespace std;

bool isSign(char sign)
{
    return ((sign >= 'a' && sign <= 'z') || (sign >= 'A' && sign <= 'Z'));
}

int main()
{
    int maxNumberOfSamples = 0;
    const int length = 10000;
    ifstream input("input.txt");
    char *word = new char [length];
    HashTable *hashTable = createHashTable();
    
    while(!input.eof())
    {
        input >> word;
        if (!input.eof())
        {
            String *newString = createString(word);
            int i = 0;
            for (i = 0; i < newString->length; i++)
            {
                if (!isSign(newString->word[i]))
                {
                    break;
                }
            }
            
            if (i != 0)
            {
                String *wordWithoutSymbol = substring(newString, i - 1);
                if (wordInHashTable(hashTable, wordWithoutSymbol))
                {
                    cout << "Word : '";
                    printElement(wordWithoutSymbol);
                    cout << "' already in hashTable" << endl;
                }
                addString(hashTable, wordWithoutSymbol);
                //deleteString(wordWithoutSymbol);
            }
            deleteString(newString);
        }
    }
    
    cout << "Load factor : ";
    cout << getLoadFactor(hashTable) << endl;
    cout << "Average number of sample : ";
    cout << getAverageNumberOfSample(hashTable) << endl;
    cout << "Max number of test : ";
    maxNumberOfSamples = getMaxNumberOfSamples(hashTable);
    cout << maxNumberOfSamples << endl;
    cout << "Elements with max number of test : ";
    printElementsWithMaxTest(hashTable, maxNumberOfSamples);
    cout << "Number of elements : ";
    cout << numbOfElements(hashTable) << endl;
    cout << "Number of empty elements : ";
    cout << emptyElements(hashTable) << endl;
    
    delete[] word;
    deleteHashTable(hashTable);
    input.close();
    return 0;
}
