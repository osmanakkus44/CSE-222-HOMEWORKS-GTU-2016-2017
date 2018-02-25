
import java.util.NavigableMap;


public class Main
{
    public static void main(String args[]){
        final Boolean q1 = Q1Test();
        final Boolean q2 = Q2Test();
        if (q1 == q2 == Boolean.TRUE) {
            System.out.println("Your tests is done. Make sure that you test all methods of class!! " );
            return;
        }
    }
    public static Boolean Q1Test(){

        NavigableMap<String,String> turkey = new BinaryNavMap<String,String>();
        turkey.put("uskudar","istanbul");
        turkey.put("kadıkoy","istanbul");
        turkey.put("cekirge","bursa");
        turkey.put("gebze","kocaeli");
        turkey.put("niksar","tokat");
        turkey.put("kecıoren","ankara");
        turkey.put("aksaray","istanbul");
        turkey.put("foca","izmir");
        turkey.put("manavgat","antalya");
        turkey.put("kahta","adıyaman");
        turkey.put("biga","canakkale");

        System.out.println("TESTING THE Q1\n");

        System.out.println("->The original set odds is " + turkey);
        NavigableMap<String,String> m = turkey.subMap("uskudar",true,"gebze",false);
        System.out.println("->The ordered set m is " + m);
        System.out.println("->The first entry is " + turkey.firstEntry());
        System.out.println("->The first key is: " + turkey.firstKey());
        System.out.println("->The last key is: " + turkey.lastKey() + "\n");
        System.out.println("->The ceilingKey is: " + turkey.ceilingKey("kahta"));
        System.out.println("->The ceilingEntry is: " + turkey.ceilingEntry("foca"));
        System.out.println("->The floorKey is: " + turkey.floorKey("kahta"));
        System.out.println("->The floorEntry is:" + turkey.floorEntry("foca"));
        System.out.println("->The higherKey is: " + turkey.higherKey("kahta"));
        System.out.println("->The higherEntry is: " + turkey.higherEntry("foca"));
        /*Test ederken her zaman aynı isimde keyleri kullandım ki fark görülsün(foca, kahta vs.)*/

        return Boolean.TRUE;

    }
    public static Boolean Q2Test(){
        HashTableChaining<String,String> turkey = new HashTableChaining<>();
        turkey.put("edremit","balikesir");
        turkey.put("edremit","van");
        turkey.put("kemalpasa","bursa");
        turkey.put("kemalpasa","izmir");
        turkey.put("ortakoy","istanbul");//we assume a district
        turkey.put("ortakoy","aksaray");
        turkey.put("ortakoy","corum");
        turkey.put("kecıoren","ankara");
        turkey.put("pinarbasi","kastamonu");
        turkey.put("pinarbasi","kayseri");
        turkey.put("eregli","konya");
        turkey.put("eregli","tekirdag");
        turkey.put("eregli","zonguldak");
        turkey.put("golbasi","adıyaman");
        turkey.put("golbasi","ankara");
        turkey.put("kale","malatya");


        System.out.println("TESTING THE Q2:\n");

        System.out.println("->Testing the other methods ");

        //Farklı key sayısı kadar size tutar.
        System.out.println("size : " + turkey.size());

        System.out.println("->Testing the get method: ");
        //Hocam burada moodle da bahsedilen sorun var aslında adıyamanı da golbası için
        //tutuyor ama get sadece bir tane return edebildiği için ilk aldığını return ediyo :)
        System.out.println("get golbası : " + turkey.get("golbasi"));

        //burada district e baglı tüm iller silinir.En başta ödev böyle verildiği için böyle yaptım
        //aslında ödevde iller key olsa daha iyi olacağını sonradan farkettim.
        System.out.println("remove ortakoy: " + turkey.remove("ortakoy"));

        //Farklı key sayısı kadar size tutar.
        System.out.println("size : " + turkey.size());

        //Is empty yi test etmeye gerek var mıydı bilmiyorum ama
        System.out.println("is Empty " + turkey.isEmpty());

        return Boolean.TRUE;
    }


}
