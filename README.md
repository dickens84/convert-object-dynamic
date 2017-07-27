# Convert Object Dynamic
    Reflection to retrieve declared fields of each object:
# Recommended Use
    ClazzDynamic clazzDynamic = new ClazzDynamic();
       
        * obj1 is class object
        * obj2 is class object
        * obj3 is HashMap object (HashMap<String,String>())
        
    1. Method :: clazzDynamic.convert(obj1, obj2);
          * Convert obj1 to obj2 on the basis of field name.
          
    2. Method :: clazzDynamic.convert(obj1, obj2, obj3) 
          * Convert obj1 to obj2 on the basis of field name. 
          * obj3 is manual assigning field name.
                [ key is obj1 field name , value is obj2 field name ] 
# Dependency
    <dependency>
      <groupId>com.dickens.core</groupId>
      <artifactId>convert-object-dynamic</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
   
