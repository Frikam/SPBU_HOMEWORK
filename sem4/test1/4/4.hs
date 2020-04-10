superMap :: [a] -> (a -> [b]) -> [b]

superMap x f =  concatMap f x
