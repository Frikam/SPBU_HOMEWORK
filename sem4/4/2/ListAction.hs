module List where

import System.IO
import Data.List

main = do
    hSetBuffering stdin LineBuffering
    actionsWithList []

actionsWithList list = do
    putStrLn "Enter a command 0 - exit, 1 - add value, 2 - remove value from list, 3 - print list"
    command <- getLine
    case command of
        "0" -> return ()
        "1" -> do putStrLn "Enter value :"
                  value <- getLine
                  actionsWithList $ addElement list $ read value    
        '2':_ -> do putStrLn "Enter value :"
                    value <- getLine
                    actionsWithList $ removeElement list $ read value
        '3':_ -> do putStrLn $ show list
                    actionsWithList list
        _ :_ -> actionsWithList list

addElement :: [Integer] -> Integer -> [Integer]
addElement [] value = [value]
addElement (x:xs) value = if value <= x then value : x : xs else x : addElement xs value


removeElement :: [Integer] -> Integer -> [Integer]
removeElement list value = if elem value list then delete value list else list
