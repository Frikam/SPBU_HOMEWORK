#include <iostream>

#include "string.hpp"
using namespace std;

int main()
{
    int maxLength = 1000; 
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
    
    cout << "Сhecks word emptiness" << endl;
    cout << isEmpty(line);
    
    cout << "Check equal of word" << endl;
    bool Equal = isEqual(line, secondLine);

    
    cout << "Produces the concatenation : " << endl;
    concatenation(line, secondLine);
    
    cout << "Copies the string" << endl;
    String *newString = clone(line);
    
    
    cout << "Take a substring" << endl;
    cout << "Enter index : ";
    int index = 0;
    cin >> index;
    String *string = substring(line, index);
    
    cout << "Сonverts from string to char*" << endl;
    char *newWord = new char [maxLength];
    newWord = representation(line);
    
    cout << "Delete string" << endl;
    deleteString(line);
    deleteString(secondLine);
    deleteString(string);
    
    delete[] word;
    delete[] secondWord;
    delete[] newWord;
    return 0;
}
