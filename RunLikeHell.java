// Justin Lugo
// COP 3503C, Fall 2021

import java.util.*;

public class RunLikeHell
{
  public static int maxGain(int [] blocks)
  {
    // Here is the DP solution to the RunLikeHell problem. It helped me to draw out a diagram to
    // approach actually coding up a solution.

    // Declare variables, including an array to store our max values; Java automatically
    // initializes all contents to 0.
    int a = 0, b = 0;
    int [] max = new int [blocks.length + 1];

    // Base cases.
    // If there are no blocks, we return 0 because we are dead.
    if (blocks.length == 0 || blocks == null)
    {
      return 0;
    }
    // If only one block, we take the only route.
    else if (blocks.length == 1)
    {
      return blocks[0];
    }

    // Store the first value of our blocks array (index 0) at index 1 in our max array.
    max[1] = blocks[0];

    // Should our blocks array have 2 or more values stored within, we find our "max gain",
    // utilizing bottom-up methodology and starting at our third index.
    for (int i = 2; i <= blocks.length; i++)
    {
      // Add previous block value and max value two steps back (which would be first index in first
      // loop) into a.
      a = blocks[i - 1] + max[i - 2];
      // System.out.println("a = " + a);

      // Store max array value at previous index in b.
      b = max[i - 1];
      // System.out.println("b = " + b);

      // Find the max of the two integers we've found, and store the result in the max array at the
      // current index, as part of our process to determine which jumps we make to get the max
      // value possible..
      max[i] = Math.max(a, b);
      // System.out.println("Max: " + max[i]);
    }

    // Finally we are at the end and return our max, which is being stored at the end of our array.
    return max[blocks.length];
  }

  public static double difficultyRating()
  {
    // Function to return how difficult I felt the assignment was; DP is not my forte.
    return 4.0;
  }

  public static double hoursSpent()
  {
    // Function to return how many hours I spent on the assignment.
    return 7.5;
  }
  // Sorry this one is late, I had major burnout prepping for finals.
}
