// Exercise 10.8 Solution: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class derived from CommissionEmployee.

public class BasePlusCommissionEmployee extends CommissionEmployee 
{
   private double baseSalary; // base salary per week

   // nine-argument constructor
   public BasePlusCommissionEmployee(boolean _covid19 ,String first, String last,
      String ssn, int month, int day, int year, int workYear,
      double sales, double rate, double salary )
   {
      super( _covid19, first, last, ssn, month, day, year, workYear, sales, rate );
      setBaseSalary( salary );
   } // end nine-argument BasePlusCommissionEmployee constructor

   // set base salary
   public void setBaseSalary( double salary )
   {
      baseSalary = salary < 0.0 ? 0.0 : salary; // non-negative
   } // end method setBaseSalary

   // return base salary
   public double getBaseSalary()
   {
      return baseSalary;
   } // end method getBaseSalary

   // calculate earnings; override method earnings in CommissionEmployee
   @Override
   public double earnings()
   {
      return getBaseSalary() + super.earnings();
   } // end method earnings

   // return String representation of BasePlusCommissionEmployee object
   @Override
   public String toString()
   {
      return String.format( "%s %s; %s: $%,.2f", 
         "base-salaried", super.toString(), 
         "base salary", getBaseSalary() );
      } // end method toString
} // end class BasePlusCommissionEmployee

