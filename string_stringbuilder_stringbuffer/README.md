


## String, StringBuilder , StringBuffer 에 대해 알아보자


### 공통점?

- 자바에서 문자열을 다루게 해주는 클래스들이다.

- 뭘 사용해도 상관없지만.. **특정한 상황**에서 이슈가 있을 수 있다.
	- 연산횟수가 많다.
	- 멀티 쓰레딩




### String

**Immutable** (불변)하다.

**불변성?**
	- 생성된 인스턴스를 변경할 수 없음을 의미한다.
	- 따라서 Thread-Safe 함




**불변성으로 인해 알고리즘 문제 풀이에 발생될 수 있는 상황**


```java
String s = "hi";
s = s + "I am a human";
```

- 위의 코드는 `s`라는 변수가 가리키고 있는 힙의 `"hi"` 라는 문자열 그 자체를 바꾸는 것이 아니다.

- 두번째 줄에서 `s` 가 재할당 되면서 기존의 "hi" 는 힙 메모리에서 garbage가 되어 `GC` 대상이 된다.

- 즉 문자열의 재할당은 새로운 String 인스턴스를 만들어 내는 것이라고 볼 수 있다.
	
- 문자열의 추가, 수정, 삭제 연산이 빈번한 알고리즘에서 String 클래스를 사용할 경우 힙 메모리에 많은 부하가 전해져 성능적으로 좋지 않다.





<br>



### StringBuilder & StringBuffer

**Mutable** 하다.

- 새로운 인스턴스를 만들어 다시 가리키는게 아니라 객체 내의 문자열 그 자체를 변경하고 삭제할 수 있다.
	- 빈번한 문자열 작업이 필요할 경우 효율적이다.




### 둘의 차이는 뭔가요?

**StringBuilder**

- Thread-Safe 하지 않다.(동시성을 지원하지 않는다.)
- 단일 스레드 환경에서 사용해야 한다.
	- 동기화를 고려하지 않아 성능이 매우 좋다.



**StringBuffer**

- Thread-Safe 함
	- Synchronized 키워드를 지원함

- 동기화 때문에 StringBuilder 보다 느림



### 결론

1. **문자열 연산이 별로 없는 경우**에는 그냥 `String` 을 쓰자

2. 알고리즘 문제 풀이에서 다중 스레드나 병렬처리 문제에 대해 신경쓸 필요 없다.
	- 바꾸기 지우기 붙이기 등의 **문자열 연산이 많다**면 `StringBuilder` 를 사용하자.





### 간단한 StringBuilder 사용법


**StringBuilder 타입으로 인스턴스화**

```java
        StringBuilder sb = new StringBuilder();
```


**출력할때는?**

```java
        System.out.println(sb.toString());
```



**String 과 동일한 메소드**

- charAt();
- indexOf();
- length();
- replace();
- substring();
- toString();


**다른 주요 메소드**

- append(String str);
	- StringBuilder 내의 문자열에 문자열을 이어붙인다.

```
        //sb:StringBuilder

        sb.append("붙일 문자열").append("\n");
        sb.append("또 붙일래");
```

- delete(int start, int end);
	- 시작점, 끝점인 두 매개변수를 받아 그 사이의 문자열을 제거한다.
	- 범위는 substring과 같다.


```java
        sb.append("도레미파솔라시도");
        sb.delete(1,3);
        // sb : 도파솔라시도
```

- deleteCharAt(int index)
	- 해당 위치 문자 제거


- reverse()
	- StringBuilder 내의 문자열을 뒤집어 준다.






