import Control.Monad

getFirstLocalMax :: [Integer] -> Maybe Integer
getFirstLocalMax (x:tail@(y:z:xs)) = mplus (if y > z && y > x then Just y else Nothing) (getFirstLocalMax tail)
getFirstLocalMax x = Nothing