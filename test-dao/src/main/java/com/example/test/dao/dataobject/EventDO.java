package com.example.test.dao.dataobject;


import lombok.Data;

import java.util.Date;

@Data
public class EventDO {

    private Integer eventId;

    private String eventName;

    private String eventAddr;

    private Date eventTime;

    private String eventDes;

    private Integer userId;

    public EventDO() {
    }

    public EventDO(Integer eventId, String eventName, String eventAddr, Date eventTime, String eventDes, Integer userId) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventAddr = eventAddr;
        this.eventTime = eventTime;
        this.eventDes = eventDes;
        this.userId = userId;
    }
}
