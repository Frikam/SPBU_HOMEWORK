checkList :: [a] -> (a -> Bool) -> Bool

checkList [] f = True
checkList (x:xs) f = if f x then checkList xs f else False