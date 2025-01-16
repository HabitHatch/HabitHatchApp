//[HabitHatch](../../index.md)/[com.habithatch.demo.core.util](index.md)/[getNextHigherOrLowest](get-next-higher-or-lowest.md)

# getNextHigherOrLowest

[app]\
fun &lt;[T](get-next-higher-or-lowest.md), [R](get-next-higher-or-lowest.md) : [Comparable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparable/index.html)&lt;[R](get-next-higher-or-lowest.md)&gt;&gt; [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;[T](get-next-higher-or-lowest.md)&gt;.[getNextHigherOrLowest](get-next-higher-or-lowest.md)(bySelector: ([T](get-next-higher-or-lowest.md)) -&gt; [R](get-next-higher-or-lowest.md), element: [T](get-next-higher-or-lowest.md)): [T](get-next-higher-or-lowest.md)

Returns the next higher element in the collection, based on the given selector.

#### Return

The next higher element in the collection.

#### Parameters

app

| | |
|---|---|
| bySelector | The selector to determine the order of the elements. |
| element | The element to find the next higher element for. |

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-illegal-argument-exception/index.html) | If the collection is empty. |