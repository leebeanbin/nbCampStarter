# OOP(Object-Oriented Programming)

> **OOP** is just a set of objects. And this program performs the relations between each others and use each object as sort of a data in the class as the method.
> - Absolutely, we get to spend much time to build this structure in the program. Notably, this structure has a bit lower speed than other **paradigm**.

`Programming paradigm is an one of the way to build program for developers to grow their insight in terms of being a programmer.`

## OOP Example

This example, I got inspired from the Baekjoon, is about the sort in the criteria of length of each morpheme and the orders of the dictionary.

```java
import java.util.Arrays;

// Word class to hold the word and its length
class Word implements Comparable<Word> {
    String word;
    int length;

    public Word(String word) {
        this.word = word;
        this.length = word.length();
    }

    // Custom compareTo method to sort by length and then by lexicographical order
    @Override
    public int compareTo(Word other) {
        if (this.length != other.length) {
            return this.length - other.length;
        }
        return this.word.compareToIgnoreCase(other.word);
    }
}

// WordSorter class to handle the sorting of words in a sentence
public class WordSorter {
    private Word[] words;

    public WordSorter(String sentence) {
        String[] splitWords = sentence.split("\\s+");  // Split the sentence into words
        words = new Word[splitWords.length];

        for (int i = 0; i < splitWords.length; i++) {
            words[i] = new Word(splitWords[i]);
        }
    }

    public void sortWords() {
        Arrays.sort(words);
    }

    public void printSortedWords() {
        for (Word word : words) {
            System.out.println(word.word);
        }
    }

    public static void main(String[] args) {
        // Example sentence
        String sentence = "Hello world this is a Java program";
        WordSorter sorter = new WordSorter(sentence);
        sorter.sortWords();
        sorter.printSortedWords();
    }
}
```


1. Word Class
```java
class Word implements Comparable<Word> {
	// instance to save basic informations we needed
    String word;
    int length;
	
    // Constructor
    public Word(String word) {
        this.word = word;
        this.length = word.length();
    }

	// compareTo Overriding to use in our class
    // Sorting elements with the length of each words
    @Override
    public int compareTo(Word other) {
        if (this.length != other.length) {
            return this.length - other.length;
        }
        return this.word.compareToIgnoreCase(other.word);
    }
}
```

This class encapsulates the concept of a "word" storing both the word itself and its length. In addition, We have to know `compareTo` method for sorting. it provides a way to compare this object with another `Word` obj. **The comparison is based first on word length. If the lengths are equal, it sorts the words lexicographically order by `compareToIgnoreCase`.**

2. WordSorter Class
```java
public class WordSorter {
	// set intial array to store result
    private Word[] words;

    public WordSorter(String sentence) {
        String[] splitWords = sentence.split("\\s+");  // Split the sentence into words
        // Initialize the size of the array
        words = new Word[splitWords.length];

		// Inject elements in it
        for (int i = 0; i < splitWords.length; i++) {
            words[i] = new Word(splitWords[i]);
        }
    }

    public void sortWords() {
        Arrays.sort(words);
    }

    public void printSortedWords() {
        for (Word word : words) {
            System.out.println(word.word);
        }
    }

    public static void main(String[] args) {
        String sentence = "Hello world this is a Java program";
        WordSorter sorter = new WordSorter(sentence);
        sorter.sortWords();
        sorter.printSortedWords();
    }
}
```

I also did it, I didn't know why this code tries to sort in another class, WordSorter. This is a reason why we should study Java everytime.

1. The `Word` Class' Role :
- Implements the `Comparable<Word>` interface.
- Defines the `compareTo` method to specify the sorting criteria- words are first compared by length, and if the lengths are the same, they are sorted lexicographically.
- It means like this class basically implemented `Comparable` to set specific criteria up for our intention.

2. The `WordSorter` Class' Role :
- Manages a collection of `Word` instances.
- Uses `Array.sort()` on the array of `Word` objects. This method leverages the `compareTo` implementation to sort the array according to the defined natural ordering of the `Word` objects.
- I gotta know that **the acutal sorting algorithm used by `Arrays.sort()` relies on the comparison rules defined in `compareTo()` to decide the order of elements.**


## Points Of OOP

1. Abstraction
   **Abstraction** is the concept of hiding the complex reality while exposing only the necessary parts. It is a method of reducing complexity and allowing effcient design and implementation in complex software systems.

```java
abstract class Animal {
    abstract void eat();  // Abstract method with no body

    public void breathe() {
        System.out.println("This animal breathes air.");
    }
}

class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("The dog eats meat.");
    }
}
```

2. Encapsulation

**Encapsulation** is the bundling of data(attr) and methods that act on the data into a single unit or class. It also involves restricting access to some of the object's components, which is why it is often associated with data hiding.

```java
public class Account {
    private double balance;  // Private variable, hidden from other classes

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
```

3. Inheritance

**Inheritance** is a mechanism where a new class is derived from an existing class. The new class is called a derived class, or subclass, and the existing class is called a base class, or superclass. It provides a method for creating a new class using details of an existing class without modifying it.

```java
 class Vehicle {
    public void move() {
        System.out.println("This vehicle moves.");
    }
}
```

```java
class Car extends Vehicle {
      public void move() {
          super.move();  // Calls the move method from Vehicle class
          System.out.println("The car drives on the road.");
      }
  }
```


4. <span style = "color : #FF6815;">**Polymorphism**</span>

