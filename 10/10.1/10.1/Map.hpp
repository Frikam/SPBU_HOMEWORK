#pragma once

struct Map
{
    int x;
    int y;
    int sizeX;
    int sizeY;
    bool **map;
};

Map *createMap(int x, int y, int sizeX, int sizeY, bool **map);
void deleteMap(Map *map);
