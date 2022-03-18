package extra;

public class Demo {
    public static void main(String[] args) {
       /*primitive Type
            boolean,char,byte,short,int,long,float,double
        * Wrapper Class
            Boolean,Character,Byte,Short,Integer,Long,Float,Double
        * */

        // (Boxing vs AutoBoxing)
        // Boxing
        int x=10;
        Integer i=Integer.valueOf(x);
        // AutoBoxing
        int y=20;
        Integer z=y;// compiler will write Integer.valueOf(y)
        //-------------------------------------------------------------

        // (Un-Boxing vs Auto Un-Boxing
        //Un-Boxing
        Integer abc= new Integer(10);
        int ii= abc.intValue();
        //Auto Un-Boxing
        int yy=ii;// compiler call abc.intValue();



    }
}
