package com.platform.code_up.services.courses;

import com.platform.code_up.entities.Course;
import com.platform.code_up.entities.Lesson;
import com.platform.code_up.entities.Question;
import com.platform.code_up.entities.Quiz;
import com.platform.code_up.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


public class CourseInstances {

    private final CourseRepository repo;
    private final List<List<Lesson>> lessons;
    private final List<List<Quiz>> quizzes;
    private final List<List<Question>> questions;
    private final Course[] course;

    public CourseInstances(CourseRepository repo) {

        this.repo = repo;
        this.lessons = new ArrayList<>();
        this.quizzes = new ArrayList<>();
        this.questions = new ArrayList<>();
        this.course = new Course[5];

        for (int i = 0; i < 10; i++) {
            this.lessons.add(new ArrayList<>());
            this.quizzes.add(new ArrayList<>());
            this.questions.add(new ArrayList<>());
        }
    }

    @Transactional
    public void createCourses() {
        // Course 0: Algorithms (your existing course)
        if(repo.findByTitle("Algorithms for Beginners").isEmpty()) {
            course[0] = new Course();
            course[0].setTitle("Algorithms for Beginners");
            course[0].setDescription("Learn algorithms through clear, structured lessons and practical quizzes.");
            course[0].setType("programming");
            course[0].setIsPremium(true);
            setLessons();
            setQuizzes();
            setQuestions();
            course[0].setLessons(lessons.get(0));
            course[0].setQuizzes(quizzes.get(0));
            repo.save(course[0]);
        }

        // Course 1: C Programming
        if(repo.findByTitle("C Programming for Beginners").isEmpty()) {
                course[1] = new Course();
        course[1].setTitle("C Programming for Beginners");
        course[1].setDescription("Learn C programming through clear, structured lessons and practical quizzes.");
        course[1].setType("programming");
        course[1].setIsPremium(true);
        course[1].setPrerequisiteCourseIds(course[0].getId());
        setClessons();
        setCquizzes();
        setCQuestions();
        course[1].setLessons(lessons.get(1));
        course[1].setQuizzes(quizzes.get(1));
        repo.save(course[1]);
    }

        if(repo.findByTitle("Java Programming for Beginners").isEmpty()) {
        course[2] = new Course();
        course[2].setTitle("Java Programming for Beginners");
        course[2].setDescription("Learn Java programming through clear, structured lessons and practical quizzes.");
        course[2].setType("programming");
        course[2].setIsPremium(true);
        setJavaLessons();
        setJavaQuizzes();
        setJavaQuestions();
        course[2].setLessons(lessons.get(2));
        course[2].setQuizzes(quizzes.get(2));
        repo.save(course[2]);
    }

    // Course 3: Python Programming
        if(repo.findByTitle("Python Programming for Beginners").isEmpty()) {
        course[3] = new Course();
        course[3].setTitle("Python Programming for Beginners");
        course[3].setDescription("Learn Python programming from scratch through simple lessons and quizzes.");
        course[3].setType("programming");
        course[3].setIsPremium(true);
        setPythonLessons();
        setPythonQuizzes();
        setPythonQuestions();
        course[3].setLessons(lessons.get(3));
        course[3].setQuizzes(quizzes.get(3));
        repo.save(course[3]);
    }

    // Course 4: JavaScript Programming
        if(repo.findByTitle("JavaScript Programming for Beginners").isEmpty()) {
        course[4] = new Course();
        course[4].setTitle("JavaScript Programming for Beginners");
        course[4].setDescription("Learn JavaScript from the ground up with beginner-friendly lessons, quizzes, and interactive examples.");
        course[4].setType("programming");
        course[4].setIsPremium(true);
        setJavaScriptLessons();
        setJavaScriptQuizzes();
        setJavaScriptQuestions();
        course[4].setLessons(lessons.get(4));
        course[4].setQuizzes(quizzes.get(4));
        repo.save(course[4]);
    }

}

private void setJavaQuizzes() {
    quizzes.get(2).add(new Quiz("Unit 1: Introduction to Java",
            1, 1, course[2], questions.get(2)));

    // Unit 2 Quiz
    quizzes.get(2).add(new Quiz("Unit 2: Variables and Data Types",
            1, 2, course[2], questions.get(2)));

    quizzes.get(2).add(new Quiz("Unit 3: Operators and Expressions",
            1, 3, course[2], questions.get(2)));

    quizzes.get(2).add(new Quiz("Unit 4: Conditional statements",
            1, 4, course[2], questions.get(2)));

    // Add new quizzes for Units 5-7
    quizzes.get(2).add(new Quiz("Unit 5: Loops",
            1, 5, course[2], questions.get(2)));

        quizzes.get(2).add(new Quiz("Unit 6: Methods",
                1, 6, course[2], questions.get(2)));

        quizzes.get(2).add(new Quiz("Unit 7: OOP Basics",
                1, 7, course[2], questions.get(2)));

        // Add new quizzes for Units 8-10
        quizzes.get(1).add(new Quiz("Unit 8: Inheritance and Polymorphism",
                1, 8, course[1], questions.get(2)));

        quizzes.get(1).add(new Quiz("Unit 9: Interfaces and Abstract Classes",
                1, 9, course[1], questions.get(2)));

        quizzes.get(1).add(new Quiz("Unit 10: Exception Handling",
                1, 10, course[1], questions.get(2)));
    }
    private void setJavaQuestions() {
        questions.get(2).add(new Question("What makes Java platform-independent?",
                """
                        a) JavaScript support
                        b) Java Virtual Machine (JVM) ✅
                        c) Python libraries
                        d) Mobile devices""",
                quizzes.get(2).get(0)));

        questions.get(2).add(new Question("Which programming style is Java based on?",
                """
                        a) Functional programming
                        b) Object-oriented programming ✅
                        c) Procedural programming
                        d) Assembly programming""",
                quizzes.get(2).get(0)));

        questions.get(2).add(new Question("Which of these is NOT a reason to learn Java?",
                """
                        a) Large community support
                        b) Portability across devices
                        c) Hard-to-find job opportunities ✅
                        d) Strong ecosystem of frameworks""",
                quizzes.get(2).get(0)));

        questions.get(2).add(new Question("What is the purpose of setting the PATH variable?",
                """
                        a) To style the code
                        b) To run Java commands from the terminal ✅
                        c) To install games
                        d) To create graphics""",
                quizzes.get(2).get(0)));

        questions.get(2).add(new Question("Which IDE is commonly used for professional Java development?",
                """
                        a) Microsoft Word
                        b) IntelliJ IDEA ✅
                        c) Photoshop
                        d) AutoCAD""",
                quizzes.get(2).get(0)));

        // Unit 2 Questions
        questions.get(2).add(new Question("Which of the following is a valid variable name in Java?",
                """
                        a) 2userName
                        b) userName ✅
                        c) user name
                        d) user-name""",
                quizzes.get(2).get(1)));

        questions.get(2).add(new Question("Which primitive type is used to store true/false values?",
                """
                        a) int
                        b) boolean ✅
                        c) double
                        d) String""",
                quizzes.get(2).get(1)));

        questions.get(2).add(new Question("What will the following code print?\nint a = 5;\nint b = 3;\nSystem.out.println(a + b);",
                """
                        a) 53
                        b) 8 ✅
                        c) 15
                        d) 2""",
                quizzes.get(2).get(1)));

        questions.get(2).add(new Question("Which data type would you use for storing a person's name?",
                """
                        a) int
                        b) boolean
                        c) String ✅
                        d) double""",
                quizzes.get(2).get(1)));

        questions.get(2).add(new Question("In Java, variables are case-sensitive. True or False?",
                "a) True ✅\n" +
                        "b) False",
                quizzes.get(2).get(1)));
        // Unit 3: Operators and Expressions questions
        questions.get(2).add(new Question("Which operator is used for division in Java?",
                """
                        a) *
                        b) %
                        c) / ✅
                        d) -""",
                quizzes.get(2).get(2)));

        questions.get(2).add(new Question("What is the result of 15 % 4?",
                """
                        a) 3 ✅
                        b) 4
                        c) 1
                        d) 0""",
                quizzes.get(2).get(2)));

        questions.get(2).add(new Question("Which of these is a relational operator?",
                """
                        a) +
                        b) &&
                        c) == ✅
                        d) =""",
                quizzes.get(2).get(2)));

        questions.get(2).add(new Question("What does the logical NOT operator ! do?",
                """
                        a) Combines two conditions
                        b) Reverses a condition ✅
                        c) Checks equality
                        d) Multiplies two numbers""",
                quizzes.get(2).get(2)));

        questions.get(2).add(new Question("In the expression 3 + 2 * 4, what gets evaluated first?",
                """
                        a) 3 + 2
                        b) 2 * 4 ✅
                        c) 3 + (2 * 4)
                        d) None of the above""",
                quizzes.get(2).get(2)));

        // Unit 4: Conditional statements questions
        questions.get(2).add(new Question("Which keyword is used for multiple conditions in if statements?",
                """
                        a) else if ✅
                        b) else
                        c) if-else
                        d) continue""",
                quizzes.get(2).get(3)));

        questions.get(2).add(new Question("What happens if you forget a break in a switch case?",
                """
                        a) Error
                        b) Fall-through ✅
                        c) Stops execution
                        d) Skips the case""",
                quizzes.get(2).get(3)));

        questions.get(2).add(new Question("Which of these can be used in a switch expression?",
                """
                        a) double
                        b) float
                        c) String ✅
                        d) boolean""",
                quizzes.get(2).get(3)));

        questions.get(2).add(new Question("Which statement allows you to execute one block if a condition is false?",
                """
                        a) if
                        b) switch
                        c) else ✅
                        d) break""",
                quizzes.get(2).get(3)));

        questions.get(2).add(new Question("""
                What is the output of the following?
                int x = 3;
                if (x < 5) {
                    System.out.println("Small");
                } else {
                    System.out.println("Large");
                }""",
                """
                        a) Small ✅
                        b) Large
                        c) Error
                        d) Nothing""",
                quizzes.get(2).get(3)));

        // Unit 5: Loops questions
        questions.get(2).add(new Question("Which loop guarantees at least one execution?",
                """
                        a) for
                        b) while
                        c) do-while ✅
                        d) switch""",
                quizzes.get(2).get(4)));

        questions.get(2).add(new Question("""
                What is the output of the following?
                for (int i = 1; i <= 3; i++) {
                    System.out.print(i);
                }""",
                """
                        a) 123 ✅
                        b) 321
                        c) 111
                        d) 222""",
                quizzes.get(2).get(4)));

        questions.get(2).add(new Question("What does the continue statement do?",
                """
                        a) Stops the loop
                        b) Skips the rest of the code in the loop ✅
                        c) Exits the method
                        d) Restarts the loop""",
                quizzes.get(2).get(4)));

        questions.get(2).add(new Question("What type of loop would be best when you don't know how many times to repeat?",
                """
                        a) for
                        b) while ✅
                        c) do-while
                        d) switch""",
                quizzes.get(2).get(4)));

        questions.get(2).add(new Question("How can you create an infinite loop intentionally?",
                """
                        a) while (false)
                        b) while (true) ✅
                        c) if (true)
                        d) do-while(false)""",
                quizzes.get(2).get(4)));

        // Unit 6: Methods questions
        questions.get(2).add(new Question("What keyword is used when a method does not return any value?",
                """
                        a) int
                        b) return
                        c) void ✅
                        d) static""",
                quizzes.get(2).get(5)));

        questions.get(2).add(new Question("Which line calls a method correctly?",
                """
                        a) call greet()
                        b) greet() ✅
                        c) greet;
                        d) method greet()""",
                quizzes.get(2).get(5)));

        questions.get(2).add(new Question("What is method overloading?",
                """
                        a) Having two methods with the same code
                        b) Having multiple methods with the same name but different parameters ✅
                        c) Calling methods again and again
                        d) None of the above""",
                quizzes.get(2).get(5)));

        questions.get(2).add(new Question("""
                Which is a correct method definition?
                public static int multiply(int a, int b) {
                    return a * b;
                }""",
                "a) Correct ✅\n" +
                        "b) Incorrect",
                quizzes.get(2).get(5)));

        questions.get(2).add(new Question("What will this print?\n" +
                "System.out.println(add(2.5, 3.5));",
                """
                        a) 6
                        b) 6.0 ✅
                        c) Error
                        d) 5""",
                quizzes.get(2).get(5)));

        // Unit 7: OOP Basics questions
        questions.get(2).add(new Question("What is a class in Java?",
                """
                        a) A file
                        b) A template to create objects ✅
                        c) A type of method
                        d) A variable""",
                quizzes.get(2).get(6)));

        questions.get(2).add(new Question("Which keyword is used to create a new object?",
                """
                        a) make
                        b) create
                        c) new ✅
                        d) object""",
                quizzes.get(2).get(6)));

        questions.get(2).add(new Question("What is a constructor?",
                """
                        a) A method that returns a value
                        b) A special method to initialize objects ✅
                        c) A variable
                        d) None of the above""",
                quizzes.get(2).get(6)));

        questions.get(2).add(new Question("What does 'this' refer to?",
                """
                        a) The parent class
                        b) The static method
                        c) The current object ✅
                        d) A variable""",
                quizzes.get(2).get(6)));

        questions.get(2).add(new Question("Which concept is related to hiding internal details?",
                """
                        a) Inheritance
                        b) Polymorphism
                        c) Encapsulation ✅
                        d) Overloading""",
                quizzes.get(2).get(6)));

        // Unit 8: Inheritance and Polymorphism questions
        questions.get(1).add(new Question("What keyword allows a class to inherit another class?",
                """
                        a) implements
                        b) extends ✅
                        c) inherits
                        d) super""",
                quizzes.get(1).get(7)));

        questions.get(1).add(new Question("Which keyword is used to refer to the parent class?",
                """
                        a) parent
                        b) this
                        c) super ✅
                        d) base""",
                quizzes.get(1).get(7)));

        questions.get(1).add(new Question("What is method overriding?",
                """
                        a) Changing method parameters
                        b) Changing method body in child class ✅
                        c) Hiding a method
                        d) None""",
                quizzes.get(1).get(7)));

        questions.get(1).add(new Question("What is polymorphism?",
                """
                        a) Many methods in one object
                        b) One object, many forms ✅
                        c) One form, many objects
                        d) None""",
                quizzes.get(1).get(7)));

        questions.get(1).add(new Question("If a Dog object overrides a sound() method, and it's stored in an Animal variable, which version is called?",
                """
                        a) Animal's
                        b) Dog's ✅
                        c) Error
                        d) None""",
                quizzes.get(1).get(7)));

        // Unit 9: Interfaces and Abstract Classes questions
        questions.get(1).add(new Question("What keyword is used to create an interface?",
                """
                        a) class
                        b) interface ✅
                        c) abstract
                        d) implements""",
                quizzes.get(1).get(8)));

        questions.get(1).add(new Question("Can an interface have method bodies?",
                "a) Yes\n" +
                        "b) No ✅",
                quizzes.get(1).get(8)));

        questions.get(1).add(new Question("What type of methods can an abstract class have?",
                """
                        a) Only abstract
                        b) Only concrete
                        c) Both ✅""",
                quizzes.get(1).get(8)));

        questions.get(1).add(new Question("Which of the following can an interface contain?",
                "a) Constructors\n" +
                        "b) Variables and constants ✅",
                quizzes.get(1).get(8)));

        questions.get(1).add(new Question("Which is true about abstract classes?",
                """
                        a) Can't have methods
                        b) Can't be instantiated ✅
                        c) Can be instantiated""",
                quizzes.get(1).get(8)));

        // Unit 10: Exception Handling questions
        questions.get(1).add(new Question("What is an exception?",
                """
                        a) Error in code
                        b) Error during program execution ✅
                        c) Bug
                        d) Syntax mistake""",
                quizzes.get(1).get(9)));

        questions.get(1).add(new Question("Which block must always be executed?",
                """
                        a) try
                        b) catch
                        c) finally ✅
                        d) throw""",
                quizzes.get(1).get(9)));

        questions.get(1).add(new Question("What keyword is used to manually throw an exception?",
                """
                        a) throw ✅
                        b) throws
                        c) catch
                        d) raise""",
                quizzes.get(1).get(9)));

        questions.get(1).add(new Question("Which keyword tells that a method may throw an exception?",
                """
                        a) throw
                        b) throws ✅
                        c) final
                        d) error""",
                quizzes.get(1).get(9)));

        questions.get(1).add(new Question("What happens if an exception is not handled?",
                """
                        a) Program stops ✅
                        b) Program continues normally
                        c) Program retries
                        d) None""",
                quizzes.get(1).get(9)));

    }

