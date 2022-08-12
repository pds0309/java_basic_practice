package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        findChildClassWithCode();
        findClassByName("reflection.Child");
        findNoArgsConstructorFromClass(Child.class);
        findSpecificArgsConstructorFromClass(Parent.class, String.class, int.class);
        findAllConstructorFromClass(Child.class);
        findSpecificMethodFromClass(Child.class, "getName");
        findSpecificMethodFromClass(Child.class, "getAge");
        invokeSpecificMethodFromClass(new Child(), "childHello");
        invokeSpecificMethodFromClass(new Parent(), "hello");
        getNewInstanceFromClass(new Parent());
        modifyFieldFromClass(new Parent(), "name", "kikiki");
    }

    /**
     * 클래스의 존재를 알고 있을 때
     */
    static void findChildClassWithCode() {
        Class<Child> clazz = Child.class;
        System.out.println("ClassName:" + clazz.getName());
        // Output
        // ClassName:reflection.Child
    }

    /**
     * 클래스의 이름만 알고 있을 떄
     *
     * @param className: 패키지 네임이 포함된 클래스 이름
     */
    static void findClassByName(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            System.out.println("ClassName:" + clazz.getName());
            // Output
            // ClassName:reflection.Child
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 클래스의 인자 없는 생성자를 출력한다.
     *
     * @param clazz: 클래스 정보
     */
    static void findNoArgsConstructorFromClass(Class<?> clazz) {
        try {
            // 인자 없는 생성자
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            System.out.println("constructor: " + constructor.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 클래스의 인자 있는 생성자를 출력한다.
     *
     * @param clazz: 클래스 정보
     * @param args   : 클래스 생성자의 인자들 타입 클래스 정보
     */
    static void findSpecificArgsConstructorFromClass(Class<?> clazz, Class<?>... args) {
        // 인자 있는 생성자
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor(args);
            System.out.println("constructor: " + constructor.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        // Output
        // constructor: reflection.Parent
    }

    /**
     * 클래스로부터 모든 생성자 정보를 출력한다.
     *
     * @param clazz : 클래스 정보
     */
    static void findAllConstructorFromClass(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.print("constructors : ");
        for (Constructor<?> cons : constructors) {
            System.out.print(cons + " ");
        }
        System.out.println();
        // Output
        // constructors : public reflection.Child() private reflection.Child(java.lang.String)
    }

    /**
     * 클래스의 특정 메소드를 찾아 출력한다.
     *
     * @param clazz:      클래스 정보
     * @param methodName: 찾으려는 메소드 이름
     * @param args:       메소드 파라미터 목록
     */
    static void findSpecificMethodFromClass(Class<?> clazz, String methodName, Class<?>... args) {
        try {
            Method method = clazz.getMethod(methodName, args);
            System.out.println("method:" + method.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param instance:  parent 계열의 인스턴스
     * @param methodName : 수행할 메소드 이름
     * @param args:      메소드 파라미터
     * @param <T>
     */
    static <T extends Parent> void invokeSpecificMethodFromClass(T instance, String methodName, Class<?>... args) {
        try {
            Method method = instance.getClass().getDeclaredMethod(methodName);
            method.setAccessible(true);
            method.invoke(instance, args);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 주어진 parent 객체를 통해 새 인스턴스를 생성한다.
     *
     * @param instance: parent 객체
     */
    static void getNewInstanceFromClass(Parent instance) {
        try {
            Constructor<Parent> constructor = (Constructor<Parent>) instance.getClass().getDeclaredConstructor();
            Parent parent = constructor.newInstance();
            System.out.println(instance == parent);
            // Output
            // false
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 입력받는 Parent 인스턴스의 특정 필드의 값을 변경한다.
     *
     * @param instance    : Parent 인스턴스
     * @param fieldName   : 변경하려는 멤버변수
     * @param changeValue : 변경하고자하는 값
     */
    static void modifyFieldFromClass(Object instance, String fieldName, Object changeValue) {
        Class<?> clazz = instance.getClass();
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            System.out.println("before change:" + field.get(instance));
            field.set(instance, changeValue);
            System.out.println("after change:" + field.get(instance));
            // Output
            // before change:parent
            // after change:kikiki
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
