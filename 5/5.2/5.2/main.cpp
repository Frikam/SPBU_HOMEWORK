#include <iostream>

#include <fstream>

#include <string.h>

using namespace std;

void fillingArrayWithZeros(int *array, int maxLength)
{
    for (int i = 0; i < maxLength; i++)
    {
        array[i] = 0;
    }
}

int main()
{
    ifstream fin;
    fin.open("input.txt");
    int IndexOfFirstLowercaseСharacterInTableAscii = 97;
    int IndexOfFirstUppercaseСharacterInTableAscii = 65;
    int DistanceBetweenUppercaseAndLowercaseInTableAscii = 32;
    int numberOfСharacter = 35;
    int maxLength = 10000;
    char line[maxLength];
    int *numbOfCharacters = new int[maxLength];
    fillingArrayWithZeros(numbOfCharacters, maxLength);
    
    while(fin >> line)
    {
        for (int i = 0; i < strlen(line); i++)
        {
            if (numbOfCharacters[int(line[i])] == 0 ){
                cout << line[i];
                
                if (int(line[i]) <= (IndexOfFirstLowercaseСharacterInTableAscii + numberOfСharacter) && int(line[i]) >= IndexOfFirstLowercaseСharacterInTableAscii){
                    numbOfCharacters[int(line[i])]++;
                    numbOfCharacters[int(line[i]) - DistanceBetweenUppercaseAndLowercaseInTableAscii]++;
                    
                }
                if (int(line[i]) <= (IndexOfFirstUppercaseСharacterInTableAscii + numberOfСharacter) && int(line[i]) >= IndexOfFirstUppercaseСharacterInTableAscii ){
                    numbOfCharacters[int(line[i])]++;
                    numbOfCharacters[int(line[i]) + DistanceBetweenUppercaseAndLowercaseInTableAscii]++;
                }
            }
        }
        cout << ' ';
        fillingArrayWithZeros(numbOfCharacters, maxLength);
    }
    delete [] numbOfCharacters;
    return 0;
}
