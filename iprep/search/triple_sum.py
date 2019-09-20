#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the triplets function below.
def triplets(a, b, c):

    a=sorted(list(set(a)))
    b=sorted(list(set(b)))
    c=sorted(list(set(c)))

    count = 0
    for middle in b:
        counta = count_leq(a, middle)
        countb = count_leq(c, middle)
        count += counta * countb

    return count

def count_leq(arr, target):

    if target < arr[0]:
        return 0
    if target > arr[-1]:
        return len(arr)

    st=0
    end=len(arr)
    while (st < end):
        mid = (st+end)//2

        if arr[mid] == target:
            return (mid+1)
        elif target < arr[mid]:
            end = mid
        elif arr[mid] < target:
            st = mid+1

    if arr[mid] < target:
        return mid+1
    else:
        return mid

def test():
    assert count_leq([1,2,3,4],5)==4
    assert count_leq([9,13,14],5)==0

    assert count_leq([1,2,3,4],3)==3
    assert count_leq([10,40,70,90,95,96,97],45)==2

    assert count_leq([1,3,5],2)==1
    assert count_leq([1,2,3],2)==2

    assert count_leq([1,3,5],3)==2
    assert count_leq([1,2,3],3)==3



if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    lenaLenbLenc = input().split()

    lena = int(lenaLenbLenc[0])

    lenb = int(lenaLenbLenc[1])

    lenc = int(lenaLenbLenc[2])

    arra = list(map(int, input().rstrip().split()))

    arrb = list(map(int, input().rstrip().split()))

    arrc = list(map(int, input().rstrip().split()))

    ans = triplets(arra, arrb, arrc)

    fptr.write(str(ans) + '\n')

    fptr.close()
