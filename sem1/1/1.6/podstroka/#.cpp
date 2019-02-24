#include <iostream>

#include <string>

using namespace std;

int main()
{
    const int maxLength = 1000000;
    char word[maxLength];
    cin >> word;
    char miniword[maxLength];
    cin >> miniword;
    int pointer = 0;
    int count = 0;
    bool isEqual = false;
    long long lenght = strlen(miniword);
    
    for (int index = 0; index < strlen(word) - lenght + 1; index++)
    {
        
        if (word[index] == miniword[0])
        {
            pointer = 1;
            
            while (word[index + pointer] == miniword[pointer])
            {
                pointer++;
                
                if (pointer == lenght)
                {
                    isEqual = true;
                }
            }
            
            if (isEqual || lenght == 1)
            {
                count++;
            }
        }
        
        isEqual = false;
        
    }
    cout << count << endl;
    return 0;
}
