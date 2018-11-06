#include <iostream>

#include <string>

using namespace std;

int main()
{
    
    const int maxLength = 1000000;
    char word[maxLength];
    cin >> word;
    int count = 0;
    bool balanceBroken = false;
    for (int index = 0; index < strlen(word); index++)
    {
        if (word[index] == '(')
        {
            count++;
        }
        else
        {
            count--;
        }
        
        if (count < 0)
        {
            balanceBroken = true;
        }
    }
    
    if (count == 0 && balanceBroken == false)
    {
        cout << "Баланск скобок не нарушен" << endl;
    }
    else
    {
        cout << "Баланс скобок не нарушен" << endl;
        
    }
    return 0;
}
