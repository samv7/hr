#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumSwaps function below.
def minimumSwaps(arr):

    count = 0
    lut = [0 for a in arr]
    for i, a in enumerate(arr):
        lut[a-1]=i

    for i, a in enumerate(arr):
        whatIneedLoc = lut[i]
        whatIhave = arr[i]

        if whatIhave != i+1:
            arr[i] = arr[whatIneedLoc]
            arr[whatIneedLoc] = whatIhave
            lut[whatIhave-1] = whatIneedLoc
            count +=1

    return count



if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    res = minimumSwaps(arr)

    fptr.write(str(res) + '\n')

    fptr.close()
