package com.example.test.api;

import com.example.test.api.result.ResultDO;
import com.example.test.dao.dataobject.EventDO;

import java.util.List;

public interface EventService {

    ResultDO getAllEvents();

    ResultDO getEventsByTime();

    ResultDO searchEventByName(String name);

    ResultDO getEventByUserId(Integer userId);

    ResultDO getEventByEventId(Integer eventId);

    ResultDO insert(EventDO eventDO);

    ResultDO delete(Integer eventId, Integer userId);

    ResultDO update(EventDO eventDO);
}
