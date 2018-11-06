#include <iostream>

#include <string.h>

using namespace std;

int howManyWord(char *line, int length)
{
    int numberOfWord = 0;
    
    for (int i = 0; i < length - 1; i++)
    {
        if (line[i] != ' ' && line [i + 1] == ' '){
            numberOfWord++;
        }
    }
    return numberOfWord;
}

int main()
{
    cout << "The program inserts spaces between words, so that the length of the original line is equal to the number you entered" << endl;
    cout << "Enter text : ";
    const int maxLength = 10000;
    char *line = new char[maxLength];
    cin.getline(line, maxLength);
    int length = strlen(line);
    int requiredLength = 0;
    cout << "Enter required length : ";
    cin >> requiredLength;
    int howMuchToAdd = requiredLength - length;
    int numberOfWord = howManyWord(line, length);
    int index1 = howMuchToAdd / numberOfWord;
    int index2 = howMuchToAdd % numberOfWord;
    int index3 = 0;
    
    cout << "Text after addint the spaces : ";
    for (int i = 0; i < length; i++)
    {
        cout << line[i];
        
        if (line[i] == ' '){
            index3++;
            
            for (int j = 0; j < index1; j++){
                cout << ' ';
            }
            
            if (index3 <= index2){
                cout << ' ';
            }
        }
    }
    
    delete[] line;
    return 0;
}

