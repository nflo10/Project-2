public class Auto extends Policy{
  
  private double exposureRate =0.0051;   // current exposure rate for Auto policies is 0.00051. Constant value set directly in the set method. No data will be passed into constructor.  
  private String makeModel;                // make and model of auto
  private int modelYear;                    // model year of auto 
  private String vin;                            // vehicle identification number
  private int[] limits=new int[3];                  //array for int values representing coverage limits (in thousands of dollars) 
  private int deduct;                     // policy deductible stated in dollars
  
  /*
   * CONSTRUCTORS
   */
  public Auto() {
  }
  
  public Auto ( String own,           // owed to SUPERCLASS
               String insd,                        // owed to SUPERCLASS
               String nbr,                          // owed to SUPERCLASS
               double prem,                       // owed to SUPERCLASS
               String model,                       // owed to SUBCLASS
               int year,                                  // owed to SUBCLASS
               String id,                                // owed to SUBCLASS
               int[ ] lims,                              // owed to SUBCLASS
               int ded)                                  // owed to SUBCLASS
  { 
    super(own,                                    // owed to SUPERCLASS
          insd,                                           // owed to SUPERCLASS
          nbr,                                             // owed to SUPERCLASS
          prem);                                        // owed to SUPERCLASS
    setMakeModel( model );                         // owed to SUBRCLASS         
    setModelYear( year );                           // owed to SUBRCLASS
    setVin( id );                                   // owed to SUBRCLASS
    setLimits( lims );                                // owed to SUBRCLASS
    setDeduct( ded );                                     // owed to SUBRCLASS
  } // end full constructor Auto 
  
  
  
  /*
   * SET METHODS
   */
  
  
  public final void setExposureRate( )
  { 
    exposureRate = 0.0051;
  } // end setExposureRate
  
  public final void setMakeModel(String model) 
  {
    makeModel = model;
  }  // end setMakeModel
  
  public final void setModelYear(int year) 
  {
    modelYear = year;
  } // end setModelYear
  
  public final void setVin(String id) 
  {
    vin = id;
  } // end setVin
  
  public final void setLimits(int[] lims)
  {
    limits = lims;
  } // end setLimits
  
  public final void setDeduct(int ded) 
  {
    deduct = ded;
  } // end setDeduct
  
  /*
   * GET METHODS
   */
  
  public final double getExposureRate()
  {
    return exposureRate;
  }  // end getExposureRate
  
  public final String getMakeModel()
  {
    return makeModel;
  } // end getMakeModel
  
  
  
  public final int getModelYear() 
  {
    return modelYear;
  } // end getModelYear
  
  
  public String getVin()
  {
    return vin;
  } // end getVin
  
  
  public final int[] getLimits()
  {
    return limits;
  } // end getLimits
  
  public final int getDeduct() {
    return deduct;
  } // end getDeduct
  
  /*
   * OTHER METHODS AS NEEDED
   */
  
  
  public String produceLimitsTxt()
  {
    return String.format( "of Collision: $%,.2f, Comprehensive: $%,.2f, UIM: $%,.2f ",
                         ( double )( 1000*limits[0] ),
                         ( double )( 1000*limits[1] ),
                         ( double )( 1000*limits[2] ) );
  } // end produceLimitsTxt
  
  public double calcExposure()
  {
    {
      double amount = 0;
      int[] total = getLimits( );
      
      for( int camaro : total )
      {
        amount += camaro*1000;
      }  // end enhanced for loop
      return amount;
    } // end calcExposure
  }
  
  public double calcCurrentValue()
  {
    return getPolPrem()-(calcExposure()*getExposureRate());
  } // end calcCurrentValue
  
  public String toString() {
    return String.format( "%sThis %s policy insures a %d %s, VIN %s with limits %s and a deductible of $%,d.00.\n", 
                         super.toString(), 
                         getClass().getName(),
                         getModelYear(),
                         getMakeModel(),
                         getVin(),
                         produceLimitsTxt(),
                         getDeduct());
  }  //end toString
  
} // end class Auto extends Policy