package com.mqhstudio.qa.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDataReader {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File("src/test/resources/testdata/login_credentials.json");
        List<LoginData> dataList = mapper.readValue(jsonFile, new TypeReference<List<LoginData>>() {});
        Object[][] data = new Object[dataList.size()][1];
        for(int i=0; i<dataList.size();i++){
            data[i][0] = dataList.get(i);
        }
        return data;
    }
}