    private void setJavaLessons() {
        lessons.get(2).add(new Lesson("What is Java?",
                "Java is a powerful, high-level programming language devel`oped by Sun Microsystems in 1995...",
                "Introduction to Java", 1, 1, course[2]));

        lessons.get(2).add(new Lesson("Why Learn Java?",
                "Java remains one of the most in-demand programming languages today...",
                "Introduction to Java", 2, 1, course[2]));

        lessons.get(2).add(new Lesson("Setting Up Java on Your Computer",
                "Before writing and running Java programs, you need to set up your working environment...",
                "Introduction to Java", 3, 1, course[2]));

        // Unit 2: Variables and Data Types
        lessons.get(2).add(new Lesson("Understanding Variables",
                "In Java, variables are used to store information that can be referenced and manipulated later...",
                "Variables and Data Types", 1, 2, course[2]));

        lessons.get(2).add(new Lesson("Java Data Types",
                "Java has different data types that specify the kind of data a variable can hold...",
                "Variables and Data Types", 2, 2, course[2]));

        lessons.get(2).add(new Lesson("Working with Variables",
                "You can perform operations on variables and combine them to create more complex behaviors...",
                "Variables and Data Types", 3, 2, course[2]));
        lessons.get(2).add(new Lesson("Introduction to Operators",
                "In Java, operators are special symbols or keywords used to perform operations on variables and values...",
                "Operators and Expressions", 1, 3, course[2]));

        lessons.get(2).add(new Lesson("Relational and Logical Operators",
                """
                        Relational Operators compare two values:`
                        == — Equal to
                        != — Not equal to
                        > — Greater than
                        < — Less than
                        >= — Greater than or equal to
                        <= — Less than or equal to...""",
                "Operators and Expressions", 2, 3, course[2]));

        lessons.get(2).add(new Lesson("Expressions in Java",
                "An expression is any valid combination of variables, operators, and values that results in a value...",
                "Operators and Expressions", 3, 3, course[2]));

        // Unit 4: Conditional statements
        lessons.get(2).add(new Lesson("Introduction to Conditional Statements (if, else)",
                "In programming, decisions are made using conditional statements...",
                "Conditional statements", 1, 4, course[2]));

        lessons.get(2).add(new Lesson("The switch Statement",
                "The switch statement provides another way to perform different actions based on different values...",
                "Conditional statements", 2, 4, course[2]));

        lessons.get(2).add(new Lesson("Nested if and switch",
                "You can nest if statements inside each other, and switch statements too...",
                "Conditional statements", 3, 4, course[2]));

        // Unit 5: Loops
        lessons.get(2).add(new Lesson("Introduction to Loops",
                "Loops are used to repeat a block of code multiple times...",
                "Loops", 1, 5, course[2]));

        lessons.get(2).add(new Lesson("for, while, and do-while Loops",
                """
                        for Loop — Known number of iterations...
                        while Loop — Unknown number of iterations...
                        do-while Loop — Runs at least once...""",
                "Loops", 2, 5, course[2]));

        lessons.get(2).add(new Lesson("Loop Control Statements",
                """
                        Sometimes, you need more control over loops...
                        break — Exits the loop immediately...
                        continue — Skips the current iteration...""",
                "Loops", 3, 5, course[2]));

        // Unit 6: Methods (Functions)
        lessons.get(2).add(new Lesson("Introduction to Methods",
                "A method in Java is a block of code that performs a specific task...",
                "Methods", 1, 6, course[2]));

        lessons.get(2).add(new Lesson("Method Parameters and Return Values",
                "Methods can accept parameters and return values...",
                "Methods", 2, 6, course[2]));

        lessons.get(2).add(new Lesson("Method Overloading",
                "Method overloading is when multiple methods have the same name but different parameters...",
                "Methods", 3, 6, course[2]));

        // Unit 7: Object-Oriented Programming (OOP) Basics
        lessons.get(2).add(new Lesson("Introduction to Classes and Objects",
                "Object-Oriented Programming (OOP) is a way of structuring programs...",
                "OOP Basics", 1, 7, course[2]));

        lessons.get(2).add(new Lesson("Constructors and the 'new' Keyword",
                "A constructor is a special method used to initialize objects...",
                "OOP Basics", 2, 7, course[2]));

        lessons.get(2).add(new Lesson("'this' Keyword and Encapsulation",
                "this keyword refers to the current object...\n" +
                        "Encapsulation is hiding the internal details of an object...",
                "OOP Basics", 3, 7, course[2]));

        // Unit 8: Inheritance and Polymorphism
        lessons.get(1).add(new Lesson("Introduction to Inheritance",
                """
                        Inheritance allows a class (child class) to inherit features (fields and methods) from another class (parent class)...
                        Example:
                        class Animal {
                            void eat() {
                                System.out.println("This animal eats food.");
                            }
                        }
                        
                        class Dog extends Animal {
                            void bark() {
                                System.out.println("The dog barks.");
                            }
                        }""",
                "Inheritance and Polymorphism", 1, 8, course[1]));

        lessons.get(1).add(new Lesson("The 'super' Keyword and Method Overriding",
                """
                        The super keyword refers to the parent class and can:
                        Call the parent's constructor.
                        Access the parent's methods and fields.
                        Example:
                        class Animal {
                            void sound() {
                                System.out.println("Animal makes a sound");
                            }
                        }
                        
                        class Cat extends Animal {
                            void sound() {
                                super.sound(); // Calls Animal's sound method
                                System.out.println("Cat meows");
                            }
                        }""",
                "Inheritance and Polymorphism", 2, 8, course[1]));

        lessons.get(1).add(new Lesson("Polymorphism",
                """
                        Polymorphism allows an object to take many forms.
                        Types:
                        Compile-time Polymorphism (Method Overloading)
                        Runtime Polymorphism (Method Overriding)
                        Example of Runtime Polymorphism:
                        class Animal {
                            void sound() {
                                System.out.println("Animal makes a sound");
                            }
                        }
                        
                        class Dog extends Animal {
                            void sound() {
                                System.out.println("Dog barks");
                            }
                        }
                        
                        class Main {
                            public static void main(String[] args) {
                                Animal myAnimal = new Dog();
                                myAnimal.sound(); // Dog barks
                            }
                        }""",
                "Inheritance and Polymorphism", 3, 8, course[1]));

        // Unit 9: Interfaces and Abstract Classes
        lessons.get(1).add(new Lesson("Interfaces",
                """
                        An interface is a blueprint of a class that contains abstract methods (methods without a body).
                        Example:
                        interface Animal {
                            void eat();
                        }
                        
                        A class implements an interface:
                        class Dog implements Animal {
                            public void eat() {
                                System.out.println("Dog eats bones");
                            }
                        }""",
                "Interfaces and Abstract Classes", 1, 9, course[1]));

        lessons.get(1).add(new Lesson("Abstract Classes",
                """
                        An abstract class is a class that cannot be instantiated, and it may contain abstract and non-abstract methods.
                        Example:
                        abstract class Animal {
                            abstract void sound();
                        
                            void breathe() {
                                System.out.println("Animal breathes");
                            }
                        }
                        
                        class Dog extends Animal {
                            void sound() {
                                System.out.println("Dog barks");
                            }
                        }""",
                "Interfaces and Abstract Classes", 2, 9, course[1]));

        lessons.get(1).add(new Lesson("Differences Between Interface and Abstract Class",
                """
                        Interface vs Abstract Class:
                        Interface:
                        - All methods are abstract by default
                        - Supports multiple inheritance
                        - Cannot have constructors
                        
                        Abstract Class:
                        - Can have both abstract and concrete methods
                        - Supports single inheritance
                        - Can have constructors""",
                "Interfaces and Abstract Classes", 3, 9, course[1]));

        // Unit 10: Exception Handling
        lessons.get(1).add(new Lesson("Introduction to Exceptions",
                """
                        An exception is an event that disrupts the normal flow of the program.
                        Common Exceptions:
                        ArithmeticException
                        NullPointerException
                        ArrayIndexOutOfBoundsException
                        Example:
                        int a = 5/0; // ArithmeticException""",
                "Exception Handling", 1, 10, course[1]));

        lessons.get(1).add(new Lesson("Try-Catch Blocks",
                """
                        Exceptions can be handled using try-catch blocks.
                        Syntax:
                        try {
                            // code that might throw an exception
                        } catch(ExceptionType e) {
                            // code to handle the exception
                        }
                        
                        Example:
                        try {
                            int a = 5/0;
                        } catch(ArithmeticException e) {
                            System.out.println("Cannot divide by zero");
                        }""",
                "Exception Handling", 2, 10, course[1]));

        lessons.get(1).add(new Lesson("Finally Block and Throw/Throws",
                """
                        finally block:
                        Always executed, even if an exception is thrown.
                        Example:
                        try {
                            int[] arr = new int[5];
                            arr[10] = 3;
                        } catch(ArrayIndexOutOfBoundsException e) {
                            System.out.println("Index out of bounds");
                        } finally {
                            System.out.println("Finally block executed");
                        }
                        
                        throw keyword:
                        Used to throw an exception manually.
                        
                        throws keyword:
                        Declares an exception that a method might throw.""",
                "Exception Handling", 3, 10, course[1]));

    }
    private void setLessons() {
        lessons.get(0).add(new Lesson(" Understanding Algorithms\n",
                """
                        An algorithm is a clear set of instructions that tells a computer how to perform a task or solve a problem. Think of it like a cooking recipe—each step must be followed in a specific order to get the desired result.
                        Real-life Examples:
                        A recipe for baking a cake.
                        Instructions for making a phone call.
                        Steps to withdraw cash from an ATM.
                        Characteristics of a Good Algorithm:
                        Clear and Unambiguous: Every step is well-defined.
                        Finite: It must complete in a limited number of steps.
                        Effective: Each operation must be basic enough to be performed.
                        """,
                "What Are Algorithms?",
                1, 1, course[0]));

        lessons.get(0).add(new Lesson("Algorithm vs. Program\n",
                """
                        Algorithm: A logical sequence of steps to solve a problem (language-independent).
                        Program: An implementation of an algorithm using a specific programming language.
                        Example:
                        Algorithm to check if a number is even:
                        Input number
                        If number % 2 == 0 → Output: Even
                        Else → Output: Odd
                        Program (in Python):
                        number = int(input("Enter a number: "))
                        if number % 2 == 0:
                            print("Even")
                        else:
                            print("Odd")
                        """, "What Are Algorithms?",
                2, 1, course[0]));

        lessons.get(0).add(new Lesson("Writing Basic Pseudocode and Flowcharts\n",
                """
                        Pseudocode is a way to describe algorithms using informal language close to programming. It's easier to understand than real code.
                        Flowcharts use diagrams to visualize the sequence of steps.
                        Example Task: Find the bigger of two numbers
                        Pseudocode:
                        START
                        Input A
                        Input B
                        IF A > B THEN
                           Print "A is greater"
                        ELSE
                           Print "B is greater"
                        END IF
                        END
                        Flowchart:
                          [Start]
                             |
                          [Input A, B]
                             |
                        [Is A > B?]
                         /        \\
                        Yes        No
                         |          |
                        [A is >]  [B is >]
                             \\    /
                             [End]""",
                "What Are Algorithms?", 3, 1, course[0]));

        lessons.get(0).add(new Lesson("Classification by Function\n",
                """
                        Algorithms can be categorized based on what they do:
                        Search Algorithms: Find a specific value (e.g., linear search, binary search).
                        Sort Algorithms: Organize data in a particular order (e.g., bubble sort, quicksort).
                        Mathematical Algorithms: Perform numeric tasks (e.g., calculating GCD, prime checks).
                        Decision-making Algorithms: Help make choices (e.g., if-else logic).
                        """,
                "Types of Algorithms",
                1, 2, course[0]));

        lessons.get(0).add(new Lesson("Classification by Design Technique\n",
                """
                        Design techniques describe how we approach building an algorithm:
                        Brute Force: Try all possible solutions (simple but inefficient).
                        Divide and Conquer: Break a problem into smaller parts (e.g., Merge Sort).
                        Greedy: Always pick the best local option (e.g., coin change).
                        Dynamic Programming: Solve overlapping subproblems efficiently (e.g., Fibonacci).
                        Backtracking: Try options and backtrack if needed (e.g., Sudoku solver).
                        """,
                "Types of Algorithms",
                2, 2, course[0]));

        lessons.get(0).add(new Lesson("Representing Algorithms Visually\n",
                """
                        Let's represent a linear search algorithm.
                        Pseudocode:
                        START
                        Input array A and value X
                        FOR each item in A
                            IF item == X THEN
                                Print "Found"
                                STOP
                        END FOR
                        Print "Not Found"
                        END
                        Flowchart:
                        [Start]
                           |
                        [Input A and X]
                           |
                        [Set i = 0]
                           |
                        [i < Length of A?]--No-->[Print "Not Found"]-->[End]
                           |
                          Yes
                           |
                        [A[i] == X?]--Yes-->[Print "Found"]-->[End]
                           |
                          No
                           |
                        [i = i + 1]
                           |
                           ↓ (go back to loop)
                        """, "Types of Algorithms",
                3, 2, course[0]
        ));

        lessons.get(0).add(new Lesson("Problem-Solving Steps\n",
                """
                        Understand the problem
                        Break it down
                        Design a solution
                        Write the pseudocode
                        Draw a flowchart
                        Test it
                        """,
                "Problem Solving and Pseudocode Practice\n",
                1, 3, course[0]));
        lessons.get(0).add(new Lesson("Common Pseudocode Patterns\n",
                """
                        Sequential Execution:
                        START \s
                        Print "Hello" \s
                        Print "World" \s
                        END
                        Conditional Execution:
                        IF age > 18 THEN \s
                           Print "Adult" \s
                        ELSE \s
                           Print "Minor"
                        Loops:
                        vbnet
                        CopyEdit
                        FOR i = 1 to 10 \s
                           Print i \s
                        END FOR""",
                "Problem Solving and Pseudocode Practice\n",
                2, 3, course[0]));
        lessons.get(0).add(new Lesson(" Pseudocode Practice – Even or Odd Numbers\n",
                """
                        Pseudocode:
                        START
                        Input number
                        IF number % 2 == 0 THEN
                           Print "Even"
                        ELSE
                           Print "Odd"
                        END
                        Flowchart:
                        [Start]
                           |
                        [Input number]
                           |
                        [Is number % 2 == 0?]
                         /        \\
                        Yes        No
                         |          |
                        [Even]     [Odd]
                             \\    /
                             [End]
                        """,
                "Problem Solving and Pseudocode Practice\n",
                3, 3, course[0]));

        lessons.get(0).add(new Lesson("Sequential Control\n",
                """
                        This is the simplest control structure where steps are executed one after the other in order.
                        Example Pseudocode:
                        START
                        Input name
                        Print "Hello " + name
                        END
                        Flowchart:
                        [Start]
                           |
                        [Input name]
                           |
                        [Print "Hello " + name]
                           |
                        [End]
                        """,
                "Control Structures in Algorithms",
                1, 4, course[0]));
        lessons.get(0).add(new Lesson("Conditional Control (If-Else)\n",
                """
                        Used when a decision is required.
                        Pseudocode:
                        START
                        Input temperature
                        IF temperature > 30 THEN
                           Print "It's hot"
                        ELSE
                           Print "It's cool"
                        END IF
                        END
                        Flowchart:
                        [Start]
                           |
                        [Input temperature]
                           |
                        [Temp > 30?]--Yes-->[Print "It's hot"]
                                 |
                                No
                                 ↓
                        [Print "It's cool"]
                                 ↓
                               [End]
                        """,
                "Control Structures in Algorithms",
                2, 4, course[0]));
        lessons.get(0).add(new Lesson(" Iterative Control (Loops)\n",
                """
                        Loops repeat actions. Common loop types:
                        For: Repeat a known number of times
                        While: Repeat while a condition is true
                        Do-While: Run at least once
                        Pseudocode (While Loop):
                        START
                        Set i = 1
                        WHILE i <= 5 DO
                           Print i
                           i = i + 1
                        END WHILE
                        END
                        """,
                "Control Structures in Algorithms",
                3, 4, course[0]));

        lessons.get(0).add(new Lesson("Linear Search\n",
                """
                        Check each element one by one.
                        Pseudocode:
                        START
                        Input array A and target X
                        FOR i = 0 to length(A) - 1
                           IF A[i] == X THEN
                              Print "Found at i"
                              STOP
                        END FOR
                        Print "Not Found"
                        END
                        Flowchart: (As in Unit 2 Lesson 3)
                        """,
                "Searching Algorithms",
                1, 5, course[0]));

        lessons.get(0).add(new Lesson("Binary Search (Sorted Arrays Only)",
                """
                        Check the middle, then halve the array each time.
                        Pseudocode:
                        START
                        Input sorted array A and target X
                        Set low = 0, high = length(A) - 1
                        WHILE low <= high
                           mid = (low + high) / 2
                           IF A[mid] == X THEN
                              Print "Found at mid"
                              STOP
                           ELSE IF A[mid] < X THEN
                              low = mid + 1
                           ELSE
                              high = mid - 1
                        END WHILE
                        Print "Not Found"
                        END
                        """, "Searching Algorithms",
                2, 5, course[0]
        ));

        lessons.get(0).add(new Lesson("When to Use Each Search",
                """
                        Linear Search:
                        - Use when data is unsorted
                        - Simple to implement
                        - Works on any data structure
                        
                        Binary Search:
                        - Requires sorted data
                        - Much faster for large datasets
                        - Only works on random-access structures (arrays)
                        
                        Comparison:
                        | Algorithm  | Best Case | Worst Case | Requires Sorted Data |
                        |------------|-----------|------------|----------------------|
                        | Linear     | O(1)      | O(n)       | No                   |
                        | Binary     | O(1)      | O(log n)   | Yes                  |""",
                "Searching Algorithms",
                3, 5, course[0]));

        // Unit 6: Sorting Algorithms
        lessons.get(0).add(new Lesson("Bubble Sort",
                """
                        Bubble sort compares adjacent items and swaps them if they are in the wrong order.
                        Pseudocode:
                        START
                        Input array A
                        FOR i = 0 to length(A)-1
                           FOR j = 0 to length(A)-i-2
                              IF A[j] > A[j+1] THEN
                                 Swap A[j] and A[j+1]
                        END FOR
                        END
                        Flowchart Overview:
                        [Start] → [Input array]
                         → [Outer Loop i]
                             → [Inner Loop j]
                                → [Compare A[j] & A[j+1]]
                                    → [Swap if needed]
                         → [Print sorted array] → [End]""",
                "Sorting Algorithms",
                1, 6, course[0]));

        lessons.get(0).add(new Lesson("Selection Sort",
                """
                        Select the smallest element and move it to the front.
                        Pseudocode:
                        START
                        Input array A
                        FOR i = 0 to length(A)-1
                           min = i
                           FOR j = i+1 to length(A)
                              IF A[j] < A[min] THEN
                                 min = j
                           Swap A[i] and A[min]
                        END FOR
                        END""",
                "Sorting Algorithms",
                2, 6, course[0]));

        lessons.get(0).add(new Lesson("Comparing Bubble and Selection Sort",
                """
                        Bubble Sort:
                        - Many swaps (O(n²) in worst case)
                        - Stable (maintains order of equal elements)
                        - Adaptive (can stop early if array is sorted)
                        
                        Selection Sort:
                        - Fewer swaps (O(n) swaps total)
                        - Not stable
                        - Not adaptive
                        
                        Performance Comparison:
                        Both have O(n²) time complexity, but selection sort generally performs better due to fewer swaps.""",
                "Sorting Algorithms",
                3, 6, course[0]));

        // Unit 7: Recursion
        lessons.get(0).add(new Lesson("What is Recursion?",
                """
                        Recursion is when a function calls itself to solve smaller instances of the same problem.
                        Key Components:
                        1. Base Case - stopping condition
                        2. Recursive Case - function calls itself
                        
                        Pseudocode:
                        FUNCTION Factorial(n)
                           IF n == 1 THEN
                              RETURN 1
                           ELSE
                              RETURN n * Factorial(n - 1)
                        END FUNCTION""",
                "Recursion",
                1, 7, course[0]));

        lessons.get(0).add(new Lesson("Recursive vs. Iterative",
                """
                        Iterative Approach:
                        - Uses loops
                        - Generally more memory efficient
                        - Often easier to understand for simple problems
                        
                        Recursive Approach:
                        - Calls itself
                        - More elegant for certain problems (trees, divide-and-conquer)
                        - Can be less memory efficient due to call stack
                        
                        Example: Factorial
                        Iterative:
                        result = 1
                        FOR i = 1 to n
                           result = result * i
                        
                        Recursive: (as shown in previous lesson)""",
                "Recursion",
                2, 7, course[0]));

        lessons.get(0).add(new Lesson("Visualizing Recursion (Factorial)",
                """
                        Factorial(3) = 3 * 2 * 1
                        Calls happen like:
                        Factorial(3)
                        → 3 * Factorial(2)
                            → 2 * Factorial(1)
                                → 1 (base case)
                        
                        Call Stack:
                        1. Factorial(3) waits for Factorial(2)
                        2. Factorial(2) waits for Factorial(1)
                        3. Factorial(1) returns 1
                        4. Factorial(2) returns 2 * 1 = 2
                        5. Factorial(3) returns 3 * 2 = 6""",
                "Recursion",
                3, 7, course[0]));

        lessons.get(0).add(new Lesson("Why Efficiency Matters",
                """
                        Two algorithms might solve the same problem but one is faster or uses less memory.
                        More efficient algorithms are critical when handling large data.
                        
                        Example:
                        Searching a phone book with 1 million entries:
                        - Linear search: Could take 1 million checks
                        - Binary search: Only ~20 checks needed
                        
                        Factors Affecting Efficiency:
                        1. Time complexity (how runtime grows with input size)
                        2. Space complexity (how memory usage grows)""",
                "Algorithm Efficiency and Big-O Notation",
                1, 8, course[0]));

        lessons.get(0).add(new Lesson("Big-O Notation",
                """
                        Describes the worst-case time complexity of an algorithm.
                        
                        Common Complexities:
                        O(1) - Constant time (best)
                        O(log n) - Logarithmic (excellent)
                        O(n) - Linear (good)
                        O(n log n) - Linearithmic (decent)
                        O(n²) - Quadratic (poor)
                        O(2ⁿ) - Exponential (worst)
                        
                        How to Determine Big-O:
                        1. Count the number of basic operations
                        2. Keep the fastest growing term
                        3. Drop constants""",
                "Algorithm Efficiency and Big-O Notation",
                2, 8, course[0]));

        lessons.get(0).add(new Lesson("Comparing Algorithm Performance",
                """
                        Scenario: You need to find a number in a list of 1 million items.
                        
                        Linear Search (O(n)):
                        - Might check all 1M items
                        - Simple to implement
                        - Works on unsorted data
                        
                        Binary Search (O(log n)):
                        - Will check ~20 times (log₂1M ≈ 20)
                        - Requires sorted data
                        - More complex to implement
                        
                        Performance Comparison:
                        | Input Size | Linear (n) | Binary (log n) |
                        |------------|------------|----------------|
                        | 10         | 10         | ~3             |
                        | 1,000      | 1,000      | ~10            |
                        | 1,000,000  | 1,000,000  | ~20            |""",
                "Algorithm Efficiency and Big-O Notation",
                3, 8, course[0]));

        // Unit 9: Divide and Conquer Algorithms
        lessons.get(0).add(new Lesson("What is Divide and Conquer?",
                """
                        It breaks a problem into smaller subproblems, solves them recursively, then combines the results.
                        
                        Steps:
                        1. Divide the problem
                        2. Conquer the subproblems
                        3. Combine the solutions
                        
                        Examples:
                        - Merge Sort
                        - Quick Sort
                        - Binary Search
                        
                        Advantages:
                        - Often more efficient than brute force
                        - Can be parallelized
                        - Elegant recursive solutions""",
                "Divide and Conquer Algorithms",
                1, 9, course[0]));

        lessons.get(0).add(new Lesson("Merge Sort (with Pseudocode)",
                """
                        Merge Sort Pseudocode:
                        FUNCTION MergeSort(arr)
                           IF length of arr > 1 THEN
                              mid = length(arr) / 2
                              left = MergeSort(arr[0:mid])
                              right = MergeSort(arr[mid:end])
                              RETURN Merge(left, right)
                           ELSE
                              RETURN arr
                        END FUNCTION
                        
                        FUNCTION Merge(left, right)
                           result = empty list
                           WHILE left and right are not empty
                              IF left[0] < right[0] THEN
                                 Append left[0] to result
                                 Remove left[0]
                              ELSE
                                 Append right[0] to result
                                 Remove right[0]
                           Append remaining elements from left and right to result
                           RETURN result
                        END FUNCTION
                        
                        Time Complexity: O(n log n)
                        Space Complexity: O(n)""",
                "Divide and Conquer Algorithms",
                2, 9, course[0]));

        lessons.get(0).add(new Lesson("Merge Sort Flowchart Overview",
                """
                        [Start]
                           |
                        [Check array length > 1?]
                           |
                          Yes
                           ↓
                        [Divide array into halves]
                           ↓
                        [Recursively sort each half]
                           ↓
                        [Merge two sorted halves]
                           ↓
                        [Return sorted array]
                           ↓
                        [End]
                        
                        Visualization:
                        Original: [3, 1, 4, 2]
                        Divide:
                        [3, 1]  [4, 2]
                        Divide again:
                        [3] [1]  [4] [2]
                        Merge:
                        [1, 3]  [2, 4]
                        Final Merge:
                        [1, 2, 3, 4]""",
                "Divide and Conquer Algorithms",
                3, 9, course[0]));

        // Unit 10: Greedy Algorithms and Dynamic Programming
        lessons.get(0).add(new Lesson("Greedy Algorithms",
                """
                        Make the best local choice at each step, hoping for the global best solution.
                        
                        Characteristics:
                        - Makes locally optimal choices
                        - Never reconsider previous choices
                        - Often simple and efficient
                        
                        Example: Coin Change (Greedy Version)
                        Pseudocode:
                        START
                        Input amount and coin values [25, 10, 5, 1]
                        FOR each coin in list
                           WHILE amount >= coin
                              amount = amount - coin
                              count++
                        Print count
                        END
                        
                        Note: Works for US coins but not all currency systems""",
                "Greedy Algorithms and Dynamic Programming",
                1, 10, course[0]));

        lessons.get(0).add(new Lesson("Dynamic Programming",
                """
                        Used when problems have overlapping subproblems and optimal substructure.
                        
                        Key Concepts:
                        1. Memoization - Store results of subproblems
                        2. Tabulation - Build solution bottom-up
                        
                        Example: Fibonacci Sequence
                        Recursive (Inefficient):
                        FUNCTION Fib(n)
                           IF n <= 1 THEN RETURN n
                           RETURN Fib(n-1) + Fib(n-2)
                        
                        Dynamic Programming (Efficient):
                        FUNCTION Fib(n)
                           Create array F[0...n]
                           F[0] = 0
                           F[1] = 1
                           FOR i = 2 to n
                              F[i] = F[i-1] + F[i-2]
                           RETURN F[n]
                        END FUNCTION
                        
                        Time Complexity: O(n) vs O(2ⁿ) for naive recursion""",
                "Greedy Algorithms and Dynamic Programming",
                2, 10, course[0]));

        lessons.get(0).add(new Lesson("Greedy vs Dynamic Programming",
                """
                        Greedy:
                        - Makes one decision at each step
                        - Never reconsider choices
                        - Generally faster
                        - Doesn't always find optimal solution
                        
                        Dynamic Programming:
                        - Explores all possibilities
                        - Stores intermediate results
                        - Slower but guarantees optimal solution
                        - More memory intensive
                        
                        When to Use:
                        Greedy - When local optimal leads to global optimal
                        DP - When problems have overlapping subproblems
                        
                        Example Problems:
                        - Greedy: Coin change (US system), Dijkstra's algorithm
                        - DP: Fibonacci, Knapsack problem, Longest common subsequence""",
                "Greedy Algorithms and Dynamic Programming",
                3, 10, course[0]));

    }

