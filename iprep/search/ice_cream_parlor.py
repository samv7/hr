#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the whatFlavors function below.
def whatFlavors(cost, money):

    cost1_map, cost2_map = {}, {}

    for i, c in enumerate(cost):
        if not c in cost1_map:
            cost1_map[c] = i
        else:
            cost2_map[c] = i


    for i, c in enumerate(cost):
        needed_cost = money - c
        if needed_cost in cost1_map:
            if cost1_map[needed_cost] !=i:
                print(min(i,cost1_map[needed_cost])+1, max(i,cost1_map[needed_cost])+1 )
                break
            else:
                if needed_cost in cost2_map:
                    print(min(i,cost2_map[needed_cost])+1, max(i,cost2_map[needed_cost])+1 )
                    break

    #for i, c1 in enumerate(cost):
    #    for j, c2 in enumerate(cost[(i+1):]):
    #        if c1 + c2 == money:
    #            print(min(i+1,i+j+1+1), max(i+1, i+j+1+1))
