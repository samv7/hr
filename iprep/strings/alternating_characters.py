#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the alternatingCharacters function below.
def alternatingCharacters(s):

    stripe = s[0]
    count = 0
    for i, c in enumerate(s[1:]):
        if c == stripe: #not what we wanted, need to delete
            count += 1
        else: #
            stripe = c


    return count
