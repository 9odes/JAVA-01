import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) throws Exception {
        HelloClassLoader helloClassLoader=new HelloClassLoader();
        Class<?> cls=helloClassLoader.loadData("Hello");
        Method method=cls.getDeclaredMethod("hello");
        method.invoke(cls.newInstance());
    }


    public Class<?> loadData (String className) throws Exception {
        byte[] bytes=this.loadFileData();
        if(bytes!=null){
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(className,bytes,0,bytes.length);
        }
        return null;
    }

    private byte[] loadFileData() throws Exception{
        InputStream input=null;
        ByteArrayOutputStream bos=null;
        byte[] data =null;
        try{
            bos =new ByteArrayOutputStream();
            input=new FileInputStream(new File("Hello.xlass"));
            int i;
            while ((i= input.read())!=-1){
                bos.write(i);
            }
            data=bos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(input!=null){
                input.close();
            }
            if(bos!=null){
                bos.close();
            }
        }
        return data;
    }
}
