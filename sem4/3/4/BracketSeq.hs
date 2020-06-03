bracketSeq :: [Char] -> Bool

bracketSeq (x:xs) = bracketSeq' xs [x] where
    bracketSeq' [] [] = True
    bracketSeq' [] _ = False
    bracketSeq' (x:xs) (y:ys) = if (x == '}' && y == '{')
                                || (x == ')' && y == '(')
                                || (x == ']' && y == '[')
                                then bracketSeq' xs ys
                                else bracketSeq' xs (x:y:ys)
