#include <iostream>

#include <string.h>

#include <fstream>

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

void printNode(bool *city, int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << city[i] << ' ';
    }
}

void refreshArray(bool *city, int n)
{
    for (int i = 0; i < n; i++)
    {
        city[i] = false;
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
                city[numberOfCity] = true;
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
    ifstream fin("input.txt");
    int n = 0;
    fin >> n;
    
    int m = 0;
    fin >> m;
    
    bool *city = new bool [n];
    
    int **graph = new int *[n];
   
    for (int i = 0; i < n; i++)
    {
        graph[i] = new int [m];
        for (int j = 0; j < m; j++)
        {
            fin >> graph[i][j];
        }
    }
    
    findNode(graph, city, n, m);
    
    for (int i = 0; i < n; i++)
    {
        delete[] graph[i];
    }
    
    delete[] graph;
    delete[] city;
    fin.close();
    return 0;
}
