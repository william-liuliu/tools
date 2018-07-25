package com.ict.toolsweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Auther: william
 * @Date: 7/25/18 06:54
 * @Description:this is used to receive IoT Edge enterprise engine's RESTFULE message
 */

@Controller
@RequestMapping("/event")
public class RestEnterpriseEngineReceiveController {

    @RequestMapping(value="/enterprise/original.do",method= RequestMethod.POST)
    @ResponseBody
    public String standardEnterpriseReceiver(@RequestBody String param){
        System.out.println(param);
        JSONObject jo=new JSONObject();


        //如果页面传的是json字符串，用下列方式解析
//		Map<String, Object> m=(Map<String, Object> )jo.parse(param); //string转map
//		System.out.println(m);//
//		JSONObject parseObject = jo.parseObject(param); //string转json
//		System.out.println(parseObject);

        //如果页面传的是json数组字符串，用下列方式解析
        List<Map> parseArray = jo.parseArray(param, Map.class);
        System.out.println(parseArray); //string转list

        JSONArray parseArray2 = jo.parseArray(param);
        System.out.println(parseArray2);
        return "ok";
    }

}
