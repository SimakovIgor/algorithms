If you already understand big O, you can skip this article.
Big O is a notation used to describe the computational complexity of an algorithm. The computational complexity of an
algorithm is split into two parts: time complexity and space complexity. The time complexity of an algorithm is the
amount of time the algorithm needs to run relative to the input size. The space complexity of an algorithm is the amount
of memory allocated by the algorithm when run relative to the input size.

Typically, people care about having a better time complexity more than having a better space complexity.
Complexity is described by a function of variables that can change with the input. The most common variable is
n
n, which usually describes the length of an input array or string. This function is wrapped by a capital O. Here are
some example complexities:

* O(n)
* O(n ^ 2)
* O(2 ^ n)
* O(log n)
* O(n ⋅ m)

These functions describe how the amount of operations/memory needed by the algorithm grows as the arguments tend to
infinity. Because the variables are tending to infinity, constants are always ignored. That means that
O (9999999 n) = O(8 n)= O(n)= O(n 500)

This also means that addition/subtraction between terms of the same variable can also be ignored. For example,
O(2^n + n^2 − n)=O(2^n), because as
n tends to infinity, 2^n completely dominates the other two terms.

Being able to analyze an algorithm and derive it's time and space complexity is a crucial skill. Interviewers will
almost always ask you for your algorithm's complexity to check that you actually understand your algorithm and didn't
just memorize/copy the code. Being able to analyze an algorithm also enables you to determine what parts of it can be
improved.

The best complexity possible is
O(1), called "constant time" or "constant space". It means that the algorithm ALWAYS uses the same amount of resources,
regardless of the input.
When talking about complexity, there are normally three cases:

Best case scenario
Average case
Worst case scenario
In most cases, all three of these will be equal, but some algorithms will have them differ. If you have to choose one to
call the algorithm's time or space complexity, never choose the best case scenario. It is most correct to use the worst
case scenario, but you should be able to talk about the difference between the average case and worst case.

Analyzing time complexity

Let's look at some example algorithms in pseudo-code and talk about their time complexities.

Given an array "arr" with length n,

for (int num: arr) {
print(num)
}
This algorithm has a time complexity of
O(n). In each for loop iteration, we are performing a print, which costs
O(1). The for loop iterates
n times, which gives a time complexity of
O(1⋅n)=O(n).

Given an array "arr" with length n,

for (int num: arr) {
for (int i = 0; i < 500,000; i++) {
print(num)
}
}
This algorithm has a time complexity of
O(n). In each inner for loop iteration, we are performing a print, which costs
O(1). This for loop iterates 500,000 times, which means each outer for loop iteration costs
O(500000)=O(1). The outer for loop iterates
n times, which gives a time complexity of
O(n).

Even though the first two algorithms technically have the same time complexity, in reality the second algorithm is much
slower than the first one. It's correct to say that the time complexity is
O(n), but it's important to be able to discuss the differences between practicality and theory.

Given an array "arr" with length n,

for (int num: arr) {
for (int num2: arr) {
print(num * num2)
}
}
This algorithm has a time complexity of
O(n 2). In each inner for loop iteration, we are performing a multiplication and print, which both cost
O(1). The inner for loop runs
n
n times, which means each outer for loop iteration costs
O(n). The outer for loop runs
O(n) times, which gives a time complexity of

O(n⋅n)=O(n 2).

Sometimes, work is done by an algorithm that isn't included in the time complexity. For example, here we said that
multiplication costs

O(1). Multiplication takes longer on larger numbers, but
n has nothing to do with the size of the numbers in the array. We could introduce another variable
k that is the largest number in the array, but this is unnecessary for integers in algorithm problems.
Given an array "arr" with length n,
Given an array "arr2" with length m,

for (int num: arr) {
print(num)
}

for (int num: arr) {
print(num)
}

for (int num: arr2) {
print(num)
}
This algorithm has a time complexity of
O(n+m). The first two for loops both cost
O(n), whereas the final for loop costs
O(m). This gives a time complexity of
O(2n+m) =
O(n+m).

Given an array "arr" with length n,

for (int i = 0; i < arr.length; i++) {
for (int j = i; j < arr.length; j++) {
print(arr[i] + arr[j])
}
}
This algorithm has a time complexity of
O(n 2). The inner for loop is dependent on what iteration the outer for loop is currently on. The first time the inner for
loop is run, it runs
n times. The second time, it runs
n−1 times, then
n−2,
n−3, and so on.

That means the total iterations is 1 + 2 + 3 + 4 + ... + n, which is the partial sum of this series, which is equal to
n⋅(n+1)
=
n
2

+

n
2
2
n
2
+n
​
. In big O, this is
O
(
n
2
)
O(n
2
) because the addition term in the numerator and the constant term in the denominator are both ignored.

Logarithmic time

A logarithm is the inverse operation to exponents. The time complexity
O
(
log
⁡
n
)
O(logn) is called logarithmic time and is extremely fast. A common time complexity is
O
(
n
⋅
log
⁡
n
)
O(n⋅logn), which is fast for most problems and also the time complexity of efficient sorting algorithms.

Typically, the base of the logarithm will be 2. This means that if your input is size n, then the algorithm will perform
x operations, where
2
x
=
n
2
x
=n. However, the base of the logarithm doesn't actually matter for big O.

O
(
log
⁡
n
)
O(logn) means that somewhere in your algorithm, the input is being reduced by a percentage at every step. A good example
of this is binary search, which is a searching algorithm that runs in
O
(
log
⁡
n
)
O(logn) time (there is a chapter dedicated to binary search later on). With binary search, we initially consider the
entire input (n elements). After the first step, we only consider n / 2 elements. After the second step, we only
consider n / 4 elements, and so on. At each step, we are reducing our search space by 50%, which gives us a logarithmic
time complexity.

Analyzing space complexity

When you declare variables and modify the data stored by said variables, your algorithm is allocating memory. We never
count the space used by the input (it is bad practice to modify the input), and don't count the space used by the
output (the answer) unless an interviewer asks us to.

Given an array "arr" with length n,

for (int num: arr) {
print(num)
}
This algorithm has a space complexity of
O
(
1
)
O(1). The only space allocated is an integer variable num, which is constant relative to
n
n.

Given an array "arr" with length n,

Array doubledNums = int[]

for (int num: arr) {
doubledNums.add(num * 2)
}
This algorithm has a space complexity of
O
(
n
)
O(n). The array doubledNums stores
n
n integers at the end of the algorithm.

Given an array "arr" with length n,

Array nums = int[]
int oneHundredth = n / 100

for (int i = 0; i < oneHundredth; i++) {
nums.add(arr[i])
}
This algorithm has a space complexity of
O
(
n
)
O(n). The array nums stores the first 1% of numbers in arr. This gives a space complexity of
O
(
n
100
)
O(
100
n
​
) =
O
(
n
)
O(n).

Given an array "arr" with length n,
Given an array "arr2" with length m,

Array grid = int[n][m]

for (int i = 0; i < arr.length; i++) {
for (int j = 0; j < arr2.length; j++) {
grid[i][j] = arr[i] * arr[j]
}
}
This algorithm has a space complexity of
O
(
n
⋅
m
)
O(n⋅m). We are creating a grid that has dimensions
n
⋅
m
n⋅m.

In this course, we will talk extensively about time and space complexity. If it's a new concept to you, don't worry -
with time, you will become more and more comfortable with analyzing algorithms on your own.