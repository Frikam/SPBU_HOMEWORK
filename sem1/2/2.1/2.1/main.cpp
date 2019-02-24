#include <iostream>

using namespace std;

long long fibonacciRecurcieve(int numb)
{
    if (numb > 1)
    {
        return fibonacciRecurcieve(numb - 1) + fibonacciRecurcieve(numb - 2);
    }
    return (numb != 0);
}

long long fibonacciIterative(int numb)
{
    int count = 1;
    int fib = 1;
    int prevFib = 0;
    int memory = 0;
    
    while (count < numb)
    {
        count++;
        memory = fib;
        fib = fib + prevFib;
        prevFib = memory;
    }
    return fib;
}
int main()
{
    cout << "If you want the program to solve the problem recursively enter 1, else enter 0"  << endl;
    bool isRecursion = false;
    cin >> isRecursion;
    cout << "What Fibonacci number do you want to see?" << endl;
    int numb = 0;
    cin >> numb;

    if (isRecursion){
        cout << fibonacciRecurcieve(numb)<< endl;
    }
    else{
        cout << fibonacciIterative(numb) << endl;
    }
    return 0;
}
