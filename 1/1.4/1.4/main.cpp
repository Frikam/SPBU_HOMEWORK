#include <iostream>

using namespace std;

int main()
{
    int sum = 0;
    int count = 0;
    
    for (int i = 0; i < 28; ++i)
    {
        for (int a = 0; a < 10; ++a)
        {
            for (int b = 0; b < 10; ++b)
            {
                for (int c = 0; c < 10; ++c)
                {
                    if (a + b + c == i)
                    {
                        ++count;
                    }
                }
            }
        }
        sum += count * count;
        count = 0;
    }
    
    cout << sum << endl;
    return 0;
}
