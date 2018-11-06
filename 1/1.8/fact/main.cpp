#include <iostream>

using namespace std;

long long recurcionFactorial(int answer)
{

    if (answer > 1)
    {
        return answer * recurcionFactorial(answer - 1);
    }
    else
    {
        return 1;
    }
}

long long interativeFactorial(int answer)
{
    int solution = 1;

    for (int i = 2; i <= answer; i++)
    {
        solution = solution * i;
    }
    
    return solution;
}

int main()
{
    cout << "Если вы хотите посчитать факториал интерактивно напечатайте 0, а затем число, иначе напечатайте 1 и число" << endl;
    bool recursionOrinteractive = 0;
    cin >> recursionOrinteractive;
    int numb = 0;
    cin >> numb;
    
    if (recursionOrinteractive == 0)
    {
        cout << recurcionFactorial(numb) << endl;

    }
    else
    {
        cout << interativeFactorial(numb) << endl;
    }
    return 0;
}
