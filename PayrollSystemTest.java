// Exercise 10.8 Solution: PayrollSystemTest.java
// Employee hierarchy test program.

import java.util.Scanner; // program uses Scanner to obtain user input

public class PayrollSystemTest 
{
   public static void main( String[] args ) 
   {
      /////////////////////////////////////////////////////////////////////////////////
      // Crate ADTBag
      ADTBag<Employee> employeeADTBag = new ADTBag<>(3);


      /////////////////////////////////////////////////////////////////////////////////
      // Create Employee
      PieceWork pieceWorker1 =
              new PieceWork(false, "1kims","hog","123-456",1,22,1966,10,4,500);
      PieceWork pieceWorker2 =
              new PieceWork(false,"2park","jinho","123-456",1,22,1956,5,4,500);
      BasePlusPieceWork basePlusPieceWorker1 =
              new BasePlusPieceWork(true,"3Choi","Jinsu","321-556",3,12,1952,10,5,100,500);


      /////////////////////////////////////////////////////////////////////////////////
      // Print worker's data
      System.out.printf( "%s\n%s: $%,.2f\n\n",
              pieceWorker1,
              "earned", pieceWorker1.earnings());
      System.out.printf( "%s\n%s: $%,.2f\n\n",
              pieceWorker2,
              "earned", pieceWorker2.earnings());
      System.out.printf( "%s\n%s: $%,.2f\n\n",
              basePlusPieceWorker1,
              "earned", basePlusPieceWorker1.earnings());


      /////////////////////////////////////////////////////////////////////////////////
      // Set Covid Confirm Data
      pieceWorker1.SetConFirmCovid(false,1,1,2022);
      pieceWorker2.SetConFirmCovid(false,2,2,2022);
      basePlusPieceWorker1.SetConFirmCovid(true,4,10,2022);


      /////////////////////////////////////////////////////////////////////////////////
      // Add Employee data to employeeADTBag
      employeeADTBag.add(pieceWorker1);
      employeeADTBag.add(pieceWorker2);
      employeeADTBag.add(basePlusPieceWorker1);


      /////////////////////////////////////////////////////////////////////////////////
      // Set new Employee Array
      Object[] employees = employeeADTBag.toArray();
      Employee[] employeesArr = new Employee[employees.length];

      /*
      ////// Class Cast Exception Error!!
      ////// Employee[] testArr = (Employee[]) employees;
      */

      for(int i = 0 ; i < employeeADTBag.getCurrentSize() ; i++)
      {
         employeesArr[i] = (Employee) employees[i];
      }

      int conFirmCount = 0;

      for(int i = 0 ; i < employeeADTBag.getCurrentSize() ; i++)
      {
         System.out.println(employeesArr[i].getCovidConfirmData());

         if(employeesArr[i].getCovidConfirmData()) conFirmCount++;
      }

      // Print result
      System.out.printf("Covid Employee counts : " + conFirmCount);










//
//
//      /////////////////////////////////////////////////////////////////////////////////
//
//      Scanner input = new Scanner( System.in ); // to get current month
//      int currentMonth;
//
//      // get and validate current month
//      do
//      {
//         System.out.print( "Enter the current month (1 - 12): " );
//         currentMonth = input.nextInt();
//         System.out.println();
//      } while ( ( currentMonth < 1 ) || ( currentMonth > 12 ) );
//
//      System.out.println( "Employees processed polymorphically:\n" );
//
//      // generically process each element in array employees
//      for ( Employee currentEmployee : employees )
//      {
//         System.out.println( currentEmployee ); // invokes toString
//
//         // determine whether element is a BasePlusCommissionEmployee
//         if ( currentEmployee instanceof BasePlusCommissionEmployee )
//         {
//            // downcast Employee reference to
//            // BasePlusCommissionEmployee reference
//            BasePlusCommissionEmployee employee =
//               ( BasePlusCommissionEmployee ) currentEmployee;
//
//            double oldBaseSalary = employee.getBaseSalary();
//            employee.setBaseSalary( 1.10 * oldBaseSalary );
//            System.out.printf(
//               "new base salary with 10%% increase is: $%,.2f\n",
//               employee.getBaseSalary() );
//         } // end if
//
//         // if month of employee's birthday, add $100 to salary
//         if ( currentMonth == currentEmployee.getBirthDate().getMonth() )
//            System.out.printf(
//               "earned $%,.2f %s", currentEmployee.earnings(),
//               "plus $100.00 birthday bonus" );
//         else
//            System.out.printf(
//               "earned $%,.2f ", currentEmployee.earnings() );
//
//
//
//         if( currentEmployee.work_10_years(currentEmployee.getWorkYear()) )
//         {
//            double bonus = currentEmployee.earnings() * 0.10;
//
//            System.out.printf("and add 10 years bonus $%,.2f \n\n", bonus);
//         }
//         else
//         {
//            System.out.printf("\n\n");
//         }
//
//
//      } // end for
//
//      // get type name of each object in employees array
//      for ( int j = 0; j < employees.length; j++ )
//         System.out.printf( "Employee %d is a %s\n", j,
//            employees[ j ].getClass().getName() );
   } // end main
} // end class PayrollSystemTest


