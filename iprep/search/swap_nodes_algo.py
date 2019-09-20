#!/bin/python3

import os
import sys

#
# Complete the swapNodes function below.
#
def swapNodes(indexes, queries):
    #
    # Write your code here.
    #
    sys.setrecursionlimit(1500)

    max_node_value = max([max(idx) for idx in indexes])
    heights = [0 for i in range(0,max_node_value+1)]
    left = [0 for i in range(0,max_node_value+1)]
    right = [0 for i in range(0,max_node_value+1)]

    cur_node = max_node_value
    for idx in reversed(indexes):
        left[cur_node] = idx[0]
        right[cur_node] = idx[1]
        cur_node -= 1

    nodeHeights(left, right, 1, heights, 1)
    idxHeights = indexHeights(indexes, heights)

    output = []
    for query in queries:
        multiples = set(range(0, max(idxHeights)+1, query)[1:])
        if 1 in multiples:
            tmp = left[1]
            left[1] = right[1]
            right[1] = tmp
        for i, idx in enumerate(indexes):
            if idxHeights[i] in multiples:
                #swap left's children
                tmp = left[indexes[i][0]]
                left[indexes[i][0]] = right[indexes[i][0]]
                right[indexes[i][0]] = tmp
                #swap right's children
                tmp = left[indexes[i][1]]
                left[indexes[i][1]] = right[indexes[i][1]]
                right[indexes[i][1]] = tmp

        output.append(inOrderArr(left, right, 1))

    return output


def indexHeights(indexes, nodeHeights):

    idxHeights = [0 for idx in indexes]
    for i,idx in enumerate(indexes):
        if idx[0]==-1 and idx[1]==-1:
            idxHeights[i] = -1
        else:
            idxHeights[i] = nodeHeights[max(idx)]
    return idxHeights

def inOrderArr(left, right, cur_node):
    if (cur_node == -1):
        return []
    else:
        return inOrderArr(left, right, left[cur_node]) + [cur_node] + \
        inOrderArr(left, right, right[cur_node])

def nodeHeights(left, right, cur_node, heights, height):
    if (cur_node == -1):
        pass
    else:
        nodeHeights(left, right, left[cur_node], heights, height+1)
        heights[cur_node] = height
        nodeHeights(left, right, right[cur_node], heights, height+1)


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    indexes = []

    for _ in range(n):
        indexes.append(list(map(int, input().rstrip().split())))

    queries_count = int(input())

    queries = []

    for _ in range(queries_count):
        queries_item = int(input())
        queries.append(queries_item)

    result = swapNodes(indexes, queries)

    fptr.write('\n'.join([' '.join(map(str, x)) for x in result]))
    #fptr.write('\n')

    fptr.close()
