// 
// 
// 

package com.esms.controller;

import com.esms.po.KeyValue;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.impl.KeyValueServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class KeyValueController
{
    @Autowired
    private KeyValueServiceImpl keyValueService;
    
    public KeyValueController() {
        this.keyValueService = null;
    }
    
    @RequestMapping({ "/getKeyValueById.do" })
    @ResponseBody
    public String getKeyValueById(final Model model, final Integer id_id) throws Exception {
        return "error.jsp";
    }
    
    @RequestMapping({ "/changeWageItem.do" })
    @ResponseBody
    public int changeWageItem(final double late_buckle_pay, final double early_buckle_pay, final double missionallowance, final double full_attendance_pay, final double food_pay, final double traffic_pay) throws Exception {
        int count = 0;
        final KeyValue kv1 = new KeyValue();
        kv1.setKvKey("food_pay");
        kv1.setKvId(1);
        kv1.setKvValue(food_pay);
        count += this.keyValueService.updateByPrimaryKey(kv1);
        final KeyValue kv2 = new KeyValue();
        kv2.setKvId(2);
        kv2.setKvKey("traffic_pay");
        kv2.setKvValue(traffic_pay);
        count += this.keyValueService.updateByPrimaryKey(kv2);
        final KeyValue kv3 = new KeyValue();
        kv3.setKvId(3);
        kv3.setKvKey("late_buckle_pay");
        kv3.setKvValue(late_buckle_pay);
        count += this.keyValueService.updateByPrimaryKey(kv3);
        final KeyValue kv4 = new KeyValue();
        kv4.setKvId(4);
        kv4.setKvKey("early_buckle_pay");
        kv4.setKvValue(early_buckle_pay);
        count += this.keyValueService.updateByPrimaryKey(kv4);
        final KeyValue kv5 = new KeyValue();
        kv5.setKvId(5);
        kv5.setKvKey("missionallowance");
        kv5.setKvValue(missionallowance);
        count += this.keyValueService.updateByPrimaryKey(kv5);
        final KeyValue kv6 = new KeyValue();
        kv6.setKvId(6);
        kv6.setKvKey("full_attendance_pay");
        kv6.setKvValue(full_attendance_pay);
        count += this.keyValueService.updateByPrimaryKey(kv6);
        return count;
    }
    
    @RequestMapping({ "/get_late_buckle_pay.do" })
    @ResponseBody
    public KeyValue get_late_buckle_pay() {
        KeyValue keyValue = new KeyValue();
        try {
            keyValue = this.keyValueService.selectBykvKey("late_buckle_pay");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }
    
    @RequestMapping({ "/get_food_pay.do" })
    @ResponseBody
    public KeyValue get_food_pay() {
        KeyValue keyValue = new KeyValue();
        try {
            keyValue = this.keyValueService.selectBykvKey("food_pay");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }
    
    @RequestMapping({ "/get_traffic_pay.do" })
    @ResponseBody
    public KeyValue get_traffic_pay() {
        KeyValue keyValue = new KeyValue();
        try {
            keyValue = this.keyValueService.selectBykvKey("traffic_pay");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }
    
    @RequestMapping({ "/get_early_buckle_pay.do" })
    @ResponseBody
    public KeyValue get_early_buckle_pay() {
        KeyValue keyValue = new KeyValue();
        try {
            keyValue = this.keyValueService.selectBykvKey("early_buckle_pay");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }
    
    @RequestMapping({ "/get_missionallowance.do" })
    @ResponseBody
    public KeyValue get_missionallowance() {
        KeyValue keyValue = new KeyValue();
        try {
            keyValue = this.keyValueService.selectBykvKey("missionallowance");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }
    
    @RequestMapping({ "/get_full_attendance_pay.do" })
    @ResponseBody
    public KeyValue get_full_attendance_pay() {
        KeyValue keyValue = new KeyValue();
        try {
            keyValue = this.keyValueService.selectBykvKey("full_attendance_pay");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }
}