**Polymorphism** means "many forms", and it allows methods to do different things based on the object it is acting upon. In programming, it lets us define one interface and have multiple implementations.

```java 
class Bird {
    public void sing() {
        System.out.println("This bird sings.");
    }
}

class Sparrow extends Bird {
    public void sing() {
        System.out.println("The sparrow chirps.");
    }
}

public class TestPolymorphism {
    public static void main(String[] args) {
        Bird myBird = new Sparrow();
        myBird.sing();  // Outputs "The sparrow chirps."
    }
}
```

I will make a bit wrap-up about this topic again.

We gotta look through the defintion of this everytime. What is the Polymorphism?

- Fundamentally, this is an implementations of interface to modify and change easily and elastically on this running time.
- **Without changing client, make server implementation flexibly.**
- That's why we need to know how to be able to make an interface to separate the roles and implements.


## <span style= "color : #FF6815;" >OOP(SOLID)</span>

1. **Single Responsibility Principle(SRP)**

<span style="background-color: yellow">A class should have only one reason to change, meaning it should have only one job or responsibility. </span>

**This principle aims to separate behaviors so that if bugs arise a result of your change, it will occur in the class with that responsibility and not affect other unrelated features.**

```java
public class UserSettings {
    private User user;
	
    // Constructor
    public UserSettings(User user) {
        this.user = user;
    }
	
    // Method to modify email as getting parameter from user
    void changeEmail(String newEmail) {
        if (EmailValidator.isValid(newEmail)) {
            user.setEmail(newEmail);
        }
    }
}

public class EmailValidator {
    static boolean isValid(String email) {
        return email.contains("@");
    }
}
```

- Problem : Over-engineering can occur if too much emphasis is placed on creating classes with only one responsibility. This can lead to an excessive number of classes, making the system harder to navigate and manage.

    - Refactor Gradually
    - Module Cohension : Aim for modules that contain related functions and data-those that change for the same reason and at the same times. Use package or namespaces to organize these modules cohesively.

2. **Open/Closed Principle(OCP)**

<span style="background-color: yellow">Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.</span>

```java
public abstract class Shape {
    public abstract double area();
}

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }
}
```

Allow systems to be extended with new functionality without altering existing source code, which can cause existing system behavior to change.

- Problem : Trying to predict futire extensions can be difficult and might lead to complex abstract designs tha are never used or are overly complicated for the tasks they need to Pluperform
    - Pattern refactoring : Develop more concrete implementations and refactor to more abstract patterns as the actual requirements for extension become clear.
    - Plugin Architecture : Use plugins or hooks that allow behaviors to be added without modifying existing code.
      ![](https://velog.velcdn.com/images/leebeanbin/post/0a78d072-85fe-4227-b5c4-c4c84473db7d/image.png)


3. **Liskov Substitution Priciple**

<span style="background-color: yellow">Subtypes must be substitutable for their base types, without altering the correctness of the program.</span>

```java
public class Rectangle {
    protected int width, height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int area() {
        return width * height;
    }
}

public class Square extends Rectangle {
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}
```

Ensure that a derived class does not affect the behavior and expectations of the base class, thereby maintaining functionality through inheritance.

- Problem : Subclassing for reuse can sometimes lead to subclasses that do not behave properly when used in place of their base classes, violating LSP.
    - Composition over Inheritance: Favor composition over inheritance when sharing functionality between classes. This approach allows you to assemble desired behaviors at runtime from smaller, decoupled objects.
    - Contract Testing

4. **Interface Segregation Principle(ISP)**

<span style="background-color: yellow">Clients should not be forced to depend upon interfaces they do not use.</span>

```java
public interface Shape {
    double area();
}

public interface SolidShape {
    double volume();
}

public class Cube implements Shape, SolidShape {
    private double side;

    public double area() {
        return 6 * side * side;
    }

    public double volume() {
        return side * side * side;
    }
}
```

Keep interfaces small and specific to client needs so that implementing classes do not have to implement methods they do not require.

- Problem : Implementing large interfaces that are not used fully by clients can lead to bloated designs, where changes to one part of a system unnecessarily impact others that don’t use those parts.
    - Role Interfaces: Split large interfaces into smaller, more specific ones based on roles the clients actually need. This reduces the dependencies on methods that the clients do not use.
    - Delegate(위임) Classes: Use delegate classes to handle specific parts of an interface, helping to keep class implementations focused on their core responsibilities.

5. **Dependency Inversion Principle(DIP)**

<span style="background-color: yellow">High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.</span>

```java
public interface DBConnectionInterface {
    void connect();
}

public class MySQLConnection implements DBConnectionInterface {
    public void connect() {
        System.out.println("Connection to MySQL");
    }
}

public class PasswordReminder {
    private DBConnectionInterface dbConnection;

    public PasswordReminder(DBConnectionInterface dbConnection) {
        this.dbConnection = dbConnection;
    }
}
```

Reduce dependencies amongst the code modules, making the system easier to understand and reduce the risk of changes in the low-level modules that affect high-level modules.

- Problem : High-level modules might depend on low-level modules directly, making the codebase rigid and difficult to maintain or test due to the hard-coded dependencies.
    - Dependency Injection (DI): Use dependency injection to manage the creation and binding of dependent objects externally rather than within the components themselves. DI frameworks like Spring or Guice can help manage these dependencies smoothly.
    - Abstraction Layers: Create abstraction layers such as interfaces or abstract classes that high-level modules can depend on, while the implementation details are left to the lower-level modules that are plugged in at runtime or during configuration.