# 상속

상속이라는 것은 부모가 자식에게 물려주는 행위를 말합니다.

- extends , implements 등으로 상속을 할 수 있고, 공통 클래스를 위로 올리고 한번에 정리하고 수정이 가능하기에 자주 사용합니다.
- 상속이라는 것을 하나의 확장의 개념으로 이해를 해야합니다.
    - 부모 클래스에 새로운 필드와 메서드가 추가되면 자식 클래스는 이를 상속받아 사용할 수 있다.
    - 부모 클래스에 새로운 필드와 메서드가 추가되어도 부모 클래스는 어떠한 영향도 받지 않습니다.
    - 따라서, 자식 클래스 멤버 개수는 부모 클래스보다 같거나 많습니다.

## 상속의 포함 관계

- 즉, 클래스 간의 관계를 분석하여 관계설정을 해줄 수 있습니다. (상속관계 : is -a / 포함관계 : has - a)

```java
public class Car {

    static final String company = "GENESIS"; // 자동차 회사
    String model; // 자동차 모델
    String color; // 자동차 색상
    double price; // 자동차 가격

    double speed;  // 자동차 속도 , km/h
    char gear = 'P'; // 기어의 상태, P,R,N,D
    boolean lights; // 자동차 조명의 상태

    Tire[] tire;
    Door[] door;
    Handle handle;

    public Car(String model, String color, double price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

		// 가변 길이의 배열을 받기 위함입니다.
    public void setTire(Tire ... tire) {
        this.tire = tire;
    }

    public void setDoor(Door ... door) {
        this.door = door;
    }

    public void setHandle(Handle handle) {
        this.handle = handle;
    }

    public double gasPedal(double kmh, char type) {
        changeGear(type);
        speed = kmh;
        return speed;
    }

    public double brakePedal() {
        speed = 0;
        return speed;
    }

    public char changeGear(char type) {
        gear = type;
        return gear;
    }

    public boolean onOffLights() {
        lights = !lights;
        return lights;
    }

    public void horn() {
        System.out.println("빵빵");
    }
}
```

## 단일 상속과 다중 상속

- 다중상속

  `Java` 는 기본적으로 다중상속을 허용하지 않습니다.

  **Why?**

    - 만약 자식 클래스에서 여러 부모 클래스를 가지게 되면, 관계가 어마무시하게 복잡해져서 구별할 수 있는 기능을 상실하기 때문입니다.

  **final**

    - `final`  은 수정할 수 없는 값으로 선언을 하는 것이다. 하지만, 여기서 의문을 가질 수 있다. 상속 받은 클래스에서 변형을  하지 않으면 사용할 수 있지 않을까?

      정답은, **아닙니다!** 상속은 무조건 Overriding 이라는 개념이 같이 따라 다닙니다. 그래서 `final` 은 상속 자체가 불가 합니다.



---

## @Overriding & Super()

- Overriding

  `@Overriding` 이라는 것은 부모 클래스로 부터 상속 받은 것을 재정의 하는 과정을 말합니다.

    - 선언부가 부모 클래스와 동일해야 합니다.
    - 접근 제어자를 좁혀서 재정의 불가합니다.
    - 예외는 부모 클래스의 메서드 보다 많이 선언 할 수 없습니다.
- super

  `super`  는 생성자와 관련이 있는 녀석입니다. 즉, 부모 클래스의 멤버를 참조할 수 있는 키워드 입니다.

    - 객체 내부 생성자 및 메서드에서 부모 클래스의 멤버에 접근하기 위해서 사용할 수 있습니다.
    - **자식 클래스 내부에서 선언한 멤버와 부모 클래스에서 상속받은 멤버와 이름이 같은 경우 이를 구분하기 위해서 사용됩니다.**

    ```java
    public class SportsCar extends Car{
        String engine;
    
        String model = "Ferrari"; // 자동차 모델
        String color = "Red"; // 자동차 색상
        double price = 300000000; // 자동차 가격
    
        public SportsCar(String engine) {
            this.engine = engine;
        }
    
        public void booster() {
            System.out.println("엔진 " + engine + " 부앙~\n");
        }
    
        public void setCarInfo(String model, String color, double price) {
            super.model = model; // model은 부모 필드에 set
            super.color = color; // color는 부모 필드에 set
            this.price = price; // price는 자식 필드에 set
        }
    
        @Override
        public double brakePedal() {
            speed = 100;
            System.out.println("스포츠카에 브레이크란 없다");
            return speed;
        }
    
        @Override
        public void horn() {
            booster();
        }
    }
    ```

  ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/83c75a39-3aba-4ba4-a792-7aefe4b07895/0c3ab262-9084-42c0-89ef-3b20ed05128a/Untitled.png)

