#include <iostream>

#include <string.h>

using namespace std;

long long const mod = 10000000000000;

void countHashOfString(char *string, long length, int *hashOfString)
{
    int power = 5;
    int number = 1;
    
    for (int i = 0; i < length; i++)
    {
        hashOfString[i] = (string[i] - 'a' + 1) * number % mod;
        
        if (i != 0)
        {
            hashOfString[i] = (hashOfString[i] + hashOfString[i - 1]) % mod;
        }
        
        number = number * power;
    }
}

int getHashOfSubstring(char *substring, long length)
{
    int answer = 0;
    int power = 5;
    int number = 1;
    
    for (int i = 0; i < length; i++)
    {
        answer = (answer + ((substring[i] - 'a' + 1) * number) % mod) % mod;
        number = number * power;
    }
    
    return answer;
}

bool isEqual(char *string, int index, char *substring)
{
    long length = strlen(substring);
    
    for (int i = 0; i < length; i++)
    {
        if (string[index + i] != substring[i])
        {
            return false;
        }
    }
    
    return true;
}

int main()
{
    int const maxLength = 1000;
    int count = 0;
    int number = 1;
    int power = 5;
    cout << "Enter string : ";
    char *string = new char [maxLength];
    cin >> string;
    long lengthOfString = strlen(string);
    int *hashOfString = new int [lengthOfString];
    countHashOfString(string, lengthOfString, hashOfString);
    
    cout << "Enter substring : ";
    char *substring =  new char [maxLength];
    cin >> substring;
    long lengthOfSubstring = strlen(substring);
    int hashOfSubstring = getHashOfSubstring(substring, lengthOfSubstring);

    for (int i = 0; i < lengthOfString - lengthOfSubstring + 1; i++)
    {
        int hash = hashOfString[i + lengthOfSubstring - 1];
        
        if (i != 0)
        {
            hash -= hashOfString[i - 1];
        }
        
        if (hash == (hashOfSubstring * number) % mod && isEqual(string, i, substring))
        {
            cout << "Index of entries : " << i << endl;
            count++;
        }
        
        number = number * power;
    }
    
    delete[] substring;
    delete[] string;
    delete[] hashOfString;
    return 0;
}
