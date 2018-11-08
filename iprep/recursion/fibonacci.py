def fibonacci(n):

    if n==0:
        return 0
    if n==1:
        return 1

    fib_a = 0
    fib_b = 1

    ans = 0
    for i in range(2,n+1):
        ans = fib_a + fib_b
        fib_a = fib_b
        fib_b = ans

    return ans
