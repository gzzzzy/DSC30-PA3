# Runtime Analysis

## Task 1. Testing Insertion Sort vs. Merge Sort vs. Tim Sort

- Dataset sizes = {10000, 20000, 40000, 80000, 160000}
- time unit: millisecond

| Dataset Size | Insertion Sort | Merge Sort | Tim Sort (run size: 16) |
| :----------: | :------------: | :--------: | :---------------------: |
|    10000     |       33       |     3      |           13            |
|    20000     |       65       |     4      |           36            |
|    40000     |      264       |     7      |           98            |
|    80000     |      883       |     15     |           392           |
|    160000    |      3813      |     31     |          2062           |

![](task1.jpg)

As the picture depicts above, when dataset sizes doubles, these three sort algorithms' performance varies from each other. Insertion sort takes O(n) time complexity

## Testing Tim Sort Cutoff Values

- Dataset size = 200,000
- Cutoff Values for Run Size = {4, 8, 16, 32, 64, 128}

| Run Size | Time (unit: ms) |
| :------: | :-------------: |
|    4     |      2886       |
|    8     |      1263       |
|    16    |       630       |
|    32    |       318       |
|    64    |       165       |
|   128    |       85        |

![](task2.jpg)
