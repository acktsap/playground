# Base patterns

## Solving

1. Understand carefully
2. Modeling (including data structure, solving strategy)
3. Validate it
4. Test with corner case (like -1, 0, 1)

## Data structure

### Canonicalization

A process for converting data that has more than one possible representation into a standard form.\
It reduces complexity by abstraction (or modeling) for computational world.

eg. 2/4, 3/6 -> 1/2

### Separate data with an algorithm

```java
// from
String getMonthName(int month) {
  if (mount == 1) return "January";
  if (mount == 2) return "February";
  if (mount == 3) return "March";
  return "December";
}

// to
String[] monthName = { "January", "February", "March", "December" };
String getMonthName(int month) {
  return monthName[month - 1];
}

// from
void move(int direction) {
  if (direction == 1) moveLeft();
  if (direction == 2) moveRight();
}

// to
int[] movement = { -1, 1 };
void move(int direction) {
  moveTo(movement[direction - 1]);
}
```

## Modeling

### Explicit Formula (점화식)

eg. sum until n

- For n >= 2, f(n) = f(n-1) + n
- For n == 1, f(n) = 1

## Priving

### Loop dominates Time Complexity

Big-O Notation : 가장 빨리 증가하는 항만 제외하고 다 버림

Approximately, 100_000_000 loop ~ 1 second. Not sure.

```java
// O(1) : Constant
System.out.println("Hello world");

// O(N * log(N))
Collections.sort()

// O(N) : Linear
for (int i = 0; i < N; ++i) {
  // do something
}

// O(N^2)
for (int i = 0; i < N; ++i) {
  for (int j = 0; j < N; ++j) {
    // do something
  }
}
```

### Mathematical Induction (수학적귀납법)

1. Clarify the step
2. Prove an algorithm on n == 1
3. Prove that if an algorithm satisfies on n, then also n + 1

eg. 100개의 도미노

1. step : 도미노 하나
2. 도미노 하나를 쓰터트린다
3. 도미노 하나가 쓰러지면, 다음 도미노도 쓰러진다

### Loop Invariant

## Writing

### Use half-open interval in a range

`[a, b)` (a <= value && value < b)

- Easy to represent empty range with `[a, a)`
- Easy to evaluate length of range by `b - a`

### Always init on declaration

```java
// from
int[] arr;

// to
int[] arr = { 1, 2, 3 };
```

### No floating point operation if possible

Floating point operation is slow, inaccurate

```java
// from
sqrt((a - b) * (a - b)) == r

// to
(a - b) * (a - b) == (r * r)
```

## Debugging

### Logging middle result

```java
int sum = 0;
for (int i = 0; i < 3; ++i) {
  sum += i;
  System.out.format("i: %d, sum: %d\n", i, sum);
}
```

### Use assert on precondition

```cpp
void f(int next, int sum) {
  assert next < 3
}
```