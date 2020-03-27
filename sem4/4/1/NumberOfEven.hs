numberOfEvenMap :: [Int] -> Int
numberOfEvenMap = sum . map (\x -> if even x then 1 else 0)

numberOfEvenFilter :: [Int] -> Int
numberOfEvenFilter = length . filter (even) 

numberOfEvenFoldr :: [Int] -> Int
numberOfEvenFoldr = foldr (\x y -> (+) x 1 `mod` 2 + y) 0