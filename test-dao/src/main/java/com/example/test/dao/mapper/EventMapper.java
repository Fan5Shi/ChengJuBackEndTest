package com.example.test.dao.mapper;

import com.example.test.dao.dataobject.EventDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventMapper {

    List<EventDO> getAllEvents();

    List<EventDO> getEventsByTime();

    List<EventDO> searchEventByName(String name);

    List<EventDO> getEventByUserId(Integer userId);

    EventDO getEventByEventId(Integer eventId);

    int insertEvent(EventDO eventDO);

    int deleteEvent(Integer eventId, Integer userId);

    int updateEvent(EventDO eventDO);


}
