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
    int maxLength = 10000;
    char line[maxLength];
    int *numbOfCharacters = new int[maxLength];
    fillingArrayWithZeros(numbOfCharacters, maxLength);
    
    while (fin >> line)
    {
        for (int i = 0; i < strlen(line); i++)
        {
            if (numbOfCharacters[int(line[i])] == 0 ){
                cout << line[i];
                
                if (int(line[i]) <= 'z' && int(line[i]) >= 'a'){
                    numbOfCharacters[int(line[i])]++;
                    numbOfCharacters[line[i] + ('A' - 'a')]++;
                }
                if (line[i] <= 'Z' && line[i] >= 'A'){
                    numbOfCharacters[int(line[i])]++;
                    numbOfCharacters[line[i] - ('A' - 'a')]++;
                }
            }
        }
        cout << ' ';
        fillingArrayWithZeros(numbOfCharacters, maxLength);
    }
    
    delete [] numbOfCharacters;
    return 0;
}
