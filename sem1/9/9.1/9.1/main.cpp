#include <iostream>

#include <fstream>

#include "Graph.hpp"

#include "State.hpp"

using namespace std;

int main()
{
    ifstream input ("input.txt");
    Graph *graph = readGraph(input);
    readState(graph, input);
    addSityToState(graph);
    printStates(graph);
    input.close();
    deleteGraph(graph);
    return 0;
}
