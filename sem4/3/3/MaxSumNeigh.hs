maxNeighSum :: [Int] -> Int

maxNeighSum (x:[]) = error "Length of list must be more than 2"
maxNeighSum (x:y:[]) = error "Length of list must be more than 2"  
maxNeighSum x = maxNeighSum' x 0 2 2
 
maxNeighSum' (x:y:z:[]) max index currentIndex = if x + z > max 
                    then currentIndex  
                    else index                                                                   
maxNeighSum' (x:y:z:xs) max index currentIndex = if x + z > max
                    then maxNeighSum' (y:z:xs) (x + z) currentIndex (currentIndex + 1)
                    else maxNeighSum' (y:z:xs) max index (currentIndex + 1)
                                                             
