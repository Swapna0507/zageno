package utilclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertiesUtil {

    public static String getValueFromThePropertiesFile(String filePath,String key) throws Exception {
        Properties prop = new Properties();
        File file= new File(filePath);
        FileInputStream fileIp = new FileInputStream(file);
        prop.load(fileIp);

        String propValue= prop.getProperty(key);
        if (Objects.nonNull(propValue) && !propValue.isEmpty()){
            return propValue;
        }else
        {
           throw new Exception(String.format("The key %s does not have corresponding value in '%s'",key,filePath));
        }


    }
}
