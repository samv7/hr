#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the isBalanced function below.
def isBalanced(s):

    if len(s)<=1 or len(s) %2 == 1:
        return "NO"

    stack = []
    for i, brack in enumerate(s):
        if brack in set(['[','{','(']):
            if i == len(s) - 1:
                return "NO"
            else:
                stack.append(brack)
        else:
            if len(stack)==0:
                return "NO"
            else:
                if is_match(stack[-1], brack):
                    stack.pop()
                else:
                    return "NO"
    return "YES"



def is_match(L, R):
    if L=='(' and R==')':
        return True
    elif L=='[' and R==']':
        return True
    elif L=='{' and R=='}':
        return True
    else:
        return False
