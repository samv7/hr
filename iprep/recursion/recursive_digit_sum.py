#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the superDigit function below.
def superDigit(n, k):

    n_sum = recurse(int(n))
    total = 0

    for i in range(1,k+1):
        total += n_sum
        if total>=10:
            total = recurse(total)

    return total


def recurse(n):

    if n<10:
        return n
    else:
        s = sum([int(x) for x in str(n)])
        return recurse(s)
