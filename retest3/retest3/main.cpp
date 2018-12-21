#include <iostream>

#include <string.h>

using namespace std;

int findAnotherCity(int **graph, int n, int index)
{
    for (int i = 0; i < n; i++)
    {
        if (graph[i][index] == 1)
        {
            return i;
        }
    }
    
    return 0;
}

bool isRightNode(bool *city, int n)
{
    for (int i = 0; i < n; i++)
    {
        if (!city[i])
        {
            return false;
        }
    }
    return true;
}

void refreshArray(bool *sity, int n)
{
    for (int i = 0; i < n; i++)
    {
        sity[i] = false;
    }
}

void bypass(int **graph, bool *city, int index, int m, int n, int currentCity)
{
    for (int i = 0; i < m; i++)
    {
        if (graph[index][i] == -1)
        {
            int numberOfCity = findAnotherCity(graph, n, i);
            if (!city[numberOfCity])
            {
                city[i] = true;
                bypass(graph, city, numberOfCity, m, n, currentCity);
            }
        }
    }
}

void findNode(int **graph, bool *city, int n, int m)
{
    for (int i = 0; i < n; i++)
    {
        refreshArray(city, n);
        
        bypass(graph, city, i, m, n, i);
        city[i] = true;
        if (isRightNode(city, n))
        {
            cout << "Index : " << i + 1 << endl;
        }
    }
}

int main()
{
    cout << "Enter N : ";
    int n = 0;
    cin >> n;
    
    cout << "Enter M : ";
    int m = 0;
    cin >> m;
    
    bool *city = new bool [n];
    
    int **graph = new int *[n];
   
    for (int i = 0; i < n; i++)
    {
        cout << "Enter line : ";
        graph[i] = new int [m];
        for (int j = 0; j < m; j++)
        {
            cin >> graph[i][j];
        }
    }
    
    findNode(graph, city, n, m);
    
    for (int i = 0; i < n; i++)
    {
        delete[] graph[i];
    }
    
    delete[] graph;
    delete[] city;
    return 0;
}
