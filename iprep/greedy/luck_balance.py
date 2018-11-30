#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the luckBalance function below.
def luckBalance(k, contests):

    contests.sort(key=lambda tup: (tup[1], tup[0]), reverse = True)
    total = 0

    for i, contest  in enumerate(contests):

        if (i+1) <= k:
            total += contest[0]
        else:
            if contest[1] == 0: #unimportant contest: gain the luck
                total += contest[0]
            else: #lose the luck
                total -= contest[0]

    return total
