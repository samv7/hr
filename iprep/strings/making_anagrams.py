#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the makeAnagram function below.
def makeAnagram(a, b):
    dels = 0

    a_count = count_chars(a)
    b_count = count_chars(b)


    dels += count_dels(a_count, b_count)
    dels += count_dels(b_count, a_count)

    return dels

def count_chars(a):
    a_count = {}

    for c in a:
        if c in a_count: a_count[c]+=1
        else: a_count[c] = 1

    return a_count

def count_dels(a_count, b_count):
    dels = 0
    for c in a_count.keys():
        if c in b_count:
            if a_count[c]>b_count[c]:
                dels += a_count[c]-b_count[c]
                a_count[c] = b_count[c]
        else:
            dels += a_count[c]
            a_count[c] = 0
    return dels
