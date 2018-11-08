#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the stepPerms function below.
def stepPerms(n):
    return ways_up_stairs(n) % 10000000007

def recurse(n):

    if n==1:
        return 1
    elif n==2:
        return recurse(1)+1
    elif n==3:
        return recurse(2)+recurse(1)+1
    else:
        return recurse(n-1)+recurse(n-2)+recurse(n-3)

def ways_up_stairs(n, step_sizes = [1,2,3]):
    W = [0 for x in range(0,n+1)]
    for step in step_sizes:
        if step <= n:
            W[step] = 1

    for i in range(1,n+1):
        for step in step_sizes:
            if i-step >= 0:
                W[i] += W[i-step]

    return W[-1]
