#include <iostream>

#include "State.hpp"

void readState(Graph *graph, ifstream &input)
{
    int numberOfState = 0;
    input >> numberOfState;
    graph->numberOfState = numberOfState;
    graph->state = new int *[numberOfState];
    int stateNumber = 0;
    
    for (int i = 0; i < numberOfState; i++)
    {
        input >> stateNumber;
        graph->state[i] = new int[graph->numberOfCity];
        graph->state[i][0] = stateNumber - 1;
        graph->city[stateNumber - 1][0] = 0;
        
        for (int j = 1; j < graph->numberOfCity; j++)
        {
            graph->city[stateNumber - 1][j] = 0;
            graph->state[i][j] = -1;
        }
        
    }
}

void addSityInState(Graph *graph, int index)
{
    int minWay = 10000;
    int sity = -1;
    
    for (int j = 0; j < graph->numberOfCity; j++)
    {
        int sityInState = graph->state[index][j];
        
        if (sityInState != -1)
        {
            for (int i = 0; i < graph->numberOfCity; i++)
            {
                if (minWay > graph->city[i][sityInState] && graph->city[i][sityInState] != 0)
                {
                    minWay = graph->city[i][sityInState];
                    sity = i;
                }
            }
        }
    }
    
    if (sity != -1)
    {
        for (int i = 0; i < graph->numberOfCity; i++)
        {
            graph->city[sity][i] = 0;
        }
        
        int count = 0;
        
        while (graph->state[index][count] != -1)
        {
            count++;
        }
        
        graph->state[index][count] = sity;
    }
}

void addSityToState(Graph *graph)
{
    int index = 0;
    
    while (index <= graph->numberOfCity - 1 - graph->numberOfState)
    {
        addSityInState(graph, index % (graph->numberOfState));
        index++;
    }
}

void printStates(Graph *graph)
{
    for (int i = 0; i < graph->numberOfState; i++)
    {
        cout << endl << "Number of state : " << graph->state[i][0] + 1 << endl;
        cout << "Numbers of sity : ";
        for (int j = 1; j < graph->numberOfCity; j++)
        {
            if (graph->state[i][j] != -1)
            {
                cout << graph->state[i][j] + 1 << ' ';
            }
        }
    }
}
