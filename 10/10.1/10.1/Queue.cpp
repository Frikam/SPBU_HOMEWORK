#include "Queue.hpp"

Queue *createQueue()
{
    return new Queue {nullptr};
}

void deleteQueue(Queue *queue)
{
    QueueElement *current = queue->first;
    while (current)
    {
        QueueElement *nextElement = current->next;
        delete current;
        current = nextElement;
    }
    
    delete queue;
}
void add(Queue *queue, int x, int y)
{
    queue->first = new QueueElement {x, y, queue->first};
}

void remove(Queue *queue, int x, int y)
{
    QueueElement *current = queue->first;
    
    if (current->x == x && current->y == y)
    {
        queue->first = current->next;
        delete current;
        return;
    }
    
    while (current->next && current->next->x != x && current->next->y != y)
    {
        current = current->next;
    }
    
    QueueElement *newElement = current->next;
    current->next = newElement->next;
    delete newElement;
}

bool isEmpty (Queue *queue)
{
    return queue->first == nullptr;
}
