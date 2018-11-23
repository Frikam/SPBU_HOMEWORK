#include <iostream>

#include <fstream>

#include "list.h"
using namespace std;

int main()
{
    
    List *NumbersBetween = createList();
    List *NumberOverThanB = createList();
    
    int number = 0;
    ifstream input("input.txt");
    ofstream output("output.txt");
    int a = 0;
    cout << "Enter a : ";
    cin >> a;
    int b = 0;
    cout << "Enter b : ";
    cin >> b;
    
    while (!input.eof())
    {
        if (!input.eof())
        {
            input >> number;
            if (number >= a && number <= b)
            {
                add(NumbersBetween, number);
            }
            else if (number < a)
            {
                output << number << ' ';
            }
            else
            {
                add(NumberOverThanB, number);
            }
        }

    }
    
    print(NumbersBetween, output);
    print(NumberOverThanB, output);
    
    input.close();
    output.close();
    deleteList(NumbersBetween);
    deleteList(NumberOverThanB);
    
    return 0;
}
