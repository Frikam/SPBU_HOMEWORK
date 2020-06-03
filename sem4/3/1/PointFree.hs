func1 x l = map (\y -> y*x) l

func2 x = map (\y -> y*x)

func3 x = map (*x)

func = map . (*) 
