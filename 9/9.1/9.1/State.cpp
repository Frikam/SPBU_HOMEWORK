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
        graph->state[i] = new int[graph->numberOfSity];
        graph->state[i][0] = stateNumber - 1;
        graph->sity[stateNumber - 1][0] = 0;
        
        for (int j = 1; j < graph->numberOfSity; j++)
        {
            graph->sity[stateNumber - 1][j] = 0;
            graph->state[i][j] = -1;
        }
        
    }
}

void addSityInState(Graph *graph, int index)
{
    int minWay = 10000;
    int sity = 0;
    
    for (int j = 0; j < graph->numberOfSity; j++)
    {
        int sityInState = graph->state[index][j];
        
        if (sityInState != -1)
        {
            for (int i = 0; i < graph->numberOfSity; i++)
            {
                if (minWay > graph->sity[i][sityInState] && graph->sity[i][sityInState] != 0)
                {
                    minWay = graph->sity[i][sityInState];
                    sity = i;
                }
            }
        }
    }
    
    for (int i = 0; i < graph->numberOfSity; i++)
    {
        graph->sity[sity][i] = 0;
    }
    
    int count = 0;
    
    while (graph->state[index][count] != -1)
    {
        count++;
    }
    
    graph->state[index][count] = sity;
}

void addSityToState(Graph *graph)
{
    int index = 0;
    
    while (index <= graph->numberOfSity - 1 - graph->numberOfState)
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
        for (int j = 1; j < graph->numberOfSity; j++)
        {
            if (graph->state[i][j] != -1)
            {
                cout << graph->state[i][j] + 1 << ' ';
            }
        }
    }
}
