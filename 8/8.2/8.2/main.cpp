#include <iostream>

#include "string.hpp"

using namespace std;

int main()
{
    const int maxLength = 1000; 
    char *word = new char [maxLength];
    char *secondWord = new char [maxLength];
    
    cout << "Enter first word : ";
    cin >> word;
    cout << "Enter second word : ";
    cin >> secondWord;
    
    cout << "Create string";
    String *line = createString(word);
    String *secondLine = createString(secondWord);

    cout << "Count length of word" << endl;
    int size = getSize(line);
    cout << size << endl;
    
    cout << "Сhecks word emptiness" << endl;
    cout << areEmpty(line) << endl;
    
    cout << "Check equal of word" << endl;
    bool equal = areEqual(line, secondLine);
    cout << equal << endl;
    
    cout << "Take a substring" << endl;
    cout << "Enter index : ";
    int index = 0;
    cin >> index;
    String *string = substring(line, index);
    
    concatenate(line, secondLine);
    
    String *newString = clone(line);
    
    char *newWord = new char [maxLength];
    newWord = representation(line);
    
    deleteString(line);
    deleteString(secondLine);
    deleteString(string);
    deleteString (newString);
    
    delete[] word;
    delete[] secondWord;
    delete[] newWord;
    
    return 0;
}
