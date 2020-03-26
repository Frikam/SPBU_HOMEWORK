positionOfNumber :: Integer -> [Integer] -> Integer
positionOfNumber number list = findPositionOfNumber number list 0

findPositionOfNumber number (x:xs) index = if number == x then index else findPositionOfNumber number xs (index + 1)