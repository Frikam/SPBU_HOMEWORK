infinityList :: [Integer]
infinityList = map (\x -> if x `mod` 2 == 0 then -1 else 1) [1, 2 ..]

infinityList' :: [Integer]
infinityList' = zipWith (*) infinityList [1, 2 ..]
