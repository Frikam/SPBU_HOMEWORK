#include "Map.hpp"

Map *createMap(int x, int y, int sizeX, int sizeY, int **map)
{
    return new Map {x, y, sizeX, sizeY, map};
}

void deleteMap(Map *map)
{
    for (int i = 0; i < map->y; i++)
    {
        delete[] map->map[i];
    }
    delete[] map->map;
    delete map;
}
