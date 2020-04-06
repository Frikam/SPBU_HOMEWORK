module PhoneBook where

import System.IO
import Control.Exception

data Contact = Contact {name :: String, number :: Integer} deriving (Show)

main = do hSetBuffering stdin LineBuffering
          actionsWithPhoneBook []

actionsWithPhoneBook :: [Contact] -> IO ()
actionsWithPhoneBook phoneBook = do
        putStrLn (show phoneBook)  --Для удобства после каждого действия выводиться список контактов      
        putStrLn "Enter a command where 0 - exit, 1 - add contact, 2 - find phonenumber by name, 3 - find name by phonenumber, 4 - save to file, 5 - get contacts frome file"
        command <- getLine
        case command of
            "0" -> return ()
            "1" -> do putStrLn "Enter name :"
                      name <- getLine
                      putStrLn "Enter number :"
                      number <- getLine
                      actionsWithPhoneBook $ (Contact name (read number :: Integer)) : phoneBook 
            "2" -> do putStrLn "Enter name :"
                      name <- getLine
                      getNumberByName name phoneBook
                      actionsWithPhoneBook phoneBook 
            "3" -> do putStrLn "Enter number :"
                      number <- getLine
                      getNameByNumber (read number::Integer) phoneBook
                      actionsWithPhoneBook phoneBook 
            "4" -> do putStrLn "Enter file name :"
                      fileName <- getLine
                      saveContactsToFile phoneBook fileName
                      actionsWithPhoneBook phoneBook
            "5" -> do putStrLn "Enter file name :"
                      fileName <- getLine
                      file <- readFile fileName
                      actionsWithPhoneBook $ getContactsFromFile file 
            _ :_ ->  actionsWithPhoneBook phoneBook

getNumberByName :: String -> [Contact] -> IO()
getNumberByName _ [] = putStrLn "Cant find this name in phonebook"
getNumberByName nameInPhoneBook (x:xs) = if name x == nameInPhoneBook 
                                                then do putStrLn (show (number x)) 
                                                else getNumberByName nameInPhoneBook xs

getNameByNumber :: Integer -> [Contact] -> IO()
getNameByNumber _ [] = putStrLn "Cant find this number in phonebook"
getNameByNumber numberInPhoneBook (x:xs) = if number x == numberInPhoneBook 
                                                then do putStrLn $ name x
                                                else getNameByNumber numberInPhoneBook xs

getContactsFromFile :: String -> [Contact]
getContactsFromFile fileData = map (\x -> Contact (head (words x)) (read (last(words x))::Integer)) $ lines fileData

saveContactsToFile :: [Contact] -> String -> IO ()
saveContactsToFile list fileName = bracket (openFile fileName WriteMode) hClose
                                    (\h -> hPutStrLn h $ concatMap (\contact -> name contact ++ " " ++ show (number contact) ++ ['\n']) list)