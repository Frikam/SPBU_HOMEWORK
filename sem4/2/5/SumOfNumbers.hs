sumOfNumbers :: [Integer] -> [Integer] -> [Integer] -> [Integer]
sumOfNumbers x y z =  sumOfNumbers' x (sumOfNumbers' y z)

sumOfNumbers' :: [Integer] -> [Integer] -> [Integer]
sumOfNumbers' [] [] = []
sumOfNumbers' (x:xs) [] = x : sumOfNumbers' xs []
sumOfNumbers' [] (y:ys) = y : sumOfNumbers' [] ys
sumOfNumbers' (x:xs) (y:ys) = (x + y) : sumOfNumbers' xs ys 