    private void setClessons() {

        // Course 1: C Programming lessons
        lessons.get(1).add(new Lesson("What is C Programming?",
                "C is a powerful and efficient programming language that has been around since the early 1970s...",
                "Introduction to C and Setup", 1, 1, course[1]));

        lessons.get(1).add(new Lesson("Why Learn C?",
                "Learning C provides a solid foundation for becoming a better programmer. Here's why:\n" +
                        "Understanding the Machine: C gives you direct access to how the computer works...",
                "Introduction to C and Setup", 2, 1, course[1]));

        lessons.get(1).add(new Lesson("Setting Up Your Environment",
                """
                        To begin coding in C, you need two things: a code editor and a C compiler...
                        Install a C Compiler:
                        Windows: Install Code::Blocks, Dev C++, or use MinGW with VS Code...
                        Hello, World! Program: Here's your first C program:
                        #include <stdio.h>
                        
                        int main() {
                            printf("Hello, World!\\n");
                            return 0;
                        }""",
                "Introduction to C and Setup", 3, 1, course[1]));

        lessons.get(1).add(new Lesson("Declaring and Initializing Variables",
                """
                        In C, variables are containers that store data during the execution of a program...
                        Syntax:
                        int age;         // declaration
                        age = 25;        // initialization
                        int age = 25;    // declaration and initialization""",
                "Variables and Data Types", 1, 2, course[1]));

        lessons.get(1).add(new Lesson("Understanding Data Types",
                "Understanding data types is essential for writing efficient C programs...\n" +
                        "You can use sizeof() to find out how much memory a variable or type occupies.",
                "Variables and Data Types", 2, 2, course[1]));

        lessons.get(1).add(new Lesson("Constants and Type Modifiers",
                """
                        Sometimes you may want to create a variable whose value cannot be changed...
                        Constant Example:
                        const float PI = 3.14;
                        C also allows modifying types with keywords like:
                        short, long - modify the size of integers
                        unsigned - used for only positive numbers""",
                "Variables and Data Types", 3, 2, course[1]));


        lessons.get(1).add(new Lesson("Arithmetic Operators",
                """
                        In C, arithmetic operators allow you to perform basic mathematical operations. These include:
                        + (Addition)
                        - (Subtraction)
                        * (Multiplication)
                        / (Division)
                        % (Modulus - returns the remainder)
                        Example:
                        int a = 10, b = 3;
                        printf("Addition: %d\\n", a + b);       // 13
                        printf("Subtraction: %d\\n", a - b);    // 7
                        printf("Multiplication: %d\\n", a * b); // 30
                        printf("Division: %d\\n", a / b);       // 3
                        printf("Modulus: %d\\n", a % b);        // 1
                        Note: Division between integers will drop any decimal part (e.g., 7 / 2 = 3).""",
                "Operators and Expressions", 1, 3, course[1]));

        lessons.get(1).add(new Lesson("Relational and Logical Operators",
                """
                        Relational operators are used to compare two values. Logical operators allow combining multiple conditions.
                        Relational Operators:
                        == (equal to)
                        != (not equal to)
                        > (greater than)
                        < (less than)
                        >= (greater than or equal to)
                        <= (less than or equal to)
                        Logical Operators:
                        && (AND)
                        || (OR)
                        ! (NOT)
                        Example:
                        int x = 10, y = 20;
                        
                        if (x < y && y != 0) {
                            printf("Both conditions are true.\\n");
                        }
                        
                        if (x == 10 || y == 15) {
                            printf("At least one condition is true.\\n");
                        }""",
                "Operators and Expressions", 2, 3, course[1]));

        lessons.get(1).add(new Lesson("Expressions and Operator Precedence",
                """
                        Expressions combine variables and operators to produce a result. Operator precedence determines the order of evaluation.
                        Precedence Example:
                        int result = 10 + 5 * 2; // Multiplication happens first: 5*2 = 10, then 10+10 = 20
                        To control precedence, use parentheses:
                        int result = (10 + 5) * 2; // Parentheses first: 15*2 = 30""",
                "Operators and Expressions", 3, 3, course[1]));

        // Unit 4: Control Structures
        lessons.get(1).add(new Lesson("If and If-Else Statements",
                """
                        The if statement allows your program to make decisions.
                        Syntax:
                        if (condition) {
                            // code runs if condition is true
                        } else {
                            // code runs if condition is false
                        }
                        Example:
                        int score = 85;
                        
                        if (score >= 90) {
                            printf("Excellent!\\n");
                        } else if (score >= 75) {
                            printf("Good job!\\n");
                        } else {
                            printf("Keep practicing.\\n");
                        }
                        You can nest if statements or use else if for multiple conditions.""",
                "Control Structures", 1, 4, course[1]));

        lessons.get(1).add(new Lesson("Switch Statement",
                """
                        The switch statement is useful for checking many constant values.
                        Syntax:
                        switch (value) {
                            case 1:
                                // code
                                break;
                            case 2:
                                // code
                                break;
                            default:
                                // code
                        }
                        Example:
                        int day = 3;
                        switch (day) {
                            case 1: printf("Monday\\n"); break;
                            case 2: printf("Tuesday\\n"); break;
                            case 3: printf("Wednesday\\n"); break;
                            default: printf("Other day\\n");
                        }""",
                "Control Structures", 2, 4, course[1]));

        lessons.get(1).add(new Lesson("Nested Conditionals and Logical Combinations",
                """
                        You can combine if with &&, ||, or ! to check complex conditions.
                        Example:
                        int age = 18;
                        char citizen = 'Y';
                        
                        if (age >= 18 && citizen == 'Y') {
                            printf("You can vote.\\n");
                        } else {
                            printf("You cannot vote.\\n");
                        }""",
                "Control Structures", 3, 4, course[1]));

        // Unit 5: Loops
        lessons.get(1).add(new Lesson("While Loop",
                """
                        The while loop runs code repeatedly as long as the condition is true.
                        Syntax:
                        while (condition) {
                            // repeated code
                        }
                        Example:
                        int i = 0;
                        while (i < 5) {
                            printf("%d\\n", i);
                            i++;
                        }""",
                "Loops", 1, 5, course[1]));

        lessons.get(1).add(new Lesson("For Loop",
                """
                        The for loop is best when you know how many times you need to repeat something.
                        Syntax:
                        for (initialization; condition; update) {
                            // code
                        }
                        Example:
                        for (int i = 1; i <= 5; i++) {
                            printf("Count: %d\\n", i);
                        }""",
                "Loops", 2, 5, course[1]));

        lessons.get(1).add(new Lesson("Do-While Loop",
                """
                        A do-while loop always runs at least once, even if the condition is false at the start.
                        Syntax:
                        do {
                            // code
                        } while (condition);
                        Example:
                        int i = 0;
                        do {
                            printf("Value: %d\\n", i);
                            i++;
                        } while (i < 3);""",
                "Loops", 3, 5, course[1]));

        // Previous units (1-5) remain unchanged

        // Unit 6: Functions
        lessons.get(1).add(new Lesson("Defining and Using Functions",
                """
                        Functions in C allow you to reuse code and keep your programs organized.
                        Syntax:
                        return_type function_name(parameter_list) {
                            // function body
                        }
                        Example:
                        int add(int a, int b) {
                            return a + b;
                        }
                        
                        int main() {
                            int result = add(4, 5);
                            printf("Sum: %d\\n", result);
                            return 0;
                        }""",
                "Functions", 1, 6, course[1]));

        lessons.get(1).add(new Lesson("Function Parameters and Return Values",
                """
                        Functions can take parameters and return values. You can pass multiple arguments and return a result using return.
                        Example:
                        float multiply(float x, float y) {
                            return x * y;
                        }
                        Calling the function:
                        float answer = multiply(2.5, 3.0);""",
                "Functions", 2, 6, course[1]));

        lessons.get(1).add(new Lesson("Void Functions and Function Prototypes",
                """
                        Void functions don't return a value. Function prototypes tell the compiler about the function before it's used.
                        Example:
                        void greet();
                        
                        int main() {
                            greet();
                            return 0;
                        }
                        
                        void greet() {
                            printf("Hello!\\n");
                        }
                        Function Prototype:
                        void greet(); // declared at the top before main""",
                "Functions", 3, 6, course[1]));

        // Unit 7: Arrays
        lessons.get(1).add(new Lesson("Introduction to Arrays",
                """
                        An array stores multiple values of the same type.
                        Syntax:
                        int numbers[5];
                        You can access or assign elements by index (starts from 0).
                        numbers[0] = 10;
                        printf("%d\\n", numbers[0]);""",
                "Arrays", 1, 7, course[1]));

        lessons.get(1).add(new Lesson("Initializing and Accessing Arrays",
                """
                        You can initialize arrays while declaring them:
                        int values[3] = {10, 20, 30};
                        Use loops to access array values:
                        for (int i = 0; i < 3; i++) {
                            printf("%d\\n", values[i]);
                        }""",
                "Arrays", 2, 7, course[1]));

        lessons.get(1).add(new Lesson("Multidimensional Arrays",
                """
                        Arrays can have more than one dimension.
                        2D Array Example:
                        int matrix[2][3] = {
                            {1, 2, 3},
                            {4, 5, 6}
                        };
                        
                        printf("%d\\n", matrix[1][2]); // Output: 6""",
                "Arrays", 3, 7, course[1]));

        // Unit 8: Strings
        lessons.get(1).add(new Lesson("Declaring and Using Strings",
                """
                        In C, strings are arrays of characters ending with a null character \\0.
                        Syntax:
                        char name[10] = "John";
                        You can also use:
                        char name[] = {'J', 'o', 'h', 'n', '\\0'};
                        Use printf and %s to display strings:
                        printf("Name: %s\\n", name);""",
                "Strings", 1, 8, course[1]));

        lessons.get(1).add(new Lesson("Common String Functions",
                """
                        The string library <string.h> provides useful functions:
                        strlen(str) – length of string
                        strcpy(dest, src) – copies string
                        strcmp(str1, str2) – compares strings
                        strcat(dest, src) – concatenates strings
                        Example:
                        #include <string.h>
                        
                        char s1[20] = "Hello";
                        char s2[] = "World";
                        strcat(s1, s2); // s1 becomes "HelloWorld\"""",
                "Strings", 2, 8, course[1]));

        lessons.get(1).add(new Lesson("Input and Output of Strings",
                """
                        Use scanf or fgets to read strings:
                        char name[30];
                        scanf("%s", name); // reads until space
                        Prefer fgets for full lines:
                        fgets(name, sizeof(name), stdin);""",
                "Strings", 3, 8, course[1]));

        lessons.get(1).add(new Lesson("Introduction to Pointers",
                """
                        A pointer stores the address of another variable.
                        Syntax:
                        int a = 10;
                        int *ptr = &a;
                        &a gives the address of a
                        *ptr accesses the value at that address""",
                "Pointers", 1, 9, course[1]));

        lessons.get(1).add(new Lesson("Pointer Arithmetic",
                """
                        You can use arithmetic on pointers to navigate memory:
                        int arr[3] = {10, 20, 30};
                        int *p = arr;
                        
                        printf("%d\\n", *(p + 1)); // 20""",
                "Pointers", 2, 9, course[1]));

        lessons.get(1).add(new Lesson("Pointers and Functions",
                """
                        Pointers allow functions to modify variables by reference.
                        Example:
                        void update(int *x) {
                            *x = 50;
                        }
                        
                        int main() {
                            int a = 10;
                            update(&a);
                            printf("%d\\n", a); // 50
                        }""",
                "Pointers", 3, 9, course[1]));

        // Unit 10: Structures and Final Review
        lessons.get(1).add(new Lesson("Introduction to Structures",
                """
                        Structures let you group variables of different types.
                        Syntax:
                        struct Person {
                            char name[20];
                            int age;
                        };
                        
                        struct Person p1 = {"Alice", 30};""",
                "Structures and Final Review", 1, 10, course[1]));

        lessons.get(1).add(new Lesson("Accessing and Using Structures",
                """
                        Access structure members with the . operator:
                        printf("Name: %s\\n", p1.name);
                        printf("Age: %d\\n", p1.age);
                        You can also use pointers with structures:
                        struct Person *ptr = &p1;
                        printf("%s\\n", ptr->name);""",
                "Structures and Final Review", 2, 10, course[1]));

        lessons.get(1).add(new Lesson("Structures in Functions",
                """
                        Pass structures to functions by value or by reference.
                        Example (by reference):
                        void print(struct Person *p) {
                            printf("Name: %s\\n", p->name);
                        }
                        
                        print(&p1);""",
                "Structures and Final Review", 3, 10, course[1]));

    }

