# explore-kotlin

## Higher Order Functions

### Passing Function as a argument

-   Below is an Higher Order Function which takes an argument and returns a result
```
fun operation(x : Int, y :Int , op : (Int, Int)-> Int): Int {
    return op(x, y)
}

fun sum(x: Int,y: Int) = x +y

### Invoking the Higher Order Function

```

### Invoking Higher Order Functions

-   Invoking the Higher Order Function using Method Reference

```
    println(operation(1, 2, ::sum))
```

-   Invoking the Higher Order Function using Lambda

```
    println(operation(1, 2) { x, y -> x + y })

```

