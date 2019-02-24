#include <iostream>

using namespace std;

int main()

{
    cout << "Введите число, которое будет подставленно в формулу x^4 + x^3 + x^2 + x + 1" << endl;
    cout << "x = ";
    int x;
    cin >> x;
    int replace = x * x;
    cout << endl << "x^4 + x^3 + x^2 + x + 1 = ";
    cout << (replace + 1) * (replace + x) + 1 << endl;
    return 0;
}