    private void setQuizzes() {

        quizzes.get(0).add(new Quiz("Intro to Algorithm",
                1,1,course[0],questions.get(0)));
        quizzes.get(0).add(new Quiz("Types of algorithms",
                1,2,course[0],questions.get(0)));
        quizzes.get(0).add(new Quiz("Pseudocode Practice – Even or Odd Numbers",
                1,3,course[0],questions.get(0)));
        quizzes.get(0).add(new Quiz("Iterative Control (Loops)\n",
                1,4,course[0],questions.get(0)));
        quizzes.get(0).add(new Quiz("Searching Algorithms",
                1,5,course[0],questions.get(0)));
        quizzes.get(0).add(new Quiz("Sorting Algorithms",
                1,6,course[0],questions.get(0)));
        quizzes.get(0).add(new Quiz("Recursion",
                1,7,course[0],questions.get(0)));
        quizzes.get(0).add(new Quiz("Algorithm Efficiency",
                1,8,course[0],questions.get(0)));
        quizzes.get(0).add(new Quiz("Divide and Conquer",
                1,9,course[0],questions.get(0)));
        quizzes.get(0).add(new Quiz("Greedy and Dynamic Programming",
                1,10,course[0],questions.get(0)));


    }

    private void setCquizzes() {
        quizzes.get(1).add(new Quiz("Unit 1: Introduction to C and Setup",
                1, 1, course[1], questions.get(1)));

        quizzes.get(1).add(new Quiz("Unit 2: Variables and Data Types",
                1, 2, course[1], questions.get(1)));
        quizzes.get(1).add(new Quiz("Unit 3: Operators and Expressions",
                1, 3, course[1], questions.get(1)));

        quizzes.get(1).add(new Quiz("Unit 4: Control Structures",
                1, 4, course[1], questions.get(1)));

        quizzes.get(1).add(new Quiz("Unit 5: Loops",
                1, 5, course[1], questions.get(1)));

        quizzes.get(1).add(new Quiz("Unit 6: Functions",
                1, 6, course[1], questions.get(1)));

        quizzes.get(1).add(new Quiz("Unit 7: Arrays",
                1, 7, course[1], questions.get(1)));

        quizzes.get(1).add(new Quiz("Unit 8: Strings",
                1, 8, course[1], questions.get(1)));

        quizzes.get(1).add(new Quiz("Unit 9: Pointers",
                1, 9, course[1], questions.get(1)));

        quizzes.get(1).add(new Quiz("Unit 10: Structures and Final Review",
                1, 10, course[1], questions.get(1)));
    }
    private void setQuestions() {
        questions.get(0).add(new Question("1. What is an algorithm?\n",
                """
                        a) A programming language
                        b) A set of rules to solve a problem ✅
                        c) A list of computer parts
                        d) A coding app
                        """,
                quizzes.get(0).get(0)));
        questions.get(0).add(new Question("2. What makes an algorithm effective?\n",
                """
                        a) It’s written in JavaScript
                        b) It has infinite steps
                        c) Its steps are simple and doable ✅
                        d) It’s complicated
                        """,quizzes.get(0).get(0)));
        questions.get(0).add(new Question("3. What’s the difference between an algorithm and a program?\n",
                """
                        a) There’s no difference
                        b) A program is a high-level algorithm
                        c) An algorithm is logic; a program is its coded form ✅
                        d) An algorithm uses syntax rules
                        """,
                quizzes.get(0).get(0)));

        questions.get(1).add(new Question("1. What type of algorithm is used to sort numbers?\n",
                """
                        a) Search
                        b) Math
                        c) Sort ✅
                        d) Decision-making
                        """,
                quizzes.get(0).get(1)));

        questions.get(1).add(new Question("2. What does a greedy algorithm do?\n",
                """
                        a) Checks all options
                        b) Breaks into subproblems
                        c) Picks best local option ✅
                        d) Stores all past choices
                        """,
                quizzes.get(0).get(1)));
        questions.get(1).add(new Question("3. Which is a visual representation of an algorithm?\n",
                """
                        a) HTML
                        b) Flowchart ✅
                        c) Compiler
                        d) Editor
                        """,
                quizzes.get(0).get(1)));

        questions.get(2).add(new Question("1. Which of these is the correct first step in problem-solving?\n",
                """
                        a) Code immediately
                        b) Understand the problem ✅
                        c) Write a flowchart
                        d) Print the result
                        """,
                quizzes.get(0).get(2)));
        questions.get(2).add(new Question("2. What does a FOR loop do?\n",
                """
                        a) Makes choices
                        b) Repeats steps ✅
                        c) Draws flowcharts
                        d) Solves automatically
                        """,
                quizzes.get(0).get(2)));
        questions.get(2).add(new Question("3. What is the output of an odd number check for 5?\n",
                """
                        a) Even
                        b) Error
                        c) Odd ✅
                        d) Prime
                        """,
                quizzes.get(0).get(2)));

        questions.get(3).add(new Question("1. What control structure runs steps in a row?\n",
                """
                        a) Loop
                        b) Sequential ✅
                        c) Branch
                        d) Function
                        """,
                quizzes.get(0).get(3)));
        questions.get(3).add(new Question("2. Which one is a conditional statement?\n",
                """
                        a) WHILE
                        b) FOR
                        c) IF ✅
                        d) REPEAT
                        """,
                quizzes.get(0).get(3)));
        questions.get(3).add(new Question("3. How many times will a WHILE loop run if the condition is never true?\n",
                """
                        a) One
                        b) Five
                        c) Infinite
                        d) Zero ✅
                        """,
                quizzes.get(0).get(3)));

        questions.get(4).add(new Question("What search algorithm checks each element?",
                """
                        a) Linear ✅
                        b) Binary
                        c) Greedy
                        d) Depth-first""",
                quizzes.get(0).get(4)));
        questions.get(4).add(new Question("Binary search needs the array to be:",
                """
                        a) Empty
                        b) Sorted ✅
                        c) Small
                        d) Random""",
                quizzes.get(0).get(4)));
        questions.get(4).add(new Question("What's the main advantage of binary search?",
                """
                        a) Easy to implement
                        b) Works on all data
                        c) Fewer comparisons ✅
                        d) Uses more memory""",
                quizzes.get(0).get(4)));

        // Unit 6: Sorting Algorithms questions
        questions.get(5).add(new Question("What does bubble sort do repeatedly?",
                """
                        a) Pick minimum
                        b) Divide array
                        c) Swap adjacent values ✅
                        d) Pick maximum""",
                quizzes.get(0).get(5)));
        questions.get(5).add(new Question("Which sort uses fewer swaps?",
                """
                        a) Bubble
                        b) Selection ✅
                        c) Merge
                        d) Binary""",
                quizzes.get(0).get(5)));
        questions.get(5).add(new Question("What's the first step in selection sort?",
                """
                        a) Swap last item
                        b) Find largest
                        c) Find smallest ✅
                        d) Sort half""",
                quizzes.get(0).get(5)));

        // Unit 7: Recursion questions
        questions.get(6).add(new Question("What is recursion?",
                """
                        a) Looping 10 times
                        b) Repeating without stopping
                        c) A function calling itself ✅
                        d) A nested loop""",
                quizzes.get(0).get(6)));
        questions.get(6).add(new Question("What's the base case in recursion?",
                """
                        a) The largest input
                        b) When recursion starts
                        c) The condition to stop ✅
                        d) A loop variable""",
                quizzes.get(0).get(6)));
        questions.get(6).add(new Question("Recursive calls are stored in:",
                """
                        a) Heap
                        b) Queue
                        c) Stack ✅
                        d) Table""",
                quizzes.get(0).get(6)));

        questions.get(7).add(new Question("What does Big-O describe?",
                """
                        a) Memory usage
                        b) Speed in best case
                        c) Worst-case complexity ✅
                        d) Visual diagrams""",
                quizzes.get(0).get(7)));
        questions.get(7).add(new Question("Which is fastest for large data?",
                """
                        a) O(n²)
                        b) O(n)
                        c) O(1) ✅
                        d) O(log n²)""",
                quizzes.get(0).get(7)));
        questions.get(7).add(new Question("What is the complexity of bubble sort?",
                """
                        a) O(n²) ✅
                        b) O(log n)
                        c) O(1)
                        d) O(n)""",
                quizzes.get(0).get(7)));

        // Unit 9: Divide and Conquer questions
        questions.get(8).add(new Question("Divide and conquer works by:",
                """
                        a) Repeating steps
                        b) Guessing answers
                        c) Dividing into smaller problems ✅
                        d) Sorting manually""",
                quizzes.get(0).get(8)));
        questions.get(8).add(new Question("Merge sort is an example of:",
                """
                        a) Iterative algorithm
                        b) Divide and conquer ✅
                        c) Brute force
                        d) Greedy""",
                quizzes.get(0).get(8)));
        questions.get(8).add(new Question("The base case of Merge Sort is:",
                """
                        a) Array is empty
                        b) Array has more than 1 item
                        c) Array has one item ✅
                        d) Array is full""",
                quizzes.get(0).get(8)));

        // Unit 10: Greedy and DP questions
        questions.get(9).add(new Question("Greedy algorithms:",
                """
                        a) Try all options
                        b) Make the worst choice
                        c) Pick the best current option ✅
                        d) Store all paths""",
                quizzes.get(0).get(9)));
        questions.get(9).add(new Question("Dynamic programming:",
                """
                        a) Never repeats
                        b) Repeats with no memory
                        c) Solves overlapping problems ✅
                        d) Uses recursion only""",
                quizzes.get(0).get(9)));
        questions.get(9).add(new Question("Which is better for Fibonacci?",
                """
                        a) Greedy
                        b) Recursion
                        c) Dynamic programming ✅
                        d) Looping backward""",
                quizzes.get(0).get(9)));

    }

