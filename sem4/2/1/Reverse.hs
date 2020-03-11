reverse :: [a] -> [a]
reverse list = reverse' [] list
    where 
        reverse' reversedList [] = reversedList
        reverse' reversedList (head:tail) = reverse' (head:reversedList) tails 
