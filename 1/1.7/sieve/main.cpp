#include <iostream>

using namespace std;

int main()
{
    cout << "Prorgamm will output all prime numbers less than the specified" << endl;
    cout << "Enter number : ";
    int num = 0;
    cin >> num;
    int maxLenght = 100000;
    int sieve[maxLenght];
    
    for (int index = 2; index < num + 1; index++)
    {
        sieve[index] = 0;
    }
    
    for (int index = 2; index < num + 1; index++)
    {
        
        for (int pointer = 2; pointer < (num / index) + 1; pointer++)
        {
            sieve[pointer * index] = 1;
        }
        
    }
    
    for (int index = 2; index < num; index++)
    {
        if (sieve[index] == 0)
        {
            cout << index << ' ';
        }
    }
    
    return 0;
}
