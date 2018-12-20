#pragma once

struct Map
{
    int x;
    int y;
    int sizeX;
    int sizeY;
    int **map;
};

Map *createMap(int x, int y, int sizeX, int sizeY, int **map);
void deleteMap(Map *map);