    private void setCQuestions() {
        questions.get(1).add(new Question("1. What type of language is C?",
                """
                        • a) Interpreted
                        • b) Object-oriented only
                        • c) Procedural and compiled ✅
                        • d) Visual scripting""",
                quizzes.get(1).get(0)));

        questions.get(1).add(new Question("2. Why is C still popular today?",
                """
                        • a) It has the best graphics
                        • b) It's required for web development
                        • c) It's simple, efficient, and foundational ✅
                        • d) It's the only language for AI""",
                quizzes.get(1).get(0)));

        questions.get(1).add(new Question("3. What's the role of a compiler in C?",
                """
                        • a) To edit the code
                        • b) To add syntax highlighting
                        • c) To convert the code into an executable ✅
                        • d) To debug the program automatically""",
                quizzes.get(1).get(0)));

        questions.get(1).add(new Question("4. What does #include <stdio.h> do?",
                """
                        • a) Includes Java libraries
                        • b) Starts a loop
                        • c) Imports standard input/output functions ✅
                        • d) Initializes a variable""",
                quizzes.get(1).get(0)));

        questions.get(1).add(new Question("5. What is printed by this code?\nprintf(\"Hi there!\\n\");",
                """
                        • a) printf("Hi there!");
                        • b) Hi there! ✅
                        • c) \\n
                        • d) An error""",
                quizzes.get(1).get(0)));

        questions.get(1).add(new Question("1. Which keyword is used to declare an integer variable in C?",
                """
                        • a) num
                        • b) var
                        • c) int ✅
                        • d) digit""",
                quizzes.get(1).get(1)));

        questions.get(1).add(new Question("2. What will be the size of a double in most systems?",
                """
                        • a) 2 bytes
                        • b) 4 bytes
                        • c) 8 bytes ✅
                        • d) 1 byte""",
                quizzes.get(1).get(1)));

        questions.get(1).add(new Question("3. What is the output of this code?\nconst int x = 10;\nx = 5;",
                """
                        • a) 5
                        • b) 10
                        • c) Error ✅
                        • d) 0""",
                quizzes.get(1).get(1)));

        questions.get(1).add(new Question("4. What does the unsigned keyword do?",
                """
                        • a) Allows decimals
                        • b) Allows negative values
                        • c) Disallows positive values
                        • d) Allows only positive values ✅""",
                quizzes.get(1).get(1)));

        questions.get(1).add(new Question("5. Which of these is a correct declaration?",
                """
                        • a) float number = "3.14";
                        • b) char letter = A;
                        • c) int age = 30; ✅
                        • d) double price = '9.99';""",
                quizzes.get(1).get(1)));

        questions.get(1).add(new Question("What does the % operator do?",
                """
                        a) Multiplies two numbers
                        b) Divides two numbers
                        c) Returns the remainder ✅
                        d) None of the above""",
                quizzes.get(1).get(2)));

        questions.get(1).add(new Question("What is the result of 5 + 2 * 3?",
                """
                        a) 21
                        b) 11 ✅
                        c) 9
                        d) 7""",
                quizzes.get(1).get(2)));

        questions.get(1).add(new Question("Which operator checks if two values are equal?",
                """
                        a) =
                        b) == ✅
                        c) !=
                        d) &&""",
                quizzes.get(1).get(2)));

        questions.get(1).add(new Question("What does the && operator mean?",
                """
                        a) OR
                        b) AND ✅
                        c) NOT
                        d) Equal""",
                quizzes.get(1).get(2)));

        // Unit 4: Control Structures questions
        questions.get(1).add(new Question("What does an if statement do?",
                """
                        a) Repeats code
                        b) Runs code if a condition is true ✅
                        c) Declares variables
                        d) Switches cases""",
                quizzes.get(1).get(3)));

        questions.get(1).add(new Question("Which is true about switch?",
                """
                        a) It handles user input
                        b) It checks fixed values using cases ✅
                        c) It uses if and else
                        d) It ends with continue""",
                quizzes.get(1).get(3)));

        questions.get(1).add(new Question("What does && mean in a condition?",
                """
                        a) OR
                        b) NOT
                        c) AND ✅
                        d) EQUAL""",
                quizzes.get(1).get(3)));

        // Unit 5: Loops questions
        questions.get(1).add(new Question("When does a while loop stop?",
                """
                        a) Never
                        b) When the condition is false ✅
                        c) After 5 times
                        d) At the end of the program""",
                quizzes.get(1).get(4)));

        questions.get(1).add(new Question("Which loop runs at least once?",
                """
                        a) while
                        b) for
                        c) do-while ✅
                        d) none""",
                quizzes.get(1).get(4)));

        questions.get(1).add(new Question("What are the three parts of a for loop?",
                """
                        a) Start, End, Loop
                        b) Initialization, Condition, Update ✅
                        c) Input, Check, Execute
                        d) Define, Repeat, Finish""",
                quizzes.get(1).get(4)));

        questions.get(1).add(new Question("What does a function do?",
                """
                        a) Stores data
                        b) Groups reusable code ✅
                        c) Takes input
                        d) Checks conditions""",
                quizzes.get(1).get(5)));

        questions.get(1).add(new Question("What is the purpose of a return value?",
                """
                        a) To send back a result ✅
                        b) To call another function
                        c) To break the program
                        d) To stop a loop""",
                quizzes.get(1).get(5)));

        questions.get(1).add(new Question("What type of function does not return a value?",
                """
                        a) float
                        b) int
                        c) void ✅
                        d) char""",
                quizzes.get(1).get(5)));

        // Unit 7: Arrays questions
        questions.get(1).add(new Question("What is an array?",
                """
                        a) A string
                        b) A group of variables of the same type ✅
                        c) A loop
                        d) A pointer""",
                quizzes.get(1).get(6)));

        questions.get(1).add(new Question("What is the index of the first element in an array?",
                """
                        a) 1
                        b) 0 ✅
                        c) -1
                        d) Depends""",
                quizzes.get(1).get(6)));

        questions.get(1).add(new Question("How do you declare a 2D array?",
                """
                        a) int a[2][3]; ✅
                        b) int a(2,3);
                        c) array[2,3];
                        d) matrix[2x3];""",
                quizzes.get(1).get(6)));

        // Unit 8: Strings questions
        questions.get(1).add(new Question("How are strings stored in C?",
                """
                        a) Numbers
                        b) Single characters
                        c) Arrays of characters ending in '\\0' ✅
                        d) Integers""",
                quizzes.get(1).get(7)));

        questions.get(1).add(new Question("What function copies a string?",
                """
                        a) strcat
                        b) strcpy ✅
                        c) strlen
                        d) strread""",
                quizzes.get(1).get(7)));

        questions.get(1).add(new Question("What does strcmp return when strings are equal?",
                """
                        a) -1
                        b) 1
                        c) 0 ✅
                        d) null""",
                quizzes.get(1).get(7)));

        questions.get(1).add(new Question("What is a pointer?",
                """
                        a) A loop
                        b) A variable storing an address ✅
                        c) A function
                        d) A number""",
                quizzes.get(1).get(8)));

        questions.get(1).add(new Question("What does *ptr do?",
                """
                        a) Gets the address
                        b) Dereferences the pointer (gets the value) ✅
                        c) Adds two numbers
                        d) Multiplies""",
                quizzes.get(1).get(8)));

        questions.get(1).add(new Question("What symbol gets the address of a variable?",
                """
                        a) *
                        b) & ✅
                        c) ^
                        d) %""",
                quizzes.get(1).get(8)));

        // Unit 10: Structures questions
        questions.get(1).add(new Question("What is a structure?",
                """
                        a) A user-defined data type ✅
                        b) An array
                        c) A pointer
                        d) A loop""",
                quizzes.get(1).get(9)));

        questions.get(1).add(new Question("How do you access a structure's member?",
                """
                        a) With the . or -> operator ✅
                        b) Using []
                        c) With *
                        d) With &""",
                quizzes.get(1).get(9)));

        questions.get(1).add(new Question("Which keyword defines a structure?",
                """
                        a) struct ✅
                        b) union
                        c) typedef
                        d) define""",
                quizzes.get(1).get(9)));


    }
    //Python Lessons
    private void setPythonLessons() {
        lessons.get(3).add(new Lesson("What is Python?",
                "Python is a high-level, interpreted programming language known for its simplicity and readability. It was created by Guido van Rossum and released in 1991.",
                "Introduction to Python", 1, 1, course[3]));

        lessons.get(3).add(new Lesson("Why Learn Python?",
                "Python is beginner-friendly, used in web development, data science, AI, automation, and more. It's one of the most popular languages today.",
                "Introduction to Python", 2, 1, course[3]));

        lessons.get(3).add(new Lesson("Installing Python",
                "You can install Python from python.org. After installation, use the terminal or an IDE like PyCharm or VS Code to run Python scripts.",
                "Introduction to Python", 3, 1, course[3]));

        // Unit 2: Variables and Data Types
        lessons.get(3).add(new Lesson("Understanding Variables",
                "Variables in Python are used to store data values. You don’t need to declare the type.",
                "Variables and Data Types", 1, 2, course[3]));

        lessons.get(3).add(new Lesson("Common Data Types",
                "Python includes data types like int, float, str, bool, list, tuple, set, and dict.",
                "Variables and Data Types", 2, 2, course[3]));

        lessons.get(3).add(new Lesson("Type Casting and Dynamic Typing",
                "Python is dynamically typed, but you can convert between types using int(), float(), str(), etc.",
                "Variables and Data Types", 3, 2, course[3]));

        // Unit 3: Operators and Expressions
        lessons.get(3).add(new Lesson("Arithmetic and Comparison Operators",
                "Includes +, -, *, /, %, ==, !=, >, <, >=, <=. Used to perform calculations and comparisons.",
                "Operators and Expressions", 1, 3, course[3]));

        lessons.get(3).add(new Lesson("Logical and Assignment Operators",
                "Logical: and, or, not. Assignment: =, +=, -=, etc.",
                "Operators and Expressions", 2, 3, course[3]));

        lessons.get(3).add(new Lesson("Operator Precedence and Associativity",
                "Determines the order in which expressions are evaluated (PEMDAS-like rules).",
                "Operators and Expressions", 3, 3, course[3]));

        // Unit 4: Control Flow
        lessons.get(3).add(new Lesson("If, Elif, Else Statements",
                "Used for decision-making in Python based on conditions.",
                "Control Flow", 1, 4, course[3]));

        lessons.get(3).add(new Lesson("While Loops",
                "Repeats a block of code while a condition is true.",
                "Control Flow", 2, 4, course[3]));

        lessons.get(3).add(new Lesson("For Loops and Range",
                "For loops iterate over sequences. The range() function is often used for numbers.",
                "Control Flow", 3, 4, course[3]));

        // Unit 5: Functions
        lessons.get(3).add(new Lesson("Defining and Calling Functions",
                "Use the 'def' keyword. Functions help organize reusable code.",
                "Functions", 1, 5, course[3]));

        lessons.get(3).add(new Lesson("Function Arguments and Return Values",
                "You can pass parameters and return values using return.",
                "Functions", 2, 5, course[3]));

        lessons.get(3).add(new Lesson("Default and Keyword Arguments",
                "Functions can have default values. Call arguments using keywords for clarity.",
                "Functions", 3, 5, course[3]));

        // Unit 6: Lists and Tuples
        lessons.get(3).add(new Lesson("Working with Lists",
                "Lists are ordered, mutable collections. Use []. Methods: append(), remove(), sort(), etc.",
                "Lists and Tuples", 1, 6, course[3]));

        lessons.get(3).add(new Lesson("Working with Tuples",
                "Tuples are ordered, immutable collections. Use ().",
                "Lists and Tuples", 2, 6, course[3]));

        lessons.get(3).add(new Lesson("Slicing and Indexing",
                "Access portions of lists or strings using indexes and slicing syntax [start:end:step].",
                "Lists and Tuples", 3, 6, course[3]));

        // Unit 7: Dictionaries and Sets
        lessons.get(3).add(new Lesson("Introduction to Dictionaries",
                "Dictionaries store key-value pairs using {}. Access with keys.",
                "Dictionaries and Sets", 1, 7, course[3]));

        lessons.get(3).add(new Lesson("Dictionary Methods",
                "Methods include keys(), values(), items(), get(), update(), etc.",
                "Dictionaries and Sets", 2, 7, course[3]));

        lessons.get(3).add(new Lesson("Working with Sets",
                "Sets are unordered collections of unique elements.",
                "Dictionaries and Sets", 3, 7, course[3]));

        // Unit 8: File Handling
        lessons.get(3).add(new Lesson("Reading Files",
                "Use open(), read(), readline(), or readlines() to access file content.",
                "File Handling", 1, 8, course[3]));

        lessons.get(3).add(new Lesson("Writing to Files",
                "Use write() or writelines() with open() in write or append mode.",
                "File Handling", 2, 8, course[3]));

        lessons.get(3).add(new Lesson("Working with File Paths",
                "Use the 'os' and 'pathlib' modules to manage file paths.",
                "File Handling", 3, 8, course[3]));

        // Unit 9: Error Handling
        lessons.get(3).add(new Lesson("Try, Except Blocks",
                "Handle exceptions using try-except. Optionally use else and finally blocks.",
                "Error Handling", 1, 9, course[3]));

        lessons.get(3).add(new Lesson("Common Exception Types",
                "Examples: ValueError, TypeError, FileNotFoundError, ZeroDivisionError.",
                "Error Handling", 2, 9, course[3]));

        lessons.get(3).add(new Lesson("Raising Exceptions",
                "Use raise to manually throw exceptions with custom messages.",
                "Error Handling", 3, 9, course[3]));

        // Unit 10: Object-Oriented Programming
        lessons.get(3).add(new Lesson("Classes and Objects",
                "Define custom data types using classes. Create objects using constructors.",
                "Object-Oriented Programming", 1, 10, course[3]));

        lessons.get(3).add(new Lesson("Attributes and Methods",
                "Attributes store object data. Methods are functions defined inside classes.",
                "Object-Oriented Programming", 2, 10, course[3]));

        lessons.get(3).add(new Lesson("Inheritance and Polymorphism",
                "Use inheritance to extend class behavior. Polymorphism allows method overriding.",
                "Object-Oriented Programming", 3, 10, course[3]));
    }


