decomposite :: Integer -> [[Integer]]

decomposite x = decomposite' 1 x where 
    decomposite' minElem maxElem | maxElem < 0 = []
                                 | maxElem == 0 = [[]]
                                 | otherwise = [x : xs | x <- [minElem..maxElem], xs <- decomposite' x (maxElem - x)] 
