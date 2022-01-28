
### ConcurrentModificationException 

---


- MultiThread 또는 객체의 변경이 허용되지 않는 환경에서 modification이 일어날 때 발생
- 한 쪽에서 Collection을 Iterating 할 때 다른 스레드에서 Collection 변경을 할 경우 발생
- 다중스레드환경 뿐 아니라 fail-fast iterating 도중 변경이 일어나면 발생함

### fail-fast iterating

- iterator 의 remove 메소드 이외의 코드로 Collection 수정 시 예외 발생
- Collection 내부에 modCount 라는 카운팅 변수가 있다.
  - 컬렉션 항목 추가 또는 제거 시 해당 카운트가 증가한다.
  - 반복 시(foreach) next() 호출에서 modCount의 현재 값이 초기 값과 비교된다.
  - Iterator자체를 통해 remove 하면 괜찮지만 
    그냥 Collection 의 remove를 내부에서 사용할 경우 안전하지 않다.
    
### fail-safe iterating

- Collection 의 사본을 만들어 반복함
- 반복자가 작성된 후 수정이 발생해도 사본은 그대로 유지되어 Collection 에 직접접근해 수정해도 계속반복됨
- 반복되는 동안 collection 수정 시 iterator가 보는 것이 보장되지 않음
- Iterator가 실제 콜렉션 대신 복제본에서 작업하고 있기 때문에 콜렉션에서 업데이트 된 데이터를 반환하지 않는다
- 시간과 메모리 소비 큼
- ConcurrentHashMap, CopyOnWriteArrayList, ConcurrentSkipListSet
  - thread-safe 하며 순회 용도로 적합하다.

[ref](https://www.baeldung.com/java-fail-safe-vs-fail-fast-iterator)








fail-fast iterating Collection 사용해서 루프돌면서 값 변경할 때 발생가능


```java
    public static void genExceptionInList() {
        for (String num : basicList) {
            if (Integer.parseInt(num) % 2 == 0) {
                basicList.remove(num);
            }
        }
    }
```

내부적으로 ArrayList 의 remove(Object o) 메소드는 어떻게 돌아갈까??

```java
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }
```

fastRemove(index)

- remove method that skips bounds checking and does not return the value removed.
- modeCount 를 증가시켜주고 있다.

```java
    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // clear to let GC do its work
    }
```

- foreach 문에서 처음에 Collection 에 대해 Itr 내부클래스 초기화 시 expectedModCount 를 할당한다.
- 해당클래스의 next() 메소드로 반복을하게된다.  
- 내부에서 collection을 통해 remove 시 modCount 는 1개가 증가하게 된다.
- 다음 루프에서 이전에 할당되어있던 expectedModCount 를 Itr 클래스의 next() 메소드에 있는
  checkForComodification() 메소드를 통해서 기존의 expectedModCount와 modCount를 비교한다.
- 두 값이 다르면 ``` throw new ConcurrentModificationException();``` 던진다.



### 해결하기

1. Iterator를 직접 사용한 변경 

- removeIf(Predicate<? super E> filter) 메소드 사용 
  - 자바 8 부터
  - Stream filter 사용이라고 생각하자

ArrayList 의 내부itr클래스의 remove() 메소드

```java
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
```
  

2. 복사본컬렉션 활용하기

```java
new CopyOnWriteArrayList<>();
```





**ConcurrentSkipListSet**

> ConcurrentSkipListSet is the concurrent SortedSet implementation, with most basic operations in O(log n). It allows concurrent adding/removing and reading/iteration, where iteration may or may not tell about changes since the iterator was created. The bulk operations are simply multiple single calls, and not done atomically – other threads may observe only some of them.

> Obviously you can use this only if you have some total order on your elements. This looks like an ideal candidate for high-concurrency situations, for not-too-large sets (because of the O(log n)).



**CopyOnWriteArraySet**

> The CopyOnWriteArraySet is a quite simple implementation - it basically has a list of elements in an array, and when changing the list, it copies the array. Iterations and other accesses which are running at this time continue with the old array, avoiding necessity of synchronization between readers and writers (though writing itself needs to be synchronized). The normally fast set operations (especially contains()) are quite slow here, as the arrays will be searched in linear time.


[ref](https://stackoverflow.com/questions/6720396/different-types-of-thread-safe-sets-in-java)

[관련 참조해서 공부하기](https://goneoneill.tistory.com/47)