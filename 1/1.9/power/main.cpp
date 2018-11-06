#include <iostream>

using namespace std;

int main()
{
    cout << "The programm will output number a^n" << endl;
    int a = 0;
    cout << "Enter a: ";
    cin >> a;
    int n = 0;
    cout << "Enter n: ";

    cin >> n;
    int numb = 1;
    for (int i = 0; i < n; i++)
    {
        numb = numb * a;
    }
    cout << numb << endl;
    return 0;
}
