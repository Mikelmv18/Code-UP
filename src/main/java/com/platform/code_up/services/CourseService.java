package com.platform.code_up.services;

import com.platform.code_up.dtos.CourseDto;
import com.platform.code_up.dtos.LessonDto;
import com.platform.code_up.entities.Course;
import com.platform.code_up.entities.Lesson;
import com.platform.code_up.entities.Question;
import com.platform.code_up.entities.Quiz;
import com.platform.code_up.exceptions.CourseNotFoundException;
import com.platform.code_up.repositories.CourseRepository;
import com.platform.code_up.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseService {
    private final CourseRepository repo;
    private List<List<Lesson>> lessons;
    private List<List<Quiz>> quizzes;
    private List<List<Question>> questions;
    private Course[] course; // Changed from course[1] to courses[5]

    public CourseService(CourseRepository repo) {
        this.repo = repo;
        this.lessons = new ArrayList<>();
        this.quizzes = new ArrayList<>();
        this.questions = new ArrayList<>();
        this.course = new Course[5];

        for (int i = 0; i < 5; i++) {
            this.lessons.add(new ArrayList<>());
            this.quizzes.add(new ArrayList<>());
            this.questions.add(new ArrayList<>());
        }
    }

    public void createCourses() {
        // Course 0: Algorithms (your existing course)
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

        // Course 1: C Programming
        course[1] = new Course();
        course[1].setTitle("C Programming for Beginners");
        course[1].setDescription("Learn C programming through clear, structured lessons and practical quizzes.");
        course[1].setType("programming");
        course[1].setIsPremium(true);
        course[1].setPrerequisiteCourseIds(course[0].getId());
        setLessons();
        setQuizzes();
        setQuestions();
        course[1].setLessons(lessons.get(1));
        course[1].setQuizzes(quizzes.get(1));
        repo.save(course[1]);

       /* course[2] = new Course();
        course[2].setTitle("Java Programming for Beginners");
        course[2].setDescription("Learn Java programming through clear, structured lessons and practical quizzes.");
        course[2].setType("programming");
        course[2].setIsPremium(true);
        setJavaLessons();
        setJavaQuizzes();
        setJavaQuestions();
        course[2].setLessons(lessons.get(2));
        course[2].setQuizzes(quizzes.get(2));
        repo.save(course[2]);*/
    }

    private void setJavaQuizzes() {
        quizzes.get(2).add(new Quiz("Unit 1: Introduction to Java",
                1, 1, course[2], questions.get(2)));

        // Unit 2 Quiz
        quizzes.get(2).add(new Quiz("Unit 2: Variables and Data Types",
                1, 2, course[2], questions.get(2)));
    }
    private void setJavaQuestions() {
    questions.get(2).add(new Question("What makes Java platform-independent?",
                "a) JavaScript support\n" +
                        "b) Java Virtual Machine (JVM) ✅\n" +
                        "c) Python libraries\n" +
                        "d) Mobile devices",
                         quizzes.get(2).get(0)));

        questions.get(2).add(new Question("Which programming style is Java based on?",
                "a) Functional programming\n" +
                        "b) Object-oriented programming ✅\n" +
                        "c) Procedural programming\n" +
                        "d) Assembly programming",
                             quizzes.get(2).get(0)));

        questions.get(2).add(new Question("Which of these is NOT a reason to learn Java?",
                "a) Large community support\n" +
                        "b) Portability across devices\n" +
                        "c) Hard-to-find job opportunities ✅\n" +
                        "d) Strong ecosystem of frameworks",
                             quizzes.get(2).get(0)));

        questions.get(2).add(new Question("What is the purpose of setting the PATH variable?",
                "a) To style the code\n" +
                        "b) To run Java commands from the terminal ✅\n" +
                        "c) To install games\n" +
                        "d) To create graphics",
                             quizzes.get(2).get(0)));

        questions.get(2).add(new Question("Which IDE is commonly used for professional Java development?",
                "a) Microsoft Word\n" +
                        "b) IntelliJ IDEA ✅\n" +
                        "c) Photoshop\n" +
                        "d) AutoCAD",
                             quizzes.get(2).get(0)));

    // Unit 2 Questions
        questions.get(2).add(new Question("Which of the following is a valid variable name in Java?",
                "a) 2userName\n" +
                        "b) userName ✅\n" +
                        "c) user name\n" +
                        "d) user-name",
                             quizzes.get(2).get(1)));

        questions.get(2).add(new Question("Which primitive type is used to store true/false values?",
                "a) int\n" +
                        "b) boolean ✅\n" +
                        "c) double\n" +
                        "d) String",
                             quizzes.get(2).get(1)));

        questions.get(2).add(new Question("What will the following code print?\nint a = 5;\nint b = 3;\nSystem.out.println(a + b);",
                "a) 53\n" +
                        "b) 8 ✅\n" +
                        "c) 15\n" +
                        "d) 2",
                             quizzes.get(2).get(1)));

        questions.get(2).add(new Question("Which data type would you use for storing a person's name?",
                "a) int\n" +
                        "b) boolean\n" +
                        "c) String ✅\n" +
                        "d) double",
                             quizzes.get(2).get(1)));

        questions.get(2).add(new Question("In Java, variables are case-sensitive. True or False?",
                "a) True ✅\n" +
                        "b) False",
                             quizzes.get(2).get(1)));
}

    private void setJavaLessons() {
        lessons.get(2).add(new Lesson("What is Java?",
                "Java is a powerful, high-level programming language developed by Sun Microsystems in 1995...",
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
    }

    public List<Course> listAllCourses() {
        List<Course> courses = new ArrayList<>();
        repo.findAll().forEach(courses::add);
        return courses;
    }

    public Course getById(Integer id) throws CourseNotFoundException {
        return repo.findById(id).orElseThrow(() -> new CourseNotFoundException());
    }

    public CourseDto updateCourse(Integer id, CourseDto courseDto) throws CourseNotFoundException {
        Course course = repo.findById(id).orElseThrow(() -> new CourseNotFoundException());

        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setType(courseDto.getType());
        course.setIsPremium(courseDto.getIsPremium());
        course.setPrerequisiteCourseIds(courseDto.getPrerequisiteCourseIds());

        repo.save(course);

        return new CourseDto(course.getTitle(), course.getDescription(), course.getType(),
                course.getIsPremium(), course.getPrerequisiteCourseIds());
    }

    public void deleteCourse(Integer id) throws CourseNotFoundException {
        Course course = repo.findById(id).orElseThrow(() -> new CourseNotFoundException());
        repo.delete(course);
    }

    private void setLessons() {
        lessons.get(0).add(new Lesson(" Understanding Algorithms\n",
                "An algorithm is a clear set of instructions that tells a computer how to perform a task or solve a problem. Think of it like a cooking recipe—each step must be followed in a specific order to get the desired result.\n" +
                        "Real-life Examples:\n" +
                        "A recipe for baking a cake.\n" +
                        "Instructions for making a phone call.\n" +
                        "Steps to withdraw cash from an ATM.\n" +
                        "Characteristics of a Good Algorithm:\n" +
                        "Clear and Unambiguous: Every step is well-defined.\n" +
                        "Finite: It must complete in a limited number of steps.\n" +
                        "Effective: Each operation must be basic enough to be performed.\n",
                "What Are Algorithms?",
                1,1, course[0]));

        lessons.get(0).add(new Lesson("Algorithm vs. Program\n",
                "Algorithm: A logical sequence of steps to solve a problem (language-independent).\n" +
                        "Program: An implementation of an algorithm using a specific programming language.\n" +
                        "Example:\n" +
                        "Algorithm to check if a number is even:\n" +
                        "Input number\n" +
                        "If number % 2 == 0 → Output: Even\n" +
                        "Else → Output: Odd\n" +
                        "Program (in Python):\n" +
                        "number = int(input(\"Enter a number: \"))\n" +
                        "if number % 2 == 0:\n" +
                        "    print(\"Even\")\n" +
                        "else:\n" +
                        "    print(\"Odd\")\n","What Are Algorithms?",
                2,1,course[0]));

        lessons.get(0).add(new Lesson("Writing Basic Pseudocode and Flowcharts\n",
                "Pseudocode is a way to describe algorithms using informal language close to programming. It's easier to understand than real code.\n" +
                        "Flowcharts use diagrams to visualize the sequence of steps.\n" +
                        "Example Task: Find the bigger of two numbers\n" +
                        "Pseudocode:\n" +
                        "START\n" +
                        "Input A\n" +
                        "Input B\n" +
                        "IF A > B THEN\n" +
                        "   Print \"A is greater\"\n" +
                        "ELSE\n" +
                        "   Print \"B is greater\"\n" +
                        "END IF\n" +
                        "END\n" +
                        "Flowchart:\n" +
                        "  [Start]\n" +
                        "     |\n" +
                        "  [Input A, B]\n" +
                        "     |\n" +
                        "[Is A > B?]\n" +
                        " /        \\\n" +
                        "Yes        No\n" +
                        " |          |\n" +
                        "[A is >]  [B is >]\n" +
                        "     \\    /\n" +
                        "     [End]",
                "What Are Algorithms?",3,1,course[0]));

        lessons.get(0).add(new Lesson("Classification by Function\n",
                "Algorithms can be categorized based on what they do:\n" +
                        "Search Algorithms: Find a specific value (e.g., linear search, binary search).\n" +
                        "Sort Algorithms: Organize data in a particular order (e.g., bubble sort, quicksort).\n" +
                        "Mathematical Algorithms: Perform numeric tasks (e.g., calculating GCD, prime checks).\n" +
                        "Decision-making Algorithms: Help make choices (e.g., if-else logic).\n",
               "Types of Algorithms",
                1,2,course[0]));

        lessons.get(0).add(new Lesson("Classification by Design Technique\n",
                "Design techniques describe how we approach building an algorithm:\n" +
                        "Brute Force: Try all possible solutions (simple but inefficient).\n" +
                        "Divide and Conquer: Break a problem into smaller parts (e.g., Merge Sort).\n" +
                        "Greedy: Always pick the best local option (e.g., coin change).\n" +
                        "Dynamic Programming: Solve overlapping subproblems efficiently (e.g., Fibonacci).\n" +
                        "Backtracking: Try options and backtrack if needed (e.g., Sudoku solver).\n",
                "Types of Algorithms",
                2,2,course[0]));

        lessons.get(0).add(new Lesson("Representing Algorithms Visually\n",
                "Let's represent a linear search algorithm.\n" +
                        "Pseudocode:\n" +
                        "START\n" +
                        "Input array A and value X\n" +
                        "FOR each item in A\n" +
                        "    IF item == X THEN\n" +
                        "        Print \"Found\"\n" +
                        "        STOP\n" +
                        "END FOR\n" +
                        "Print \"Not Found\"\n" +
                        "END\n" +
                        "Flowchart:\n" +
                        "[Start]\n" +
                        "   |\n" +
                        "[Input A and X]\n" +
                        "   |\n" +
                        "[Set i = 0]\n" +
                        "   |\n" +
                        "[i < Length of A?]--No-->[Print \"Not Found\"]-->[End]\n" +
                        "   |\n" +
                        "  Yes\n" +
                        "   |\n" +
                        "[A[i] == X?]--Yes-->[Print \"Found\"]-->[End]\n" +
                        "   |\n" +
                        "  No\n" +
                        "   |\n" +
                        "[i = i + 1]\n" +
                        "   |\n" +
                        "   ↓ (go back to loop)\n","Types of Algorithms",
                3,2,course[0]
                ));

        lessons.get(0).add(new Lesson("Problem-Solving Steps\n",
                "Understand the problem\n" +
                        "Break it down\n" +
                        "Design a solution\n" +
                        "Write the pseudocode\n" +
                        "Draw a flowchart\n" +
                        "Test it\n",
                "Problem Solving and Pseudocode Practice\n",
                1,3,course[0]));
        lessons.get(0).add(new Lesson("Common Pseudocode Patterns\n",
                "Sequential Execution:\n" +
                        "START  \n" +
                        "Print \"Hello\"  \n" +
                        "Print \"World\"  \n" +
                        "END\n" +
                        "Conditional Execution:\n" +
                        "IF age > 18 THEN  \n" +
                        "   Print \"Adult\"  \n" +
                        "ELSE  \n" +
                        "   Print \"Minor\"\n" +
                        "Loops:\n" +
                        "vbnet\n" +
                        "CopyEdit\n" +
                        "FOR i = 1 to 10  \n" +
                        "   Print i  \n" +
                        "END FOR",
                "Problem Solving and Pseudocode Practice\n",
                2,3,course[0]));
        lessons.get(0).add(new Lesson(" Pseudocode Practice – Even or Odd Numbers\n",
                "Pseudocode:\n" +
                        "START\n" +
                        "Input number\n" +
                        "IF number % 2 == 0 THEN\n" +
                        "   Print \"Even\"\n" +
                        "ELSE\n" +
                        "   Print \"Odd\"\n" +
                        "END\n" +
                        "Flowchart:\n" +
                        "[Start]\n" +
                        "   |\n" +
                        "[Input number]\n" +
                        "   |\n" +
                        "[Is number % 2 == 0?]\n" +
                        " /        \\\n" +
                        "Yes        No\n" +
                        " |          |\n" +
                        "[Even]     [Odd]\n" +
                        "     \\    /\n" +
                        "     [End]\n",
                "Problem Solving and Pseudocode Practice\n",
                3,3,course[0]));

        lessons.get(0).add(new Lesson("Sequential Control\n",
                "This is the simplest control structure where steps are executed one after the other in order.\n" +
                        "Example Pseudocode:\n" +
                        "START\n" +
                        "Input name\n" +
                        "Print \"Hello \" + name\n" +
                        "END\n" +
                        "Flowchart:\n" +
                        "[Start]\n" +
                        "   |\n" +
                        "[Input name]\n" +
                        "   |\n" +
                        "[Print \"Hello \" + name]\n" +
                        "   |\n" +
                        "[End]\n",
                "Control Structures in Algorithms",
                1,4,course[0]));
        lessons.get(0).add(new Lesson("Conditional Control (If-Else)\n",
                "Used when a decision is required.\n" +
                        "Pseudocode:\n" +
                        "START\n" +
                        "Input temperature\n" +
                        "IF temperature > 30 THEN\n" +
                        "   Print \"It's hot\"\n" +
                        "ELSE\n" +
                        "   Print \"It's cool\"\n" +
                        "END IF\n" +
                        "END\n" +
                        "Flowchart:\n" +
                        "[Start]\n" +
                        "   |\n" +
                        "[Input temperature]\n" +
                        "   |\n" +
                        "[Temp > 30?]--Yes-->[Print \"It's hot\"]\n" +
                        "         |\n" +
                        "        No\n" +
                        "         ↓\n" +
                        "[Print \"It's cool\"]\n" +
                        "         ↓\n" +
                        "       [End]\n",
               "Control Structures in Algorithms",
                2,4,course[0]));
        lessons.get(0).add(new Lesson(" Iterative Control (Loops)\n",
                "Loops repeat actions. Common loop types:\n" +
                        "For: Repeat a known number of times\n" +
                        "While: Repeat while a condition is true\n" +
                        "Do-While: Run at least once\n" +
                        "Pseudocode (While Loop):\n" +
                        "START\n" +
                        "Set i = 1\n" +
                        "WHILE i <= 5 DO\n" +
                        "   Print i\n" +
                        "   i = i + 1\n" +
                        "END WHILE\n" +
                        "END\n",
                "Control Structures in Algorithms",
                3,4,course[0]));

        lessons.get(0).add(new Lesson("Linear Search\n",
                "Check each element one by one.\n" +
                        "Pseudocode:\n" +
                        "START\n" +
                        "Input array A and target X\n" +
                        "FOR i = 0 to length(A) - 1\n" +
                        "   IF A[i] == X THEN\n" +
                        "      Print \"Found at i\"\n" +
                        "      STOP\n" +
                        "END FOR\n" +
                        "Print \"Not Found\"\n" +
                        "END\n" +
                        "Flowchart: (As in Unit 2 Lesson 3)\n",
                "Searching Algorithms",
                1,5,course[0]));

        lessons.get(0).add(new Lesson("Binary Search (Sorted Arrays Only)",
                "Check the middle, then halve the array each time.\n" +
                        "Pseudocode:\n" +
                        "START\n" +
                        "Input sorted array A and target X\n" +
                        "Set low = 0, high = length(A) - 1\n" +
                        "WHILE low <= high\n" +
                        "   mid = (low + high) / 2\n" +
                        "   IF A[mid] == X THEN\n" +
                        "      Print \"Found at mid\"\n" +
                        "      STOP\n" +
                        "   ELSE IF A[mid] < X THEN\n" +
                        "      low = mid + 1\n" +
                        "   ELSE\n" +
                        "      high = mid - 1\n" +
                        "END WHILE\n" +
                        "Print \"Not Found\"\n" +
                        "END\n","Searching Algorithms",
                2,5,course[0]
                ));

        lessons.get(0).add(new Lesson("When to Use Each Search",
                "Linear Search:\n" +
                        "- Use when data is unsorted\n" +
                        "- Simple to implement\n" +
                        "- Works on any data structure\n" +
                        "\n" +
                        "Binary Search:\n" +
                        "- Requires sorted data\n" +
                        "- Much faster for large datasets\n" +
                        "- Only works on random-access structures (arrays)\n" +
                        "\n" +
                        "Comparison:\n" +
                        "| Algorithm  | Best Case | Worst Case | Requires Sorted Data |\n" +
                        "|------------|-----------|------------|----------------------|\n" +
                        "| Linear     | O(1)      | O(n)       | No                   |\n" +
                        "| Binary     | O(1)      | O(log n)   | Yes                  |",
                "Searching Algorithms",
                3,5,course[0]));

        // Unit 6: Sorting Algorithms
        lessons.get(0).add(new Lesson("Bubble Sort",
                "Bubble sort compares adjacent items and swaps them if they are in the wrong order.\n" +
                        "Pseudocode:\n" +
                        "START\n" +
                        "Input array A\n" +
                        "FOR i = 0 to length(A)-1\n" +
                        "   FOR j = 0 to length(A)-i-2\n" +
                        "      IF A[j] > A[j+1] THEN\n" +
                        "         Swap A[j] and A[j+1]\n" +
                        "END FOR\n" +
                        "END\n" +
                        "Flowchart Overview:\n" +
                        "[Start] → [Input array]\n" +
                        " → [Outer Loop i]\n" +
                        "     → [Inner Loop j]\n" +
                        "        → [Compare A[j] & A[j+1]]\n" +
                        "            → [Swap if needed]\n" +
                        " → [Print sorted array] → [End]",
                "Sorting Algorithms",
                1,6,course[0]));

        lessons.get(0).add(new Lesson("Selection Sort",
                "Select the smallest element and move it to the front.\n" +
                        "Pseudocode:\n" +
                        "START\n" +
                        "Input array A\n" +
                        "FOR i = 0 to length(A)-1\n" +
                        "   min = i\n" +
                        "   FOR j = i+1 to length(A)\n" +
                        "      IF A[j] < A[min] THEN\n" +
                        "         min = j\n" +
                        "   Swap A[i] and A[min]\n" +
                        "END FOR\n" +
                        "END",
                "Sorting Algorithms",
                2,6,course[0]));

        lessons.get(0).add(new Lesson("Comparing Bubble and Selection Sort",
                "Bubble Sort:\n" +
                        "- Many swaps (O(n²) in worst case)\n" +
                        "- Stable (maintains order of equal elements)\n" +
                        "- Adaptive (can stop early if array is sorted)\n" +
                        "\n" +
                        "Selection Sort:\n" +
                        "- Fewer swaps (O(n) swaps total)\n" +
                        "- Not stable\n" +
                        "- Not adaptive\n" +
                        "\n" +
                        "Performance Comparison:\n" +
                        "Both have O(n²) time complexity, but selection sort generally performs better due to fewer swaps.",
                "Sorting Algorithms",
                3,6,course[0]));

        // Unit 7: Recursion
        lessons.get(0).add(new Lesson("What is Recursion?",
                "Recursion is when a function calls itself to solve smaller instances of the same problem.\n" +
                        "Key Components:\n" +
                        "1. Base Case - stopping condition\n" +
                        "2. Recursive Case - function calls itself\n" +
                        "\n" +
                        "Pseudocode:\n" +
                        "FUNCTION Factorial(n)\n" +
                        "   IF n == 1 THEN\n" +
                        "      RETURN 1\n" +
                        "   ELSE\n" +
                        "      RETURN n * Factorial(n - 1)\n" +
                        "END FUNCTION",
                "Recursion",
                1,7,course[0]));

        lessons.get(0).add(new Lesson("Recursive vs. Iterative",
                "Iterative Approach:\n" +
                        "- Uses loops\n" +
                        "- Generally more memory efficient\n" +
                        "- Often easier to understand for simple problems\n" +
                        "\n" +
                        "Recursive Approach:\n" +
                        "- Calls itself\n" +
                        "- More elegant for certain problems (trees, divide-and-conquer)\n" +
                        "- Can be less memory efficient due to call stack\n" +
                        "\n" +
                        "Example: Factorial\n" +
                        "Iterative:\n" +
                        "result = 1\n" +
                        "FOR i = 1 to n\n" +
                        "   result = result * i\n" +
                        "\n" +
                        "Recursive: (as shown in previous lesson)",
                "Recursion",
                2,7,course[0]));

        lessons.get(0).add(new Lesson("Visualizing Recursion (Factorial)",
                "Factorial(3) = 3 * 2 * 1\n" +
                        "Calls happen like:\n" +
                        "Factorial(3)\n" +
                        "→ 3 * Factorial(2)\n" +
                        "    → 2 * Factorial(1)\n" +
                        "        → 1 (base case)\n" +
                        "\n" +
                        "Call Stack:\n" +
                        "1. Factorial(3) waits for Factorial(2)\n" +
                        "2. Factorial(2) waits for Factorial(1)\n" +
                        "3. Factorial(1) returns 1\n" +
                        "4. Factorial(2) returns 2 * 1 = 2\n" +
                        "5. Factorial(3) returns 3 * 2 = 6",
                "Recursion",
                3,7,course[0]));

        lessons.get(0).add(new Lesson("Why Efficiency Matters",
                "Two algorithms might solve the same problem but one is faster or uses less memory.\n" +
                        "More efficient algorithms are critical when handling large data.\n" +
                        "\n" +
                        "Example:\n" +
                        "Searching a phone book with 1 million entries:\n" +
                        "- Linear search: Could take 1 million checks\n" +
                        "- Binary search: Only ~20 checks needed\n" +
                        "\n" +
                        "Factors Affecting Efficiency:\n" +
                        "1. Time complexity (how runtime grows with input size)\n" +
                        "2. Space complexity (how memory usage grows)",
                "Algorithm Efficiency and Big-O Notation",
                1,8,course[0]));

        lessons.get(0).add(new Lesson("Big-O Notation",
                "Describes the worst-case time complexity of an algorithm.\n" +
                        "\n" +
                        "Common Complexities:\n" +
                        "O(1) - Constant time (best)\n" +
                        "O(log n) - Logarithmic (excellent)\n" +
                        "O(n) - Linear (good)\n" +
                        "O(n log n) - Linearithmic (decent)\n" +
                        "O(n²) - Quadratic (poor)\n" +
                        "O(2ⁿ) - Exponential (worst)\n" +
                        "\n" +
                        "How to Determine Big-O:\n" +
                        "1. Count the number of basic operations\n" +
                        "2. Keep the fastest growing term\n" +
                        "3. Drop constants",
                "Algorithm Efficiency and Big-O Notation",
                2,8,course[0]));

        lessons.get(0).add(new Lesson("Comparing Algorithm Performance",
                "Scenario: You need to find a number in a list of 1 million items.\n" +
                        "\n" +
                        "Linear Search (O(n)):\n" +
                        "- Might check all 1M items\n" +
                        "- Simple to implement\n" +
                        "- Works on unsorted data\n" +
                        "\n" +
                        "Binary Search (O(log n)):\n" +
                        "- Will check ~20 times (log₂1M ≈ 20)\n" +
                        "- Requires sorted data\n" +
                        "- More complex to implement\n" +
                        "\n" +
                        "Performance Comparison:\n" +
                        "| Input Size | Linear (n) | Binary (log n) |\n" +
                        "|------------|------------|----------------|\n" +
                        "| 10         | 10         | ~3             |\n" +
                        "| 1,000      | 1,000      | ~10            |\n" +
                        "| 1,000,000  | 1,000,000  | ~20            |",
                "Algorithm Efficiency and Big-O Notation",
                3,8,course[0]));

        // Unit 9: Divide and Conquer Algorithms
        lessons.get(0).add(new Lesson("What is Divide and Conquer?",
                "It breaks a problem into smaller subproblems, solves them recursively, then combines the results.\n" +
                        "\n" +
                        "Steps:\n" +
                        "1. Divide the problem\n" +
                        "2. Conquer the subproblems\n" +
                        "3. Combine the solutions\n" +
                        "\n" +
                        "Examples:\n" +
                        "- Merge Sort\n" +
                        "- Quick Sort\n" +
                        "- Binary Search\n" +
                        "\n" +
                        "Advantages:\n" +
                        "- Often more efficient than brute force\n" +
                        "- Can be parallelized\n" +
                        "- Elegant recursive solutions",
                "Divide and Conquer Algorithms",
                1,9,course[0]));

        lessons.get(0).add(new Lesson("Merge Sort (with Pseudocode)",
                "Merge Sort Pseudocode:\n" +
                        "FUNCTION MergeSort(arr)\n" +
                        "   IF length of arr > 1 THEN\n" +
                        "      mid = length(arr) / 2\n" +
                        "      left = MergeSort(arr[0:mid])\n" +
                        "      right = MergeSort(arr[mid:end])\n" +
                        "      RETURN Merge(left, right)\n" +
                        "   ELSE\n" +
                        "      RETURN arr\n" +
                        "END FUNCTION\n" +
                        "\n" +
                        "FUNCTION Merge(left, right)\n" +
                        "   result = empty list\n" +
                        "   WHILE left and right are not empty\n" +
                        "      IF left[0] < right[0] THEN\n" +
                        "         Append left[0] to result\n" +
                        "         Remove left[0]\n" +
                        "      ELSE\n" +
                        "         Append right[0] to result\n" +
                        "         Remove right[0]\n" +
                        "   Append remaining elements from left and right to result\n" +
                        "   RETURN result\n" +
                        "END FUNCTION\n" +
                        "\n" +
                        "Time Complexity: O(n log n)\n" +
                        "Space Complexity: O(n)",
                "Divide and Conquer Algorithms",
                2,9,course[0]));

        lessons.get(0).add(new Lesson("Merge Sort Flowchart Overview",
                "[Start]\n" +
                        "   |\n" +
                        "[Check array length > 1?]\n" +
                        "   |\n" +
                        "  Yes\n" +
                        "   ↓\n" +
                        "[Divide array into halves]\n" +
                        "   ↓\n" +
                        "[Recursively sort each half]\n" +
                        "   ↓\n" +
                        "[Merge two sorted halves]\n" +
                        "   ↓\n" +
                        "[Return sorted array]\n" +
                        "   ↓\n" +
                        "[End]\n" +
                        "\n" +
                        "Visualization:\n" +
                        "Original: [3, 1, 4, 2]\n" +
                        "Divide:\n" +
                        "[3, 1]  [4, 2]\n" +
                        "Divide again:\n" +
                        "[3] [1]  [4] [2]\n" +
                        "Merge:\n" +
                        "[1, 3]  [2, 4]\n" +
                        "Final Merge:\n" +
                        "[1, 2, 3, 4]",
                "Divide and Conquer Algorithms",
                3,9,course[0]));

        // Unit 10: Greedy Algorithms and Dynamic Programming
        lessons.get(0).add(new Lesson("Greedy Algorithms",
                "Make the best local choice at each step, hoping for the global best solution.\n" +
                        "\n" +
                        "Characteristics:\n" +
                        "- Makes locally optimal choices\n" +
                        "- Never reconsider previous choices\n" +
                        "- Often simple and efficient\n" +
                        "\n" +
                        "Example: Coin Change (Greedy Version)\n" +
                        "Pseudocode:\n" +
                        "START\n" +
                        "Input amount and coin values [25, 10, 5, 1]\n" +
                        "FOR each coin in list\n" +
                        "   WHILE amount >= coin\n" +
                        "      amount = amount - coin\n" +
                        "      count++\n" +
                        "Print count\n" +
                        "END\n" +
                        "\n" +
                        "Note: Works for US coins but not all currency systems",
                "Greedy Algorithms and Dynamic Programming",
                1,10,course[0]));

        lessons.get(0).add(new Lesson("Dynamic Programming",
                "Used when problems have overlapping subproblems and optimal substructure.\n" +
                        "\n" +
                        "Key Concepts:\n" +
                        "1. Memoization - Store results of subproblems\n" +
                        "2. Tabulation - Build solution bottom-up\n" +
                        "\n" +
                        "Example: Fibonacci Sequence\n" +
                        "Recursive (Inefficient):\n" +
                        "FUNCTION Fib(n)\n" +
                        "   IF n <= 1 THEN RETURN n\n" +
                        "   RETURN Fib(n-1) + Fib(n-2)\n" +
                        "\n" +
                        "Dynamic Programming (Efficient):\n" +
                        "FUNCTION Fib(n)\n" +
                        "   Create array F[0...n]\n" +
                        "   F[0] = 0\n" +
                        "   F[1] = 1\n" +
                        "   FOR i = 2 to n\n" +
                        "      F[i] = F[i-1] + F[i-2]\n" +
                        "   RETURN F[n]\n" +
                        "END FUNCTION\n" +
                        "\n" +
                        "Time Complexity: O(n) vs O(2ⁿ) for naive recursion",
                "Greedy Algorithms and Dynamic Programming",
                2,10,course[0]));

        lessons.get(0).add(new Lesson("Greedy vs Dynamic Programming",
                "Greedy:\n" +
                        "- Makes one decision at each step\n" +
                        "- Never reconsider choices\n" +
                        "- Generally faster\n" +
                        "- Doesn't always find optimal solution\n" +
                        "\n" +
                        "Dynamic Programming:\n" +
                        "- Explores all possibilities\n" +
                        "- Stores intermediate results\n" +
                        "- Slower but guarantees optimal solution\n" +
                        "- More memory intensive\n" +
                        "\n" +
                        "When to Use:\n" +
                        "Greedy - When local optimal leads to global optimal\n" +
                        "DP - When problems have overlapping subproblems\n" +
                        "\n" +
                        "Example Problems:\n" +
                        "- Greedy: Coin change (US system), Dijkstra's algorithm\n" +
                        "- DP: Fibonacci, Knapsack problem, Longest common subsequence",
                "Greedy Algorithms and Dynamic Programming",
                3,10,course[0]));

        // Course 1: C Programming lessons
        lessons.get(1).add(new Lesson("What is C Programming?",
                "C is a powerful and efficient programming language that has been around since the early 1970s...",
                "Introduction to C and Setup", 1, 1, course[1]));

        lessons.get(1).add(new Lesson("Why Learn C?",
                "Learning C provides a solid foundation for becoming a better programmer. Here's why:\n" +
                        "Understanding the Machine: C gives you direct access to how the computer works...",
                "Introduction to C and Setup", 2, 1, course[1]));

        lessons.get(1).add(new Lesson("Setting Up Your Environment",
                "To begin coding in C, you need two things: a code editor and a C compiler...\n" +
                        "Install a C Compiler:\n" +
                        "Windows: Install Code::Blocks, Dev C++, or use MinGW with VS Code...\n" +
                        "Hello, World! Program: Here's your first C program:\n" +
                        "#include <stdio.h>\n\n" +
                        "int main() {\n" +
                        "    printf(\"Hello, World!\\n\");\n" +
                        "    return 0;\n" +
                        "}",
                "Introduction to C and Setup", 3, 1, course[1]));

        lessons.get(1).add(new Lesson("Declaring and Initializing Variables",
                "In C, variables are containers that store data during the execution of a program...\n" +
                        "Syntax:\n" +
                        "int age;         // declaration\n" +
                        "age = 25;        // initialization\n" +
                        "int age = 25;    // declaration and initialization",
                "Variables and Data Types", 1, 2, course[1]));

        lessons.get(1).add(new Lesson("Understanding Data Types",
                "Understanding data types is essential for writing efficient C programs...\n" +
                        "You can use sizeof() to find out how much memory a variable or type occupies.",
                "Variables and Data Types", 2, 2, course[1]));

        lessons.get(1).add(new Lesson("Constants and Type Modifiers",
                "Sometimes you may want to create a variable whose value cannot be changed...\n" +
                        "Constant Example:\n" +
                        "const float PI = 3.14;\n" +
                        "C also allows modifying types with keywords like:\n" +
                        "short, long - modify the size of integers\n" +
                        "unsigned - used for only positive numbers",
                "Variables and Data Types", 3, 2, course[1]));


        lessons.get(1).add(new Lesson("Arithmetic Operators",
                "In C, arithmetic operators allow you to perform basic mathematical operations. These include:\n" +
                        "+ (Addition)\n" +
                        "- (Subtraction)\n" +
                        "* (Multiplication)\n" +
                        "/ (Division)\n" +
                        "% (Modulus - returns the remainder)\n" +
                        "Example:\n" +
                        "int a = 10, b = 3;\n" +
                        "printf(\"Addition: %d\\n\", a + b);       // 13\n" +
                        "printf(\"Subtraction: %d\\n\", a - b);    // 7\n" +
                        "printf(\"Multiplication: %d\\n\", a * b); // 30\n" +
                        "printf(\"Division: %d\\n\", a / b);       // 3\n" +
                        "printf(\"Modulus: %d\\n\", a % b);        // 1\n" +
                        "Note: Division between integers will drop any decimal part (e.g., 7 / 2 = 3).",
                "Operators and Expressions", 1, 3, course[1]));

        lessons.get(1).add(new Lesson("Relational and Logical Operators",
                "Relational operators are used to compare two values. Logical operators allow combining multiple conditions.\n" +
                        "Relational Operators:\n" +
                        "== (equal to)\n" +
                        "!= (not equal to)\n" +
                        "> (greater than)\n" +
                        "< (less than)\n" +
                        ">= (greater than or equal to)\n" +
                        "<= (less than or equal to)\n" +
                        "Logical Operators:\n" +
                        "&& (AND)\n" +
                        "|| (OR)\n" +
                        "! (NOT)\n" +
                        "Example:\n" +
                        "int x = 10, y = 20;\n\n" +
                        "if (x < y && y != 0) {\n" +
                        "    printf(\"Both conditions are true.\\n\");\n" +
                        "}\n\n" +
                        "if (x == 10 || y == 15) {\n" +
                        "    printf(\"At least one condition is true.\\n\");\n" +
                        "}",
                "Operators and Expressions", 2, 3, course[1]));

        lessons.get(1).add(new Lesson("Expressions and Operator Precedence",
                "Expressions combine variables and operators to produce a result. Operator precedence determines the order of evaluation.\n" +
                        "Precedence Example:\n" +
                        "int result = 10 + 5 * 2; // Multiplication happens first: 5*2 = 10, then 10+10 = 20\n" +
                        "To control precedence, use parentheses:\n" +
                        "int result = (10 + 5) * 2; // Parentheses first: 15*2 = 30",
                "Operators and Expressions", 3, 3, course[1]));

        // Unit 4: Control Structures
        lessons.get(1).add(new Lesson("If and If-Else Statements",
                "The if statement allows your program to make decisions.\n" +
                        "Syntax:\n" +
                        "if (condition) {\n" +
                        "    // code runs if condition is true\n" +
                        "} else {\n" +
                        "    // code runs if condition is false\n" +
                        "}\n" +
                        "Example:\n" +
                        "int score = 85;\n\n" +
                        "if (score >= 90) {\n" +
                        "    printf(\"Excellent!\\n\");\n" +
                        "} else if (score >= 75) {\n" +
                        "    printf(\"Good job!\\n\");\n" +
                        "} else {\n" +
                        "    printf(\"Keep practicing.\\n\");\n" +
                        "}\n" +
                        "You can nest if statements or use else if for multiple conditions.",
                "Control Structures", 1, 4, course[1]));

        lessons.get(1).add(new Lesson("Switch Statement",
                "The switch statement is useful for checking many constant values.\n" +
                        "Syntax:\n" +
                        "switch (value) {\n" +
                        "    case 1:\n" +
                        "        // code\n" +
                        "        break;\n" +
                        "    case 2:\n" +
                        "        // code\n" +
                        "        break;\n" +
                        "    default:\n" +
                        "        // code\n" +
                        "}\n" +
                        "Example:\n" +
                        "int day = 3;\n" +
                        "switch (day) {\n" +
                        "    case 1: printf(\"Monday\\n\"); break;\n" +
                        "    case 2: printf(\"Tuesday\\n\"); break;\n" +
                        "    case 3: printf(\"Wednesday\\n\"); break;\n" +
                        "    default: printf(\"Other day\\n\");\n" +
                        "}",
                "Control Structures", 2, 4, course[1]));

        lessons.get(1).add(new Lesson("Nested Conditionals and Logical Combinations",
                "You can combine if with &&, ||, or ! to check complex conditions.\n" +
                        "Example:\n" +
                        "int age = 18;\n" +
                        "char citizen = 'Y';\n\n" +
                        "if (age >= 18 && citizen == 'Y') {\n" +
                        "    printf(\"You can vote.\\n\");\n" +
                        "} else {\n" +
                        "    printf(\"You cannot vote.\\n\");\n" +
                        "}",
                "Control Structures", 3, 4, course[1]));

        // Unit 5: Loops
        lessons.get(1).add(new Lesson("While Loop",
                "The while loop runs code repeatedly as long as the condition is true.\n" +
                        "Syntax:\n" +
                        "while (condition) {\n" +
                        "    // repeated code\n" +
                        "}\n" +
                        "Example:\n" +
                        "int i = 0;\n" +
                        "while (i < 5) {\n" +
                        "    printf(\"%d\\n\", i);\n" +
                        "    i++;\n" +
                        "}",
                "Loops", 1, 5, course[1]));

        lessons.get(1).add(new Lesson("For Loop",
                "The for loop is best when you know how many times you need to repeat something.\n" +
                        "Syntax:\n" +
                        "for (initialization; condition; update) {\n" +
                        "    // code\n" +
                        "}\n" +
                        "Example:\n" +
                        "for (int i = 1; i <= 5; i++) {\n" +
                        "    printf(\"Count: %d\\n\", i);\n" +
                        "}",
                "Loops", 2, 5, course[1]));

        lessons.get(1).add(new Lesson("Do-While Loop",
                "A do-while loop always runs at least once, even if the condition is false at the start.\n" +
                        "Syntax:\n" +
                        "do {\n" +
                        "    // code\n" +
                        "} while (condition);\n" +
                        "Example:\n" +
                        "int i = 0;\n" +
                        "do {\n" +
                        "    printf(\"Value: %d\\n\", i);\n" +
                        "    i++;\n" +
                        "} while (i < 3);",
                "Loops", 3, 5, course[1]));

            // Previous units (1-5) remain unchanged

            // Unit 6: Functions
            lessons.get(1).add(new Lesson("Defining and Using Functions",
                    "Functions in C allow you to reuse code and keep your programs organized.\n" +
                            "Syntax:\n" +
                            "return_type function_name(parameter_list) {\n" +
                            "    // function body\n" +
                            "}\n" +
                            "Example:\n" +
                            "int add(int a, int b) {\n" +
                            "    return a + b;\n" +
                            "}\n\n" +
                            "int main() {\n" +
                            "    int result = add(4, 5);\n" +
                            "    printf(\"Sum: %d\\n\", result);\n" +
                            "    return 0;\n" +
                            "}",
                    "Functions", 1, 6, course[1]));

            lessons.get(1).add(new Lesson("Function Parameters and Return Values",
                    "Functions can take parameters and return values. You can pass multiple arguments and return a result using return.\n" +
                            "Example:\n" +
                            "float multiply(float x, float y) {\n" +
                            "    return x * y;\n" +
                            "}\n" +
                            "Calling the function:\n" +
                            "float answer = multiply(2.5, 3.0);",
                    "Functions", 2, 6, course[1]));

            lessons.get(1).add(new Lesson("Void Functions and Function Prototypes",
                    "Void functions don't return a value. Function prototypes tell the compiler about the function before it's used.\n" +
                            "Example:\n" +
                            "void greet();\n\n" +
                            "int main() {\n" +
                            "    greet();\n" +
                            "    return 0;\n" +
                            "}\n\n" +
                            "void greet() {\n" +
                            "    printf(\"Hello!\\n\");\n" +
                            "}\n" +
                            "Function Prototype:\n" +
                            "void greet(); // declared at the top before main",
                    "Functions", 3, 6, course[1]));

            // Unit 7: Arrays
            lessons.get(1).add(new Lesson("Introduction to Arrays",
                    "An array stores multiple values of the same type.\n" +
                            "Syntax:\n" +
                            "int numbers[5];\n" +
                            "You can access or assign elements by index (starts from 0).\n" +
                            "numbers[0] = 10;\n" +
                            "printf(\"%d\\n\", numbers[0]);",
                    "Arrays", 1, 7, course[1]));

            lessons.get(1).add(new Lesson("Initializing and Accessing Arrays",
                    "You can initialize arrays while declaring them:\n" +
                            "int values[3] = {10, 20, 30};\n" +
                            "Use loops to access array values:\n" +
                            "for (int i = 0; i < 3; i++) {\n" +
                            "    printf(\"%d\\n\", values[i]);\n" +
                            "}",
                    "Arrays", 2, 7, course[1]));

            lessons.get(1).add(new Lesson("Multidimensional Arrays",
                    "Arrays can have more than one dimension.\n" +
                            "2D Array Example:\n" +
                            "int matrix[2][3] = {\n" +
                            "    {1, 2, 3},\n" +
                            "    {4, 5, 6}\n" +
                            "};\n\n" +
                            "printf(\"%d\\n\", matrix[1][2]); // Output: 6",
                    "Arrays", 3, 7, course[1]));

            // Unit 8: Strings
            lessons.get(1).add(new Lesson("Declaring and Using Strings",
                    "In C, strings are arrays of characters ending with a null character \\0.\n" +
                            "Syntax:\n" +
                            "char name[10] = \"John\";\n" +
                            "You can also use:\n" +
                            "char name[] = {'J', 'o', 'h', 'n', '\\0'};\n" +
                            "Use printf and %s to display strings:\n" +
                            "printf(\"Name: %s\\n\", name);",
                    "Strings", 1, 8, course[1]));

            lessons.get(1).add(new Lesson("Common String Functions",
                    "The string library <string.h> provides useful functions:\n" +
                            "strlen(str) – length of string\n" +
                            "strcpy(dest, src) – copies string\n" +
                            "strcmp(str1, str2) – compares strings\n" +
                            "strcat(dest, src) – concatenates strings\n" +
                            "Example:\n" +
                            "#include <string.h>\n\n" +
                            "char s1[20] = \"Hello\";\n" +
                            "char s2[] = \"World\";\n" +
                            "strcat(s1, s2); // s1 becomes \"HelloWorld\"",
                    "Strings", 2, 8, course[1]));

            lessons.get(1).add(new Lesson("Input and Output of Strings",
                    "Use scanf or fgets to read strings:\n" +
                            "char name[30];\n" +
                            "scanf(\"%s\", name); // reads until space\n" +
                            "Prefer fgets for full lines:\n" +
                            "fgets(name, sizeof(name), stdin);",
                    "Strings", 3, 8, course[1]));

        lessons.get(1).add(new Lesson("Introduction to Pointers",
                "A pointer stores the address of another variable.\n" +
                        "Syntax:\n" +
                        "int a = 10;\n" +
                        "int *ptr = &a;\n" +
                        "&a gives the address of a\n" +
                        "*ptr accesses the value at that address",
                "Pointers", 1, 9, course[1]));

        lessons.get(1).add(new Lesson("Pointer Arithmetic",
                "You can use arithmetic on pointers to navigate memory:\n" +
                        "int arr[3] = {10, 20, 30};\n" +
                        "int *p = arr;\n\n" +
                        "printf(\"%d\\n\", *(p + 1)); // 20",
                "Pointers", 2, 9, course[1]));

        lessons.get(1).add(new Lesson("Pointers and Functions",
                "Pointers allow functions to modify variables by reference.\n" +
                        "Example:\n" +
                        "void update(int *x) {\n" +
                        "    *x = 50;\n" +
                        "}\n\n" +
                        "int main() {\n" +
                        "    int a = 10;\n" +
                        "    update(&a);\n" +
                        "    printf(\"%d\\n\", a); // 50\n" +
                        "}",
                "Pointers", 3, 9, course[1]));

        // Unit 10: Structures and Final Review
        lessons.get(1).add(new Lesson("Introduction to Structures",
                "Structures let you group variables of different types.\n" +
                        "Syntax:\n" +
                        "struct Person {\n" +
                        "    char name[20];\n" +
                        "    int age;\n" +
                        "};\n\n" +
                        "struct Person p1 = {\"Alice\", 30};",
                "Structures and Final Review", 1, 10, course[1]));

        lessons.get(1).add(new Lesson("Accessing and Using Structures",
                "Access structure members with the . operator:\n" +
                        "printf(\"Name: %s\\n\", p1.name);\n" +
                        "printf(\"Age: %d\\n\", p1.age);\n" +
                        "You can also use pointers with structures:\n" +
                        "struct Person *ptr = &p1;\n" +
                        "printf(\"%s\\n\", ptr->name);",
                "Structures and Final Review", 2, 10, course[1]));

        lessons.get(1).add(new Lesson("Structures in Functions",
                "Pass structures to functions by value or by reference.\n" +
                        "Example (by reference):\n" +
                        "void print(struct Person *p) {\n" +
                        "    printf(\"Name: %s\\n\", p->name);\n" +
                        "}\n\n" +
                        "print(&p1);",
                "Structures and Final Review", 3, 10, course[1]));






    }

    private void setQuizzes() {

        quizzes.get(0).add(new Quiz("Intro to Algorithm",
                1,1,course[0],questions.get(0)));
        quizzes.get(0).add(new Quiz("Types of algorithms",
                1,2,course[0],questions.get(1)));
        quizzes.get(0).add(new Quiz("Pseudocode Practice – Even or Odd Numbers",
                1,3,course[0],questions.get(2)));
        quizzes.get(0).add(new Quiz("Iterative Control (Loops)\n",
                1,4,course[0],questions.get(3)));
        quizzes.get(0).add(new Quiz("Searching Algorithms",
                1,5,course[0],questions.get(4)));
        quizzes.get(0).add(new Quiz("Sorting Algorithms",
                1,6,course[0],questions.get(5)));
        quizzes.get(0).add(new Quiz("Recursion",
                1,7,course[0],questions.get(6)));
        quizzes.get(0).add(new Quiz("Algorithm Efficiency",
                1,8,course[0],questions.get(7)));
        quizzes.get(0).add(new Quiz("Divide and Conquer",
                1,9,course[0],questions.get(8)));
        quizzes.get(0).add(new Quiz("Greedy and Dynamic Programming",
                1,10,course[0],questions.get(9)));
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
                "a) A programming language\n" +
                        "b) A set of rules to solve a problem ✅\n" +
                        "c) A list of computer parts\n" +
                        "d) A coding app\n",
                quizzes.get(0).get(0)));
        questions.get(0).add(new Question("2. What makes an algorithm effective?\n",
                "a) It’s written in JavaScript\n" +
                        "b) It has infinite steps\n" +
                        "c) Its steps are simple and doable ✅\n" +
                        "d) It’s complicated\n",quizzes.get(0).get(0)));
        questions.get(0).add(new Question("3. What’s the difference between an algorithm and a program?\n",
                "a) There’s no difference\n" +
                        "b) A program is a high-level algorithm\n" +
                        "c) An algorithm is logic; a program is its coded form ✅\n" +
                        "d) An algorithm uses syntax rules\n",
                quizzes.get(0).get(0)));

        questions.get(1).add(new Question("1. What type of algorithm is used to sort numbers?\n",
                "a) Search\n" +
                        "b) Math\n" +
                        "c) Sort ✅\n" +
                        "d) Decision-making\n",
                quizzes.get(0).get(1)));

        questions.get(1).add(new Question("2. What does a greedy algorithm do?\n",
                "a) Checks all options\n" +
                        "b) Breaks into subproblems\n" +
                        "c) Picks best local option ✅\n" +
                        "d) Stores all past choices\n",
                quizzes.get(0).get(1)));
        questions.get(1).add(new Question("3. Which is a visual representation of an algorithm?\n",
                "a) HTML\n" +
                        "b) Flowchart ✅\n" +
                        "c) Compiler\n" +
                        "d) Editor\n",
                quizzes.get(0).get(1)));

        questions.get(2).add(new Question("1. Which of these is the correct first step in problem-solving?\n",
                "a) Code immediately\n" +
                        "b) Understand the problem ✅\n" +
                        "c) Write a flowchart\n" +
                        "d) Print the result\n",
                quizzes.get(0).get(2)));
        questions.get(2).add(new Question("2. What does a FOR loop do?\n",
                "a) Makes choices\n" +
                        "b) Repeats steps ✅\n" +
                        "c) Draws flowcharts\n" +
                        "d) Solves automatically\n",
                quizzes.get(0).get(2)));
        questions.get(2).add(new Question("3. What is the output of an odd number check for 5?\n",
                "a) Even\n" +
                        "b) Error\n" +
                        "c) Odd ✅\n" +
                        "d) Prime\n",
                quizzes.get(0).get(2)));

        questions.get(3).add(new Question("1. What control structure runs steps in a row?\n",
                "a) Loop\n" +
                        "b) Sequential ✅\n" +
                        "c) Branch\n" +
                        "d) Function\n",
                quizzes.get(0).get(3)));
        questions.get(3).add(new Question("2. Which one is a conditional statement?\n",
                "a) WHILE\n" +
                        "b) FOR\n" +
                        "c) IF ✅\n" +
                        "d) REPEAT\n",
                quizzes.get(0).get(3)));
        questions.get(3).add(new Question("3. How many times will a WHILE loop run if the condition is never true?\n",
                "a) One\n" +
                        "b) Five\n" +
                        "c) Infinite\n" +
                        "d) Zero ✅\n",
                quizzes.get(0).get(3)));

        questions.get(4).add(new Question("What search algorithm checks each element?",
                "a) Linear ✅\n" +
                        "b) Binary\n" +
                        "c) Greedy\n" +
                        "d) Depth-first",
                quizzes.get(0).get(4)));
        questions.get(4).add(new Question("Binary search needs the array to be:",
                "a) Empty\n" +
                        "b) Sorted ✅\n" +
                        "c) Small\n" +
                        "d) Random",
                quizzes.get(0).get(4)));
        questions.get(4).add(new Question("What's the main advantage of binary search?",
                "a) Easy to implement\n" +
                        "b) Works on all data\n" +
                        "c) Fewer comparisons ✅\n" +
                        "d) Uses more memory",
                quizzes.get(0).get(4)));

        // Unit 6: Sorting Algorithms questions
        questions.get(5).add(new Question("What does bubble sort do repeatedly?",
                "a) Pick minimum\n" +
                        "b) Divide array\n" +
                        "c) Swap adjacent values ✅\n" +
                        "d) Pick maximum",
                quizzes.get(0).get(5)));
        questions.get(5).add(new Question("Which sort uses fewer swaps?",
                "a) Bubble\n" +
                        "b) Selection ✅\n" +
                        "c) Merge\n" +
                        "d) Binary",
                quizzes.get(0).get(5)));
        questions.get(5).add(new Question("What's the first step in selection sort?",
                "a) Swap last item\n" +
                        "b) Find largest\n" +
                        "c) Find smallest ✅\n" +
                        "d) Sort half",
                quizzes.get(0).get(5)));

        // Unit 7: Recursion questions
        questions.get(6).add(new Question("What is recursion?",
                "a) Looping 10 times\n" +
                        "b) Repeating without stopping\n" +
                        "c) A function calling itself ✅\n" +
                        "d) A nested loop",
                quizzes.get(0).get(6)));
        questions.get(6).add(new Question("What's the base case in recursion?",
                "a) The largest input\n" +
                        "b) When recursion starts\n" +
                        "c) The condition to stop ✅\n" +
                        "d) A loop variable",
                quizzes.get(0).get(6)));
        questions.get(6).add(new Question("Recursive calls are stored in:",
                "a) Heap\n" +
                        "b) Queue\n" +
                        "c) Stack ✅\n" +
                        "d) Table",
                quizzes.get(0).get(6)));

        questions.get(7).add(new Question("What does Big-O describe?",
                "a) Memory usage\n" +
                        "b) Speed in best case\n" +
                        "c) Worst-case complexity ✅\n" +
                        "d) Visual diagrams",
                quizzes.get(0).get(7)));
        questions.get(7).add(new Question("Which is fastest for large data?",
                "a) O(n²)\n" +
                        "b) O(n)\n" +
                        "c) O(1) ✅\n" +
                        "d) O(log n²)",
                quizzes.get(0).get(7)));
        questions.get(7).add(new Question("What is the complexity of bubble sort?",
                "a) O(n²) ✅\n" +
                        "b) O(log n)\n" +
                        "c) O(1)\n" +
                        "d) O(n)",
                quizzes.get(0).get(7)));

        // Unit 9: Divide and Conquer questions
        questions.get(8).add(new Question("Divide and conquer works by:",
                "a) Repeating steps\n" +
                        "b) Guessing answers\n" +
                        "c) Dividing into smaller problems ✅\n" +
                        "d) Sorting manually",
                quizzes.get(0).get(8)));
        questions.get(8).add(new Question("Merge sort is an example of:",
                "a) Iterative algorithm\n" +
                        "b) Divide and conquer ✅\n" +
                        "c) Brute force\n" +
                        "d) Greedy",
                quizzes.get(0).get(8)));
        questions.get(8).add(new Question("The base case of Merge Sort is:",
                "a) Array is empty\n" +
                        "b) Array has more than 1 item\n" +
                        "c) Array has one item ✅\n" +
                        "d) Array is full",
                quizzes.get(0).get(8)));

        // Unit 10: Greedy and DP questions
        questions.get(9).add(new Question("Greedy algorithms:",
                "a) Try all options\n" +
                        "b) Make the worst choice\n" +
                        "c) Pick the best current option ✅\n" +
                        "d) Store all paths",
                quizzes.get(0).get(9)));
        questions.get(9).add(new Question("Dynamic programming:",
                "a) Never repeats\n" +
                        "b) Repeats with no memory\n" +
                        "c) Solves overlapping problems ✅\n" +
                        "d) Uses recursion only",
                quizzes.get(0).get(9)));
        questions.get(9).add(new Question("Which is better for Fibonacci?",
                "a) Greedy\n" +
                        "b) Recursion\n" +
                        "c) Dynamic programming ✅\n" +
                        "d) Looping backward",
                quizzes.get(0).get(9)));

        questions.get(1).add(new Question("1. What type of language is C?",
                "• a) Interpreted\n" +
                        "• b) Object-oriented only\n" +
                        "• c) Procedural and compiled ✅\n" +
                        "• d) Visual scripting",
                quizzes.get(1).get(0)));

        questions.get(1).add(new Question("2. Why is C still popular today?",
                "• a) It has the best graphics\n" +
                        "• b) It's required for web development\n" +
                        "• c) It's simple, efficient, and foundational ✅\n" +
                        "• d) It's the only language for AI",
                quizzes.get(1).get(0)));

        questions.get(1).add(new Question("3. What's the role of a compiler in C?",
                "• a) To edit the code\n" +
                        "• b) To add syntax highlighting\n" +
                        "• c) To convert the code into an executable ✅\n" +
                        "• d) To debug the program automatically",
                quizzes.get(1).get(0)));

        questions.get(1).add(new Question("4. What does #include <stdio.h> do?",
                "• a) Includes Java libraries\n" +
                        "• b) Starts a loop\n" +
                        "• c) Imports standard input/output functions ✅\n" +
                        "• d) Initializes a variable",
                quizzes.get(1).get(0)));

        questions.get(1).add(new Question("5. What is printed by this code?\nprintf(\"Hi there!\\n\");",
                "• a) printf(\"Hi there!\");\n" +
                        "• b) Hi there! ✅\n" +
                        "• c) \\n\n" +
                        "• d) An error",
                quizzes.get(1).get(0)));

        questions.get(1).add(new Question("1. Which keyword is used to declare an integer variable in C?",
                "• a) num\n" +
                        "• b) var\n" +
                        "• c) int ✅\n" +
                        "• d) digit",
                quizzes.get(1).get(1)));

        questions.get(1).add(new Question("2. What will be the size of a double in most systems?",
                "• a) 2 bytes\n" +
                        "• b) 4 bytes\n" +
                        "• c) 8 bytes ✅\n" +
                        "• d) 1 byte",
                quizzes.get(1).get(1)));

        questions.get(1).add(new Question("3. What is the output of this code?\nconst int x = 10;\nx = 5;",
                "• a) 5\n" +
                        "• b) 10\n" +
                        "• c) Error ✅\n" +
                        "• d) 0",
                quizzes.get(1).get(1)));

        questions.get(1).add(new Question("4. What does the unsigned keyword do?",
                "• a) Allows decimals\n" +
                        "• b) Allows negative values\n" +
                        "• c) Disallows positive values\n" +
                        "• d) Allows only positive values ✅",
                quizzes.get(1).get(1)));

        questions.get(1).add(new Question("5. Which of these is a correct declaration?",
                "• a) float number = \"3.14\";\n" +
                        "• b) char letter = A;\n" +
                        "• c) int age = 30; ✅\n" +
                        "• d) double price = '9.99';",
                quizzes.get(1).get(1)));

        questions.get(1).add(new Question("What does the % operator do?",
                "a) Multiplies two numbers\n" +
                        "b) Divides two numbers\n" +
                        "c) Returns the remainder ✅\n" +
                        "d) None of the above",
                quizzes.get(1).get(2)));

        questions.get(1).add(new Question("What is the result of 5 + 2 * 3?",
                "a) 21\n" +
                        "b) 11 ✅\n" +
                        "c) 9\n" +
                        "d) 7",
                quizzes.get(1).get(2)));

        questions.get(1).add(new Question("Which operator checks if two values are equal?",
                "a) =\n" +
                        "b) == ✅\n" +
                        "c) !=\n" +
                        "d) &&",
                quizzes.get(1).get(2)));

        questions.get(1).add(new Question("What does the && operator mean?",
                "a) OR\n" +
                        "b) AND ✅\n" +
                        "c) NOT\n" +
                        "d) Equal",
                quizzes.get(1).get(2)));

        // Unit 4: Control Structures questions
        questions.get(1).add(new Question("What does an if statement do?",
                "a) Repeats code\n" +
                        "b) Runs code if a condition is true ✅\n" +
                        "c) Declares variables\n" +
                        "d) Switches cases",
                quizzes.get(1).get(3)));

        questions.get(1).add(new Question("Which is true about switch?",
                "a) It handles user input\n" +
                        "b) It checks fixed values using cases ✅\n" +
                        "c) It uses if and else\n" +
                        "d) It ends with continue",
                quizzes.get(1).get(3)));

        questions.get(1).add(new Question("What does && mean in a condition?",
                "a) OR\n" +
                        "b) NOT\n" +
                        "c) AND ✅\n" +
                        "d) EQUAL",
                quizzes.get(1).get(3)));

        // Unit 5: Loops questions
        questions.get(1).add(new Question("When does a while loop stop?",
                "a) Never\n" +
                        "b) When the condition is false ✅\n" +
                        "c) After 5 times\n" +
                        "d) At the end of the program",
                quizzes.get(1).get(4)));

        questions.get(1).add(new Question("Which loop runs at least once?",
                "a) while\n" +
                        "b) for\n" +
                        "c) do-while ✅\n" +
                        "d) none",
                quizzes.get(1).get(4)));

        questions.get(1).add(new Question("What are the three parts of a for loop?",
                "a) Start, End, Loop\n" +
                        "b) Initialization, Condition, Update ✅\n" +
                        "c) Input, Check, Execute\n" +
                        "d) Define, Repeat, Finish",
                quizzes.get(1).get(4)));

        questions.get(1).add(new Question("What does a function do?",
                "a) Stores data\n" +
                        "b) Groups reusable code ✅\n" +
                        "c) Takes input\n" +
                        "d) Checks conditions",
                quizzes.get(1).get(5)));

        questions.get(1).add(new Question("What is the purpose of a return value?",
                "a) To send back a result ✅\n" +
                        "b) To call another function\n" +
                        "c) To break the program\n" +
                        "d) To stop a loop",
                quizzes.get(1).get(5)));

        questions.get(1).add(new Question("What type of function does not return a value?",
                "a) float\n" +
                        "b) int\n" +
                        "c) void ✅\n" +
                        "d) char",
                quizzes.get(1).get(5)));

        // Unit 7: Arrays questions
        questions.get(1).add(new Question("What is an array?",
                "a) A string\n" +
                        "b) A group of variables of the same type ✅\n" +
                        "c) A loop\n" +
                        "d) A pointer",
                quizzes.get(1).get(6)));

        questions.get(1).add(new Question("What is the index of the first element in an array?",
                "a) 1\n" +
                        "b) 0 ✅\n" +
                        "c) -1\n" +
                        "d) Depends",
                quizzes.get(1).get(6)));

        questions.get(1).add(new Question("How do you declare a 2D array?",
                "a) int a[2][3]; ✅\n" +
                        "b) int a(2,3);\n" +
                        "c) array[2,3];\n" +
                        "d) matrix[2x3];",
                quizzes.get(1).get(6)));

        // Unit 8: Strings questions
        questions.get(1).add(new Question("How are strings stored in C?",
                "a) Numbers\n" +
                        "b) Single characters\n" +
                        "c) Arrays of characters ending in '\\0' ✅\n" +
                        "d) Integers",
                quizzes.get(1).get(7)));

        questions.get(1).add(new Question("What function copies a string?",
                "a) strcat\n" +
                        "b) strcpy ✅\n" +
                        "c) strlen\n" +
                        "d) strread",
                quizzes.get(1).get(7)));

        questions.get(1).add(new Question("What does strcmp return when strings are equal?",
                "a) -1\n" +
                        "b) 1\n" +
                        "c) 0 ✅\n" +
                        "d) null",
                quizzes.get(1).get(7)));

        questions.get(1).add(new Question("What is a pointer?",
                "a) A loop\n" +
                        "b) A variable storing an address ✅\n" +
                        "c) A function\n" +
                        "d) A number",
                quizzes.get(1).get(8)));

        questions.get(1).add(new Question("What does *ptr do?",
                "a) Gets the address\n" +
                        "b) Dereferences the pointer (gets the value) ✅\n" +
                        "c) Adds two numbers\n" +
                        "d) Multiplies",
                quizzes.get(1).get(8)));

        questions.get(1).add(new Question("What symbol gets the address of a variable?",
                "a) *\n" +
                        "b) & ✅\n" +
                        "c) ^\n" +
                        "d) %",
                quizzes.get(1).get(8)));

        // Unit 10: Structures questions
        questions.get(1).add(new Question("What is a structure?",
                "a) A user-defined data type ✅\n" +
                        "b) An array\n" +
                        "c) A pointer\n" +
                        "d) A loop",
                quizzes.get(1).get(9)));

        questions.get(1).add(new Question("How do you access a structure's member?",
                "a) With the . or -> operator ✅\n" +
                        "b) Using []\n" +
                        "c) With *\n" +
                        "d) With &",
                quizzes.get(1).get(9)));

        questions.get(1).add(new Question("Which keyword defines a structure?",
                "a) struct ✅\n" +
                        "b) union\n" +
                        "c) typedef\n" +
                        "d) define",
                quizzes.get(1).get(9)));



    }
}
