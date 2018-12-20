#pragma once

#include <iostream>

#include "Map.hpp"

#include "Queue.hpp"

int h(int x1, int y1, Map *map);
void aStar(Map *map, int **rightWay, int currentX, int currentY);
void findNextPoint(Queue queue, int currentX, int currentY);
void checkNewPoint(Map *map, Queue *queue, int **rightWay, int x, int y);
void addNeighbors(Map *map, Queue *queue, int **rightWay, int currentX, int currentY);
void findRightPoint(Map *map, Queue *queue, int &currentX, int &currentY);
