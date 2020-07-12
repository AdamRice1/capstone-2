Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation

    Encapsulation is the practice of restricting the direct access to some of an object's components.
    This can be used to hide the values or state of a data object inside a class, preventing unauthorized access to said properties.
    Methods called getters and setters are a way in which data can be access when doing this.
    
    Example of Encapsulation:
    
    
    public class Employee {
        private BigDecimal salary = new BigDecimal(50000.00);
        
        public BigDecimal getSalary() {
            return salary;
        }
    
        public static void main() {
            Employee e = new Employee();
            BigDecimal sal = e.getSalary();
        }
    }
    
********************
2. Inheritance
    
    Inheritance is the process of basing one object or class off another object or class.
    This would be deriving sub classes from parent classes or super classes.  This forms a hierarchy of classes.
    This would mean the instance variables and methods of parent class can be used in the child class.
    To do this you need to use the "extends" keyword. 
    
    Example of Inheritance:
    
    
    class Calculation {
       int z;
    	
       public void addition(int x, int y) {
          z = x + y;
          System.out.println("The sum of the given numbers:"+z);
       }
    	
       public void Subtraction(int x, int y) {
          z = x - y;
          System.out.println("The difference between the given numbers:"+z);
       }
    }
    
    public class My_Calculation extends Calculation {
       public void multiplication(int x, int y) {
          z = x * y;
          System.out.println("The product of the given numbers:"+z);
       }
    	
       public static void main(String args[]) {
          int a = 20, b = 10;
          My_Calculation demo = new My_Calculation();
          demo.addition(a, b);
          demo.Subtraction(a, b);
          demo.multiplication(a, b);
       }
    }

    




********************
3. Abstraction

    Abstraction is a way to hide the internal implementation details for a class.  The main purpose of this
    is to hide the unnecessary details from other users.  You only show the relevant details.
    This can help reduce program complexity and effort. 
    
    Example of Abstraction:
    

    abstract class Shape 
    { 
    	String color; 
    	
    	abstract double area(); 
    	public abstract String toString(); 
    	
    	public Shape(String color) { 
    		System.out.println("Shape constructor called"); 
    		this.color = color; 
    	} 
    	
    	public String getColor() { 
    		return color; 
    	} 
    } 
    class Circle extends Shape 
    { 
    	double radius; 
    	
    	public Circle(String color,double radius) { 
    
    		super(color); 
    		System.out.println("Circle constructor called"); 
    		this.radius = radius; 
    	} 
    
    	@Override
    	double area() { 
    		return Math.PI * Math.pow(radius, 2); 
    	} 
    
    	@Override
    	public String toString() { 
    		return "Circle color is " + super.color + 
    					"and area is : " + area(); 
    	} 
    	
    } 
    class Rectangle extends Shape{ 
    
    	double length; 
    	double width; 
    	
    	public Rectangle(String color,double length,double width) { 
    		super(color); 
    		System.out.println("Rectangle constructor called"); 
    		this.length = length; 
    		this.width = width; 
    	} 
    	
    	@Override
    	double area() { 
    		return length*width; 
    	} 
    
    	@Override
    	public String toString() { 
    		return "Rectangle color is " + super.color + 
    						"and area is : " + area(); 
    	} 
    
    } 
    public class Test 
    { 
    	public static void main(String[] args) 
    	{ 
    		Shape s1 = new Circle("Red", 2.2); 
    		System.out.println(s1.toString()); 

    	} 
    } 





********************
4. Polymorphism
   
    Polymorphism is the concept that objects of different types can be accessed through the same interface.
    Java specifically supports 2 types of polymorphism.  Static and dynamic.
    Static polymorphism allows you to implement multiple methods within the same class that use the same name but a different set of parameters.
    
    Example of Static Polymorphism: 


    public class BasicCoffeeMachine {
        
        public Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException {
            switch (selection) {
            case FILTER_COFFEE:
                return brewFilterCoffee();
            default:
                throw new CoffeeException(
                    "CoffeeSelection ["+selection+"] not supported!");
            }   
        }
      
        public List brewCoffee(CoffeeSelection selection, int number) throws CoffeeException {
            List coffees = new ArrayList(number);
            for (int i=0; i<number; i++) {
                coffees.add(brewCoffee(selection));
            }
            return coffees;
        }

    }

    
 Dynamic polymorphism doesn't allow the compiler to determine the executed method. The JVM reeds to do that at runtime.
 Within an inheritance hierarchy, a subclass can override a method of its superclass. Both methods are implemented by the parent and child class and share the same name and parameters,
 but provide different functionality. 

   Example of Dynamic Polymorphism:
   

    class Vehicle{
        public void move(){
        System.out.println(“Vehicles can move!!”);
        }
    }
    
    class MotorBike extends Vehicle{
        public void move(){
        System.out.println(“MotorBike can move and accelerate too!!”);
        }
    }
    
    class Test{
        public static void main(String[] args){
        Vehicle vh=new MotorBike();
        vh.move();    // prints MotorBike can move and accelerate too!!
        vh=new Vehicle();
        vh.move();    // prints Vehicles can move!!
        }
    }

