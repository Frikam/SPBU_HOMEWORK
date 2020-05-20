module Queue where

import System.IO
import Control.Exception

data QueueElement = QueueElement {value :: String, priority :: Integer} deriving (Show)

main = do hSetBuffering stdin LineBuffering
          doLoop []

doLoop :: [QueueElement] -> IO()
doLoop queue = do
        putStrLn (show queue)
        command <- getLine
        case command of
            "0" -> return ()
            "1" -> do putStrLn "Enter value :"
                      value <- getLine
                      putStrLn "Enter priority :"
                      priority <- getLine
                      doLoop $ add queue (QueueElement value (read priority :: Integer)) 
            "2" -> do putStrLn "Enter priority :"
                      priority <- getLine
                      let result = getElem queue (read priority :: Integer) ""
                      putStrLn $ if result == "" then "Value not found" else "Value: " ++ result
                      doLoop queue 
            "3" -> do let highestPriority = getElementsWithHighestPriority queue (priority (head queue)) ""
                      putStrLn $ if highestPriority == "" then "List is empty" else "Result: " ++ highestPriority
                      doLoop queue
            "4" -> do putStrLn $ "Queue: " ++ getValues queue ""
                      doLoop queue
            _ :_ ->  doLoop queue

add :: [QueueElement] -> QueueElement -> [QueueElement]
add [] newElem = [newElem]
add (x:xs) newElem = if (priority x < priority newElem) 
                                            then newElem : (x:xs)
                                            else x : add xs newElem

getElem :: [QueueElement] -> Integer -> String -> String
getElem [] prior result = result
getElem (x:xs) prior result = if (priority x > prior)
                                    then getElem xs prior result
                                    else if (priority x == prior) 
                                                        then getElem xs prior (result ++ value x ++ " ")
                                                        else result

getElementsWithHighestPriority :: [QueueElement] -> Integer -> String -> String
getElementsWithHighestPriority [] highestPriority result = result
getElementsWithHighestPriority (x:xs) highestPriority result = if (priority x == highestPriority)
                                                                            then getElementsWithHighestPriority xs highestPriority (result ++ value x)
                                                                            else result
--Get values from queue without priority
getValues :: [QueueElement] -> String -> String
getValues [] result = result
getValues (x:[]) result = result ++ value x
getValues (x:xs) result = getValues xs (result ++ " " ++ value x ++ ", ")

--Get values from queue with priority
getValues2 :: [QueueElement] -> String -> String
getValues2 [] result = result
getValues2 (x:[]) result = result ++ "Value: " ++ value x ++ " Priority: " ++ show (priority x)
getValues2 (x:xs) result = getValues2 xs (result ++ "Value: " ++ value x ++ " Priority: " ++ show (priority x) ++ ", ")
