#include <fstream>

#include <iostream>

#include "Graph.hpp"

using namespace std;

Graph *createGraph(int numberOfCity)
{
    Graph *graph = new Graph {};
    graph->numberOfCity = numberOfCity;
    graph->city = new int *[numberOfCity];
    
    for (int i = 0; i < numberOfCity; i++)
    {
        graph->city[i] = new int[numberOfCity];
        for (int j = 0; j < numberOfCity; j++)
        {
            graph->city[i][j] = 0;
        }
    }
    
    return graph;
}

Graph *readGraph(ifstream &input)
{
    int firstSity = 0;
    int secondSity = 0;
    int length = 0;
    int  numberOfCity = 0;
    input >> numberOfCity;
    Graph *graph = createGraph(numberOfCity);
    
    int numberOfRoad = 0;
    input >> numberOfRoad;
    
    for (int i = 0; i < numberOfRoad; i++)
    {
        input >> firstSity;
        input >> secondSity;
        input >> length;
        graph->city[firstSity - 1][secondSity - 1] = length;
        graph->city[secondSity - 1][firstSity - 1] = length;
    }
    
    return graph;
}

void printMatrix(Graph *graph)
{
    for (int i = 0; i < graph->numberOfCity; i++)
    {
        for (int j = 0; j < graph->numberOfCity; j++)
        {
            cout << graph->city[i][j] << ' ';
        }
        
        cout << endl;
    }
}

void deleteGraph(Graph *graph)
{
    for (int i = 0; i < graph->numberOfCity; i++)
    {
        delete[] graph->city[i];
    }
    
    delete[] graph->city;
    
    for (int i = 0; i < graph->numberOfState; i++)
    {
        delete[] graph->state[i];
    }
    
    delete[] graph->state;
}
