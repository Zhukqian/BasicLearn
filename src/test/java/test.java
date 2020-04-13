/**
 * @ClassName test
 * @Description TODO
 * @Author zhukq
 * @Date 2020/4/10 9:03
 * @Version 1.0
 */
public class test {

    public static void main(String[] args) {
        String efftimeString = "-4";
        String startEffString ;
        String endEffString ;
        if(efftimeString.startsWith("-")){
            startEffString = efftimeString.substring(1);
            endEffString = String.valueOf(Integer.valueOf(efftimeString.substring(1))+1);
        }else{
            startEffString = "-"+(Integer.valueOf(efftimeString)+1);
            endEffString = "-"+efftimeString;
        }
        System.out.println("startEffString==="+startEffString+";        endEffString==="+endEffString);
    }


}
