/*
 * This code describes a HomeOwners object.
 * the HomeOwners class is a SUBCLASS of Policy.
 * Policy is the SUPERCLASS of HomeOwners.
 * This is what a heirachy looks like:
 * 
 *          Policy (SUPERCLASS)
 *                  HomeOwners(SUBLCASS)
 */

public class HomeOwners extends Policy 
{
  private double exposureRate = .0025;
  private String propAddress;
  private int propType;
  private int structure;
  private int contents;
  private double deduct;
  private boolean umbrella;
  
  /*
   * CONSTUCTORS
   */
  
  
  public HomeOwners() 
  {
    super();
  }
  
  public HomeOwners(String own,    //owed to SUPERCLASS
                    String insd,   //owed to SUPERCLASS
                    String nbr,    //owed to SUPERCLASS
                    double prem,   //owed to SUPERCLASS
                    String addr,   //SUBCLASS variable
                    int type,      //SUBCLASS variable
                    int struct,    //SUBCLASS variable
                    int goods,     //SUBCLASS variable
                    double ded,    //SUBCLASS variable
                    boolean umbr)  //SUBCLASS variable
  {
    // THE FIRST EXECUTABLE STATEMENT HERE MUST BE A CALL TO 
    // THE SUPERCLASS CONSTRUCTOR
    super(own,    //owed to SUPERCLASS
          insd,   //owed to SUPERCLASS
          nbr,    //owed to SUPERCLASS
          prem);  //owed to SUPERCLASS
    setPropAddress(addr);
    setPropType(type);
    setStructure(struct);
    setContents(goods);
    setDeduct(ded);
    setUmbrella(umbr);
  }//END Full Constructor
  
  public final void setExposureRate() 
  {
    exposureRate = 0.0025;
  }//end setExposureRate
  
  public final void setPropAddress(String addr) 
  {
    propAddress = addr;
  }//end setPropAddress
  
  public final void setPropType(int type) 
  {
    propType = type;
  }//end setPropType
  
  public final void setStructure(int struct) 
  {
    structure = struct;
  }//end setStructure
  
  public final void setContents(int goods) 
  {
    contents = goods;
  }//end setContents
  
  public final void setDeduct(double ded)
  {
    deduct = ded;
  }//end setDedcut
  
  public final void setUmbrella(boolean umbr) 
  {
    umbrella = umbr;
  }//end setUmbrella
  
  /*
   * GET METHODS
   */
  
public double getExposureRate() 
  {
    return exposureRate;
  }//end getExposureRate
  
  public final String getPropAddress()
  {
    return propAddress;
  }//end getPropAddress
  
  public final int getPropType() 
  {
    return propType;
  }//end getPropType
  
  public final int getStructure()
  {
    return structure;
  }//end getStructure
  
  public final int getContents()
  {
    return contents;
  }//end getContents
  
  public final double getDeduct()
  {
    return deduct;
  }//end getDeduct
  
  public final boolean getUmbrella()
  {
    return umbrella;
  }//end getUmbrella
  
  
  public double getDeductInDollars( )
  {
    return ( structure + contents )*1000 * deduct;
  }//end getDeductInDollars
  
  public double calcExposure( )
  {
    return (getStructure() + getContents())*1000;
  } //end calculateExposure
  
    public double calcCurrentValue()
  {
    return getPolPrem()-(calcExposure()*exposureRate);
  }//end calcCurrentValue
  
  
  public String toString( )
  {
    // if else to test boolean condition that produces string "is not" if false or "is" if else
    String isIsNot;
    if( getUmbrella( ) )
      isIsNot = ("is" );
    
    else
      isIsNot = ( "is not" );
    
    
    return String.format( "%sThis %s policy insures a type %d home at %s. The structure is " +
                         "insured for $%,d.00; contents for $%,d.00. The deductible is $%,.2f. This policy %s part of an Umbrella Contract. %n",
                         super.toString( ),
                         getClass().getName(),
                         getPropType( ),
                         getPropAddress( ),
                         getStructure( )*1000,
                         getContents( )*1000,
                         getDeductInDollars( ),
                         isIsNot);
  }//end toString
}//end HomeOwners extends Policy 