import Control.Monad

printRhombus n = mapM_ (\x -> putStrLn (concat(replicate (n - x) " ") ++ concat(replicate (2 * x - 1) "x") ++ concat(replicate (n - x) " ")))
              ([1 .. n] ++ [n - 1, n - 2 .. 1])