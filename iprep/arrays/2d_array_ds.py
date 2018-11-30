#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the hourglassSum function below.
def hourglassSum(arr):

    i, j = 1,1
    cur_max = sum(arr[i-1][(j-1):(j+2)]) + arr[i][j] + sum(arr[i+1][(j-1):(j+2)])

    for i in range(1,5):
        for j in range(1,5):
            hourglass_sum = sum(arr[i-1][(j-1):(j+2)]) + arr[i][j] + sum(arr[i+1][(j-1):(j+2)])

            cur_max = max(cur_max, hourglass_sum)

    return cur_max
