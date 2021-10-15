// Exercise 10.8 Solution: SalariedEmployee.java
// SalariedEmployee class derived from Employee.


public class SalariedEmployee extends Employee
{
   private double weeklySalary;

   // seven-argument constructor
   public SalariedEmployee(boolean _covid19, String first, String last, String ssn,
      int month, int day, int year, int workYear, double salary )
   {
      super( _covid19, first, last, ssn, month, day, year, workYear );
      setWeeklySalary( salary );
   } // end seven-argument SalariedEmployee constructor

   // set salary
   public void setWeeklySalary( double salary )
   {
      weeklySalary = salary < 0.0 ? 0.0 : salary;
   } // end method setWeeklySalary

   // return salary
   public double getWeeklySalary()
   {
      return weeklySalary;
   } // end method getWeeklySalary

   // calculate earnings; override abstract method earnings in Employee
   @Override
   public double earnings()
   {
      return getWeeklySalary();
   } // end method earnings

   // return String representation of SalariedEmployee object
   @Override
   public String toString()
   {
      return String.format( "salaried employee: %s\n%s: $%,.2f", 
         super.toString(), "weekly salary", getWeeklySalary() );
   } // end method toString   
} // end class SalariedEmployee