- super()

  `super()` 자신이 상속받은 부모의 생성자를 호출하는 메서드입니다.

    - 상속에서의 생성자는 상속되지 않는 유일한 멤버함수이다. 따라서 부모클래스의 멤버를 초기화하기 위해서는 당연히 부모클래스의 생성자를 호출해야 할 것 입니다. 즉, 자식클래스 생성자를 호출할 때 부모클래스 생성자도 동시에 호출 해야합니다. 이때, `super()` 를 사용하여 부모 생성자를 호출해주는 메서드를 추가해줍니다.
    - 단, **부모클래스에 기본 생성자가 아닌 매개변수를 가지는 생성자가 있다면(=부모클래스에서 생성자가 오버로딩이 가능할 경우) 자동으로 추가되지 않습니다. (=묵시적 제공을 하지 않음)**


---

## 다형성과 InstanceOf()

**다형성이란, 여러 가지 형태를 가질 수 있는 능력을 말합니다.**

- 자동 타입변환
    - 서로 다른 두개의 클래스가 있는데  a 가 b를 상속 받은 경우를 생각해봅시다.
        - 이 경우에는 `b num = new a();` 가 가능하다는 의미입니다.
        - **하지만, a 안에 있는 메서드를 부를 수 없습니다. 그리고, 반대의 경우는 불가능합니다.**
- 강제 타입 변환(Casting)
    - 단, 자동 형변환이 된 객체들만 다시 강제 타입변환을 통해서 원래의 형태로 돌아갈 수 있는 것입니다.
    - `B num = new a();` → `A num = new a()`

다형성의 기능으로 인해 해당 클래스 객체의 원래 클래스 명을 체크하는 것이 필요한데 이때 사용할 수 있는 명령어가 `instanceOf()` 입니다.

```java
// 다형성

class Parent { }
class Child extends Parent { }
class Brother extends Parent { }

public class Main {
    public static void main(String[] args) {

        Parent pc = new Child();  // 다형성 허용 (자식 -> 부모)
        Parent p = new Parent();

        System.out.println(p instanceof Object); // true 출력
        System.out.println(p instanceof Parent); // true 출력
        System.out.println(p instanceof Child);  // false 출력

        Parent c = new Child();

        System.out.println(c instanceof Object); // true 출력
        System.out.println(c instanceof Parent); // true 출력
        System.out.println(c instanceof Child);  // true 출력

    }
}
```

---

## Abstract

미완성된 설계도라고 표현할 수 있다. 즉, 형식만 정의하고 자식 클래스에서 구현해서 사용하는 방식입니다.

```java
public abstract class ClassName{

}
```

- 추상 클래스는 추상 메서드를 포함할 수 있고, 추상 메서드가 없어서 추상 클래스로 선언이 가능합니다.
- 추상 클래스는 자식 클래스에 상속되어 자식 클래스에 의해서만 완성 될 수 있습니다.
- 추상 클래스는 여러 개의 자식 클래스들에서 공통적인 필드나 메서드를 추출해서 만들 수 있습니다.

---

## Interface

두 객체의 다리 역할을 해주는 형식입니다.

상속 관계가 없는 다른 클래스들이 서로 동일한 행위 즉, 메서드를 구현해야할 때 인터페이스는 구현 클래스들의 동인한 사용 방법과 행위를 보장해 줄 수 있습니다.

```java
public interface InterfaceName{

}
```

- 모든 변수가 `public static final`  이어야 합니다. 다만, 없어도 알아서 추가 해줍니다.
- 해당 인터페이스를 `implemens` 라는 키워드로 받아서 구현합니다.
- **만약, 인터페이스의 추상 메서드를 일부만 구현해야 한다면 해당 클래스를 추상 클래스로 변경해주면 됩니다.**
- 인터페이스 간의 상속도 가능합니다. 이때는 `extends` 키워드를 사용합니다. **이것은 기존 클래스와 다르게 다중 상속이 가능합니다!**

Reference : [https://velog.io/@rhdmstj17/java.-super와-super-완벽하게-이해하기](https://velog.io/@rhdmstj17/java.-super%EC%99%80-super-%EC%99%84%EB%B2%BD%ED%95%98%EA%B2%8C-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0)