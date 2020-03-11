fibonacci :: Integer -> Integer
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci i = fibonacci (i - 1) + fibonacci (i - 2)
