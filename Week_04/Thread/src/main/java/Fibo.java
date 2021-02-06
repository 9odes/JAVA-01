/**
 * @author dongfangxu
 * @date 2021/2/1 15:40
 * @description
 */
public  class Fibo {

    static int fibo(int a) {
        if ( a < 2){
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
}
