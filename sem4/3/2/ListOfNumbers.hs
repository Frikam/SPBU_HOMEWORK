listOfNumbers :: [Integer] 

listOfNumbers = 1:7:9: concatMap (\x -> [x * 10 + 1, x * 10 + 7, x * 10 + 9]) listOfNumbers
