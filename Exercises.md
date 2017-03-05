# Exercises / Session 1

Solve the first 5 problems of [Project
Euler](https://projecteuler.net/archives).

# Exercises / Session 2

## Exercise 1

Create an `Iterator` subclass which iterates over an array. The array
to be iterated over should be provided as a constructor argument.
Write a small test that checks that your implementation is correct.

## Exercise 2

- Create at least 3 different types of collections (e.g., `ArrayList`,
  `LinkedList`, and `Vector`), and initialize them with 100'000 random
  integers. In order to generate pseudo-random numbers utilize the
  class `java.util.Random`.

- Make use of a *seed value* to ensure all collections contain exactly
  the same elements.

- Use Java's `assert` statement to check that all collections contain
  the same elements.

- Learn how to enable and disable assertions by studying the following guide:
  https://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html#enable-disable

## Exercise 3

- Compare the performance of the 3 different collection types created
  in exercise 2 by measuring the time it takes to traverse each
  collection using an iterator (from beginning to end). Use
  [`System.nanoTime()`](https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#nanoTime())
  for measuring wall-clock execution time.

- Reverse the traversal order and measure again. Try to find out why
  `ArrayList` is so much faster than `LinkedList` in this situation.

- For each collection type, measure the time it takes to compute the
  sum of 100'000 elements retrieved from random positions. Precompute
  the 100'000 positions you will use and store them in an array to
  avoid measuring the execution time of `Random.nextInt()`.

## Exercise 4

- Find out how to sort arrays, as well as different collection
  types. For this, study the [Java API
  documentation](https://docs.oracle.com/javase/7/docs/api/), and
  write small example programs.

