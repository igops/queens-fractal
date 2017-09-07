Obviously, the number of queens must satisfy a lot of conditions to have a fractal nature, so **do not use this code for solving the queens puzzle for N = any integer**.

The given solver generates a solution using multiple 5- chunk fractals and single wrapping 8- chunk pattern.
So, at the moment it can deal with 5, 8, 25, 200, 125, 1000, 625, 5000 ... and so on with N = k * 5 or k * 5 * 8.

Actually, 3'125'000 queens are placed in 4 seconds on MacBook Air 1,6 GHz Intel Core i5.
  
The pattern of 5-chunk fractal (an arrow shows a start point):
``` 
     WW
           WW
    -> WW
   WW  
         WW
```          

The optional wrapping pattern of 8-chunk fractal (an arrow shows a start point):
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
Every chunk is a fractal too and is a valid solution itself.

The patterns were found manually using a pen and a copybook while I've been obsessed by finding a quick solution for 1000 queens (inspired by [«"Simple" chess puzzle holds key to $1m prize» article](https://www.st-andrews.ac.uk/news/archive/2017/title,1539813,en.php). So, I've got a valid solution using 5 x 5 x 5 x 8 fractal chunks and probably will become a millionaire soon :).

A short profiling note:
3'125'000 queens placed in 4s (MacBook Air 1,6 GHz Intel Core i5).
