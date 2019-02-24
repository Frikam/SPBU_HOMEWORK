#include <iostream>

#include <fstream>

#include <string.h>

using namespace std;

bool lineIsEmpty(char line[])
{
    for(int i = 0; i < strlen(line); i++)
    {
        if (line[i] != ' ' && line[i] != '\t'){
             return false;
        }
    }
    return true;
}
int main()
{
    ifstream fin;
    fin.open("input.txt");
    
    int maxLength = 10000;
    char line[maxLength];
    int count = 0;
    bool isEmpty = true;
    
    while(fin.getline(line, maxLength))
    {
        isEmpty = lineIsEmpty(line);
        
        if (!isEmpty){
            count++;
        }
        
        isEmpty = true;
    }
    
    cout  << count;

    fin.close();
    return 0;
}
