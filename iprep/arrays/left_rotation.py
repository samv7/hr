#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the rotLeft function below.
def rotLeft(a, d):

    if len(a)==1:
        return a

    if d==len(a):
        return a
    else:
        return a[d:]+a[:d]

    
