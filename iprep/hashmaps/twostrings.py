
import math
import os
import random
import re
import sys

# Complete the twoStrings function below.
def twoStrings(s1, s2):

    s1_count, s2_count = {}, {}
    for c in s1:
        s1_count[c] = True
    for c in s2:
        s2_count[c] = True

    for c in s1:
        if c in s2:
            return "YES"

    #if len(set(s1).intersection(set(s2)) ) > 0:
    #    return "YES"


    return "NO"
