-- x^2 + 2x + 3 represented as [3, 2, 1]
data Polynom = Polynom [Integer]

polynomSum :: Polynom -> Polynom -> Polynom
polynomSum (Polynom x) (Polynom y) = Polynom (sumLists x y)

sumLists :: [Integer] -> [Integer] -> [Integer]
sumLists [] y = y
sumLists x [] = x
sumLists (x:xs) (y:ys) = x + y : sumLists xs ys

polynomMult :: Polynom -> Polynom -> Polynom
polynomMult (Polynom x) (Polynom y) = Polynom (multLists x y)

multLists :: [Integer] -> [Integer] -> [Integer]
multLists xs ys = multLists' (map (\coeff -> map (*coeff) ys) xs) [] []
multLists' [] list _ = list 
multLists' (x:xs) list listFilledWithZeros = multLists' xs (sumLists list (listFilledWithZeros ++ x)) (0 : listFilledWithZeros)


showPolynom :: Polynom -> String
showPolynom (Polynom (x:xs)) = firstCoeff ++ if polynom == "" then "0" else polynom where
                                      polynom = showPolynom' xs 1
                                      firstCoeff = if x == 0 then "" else (show x)

showPolynom' :: [Integer] -> Integer -> String
showPolynom' [] power = ""
showPolynom' (x:xs) power = showCoeff x ++ showPower x power ++ showPolynom' xs (power + 1)

showCoeff :: Integer -> String
showCoeff coeff | coeff == 0 = ""
                | coeff < 0 = " - "  ++ if coeff == -1 then "" else show (-coeff)
                | coeff > 0 = " + " ++ if coeff == 1 then "" else show coeff
        

showPower :: Integer -> Integer -> String
showPower coeff power | coeff == 0 = ""
                      | power == 0 = ""
                      | power == 1 = "x"
                      | otherwise = "x^(" ++ show power ++ ")"


polynom1 = Polynom [3, 2, 1]
polynom2 = Polynom [5, 2, 0, -4]    

polynom3 = Polynom [3, 2, 1]
polynom4 = Polynom [-3, -2, -1]

main = do putStrLn "Polynom sum test"
          putStrLn ("Second polynom: " ++ (showPolynom polynom4))
          putStrLn ("First polynom: " ++ showPolynom polynom3)
          putStrLn ("Sum : " ++ showPolynom (polynomSum polynom3 polynom4))

          putStrLn "Polynom multiplication test"
          putStrLn ("First polynom: " ++ showPolynom polynom1)
          putStrLn ("Second polynom: " ++ (showPolynom polynom2))
          putStrLn ("Multiplication : " ++ showPolynom (polynomMult polynom1 polynom2))

