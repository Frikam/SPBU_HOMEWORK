#pragma once

#include <iostream>

#include "Map.hpp"

#include "Queue.hpp"

struct Coordinate
{
    int x;
    int y;
};

int h(int x1, int y1, int x2, int y2);
void aStar(Map *map, bool **isUsed, int currentX, int currentY, Coordinate **rightWay);
void checkNewPoint(Map *map, Queue *queue, bool **isUsed, int x, int y);
void addNeighbors(Map *map, Queue *queue, bool **isUsed, int currentX, int currentY);
void findRightPoint(Map *map, Queue *queue, int &currentX, int &currentY, Coordinate **rightWay);
void checkNewPoint(Map *map, Queue *queue, bool **isUsed, int x, int y, int x1, int y1);
