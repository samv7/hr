#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the flippingBits function below.
def flippingBits(n):

    arr = to_binary(n)

    for i, a in enumerate(arr):
        if a==0:
            arr[i] = 1
        else:
            arr[i] = 0


    return from_binary(arr)


def to_binary(n):
    arr = [0 for x in range(0,32)]

    pow = 0
    k = n
    while (k > 0):
        if (k % 2 == 1):
            arr[(-1 - pow)] = 1
            k -= 1
        k = (k/2)
        pow += 1

    return arr

def from_binary(arr):
    num = 0
    pow = 0
    for i in range(len(arr)-1,-1,-1):
        if arr[i]==1:
            num += 2**pow
        pow += 1
    return num