    private void setPythonQuizzes() {
        quizzes.get(3).add(new Quiz("Unit 1: Python Basics",
                1, 1, course[3], questions.get(3)));

        quizzes.get(3).add(new Quiz("Unit 2: Variables and Data Types",
                1, 2, course[3], questions.get(3)));

        quizzes.get(3).add(new Quiz("Unit 3: Operators and Expressions",
                1, 3, course[3], questions.get(3)));

        quizzes.get(3).add(new Quiz("Unit 4: Control Flow",
                1, 4, course[3], questions.get(3)));

        quizzes.get(3).add(new Quiz("Unit 5: Functions",
                1, 5, course[3], questions.get(3)));

        quizzes.get(3).add(new Quiz("Unit 6: Lists and Tuples",
                1, 6, course[3], questions.get(3)));

        quizzes.get(3).add(new Quiz("Unit 7: Dictionaries and Sets",
                1, 7, course[3], questions.get(3)));

        quizzes.get(3).add(new Quiz("Unit 8: File Handling",
                1, 8, course[3], questions.get(3)));

        quizzes.get(3).add(new Quiz("Unit 9: Error Handling",
                1, 9, course[3], questions.get(3)));

        quizzes.get(3).add(new Quiz("Unit 10: Object-Oriented Programming",
                1, 10, course[3], questions.get(3)));
    }
    //Python Questions
    private void setPythonQuestions() {
        questions.get(3).add(new Question("1. What is Python primarily known for?\n",
                """
                        a) Complex syntax
                        b) Speed in mobile apps
                        c) Simplicity and readability ✅
                        d) Use in hardware programming
                        """,
                quizzes.get(3).get(0)));

        questions.get(3).add(new Question("2. Who developed Python?\n",
                """
                        a) Bill Gates
                        b) James Gosling
                        c) Guido van Rossum ✅
                        d) Dennis Ritchie
                        """,
                quizzes.get(3).get(0)));

        questions.get(3).add(new Question("3. What file extension is used for Python files?\n",
                """
                        a) .java
                        b) .py ✅
                        c) .c
                        d) .txt
                        """,
                quizzes.get(3).get(0)));

        questions.get(3).add(new Question("1. Which keyword declares a variable in Python?\n",
                """
                        a) var
                        b) let
                        c) No keyword is needed ✅
                        d) declare
                        """,
                quizzes.get(3).get(1)));

        questions.get(3).add(new Question("2. What is the output of: print(type(5))?\n",
                """
                        a) <class 'float'>
                        b) <class 'int'> ✅
                        c) integer
                        d) type error
                        """,
                quizzes.get(3).get(1)));

        questions.get(3).add(new Question("3. Which is a valid variable name?\n",
                """
                        a) 2value
                        b) my-var
                        c) _value ✅
                        d) class
                        """,
                quizzes.get(3).get(1)));

        questions.get(3).add(new Question("1. What does this return: 10 % 3?\n",
                """
                        a) 3
                        b) 1 ✅
                        c) 10
                        d) 0
                        """,
                quizzes.get(3).get(2)));

        questions.get(3).add(new Question("2. Which operator is used for exponentiation?\n",
                """
                        a) ^
                        b) ** ✅
                        c) %
                        d) //
                        """,
                quizzes.get(3).get(2)));

        questions.get(3).add(new Question("3. What is the result of 3 + 2 * 2?\n",
                """
                        a) 10
                        b) 7 ✅
                        c) 9
                        d) 12
                        """,
                quizzes.get(3).get(2)));

        questions.get(3).add(new Question("1. Which statement checks conditions?\n",
                """
                        a) repeat
                        b) if ✅
                        c) loop
                        d) then
                        """,
                quizzes.get(3).get(3)));

        questions.get(3).add(new Question("2. What does 'elif' mean in Python?\n",
                """
                        a) Else if ✅
                        b) Loop end
                        c) Error
                        d) Another else
                        """,
                quizzes.get(3).get(3)));

        questions.get(3).add(new Question("3. What is the output of: if False: print('Hi')?\n",
                """
                        a) Hi
                        b) Error
                        c) Nothing ✅
                        d) False
                        """,
                quizzes.get(3).get(3)));

        questions.get(3).add(new Question("1. Which loop runs until condition is false?\n",
                """
                        a) for
                        b) while ✅
                        c) loop
                        d) repeat
                        """,
                quizzes.get(3).get(4)));

        questions.get(3).add(new Question("2. Which keyword stops a loop?\n",
                """
                        a) stop
                        b) exit
                        c) break ✅
                        d) halt
                        """,
                quizzes.get(3).get(4)));

        questions.get(3).add(new Question("3. What does 'range(3)' return?\n",
                """
                        a) [1, 2, 3]
                        b) [0, 1, 2] ✅
                        c) [0, 1, 2, 3]
                        d) [3, 2, 1]
                        """,
                quizzes.get(3).get(4)));

        questions.get(3).add(new Question("1. What is a function in Python?\n",
                """
                        a) A keyword
                        b) A stored value
                        c) A block of code for reuse ✅
                        d) A module
                        """,
                quizzes.get(3).get(5)));

        questions.get(3).add(new Question("2. Which keyword defines a function?\n",
                """
                        a) function
                        b) def ✅
                        c) fun
                        d) void
                        """,
                quizzes.get(3).get(5)));

        questions.get(3).add(new Question("3. What is the default return type in Python?\n",
                """
                        a) int
                        b) None ✅
                        c) 0
                        d) bool
                        """,
                quizzes.get(3).get(5)));

        questions.get(3).add(new Question("1. How is a list declared?\n",
                """
                        a) list()
                        b) {}
                        c) [] ✅
                        d) <>
                        """,
                quizzes.get(3).get(6)));

        questions.get(3).add(new Question("2. What does len([1,2,3]) return?\n",
                """
                        a) 2
                        b) 3 ✅
                        c) 1
                        d) Error
                        """,
                quizzes.get(3).get(6)));

        questions.get(3).add(new Question("3. What is the index of the last element?\n",
                """
                        a) -1 ✅
                        b) 0
                        c) size
                        d) end
                        """,
                quizzes.get(3).get(6)));

        questions.get(3).add(new Question("1. What is a string in Python?\n",
                """
                        a) A number
                        b) A list
                        c) A sequence of characters ✅
                        d) A data type for files
                        """,
                quizzes.get(3).get(7)));

        questions.get(3).add(new Question("2. How are strings indexed?\n",
                """
                        a) Starting from 1
                        b) Randomly
                        c) From 0 ✅
                        d) From -1
                        """,
                quizzes.get(3).get(7)));

        questions.get(3).add(new Question("3. What does 'hello'.upper() return?\n",
                """
                        a) error
                        b) HELLO ✅
                        c) hello
                        d) Upperhello
                        """,
                quizzes.get(3).get(7)));

        questions.get(3).add(new Question("1. What is a dictionary in Python?\n",
                """
                        a) A list of values
                        b) A data structure with key-value pairs ✅
                        c) An index
                        d) A library
                        """,
                quizzes.get(3).get(8)));

        questions.get(3).add(new Question("2. Which syntax accesses a dictionary value by key?\n",
                """
                        a) dict.key
                        b) dict{key}
                        c) dict[key] ✅
                        d) dict->key
                        """,
                quizzes.get(3).get(8)));

        questions.get(3).add(new Question("3. What does dict.get('x', 0) do?\n",
                """
                        a) Throws error
                        b) Gets value or returns 0 ✅
                        c) Updates key
                        d) Clears dict
                        """,
                quizzes.get(3).get(8)));

        questions.get(3).add(new Question("1. What is a module in Python?\n",
                """
                        a) A built-in variable
                        b) A set of functions/code ✅
                        c) A loop
                        d) A statement
                        """,
                quizzes.get(3).get(9)));

        questions.get(3).add(new Question("2. How to import a module?\n",
                """
                        a) include math
                        b) use math
                        c) import math ✅
                        d) module math
                        """,
                quizzes.get(3).get(9)));

        questions.get(3).add(new Question("3. Which function gives the square root?\n",
                """
                        a) math.pow()
                        b) math.square()
                        c) math.sqrt() ✅
                        d) math.sqr()
                        """,
                quizzes.get(3).get(9)));
    }

