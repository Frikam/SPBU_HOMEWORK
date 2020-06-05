data Tree a = Leaf a
                  | Branch (Tree a) a (Tree a)

instance Foldable Tree where
    foldr f list (Leaf a) = f a list
    foldr f list (Branch left value right) = foldr f (f value (foldr f list right)) left

getElements :: Tree a -> [a]
getElements = foldr (:) []

testTree = Branch(Branch (Leaf 3) 2 (Leaf 4)) 1 (Leaf 5)
