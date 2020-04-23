diagonalList :: Integer -> [[Integer]]

diagonalList n = map (\x -> helper [1 .. n] x) [1 .. n] where 
                     helper list i = map (\x -> if i > x then i else x) list