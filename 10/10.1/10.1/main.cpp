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
    bool **array = new bool *[n];
    int **rightWay = new int *[n];
    cout << "Map : ";
    
    for (int i = 0; i < n; i++)
    {
        cout << endl;
        array[i] = new bool [m];
        rightWay[i] = new int [m];
        for (int j = 0; j < m; j++)
        {
            rightWay[i][j] = 0;
            fin >> array[i][j];
            cout << array[i][j] << ' ';
        }
    }
    
    Map *map = createMap(x2, y2, n, m, array);
    aStar(map, rightWay, x1, y1);
    deleteMap(map);
    fin.close();
    return 0;
}
