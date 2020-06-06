import Control.Monad
import System.Random

data BinTree a = Null | Leaf a | Branch a (BinTree a) (BinTree a) deriving (Show, Eq)

add :: Ord a => a -> BinTree a -> BinTree a
add elem Null = Leaf elem
add elem (Leaf a) | elem >= a = Branch a Null (Leaf elem) 
                  | elem < a = Branch a (Leaf elem) Null
add elem (Branch a left right) | elem >= a = Branch a left (add elem right)
                               | elem < a = Branch a (add elem left) right

remove :: Ord a => a -> BinTree a -> BinTree a
remove elem (Leaf a) = if a == elem then Null else Leaf a 
remove elem (Branch a left right) | elem == a && right == Null = left
                                  | elem == a && left == Null = right
                                  | elem == a = Branch (nextElem) left (remove nextElem right)
                                  | elem > a = Branch a left (remove elem right)
                                  | elem < a = Branch a (remove elem left) right
                                    where nextElem = findNextElem right

findNextElem :: Ord a => BinTree a -> a
findNextElem (Leaf a) = a
findNextElem (Branch a left right) | left == Null = a 
                                   | otherwise = findNextElem left
                                            

isContains :: Ord a => a -> BinTree a -> Bool
isContains elem Null = False
isContains elem (Leaf a) = elem == a
isContains elem (Branch a left right) = if (a == elem) then True else isContains elem left || isContains elem right

treeSize :: BinTree a -> Integer
treeSize Null = 0
treeSize (Leaf a) = 1
treeSize (Branch a left right) = 1 + treeSize left + treeSize right

getTreeWithRandomValues :: BinTree a -> IO (BinTree Integer)
getTreeWithRandomValues Null = return Null
getTreeWithRandomValues (Leaf a) = do value <- randomIO :: IO Integer
                                      return (Leaf value) 
getTreeWithRandomValues (Branch a left right) = do value <- randomIO :: IO Integer
                                                   l <- getTreeWithRandomValues left
                                                   r <- getTreeWithRandomValues right
                                                   return $ Branch value l r

treeHeight Null = 0
treeHeight (Leaf a) = 1
treeHeight (Branch a left right) = 1 + max (treeHeight(left)) (treeHeight(right))

testTree1 = (Branch 4 (Leaf 1) (Leaf 5))

testTree2 = (Branch 4 
                (Branch 2 
                    (Leaf 1) (Leaf 3))
                (Branch 6 
                    (Leaf 5) (Leaf 8)))


testTree3 = (Branch 4 
                (Branch 2 
                    (Leaf 1) (Leaf 3))
                (Branch 7 
                    (Leaf 5) (Branch 9 (Null) (Leaf 10))))

main = do putStrLn ("Tree : " ++  show testTree2)
          putStrLn ("Add to tree 10")
          putStrLn (show (add 10 testTree2))

          putStrLn ""
          putStrLn ("Tree : " ++  show testTree2)
          putStrLn ("Remove from tree 4")
          putStrLn (show (remove 4 testTree2))

          putStrLn ""
          putStrLn ("Tree : " ++ show testTree1)
          putStrLn ("Tree size : " ++ show (treeSize testTree1))

          putStrLn ""
          putStrLn ("Tree : " ++ show testTree3)
          putStrLn ("Tree height : " ++ show (treeHeight testTree3))

          putStrLn ""
          putStrLn ("Tree : " ++ show testTree3)
          putStrLn ("Tree with random values : " ++ show (getTreeWithRandomValues testTree3))