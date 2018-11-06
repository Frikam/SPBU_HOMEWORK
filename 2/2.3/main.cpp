#include <iostream>

using namespace std;

void seriesOfNumbers(int leftNumer, int leftDenom, int rightNumer, int rightDenom, int number)
{
    int newDenom = 0;
    int newNumer = 0;
    
    if (leftDenom < number && rightDenom < number)
    {
        newDenom = leftDenom + rightDenom;
        newNumer = leftNumer + rightNumer;
        
        seriesOfNumbers(leftNumer, leftDenom, newNumer, newDenom, number);
        
        if (newDenom < number)
        {
            cout << newNumer << '/' << newDenom << ' ';
        }
        seriesOfNumbers(newNumer, newDenom, rightNumer, rightDenom, number);

    }
}

int main()
{
    cout << "The program prints all irreducible fractions from 0 to 1, whose denominator is less than your number" << endl;
    cout << "Enter number : ";
    int number = 0;
    cin >> number;
    seriesOfNumbers(0, 1, 1, 1, number);
    return 0;
}
