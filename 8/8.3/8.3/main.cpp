#include <iostream>

#include <fstream>

#include "string.hpp"

#include "hash.hpp"

using namespace std;

bool isLetter(char symbol)
{
    return !(symbol == ' ' || symbol == '?' || symbol == '!' || symbol == ','
             || symbol == ';' || symbol == '.' || symbol == '-' || symbol == '\0' || symbol == ':' || symbol == '"');
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
                if (!isLetter(newString->word[i]))
                {
                    break;
                }
            }
            String *wordWithoutSymbol = substring(newString, i);
            addString(hashTable, wordWithoutSymbol);
        }
        
    }
    
    //print(hashTable);
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
    
    input.close();
    return 0;
}
