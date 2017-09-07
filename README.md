Generates a solution of the queens puzzle using 5- and 8- chunk fractals
  
The pattern of 5-chunk fractal (an arrow shows a start point):
``` 
     WW
           WW
    -> WW
   WW  
         WW
```          

The pattern of 8-chunk fractal (an arrow shows a start point):
```  
         WW
             WW
       WW
                   WW
  -> WW           
                 WW
           WW     
               WW
```
               
Each of these patterns represents a valid solution of the queens puzzle.
Every chunk is a fractal also.
  
At the moment I have tested this class against N * 5 and N * 5 * 8 queens.

3'125'000 queens placed in 4s (MacBook Air 1,6 GHz Intel Core i5).