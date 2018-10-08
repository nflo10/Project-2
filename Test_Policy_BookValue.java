/*
 *  This is a test harness for the Policy hierarchy, Annuity, and the BookValue interface.
 * 
 *  This process begin by building an array of objects that implement the BookValue interface.
 *    These include HomeOwners, Auto, and Annuity objects. Objects will be instantiated directly
 *    into an array.
 * 
 *  The array will be processed three times - each loop executing a specific function.
 *     1. Output the toString return for each object.
 *     2. Output (and accumulate) the current financial exposure for each object.
 *        Output the accumulated exposure for all objects.
 *     3. Output (and accumulate) the current cash or book value for each object.
 *        Output the accumulated cash value for all objects.
 * 
 * (c) 2018, Terri Davis
 */ 
public class Test_Policy_BookValue
{
  /*
   *  Global scoping for variables/data structures is STRONGLY DISCOURAGED, but here it makes
   *   our lives (and code) simpler, so we'll allow it.
   *  COMPLETE THE FOLLOWING ARRAY DECLARATION
   */
  private static BookValue[] bookValues = new BookValue[6];
  
  /*
   *  The main method will only 'direct traffic' from this point forward. 
   *  This main calls one method to build/load the array and a second method to process it.
   */
  public static void main( String[] args )
  {
    buildArray( );
    reviewArray( );
  } // end main
  
  /*
   *  The buildArray method instantiates 6 objects and stores them in the globally declared array.
   */
  private static void buildArray( )
  {
    // First, we're going to set up int arrays for our Auto limits...
    //  This is a simpler method than trying to instantiate the arrays in the contructor calls...
    int[] std   = {50,50,100};
    int[] hiVal = {100,100,250};
    
    // Add HomeOwner objects to the array
    bookValues[0] = new HomeOwners( "Ted Arroway",
                                    "Ted Arroway", 
                                    "HO658542",
                                     2563.58,
                                     "Lacy Lane, BLK 5, LOT 8",
                                     1,
                                     200,
                                     25,
                                     0.015,
                                     false );

    bookValues[1] = new HomeOwners( "Drumlin, LLC",
                                    "David Drumlin",
                                    "HO963214",
                                     5980.73,
                                    "Silicon Heights, BLK1 , Lot 1",
                                     4,
                                     1200,
                                     250,
                                     0.03,
                                     true );
    
    // Add Auto objects to the array
    bookValues[2] = new Auto(  "Eleanor Arroway",
                               "Eleanor Arroway",
                               "AU002584",
                                1503.27,
                               "Jeep Wrangler",
                                1998,
                               "CHRJ99W541230",
                                std,
                                500 );
    
    bookValues[3] = new Auto( "Palmer Joss",
                              "Palmer Joss",
                              "AU456852",
                               3103.79,
                              "BMW X3",
                               2016,
                              "BWMX163415872",
                               hiVal,
                               1000 );

    // Add Annuity objects to the array
    bookValues[4] = new Annuity( "Ted Arroway",
                                 "Eleanor Arroway",
                                 "5482361597",
                                  100000,
                                  83462.47 );
    bookValues[5] = new Annuity( "S. R. Hadden",
                                 "SETI",
                                 "8543269716",
                                 2500000,
                                 1803957.41 );
    
  } // end buildArray
  
  /*
   *  The reviewArray method will call three other methods. Each called method executes a 
   *    specific function across each object in the array.
   */
  private static void reviewArray( )
  {
    printToStrings( );
    calculateExposures( );
    calculateCurrValues( );
    
  } // end reviewArray
  
  /*
   *  The printToStrings method will use an enhanced for loop to retrieve and output the toString
   *     return for each object in the array. 
   */
  private static void printToStrings( )
  { 
    System.out.printf( "%n%nList of Policy Objects in Array bookValues%n%n" );
    
    // Add the control statement for the ENHANCED FOR LOOP here
    for( BookValue oneContract: bookValues )
    {
      System.out.printf( "%s%n",
                         oneContract.toString( ) );
    } // end for loop
    
  } // end printToStrings
  
   /*
   *  The calculateExposures method will use an enhanced for loop to retrieve and output the calculateExposure
   *     return for each object in the array. 
   *  An accumulator (totalExposure) is declared, and each object's calculateExposure value is added to the
   *     accumulator within the loop.
   *  When the loop completes, the total accumulated exposure value is output.
   */
  private static void calculateExposures( )
  {
    System.out.printf( "%n%n%n\tContract Exposures%n%n" );
    
    // declare and initialize an accumulator 
    double totalExposure = 0.0;
    
    // Add the control statement for the ENHANCED FOR LOOP here
    for( BookValue oneContract: bookValues )
    {
      // retrieve the exposure value
      double currExposure = oneContract.calcExposure( );
      // output a report line including the exposure value
      System.out.printf( "Contract %-10s       $%,13.2f%n",
                         oneContract.identifyContract( ),
                         currExposure );
      // accumulate exposure values
      totalExposure = totalExposure + currExposure;
    } // end for loop   
    
    // Output total accumulated exposure 
    System.out.printf( "%n\t\tTotal Exposure is $%,.2f%n%n",
                       totalExposure );
    
  } // end calculateExposures
  
  
  /*
   *  The calculateCurrValues method will use an enhanced for loop to retrieve and output the calcCurrentValue
   *     return for each object in the array. 
   *  An accumulator (totalBook) is declared, and each object's calcCurrentValue value is added to the
   *     accumulator within the loop.
   *  When the loop completes, the total accumulated book value value is output.
   */
  private static void calculateCurrValues( )
  {
    System.out.printf( "%n%n%n\tContract Book Values%n%n" );
    
    double totalBook = 0.0;
    
    // Add the control statement for the ENHANCED FOR LOOP here
    for( BookValue oneContract: bookValues )
    {
      // retrieve the exposure value
      double currBook = oneContract.calcCurrentValue( );
      System.out.printf( "Contract %-10s       $%,13.2f%n",
                         oneContract.identifyContract( ),
                         currBook );
      // accumulate book values
      totalBook = totalBook + currBook;
    } // end for loop   
    
    // Output total accumulated book value 
    System.out.printf( "%n\t\tTotal Book Value is $%,.2f%n%n",
                       totalBook );    
  } 
  
} // end Test_Policy_BookValue