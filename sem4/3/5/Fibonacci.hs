fibonacci :: Integer -> Integer
fibonacci n = fibonacci' 0 1 n where
    fibonacci' a b n | n == 0 = a
                     | n > 0 = fibonacci' (a + b) a (n - 1)
                     | n < 0 = fibonacci' b (a - b) (n + 1)