#include <iostream>

using namespace std;

int main()
{
    cout << "Array NxM" << endl;
    cout << "Enter N : ";
    int n = 0;
    cin >> n;
    cout << "Enter M : ";
    int m = 0;
    cin >> m;
    int *minInline = new int [m];
    int *maxInColumn = new int [n];
    
    int number = 0;
    int **array = new int *[n];
    
    for (int i = 0; i < n; i++)
    {
        array[i] = new int [m];
        for (int j = 0; j < m; j++)
        {
            cout << "Enter number : ";
            cin >> number;
            array[i][j] = number;
            if (j == 0 || minInline[i] > number)
            {
                minInline[i] = number;
            }
            
            if (i == 0 || maxInColumn[j] < number)
            {
                maxInColumn[j] = number;
            }
        }
    }
    

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (array[i][j] == maxInColumn[j] && array[i][j] == minInline[i])
            {
                cout << "Coordinates of the point : " << i + 1 << ' ' << j + 1 << endl;
            }
        }
    }
    
    delete[] array;
    delete[] maxInColumn;
    delete[] minInline;
    return 0;
}
