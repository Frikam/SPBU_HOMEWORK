sumOfDigit :: Integer -> Integer
sumOfDigit 0 = 0
sumOfDigit x = (x `mod` 10) + sumOfDigit(x `div` 10)