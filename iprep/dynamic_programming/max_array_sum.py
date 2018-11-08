#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the maxSubsetSum function below.
def maxSubsetSum(arr):

    S = [0 for a in arr]

    for i, a in enumerate(arr):
        choices = []
        for j in range(0, i - 1):
            choices.append(S[j]+arr[i])
        for j in range(0, i-1):
            choices.append(arr[j]+arr[i])
        if len(choices) > 0:
            S[i] = max(choices)

    return max(S)
