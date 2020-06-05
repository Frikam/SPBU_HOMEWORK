listOfPairwiseNumbers :: Integer -> [Integer]

listOfPairwiseNumbers n = [1..n] >>= \x -> [1..n] >>= \y -> return (x * y)