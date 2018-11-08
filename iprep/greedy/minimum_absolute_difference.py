#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumAbsoluteDifference function below.
def minimumAbsoluteDifference(arr):
    arr.sort()
    min_dist = abs(arr[-1]-arr[0])
    for i,j in pairwise(arr):
        d = abs(i-j)

        if d<min_dist:
            min_dist = d
    return min_dist

def pairwise(iterable):
    it = iter(iterable)
    a = next(it, None)

    for b in it:
        yield (a, b)
        a = b
