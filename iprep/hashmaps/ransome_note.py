#!/bin/python3

import math
import os
import random
import re
import sys
from collections import defaultdict

# Complete the checkMagazine function below.
def checkMagazine(magazine, note):
    mag_map = defaultdict(lambda *x : 0)
    for word in magazine:
        mag_map[word] += 1

    for word in note:
        if mag_map[word] == 0:
            print("No")
            return
        else:
            mag_map[word] -= 1

    print("Yes")
