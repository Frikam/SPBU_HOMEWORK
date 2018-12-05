#include <fstream>

#include <iostream>

#include "Graph.hpp"

using namespace std;

Graph *createGraph(int numberOfSity)
{
    Graph *graph = new Graph {};
    graph->numberOfSity = numberOfSity;
    graph->sity = new int *[numberOfSity];
    
    for (int i = 0; i < numberOfSity; i++)
    {
        graph->sity[i] = new int[numberOfSity];
        for (int j = 0; j < numberOfSity; j++)
        {
            graph->sity[i][j] = 0;
        }
    }
    
    return graph;
}

Graph *readGraph(ifstream &input)
{
    int firstSity = 0;
    int secondSity = 0;
    int length = 0;
    int  numberOfSity = 0;
    input >> numberOfSity;
    Graph *graph = createGraph(numberOfSity);
    
    int numberOfRoad = 0;
    input >> numberOfRoad;
    
    for (int i = 0; i < numberOfRoad; i++)
    {
        input >> firstSity;
        input >> secondSity;
        input >> length;
        graph->sity[firstSity - 1][secondSity - 1] = length;
        graph->sity[secondSity - 1][firstSity - 1] = length;
    }
    
    return graph;
}

void printMatrix(Graph *graph)
{
    for (int i = 0; i < graph->numberOfSity; i++)
    {
        for (int j = 0; j < graph->numberOfSity; j++)
        {
            cout << graph->sity[i][j] << ' ';
        }
        
        cout << endl;
    }
}

void deleteGraph(Graph *graph)
{
    for (int i = 0; i < graph->numberOfSity; i++)
    {
        delete[] graph->sity[i];
    }
    
    delete[] graph->sity;
    
    for (int i = 0; i < graph->numberOfState; i++)
    {
        delete[] graph->state[i];
    }
    
    delete[] graph->state;
}
