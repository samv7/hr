#!/bin/python3

import math
import os
import random
import re
import sys
from collections import defaultdict

# Complete the sockMerchant function below.
def sockMerchant(n, ar):
    total_pairs = 0
    sock_count = defaultdict(lambda *x: 0)
    for i, sock in enumerate(ar):
        sock_count[sock] += 1
        if sock_count[sock] % 2 == 0:
            total_pairs += 1


    return total_pairs
