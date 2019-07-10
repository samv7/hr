#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the countSort function below.
def countSort(arr):

        sorted = [ [] for i in range(0,101)]

        for i, elem in enumerate(arr):
            k, s = elem
            if (i >= len(arr) / 2):
                sorted[int(k)] += [s]
            else:
                sorted[int(k)] += ["-"]

        out = []

        for i in range(0,101) :
            for j in range(0, len(sorted[i]) ):
                out.append(sorted[i][j])

        print(" ".join(out))


if __name__ == '__main__':
    n = int(input().strip())

    arr = []

    for _ in range(n):
        arr.append(input().rstrip().split())

    countSort(arr)
