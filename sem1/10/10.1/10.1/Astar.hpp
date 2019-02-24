#pragma once

#include <iostream>

#include "Map.hpp"

#include "Queue.hpp"

struct Coordinate
{
    int x;
    int y;
};

void aStar(Map *map, bool **isUsed, int currentX, int currentY, Coordinate **rightWay);