    //JavaScript Course
    private void setJavaScriptLessons() {
        // Unit 1: Introduction to JavaScript
        lessons.get(4).add(new Lesson("What is JavaScript?",
                "JavaScript is a scripting language that enables dynamic content on web pages, allowing for interactive features.",
                "Introduction to JavaScript", 1, 1, course[4]));

        lessons.get(4).add(new Lesson("JavaScript in Web Development",
                "Used alongside HTML and CSS, JavaScript is one of the core technologies of the web.",
                "Introduction to JavaScript", 2, 1, course[4]));

        lessons.get(4).add(new Lesson("Writing and Running JS",
                "JavaScript can be written in script tags or separate .js files and run in browsers or Node.js.",
                "Introduction to JavaScript", 3, 1, course[4]));

        // Unit 2: Variables and Data Types
        lessons.get(4).add(new Lesson("Declaring Variables (var, let, const)",
                "var is function-scoped, let and const are block-scoped; use const for values that don’t change.",
                "Variables and Data Types", 1, 2, course[4]));

        lessons.get(4).add(new Lesson("Primitive Data Types",
                "Includes string, number, boolean, null, undefined, and symbol.",
                "Variables and Data Types", 2, 2, course[4]));

        lessons.get(4).add(new Lesson("Dynamic Typing and typeof",
                "JavaScript is dynamically typed; use typeof to check variable types.",
                "Variables and Data Types", 3, 2, course[4]));

        // Unit 3: Operators and Expressions
        lessons.get(4).add(new Lesson("Arithmetic and Assignment Operators",
                "Operators include +, -, *, /, %, ++, --, and assignment operators like =, +=, -=.",
                "Operators and Expressions", 1, 3, course[4]));

        lessons.get(4).add(new Lesson("Comparison and Logical Operators",
                "== vs ===, != vs !==, >, <, >=, <=, &&, ||, !.",
                "Operators and Expressions", 2, 3, course[4]));

        lessons.get(4).add(new Lesson("Ternary and Type Coercion",
                "Ternary is shorthand for if-else; JavaScript does automatic type conversion in many cases.",
                "Operators and Expressions", 3, 3, course[4]));

        // Unit 4: Control Structures
        lessons.get(4).add(new Lesson("If, Else, and Else If",
                "Control decision-making based on conditions using if, else if, and else blocks.",
                "Control Structures", 1, 4, course[4]));

        lessons.get(4).add(new Lesson("Switch Statements",
                "Simplifies multiple condition checks by matching values against cases.",
                "Control Structures", 2, 4, course[4]));

        lessons.get(4).add(new Lesson("For, While, and Do-While Loops",
                "Different types of loops for repeating code: for, while, do-while.",
                "Control Structures", 3, 4, course[4]));

        // Unit 5: Functions
        lessons.get(4).add(new Lesson("Function Declaration and Expression",
                "Functions can be declared or assigned to variables as expressions.",
                "Functions", 1, 5, course[4]));

        lessons.get(4).add(new Lesson("Arrow Functions",
                "Shorter syntax using =>, does not bind its own this.",
                "Functions", 2, 5, course[4]));

        lessons.get(4).add(new Lesson("Parameters and Return Values",
                "Functions can accept arguments and return results using return.",
                "Functions", 3, 5, course[4]));

        // Unit 6: Arrays and Objects
        lessons.get(4).add(new Lesson("Creating and Accessing Arrays",
                "Use [] to define arrays, access elements by index.",
                "Arrays and Objects", 1, 6, course[4]));

        lessons.get(4).add(new Lesson("Array Methods (push, pop, map, filter)",
                "Built-in methods to manipulate arrays: push(), pop(), map(), filter().",
                "Arrays and Objects", 2, 6, course[4]));

        lessons.get(4).add(new Lesson("Objects and Properties",
                "Objects store key-value pairs; access with dot or bracket notation.",
                "Arrays and Objects", 3, 6, course[4]));

        // Unit 7: DOM Manipulation
        lessons.get(4).add(new Lesson("The Document Object Model (DOM)",
                "DOM represents the structure of web pages as objects and nodes.",
                "DOM Manipulation", 1, 7, course[4]));

        lessons.get(4).add(new Lesson("Selecting Elements (getElementById, querySelector)",
                "Use methods like getElementById and querySelector to select HTML elements.",
                "DOM Manipulation", 2, 7, course[4]));

        lessons.get(4).add(new Lesson("Changing Content and Styles",
                "Change HTML and CSS properties using JS DOM methods and style objects.",
                "DOM Manipulation", 3, 7, course[4]));

        // Unit 8: Events and Event Handling
        lessons.get(4).add(new Lesson("Adding Event Listeners",
                "Use addEventListener() to run functions when user interacts with elements.",
                "Events and Event Handling", 1, 8, course[4]));

        lessons.get(4).add(new Lesson("Mouse and Keyboard Events",
                "Events like click, mouseover, keydown help track user activity.",
                "Events and Event Handling", 2, 8, course[4]));

        lessons.get(4).add(new Lesson("Event Propagation and Delegation",
                "Event bubbling and capturing determine event flow; delegation improves performance.",
                "Events and Event Handling", 3, 8, course[4]));

        // Unit 9: Error Handling and Debugging
        lessons.get(4).add(new Lesson("Try-Catch-Finally Blocks",
                "Handle exceptions using try, catch, and finally blocks.",
                "Error Handling and Debugging", 1, 9, course[4]));

        lessons.get(4).add(new Lesson("Console and Debugging Tools",
                "Use console.log() and browser dev tools to find bugs.",
                "Error Handling and Debugging", 2, 9, course[4]));

        lessons.get(4).add(new Lesson("Throwing Custom Errors",
                "Use throw to create custom error messages when something goes wrong.",
                "Error Handling and Debugging", 3, 9, course[4]));

        // Unit 10: ES6+ Features
        lessons.get(4).add(new Lesson("Let, Const, and Template Literals",
                "ES6 introduced block-scoped variables and backtick template strings.",
                "ES6+ Features", 1, 10, course[4]));

        lessons.get(4).add(new Lesson("Destructuring and Spread Operator",
                "Destructuring simplifies variable assignment; spread (...) expands arrays/objects.",
                "ES6+ Features", 2, 10, course[4]));

        lessons.get(4).add(new Lesson("Promises and Async/Await",
                "Used for asynchronous programming, replacing callbacks for better readability.",
                "ES6+ Features", 3, 10, course[4]));
    }

