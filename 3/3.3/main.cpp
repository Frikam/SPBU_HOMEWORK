#include <iostream>

using namespace std;

int quickPower(int number, int power)
{
    if (power == 0)
    {
        return 1;
    }
    else
    {
        if (power % 2 == 1)
        {
            return quickPower(number, power - 1) * number;
        }
        else
        {
            int replace = quickPower(number, power / 2);
            return replace * replace;
        } 
    }
}
int main()
{
    cout << "Program raises your number to a power" << endl;
    cout << "Enter number : ";
    int number = 0;
    cin >> number;
    cout << "Enter power : ";
    int power = 0;
    cin >> power;
    cout << quickPower(number, power) << endl;
    return 0;
}
