#include <iostream>

using namespace std;

void reverse(long long numb[], int begin, int end)
{
    
    long long memory = 0;
    for (int i = begin; i < (end + begin) / 2; i++)
    {
        memory = numb[i];
        numb[i] = numb[begin + end - i - 1];
        numb[begin + end - i - 1] = memory;
    }
}

int main()
{
    cout << "Programm rearranges begin and end of array" << endl;
    int m = 0;
    cin >> m;
    int n = 0;
    cin >> n;
    long long numb[n + m];
    
    for (int i = 0; i < n + m; i++)
    {
        cin >> numb[i];
    }
    reverse(numb, 0, m);
    reverse(numb, m , n + m);
    reverse(numb, 0, n + m );
    
    for (int i = 0; i < n + m; i++)
    {
        cout << numb[i] << ' ';
    }
    return 0;
}
