# Data Structures and Algorithms

## References

- [Tech Interview Handbook](https://yangshun.github.io/tech-interview-handbook)
- [Geeks for Geeks](https://www.geeksforgeeks.org/)

---

## Table of Contents

1. [Array](#array)

## Array

| Problem Statement                                                                                           |                                     Solution | Difficulty |
|:------------------------------------------------------------------------------------------------------------|---------------------------------------------:|:----------:|
| [Two Sum](https://leetcode.com/problems/two-sum/)                                                           |                    [Code](array/TwoSum.java) |    Easy    |
| [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)           | [Code](array/BestTimeToBuyAndSellStock.java) |    Easy    |
| [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)                                     |         [Code](array/ContainsDuplicate.java) |    Easy    |
| [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)                 |  [Code](array/ProductOfArrayExceptSelf.java) |    Easy    |
| [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)                                         |           [Code](array/MaximumSubarray.java) |    Easy    |
| [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)                         |    [Code](array/MaximumProductSubarray.java) |   Medium   |
| [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | [Code](array/MinimumRotatedSortedArray.java) |   Medium   |
| [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)             |  [Code](array/SearchRotatedSortedArray.java) |   Medium   |
| [3Sum](https://leetcode.com/problems/3sum/)                                                                 |                  [Code](array/ThreeSum.java) |   Medium   |
| [Container with Most Water](https://leetcode.com/problems/container-with-most-water/)                       |    [Code](array/ContainerWithMostWater.java) |   Medium   |

## Binary

> Some helpful utilities
>
> - Test k<sup>th</sup> bit is set: `n & (1 << k) != 0`
> - Set k<sup>th</sup> bit: `n |= (1 << k)`
> - Clear k<sup>th</sup> bit: `n &= ~(1 << k)`
> - Toggle k<sup>th</sup> bit: `n ^= (1 << k)`
> - Check power of 2: `n & n - 1 == 0`
> - Check if number is odd: `n & 1 != 0`

| Problem Statement                                                         |                             Solution | Difficulty |
|:--------------------------------------------------------------------------|-------------------------------------:|:----------:|
| [Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/) | [Code](binary/SumOfTwoIntegers.java) |   Medium   |
| [Number of 1 bits](https://leetcode.com/problems/number-of-1-bits/)       |    [Code](binary/NumberOf1Bits.java) |    Easy    |
| [Counting Bits](https://leetcode.com/problems/counting-bits/)             |     [Code](binary/CountingBits.java) |   Medium   |
| [Missing Number](https://leetcode.com/problems/missing-number/)           |    [Code](binary/MissingNumber.java) |    Easy    |
| [Reverse Bits](https://leetcode.com/problems/reverse-bits/)               |      [Code](binary/ReverseBits.java) |    Easy    |
