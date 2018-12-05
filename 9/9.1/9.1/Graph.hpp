#pragma once

#include <fstream>

using namespace std;

struct Graph
{
    int numberOfSity;
    int **sity;
    int numberOfState;
    int **state;
};

Graph *createGraph(int numberOfSity);
Graph *readGraph(ifstream &fin);
void printMatrix(Graph *graph);
void deleteGraph(Graph *graph);
