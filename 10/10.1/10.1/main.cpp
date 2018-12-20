#include <iostream>

#include <fstream>

#include "Map.hpp"

#include "Astar.hpp"

using namespace std;


int main()
{
    ifstream fin("input.txt");
    int n = 0;
    fin >> n;
    int m = 0;
    fin >> m;
    int x1 = 0;
    int y1 = 0;
    fin >> x1 >> y1;
    int x2 = 0;
    int y2 = 0;
    fin >> x2 >> y2;
    int **array = new int *[n];
    bool **isUsed = new bool *[n];
    Coordinate **rightWay = new Coordinate *[n];
    cout << "Map : " << endl;
    
    for (int i = 0; i < n; i++)
    {
        rightWay[i] = new Coordinate [m];
        array[i] = new int [m];
        isUsed[i] = new bool [m];
        for (int j = 0; j < m; j++)
        {
            rightWay[i][j] = *new Coordinate {0, 0};
            isUsed[i][j] = false;
            fin >> array[i][j];
            cout << array[i][j] << ' ';
        }
        cout << endl;

    }
    
    Map *map = createMap(y2, x2, n, m, array);
    aStar(map, isUsed, y1, x1, rightWay);
    deleteMap(map);
    for (int i = 0; i < n; i++)
    {
        delete[] isUsed[i];
    }
    delete[] isUsed;
    fin.close();
    return 0;
}
