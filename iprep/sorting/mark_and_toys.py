#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the maximumToys function below.
def maximumToys(prices, k):

    prices.sort()
    subtotal, num_items = 0, 0

    for price in prices:
        if subtotal + price <= k:
            num_items += 1
            subtotal += price
        else:
            break

    return num_items
