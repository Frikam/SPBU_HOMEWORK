#include <iostream>

using namespace std;

int main()
{
    int a = 0;
    cin >> a;
    int b = 0;
    cin >> b;
    int count = 0;
    bool isPositive = 1;
    if (b < 0)
    {
        b = -b;
        isPositive = -1;
    }
    if (a > 0)
    {
        
        while (a > 0)
        {
            count++;
            a = a - b;
        }
    }
    else
    {
        while (a < 0)
        {
            isPositive = isPositive * -1;
            count++;
            a = a + b;
        }
    }
    if (a == 0)
    {
        cout << count * isPositive << endl;
    }
    else
    {
        cout << (count - 1) * isPositive << endl;
    }
    return 0;
}