    //Javascript Quizzes
    private void setJavaScriptQuizzes() {
        quizzes.get(4).add(new Quiz("Unit 1: Introduction to JavaScript",
                1, 1, course[4], questions.get(4)));

        quizzes.get(4).add(new Quiz("Unit 2: Variables and Data Types",
                1, 2, course[4], questions.get(4)));

        quizzes.get(4).add(new Quiz("Unit 3: Operators and Expressions",
                1, 3, course[4], questions.get(4)));

        quizzes.get(4).add(new Quiz("Unit 4: Control Structures",
                1, 4, course[4], questions.get(4)));

        quizzes.get(4).add(new Quiz("Unit 5: Functions",
                1, 5, course[4], questions.get(4)));

        quizzes.get(4).add(new Quiz("Unit 6: Arrays and Objects",
                1, 6, course[4], questions.get(4)));

        quizzes.get(4).add(new Quiz("Unit 7: DOM Manipulation",
                1, 7, course[4], questions.get(4)));

        quizzes.get(4).add(new Quiz("Unit 8: Events and Event Handling",
                1, 8, course[4], questions.get(4)));

        quizzes.get(4).add(new Quiz("Unit 9: Error Handling and Debugging",
                1, 9, course[4], questions.get(8)));

        quizzes.get(4).add(new Quiz("Unit 10: ES6+ Features",
                1, 10, course[4], questions.get(9)));
    }
    //Javascript Questions
    private void setJavaScriptQuestions() {
        // Unit 1: Introduction to JavaScript
        questions.get(4).add(new Question("1. What is JavaScript primarily used for in web development?\n",
                """
                        a) Server-side scripting
                        b) Web page styling
                        c) Making web pages interactive ✅
                        d) Database management
                        """,
                quizzes.get(4).get(0)));
        questions.get(4).add(new Question("2. Who developed JavaScript?\n",
                """
                        a) Tim Berners-Lee
                        b) Brendan Eich ✅
                        c) Dennis Ritchie
                        d) Mark Zuckerberg
                        """,
                quizzes.get(4).get(0)));
        questions.get(4).add(new Question("3. What keyword is used to declare a variable in JavaScript?\n",
                """
                        a) var ✅
                        b) int
                        c) dim
                        d) letvar
                        """,
                quizzes.get(4).get(0)));

        // Unit 2: Variables and Data Types
        questions.get(4).add(new Question("1. What is a boolean data type?\n",
                """
                        a) A text value
                        b) A number
                        c) True or False ✅
                        d) A function
                        """,
                quizzes.get(4).get(1)));
        questions.get(4).add(new Question("2. Which of these is a valid variable name?\n",
                """
                        a) 123name
                        b) user_name ✅
                        c) var
                        d) user-name
                        """,
                quizzes.get(4).get(1)));
        questions.get(4).add(new Question("3. What is 'undefined' in JavaScript?\n",
                """
                        a) A declared but uninitialized variable ✅
                        b) A syntax error
                        c) A null object
                        d) A reserved keyword
                        """,
                quizzes.get(4).get(1)));

        // Unit 3: Operators and Expressions
        questions.get(4).add(new Question("1. What does the '+' operator do?\n",
                """
                        a) Adds numbers
                        b) Concatenates strings
                        c) Both ✅
                        d) None
                        """,
                quizzes.get(4).get(2)));
        questions.get(4).add(new Question("2. What is the result of 5 === '5'?\n",
                """
                        a) true
                        b) false ✅
                        c) undefined
                        d) error
                        """,
                quizzes.get(4).get(2)));
        questions.get(4).add(new Question("3. Which is a comparison operator?\n",
                """
                        a) &&
                        b) === ✅
                        c) =
                        d) +=
                        """,
                quizzes.get(4).get(2)));

        // Unit 4: Control Structures
        questions.get(4).add(new Question("1. Which statement is used to make decisions?\n",
                """
                        a) for
                        b) if ✅
                        c) switch
                        d) while
                        """,
                quizzes.get(4).get(3)));
        questions.get(4).add(new Question("2. What does a 'switch' statement do?\n",
                """
                        a) Repeats code
                        b) Tests multiple conditions ✅
                        c) Declares functions
                        d) Loops forever
                        """,
                quizzes.get(4).get(3)));
        questions.get(4).add(new Question("3. What keyword ends a case block?\n",
                """
                        a) stop
                        b) close
                        c) break ✅
                        d) exit
                        """,
                quizzes.get(4).get(3)));

        // Unit 5: Loops
        questions.get(4).add(new Question("1. Which loop checks condition before running?\n",
                """
                        a) do-while
                        b) while ✅
                        c) forever
                        d) loop
                        """,
                quizzes.get(4).get(4)));
        questions.get(4).add(new Question("2. What loop always runs at least once?\n",
                """
                        a) for
                        b) while
                        c) do-while ✅
                        d) loop
                        """,
                quizzes.get(4).get(4)));
        questions.get(4).add(new Question("3. What is used to exit a loop early?\n",
                """
                        a) break ✅
                        b) exit
                        c) close
                        d) return
                        """,
                quizzes.get(4).get(4)));

        // Unit 6: Functions
        questions.get(4).add(new Question("1. How do you define a function?\n",
                """
                        a) method myFunc(){}
                        b) function myFunc(){} ✅
                        c) def myFunc(){}
                        d) fun myFunc(){}
                        """,
                quizzes.get(4).get(5)));
        questions.get(4).add(new Question("2. What keyword returns a value?\n",
                """
                        a) break
                        b) stop
                        c) return ✅
                        d) yield
                        """,
                quizzes.get(4).get(5)));
        questions.get(4).add(new Question("3. Functions in JS are:\n",
                """
                        a) Not reusable
                        b) First-class citizens ✅
                        c) Only global
                        d) Static
                        """,
                quizzes.get(4).get(5)));

        // Unit 7: Arrays
        questions.get(4).add(new Question("1. How to define an array?\n",
                """
                        a) let a = [] ✅
                        b) let a = {}
                        c) let a = ()
                        d) let a = <>
                        """,
                quizzes.get(4).get(6)));
        questions.get(4).add(new Question("2. What method adds an item to an array?\n",
                """
                        a) add()
                        b) append()
                        c) push() ✅
                        d) insert()
                        """,
                quizzes.get(4).get(6)));
        questions.get(4).add(new Question("3. Which method removes the last item?\n",
                """
                        a) shift()
                        b) pop() ✅
                        c) splice()
                        d) delete()
                        """,
                quizzes.get(4).get(6)));

        // Unit 8: Objects
        questions.get(4).add(new Question("1. What is a JavaScript object?\n",
                """
                        a) A number
                        b) A key-value pair ✅
                        c) A string
                        d) A function
                        """,
                quizzes.get(4).get(7)));
        questions.get(4).add(new Question("2. How to access an object’s property?\n",
                """
                        a) obj->prop
                        b) obj[prop] or obj.prop ✅
                        c) obj::prop
                        d) obj.prop()
                        """,
                quizzes.get(4).get(7)));
        questions.get(4).add(new Question("3. What is JSON?\n",
                """
                        a) JavaScript Object Notation ✅
                        b) Java Simple Object Node
                        c) Java Set Object
                        d) JS Option Notation
                        """,
                quizzes.get(4).get(7)));
    }



}
